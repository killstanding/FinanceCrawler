package com.jerry.financecrawler.translate.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.HistoricalNetVo;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
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
        Parser parser = new Parser();
        parser.setResource(html);
        parser.setEncoding(CommonsCharset.UTF_8);
        NodeFilter filter = new HasAttributeFilter( "class", "fund_data" );
        NodeList div = parser.extractAllNodesThatMatch(filter);
        if(div != null && div.elementAt(0) != null){
            NodeList table = new NodeList();
            NodeFilter tabFilter = new TagNameFilter("table");
            div.elementAt(0).collectInto(table, tabFilter);
            if(table != null && table.elementAt(0)!= null && table.size() > 0){
                resultList = new ArrayList<HistoricalNetVo>();
                NodeList trs = new NodeList();
                NodeFilter trFilter = new TagNameFilter("tr");
                table.elementAt(0).collectInto(trs,trFilter);
                if(trs != null && trs.size() > 0){
                    for (int i = 0; i < trs.size(); i++) {
                        NodeList tds = new NodeList();
                        NodeFilter tdFilter = new TagNameFilter("td");
                        trs.elementAt(i).collectInto(tds,tdFilter);
                        if(tds != null && tds.size() > 0){
                            HistoricalNetVo midVo =  new HistoricalNetVo();
                            midVo.setProduct_id(product_id);
                            midVo.setProduct_code(product_code);
                            for (int j = 0; j < tds.size() ; j++) {
                                Node td = tds.elementAt(j);
                                String val = td.toPlainTextString();
                                String fval= StringUtil.filterAllSymbol(val);//过滤特殊符号
                                //System.out.println("fval = [" + fval + "]" +"j = [" + j + "]"  );
                                //赋值
                                switch (j){
                                    case 0: midVo.setNet_worth_date(fval); break;
                                    case 1: midVo.setUnit_net_worth(StringUtil.StringToDouble(fval)); break;
                                    case 2: midVo.setAdd_net_worth(StringUtil.StringToDouble(fval));break;
                                    case 3: midVo.setChg(StringUtil.StringToDouble(fval));break;
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
