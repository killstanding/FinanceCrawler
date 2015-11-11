package com.jerry.financecrawler.job;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.CommonsUrl;
import com.jerry.financecrawler.db.dao.IEastFinanceDao;
import com.jerry.financecrawler.db.po.EastFinancePo;
import com.jerry.financecrawler.translate.JsonToEastOBject;
import com.jerry.financecrawler.visitor.HtmlRequest;
import com.jerry.financecrawler.vo.EastFinanceTotalVo;
import com.jerry.financecrawler.vo.EastFinanceVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jerry on 2015/9/17.
 */
public class EastFinanceJob implements QuartzJob {
    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(EastFinanceJob.class);

    private static final String baseUrl = CommonsUrl.EAST_FINANCE_URL;

    private static final String charset = CommonsCharset.GB2312;

    @Resource
    private HtmlRequest htmlRequest;

    @Resource
    private JsonToEastOBject jsonToEastOBject;
    @Resource
    private IEastFinanceDao eastFinanceDao;

    @Override
    public void execute() {
        try {
            int index = 1;
            int pageNum = 30;
            EastFinanceTotalVo eastFinanceTotalVo = getHtmlData(index, pageNum, 0);
            int allPages = eastFinanceTotalVo.getAllPages();
            index++;
            while (index <= allPages) {
                getHtmlData(index, pageNum, allPages);
                index++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error " + this.getClass().getName() + "dealing EastFinance data", ex);
        }
    }

    private EastFinanceTotalVo getHtmlData(int index, int pageNum, int allpages) throws Exception {
        String url = CommonsUrl.getUrl(baseUrl, index, pageNum, 0);
        String data = htmlRequest.getHtmlData(url, charset);
        EastFinanceTotalVo eastFinanceTotalVo = null;
        if (!data.equals("")) {
            data = data.substring(data.indexOf("=") + 1, data.length());
            eastFinanceTotalVo = jsonToEastOBject.parseToEastFinanceData(data);
            // System.out.println("eastFinanceTotalVo = ["+eastFinanceTotalVo.toString()+"]");
            List<EastFinanceVo> eastFinanceVoList = eastFinanceTotalVo.getDatas();
            saveEastFinanceData(eastFinanceVoList);
        }
        return eastFinanceTotalVo;
    }

    private void saveEastFinanceData(List<EastFinanceVo> eastFinanceVoList) {
        if (eastFinanceVoList != null) {
            for (int i = 0; i < eastFinanceVoList.size(); i++) {
                EastFinanceVo midVo = eastFinanceVoList.get(i);
                EastFinancePo midPo = changeToPo(midVo);
                String id = midPo.getId();
                if (eastFinanceDao.find(id) != null) {
                    eastFinanceDao.modify(midPo);
                } else {
                    eastFinanceDao.save(midPo);
                }

            }
        }
    }

    private EastFinancePo changeToPo(EastFinanceVo vo) {
        EastFinancePo eastFinancePo = new EastFinancePo();
        eastFinancePo.setId(vo.getId());
        eastFinancePo.setFINCODE(vo.getFINCODE());
        eastFinancePo.setFULLNAME(vo.getFULLNAME());
        eastFinancePo.setSHORTNAME(vo.getSHORTNAME());
        eastFinancePo.setESTABDATE(vo.getESTABDATE());
        eastFinancePo.setMANAGERCODE(vo.getMANAGERCODE());
        eastFinancePo.setMANAGER(vo.getMANAGER());
        eastFinancePo.setSMANAGER(vo.getSMANAGER());
        eastFinancePo.setTRUSTEECODE(vo.getTRUSTEECODE());
        eastFinancePo.setTRUSTEE(vo.getTRUSTEE());
        eastFinancePo.setSTRUSTEE(vo.getSTRUSTEE());
        eastFinancePo.setSCUSTDN(vo.getSCUSTDN());
        eastFinancePo.setMGRNAME(vo.getMGRNAME());
        eastFinancePo.setPDATE(vo.getPDATE());
        eastFinancePo.setNAV(vo.getNAV());
        eastFinancePo.setACCNAV(vo.getACCNAV());
        eastFinancePo.setHY(vo.getHY());
        eastFinancePo.setY(vo.getY());
        eastFinancePo.setTWY(vo.getTWY());
        eastFinancePo.setSY(vo.getSY());
        return eastFinancePo;
    }
}
