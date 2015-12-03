package com.jerry.financecrawler.job.eastmoney;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.job.QuartzJob;
import com.jerry.financecrawler.save.SaveData;
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

    private static final String charset = CommonsCharset.GB2312;

    @Resource
    private HtmlRequest htmlRequest;

    @Resource
    private JsonToEastMoneyFundProductVo jsonToEastMoneyFundProductVo;
    @Resource
    private SaveData saveData;

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

    private FundProductTotalVo getHtmlData(int index, int pageNum, int allpages) throws Exception {
        String url = CommonsUrl.getUrl(baseUrl, index, pageNum, 0);
        String data = htmlRequest.getHtmlData(url, charset);
        FundProductTotalVo fundProductTotalVo = null;
        if (!data.equals("")) {
            data = StringUtil.subJsonStrBySymbol(data, StringUtil.SYMBOL_EQUAL);
            // 翻译EastMoney 产品数据
            fundProductTotalVo = jsonToEastMoneyFundProductVo.parseToEastMoneyData(data);
            List<FundProductVo> fundProductVoList = fundProductTotalVo.getDatas();
            if(fundProductVoList != null && fundProductVoList.size() > 0){
                for (int i = 0; i < fundProductVoList.size(); i++) {



                }// for fundProductVoList
                saveData.saveFundProductData(fundProductVoList);
            }// if fundProductVoList

        }
        return fundProductTotalVo;
    }


}
