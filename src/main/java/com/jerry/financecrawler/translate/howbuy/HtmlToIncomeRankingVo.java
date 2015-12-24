package com.jerry.financecrawler.translate.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.HtmlParserUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.IncomeRankingVo;
import org.htmlparser.Node;
import org.htmlparser.util.NodeList;
import org.springframework.stereotype.Component;

/**
 * Created by Jerry on 15/11/30.
 */
@Component
public class HtmlToIncomeRankingVo {
    public IncomeRankingVo parseToIncomeRankingData(String html, int product_id) throws Exception{
        IncomeRankingVo vo = new IncomeRankingVo();
        if (html == null || html.equals("")) return null;
        vo.setProduct_id(product_id);
        //获取表格信息
        NodeList div = HtmlParserUtil.filterTargetNode(html, CommonsCharset.UTF_8, "class", "history_tb_con table-style-a");
        if (div != null) {
            NodeList table = HtmlParserUtil.filterNode(div.elementAt(0), "table");
            if (table != null && table.elementAt(0) != null && table.size() > 0) {
                NodeList trs = HtmlParserUtil.filterNode(table.elementAt(0), "tr");
                if (trs != null && trs.size() > 0) {
                    for (int i = 0; i < trs.size(); i++) {
                        if (i == 5) {//只取收益排名数据
                            NodeList tds = HtmlParserUtil.filterNode(trs.elementAt(i), "td");
                            if (tds != null && tds.size() > 0) {
                                for (int j = 0; j < tds.size(); j++) {
                                    Node td = tds.elementAt(j);
                                    String fVal = HtmlParserUtil.getPlainTextStringWithoutFilter(td);
                                    System.out.println("fVal = [" + fVal + "]" + ", j = [" + j + "]");
                                    //赋值
                                    switch (j) {
                                        case 0:
                                            // 数据类型名称
                                            break;
                                        case 1:
                                            if (!StringUtil.isEmpty(fVal))
                                                vo.setIR_SINCE_THIS_YEAR(fVal); //今年以来
                                            break;
                                        case 2:
                                            if (!StringUtil.isEmpty(fVal))
                                                vo.setIR_NEARLY_A_MONTH(fVal);//近一月
                                            break;
                                        case 3:
                                            if (!StringUtil.isEmpty(fVal))
                                                vo.setIR_NEARLY_THREE_MONTHS(fVal);//近三月
                                            break;
                                        case 4:
                                            if (!StringUtil.isEmpty(fVal))
                                                vo.setIR_NEARLY_HALF_A_YEAR(fVal);//近六月
                                            break;
                                        case 5:
                                            if (!StringUtil.isEmpty(fVal))
                                                vo.setIR_NEARLY_A_YEAR(fVal);//近一年
                                            break;
                                        case 6:
                                            if (!StringUtil.isEmpty(fVal))
                                                vo.setIR_NEARLY_TWO_YEARS(fVal);//近二年
                                            break;
                                        case 7:
                                            if (!StringUtil.isEmpty(fVal))
                                                vo.setIR_NEARLY_THREE_YEARS(fVal);//近三年
                                            break;
                                        case 8:
                                            if (!StringUtil.isEmpty(fVal))
                                                vo.setIR_NEARLY_FIVE_YEARS(fVal);//近五年
                                            break;
                                        case 9:
                                            break;
                                    }
                                }//for tds
                            }//tds
                            break;
                        }//if  i
                    }//for trs
                }//if trs
            }//if table
        }
        return vo;
    }

}
