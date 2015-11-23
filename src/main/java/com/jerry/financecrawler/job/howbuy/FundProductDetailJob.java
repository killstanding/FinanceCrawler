package com.jerry.financecrawler.job.howbuy;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.convert.PoToVo;
import com.jerry.financecrawler.db.dao.IFundProduct;
import com.jerry.financecrawler.db.po.FundProductPo;
import com.jerry.financecrawler.job.QuartzJob;
import com.jerry.financecrawler.visitor.HtmlRequest;
import com.jerry.financecrawler.vo.FundProductVo;
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

    @Override
    public void execute() {
        log.info("howbuy  产品详情采集服务启动");
        List<FundProductPo> fundProductPoList = fundProductDao.findAll();
        if (fundProductPoList != null) {
            for (int i = 0; i < fundProductPoList.size(); i++) {
                FundProductPo fundProduct = fundProductPoList.get(i);
                String product_code = fundProduct.getProduct_code();
                //System.out.println("product_code = " + product_code);
                List<FundProductVo> fundProductVoList = null;
                try {
                    if (product_code != null && !product_code.equals("")) {
                        fundProductVoList = getHtmlData(fundProduct);
                    } else {
                        log.error(fundProduct.getProduct_name() + "(" + fundProduct.getProduct_shortname() + ")的 product_code为空");
                    }
                } catch (Exception ex) {
                    log.error(fundProduct.getProduct_name() + "(" + fundProduct.getProduct_shortname() + ")的 product_code = " + product_code);
                    log.error("dealing FundProductDetailJob data", ex);
                    ex.printStackTrace();
                }
                if(fundProductVoList != null) saveFundProductDetailData(fundProductVoList);
            }
        }
        log.info("howbuy 产品详情采集服务完成");
    }
    private List<FundProductVo> getHtmlData(FundProductPo po) throws Exception {
        String url = CommonsUrl.getUrlByCode(baseUrl, po.getProduct_code());
        String html = htmlRequest.getHtmlData(url, charset);
        FundProductVo fundProductVo = PoToVo.fundProductPoToVo(po);
        List<FundProductVo> historicalNetList = null;
        if (!html.equals("")) {
            //historicalNetList = htmlToHistoricalNetVo.parseToHistoricalNetData(html, product_id, product_code);
        }
        return historicalNetList;
    }
    private void saveFundProductDetailData(List<FundProductVo> fundProductVoList) {

    }

}
