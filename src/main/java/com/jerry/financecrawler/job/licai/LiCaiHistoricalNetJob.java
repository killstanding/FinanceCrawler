package com.jerry.financecrawler.job.licai;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.db.po.FundProductPo;
import com.jerry.financecrawler.save.SaveData;
import com.jerry.financecrawler.translate.licai.HtmlToLiCaiHistoricalNetVo;
import com.jerry.financecrawler.visitor.HtmlRequest;
import com.jerry.financecrawler.vo.HistoricalNetVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jerry on 2015/9/17.
 */
@Component
public class LiCaiHistoricalNetJob {
    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(LiCaiHistoricalNetJob.class);

    private static final String baseUrl = CommonsUrl.LI_CAI_BASE_URL;

    private static final String charset = CommonsCharset.GB2312;

    @Resource
    private HtmlRequest htmlRequest;

    @Resource
    private HtmlToLiCaiHistoricalNetVo htmlToLiCaiHistoricalNetVo;
    @Resource
    private SaveData saveData;

    public void execute(List<FundProductPo> fundProductPoList) {
        log.info("LiCai 历史净值采集服务启动");
        //log.info("fundProductPoList= " + fundProductPoList.size());
        if (fundProductPoList != null) {
            for (int i = 0; i < fundProductPoList.size(); i++) {
                FundProductPo fundProductPo = fundProductPoList.get(i);
                String fincode = fundProductPo.getFincode();
                int product_id = fundProductPo.getId();
                String product_code = fundProductPo.getProduct_code();
                try {

                    getHtmlData(product_id, product_code, fincode);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    log.error("dealing LiCaiHistoricalNetJob data", ex);
                }
            }
        }

        log.info("LiCai 历史净值采集服务完成");
    }

    private void getHtmlData(int product_id, String product_code, String fincode) throws Exception {
        String url = baseUrl + fincode;
        String data = htmlRequest.getHtmlData(url, charset);
        if (!data.equals("")) {

            List<HistoricalNetVo> historicalNetVoList = htmlToLiCaiHistoricalNetVo.parseToHistoricalNetData(data, product_id, product_code);
            //log.info("historicalNetVoList = " + historicalNetVoList.size());
            if (historicalNetVoList != null) saveData.saveHistoricalNetData(historicalNetVoList);
        }
    }


}
