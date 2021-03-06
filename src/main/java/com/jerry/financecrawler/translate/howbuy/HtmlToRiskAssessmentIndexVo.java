package com.jerry.financecrawler.translate.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.HtmlParserUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.*;
import org.htmlparser.util.NodeList;
import org.springframework.stereotype.Component;
/**
 * Created by Jerry on 15/11/24.
 */
@Component
public class HtmlToRiskAssessmentIndexVo {

    public RiskAssessmentIndexVo parseToRiskAssessmentIndexData(String html, int product_id) throws Exception{
        RiskAssessmentIndexVo  riskAssessmentIndexVo = new RiskAssessmentIndexVo();
        NodeList div = HtmlParserUtil.filterTargetNode(html, CommonsCharset.UTF_8, "class", "tb_nouns ftArial ft12 cBlack table-style-a fl" );
        if(div != null && div.elementAt(0) != null){
            NodeList table = HtmlParserUtil.filterNode(div.elementAt(0), "table");
            if(table != null && table.elementAt(0)!= null && table.size() > 0){
                NodeList trs = HtmlParserUtil.filterNode(table.elementAt(0), "tr");
                if(trs != null && trs.size() > 0){
                    for (int i = 0; i < trs.size(); i++) {
                        if (i == 0) continue;
                        NodeList tds = HtmlParserUtil.filterNode(trs.elementAt(i), "td");
                        switch (i) {
                            case 1:
                                AnnualizedReturnRateVo annualizedReturnRateVo = setAnnualizedReturnRateVoValue(tds, product_id);
                                if (annualizedReturnRateVo != null)
                                    riskAssessmentIndexVo.setAnnualizedReturnRateVo(annualizedReturnRateVo);
                                break;//年化收益率
                            case 2:
                                AnnualFluctuationRateVo annualFluctuationRateVo = setAnnualFluctuationRateVoValue(tds, product_id);
                                if (annualFluctuationRateVo != null)
                                    riskAssessmentIndexVo.setAnnualFluctuationRateVo(annualFluctuationRateVo);
                                break;//年化波动率
                            case 3:
                                MaximumReturnVo maximumReturnVo = setMaximumReturnVoValue(tds, product_id);
                                if (maximumReturnVo != null) riskAssessmentIndexVo.setMaximumReturnVo(maximumReturnVo);
                                break;//最大回撤
                            case 4:
                                SharpRatioVo sharpRatioVo = setSharpRatioVoValue(tds, product_id);
                                if (sharpRatioVo != null) riskAssessmentIndexVo.setSharpRatioVo(sharpRatioVo);
                                break;//夏普比率
                            case 5:
                                CalmarRatioVo calmarRatioVo = setCalmarRatioVoValue(tds, product_id);
                                if (calmarRatioVo != null) riskAssessmentIndexVo.setCalmarRatioVo(calmarRatioVo);
                                break;//CALMAR比率
                            case 6:
                                SterlingRatioVo sterlingRatioVo = setSterlingRatioVoValue(tds, product_id);
                                if (sterlingRatioVo != null) riskAssessmentIndexVo.setSterlingRatioVo(sterlingRatioVo);
                                break;//Sterling比率
                        }//switch
                    }//for trs
                }//if trs
            }//table
        }//div
        return riskAssessmentIndexVo;
    }

    //年化收益率
    private AnnualizedReturnRateVo setAnnualizedReturnRateVoValue(NodeList tds, int product_id){
        AnnualizedReturnRateVo vo = null;
        if(tds != null && tds.size() > 0){
            vo =  new AnnualizedReturnRateVo();
            vo.setProduct_id(product_id);
            for (int i = 0; i < tds.size() ; i++) {
                String fVal= HtmlParserUtil.getPlainTextString(tds.elementAt(i));
                //System.out.println("fVal = [" + fVal + "]" +"j = [" + j + "]"  );
                //赋值
                switch (i){
                    case 0:  break; //风险评估指标 名称
                    case 1: vo.setRR_NEARLY_A_YEAR(StringUtil.StringToDouble(fVal)); break; //近一年
                    case 2: vo.setRR_NEARLY_TWO_YEARS(StringUtil.StringToDouble(fVal));break;//近两年
                    case 3: vo.setRR_NEARLY_THREE_YEARS(StringUtil.StringToDouble(fVal));break;//近三年
                    case 4: vo.setRR_NEARLY_FIVE_YEARS(StringUtil.StringToDouble(fVal)); break;//近五年
                    case 5: vo.setRR_SINCE_ITS_ESTABLISHMENT(StringUtil.StringToDouble(fVal)); break;//成立以来

                }// switch
            }//for
        }//tds
        return vo;
    }
    //年化波动率
    private AnnualFluctuationRateVo setAnnualFluctuationRateVoValue(NodeList tds, int product_id){
        AnnualFluctuationRateVo vo = null;
        if(tds != null && tds.size() > 0){
            vo =  new AnnualFluctuationRateVo();
            vo.setProduct_id(product_id);
            for (int i = 0; i < tds.size() ; i++) {
                String fVal= HtmlParserUtil.getPlainTextString(tds.elementAt(i));
                //System.out.println("fVal = [" + fVal + "]" +"j = [" + j + "]"  );
                //赋值
                switch (i){
                    case 0:  break; //风险评估指标 名称
                    case 1: vo.setFR_NEARLY_A_YEAR(StringUtil.StringToDouble(fVal)); break;//近一年
                    case 2: vo.setFR_NEARLY_TWO_YEARS(StringUtil.StringToDouble(fVal));break;//近两年
                    case 3: vo.setFR_NEARLY_THREE_YEARS(StringUtil.StringToDouble(fVal));break;//近三年
                    case 4: vo.setFR_NEARLY_FIVE_YEARS(StringUtil.StringToDouble(fVal)); break;//近五年
                    case 5: vo.setFR_SINCE_ITS_ESTABLISHMENT(StringUtil.StringToDouble(fVal)); break;//成立以来

                }// switch
            }//for
        }//tds
        return vo;
    }

    //最大回撤
    private MaximumReturnVo setMaximumReturnVoValue(NodeList tds, int product_id){
        MaximumReturnVo vo = null;
        if(tds != null && tds.size() > 0){
            vo =  new MaximumReturnVo();
            vo.setProduct_id(product_id);
            for (int i = 0; i < tds.size() ; i++) {
                String fVal= HtmlParserUtil.getPlainTextString(tds.elementAt(i));
                //System.out.println("fVal = [" + fVal + "]" +"j = [" + j + "]"  );
                //赋值
                switch (i){
                    case 0:  break; //风险评估指标 名称
                    case 1: vo.setMR_NEARLY_A_YEAR(StringUtil.StringToDouble(fVal)); break;//近一年
                    case 2: vo.setMR_NEARLY_TWO_YEARS(StringUtil.StringToDouble(fVal));break;//近两年
                    case 3: vo.setMR_NEARLY_THREE_YEARS(StringUtil.StringToDouble(fVal));break;//近三年
                    case 4: vo.setMR_NEARLY_FIVE_YEARS(StringUtil.StringToDouble(fVal)); break;//近五年
                    case 5: vo.setMR_SINCE_ITS_ESTABLISHMENT(StringUtil.StringToDouble(fVal)); break;//成立以来

                }// switch
            }//for
        }//tds
        return vo;
    }
    //夏普比率
    private SharpRatioVo setSharpRatioVoValue(NodeList tds, int product_id){
        SharpRatioVo vo = null;
        if(tds != null && tds.size() > 0){
            vo =  new SharpRatioVo();
            vo.setProduct_id(product_id);
            for (int i = 0; i < tds.size() ; i++) {
                String fVal= HtmlParserUtil.getPlainTextString(tds.elementAt(i));
                //System.out.println("fVal = [" + fVal + "]" +"j = [" + j + "]"  );
                //赋值
                switch (i){
                    case 0:  break; //风险评估指标 名称
                    case 1: vo.setSR_NEARLY_A_YEAR(StringUtil.StringToDouble(fVal)); break;//近一年
                    case 2: vo.setSR_NEARLY_TWO_YEARS(StringUtil.StringToDouble(fVal));break;//近两年
                    case 3: vo.setSR_NEARLY_THREE_YEARS(StringUtil.StringToDouble(fVal));break;//近三年
                    case 4: vo.setSR_NEARLY_FIVE_YEARS(StringUtil.StringToDouble(fVal)); break;//近五年
                    case 5: vo.setSR_SINCE_ITS_ESTABLISHMENT(StringUtil.StringToDouble(fVal)); break;//成立以来

                }// switch
            }//for
        }//tds
        return vo;
    }
    //CALMAR比率
    private CalmarRatioVo setCalmarRatioVoValue(NodeList tds, int product_id){
        CalmarRatioVo vo = null;
        if(tds != null && tds.size() > 0){
            vo =  new CalmarRatioVo();
            vo.setProduct_id(product_id);
            for (int i = 0; i < tds.size() ; i++) {
                String fVal= HtmlParserUtil.getPlainTextString(tds.elementAt(i));
                //System.out.println("fVal = [" + fVal + "]" +"j = [" + j + "]"  );
                //赋值
                switch (i){
                    case 0:  break; //风险评估指标 名称
                    case 1: vo.setCR_NEARLY_A_YEAR(StringUtil.StringToDouble(fVal)); break;//近一年
                    case 2: vo.setCR_NEARLY_TWO_YEARS(StringUtil.StringToDouble(fVal));break;//近两年
                    case 3: vo.setCR_NEARLY_THREE_YEARS(StringUtil.StringToDouble(fVal));break;//近三年
                    case 4: vo.setCR_NEARLY_FIVE_YEARS(StringUtil.StringToDouble(fVal)); break;//近五年
                    case 5: vo.setCR_SINCE_ITS_ESTABLISHMENT(StringUtil.StringToDouble(fVal)); break;//成立以来

                }// switch
            }//for
        }//tds
        return vo;
    }
    //Sterling比率
    private SterlingRatioVo setSterlingRatioVoValue(NodeList tds, int product_id){
        SterlingRatioVo vo = null;
        if(tds != null && tds.size() > 0){
            vo =  new SterlingRatioVo();
            vo.setProduct_id(product_id);
            for (int i = 0; i < tds.size() ; i++) {
                String fVal= HtmlParserUtil.getPlainTextString(tds.elementAt(i));
                //System.out.println("fVal = [" + fVal + "]" +"j = [" + j + "]"  );
                //赋值
                switch (i){
                    case 0:  break; //风险评估指标 名称
                    case 1: vo.setSR_NEARLY_A_YEAR(StringUtil.StringToDouble(fVal)); break;//近一年
                    case 2: vo.setSR_NEARLY_TWO_YEARS(StringUtil.StringToDouble(fVal));break;//近两年
                    case 3: vo.setSR_NEARLY_THREE_YEARS(StringUtil.StringToDouble(fVal));break;//近三年
                    case 4: vo.setSR_NEARLY_FIVE_YEARS(StringUtil.StringToDouble(fVal)); break;//近五年
                    case 5: vo.setSR_SINCE_ITS_ESTABLISHMENT(StringUtil.StringToDouble(fVal)); break;//成立以来

                }// switch
            }//for
        }//tds
        return vo;
    }


}
