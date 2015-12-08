package com.jerry.financecrawler.job.licai;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.translate.licai.HtmlToLiCaiDetailVo;
import com.jerry.financecrawler.visitor.HtmlRequest;
import com.jerry.financecrawler.vo.FundProductVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jerry on 2015/9/17.
 */
@Component
public class LiCaiDetailJob {
    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(LiCaiDetailJob.class);

    private static final String baseUrl = CommonsUrl.LI_CAI_BASE_URL;

    private static final String charset = CommonsCharset.GB2312;

    @Resource
    private HtmlRequest htmlRequest;

    @Resource
    private HtmlToLiCaiDetailVo htmlToLiCaiDetailVo;

    public void execute(List<FundProductVo> fundProductVoList) {
        log.info("LiCai 详情采集服务启动");
        if (fundProductVoList != null) {
            for (int i = 0; i < fundProductVoList.size(); i++) {
                FundProductVo fundProductVo = fundProductVoList.get(i);
                String fincode = fundProductVo.getFincode();
                try {

                    getHtmlData(fincode, fundProductVo);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    log.error("dealing LiCaiDetailJob data", ex);
                }
            }
        }

        log.info("LiCai 详情采集服务完成");
    }

    private void getHtmlData(String fincode, FundProductVo fundProductVo) throws Exception {
        String url = baseUrl + fincode;
        String data = htmlRequest.getHtmlData(url, charset);
        if (!data.equals("")) {

            htmlToLiCaiDetailVo.HtmlToLiCaiDetail(data, fundProductVo);

        }
    }


}
