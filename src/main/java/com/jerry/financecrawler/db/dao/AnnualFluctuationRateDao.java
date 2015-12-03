package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.AnnualFluctuationRatePo;
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
public class AnnualFluctuationRateDao implements IAnnualFluctuationRate{
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final AnnualFluctuationRatePo po) {
        final String sql = "INSERT INTO bs_annual_fluctuation_rate(product_id,FR_NEARLY_A_YEAR,FR_NEARLY_TWO_YEARS,FR_NEARLY_THREE_YEARS,FR_NEARLY_FIVE_YEARS,FR_SINCE_ITS_ESTABLISHMENT,FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS,FR_MAXIMUM_CONTINUOUS_LOSS_DAYS,product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getProduct_id());
                ps.setDouble(2, po.getFR_NEARLY_A_YEAR());
                ps.setDouble(3, po.getFR_NEARLY_TWO_YEARS());
                ps.setDouble(4, po.getFR_NEARLY_THREE_YEARS());
                ps.setDouble(5, po.getFR_NEARLY_FIVE_YEARS());
                ps.setDouble(6, po.getFR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(7, po.getFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS());
                ps.setInt(8, po.getFR_MAXIMUM_CONTINUOUS_LOSS_DAYS());
                ps.setInt(9, po.getProduct_is_crawler());

                return ps;
            }
        });
    }

    @Override
    public void remove(int product_id) {
        String sql = "DELETE FROM bs_annual_fluctuation_rate WHERE product_id = ?";
        jdbcTemplate.update(sql, new Object[]{product_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final AnnualFluctuationRatePo po) {
        final String sql = "UPDATE  bs_annual_fluctuation_rate SET FR_NEARLY_A_YEAR = ?, FR_NEARLY_TWO_YEARS = ?, FR_NEARLY_THREE_YEARS = ?, FR_NEARLY_FIVE_YEARS = ?, FR_SINCE_ITS_ESTABLISHMENT = ?, FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS = ?, FR_MAXIMUM_CONTINUOUS_LOSS_DAYS = ?, product_is_crawler = ? WHERE product_id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, po.getFR_NEARLY_A_YEAR());
                ps.setDouble(2, po.getFR_NEARLY_TWO_YEARS());
                ps.setDouble(3, po.getFR_NEARLY_THREE_YEARS());
                ps.setDouble(4, po.getFR_NEARLY_FIVE_YEARS());
                ps.setDouble(5, po.getFR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(6, po.getFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS());
                ps.setInt(7, po.getFR_MAXIMUM_CONTINUOUS_LOSS_DAYS());
                ps.setInt(8, po.getProduct_is_crawler());
                ps.setInt(9, po.getProduct_id());
                return ps;
            }
        });
    }

    @Override
    public AnnualFluctuationRatePo find(int product_id) {
        String sql = "SELECT * FROM bs_annual_fluctuation_rate WHERE product_id = ?";
        List<AnnualFluctuationRatePo> annualFluctuationRatePoList = jdbcTemplate.query(sql, new Object[]{product_id},
                new int[]{Types.INTEGER}, new AnnualFluctuationRatePo());
        if (annualFluctuationRatePoList.isEmpty()) {
            return null;
        } else {
            return annualFluctuationRatePoList.get(0);
        }
    }
}
