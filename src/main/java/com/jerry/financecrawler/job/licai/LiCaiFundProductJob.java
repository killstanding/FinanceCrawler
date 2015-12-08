package com.jerry.financecrawler.job.licai;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.db.po.FundProductPo;
import com.jerry.financecrawler.job.QuartzJob;
import com.jerry.financecrawler.save.SaveData;
import com.jerry.financecrawler.translate.licai.HtmlToLiCaiFundProductVo;
import com.jerry.financecrawler.visitor.HtmlRequest;
import com.jerry.financecrawler.vo.FundProductVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jerry on 2015/9/17.
 */
public class LiCaiFundProductJob implements QuartzJob {
    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(LiCaiFundProductJob.class);

    private static final String baseUrl = CommonsUrl.LI_CAI_URL;

    private static final String charset = CommonsCharset.GB2312;

    @Resource
    private HtmlRequest htmlRequest;

    @Resource
    private HtmlToLiCaiFundProductVo htmlToLiCaiFundProductVo;
    @Resource
    private SaveData saveData;
    @Resource
    private LiCaiHistoricalNetJob liCaiHistoricalNetJob;
    @Resource
    private LiCaiDetailJob liCaiDetailJob;

    @Override
    public void execute() {
        log.info("LiCai 采集服务启动");
        List<FundProductVo> fundProductVoList = null;
        try {
            fundProductVoList = getHtmlData();
            if (fundProductVoList != null) {
                //补全产品数据detail
                liCaiDetailJob.execute(fundProductVoList);
                //保存产品数据
                List<FundProductPo> fundProductPoList = saveData.saveFundProductData(fundProductVoList);
                //采集历史净值
                liCaiHistoricalNetJob.execute(fundProductPoList);
            }

        } catch (Exception ex) {
            log.error("dealing LiCaiJob data", ex);
            ex.printStackTrace();
        }

        log.info("LiCai 采集服务完成");
    }

    private List<FundProductVo> getHtmlData() throws Exception {
        String url = baseUrl;
        String html = htmlRequest.getHtmlData(url, charset);
        List<FundProductVo> fundProductVoList = null;
        if (!html.equals("")) {
            fundProductVoList = htmlToLiCaiFundProductVo.parseToFundProductData(html);
        }
        return fundProductVoList;
    }

}
