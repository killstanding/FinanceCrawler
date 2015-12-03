package com.jerry.financecrawler.job.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.convert.VoToPo;
import com.jerry.financecrawler.db.dao.IFundProduct;
import com.jerry.financecrawler.db.dao.IHistoricalNet;
import com.jerry.financecrawler.db.po.FundProductPo;
import com.jerry.financecrawler.db.po.HistoricalNetPo;
import com.jerry.financecrawler.job.QuartzJob;
import com.jerry.financecrawler.save.SaveData;
import com.jerry.financecrawler.translate.howbuy.HtmlToHistoricalNetVo;
import com.jerry.financecrawler.visitor.HtmlRequest;
import com.jerry.financecrawler.vo.HistoricalNetVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jerry on 2015/9/17.
 */
public class HistoricalNetJob implements QuartzJob {
    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(HistoricalNetJob.class);

    private static final String baseUrl = CommonsUrl.HOW_BUY_FINANCE_HISTORICAL_NET_URL;

    private static final String charset = CommonsCharset.UTF_8;

    @Resource
    private HtmlRequest htmlRequest;

    @Resource
    private HtmlToHistoricalNetVo htmlToHistoricalNetVo;
    @Resource
    private IFundProduct fundProductDao;
    @Resource
    private SaveData saveData;

    @Override
    public void execute() {
        log.info("howbuy 历史净值采集服务启动");
        List<FundProductPo> fundProductPoList = fundProductDao.findAll();
        if (fundProductPoList != null) {
            for (int i = 0; i < fundProductPoList.size(); i++) {
                FundProductPo fundProduct = fundProductPoList.get(i);
                int product_id = fundProduct.getId();
                String product_code = fundProduct.getProduct_code();
                //System.out.println("product_code = " + product_code);
                List<HistoricalNetVo> historicalNetList = null;
                try {
                    if (product_code != null && !product_code.equals("")) {
                        historicalNetList = getHtmlData(product_id, product_code);
                    } else {
                        log.error(fundProduct.getProduct_name() + "(" + fundProduct.getProduct_shortname() + ")的 product_code为空");
                    }
                } catch (Exception ex) {
                    log.error(fundProduct.getProduct_name() + "(" + fundProduct.getProduct_shortname() + ")的 product_code = " + product_code);
                    log.error("dealing HowBuyHistoricalNetJob data", ex);
                    ex.printStackTrace();
                }
                if(historicalNetList != null) saveData.saveHistoricalNetData(historicalNetList);
            }
        }
        log.info("howbuy 历史净值采集服务完成");
    }

    private List<HistoricalNetVo> getHtmlData(int product_id, String product_code) throws Exception {
        String url = CommonsUrl.getUrlByCode(baseUrl, product_code);
        String html = htmlRequest.getHtmlData(url, charset);
        List<HistoricalNetVo> historicalNetList = null;
        if (!html.equals("")) {
            historicalNetList = htmlToHistoricalNetVo.parseToHistoricalNetData(html, product_id, product_code);
        }
        return historicalNetList;
    }




}
