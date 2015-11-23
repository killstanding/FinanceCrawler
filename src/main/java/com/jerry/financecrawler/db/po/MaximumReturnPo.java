package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.MaximumReturnVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jerry on 15/11/12.
 */
public class MaximumReturnPo extends MaximumReturnVo implements RowMapper<MaximumReturnPo> {
    @Override
    public int hashCode() {
        return getProduct_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        MaximumReturnPo maximumReturnPo = (MaximumReturnPo) obj;
        if (this.getProduct_id() != maximumReturnPo.getProduct_id()) {
            return false;
        }
        return true;
    }

    @Override
    public MaximumReturnPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        MaximumReturnPo maximumReturnPo = new MaximumReturnPo();
        maximumReturnPo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        maximumReturnPo.setMR_NEARLY_A_YEAR(rs.getDouble("MR_NEARLY_A_YEAR"));//近一年
        maximumReturnPo.setMR_NEARLY_TWO_YEARS(rs.getDouble("MR_NEARLY_TWO_YEARS"));//近两年
        maximumReturnPo.setMR_NEARLY_THREE_YEARS(rs.getDouble("MR_NEARLY_THREE_YEARS"));// 近三年
        maximumReturnPo.setMR_NEARLY_FIVE_YEARS(rs.getDouble("MR_NEARLY_FIVE_YEARS"));//近5年
        maximumReturnPo.setMR_SINCE_ITS_ESTABLISHMENT(rs.getDouble("MR_SINCE_ITS_ESTABLISHMENT"));//成立以来
        maximumReturnPo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return maximumReturnPo;
    }
}
