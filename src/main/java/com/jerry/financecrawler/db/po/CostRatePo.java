package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.CostRateVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 费用费率
 * Created by Jerry on 15/11/12.
 */
public class CostRatePo extends CostRateVo implements RowMapper<CostRatePo> {
    @Override
    public int hashCode() {
        return getProduct_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        CostRatePo costRatePo = (CostRatePo) obj;
        if (this.getProduct_id() != costRatePo.getProduct_id()) {
            return false;
        }
        return true;
    }

    @Override
    public CostRatePo mapRow(ResultSet rs, int rowNum) throws SQLException {
        CostRatePo costRatePo = new CostRatePo();
        costRatePo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        costRatePo.setCR_SUBSCRIPTION_RATE(rs.getDouble("CR_SUBSCRIPTION_RATE"));//认购费率
        costRatePo.setCR_REDEMPTION_RATE(rs.getDouble("CR_REDEMPTION_RATE"));//赎回费
        costRatePo.setCR_MANAGEMENT_RATE(rs.getDouble("CR_MANAGEMENT_RATE"));//管理费
        costRatePo.setCR_HOSTING_RATE(rs.getDouble("CR_HOSTING_RATE"));//托管费
        costRatePo.setCR_PERFORMANCE_PAY_RATE(rs.getDouble("CR_PERFORMANCE_PAY_RATE"));//业绩报酬
        costRatePo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return costRatePo;
    }
}
