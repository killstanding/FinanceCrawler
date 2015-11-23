package com.jerry.financecrawler.convert;

import com.jerry.financecrawler.db.po.FundProductPo;
import com.jerry.financecrawler.vo.FundProductVo;

/**
 * Created by Jerry on 15/11/19.
 */
public class PoToVo {
    //产品
    public static FundProductVo fundProductPoToVo(FundProductPo po) {
        //产品
        FundProductVo vo = new FundProductVo();
        vo.setId(po.getId());
        vo.setProduct_name(po.getProduct_name()); //产品名称
        vo.setProduct_shortname(po.getProduct_shortname());//产品简称
        vo.setProduct_code(po.getProduct_code());//产品代码
        vo.setIsactice(po.getIsactice());//产品状态
        vo.setSupplier_code(po.getSupplier_code());//基金发行人
        vo.setProduct_nature(po.getProduct_nature()); //基金性质
        vo.setProduct_bank(po.getProduct_bank());  //托管行
        vo.setProduct_COOPERATIVE_SECURITIES_INSTITUTION(po.getProduct_COOPERATIVE_SECURITIES_INSTITUTION());   //合作证券机构
        vo.setProduct_COOPERATIVE_FUTURES_AGENCY(po.getProduct_COOPERATIVE_FUTURES_AGENCY()); //合作期货机构
        vo.setProduct_ESTABLISHMENT_DATE(po.getProduct_ESTABLISHMENT_DATE()); //   date 成立日期
        vo.setProduct_DURATION_YEAR(po.getProduct_DURATION_YEAR());    //存续期间(年)
        vo.setProduct_DURATION_EXISTENCE_YEAR(po.getProduct_DURATION_EXISTENCE_YEAR());  //存续期限(年)
        vo.setProduct_TERMINATION_CONTION(po.getProduct_TERMINATION_CONTION());  //终止条件
        vo.setProduct_TYPE(po.getProduct_TYPE());   //基金类型
        vo.setProduct_INVESTMENT_TYPE(po.getProduct_INVESTMENT_TYPE());   //投资类型
        vo.setProduct_INVESTMENT_TYPE_DETAIL(po.getProduct_INVESTMENT_TYPE_DETAIL());   //投资类型细分
        vo.setProduct_info(po.getProduct_info());    // 产品信息
        vo.setProduct_INVESTMENT_TARGETS(po.getProduct_INVESTMENT_TARGETS());   //投资标的
        vo.setProduct_INVESTMENT_RATIO(po.getProduct_INVESTMENT_RATIO());    //投资比例
        vo.setProduct_EXPECTED_RETURN(po.getProduct_EXPECTED_RETURN());  //预期收益
        vo.setProduct_HEDGE_RATIO(po.getProduct_HEDGE_RATIO());    //对冲比例
        vo.setProduct_INVESTMENT_THRESHOLD(po.getProduct_INVESTMENT_THRESHOLD());    //投资门槛（万）
        vo.setProduct_ADDITIONAL_AMOUNT(po.getProduct_ADDITIONAL_AMOUNT());   //追加金额（万）
        vo.setProduct_OPEN_PERIOD(po.getProduct_OPEN_PERIOD());    //开放期
        vo.setProduct_OPEN_FREQUENCY(po.getProduct_OPEN_FREQUENCY());   //开放频度
        vo.setProduct_CLOSURE_PERIOD(po.getProduct_CLOSURE_PERIOD());    //封闭期(天)（转换下）
        vo.setProduct_EARLY_WARNING_LINE(po.getProduct_EARLY_WARNING_LINE());    //预警线
        vo.setProduct_STOP_LINE(po.getProduct_STOP_LINE());    //止损线
        vo.setProduct_CLASSIFICATON(po.getProduct_CLASSIFICATON());    //是否分级 0 否 1 是
        vo.setProduct_GRADING_SCALE(po.getProduct_GRADING_SCALE());    //分级比例
        vo.setProduct_OTHERS(po.getProduct_OTHERS()); //其他说明
        vo.setProduct_price(po.getProduct_price());   //产品价格
        vo.setCreatedate(po.getCreatedate());    //datetime
        vo.setProductcategory_code(po.getProductcategory_code());  //产品分类代码
        vo.setProduct_image_url(po.getProduct_image_url());    //图片url
        vo.setProduct_is_crawler(1); //是否为爬取 1 是 0 不是
        return vo;
    }
}
