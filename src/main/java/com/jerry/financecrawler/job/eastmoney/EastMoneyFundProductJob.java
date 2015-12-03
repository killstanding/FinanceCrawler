package com.jerry.financecrawler.job.eastmoney;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.db.po.FundProductPo;
import com.jerry.financecrawler.job.QuartzJob;
import com.jerry.financecrawler.save.SaveData;
import com.jerry.financecrawler.translate.eastmoney.HtmlToEastMoneyDetailVo;
import com.jerry.financecrawler.translate.eastmoney.JsonToEastMoneyFundProductVo;
import com.jerry.financecrawler.visitor.HtmlRequest;
import com.jerry.financecrawler.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jerry on 2015/9/17.
 */
public class EastMoneyFundProductJob implements QuartzJob {
    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(EastMoneyFundProductJob.class);

    private static final String baseUrl = CommonsUrl.EAST_MONEY_URL;

    private static final String detailUrl = CommonsUrl.EAST_MONEY_DETAIL_URL;

    private static final String charset = CommonsCharset.GB2312;

    @Resource
    private HtmlRequest htmlRequest;

    @Resource
    private JsonToEastMoneyFundProductVo jsonToEastMoneyFundProductVo;
    @Resource
    private SaveData saveData;
    @Resource
    private EastMoneyHistoricalNetJob eastMoneyHistoricalNetJob;
    @Resource
    private HtmlToEastMoneyDetailVo htmlToEastMoneyDetailVo;

    @Override
    public void execute() {
        log.info("EastMoney 基金产品采集服务启动");
        try {
            int index = 1;
            int pageNum = 100;
            FundProductTotalVo fundProductTotalVo = getHtmlData(index, pageNum, 0);
            int allPages = fundProductTotalVo.getAllPages();
            index++;
            while (index <= allPages) {
                getHtmlData(index, pageNum, allPages);
                index++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("dealing EastMoney data", ex);
        }


        log.info("EastMoney 基金产品采集服务完成");
    }

    private FundProductTotalVo getHtmlData(int index, int pageNum, int allPages) throws Exception {
        String url = CommonsUrl.getUrl(baseUrl, index, pageNum, allPages);
        String data = htmlRequest.getHtmlData(url, charset);
        FundProductTotalVo fundProductTotalVo = null;
        if (!data.equals("")) {
            data = StringUtil.subJsonStrBySymbol(data, StringUtil.SYMBOL_EQUAL);
            // 翻译EastMoney 产品数据
            fundProductTotalVo = jsonToEastMoneyFundProductVo.parseToEastMoneyData(data);
            List<FundProductVo> fundProductVoList = fundProductTotalVo.getDatas();
            if (fundProductVoList != null && fundProductVoList.size() > 0) {
                for (int i = 0; i < fundProductVoList.size(); i++) {
                    FundProductVo fundProductVo = fundProductVoList.get(i);
                    String fincode = fundProductVo.getFincode();
                    //获取product_code
                    String product_code = getFcodeByFincode(fincode);
                    fundProductVo.setProduct_code(product_code);
                    //log.info("product_code = [" + product_code + "]");
                }// for fundProductVoList
                //log.info("开始保存 基金产品数据");
                List<FundProductPo> fundProductPoList = saveData.saveFundProductData(fundProductVoList);
                //log.info("fundProductPoList.size = [" + fundProductPoList.size() + "]");
                //采集新东方历史净值
                eastMoneyHistoricalNetJob.execute(fundProductPoList);
            }// if fundProductVoList
        }
        return fundProductTotalVo;
    }

    private String getFcodeByFincode(String fincode) throws Exception{
        String url = CommonsUrl.getUrlByCode(detailUrl, fincode);
        String data = htmlRequest.getHtmlData(url, charset);

        return htmlToEastMoneyDetailVo.HtmlToProductCode(data);
    }

}
