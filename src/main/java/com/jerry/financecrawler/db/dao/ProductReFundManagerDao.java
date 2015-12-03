package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.ProductReFundManagePeoplePo;
import com.jerry.financecrawler.db.po.ProductReFundManagerPo;
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
public class ProductReFundManagerDao implements IProductReFundManager {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final ProductReFundManagerPo po) {
        final String sql = "INSERT INTO bs_productfundmanager (id, product_id, bs_fundmanager, product_is_crawler) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getId());
                ps.setInt(2, po.getProduct_id());
                ps.setInt(3, po.getBs_fundmanager());
                ps.setInt(4, po.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM bs_productfundmanager WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final ProductReFundManagerPo po) {
        final String sql = "UPDATE bs_productfundmanager SET product_id = ?, bs_fundmanager = ?, product_is_crawler = ?WHERE id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getProduct_id());
                ps.setInt(2, po.getBs_fundmanager());
                ps.setInt(3, po.getProduct_is_crawler());
                ps.setInt(4, po.getId());
                return ps;
            }
        });
    }

    @Override
    public ProductReFundManagerPo find(int id) {
        String sql = "SELECT * FROM bs_productfundmanager WHERE id = ?";
        List<ProductReFundManagerPo> productReFundManagerPoList = jdbcTemplate.query(sql, new Object[]{id},
                new int[]{Types.INTEGER}, new ProductReFundManagerPo());
        if (productReFundManagerPoList.isEmpty()) {
            return null;
        } else {
            return productReFundManagerPoList.get(0);
        }
    }

    @Override
    public ProductReFundManagerPo findByProductIDAndFundManagerID(int product_id, int bs_fundmanager){
        String sql = "SELECT * FROM bs_productfundmanager WHERE product_id =  ? and bs_fundmanager =  ?";
        List<ProductReFundManagerPo> productReFundManagerPoList = jdbcTemplate.query(sql, new Object[]{product_id, bs_fundmanager},
                new int[]{Types.VARCHAR,Types.VARCHAR}, new ProductReFundManagerPo());
        if (productReFundManagerPoList.isEmpty()) {
            return null;
        } else {
            return productReFundManagerPoList.get(0);
        }
    }

    @Override
    public Integer getMaxId() {
        String sql = "select max(id) as maxid from bs_productfundmanager";
        Integer maxId = jdbcTemplate.queryForObject(sql, Integer.class);
        return maxId;
    }
}
