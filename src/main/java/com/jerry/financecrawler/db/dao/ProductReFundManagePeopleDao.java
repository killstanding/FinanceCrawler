package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.ProductReFundManagePeoplePo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by Jerry on 15/11/18.
 */
@Repository
public class ProductReFundManagePeopleDao implements IProductReFundManagePeople {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final ProductReFundManagePeoplePo po) {
        final String sql = "INSERT INTO bs_productfund (id, product_id, bs_fund, product_is_crawler ) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getId());
                ps.setInt(2, po.getProduct_id());
                ps.setInt(3, po.getBs_fund());
                ps.setInt(4, po.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM bs_productfund WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final ProductReFundManagePeoplePo po) {
        final String sql = "UPDATE bs_productfund SET product_id = ?, bs_fund = ?, product_is_crawler = ? WHERE id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getProduct_id());
                ps.setInt(2, po.getBs_fund());
                ps.setInt(3, po.getProduct_is_crawler());
                ps.setInt(4, po.getId());
                return ps;
            }
        });
    }

    @Override
    public ProductReFundManagePeoplePo find(int id) {
        String sql = "SELECT * FROM bs_productfund WHERE id = ?";
        List<ProductReFundManagePeoplePo> productReFundManagePeoplePoList = jdbcTemplate.query(sql, new Object[]{id},
                new int[]{Types.INTEGER}, new ProductReFundManagePeoplePo());
        if (productReFundManagePeoplePoList.isEmpty()) {
            return null;
        } else {
            return productReFundManagePeoplePoList.get(0);
        }
    }

    @Override
    public ProductReFundManagePeoplePo findByProductIDAndFundPeopleID(int product_id, int bs_fund) {
        String sql = "SELECT * FROM bs_productfund WHERE product_id =  ? and bs_fund =  ?";
        List<ProductReFundManagePeoplePo> productReFundManagePeoplePoList = jdbcTemplate.query(sql, new Object[]{product_id, bs_fund},
                new int[]{Types.VARCHAR,Types.VARCHAR}, new ProductReFundManagePeoplePo());
        if (productReFundManagePeoplePoList.isEmpty()) {
            return null;
        } else {
            return productReFundManagePeoplePoList.get(0);
        }
    }

    @Override
    public Integer getMaxId() {
        String sql = "select max(id) as maxid from bs_productfund";
        Integer maxId = jdbcTemplate.queryForObject(sql, Integer.class);
        return maxId;
    }
}
