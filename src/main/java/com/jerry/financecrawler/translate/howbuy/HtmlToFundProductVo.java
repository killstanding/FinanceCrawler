package com.jerry.financecrawler.translate.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
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

        //System.out.println("html = [" + html + "]");
        if (html == null || html.equals("")) return null;
        FundProductTotalVo fundProductTotalVo = new FundProductTotalVo();
        List<FundProductVo> resultList = null;

        //获取page信息
        getPageData(fundProductTotalVo, html);

        //获取表格信息
        Parser parser = new Parser();
        parser.setResource(html);
        parser.setEncoding(CommonsCharset.UTF_8);
        NodeFilter filter = new HasAttributeFilter("class", "result_table result_data0");
        NodeList div = parser.extractAllNodesThatMatch(filter);
        if (div != null) {
            NodeList table = new NodeList();
            NodeFilter tabFilter = new TagNameFilter("table");
            div.elementAt(0).collectInto(table, tabFilter);
            if (table != null && table.elementAt(0) != null && table.size() > 0) {
                resultList = new ArrayList<FundProductVo>();
                NodeList trs = new NodeList();
                NodeFilter trFilter = new TagNameFilter("tr");
                table.elementAt(0).collectInto(trs, trFilter);
                if (trs != null && trs.size() > 0) {
                    for (int i = 0; i < trs.size(); i++) {
                        NodeList tds = new NodeList();
                        NodeFilter tdFilter = new TagNameFilter("td");
                        trs.elementAt(i).collectInto(tds, tdFilter);
                        if (i % 3 == 1 || i % 3 == 2) continue;
                        if (tds != null && tds.size() > 0) {
                            FundProductVo midVo = new FundProductVo();
                            IncomeVo incomeVo = new IncomeVo();
                            for (int j = 0; j < tds.size(); j++) {
                                Node td = tds.elementAt(j);
                                String val = td.toPlainTextString();
                                String fval = StringUtil.filterAllSymbol(val);//过滤特殊符号
                                //System.out.println("fval = [" + fval + "]" + "j = [" + j + "]");
                                //赋值
                                switch (j) {
                                    case 0:
                                        InputTag inputTag = (InputTag) td.getFirstChild();
                                        String product_code = inputTag.getAttribute("code");
                                        midVo.setProduct_code(product_code);//基金编号
                                        break;
                                    case 1:
                                        break;
                                    case 2:
                                        if (fval != null && !fval.equals("")) {
                                            midVo.setProduct_name(fval);//名称
                                            midVo.setProduct_shortname(fval);//名称
                                        }
                                        break;
                                    case 3:
                                        if (fval != null && !fval.equals("")) midVo.setProduct_TYPE(fval);//类型
                                        break;
                                    case 4:
                                        if (fval != null && !fval.equals(""))
                                            incomeVo.setI_SINCE_ITS_ESTABLISHMENT(StringUtil.StringToDouble(fval));
                                        break;//成立以来
                                    case 5:
                                        break;
                                    case 6:
                                        if (fval != null && !fval.equals(""))
                                            incomeVo.setI_NEARLY_A_YEAR(StringUtil.StringToDouble(fval));
                                        break;//近一年
                                    case 7:
                                        if (fval != null && !fval.equals(""))
                                            incomeVo.setI_NEARLY_TWO_YEARS(StringUtil.StringToDouble(fval));
                                        break;//近两年
                                    case 8:
                                        if (fval != null && !fval.equals(""))
                                            incomeVo.setI_NEARLY_THREE_YEARS(StringUtil.StringToDouble(fval));
                                        break;//近三年
                                    case 9:
                                        if (fval != null && !fval.equals(""))
                                            incomeVo.setI_NEARLY_FIVE_YEARS(StringUtil.StringToDouble(fval));
                                        break;//近5年
                                    case 10:
                                        if (fval != null && !fval.equals(""))
                                            incomeVo.setI_NEARLY_A_MONTH(StringUtil.StringToDouble(fval));
                                        break;// 近一月
                                    case 11:
                                        if (fval != null && !fval.equals(""))
                                            incomeVo.setI_NEARLY_THREE_MONTHS(StringUtil.StringToDouble(fval));
                                        break;// 近三月
                                    case 12:
                                        if (fval != null && !fval.equals(""))
                                            incomeVo.setI_NEARLY_HALF_A_YEAR(StringUtil.StringToDouble(fval));
                                        break;//近半年
                                    case 13:
                                        if (fval != null && !fval.equals(""))
                                            incomeVo.setI_SINCE_THIS_YEAR(StringUtil.StringToDouble(fval));
                                        break;//近一年
                                    case 14:
                                        if (fval != null && !fval.equals("")) {
                                            String preValue = StringUtil.subPreBracket(fval);
                                            if (preValue != null && !preValue.equals(""))
                                                incomeVo.setI_LATEST_NET_WORTH(StringUtil.StringToDouble(preValue));
                                            String backValue = StringUtil.subBackBracket(fval);
                                            if (backValue != null && !backValue.equals("")) {
                                                backValue = StringUtil.addDateYear(backValue);
                                                incomeVo.setI_UPDATE_DATE(backValue);
                                            }
                                        }
                                        break; //最新净值和日期
                                    case 15:
                                        break; //评级
                                    case 16:
                                        if (fval != null && !fval.equals(""))
                                            midVo.setProduct_ESTABLISHMENT_DATE(fval);//   date 成立日期
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
