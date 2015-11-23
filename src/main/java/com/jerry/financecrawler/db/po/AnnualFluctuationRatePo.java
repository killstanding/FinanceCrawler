package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.AnnualFluctuationRateVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 年化波动率
 * Created by Jerry on 15/11/12.
 */
public class AnnualFluctuationRatePo extends AnnualFluctuationRateVo implements RowMapper<AnnualFluctuationRatePo> {
    @Override
    public int hashCode() {
        return getProduct_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        AnnualFluctuationRatePo annualFluctuationRatePo = (AnnualFluctuationRatePo) obj;
        if (this.getProduct_id() != annualFluctuationRatePo.getProduct_id()) {
            return false;
        }
        return true;
    }

    @Override
    public AnnualFluctuationRatePo mapRow(ResultSet rs, int rowNum) throws SQLException {
        AnnualFluctuationRatePo annualFluctuationRatePo = new AnnualFluctuationRatePo();
        annualFluctuationRatePo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        annualFluctuationRatePo.setFR_NEARLY_A_YEAR(rs.getDouble("FR_NEARLY_A_YEAR"));//近一年
        annualFluctuationRatePo.setFR_NEARLY_TWO_YEARS(rs.getDouble("FR_NEARLY_TWO_YEARS"));//近两年
        annualFluctuationRatePo.setFR_NEARLY_THREE_YEARS(rs.getDouble("FR_NEARLY_THREE_YEARS"));// 近三年
        annualFluctuationRatePo.setFR_NEARLY_FIVE_YEARS(rs.getDouble("FR_NEARLY_FIVE_YEARS"));//近5年
        annualFluctuationRatePo.setFR_SINCE_ITS_ESTABLISHMENT(rs.getDouble("FR_SINCE_ITS_ESTABLISHMENT"));//成立以来
        annualFluctuationRatePo.setFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS(rs.getInt("FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS"));//最多连续盈利天数
        annualFluctuationRatePo.setFR_MAXIMUM_CONTINUOUS_LOSS_DAYS(rs.getInt("FR_MAXIMUM_CONTINUOUS_LOSS_DAYS"));//最多连续亏损天数
        annualFluctuationRatePo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return annualFluctuationRatePo;
    }
}
