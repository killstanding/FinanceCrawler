package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.IncomeRankingVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 收益排名
 * Created by Jerry on 15/11/12.
 */
public class IncomeRankingPo extends IncomeRankingVo implements RowMapper<IncomeRankingPo> {
    @Override
    public int hashCode() {
        return getProduct_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        IncomeRankingPo incomeRankingPo = (IncomeRankingPo) obj;
        if (this.getProduct_id() != incomeRankingPo.getProduct_id()) {
            return false;
        }
        return true;
    }

    @Override
    public IncomeRankingPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        IncomeRankingPo incomeRankingPo = new IncomeRankingPo();
        incomeRankingPo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        incomeRankingPo.setIR_SINCE_THIS_YEAR(rs.getString("IR_SINCE_THIS_YEAR"));// 今年以来
        incomeRankingPo.setIR_NEARLY_A_MONTH(rs.getString("IR_NEARLY_A_MONTH"));// 近一月
        incomeRankingPo.setIR_NEARLY_THREE_MONTHS(rs.getString("IR_NEARLY_THREE_MONTHS"));// 近三月
        incomeRankingPo.setIR_NEARLY_HALF_A_YEAR(rs.getString("IR_NEARLY_HALF_A_YEAR"));//近半年
        incomeRankingPo.setIR_NEARLY_A_YEAR(rs.getString("IR_NEARLY_A_YEAR"));// 近一年
        incomeRankingPo.setIR_NEARLY_TWO_YEARS(rs.getString("IR_NEARLY_TWO_YEARS"));//近两年
        incomeRankingPo.setIR_NEARLY_THREE_YEARS(rs.getString("IR_NEARLY_THREE_YEARS"));//近三年
        incomeRankingPo.setIR_NEARLY_FIVE_YEARS(rs.getString("IR_NEARLY_FIVE_YEARS"));//近5年
        incomeRankingPo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return incomeRankingPo;
    }

}
