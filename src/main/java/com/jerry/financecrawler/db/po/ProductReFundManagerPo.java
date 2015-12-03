package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.ProductReFundManagerVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jerry on 15/11/12.
 */
public class ProductReFundManagerPo extends ProductReFundManagerVo implements RowMapper<ProductReFundManagerPo> {

    @Override
    public int hashCode() {
        return getId() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        ProductReFundManagerPo re = (ProductReFundManagerPo) obj;
        if (this.getId() != re.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public ProductReFundManagerPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductReFundManagerPo re = new ProductReFundManagerPo();
        re.setId(rs.getInt("id"));
        re.setProduct_id(rs.getInt("product_id"));// 产品ID
        re.setBs_fundmanager(rs.getInt("bs_fundmanager"));// 基金经理
        re.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return re;
    }
}
