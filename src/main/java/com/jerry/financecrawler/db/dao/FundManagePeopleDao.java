package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.FundManagePeoplePo;
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
 * Created by Jerry on 15/11/17.
 */
@Repository
public class FundManagePeopleDao implements  IFundManagePeople {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final FundManagePeoplePo po) {
        final String sql = "INSERT INTO bs_fund(id, fund_name, fund_date, fund_assets, fund_product_no, fund_count, product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getId());
                ps.setString(2, po.getFund_name());
                ps.setString(3, po.getFund_date());
                ps.setString(4, po.getFund_assets());
                ps.setInt(5, po.getFund_product_no());
                ps.setString(6, po.getFund_count());
                ps.setInt(7, po.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM bs_fund WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final FundManagePeoplePo po) {
        final String sql = "UPDATE bs_fund SET fund_name = ?, fund_date = ?, fund_assets = ?, fund_product_no = ?, fund_count = ?, product_is_crawler = ? WHERE id = ? ";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, po.getFund_name());
                ps.setString(2, po.getFund_date());
                ps.setString(3, po.getFund_assets());
                ps.setInt(4, po.getFund_product_no());
                ps.setString(5, po.getFund_count());
                ps.setInt(6, po.getProduct_is_crawler());
                ps.setInt(7, po.getId());
                return ps;
            }
        });
    }

    @Override
    public FundManagePeoplePo find(int id) {
        String sql = "SELECT * FROM bs_fund WHERE product_id = ?";
        List<FundManagePeoplePo> fundManagePeoplePoList = jdbcTemplate.query(sql, new Object[]{id},
                new int[]{Types.INTEGER}, new FundManagePeoplePo());
        if (fundManagePeoplePoList.isEmpty()) {
            return null;
        } else {
            return fundManagePeoplePoList.get(0);
        }
    }

    @Override
    public Integer getMaxId() {
        String sql = "select max(id) as maxid from bs_fund";
        Integer maxId = jdbcTemplate.queryForObject(sql, Integer.class);
        return maxId;
    }
}
