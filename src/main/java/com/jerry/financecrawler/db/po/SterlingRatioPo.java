package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.SterlingRatioVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *Sterling比率
 * Created by Jerry on 15/11/12.
 */
public class SterlingRatioPo extends SterlingRatioVo implements RowMapper<SterlingRatioPo> {
    @Override
    public int hashCode() {
        return getProduct_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        SterlingRatioPo sterlingRatioPo = (SterlingRatioPo) obj;
        if (this.getProduct_id() != sterlingRatioPo.getProduct_id()) {
            return false;
        }
        return true;
    }

    @Override
    public SterlingRatioPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        SterlingRatioPo sterlingRatioPo = new SterlingRatioPo();
        sterlingRatioPo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        sterlingRatioPo.setSR_NEARLY_A_YEAR(rs.getDouble("SR_NEARLY_A_YEAR"));//近一年
        sterlingRatioPo.setSR_NEARLY_TWO_YEARS(rs.getDouble("SR_NEARLY_TWO_YEARS"));//近两年
        sterlingRatioPo.setSR_NEARLY_THREE_YEARS(rs.getDouble("SR_NEARLY_THREE_YEARS"));// 近三年
        sterlingRatioPo.setSR_NEARLY_FIVE_YEARS(rs.getDouble("SR_NEARLY_FIVE_YEARS"));//近5年
        sterlingRatioPo.setSR_SINCE_ITS_ESTABLISHMENT(rs.getDouble("SR_SINCE_ITS_ESTABLISHMENT"));//成立以来
        sterlingRatioPo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return sterlingRatioPo;
    }
}
