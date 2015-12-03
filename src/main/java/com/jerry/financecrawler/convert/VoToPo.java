package com.jerry.financecrawler.convert;

import com.jerry.financecrawler.db.po.*;
import com.jerry.financecrawler.vo.*;

/**
 * Created by Jerry on 15/11/19.
 */
public class VoToPo {

    //产品
    public static FundProductPo fundProductVoToPo(FundProductVo vo) {
        //产品
        FundProductPo po = new FundProductPo();
        po.setId(vo.getId());
        po.setFincode(vo.getFincode());
        po.setProduct_name(vo.getProduct_name()); //产品名称
        po.setProduct_shortname(vo.getProduct_shortname());//产品简称
        po.setProduct_code(vo.getProduct_code());//产品代码
        po.setIsactice(vo.getIsactice());//产品状态
        po.setSupplier_code(vo.getSupplier_code());//基金发行人
        po.setProduct_nature(vo.getProduct_nature()); //基金性质
        po.setProduct_bank(vo.getProduct_bank());  //托管行
        po.setProduct_COOPERATIVE_SECURITIES_INSTITUTION(vo.getProduct_COOPERATIVE_SECURITIES_INSTITUTION());   //合作证券机构
        po.setProduct_COOPERATIVE_FUTURES_AGENCY(vo.getProduct_COOPERATIVE_FUTURES_AGENCY()); //合作期货机构
        po.setProduct_ESTABLISHMENT_DATE(vo.getProduct_ESTABLISHMENT_DATE()); //   date 成立日期
        po.setProduct_DURATION_YEAR(vo.getProduct_DURATION_YEAR());    //存续期间(年)
        po.setProduct_DURATION_EXISTENCE_YEAR(vo.getProduct_DURATION_EXISTENCE_YEAR());  //存续期限(年)
        po.setProduct_TERMINATION_CONTION(vo.getProduct_TERMINATION_CONTION());  //终止条件
        po.setProduct_TYPE(vo.getProduct_TYPE());   //基金类型
        po.setProduct_INVESTMENT_TYPE(vo.getProduct_INVESTMENT_TYPE());   //投资类型
        po.setProduct_INVESTMENT_TYPE_DETAIL(vo.getProduct_INVESTMENT_TYPE_DETAIL());   //投资类型细分
        po.setProduct_info(vo.getProduct_info());    // 产品信息
        po.setProduct_INVESTMENT_TARGETS(vo.getProduct_INVESTMENT_TARGETS());   //投资标的
        po.setProduct_INVESTMENT_RATIO(vo.getProduct_INVESTMENT_RATIO());    //投资比例
        po.setProduct_EXPECTED_RETURN(vo.getProduct_EXPECTED_RETURN());  //预期收益
        po.setProduct_HEDGE_RATIO(vo.getProduct_HEDGE_RATIO());    //对冲比例
        po.setProduct_INVESTMENT_THRESHOLD(vo.getProduct_INVESTMENT_THRESHOLD());    //投资门槛（万）
        po.setProduct_ADDITIONAL_AMOUNT(vo.getProduct_ADDITIONAL_AMOUNT());   //追加金额（万）
        po.setProduct_OPEN_PERIOD(vo.getProduct_OPEN_PERIOD());    //开放期
        po.setProduct_OPEN_FREQUENCY(vo.getProduct_OPEN_FREQUENCY());   //开放频度
        po.setProduct_CLOSURE_PERIOD(vo.getProduct_CLOSURE_PERIOD());    //封闭期(天)（转换下）
        po.setProduct_EARLY_WARNING_LINE(vo.getProduct_EARLY_WARNING_LINE());    //预警线
        po.setProduct_STOP_LINE(vo.getProduct_STOP_LINE());    //止损线
        po.setProduct_CLASSIFICATON(vo.getProduct_CLASSIFICATON());    //是否分级 0 否 1 是
        po.setProduct_GRADING_SCALE(vo.getProduct_GRADING_SCALE());    //分级比例
        po.setProduct_OTHERS(vo.getProduct_OTHERS()); //其他说明
        po.setProduct_price(vo.getProduct_price());   //产品价格
        po.setCreatedate(vo.getCreatedate());    //datetime
        po.setProductcategory_code(vo.getProductcategory_code());  //产品分类代码
        po.setProduct_image_url(vo.getProduct_image_url());    //图片url
        po.setProduct_is_crawler(1); //是否为爬取 1 是 0 不是
        return po;
    }

    //收益
    public static IncomePo incomeVoToPo(IncomeVo vo) {
        IncomePo po = new IncomePo();
        po.setProduct_id(vo.getProduct_id());
        po.setI_UPDATE_DATE(vo.getI_UPDATE_DATE());// date 更新时间
        po.setI_LATEST_NET_WORTH(vo.getI_LATEST_NET_WORTH());// 最新净值
        po.setI_SINCE_THIS_YEAR(vo.getI_SINCE_THIS_YEAR());// 今年以来
        po.setI_NEARLY_A_MONTH(vo.getI_NEARLY_A_MONTH());// 近一月
        po.setI_NEARLY_THREE_MONTHS(vo.getI_NEARLY_THREE_MONTHS());// 近三月
        po.setI_NEARLY_HALF_A_YEAR(vo.getI_NEARLY_HALF_A_YEAR());//近半年
        po.setI_NEARLY_A_YEAR(vo.getI_NEARLY_A_YEAR());// 近一年
        po.setI_NEARLY_TWO_YEARS(vo.getI_NEARLY_TWO_YEARS());//近两年
        po.setI_NEARLY_THREE_YEARS(vo.getI_NEARLY_THREE_YEARS());//近三年
        po.setI_NEARLY_FIVE_YEARS(vo.getI_NEARLY_FIVE_YEARS());//近5年
        po.setI_SINCE_ITS_ESTABLISHMENT(vo.getI_SINCE_ITS_ESTABLISHMENT());//成立以来
        return po;
    }

    //历史净值
    public static HistoricalNetPo historicalNetVoToPo(HistoricalNetVo vo) {
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

    //年化波动率
    public static AnnualFluctuationRatePo annualFluctuationRateVoToPo(AnnualFluctuationRateVo vo) {
        AnnualFluctuationRatePo po = new AnnualFluctuationRatePo();
        po.setProduct_id(vo.getProduct_id());
        po.setFR_NEARLY_A_YEAR(vo.getFR_NEARLY_A_YEAR());//近一年
        po.setFR_NEARLY_TWO_YEARS(vo.getFR_NEARLY_TWO_YEARS());//近两年
        po.setFR_NEARLY_THREE_YEARS(vo.getFR_NEARLY_THREE_YEARS());//近三年
        po.setFR_NEARLY_FIVE_YEARS(vo.getFR_NEARLY_FIVE_YEARS());//近5年
        po.setFR_SINCE_ITS_ESTABLISHMENT(vo.getFR_SINCE_ITS_ESTABLISHMENT());//成立以来
        po.setFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS(vo.getFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS());//最多连续盈利天数
        po.setFR_MAXIMUM_CONTINUOUS_LOSS_DAYS(vo.getFR_MAXIMUM_CONTINUOUS_LOSS_DAYS());//最多连续亏损天数
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }

    //年化收益率
    public static AnnualizedReturnRatePo annualizedReturnRateVoToPo(AnnualizedReturnRateVo vo) {
        AnnualizedReturnRatePo po = new AnnualizedReturnRatePo();
        po.setProduct_id(vo.getProduct_id());
        po.setRR_NEARLY_A_YEAR(vo.getRR_NEARLY_A_YEAR());//近一年
        po.setRR_NEARLY_TWO_YEARS(vo.getRR_NEARLY_TWO_YEARS());//近两年
        po.setRR_NEARLY_THREE_YEARS(vo.getRR_NEARLY_THREE_YEARS());//近三年
        po.setRR_NEARLY_FIVE_YEARS(vo.getRR_NEARLY_FIVE_YEARS());//近5年
        po.setRR_SINCE_ITS_ESTABLISHMENT(vo.getRR_SINCE_ITS_ESTABLISHMENT());//成立以来
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }

    //CALMAR比率
    public static CalmarRatioPo calmarRatioVoToPo(CalmarRatioVo vo) {
        CalmarRatioPo po = new CalmarRatioPo();
        po.setProduct_id(vo.getProduct_id());
        po.setCR_NEARLY_A_YEAR(vo.getCR_NEARLY_A_YEAR());//近一年
        po.setCR_NEARLY_TWO_YEARS(vo.getCR_NEARLY_TWO_YEARS());//近两年
        po.setCR_NEARLY_THREE_YEARS(vo.getCR_NEARLY_THREE_YEARS());//近三年
        po.setCR_NEARLY_FIVE_YEARS(vo.getCR_NEARLY_FIVE_YEARS());//近5年
        po.setCR_SINCE_ITS_ESTABLISHMENT(vo.getCR_SINCE_ITS_ESTABLISHMENT());//成立以来
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }

    //费用费率
    public static CostRatePo CostRateVoToPo(CostRateVo vo) {
        CostRatePo po = new CostRatePo();
        po.setProduct_id(vo.getProduct_id());
        po.setCR_SUBSCRIPTION_RATE(vo.getCR_SUBSCRIPTION_RATE());//认购费率
        po.setCR_REDEMPTION_RATE(vo.getCR_REDEMPTION_RATE());//赎回费
        po.setCR_MANAGEMENT_RATE(vo.getCR_MANAGEMENT_RATE());//管理费
        po.setCR_HOSTING_RATE(vo.getCR_HOSTING_RATE());//托管费
        po.setCR_PERFORMANCE_PAY_RATE(vo.getCR_PERFORMANCE_PAY_RATE());//业绩报酬
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }


    //管理人
    public static FundManagePeoplePo fundManagePeopleVoToPo(FundManagePeopleVo vo) {
        FundManagePeoplePo po = new FundManagePeoplePo();
        po.setId(vo.getId());
        po.setFund_name(vo.getFund_name());//基金管理人
        po.setFund_date(vo.getFund_date());//成立时间
        po.setFund_assets(vo.getFund_assets());//管理人管理资产
        po.setFund_product_no(vo.getFund_product_no());//管理人管理产品
        po.setFund_count(vo.getFund_count());//投研人数
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }

    //基金经理
    public static FundManagerPo fundManagerVoToPo(FundManagerVo vo) {
        FundManagerPo po = new FundManagerPo();
        po.setFundmanager_id(vo.getFundmanager_id());
        po.setID(vo.getID());
        po.setBS_NAME(vo.getBS_NAME());//基金经理
        po.setBS_FUND_MANAGEMENT_START_DATE(vo.getBS_FUND_MANAGEMENT_START_DATE());//基金起始管理日期
        po.setBS_FUND_MANAGEMENT_END_DATE(vo.getBS_FUND_MANAGEMENT_END_DATE());//基金结束管理日期
        po.setBS_MANAGEMENT_FUND_NUM(vo.getBS_MANAGEMENT_FUND_NUM());//管理基金数
        po.setBS_HISTORICAL_MANANGEMENT_FUND_NUM(vo.getBS_HISTORICAL_MANANGEMENT_FUND_NUM());//历史管理基金
        po.setBS_UNIVERSITY(vo.getBS_UNIVERSITY());//毕业院校
        po.setBS_EDUCATION(vo.getBS_EDUCATION());//学历
        po.setBS_PROFESSIONAL(vo.getBS_PROFESSIONAL());//专业
        po.setBS_WORKING_TIME(vo.getBS_WORKING_TIME());//从业时间
        po.setBS_WORKING_YEAR(vo.getBS_WORKING_YEAR());//从业年限
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }

    //收益排名
    public static IncomeRankingPo incomeRankingVoToPo(IncomeRankingVo vo) {
        IncomeRankingPo po = new IncomeRankingPo();
        po.setProduct_id(vo.getProduct_id());
        po.setIR_SINCE_THIS_YEAR(vo.getIR_SINCE_THIS_YEAR());// 今年以来
        po.setIR_NEARLY_A_MONTH(vo.getIR_NEARLY_A_MONTH());// 近一月
        po.setIR_NEARLY_THREE_MONTHS(vo.getIR_NEARLY_THREE_MONTHS());// 近三月
        po.setIR_NEARLY_HALF_A_YEAR(vo.getIR_NEARLY_HALF_A_YEAR());//近半年
        po.setIR_NEARLY_A_YEAR(vo.getIR_NEARLY_A_YEAR());// 近一年
        po.setIR_NEARLY_TWO_YEARS(vo.getIR_NEARLY_TWO_YEARS());//近两年
        po.setIR_NEARLY_THREE_YEARS(vo.getIR_NEARLY_THREE_YEARS());//近三年
        po.setIR_NEARLY_FIVE_YEARS(vo.getIR_NEARLY_FIVE_YEARS());//近5年
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }

    //最大回撤
    public static MaximumReturnPo maximumReturnVoToPo(MaximumReturnVo vo) {
        MaximumReturnPo po = new MaximumReturnPo();
        po.setProduct_id(vo.getProduct_id());
        po.setMR_NEARLY_A_YEAR(vo.getMR_NEARLY_A_YEAR());//近一年
        po.setMR_NEARLY_TWO_YEARS(vo.getMR_NEARLY_TWO_YEARS());//近两年
        po.setMR_NEARLY_THREE_YEARS(vo.getMR_NEARLY_THREE_YEARS());//近三年
        po.setMR_NEARLY_FIVE_YEARS(vo.getMR_NEARLY_FIVE_YEARS());//近5年
        po.setMR_SINCE_ITS_ESTABLISHMENT(vo.getMR_SINCE_ITS_ESTABLISHMENT());//成立以来
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }

    //夏普比率
    public static SharpRatioPo sharpRatioVoToPo(SharpRatioVo vo) {
        SharpRatioPo po = new SharpRatioPo();
        po.setProduct_id(vo.getProduct_id());
        po.setSR_NEARLY_A_YEAR(vo.getSR_NEARLY_A_YEAR());//近一年
        po.setSR_NEARLY_TWO_YEARS(vo.getSR_NEARLY_TWO_YEARS());//近两年
        po.setSR_NEARLY_THREE_YEARS(vo.getSR_NEARLY_THREE_YEARS());//近三年
        po.setSR_NEARLY_FIVE_YEARS(vo.getSR_NEARLY_FIVE_YEARS());//近5年
        po.setSR_SINCE_ITS_ESTABLISHMENT(vo.getSR_SINCE_ITS_ESTABLISHMENT());//成立以来
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }

    //Sterling比率
    public static SterlingRatioPo sterlingRatioVoToPo(SterlingRatioVo vo) {
        SterlingRatioPo po = new SterlingRatioPo();
        po.setProduct_id(vo.getProduct_id());
        po.setSR_NEARLY_A_YEAR(vo.getSR_NEARLY_A_YEAR());//近一年
        po.setSR_NEARLY_TWO_YEARS(vo.getSR_NEARLY_TWO_YEARS());//近两年
        po.setSR_NEARLY_THREE_YEARS(vo.getSR_NEARLY_THREE_YEARS());//近三年
        po.setSR_NEARLY_FIVE_YEARS(vo.getSR_NEARLY_FIVE_YEARS());//近5年
        po.setSR_SINCE_ITS_ESTABLISHMENT(vo.getSR_SINCE_ITS_ESTABLISHMENT());//成立以来
        po.setProduct_is_crawler(vo.getProduct_is_crawler());//是否为爬取 1 是 0 不是
        return po;
    }

}
