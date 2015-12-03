package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.ProductReFundManagePeopleVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 管理人产品关联关系表
 * Created by Jerry on 15/11/12.
 */
public class ProductReFundManagePeoplePo extends ProductReFundManagePeopleVo implements RowMapper<ProductReFundManagePeoplePo> {
    @Override
    public int hashCode() {
        return getId() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        ProductReFundManagePeoplePo re = (ProductReFundManagePeoplePo) obj;
        if (this.getId() != re.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public ProductReFundManagePeoplePo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductReFundManagePeoplePo re = new ProductReFundManagePeoplePo();
        re.setId(rs.getInt("id"));
        re.setProduct_id(rs.getInt("product_id"));// 产品ID
        re.setBs_fund(rs.getInt("bs_fund"));// 管理人
        re.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return re;
    }


}
