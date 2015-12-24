package com.jerry.financecrawler.job.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.convert.PoToVo;
import com.jerry.financecrawler.db.dao.*;
import com.jerry.financecrawler.db.po.FundProductPo;
import com.jerry.financecrawler.job.QuartzJob;
import com.jerry.financecrawler.save.SaveData;
import com.jerry.financecrawler.translate.howbuy.HtmlToIncomeRankingVo;
import com.jerry.financecrawler.translate.howbuy.HtmlToIncomeVo;
import com.jerry.financecrawler.translate.howbuy.HtmlToRiskAssessmentIndexVo;
import com.jerry.financecrawler.visitor.HtmlRequest;
import com.jerry.financecrawler.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jerry on 15/11/18.
 */
public class FundProductDetailJob implements QuartzJob {

    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(FundProductDetailJob.class);

    private static final String baseUrl = CommonsUrl.HOW_BUY_FINANCE_PRODUCT_DETAIL_URL;

    private static final String charset = CommonsCharset.UTF_8;

    @Resource
    private HtmlRequest htmlRequest;
    @Resource
    private IFundProduct fundProductDao;
    @Resource
    private SaveData saveData;


    @Resource
    private HtmlToRiskAssessmentIndexVo htmlToRiskAssessmentIndexVo;
    @Resource
    private HtmlToIncomeRankingVo htmlToIncomeRankingVo;
    @Resource
    private HtmlToIncomeVo htmlToIncomeVo;

    @Override
    public void execute() {
        log.info("howbuy  产品详情采集服务启动");
        List<FundProductPo> fundProductPoList = fundProductDao.findAll();
        if (fundProductPoList != null) {
            for (int i = 0; i < fundProductPoList.size(); i++) {
                FundProductPo fundProduct = fundProductPoList.get(i);
                String product_code = fundProduct.getProduct_code();
                //System.out.println("product_code = " + product_code);
                try {
                    if (product_code != null && !product_code.equals("")) {
                        getHtmlData(fundProduct);
                    } else {
                        log.error(fundProduct.getProduct_name() + "(" + fundProduct.getProduct_shortname() + ")的 product_code为空");
                    }
                } catch (Exception ex) {
                    log.error(fundProduct.getProduct_name() + "(" + fundProduct.getProduct_shortname() + ")的 product_code = " + product_code);
                    log.error("dealing FundProductDetailJob data", ex);
                    ex.printStackTrace();
                }
            }
        }
        log.info("howbuy 产品详情采集服务完成");
    }

    private void getHtmlData(FundProductPo po) throws Exception {
        String url = CommonsUrl.getUrlByCode(baseUrl, po.getProduct_code());
        String html = htmlRequest.getHtmlData(url, charset);
        FundProductVo fundProductVo = PoToVo.fundProductPoToVo(po);
        int product_id = fundProductVo.getId();

        if (!html.equals("")) {

            //解析收益指标
            IncomeVo incomeVo = htmlToIncomeVo.parseToIncomeData(html, product_id) ;

            //保存收益
            if(incomeVo != null) saveData.saveIncomeData(incomeVo, product_id);

            //解析风险评估指标
            RiskAssessmentIndexVo riskAssessmentIndexVo = htmlToRiskAssessmentIndexVo.parseToRiskAssessmentIndexData(html, product_id);

            //保存风险评估指标
            saveRiskAssessmentIndexData(riskAssessmentIndexVo, product_id);

            //解析收益同类排名
            IncomeRankingVo incomeRankingVo = htmlToIncomeRankingVo.parseToIncomeRankingData(html, product_id);

            if(incomeRankingVo != null) saveData.saveIncomeRankingData(incomeRankingVo, product_id);

            //解析费用费率


            //解析产品字段


        }
    }

    //风险评估指标
    private void saveRiskAssessmentIndexData(RiskAssessmentIndexVo riskAssessmentIndexVo, int product_id) throws Exception {
        //年化收益率
        AnnualizedReturnRateVo annualizedReturnRateVo = riskAssessmentIndexVo.getAnnualizedReturnRateVo();
        if (annualizedReturnRateVo != null) saveData.saveAnnualizedReturnRateData(annualizedReturnRateVo, product_id);

        //年化波动率
        AnnualFluctuationRateVo annualFluctuationRateVo = riskAssessmentIndexVo.getAnnualFluctuationRateVo();
        if (annualFluctuationRateVo != null)
            saveData.saveAnnualFluctuationRateData(annualFluctuationRateVo, product_id);

        //最大回撤
        MaximumReturnVo maximumReturnVo = riskAssessmentIndexVo.getMaximumReturnVo();
        if (maximumReturnVo != null) saveData.saveMaximumReturnData(maximumReturnVo, product_id);

        //夏普比率
        SharpRatioVo sharpRatioVo = riskAssessmentIndexVo.getSharpRatioVo();
        if (sharpRatioVo != null) saveData.saveSharpRatioData(sharpRatioVo, product_id);

        //CALMAR比率
        CalmarRatioVo calmarRatioVo = riskAssessmentIndexVo.getCalmarRatioVo();
        if (calmarRatioVo != null) saveData.saveCalmarRatioData(calmarRatioVo, product_id);

        //Sterling比率
        SterlingRatioVo sterlingRatioVo = riskAssessmentIndexVo.getSterlingRatioVo();
        if (sterlingRatioVo != null) saveData.saveSterlingRatioData(sterlingRatioVo, product_id);

    }

}
