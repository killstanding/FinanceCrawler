package com.jerry.financecrawler.save;

import com.jerry.financecrawler.commons.ProductFilter;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.convert.SetValue;
import com.jerry.financecrawler.convert.VoToPo;
import com.jerry.financecrawler.db.dao.*;
import com.jerry.financecrawler.db.po.*;
import com.jerry.financecrawler.vo.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 15/11/24.
 */
@Component
public class SaveData {
    @Resource
    private IIncome incomeDao;
    @Resource
    private IFundProduct fundProductDao;
    @Resource
    private IHistoricalNet historicalNetDao;
    @Resource
    private IAnnualFluctuationRate annualFluctuationRateDao;
    @Resource
    private IAnnualizedReturnRate annualizedReturnRateDao;
    @Resource
    private IMaximumReturn maximumReturnDao;
    @Resource
    private ISharpRatio sharpRatioDao;
    @Resource
    private ICalmarRatio calmarRatioDao;
    @Resource
    private ISterlingRatio sterlingRatioDao;
    @Resource
    private IncomeRankingDao incomeRankingDao;
    @Resource
    private HSDao hsDao;

    public List<FundProductPo> saveFundProductData(List<FundProductVo> fundProductVoList) throws Exception{
        List<FundProductPo> result = new ArrayList<FundProductPo>();
        if (fundProductVoList != null) {
            List<FundProductVo> noExistVos = new ArrayList<FundProductVo>();
            Integer maxId = fundProductDao.getMaxId();
            if (maxId == null) maxId = 0;
            for (int i = 0; i < fundProductVoList.size(); i++) {
                FundProductVo midVo = fundProductVoList.get(i);
                String product_name = midVo.getProduct_name();
                String product_code = midVo.getProduct_code();
                String product_type = midVo.getProduct_TYPE();
                if (ProductFilter.filter(product_type, product_name)) {
                    FundProductPo basePo = fundProductDao.findByCodeOrName(product_code, product_name);
                    if (basePo != null) {
                        SetValue.setFundProductPoValue(basePo, midVo);
                        fundProductDao.modify(basePo);
                        result.add(basePo);
                        //System.out.println("basePo = [" + basePo + "]");
                        // 收益
                        saveIncomeData(midVo.getIncomeVo(), basePo.getId());
                    } else {
                        noExistVos.add(midVo);
                    }//if  else

                }//if
            }// for
            // 保存不存在数据
            for (int i = 0; i < noExistVos.size(); i++) {
                //产品
                FundProductVo midVo = noExistVos.get(i);
                FundProductPo midPo = changeToPo(midVo);
                midPo.setId(maxId + i + 1);
                fundProductDao.save(midPo);
                result.add(midPo);
                // 收益
                IncomePo incomePo =midPo.getIncomePo();
                incomePo.setProduct_id(midPo.getId());
                incomeDao.save(incomePo);
            }//for

        }// if
        return result;
    }

    private FundProductPo changeToPo(FundProductVo vo) {
        //产品
        FundProductPo po = VoToPo.fundProductVoToPo(vo);

        //收益
        IncomeVo incomeVo = vo.getIncomeVo();
        IncomePo incomePo = VoToPo.incomeVoToPo(incomeVo);
        po.setIncomePo(incomePo);
        return po;
    }

    public void saveHistoricalNetData(List<HistoricalNetVo> historicalNetList) {
        if (historicalNetList != null) {
            Integer maxId = historicalNetDao.getMaxId();
            if(maxId == null) maxId = 0;
            for (int i = 0; i < historicalNetList.size(); i++) {
                HistoricalNetVo midVo = historicalNetList.get(i);
                HistoricalNetPo midPo = VoToPo.historicalNetVoToPo(midVo);
                int product_id = midPo.getProduct_id();
                String net_worth_date = midPo.getNet_worth_date();
                if (historicalNetDao.findByProductIDAndDate(product_id, net_worth_date) == null) {
                    if (midPo.getNet_worth_date() != null && !midPo.getNet_worth_date().equals("")) {
                        midPo.setId(maxId + i + 1);
                        historicalNetDao.save(midPo);
                    }//if
                }//if
            }//for
        }//if
    }

    public void updateHistoricalNetInIncome(int product_id){
        HistoricalNetPo latestPo =  historicalNetDao.findLatestPo(product_id);
        IncomePo incomePo = incomeDao.find(product_id);
        incomePo.setI_LATEST_NET_WORTH(latestPo.getUnit_net_worth());
        incomePo.setI_UPDATE_DATE(latestPo.getNet_worth_date());
        incomeDao.modify(incomePo);
    }

    public void saveFundProductData(FundProductVo vo, int id) throws Exception {
        String product_name = vo.getProduct_name();
        String product_code = vo.getProduct_code();
        FundProductPo po = fundProductDao.findByCodeOrName(product_code, product_name);
        if (po != null) {
            SetValue.setFundProductPoValue(po, vo);
            fundProductDao.modify(po);
        } else {
            po = VoToPo.fundProductVoToPo(vo);
            po.setId(id);
            fundProductDao.save(po);
        }//if  else

    }

    //收益
    public void saveIncomeData(IncomeVo vo, int product_id) throws Exception {
        IncomePo po = incomeDao.find(product_id);
        if (po != null) {
            SetValue.setIncomePoValue(po, vo);
            incomeDao.modify(po);
        } else {
            po = VoToPo.incomeVoToPo(vo);
            po.setProduct_id(product_id);
            incomeDao.save(po);
        }
    }

    //年化收益率
    public void saveAnnualizedReturnRateData(AnnualizedReturnRateVo vo, int product_id) throws Exception {
        AnnualizedReturnRatePo po = annualizedReturnRateDao.find(product_id);
        if (po != null) {
            SetValue.setAnnualizedReturnRatePoValue(po, vo);
            annualizedReturnRateDao.modify(po);
        } else {
            po = VoToPo.annualizedReturnRateVoToPo(vo);
            po.setProduct_id(product_id);
            annualizedReturnRateDao.save(po);
        }
    }

    //年化波动率
    public void saveAnnualFluctuationRateData(AnnualFluctuationRateVo vo, int product_id) throws Exception {
        AnnualFluctuationRatePo po = annualFluctuationRateDao.find(product_id);
        if (po != null) {
            SetValue.setAnnualFluctuationRatePoValue(po, vo);
            annualFluctuationRateDao.modify(po);
        } else {
            po= VoToPo.annualFluctuationRateVoToPo(vo);
            po.setProduct_id(product_id);
            annualFluctuationRateDao.save(po);
        }
    }

    //最大回撤
    public void saveMaximumReturnData(MaximumReturnVo vo, int product_id) throws Exception {
        MaximumReturnPo po = maximumReturnDao.find(product_id);
        if (po != null) {
            SetValue.setMaximumReturnPoValue(po, vo);
            maximumReturnDao.modify(po);
        } else {
            po= VoToPo.maximumReturnVoToPo(vo);
            po.setProduct_id(product_id);
            maximumReturnDao.save(po);
        }
    }

    //夏普比率
    public void saveSharpRatioData(SharpRatioVo vo, int product_id) throws Exception {
        SharpRatioPo po = sharpRatioDao.find(product_id);
        if (po != null) {
            SetValue.setSharpRatioPoValue(po, vo);
            sharpRatioDao.modify(po);
        } else {
            po= VoToPo.sharpRatioVoToPo(vo);
            po.setProduct_id(product_id);
            sharpRatioDao.save(po);
        }
    }

    //CALMAR比率
    public void saveCalmarRatioData(CalmarRatioVo vo, int product_id) throws Exception {
        CalmarRatioPo po = calmarRatioDao.find(product_id);
        if (po != null) {
            SetValue.setCalmarRatioPoValue(po, vo);
            calmarRatioDao.modify(po);
        } else {
            po= VoToPo.calmarRatioVoToPo(vo);
            po.setProduct_id(product_id);
            calmarRatioDao.save(po);
        }
    }

    //Sterling比率
    public void saveSterlingRatioData(SterlingRatioVo vo, int product_id) throws Exception {
        SterlingRatioPo po = sterlingRatioDao.find(product_id);
        if (po != null) {
            SetValue.setSterlingRatioPoValue(po, vo);
            sterlingRatioDao.modify(po);
        } else {
            po= VoToPo.sterlingRatioVoToPo(vo);
            po.setProduct_id(product_id);
            sterlingRatioDao.save(po);
        }
    }

    //Sterling比率
    public void saveIncomeRankingData(IncomeRankingVo vo, int product_id) throws Exception {
        IncomeRankingPo po = incomeRankingDao.find(product_id);
        if (po != null) {
            SetValue.setIncomeRankingPoValue(po, vo);
            incomeRankingDao.modify(po);
        } else {
            po= VoToPo.incomeRankingVoToPo(vo);
            po.setProduct_id(product_id);
            incomeRankingDao.save(po);
        }
    }

    //HS300
    public void saveHSData(List<HSVo> voList) throws Exception {
        if (voList != null) {
            Integer maxId = hsDao.getMaxId();
            if(maxId == null) maxId = 0;
            for (int i = 0; i < voList.size(); i++) {
                HSVo vo = voList.get(i);
                String date = vo.getDate();
                HSPo prePo = hsDao.findPreData(date);
                if(prePo != null) {
                    double zdf = (vo.getSpj() - prePo.getSpj())/prePo.getSpj()*100;
                    vo.setZdf(zdf);
                }
                HSPo po = hsDao.findByDate(date);
                if (po == null) {
                    po = VoToPo.hsVoToPo(vo);
                    po.setId(maxId + i + 1);
                    hsDao.save(po);
                }else{
                    SetValue.setHSPoValue(po, vo);
                    hsDao.modify(po);
                }
            }//for
        }//if
    }

    public void saveHSData(HSVo vo) throws Exception {
        String date = vo.getDate();
        HSPo prePo = hsDao.findPreData(date);
        if(prePo != null) {
            double zdf = (vo.getSpj() - prePo.getSpj())/prePo.getSpj()*100;
            vo.setZdf(zdf);
        }
        Integer maxId = hsDao.getMaxId();
        HSPo po = hsDao.findByDate(date);
        if (po == null) {
            po = VoToPo.hsVoToPo(vo);
            po.setId(maxId +  1);
            hsDao.save(po);
        }else{
            SetValue.setHSPoValue(po, vo);
            hsDao.modify(po);
        }
    }

}
