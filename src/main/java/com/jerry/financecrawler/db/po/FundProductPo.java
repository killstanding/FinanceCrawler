package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.FundProductVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jerry on 2015/9/20.
 */
public class FundProductPo extends FundProductVo implements RowMapper<FundProductPo> {

    private IncomePo incomePo;

    public IncomePo getIncomePo() {
        return incomePo;
    }

    public void setIncomePo(IncomePo incomePo) {
        this.incomePo = incomePo;
    }

    @Override
    public int hashCode() {
        return getId() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        FundProductPo fundProductPo = (FundProductPo) obj;
        if (this.getId() !=  fundProductPo.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public FundProductPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        FundProductPo fundProductPo = new FundProductPo();
        fundProductPo.setId(rs.getInt("id"));
         fundProductPo.setProduct_name(rs.getString("product_name"));  //产品名称
        fundProductPo.setProduct_shortname(rs.getString("product_shortname"));//产品简称
        fundProductPo.setProduct_code(rs.getString("product_code"));//产品代码
        fundProductPo.setIsactice(rs.getString("isactice"));//产品状态
        fundProductPo.setSupplier_code(rs.getString("supplier_code"));//基金发行人
        fundProductPo.setProduct_nature(rs.getString("product_nature")); //基金性质
        fundProductPo.setProduct_bank(rs.getString("product_bank"));  //托管行
        fundProductPo.setProduct_COOPERATIVE_SECURITIES_INSTITUTION(rs.getString("product_COOPERATIVE_SECURITIES_INSTITUTION"));   //合作证券机构
        fundProductPo.setProduct_COOPERATIVE_FUTURES_AGENCY(rs.getString("product_COOPERATIVE_FUTURES_AGENCY")); ; //合作期货机构
        fundProductPo.setProduct_ESTABLISHMENT_DATE(rs.getString("product_ESTABLISHMENT_DATE")); //   date 成立日期
        fundProductPo.setProduct_DURATION_YEAR(rs.getInt("product_DURATION_YEAR"));    //存续期间(年)
        fundProductPo.setProduct_DURATION_EXISTENCE_YEAR(rs.getInt("product_DURATION_EXISTENCE_YEAR"));  //存续期限(年)
        fundProductPo.setProduct_TERMINATION_CONTION(rs.getString("product_TERMINATION_CONTION"));  //终止条件
        fundProductPo.setProduct_TYPE(rs.getString("product_TYPE"));   //基金类型
        fundProductPo.setProduct_INVESTMENT_TYPE(rs.getString("product_INVESTMENT_TYPE"));   //投资类型
        fundProductPo.setProduct_INVESTMENT_TYPE_DETAIL(rs.getString("product_INVESTMENT_TYPE_DETAIL"));   //投资类型细分
        fundProductPo.setProduct_info(rs.getString("product_info"));    // 产品信息
        fundProductPo.setProduct_INVESTMENT_TARGETS(rs.getString("product_INVESTMENT_TARGETS"));   //投资标的
        fundProductPo.setProduct_INVESTMENT_RATIO(rs.getString("product_INVESTMENT_RATIO"));    //投资比例
        fundProductPo.setProduct_EXPECTED_RETURN(rs.getDouble("product_EXPECTED_RETURN"));  //预期收益
        fundProductPo.setProduct_HEDGE_RATIO(rs.getDouble("product_HEDGE_RATIO"));    //对冲比例
        fundProductPo.setProduct_INVESTMENT_THRESHOLD(rs.getInt("product_INVESTMENT_THRESHOLD"));    //投资门槛（万）
        fundProductPo.setProduct_ADDITIONAL_AMOUNT(rs.getInt("product_ADDITIONAL_AMOUNT"));   //追加金额（万）
        fundProductPo.setProduct_OPEN_PERIOD(rs.getString("product_OPEN_PERIOD"));    //开放期
        fundProductPo.setProduct_OPEN_FREQUENCY(rs.getString("product_OPEN_FREQUENCY"));   //开放频度
        fundProductPo.setProduct_CLOSURE_PERIOD(rs.getInt("product_CLOSURE_PERIOD"));    //封闭期(天)（转换下）
        fundProductPo.setProduct_EARLY_WARNING_LINE(rs.getDouble("product_EARLY_WARNING_LINE"));    //预警线
        fundProductPo.setProduct_STOP_LINE(rs.getDouble("product_STOP_LINE"));    //止损线
        fundProductPo.setProduct_CLASSIFICATON(rs.getString("product_CLASSIFICATON"));    //是否分级 0 否 1 是
        fundProductPo.setProduct_GRADING_SCALE(rs.getString("product_GRADING_SCALE"));    //分级比例
        fundProductPo.setProduct_OTHERS(rs.getString("product_OTHERS")); //其他说明
        fundProductPo.setProduct_price(rs.getDouble("product_price"));   //产品价格
        fundProductPo.setCreatedate(rs.getString("createdate"));    //datetime
        fundProductPo.setProductcategory_code(rs.getString("productcategory_code"));  //产品分类代码
        fundProductPo.setProduct_image_url(rs.getString("product_image_url"));    //图片url
        fundProductPo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return fundProductPo;
    }
}
