package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.CostRatePo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by Jerry on 15/11/17.
 */
public class CostRateDao implements ICostRate{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final CostRatePo po) {
        final String sql = "INSERT INTO bs_cost_rate(product_id,CR_SUBSCRIPTION_RATE,CR_REDEMPTION_RATE,CR_MANAGEMENT_RATE,CR_HOSTING_RATE,CR_PERFORMANCE_PAY_RATE,product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getProduct_id());
                ps.setDouble(2, po.getCR_SUBSCRIPTION_RATE());
                ps.setDouble(3, po.getCR_REDEMPTION_RATE());
                ps.setDouble(4, po.getCR_MANAGEMENT_RATE());
                ps.setDouble(5, po.getCR_HOSTING_RATE());
                ps.setDouble(6, po.getCR_PERFORMANCE_PAY_RATE());
                ps.setInt(7, po.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int product_id) {
        String sql = "DELETE FROM bs_cost_rate WHERE product_id = ?";
        jdbcTemplate.update(sql, new Object[]{product_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final CostRatePo po) {
        final String sql = "UPDATE bs_cost_rate SET CR_SUBSCRIPTION_RATE = ?,CR_REDEMPTION_RATE = ?, CR_MANAGEMENT_RATE = ?, CR_HOSTING_RATE = ?, CR_PERFORMANCE_PAY_RATE = ?, product_is_crawler = ? WHERE product_id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, po.getCR_SUBSCRIPTION_RATE());
                ps.setDouble(2, po.getCR_REDEMPTION_RATE());
                ps.setDouble(3, po.getCR_MANAGEMENT_RATE());
                ps.setDouble(4, po.getCR_HOSTING_RATE());
                ps.setDouble(5, po.getCR_PERFORMANCE_PAY_RATE());
                ps.setInt(6, po.getProduct_is_crawler());
                ps.setInt(7, po.getProduct_id());
                return ps;
            }
        });
    }

    @Override
    public CostRatePo find(int product_id) {
        String sql = "SELECT * FROM bs_cost_rate WHERE product_id = ?";
        List<CostRatePo> costRatePoList = jdbcTemplate.query(sql, new Object[]{product_id},
                new int[]{Types.INTEGER}, new CostRatePo());
        if (costRatePoList.isEmpty()) {
            return null;
        } else {
            return costRatePoList.get(0);
        }
    }
}
