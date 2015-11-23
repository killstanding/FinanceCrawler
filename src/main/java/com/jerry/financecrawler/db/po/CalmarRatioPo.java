package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.CalmarRatioVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * CALMAR比率
 * Created by Jerry on 15/11/12.
 */
public class CalmarRatioPo extends CalmarRatioVo implements RowMapper<CalmarRatioPo> {
    @Override
    public int hashCode() {
        return getProduct_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        CalmarRatioPo calmarRatioPo = (CalmarRatioPo) obj;
        if (this.getProduct_id() != calmarRatioPo.getProduct_id()) {
            return false;
        }
        return true;
    }

    @Override
    public CalmarRatioPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        CalmarRatioPo calmarRatioPo = new CalmarRatioPo();
        calmarRatioPo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        calmarRatioPo.setCR_NEARLY_A_YEAR(rs.getDouble("CR_NEARLY_A_YEAR"));//近一年
        calmarRatioPo.setCR_NEARLY_TWO_YEARS(rs.getDouble("CR_NEARLY_TWO_YEARS"));//近两年
        calmarRatioPo.setCR_NEARLY_THREE_YEARS(rs.getDouble("CR_NEARLY_THREE_YEARS"));// 近三年
        calmarRatioPo.setCR_NEARLY_FIVE_YEARS(rs.getDouble("CR_NEARLY_FIVE_YEARS"));//近5年
        calmarRatioPo.setCR_SINCE_ITS_ESTABLISHMENT(rs.getDouble("CR_SINCE_ITS_ESTABLISHMENT"));//成立以来
        calmarRatioPo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return calmarRatioPo;
    }
}
