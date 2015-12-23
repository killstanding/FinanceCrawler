package com.jerry.financecrawler.job.eastmoney;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.db.po.FundProductPo;
import com.jerry.financecrawler.save.SaveData;
import com.jerry.financecrawler.translate.eastmoney.JsonToEastMoneyHistoricalNetVo;
import com.jerry.financecrawler.visitor.HtmlRequest;
import com.jerry.financecrawler.vo.HistoricalNetTotalVo;
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
public class EastMoneyHistoricalNetJob {
    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(EastMoneyHistoricalNetJob.class);

    private static final String baseUrl = CommonsUrl.EAST_MONEY_HISTORICAL_NET_URL;

    private static final String charset = CommonsCharset.GB2312;

    @Resource
    private HtmlRequest htmlRequest;

    @Resource
    private JsonToEastMoneyHistoricalNetVo jsonToEastMoneyHistoricalNetVo;
    @Resource
    private SaveData saveData;

    public void execute(List<FundProductPo> fundProductPoList) {
        log.info("EastMoney 历史净值采集服务启动");
        if (fundProductPoList != null) {
            for (int i = 0; i < fundProductPoList.size(); i++) {
                FundProductPo fundProductPo = fundProductPoList.get(i);
                String fincode = fundProductPo.getFincode();
                int product_id = fundProductPo.getId();
                String product_code = fundProductPo.getProduct_code();
                try {
                    int index = 1;
                    int pageNum = 10;
                    HistoricalNetTotalVo historicalNetTotalVo = getHtmlData(product_id, product_code, fincode, index, pageNum, 0);
                    int allPages = historicalNetTotalVo.getAllPages();
                    index++;
                    while (index <= allPages) {
                        getHtmlData(product_id, product_code, fincode, index, pageNum, allPages);
                        index++;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    log.error("dealing EastMoneyHistoricalNetJob data", ex);
                }
            }
        }

        log.info("EastMoney 历史净值采集服务完成");
    }

    private HistoricalNetTotalVo getHtmlData( int product_id, String product_code, String fincode, int index, int pageNum, int allPages) throws Exception {
        String url = CommonsUrl.getEastMoneyFinanceHistoricalNetUrlByCode(baseUrl, fincode, index, pageNum, allPages);
        String data = htmlRequest.getHtmlData(url, charset);
        HistoricalNetTotalVo historicalNetTotalVo = null;
        if (!data.equals("")) {
            data = StringUtil.subJsonStrBySymbol(data, StringUtil.SYMBOL_EQUAL);
            historicalNetTotalVo = jsonToEastMoneyHistoricalNetVo.parseToHistoricalNetData(data, product_id, product_code);
            List<HistoricalNetVo> historicalNetVoList = historicalNetTotalVo.getDatas();

            if(historicalNetVoList != null) saveData.saveHistoricalNetData(historicalNetVoList);
        }
        return historicalNetTotalVo;
    }


}
