package com.jerry.financecrawler.translate.licai;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.HtmlParserUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.FundProductVo;
import com.jerry.financecrawler.vo.HistoricalNetVo;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jerry on 2015/9/18.
 */
@Component
public class HtmlToLiCaiHistoricalNetVo {

    public List<HistoricalNetVo> parseToHistoricalNetData(String html, int product_id, String product_code) throws Exception {
        //System.out.println("html = [" + html + "]");
        List<HistoricalNetVo> resultList = null;
        NodeList div = HtmlParserUtil.filterTargetNode(html, CommonsCharset.GB2312, "class", "tab_zst r m");
        if (div != null && div.size() > 0) {
            NodeList tables = HtmlParserUtil.filterNode(div.elementAt(0), "table");
            if (tables != null && tables.size() > 1 && tables.elementAt(1) != null ) {
                resultList = new ArrayList<HistoricalNetVo>();
                NodeList trs = HtmlParserUtil.filterNode(tables.elementAt(1), "tr");
                if (trs != null && trs.size() > 0) {
                    for (int i = 0; i < trs.size(); i++) {
                        NodeList tds = HtmlParserUtil.filterNode(trs.elementAt(i), "td");
                        if (tds != null && tds.size() > 0) {
                            HistoricalNetVo midVo = new HistoricalNetVo();
                            midVo.setProduct_id(product_id);
                            midVo.setProduct_code(product_code);
                            for (int j = 0; j < tds.size(); j++) {
                                String fVal = HtmlParserUtil.getPlainTextString(tds.elementAt(j));
                                //System.out.println("fVal = [" + fVal + "]" +"j = [" + j + "]"  );
                                //赋值
                                switch (j) {
                                    case 0:
                                        if (!StringUtil.isEmpty(fVal)) {
                                            fVal = fVal.replace(".", "-");
                                            midVo.setNet_worth_date(fVal);
                                        }
                                        break;//净值时间
                                    case 1:
                                        midVo.setUnit_net_worth(StringUtil.StringToDouble(fVal));
                                        break;//单位净值
                                    case 2: //midVo.setAdd_net_worth(StringUtil.StringToDouble(fVal));break;//复权净值
                                    case 3:
                                        midVo.setChg(StringUtil.StringToDouble(fVal));
                                        break;//增长率
                                }
                            }
                            if (midVo != null) resultList.add(midVo);
                        }//tds
                    }
                }// trs
            }//table
        }//div
        return resultList;
    }
}
