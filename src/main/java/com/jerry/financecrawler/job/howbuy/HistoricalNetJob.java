package com.jerry.financecrawler.job.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.db.dao.IFundProductDao;
import com.jerry.financecrawler.db.dao.IHistoricalNetDao;
import com.jerry.financecrawler.db.po.FundProductPo;
import com.jerry.financecrawler.db.po.HistoricalNetPo;
import com.jerry.financecrawler.job.QuartzJob;
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
    private IFundProductDao fundProductDao;
    @Resource
    private IHistoricalNetDao historicalNetDao;

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
                    historicalNetList = getHtmlData(product_id, product_code);
                } catch (Exception ex) {
                    log.error("Error " + this.getClass().getName() + "dealing HowBuyHistoricalNetJob data", ex);
                    ex.printStackTrace();
                }
                saveHistoricalNetData(historicalNetList);
            }
        }
        log.info("howbuy 历史净值采集服务完成");
    }

    private List<HistoricalNetVo> getHtmlData(int product_id, String product_code) throws Exception {
        String url = CommonsUrl.getHowBuyHistoricalNet(baseUrl, product_code);
        String html = htmlRequest.getHtmlData(url, charset);
        List<HistoricalNetVo> historicalNetList = null;
        if (!html.equals("")) {
            historicalNetList = htmlToHistoricalNetVo.parseToHistoricalNetData(html, product_id, product_code);
        }
        return historicalNetList;
    }

    private void saveHistoricalNetData(List<HistoricalNetVo> historicalNetList) {
        if (historicalNetList != null) {
            int maxId = historicalNetDao.getMaxId();
            for (int i = 0; i < historicalNetList.size(); i++) {
                HistoricalNetVo midVo = historicalNetList.get(i);
                HistoricalNetPo midPo = changeToPo(midVo);
                String product_code = midPo.getProduct_code();
                String net_worth_date = midPo.getNet_worth_date();
                if (historicalNetDao.findByProductIDAndDate(product_code, net_worth_date) == null) {
                    midPo.setId(maxId + i + 1);
                    historicalNetDao.save(midPo);
                }

            }
        }
    }

    private HistoricalNetPo changeToPo(HistoricalNetVo vo) {
        HistoricalNetPo po = new HistoricalNetPo();
        po.setId(vo.getId());
        po.setProduct_id(vo.getProduct_id()); //产品id-唯一值
        po.setProduct_code(vo.getProduct_code());//产品代码
        po.setNet_worth_date(vo.getNet_worth_date());//date 净值日期
        po.setUnit_net_worth(vo.getUnit_net_worth());//单位净值
        po.setAdd_net_worth(vo.getAdd_net_worth()); //累计净值
        po.setChg(vo.getChg());//涨跌幅
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }
}
