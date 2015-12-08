package com.jerry.financecrawler.translate.licai;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.HtmlParserUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.FundProductVo;
import com.jerry.financecrawler.vo.IncomeVo;
import org.htmlparser.util.NodeList;
import org.springframework.stereotype.Component;



/**
 * Created by Jerry on 15/12/2.
 */
@Component
public class HtmlToLiCaiDetailVo {

    public void HtmlToLiCaiDetail(String html, FundProductVo fundProductVo) throws Exception {
        IncomeVo incomeVo = fundProductVo.getIncomeVo();
        //获取单位净值
        setLatestNetWorth(html, incomeVo);

        //获取净值更新时间和创建时间
        setUpdateDateAndEstablishmentDate(html, incomeVo, fundProductVo);
    }

    private void setLatestNetWorth(String html, IncomeVo incomeVo) throws Exception{
        NodeList uls = HtmlParserUtil.filterTargetNode(html, CommonsCharset.GB2312, "class", "fund_dt_big");
        if (uls != null && uls.elementAt(0) != null) {
            NodeList lis = HtmlParserUtil.filterNode(uls.elementAt(0), "li");
            if(lis.size() > 0 ){
                NodeList spans = HtmlParserUtil.filterNode(lis.elementAt(0), "span");
                String fVal = HtmlParserUtil.getPlainTextString(spans.elementAt(0));
               // System.out.println("fVal = [" + fVal + "]");
                incomeVo.setI_LATEST_NET_WORTH(StringUtil.StringToDouble(fVal));//最新净值
            }//if lis

        }//if uls
    }

    private void setUpdateDateAndEstablishmentDate(String html, IncomeVo incomeVo, FundProductVo fundProductVo) throws Exception{
        NodeList uls = HtmlParserUtil.filterTargetNode(html, CommonsCharset.GB2312, "class", "fund_dtail");
        if (uls != null && uls.elementAt(0) != null) {
            NodeList lis = HtmlParserUtil.filterNode(uls.elementAt(0), "li");
            if(lis.size() > 0 ){
                for (int i = 0; i <lis.size() ; i++) {
                    NodeList spans = null;
                    String fVal = "";
                    if(i != 1){
                         spans = HtmlParserUtil.filterNode(lis.elementAt(i), "span");
                         fVal = HtmlParserUtil.getPlainTextString(spans.elementAt(0));
                    }
                    //赋值
                    switch (i){
                        case 0:
                            NodeList as = HtmlParserUtil.filterNode(spans.elementAt(0), "a");
                            if(as.size() > 0) {
                                String companyUrl = HtmlParserUtil.getLinkAttribute(as.elementAt(0), "href");
                            }
                             break;//私募公司
                        case 1:
                            NodeList aList = HtmlParserUtil.filterNode(lis.elementAt(i), "a");
                            if(aList.size() > 0) {
                                String managerUrl = HtmlParserUtil.getLinkAttribute(aList.elementAt(0), "href");
                            }
                            break;//基金经理
                        case 2:

                            break;//年化收益
                        case 3:

                            break;//复权净值
                        case 4:
                            if(!StringUtil.isEmpty(fVal)){
                                fVal = fVal.replace("/", "-");
                                incomeVo.setI_UPDATE_DATE(fVal);
                            }
                            //System.out.println("incomeVo = [" + incomeVo.getI_UPDATE_DATE() + "]");
                            break;//净值日期
                        case 5:
                            if(!StringUtil.isEmpty(fVal)){
                                fVal = fVal.replace("/", "-");
                                fundProductVo.setProduct_ESTABLISHMENT_DATE(fVal);
                            }
                            break;//成立日期
                        default:break;
                    }
                }// for lis
            }//if lis

        }//if uls
    }
}
