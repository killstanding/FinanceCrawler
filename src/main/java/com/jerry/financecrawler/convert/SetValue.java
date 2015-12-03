package com.jerry.financecrawler.convert;

import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.db.po.*;
import com.jerry.financecrawler.vo.*;

/**
 * Created by Jerry on 15/11/19.
 */
public class SetValue {




    //产品
    public static void setFundProductPoValue(FundProductPo po, FundProductVo vo) {
        po.setFincode(vo.getFincode());
        if (StringUtil.isEmpty(po.getProduct_name()))
            po.setProduct_name(vo.getProduct_name()); //产品名称
        if (StringUtil.isEmpty(po.getProduct_shortname()))
            po.setProduct_shortname(vo.getProduct_shortname());//产品简称
        if (StringUtil.isEmpty(po.getProduct_code()))
            po.setProduct_code(vo.getProduct_code());//产品代码
        if (StringUtil.isEmpty(po.getIsactice()))
            po.setIsactice(vo.getIsactice());//产品状态
        if (StringUtil.isEmpty(po.getSupplier_code()))
            po.setSupplier_code(vo.getSupplier_code());//基金发行人
        if (StringUtil.isEmpty(po.getProduct_nature()))
            po.setProduct_nature(vo.getProduct_nature()); //基金性质
        if (StringUtil.isEmpty(po.getProduct_bank()))
            po.setProduct_bank(vo.getProduct_bank());  //托管行
        if (StringUtil.isEmpty(po.getProduct_COOPERATIVE_SECURITIES_INSTITUTION()))
            po.setProduct_COOPERATIVE_SECURITIES_INSTITUTION(vo.getProduct_COOPERATIVE_SECURITIES_INSTITUTION());   //合作证券机构
        if (StringUtil.isEmpty(po.getProduct_COOPERATIVE_FUTURES_AGENCY()))
            po.setProduct_COOPERATIVE_FUTURES_AGENCY(vo.getProduct_COOPERATIVE_FUTURES_AGENCY()); //合作期货机构
        if (StringUtil.isEmpty(po.getProduct_ESTABLISHMENT_DATE()))
            po.setProduct_ESTABLISHMENT_DATE(vo.getProduct_ESTABLISHMENT_DATE()); //   date 成立日期
        if (po.getProduct_DURATION_YEAR() == 0)
            po.setProduct_DURATION_YEAR(vo.getProduct_DURATION_YEAR());    //存续期间(年)
        if (po.getProduct_DURATION_EXISTENCE_YEAR() == 0)
            po.setProduct_DURATION_EXISTENCE_YEAR(vo.getProduct_DURATION_EXISTENCE_YEAR());  //存续期限(年)
        if (StringUtil.isEmpty(po.getProduct_TERMINATION_CONTION()))
            po.setProduct_TERMINATION_CONTION(vo.getProduct_TERMINATION_CONTION());  //终止条件
        if (StringUtil.isEmpty(po.getProduct_TYPE()))
            po.setProduct_TYPE(vo.getProduct_TYPE());   //基金类型
        if (StringUtil.isEmpty(po.getProduct_INVESTMENT_TYPE()))
            po.setProduct_INVESTMENT_TYPE(vo.getProduct_INVESTMENT_TYPE());   //投资类型
        if (StringUtil.isEmpty(po.getProduct_INVESTMENT_TYPE_DETAIL()))
            po.setProduct_INVESTMENT_TYPE_DETAIL(vo.getProduct_INVESTMENT_TYPE_DETAIL());   //投资类型细分
        if (StringUtil.isEmpty(po.getProduct_info()))
            po.setProduct_info(vo.getProduct_info());    // 产品信息
        if (StringUtil.isEmpty(po.getProduct_INVESTMENT_TARGETS()))
            po.setProduct_INVESTMENT_TARGETS(vo.getProduct_INVESTMENT_TARGETS());   //投资标的
        if (StringUtil.isEmpty(po.getProduct_INVESTMENT_RATIO()))
            po.setProduct_INVESTMENT_RATIO(vo.getProduct_INVESTMENT_RATIO());    //投资比例
        if (po.getProduct_EXPECTED_RETURN() == 0.0)
            po.setProduct_EXPECTED_RETURN(vo.getProduct_EXPECTED_RETURN());  //预期收益
        if (po.getProduct_HEDGE_RATIO() == 0.0)
            po.setProduct_HEDGE_RATIO(vo.getProduct_HEDGE_RATIO());    //对冲比例
        if (po.getProduct_INVESTMENT_THRESHOLD() == 0)
            po.setProduct_INVESTMENT_THRESHOLD(vo.getProduct_INVESTMENT_THRESHOLD());    //投资门槛（万）
        if (po.getProduct_ADDITIONAL_AMOUNT() == 0)
            po.setProduct_ADDITIONAL_AMOUNT(vo.getProduct_ADDITIONAL_AMOUNT());   //追加金额（万）
        if (StringUtil.isEmpty(po.getProduct_OPEN_PERIOD()))
            po.setProduct_OPEN_PERIOD(vo.getProduct_OPEN_PERIOD());    //开放期
        if (StringUtil.isEmpty(po.getProduct_OPEN_FREQUENCY()))
            po.setProduct_OPEN_FREQUENCY(vo.getProduct_OPEN_FREQUENCY());   //开放频度
        if (po.getProduct_CLOSURE_PERIOD() == 0)
            po.setProduct_CLOSURE_PERIOD(vo.getProduct_CLOSURE_PERIOD());    //封闭期(天)（转换下）
        if (po.getProduct_EARLY_WARNING_LINE() == 0.0)
            po.setProduct_EARLY_WARNING_LINE(vo.getProduct_EARLY_WARNING_LINE());    //预警线
        if (po.getProduct_STOP_LINE() == 0.0) po.setProduct_STOP_LINE(vo.getProduct_STOP_LINE());    //止损线
        if (StringUtil.isEmpty(po.getProduct_CLASSIFICATON()))
            po.setProduct_CLASSIFICATON(vo.getProduct_CLASSIFICATON());    //是否分级 0 否 1 是
        if (StringUtil.isEmpty(po.getProduct_GRADING_SCALE()))
            po.setProduct_GRADING_SCALE(vo.getProduct_GRADING_SCALE());    //分级比例
        if (StringUtil.isEmpty(po.getProduct_OTHERS()))
            po.setProduct_OTHERS(vo.getProduct_OTHERS()); //其他说明
        if (po.getProduct_price() == 0.0) po.setProduct_price(vo.getProduct_price());   //产品价格
        if (StringUtil.isEmpty(po.getCreatedate()))
            po.setCreatedate(vo.getCreatedate());    //datetime
        if (StringUtil.isEmpty(po.getProductcategory_code()))
            po.setProductcategory_code(vo.getProductcategory_code());  //产品分类代码
        if (StringUtil.isEmpty(po.getProduct_image_url()))
            po.setProduct_image_url(vo.getProduct_image_url());    //图片url
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是

    }

    //收益
    public static void setIncomePoValue(IncomePo po, IncomeVo vo) {

        if (StringUtil.isEmpty(po.getI_UPDATE_DATE()) || !StringUtil.isEmpty(vo.getI_UPDATE_DATE()) ) {
            if (StringUtil.isEmpty(vo.getI_UPDATE_DATE())) {
                po.setI_UPDATE_DATE("");
            } else {
                po.setI_UPDATE_DATE(vo.getI_UPDATE_DATE());
            }

        }
        if (po.getI_LATEST_NET_WORTH() == 0 || vo.getI_LATEST_NET_WORTH() != 0)
            po.setI_LATEST_NET_WORTH(vo.getI_LATEST_NET_WORTH());// 最新净值
        if (po.getI_SINCE_THIS_YEAR() == 0 || vo.getI_SINCE_THIS_YEAR() != 0)
            po.setI_SINCE_THIS_YEAR(vo.getI_SINCE_THIS_YEAR());// 今年以来
        if (po.getI_NEARLY_A_MONTH() == 0 || vo.getI_NEARLY_A_MONTH() != 0)
            po.setI_NEARLY_A_MONTH(vo.getI_NEARLY_A_MONTH());// 近一月
        if (po.getI_NEARLY_THREE_MONTHS() == 0 || vo.getI_NEARLY_THREE_MONTHS() != 0)
            po.setI_NEARLY_THREE_MONTHS(vo.getI_NEARLY_THREE_MONTHS());// 近三月
        if (po.getI_NEARLY_HALF_A_YEAR() == 0 || vo.getI_NEARLY_HALF_A_YEAR() != 0)
            po.setI_NEARLY_HALF_A_YEAR(vo.getI_NEARLY_HALF_A_YEAR());//近半年
        if (po.getI_NEARLY_A_YEAR() == 0 || vo.getI_NEARLY_A_YEAR() != 0)
            po.setI_NEARLY_A_YEAR(vo.getI_NEARLY_A_YEAR());// 近一年
        if (po.getI_NEARLY_TWO_YEARS() == 0 || vo.getI_NEARLY_TWO_YEARS() != 0)
            po.setI_NEARLY_TWO_YEARS(vo.getI_NEARLY_TWO_YEARS());//近两年
        if (po.getI_NEARLY_THREE_YEARS() == 0 || vo.getI_NEARLY_THREE_YEARS() != 0)
            po.setI_NEARLY_THREE_YEARS(vo.getI_NEARLY_THREE_YEARS());//近三年
        if (po.getI_NEARLY_FIVE_YEARS() == 0 || vo.getI_NEARLY_FIVE_YEARS() != 0)
            po.setI_NEARLY_FIVE_YEARS(vo.getI_NEARLY_FIVE_YEARS());//近5年
        if (po.getI_SINCE_ITS_ESTABLISHMENT() == 0 || vo.getI_SINCE_ITS_ESTABLISHMENT() != 0)
            po.setI_SINCE_ITS_ESTABLISHMENT(vo.getI_SINCE_ITS_ESTABLISHMENT());//成立以来
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }

    //年化波动率
    public static void setAnnualFluctuationRatePoValue(AnnualFluctuationRatePo po, AnnualFluctuationRateVo vo) {
        if (po.getFR_NEARLY_A_YEAR() == 0 || vo.getFR_NEARLY_A_YEAR() != 0)
            po.setFR_NEARLY_A_YEAR(vo.getFR_NEARLY_A_YEAR());//近一年
        if (po.getFR_NEARLY_TWO_YEARS() == 0 || vo.getFR_NEARLY_TWO_YEARS() != 0)
            po.setFR_NEARLY_TWO_YEARS(vo.getFR_NEARLY_TWO_YEARS());//近两年
        if (po.getFR_NEARLY_THREE_YEARS() == 0 || vo.getFR_NEARLY_THREE_YEARS() != 0)
            po.setFR_NEARLY_THREE_YEARS(vo.getFR_NEARLY_THREE_YEARS());//近三年
        if (po.getFR_NEARLY_FIVE_YEARS() == 0 || vo.getFR_NEARLY_FIVE_YEARS() != 0)
            po.setFR_NEARLY_FIVE_YEARS(vo.getFR_NEARLY_FIVE_YEARS());//近5年
        if (po.getFR_SINCE_ITS_ESTABLISHMENT() == 0 || vo.getFR_SINCE_ITS_ESTABLISHMENT() != 0)
            po.setFR_SINCE_ITS_ESTABLISHMENT(vo.getFR_SINCE_ITS_ESTABLISHMENT());//成立以来
        if (po.getFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS() == 0 || vo.getFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS() != 0)
            po.setFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS(vo.getFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS());//最多连续盈利天数
        if (po.getFR_MAXIMUM_CONTINUOUS_LOSS_DAYS() == 0 || vo.getFR_MAXIMUM_CONTINUOUS_LOSS_DAYS() != 0)
            po.setFR_MAXIMUM_CONTINUOUS_LOSS_DAYS(vo.getFR_MAXIMUM_CONTINUOUS_LOSS_DAYS());//最多连续亏损天数
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }

    //年化收益率
    public static void setAnnualizedReturnRatePoValue(AnnualizedReturnRatePo po, AnnualizedReturnRateVo vo) {
        if (po.getRR_NEARLY_A_YEAR() == 0 || vo.getRR_NEARLY_A_YEAR() != 0)
            po.setRR_NEARLY_A_YEAR(vo.getRR_NEARLY_A_YEAR());//近一年
        if (po.getRR_NEARLY_TWO_YEARS() == 0 || vo.getRR_NEARLY_TWO_YEARS() != 0)
            po.setRR_NEARLY_TWO_YEARS(vo.getRR_NEARLY_TWO_YEARS());//近两年
        if (po.getRR_NEARLY_THREE_YEARS() == 0 || vo.getRR_NEARLY_THREE_YEARS() != 0)
            po.setRR_NEARLY_THREE_YEARS(vo.getRR_NEARLY_THREE_YEARS());//近三年
        if (po.getRR_NEARLY_FIVE_YEARS() == 0 || vo.getRR_NEARLY_FIVE_YEARS() != 0)
            po.setRR_NEARLY_FIVE_YEARS(vo.getRR_NEARLY_FIVE_YEARS());//近5年
        if (po.getRR_SINCE_ITS_ESTABLISHMENT() == 0 || vo.getRR_SINCE_ITS_ESTABLISHMENT() != 0)
            po.setRR_SINCE_ITS_ESTABLISHMENT(vo.getRR_SINCE_ITS_ESTABLISHMENT());//成立以来
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }

    //CALMAR比率
    public static void setCalmarRatioPoValue(CalmarRatioPo po, CalmarRatioVo vo) {
        if (po.getCR_NEARLY_A_YEAR() == 0 || vo.getCR_NEARLY_A_YEAR() != 0)
            po.setCR_NEARLY_A_YEAR(vo.getCR_NEARLY_A_YEAR());//近一年
        if (po.getCR_NEARLY_TWO_YEARS() == 0 || vo.getCR_NEARLY_TWO_YEARS() != 0)
            po.setCR_NEARLY_TWO_YEARS(vo.getCR_NEARLY_TWO_YEARS());//近两年
        if (po.getCR_NEARLY_THREE_YEARS() == 0 || vo.getCR_NEARLY_THREE_YEARS() != 0)
            po.setCR_NEARLY_THREE_YEARS(vo.getCR_NEARLY_THREE_YEARS());//近三年
        if (po.getCR_NEARLY_FIVE_YEARS() == 0 || vo.getCR_NEARLY_FIVE_YEARS() != 0)
            po.setCR_NEARLY_FIVE_YEARS(vo.getCR_NEARLY_FIVE_YEARS());//近5年
        if (po.getCR_SINCE_ITS_ESTABLISHMENT() == 0 || vo.getCR_SINCE_ITS_ESTABLISHMENT() != 0)
            po.setCR_SINCE_ITS_ESTABLISHMENT(vo.getCR_SINCE_ITS_ESTABLISHMENT());//成立以来
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }

    //费用费率
    public static void setCostRatePoValue(CostRatePo po, CostRateVo vo) {
        if (po.getCR_SUBSCRIPTION_RATE() == 0 || vo.getCR_SUBSCRIPTION_RATE() != 0)
            po.setCR_SUBSCRIPTION_RATE(vo.getCR_SUBSCRIPTION_RATE());//认购费率
        if (po.getCR_REDEMPTION_RATE() == 0 || vo.getCR_REDEMPTION_RATE() != 0)
            po.setCR_REDEMPTION_RATE(vo.getCR_REDEMPTION_RATE());//赎回费
        if (po.getCR_MANAGEMENT_RATE() == 0 || vo.getCR_MANAGEMENT_RATE() != 0)
            po.setCR_MANAGEMENT_RATE(vo.getCR_MANAGEMENT_RATE());//管理费
        if (po.getCR_HOSTING_RATE() == 0 || vo.getCR_HOSTING_RATE() != 0)
            po.setCR_HOSTING_RATE(vo.getCR_HOSTING_RATE());//托管费
        if (po.getCR_PERFORMANCE_PAY_RATE() == 0 || vo.getCR_PERFORMANCE_PAY_RATE() != 0)
            po.setCR_PERFORMANCE_PAY_RATE(vo.getCR_PERFORMANCE_PAY_RATE());//业绩报酬
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }

    //管理人
    public static void setFundManagePeoplePoValue(FundManagePeoplePo po, FundManagePeopleVo vo) {
        if (StringUtil.isEmpty(po.getFund_name()))
            po.setFund_name(vo.getFund_name());//基金管理人
        if (StringUtil.isEmpty(po.getFund_date()))
            po.setFund_date(vo.getFund_date());//成立时间
        if (StringUtil.isEmpty(po.getFund_assets()))
            po.setFund_assets(vo.getFund_assets());//管理人管理资产
        if (po.getFund_product_no() == 0)
            po.setFund_product_no(vo.getFund_product_no());//管理人管理产品
        if (StringUtil.isEmpty(po.getFund_count()))
            po.setFund_count(vo.getFund_count());//投研人数
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }

    //基金经理
    public static void setFundManagerPoValue(FundManagerPo po, FundManagerVo vo) {
        if (StringUtil.isEmpty(po.getBS_NAME()))
            po.setBS_NAME(vo.getBS_NAME());//基金经理
        if (StringUtil.isEmpty(po.getBS_FUND_MANAGEMENT_START_DATE()))
            po.setBS_FUND_MANAGEMENT_START_DATE(vo.getBS_FUND_MANAGEMENT_START_DATE());//基金起始管理日期
        if (StringUtil.isEmpty(po.getBS_FUND_MANAGEMENT_END_DATE()))
            po.setBS_FUND_MANAGEMENT_END_DATE(vo.getBS_FUND_MANAGEMENT_END_DATE());//基金结束管理日期
        if (po.getBS_MANAGEMENT_FUND_NUM() == 0 || vo.getBS_MANAGEMENT_FUND_NUM() != 0)
            po.setBS_MANAGEMENT_FUND_NUM(vo.getBS_MANAGEMENT_FUND_NUM());//管理基金数
        if (po.getBS_HISTORICAL_MANANGEMENT_FUND_NUM() == 0 || vo.getBS_HISTORICAL_MANANGEMENT_FUND_NUM() != 0)
            po.setBS_HISTORICAL_MANANGEMENT_FUND_NUM(vo.getBS_HISTORICAL_MANANGEMENT_FUND_NUM());//历史管理基金
        if (StringUtil.isEmpty(po.getBS_UNIVERSITY()))
            po.setBS_UNIVERSITY(vo.getBS_UNIVERSITY());//毕业院校
        if (StringUtil.isEmpty(po.getBS_EDUCATION()))
            po.setBS_EDUCATION(vo.getBS_EDUCATION());//学历
        if (StringUtil.isEmpty(po.getBS_PROFESSIONAL()))
            po.setBS_PROFESSIONAL(vo.getBS_PROFESSIONAL());//专业
        if (StringUtil.isEmpty(po.getBS_WORKING_TIME()))
            po.setBS_WORKING_TIME(vo.getBS_WORKING_TIME());//从业时间
        if (StringUtil.isEmpty(po.getBS_WORKING_YEAR()))
            po.setBS_WORKING_YEAR(vo.getBS_WORKING_YEAR());//从业年限
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }

    //收益排名
    public static void setIncomeRankingPoValue(IncomeRankingPo po, IncomeRankingVo vo) {
        if (StringUtil.isEmpty(po.getIR_SINCE_THIS_YEAR()) || StringUtil.isEmpty(vo.getIR_SINCE_THIS_YEAR()))
            po.setIR_SINCE_THIS_YEAR(vo.getIR_SINCE_THIS_YEAR());// 今年以来
        if (StringUtil.isEmpty(po.getIR_NEARLY_A_MONTH()) || StringUtil.isEmpty(vo.getIR_NEARLY_A_MONTH()))
            po.setIR_NEARLY_A_MONTH(vo.getIR_NEARLY_A_MONTH());// 近一月
        if (StringUtil.isEmpty(po.getIR_NEARLY_THREE_MONTHS()) || StringUtil.isEmpty(vo.getIR_NEARLY_THREE_MONTHS()))
            po.setIR_NEARLY_THREE_MONTHS(vo.getIR_NEARLY_THREE_MONTHS());// 近三月
        if (StringUtil.isEmpty(po.getIR_NEARLY_HALF_A_YEAR()) || StringUtil.isEmpty(vo.getIR_NEARLY_HALF_A_YEAR()))
            po.setIR_NEARLY_HALF_A_YEAR(vo.getIR_NEARLY_HALF_A_YEAR());//近半年
        if (StringUtil.isEmpty(po.getIR_NEARLY_A_YEAR()) || StringUtil.isEmpty(vo.getIR_NEARLY_A_YEAR()))
            po.setIR_NEARLY_A_YEAR(vo.getIR_NEARLY_A_YEAR());// 近一年
        if (StringUtil.isEmpty(po.getIR_NEARLY_TWO_YEARS()) || StringUtil.isEmpty(vo.getIR_NEARLY_TWO_YEARS()))
            po.setIR_NEARLY_TWO_YEARS(vo.getIR_NEARLY_TWO_YEARS());//近两年
        if (StringUtil.isEmpty(po.getIR_NEARLY_THREE_YEARS()) || StringUtil.isEmpty(vo.getIR_NEARLY_THREE_YEARS()))
            po.setIR_NEARLY_THREE_YEARS(vo.getIR_NEARLY_THREE_YEARS());//近三年
        if (StringUtil.isEmpty(po.getIR_NEARLY_FIVE_YEARS()) || StringUtil.isEmpty(vo.getIR_NEARLY_FIVE_YEARS()))
            po.setIR_NEARLY_FIVE_YEARS(vo.getIR_NEARLY_FIVE_YEARS());//近5年
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }


    //最大回撤
    public static void setMaximumReturnPoValue(MaximumReturnPo po, MaximumReturnVo vo) {
        if (po.getMR_NEARLY_A_YEAR() == 0 || vo.getMR_NEARLY_A_YEAR() != 0)
            po.setMR_NEARLY_A_YEAR(vo.getMR_NEARLY_A_YEAR());//近一年
        if (po.getMR_NEARLY_TWO_YEARS() == 0 || vo.getMR_NEARLY_TWO_YEARS() != 0)
            po.setMR_NEARLY_TWO_YEARS(vo.getMR_NEARLY_TWO_YEARS());//近两年
        if (po.getMR_NEARLY_THREE_YEARS() == 0 || vo.getMR_NEARLY_THREE_YEARS() != 0)
            po.setMR_NEARLY_THREE_YEARS(vo.getMR_NEARLY_THREE_YEARS());//近三年
        if (po.getMR_NEARLY_FIVE_YEARS() == 0 || vo.getMR_NEARLY_FIVE_YEARS() != 0)
            po.setMR_NEARLY_FIVE_YEARS(vo.getMR_NEARLY_FIVE_YEARS());//近5年
        if (po.getMR_SINCE_ITS_ESTABLISHMENT() == 0 || vo.getMR_SINCE_ITS_ESTABLISHMENT() != 0)
            po.setMR_SINCE_ITS_ESTABLISHMENT(vo.getMR_SINCE_ITS_ESTABLISHMENT());//成立以来
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }

    //夏普比率
    public static void setSharpRatioPoValue(SharpRatioPo po, SharpRatioVo vo) {
        if (po.getSR_NEARLY_A_YEAR() == 0 || vo.getSR_NEARLY_A_YEAR() != 0)
            po.setSR_NEARLY_A_YEAR(vo.getSR_NEARLY_A_YEAR());//近一年
        if (po.getSR_NEARLY_TWO_YEARS() == 0 || vo.getSR_NEARLY_TWO_YEARS() != 0)
            po.setSR_NEARLY_TWO_YEARS(vo.getSR_NEARLY_TWO_YEARS());//近两年
        if (po.getSR_NEARLY_THREE_YEARS() == 0 || vo.getSR_NEARLY_THREE_YEARS() != 0)
            po.setSR_NEARLY_THREE_YEARS(vo.getSR_NEARLY_THREE_YEARS());//近三年
        if (po.getSR_NEARLY_FIVE_YEARS() == 0 || vo.getSR_NEARLY_FIVE_YEARS() != 0)
            po.setSR_NEARLY_FIVE_YEARS(vo.getSR_NEARLY_FIVE_YEARS());//近5年
        if (po.getSR_SINCE_ITS_ESTABLISHMENT() == 0 || vo.getSR_SINCE_ITS_ESTABLISHMENT() != 0)
            po.setSR_SINCE_ITS_ESTABLISHMENT(vo.getSR_SINCE_ITS_ESTABLISHMENT());//成立以来
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }

    //Sterling比率
    public static void setSterlingRatioPoValue(SterlingRatioPo po, SterlingRatioVo vo) {
        if (po.getSR_NEARLY_A_YEAR() == 0 || vo.getSR_NEARLY_A_YEAR() != 0)
            po.setSR_NEARLY_A_YEAR(vo.getSR_NEARLY_A_YEAR());//近一年
        if (po.getSR_NEARLY_TWO_YEARS() == 0 || vo.getSR_NEARLY_TWO_YEARS() != 0)
            po.setSR_NEARLY_TWO_YEARS(vo.getSR_NEARLY_TWO_YEARS());//近两年
        if (po.getSR_NEARLY_THREE_YEARS() == 0 || vo.getSR_NEARLY_THREE_YEARS() != 0)
            po.setSR_NEARLY_THREE_YEARS(vo.getSR_NEARLY_THREE_YEARS());//近三年
        if (po.getSR_NEARLY_FIVE_YEARS() == 0 || vo.getSR_NEARLY_FIVE_YEARS() != 0)
            po.setSR_NEARLY_FIVE_YEARS(vo.getSR_NEARLY_FIVE_YEARS());//近5年
        if (po.getSR_SINCE_ITS_ESTABLISHMENT() == 0 || vo.getSR_SINCE_ITS_ESTABLISHMENT() != 0)
            po.setSR_SINCE_ITS_ESTABLISHMENT(vo.getSR_SINCE_ITS_ESTABLISHMENT());//成立以来
        if (po.getProduct_is_crawler() == 0)
            po.setProduct_is_crawler(vo.getProduct_is_crawler()); //是否为爬取 1 是 0 不是
    }
}
