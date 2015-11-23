package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.SharpRatioVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 夏普比率
 * Created by Jerry on 15/11/12.
 */
public class SharpRatioPo extends SharpRatioVo implements RowMapper<SharpRatioPo> {
    @Override
    public int hashCode() {
        return getProduct_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        SharpRatioPo sharpRatioPo = (SharpRatioPo) obj;
        if (this.getProduct_id() != sharpRatioPo.getProduct_id()) {
            return false;
        }
        return true;
    }

    @Override
    public SharpRatioPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        SharpRatioPo sharpRatioPo = new SharpRatioPo();
        sharpRatioPo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        sharpRatioPo.setSR_NEARLY_A_YEAR(rs.getDouble("SR_NEARLY_A_YEAR"));//近一年
        sharpRatioPo.setSR_NEARLY_TWO_YEARS(rs.getDouble("SR_NEARLY_TWO_YEARS"));//近两年
        sharpRatioPo.setSR_NEARLY_THREE_YEARS(rs.getDouble("SR_NEARLY_THREE_YEARS"));// 近三年
        sharpRatioPo.setSR_NEARLY_FIVE_YEARS(rs.getDouble("SR_NEARLY_FIVE_YEARS"));//近5年
        sharpRatioPo.setSR_SINCE_ITS_ESTABLISHMENT(rs.getDouble("SR_SINCE_ITS_ESTABLISHMENT"));//成立以来
        sharpRatioPo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return sharpRatioPo;
    }

}
