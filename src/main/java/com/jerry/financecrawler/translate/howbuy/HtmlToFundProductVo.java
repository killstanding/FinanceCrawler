package com.jerry.financecrawler.translate.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.HtmlParserUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.FundProductTotalVo;
import com.jerry.financecrawler.vo.FundProductVo;
import com.jerry.financecrawler.vo.IncomeVo;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.InputTag;
import org.htmlparser.util.NodeList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2015/9/18.
 */
@Component
public class HtmlToFundProductVo {
    public FundProductTotalVo parseToFundProductData(String html) throws Exception {
//        if(html.indexOf("P04876") != -1)
//        System.out.println("html = [" + html + "]");
        if (html == null || html.equals("")) return null;
        FundProductTotalVo fundProductTotalVo = new FundProductTotalVo();
        List<FundProductVo> resultList = null;

        //获取page信息
        getPageData(fundProductTotalVo, html);

        //获取表格信息
        NodeList div = HtmlParserUtil.filterTargetNode(html, CommonsCharset.UTF_8, "class", "result_table result_data0");
        if (div != null) {
            NodeList table = HtmlParserUtil.filterNode(div.elementAt(0), "table");
            if (table != null && table.elementAt(0) != null && table.size() > 0) {
                resultList = new ArrayList<FundProductVo>();
                NodeList trs = HtmlParserUtil.filterNode(table.elementAt(0), "tr");
                if (trs != null && trs.size() > 0) {
                    for (int i = 0; i < trs.size(); i++) {
                        NodeList tds = HtmlParserUtil.filterNode(trs.elementAt(i), "td");
                        if (i % 3 == 1 || i % 3 == 2) continue;
                        if (tds != null && tds.size() > 0) {
                            FundProductVo midVo = new FundProductVo();
                            IncomeVo incomeVo = new IncomeVo();
                            for (int j = 0; j < tds.size(); j++) {
                                Node td = tds.elementAt(j);
                                String fVal= HtmlParserUtil.getPlainTextString(td);
                                //System.out.println("fVal = [" + fVal + "]" + "j = [" + j + "]");
                                //赋值
                                switch (j) {
                                    case 0:
                                        NodeList inputs = HtmlParserUtil.filterNode(td,"input");
                                        if(inputs.size()>0){
                                            String product_code = HtmlParserUtil.getInputAttribute(inputs.elementAt(0), "code");
                                            midVo.setProduct_code(product_code);//基金编号
                                        }else{
                                            continue;
                                        }
                                        break;
                                    case 1:
                                        break;
                                    case 2:
                                        if(!StringUtil.isEmpty(fVal)) {
                                            midVo.setProduct_name(fVal);//名称
                                            midVo.setProduct_shortname(fVal);//名称
                                        }
                                        break;
                                    case 3:
                                        if(!StringUtil.isEmpty(fVal)) midVo.setProduct_TYPE(fVal);//类型
                                        break;
                                    case 4:
                                        if(!StringUtil.isEmpty(fVal))
                                            incomeVo.setI_SINCE_ITS_ESTABLISHMENT(StringUtil.StringToDouble(fVal));
                                        break;//成立以来
                                    case 5:
                                        break;
                                    case 6:
                                        if(!StringUtil.isEmpty(fVal))
                                            incomeVo.setI_NEARLY_A_YEAR(StringUtil.StringToDouble(fVal));
                                        break;//近一年
                                    case 7:
                                        if(!StringUtil.isEmpty(fVal))
                                            incomeVo.setI_NEARLY_TWO_YEARS(StringUtil.StringToDouble(fVal));
                                        break;//近两年
                                    case 8:
                                        if(!StringUtil.isEmpty(fVal))
                                            incomeVo.setI_NEARLY_THREE_YEARS(StringUtil.StringToDouble(fVal));
                                        break;//近三年
                                    case 9:
                                        if(!StringUtil.isEmpty(fVal))
                                            incomeVo.setI_NEARLY_FIVE_YEARS(StringUtil.StringToDouble(fVal));
                                        break;//近5年
                                    case 10:
                                        if(!StringUtil.isEmpty(fVal))
                                            incomeVo.setI_NEARLY_A_MONTH(StringUtil.StringToDouble(fVal));
                                        break;// 近一月
                                    case 11:
                                        if(!StringUtil.isEmpty(fVal))
                                            incomeVo.setI_NEARLY_THREE_MONTHS(StringUtil.StringToDouble(fVal));
                                        break;// 近三月
                                    case 12:
                                        if(!StringUtil.isEmpty(fVal))
                                            incomeVo.setI_NEARLY_HALF_A_YEAR(StringUtil.StringToDouble(fVal));
                                        break;//近半年
                                    case 13:
                                        if(!StringUtil.isEmpty(fVal))
                                            incomeVo.setI_SINCE_THIS_YEAR(StringUtil.StringToDouble(fVal));
                                        break;//近一年
                                    case 14:
                                        if(!StringUtil.isEmpty(fVal)) {
                                            String preValue = StringUtil.subPreBracket(fVal);
                                            if (preValue != null && !preValue.equals(""))
                                                incomeVo.setI_LATEST_NET_WORTH(StringUtil.StringToDouble(preValue));
                                            String backValue = StringUtil.subBackBracket(fVal);
                                            if (backValue != null && !backValue.equals("")) {
                                                backValue = StringUtil.addDateYear(backValue);
                                                incomeVo.setI_UPDATE_DATE(backValue);
                                            }
                                        }
                                        break; //最新净值和日期
                                    case 15:
                                        break; //评级
                                    case 16:
                                        if(!StringUtil.isEmpty(fVal))
                                            midVo.setProduct_ESTABLISHMENT_DATE(fVal);//   date 成立日期
                                        break;
                                }
                            }//for tds
                            if (incomeVo != null) midVo.setIncomeVo(incomeVo);
                            if (midVo != null) resultList.add(midVo);
                        }//tds
                    }//for trs
                }//if trs
            }//if table
        }
        fundProductTotalVo.setDatas(resultList);
        return fundProductTotalVo;
    }

    public void getPageData(FundProductTotalVo fundProductTotalVo, String html) throws Exception {
        Parser parser = new Parser();
        parser.setResource(html);
        parser.setEncoding(CommonsCharset.UTF_8);
        NodeFilter filter = new HasAttributeFilter("class", "pages");
        NodeList div = parser.extractAllNodesThatMatch(filter);
        if (div != null) {
            NodeList inputs = new NodeList();
            NodeFilter tabFilter = new TagNameFilter("input");
            div.elementAt(0).collectInto(inputs, tabFilter);
            if (inputs != null && inputs.elementAt(0) != null && inputs.size() > 0) {
                for (int i = 0; i < 3; i++) {
                    InputTag inputTag = (InputTag) inputs.elementAt(i);
                    String val = inputTag.getAttribute("value");
                    //System.out.println("val = [" + val + "]");
                    switch (i) {
                        case 0:
                            fundProductTotalVo.setPageIndex(StringUtil.StringToInt(val));
                            break;
                        case 1:
                            fundProductTotalVo.setPageSize(StringUtil.StringToInt(val));
                            break;
                        case 2:
                            fundProductTotalVo.setAllPages(StringUtil.StringToInt(val));
                            break;
                    }
                }//for inputs
            }//if inputs
        }//if div
    }

}
