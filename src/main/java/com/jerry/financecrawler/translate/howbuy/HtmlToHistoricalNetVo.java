package com.jerry.financecrawler.translate.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.HtmlParserUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.HistoricalNetVo;
import org.htmlparser.util.NodeList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2015/9/18.
 */
@Component
public class HtmlToHistoricalNetVo {

    public List<HistoricalNetVo> parseToHistoricalNetData(String html, int product_id, String product_code) throws Exception{
        //System.out.println("html = [" + html + "]");
        List<HistoricalNetVo> resultList = null;
        NodeList div = HtmlParserUtil.filterTargetNode(html, CommonsCharset.UTF_8, "class", "fund_data" );
        if(div != null && div.elementAt(0) != null){
            NodeList table = HtmlParserUtil.filterNode(div.elementAt(0), "table");
            if(table != null && table.elementAt(0)!= null && table.size() > 0){
                resultList = new ArrayList<HistoricalNetVo>();
                NodeList trs = HtmlParserUtil.filterNode(table.elementAt(0), "tr");
                if(trs != null && trs.size() > 0){
                    for (int i = 0; i < trs.size(); i++) {
                        NodeList tds = HtmlParserUtil.filterNode(trs.elementAt(i), "td");
                        if(tds != null && tds.size() > 0){
                            HistoricalNetVo midVo =  new HistoricalNetVo();
                            midVo.setProduct_id(product_id);
                            midVo.setProduct_code(product_code);
                            for (int j = 0; j < tds.size() ; j++) {
                                String fVal= HtmlParserUtil.getPlainTextString(tds.elementAt(j));
                                //System.out.println("fVal = [" + fVal + "]" +"j = [" + j + "]"  );
                                //赋值
                                switch (j){
                                    case 0: if(!StringUtil.isEmpty(fVal))midVo.setNet_worth_date(fVal); break;
                                    case 1: midVo.setUnit_net_worth(StringUtil.StringToDouble(fVal)); break;
                                    case 2: midVo.setAdd_net_worth(StringUtil.StringToDouble(fVal));break;
                                    case 3: midVo.setChg(StringUtil.StringToDouble(fVal));break;
                                }
                            }
                            if(midVo != null) resultList.add(midVo);
                        }//tds
                    }
                }// trs
            }//table
        }//div
        return resultList;
    }
}
