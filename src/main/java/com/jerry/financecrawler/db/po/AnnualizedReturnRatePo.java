package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.AnnualizedReturnRateVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 年化收益率
 * Created by Jerry on 15/11/12.
 */
public class AnnualizedReturnRatePo extends AnnualizedReturnRateVo implements RowMapper<AnnualizedReturnRatePo> {
    @Override
    public int hashCode() {
        return getProduct_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        AnnualizedReturnRatePo annualizedReturnRatePo = (AnnualizedReturnRatePo) obj;
        if (this.getProduct_id() != annualizedReturnRatePo.getProduct_id()) {
            return false;
        }
        return true;
    }

    @Override
    public AnnualizedReturnRatePo mapRow(ResultSet rs, int rowNum) throws SQLException {
        AnnualizedReturnRatePo annualizedReturnRatePo = new AnnualizedReturnRatePo();
        annualizedReturnRatePo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        annualizedReturnRatePo.setRR_NEARLY_A_YEAR(rs.getDouble("RR_NEARLY_A_YEAR"));//近一年
        annualizedReturnRatePo.setRR_NEARLY_TWO_YEARS(rs.getDouble("RR_NEARLY_TWO_YEARS"));//近两年
        annualizedReturnRatePo.setRR_NEARLY_THREE_YEARS(rs.getDouble("RR_NEARLY_THREE_YEARS"));// 近三年
        annualizedReturnRatePo.setRR_NEARLY_FIVE_YEARS(rs.getDouble("RR_NEARLY_FIVE_YEARS"));//近5年
        annualizedReturnRatePo.setRR_SINCE_ITS_ESTABLISHMENT(rs.getDouble("RR_SINCE_ITS_ESTABLISHMENT"));//成立以来
        annualizedReturnRatePo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return annualizedReturnRatePo;
    }

}
