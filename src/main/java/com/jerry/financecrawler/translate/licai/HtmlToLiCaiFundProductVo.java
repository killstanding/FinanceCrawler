package com.jerry.financecrawler.translate.licai;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.HtmlParserUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.FundProductVo;
import com.jerry.financecrawler.vo.IncomeVo;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2015/9/18.
 */
@Component
public class HtmlToLiCaiFundProductVo {

    public List<FundProductVo> parseToFundProductData(String html) throws Exception {
        //System.out.println("html = [" + html + "]");
        List<FundProductVo> resultList = null;
        NodeList trs = HtmlParserUtil.filterTargetNode(html, CommonsCharset.GB2312, "tr");
        if (trs != null && trs.size() > 0) {
            resultList = new ArrayList<FundProductVo>();
            for (int i = 0; i < trs.size(); i++) {
                NodeList tds = HtmlParserUtil.filterNode(trs.elementAt(i), "td");
                if (tds != null && tds.size() > 0) {
                    FundProductVo midVo = new FundProductVo();
                    IncomeVo incomeVo = new IncomeVo();
                    for (int j = 0; j < tds.size(); j++) {
                        Node td = tds.elementAt(j);
                        String fVal = HtmlParserUtil.getPlainTextString(td);
                        //System.out.println("fVal = [" + fVal + "]" +"j = [" + j + "]"  );
                        //赋值
                        switch (j) {
                            case 0:
                                NodeList inputs = HtmlParserUtil.filterNode(td,"input");
                                if(inputs.size()>0){
                                    String product_code = HtmlParserUtil.getInputAttribute(inputs.elementAt(0), "id");
                                    //midVo.setProduct_code(product_code);//基金编号
                                }
                                break;
                            case 1: break;
                            case 2:
                                //产品名称
                                if(!StringUtil.isEmpty(fVal)) {
                                    midVo.setProduct_name(fVal);
                                    midVo.setProduct_shortname(fVal);
                                }
                                NodeList links = HtmlParserUtil.filterNode(td, "a");
                                if(links.size()>0){
                                    String detailUrl =HtmlParserUtil.getLinkAttribute(links.elementAt(0), "href");
                                    midVo.setFincode(detailUrl);//详情url
                                }
                                break;
                            case 3:
                                // 私募公司
                                NodeList ls = HtmlParserUtil.filterNode(td, "a");
                                if(ls.size()>0){
                                    String companyUrl = HtmlParserUtil.getLinkAttribute(ls.elementAt(0), "href");
                                }
                                break;
                            case 4:
                                if(!StringUtil.isEmpty(fVal)) midVo.setProduct_TYPE(fVal);//类型
                                break;
                            case 5:
                                if(!StringUtil.isEmpty(fVal)) incomeVo.setI_NEARLY_A_MONTH(StringUtil.StringToDouble(fVal));//本月
                                break;
                            case 6:
                                 if(!StringUtil.isEmpty(fVal)) incomeVo.setI_SINCE_THIS_YEAR(StringUtil.StringToDouble(fVal));//今年以来
                                break;
                            case 7:
                                if(!StringUtil.isEmpty(fVal))
                                    incomeVo.setI_NEARLY_A_YEAR(StringUtil.StringToDouble(fVal));
                                break;//近一年
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
                                    incomeVo.setI_SINCE_ITS_ESTABLISHMENT(StringUtil.StringToDouble(fVal)); //成立以来
                                break;//总收益
                            default: break;

                        }
                    }
                    if (midVo != null) {
                        midVo.setIncomeVo(incomeVo);
                        resultList.add(midVo);
                    }
                }//tds
            }
        }// trs

        return resultList;
    }
}
