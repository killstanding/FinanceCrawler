package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.IncomeVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jerry on 2015/9/20.
 */
public class IncomePo extends IncomeVo implements RowMapper<IncomePo> {
    @Override
    public int hashCode() {
        return getProduct_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        IncomePo eastFinancePo = (IncomePo) obj;
        if (this.getProduct_id() != eastFinancePo.getProduct_id()) {
            return false;
        }
        return true;
    }

    @Override
    public IncomePo mapRow(ResultSet rs, int rowNum) throws SQLException {
        IncomePo incomePo = new IncomePo();
        incomePo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        incomePo.setI_UPDATE_DATE(rs.getString("I_UPDATE_DATE"));// date 更新时间
        incomePo.setI_LATEST_NET_WORTH(rs.getDouble("I_LATEST_NET_WORTH"));// 最新净值
        incomePo.setI_SINCE_THIS_YEAR(rs.getDouble("I_SINCE_THIS_YEAR"));// 今年以来
        incomePo.setI_NEARLY_A_MONTH(rs.getDouble("I_NEARLY_A_MONTH"));// 近一月
        incomePo.setI_NEARLY_THREE_MONTHS(rs.getDouble("I_NEARLY_THREE_MONTHS"));// 近三月
        incomePo.setI_NEARLY_HALF_A_YEAR(rs.getDouble("I_NEARLY_HALF_A_YEAR"));//近半年
        incomePo.setI_NEARLY_A_YEAR(rs.getDouble("I_NEARLY_A_YEAR"));// 近一年
        incomePo.setI_NEARLY_TWO_YEARS(rs.getDouble("I_NEARLY_TWO_YEARS"));//近两年
        incomePo.setI_NEARLY_THREE_YEARS(rs.getDouble("I_NEARLY_THREE_YEARS"));//近三年
        incomePo.setI_NEARLY_FIVE_YEARS(rs.getDouble("I_NEARLY_FIVE_YEARS"));//近5年
        incomePo.setI_SINCE_ITS_ESTABLISHMENT(rs.getDouble("I_SINCE_ITS_ESTABLISHMENT"));//成立以来
        incomePo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return incomePo;
    }
}
