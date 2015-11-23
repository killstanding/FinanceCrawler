package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.AnnualFluctuationRatePo;
import com.jerry.financecrawler.db.po.AnnualizedReturnRatePo;
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
public class AnnualizedReturnRateDao  implements  IAnnualizedReturnRate{
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final AnnualizedReturnRatePo po) {
        final String sql = "INSERT INTO bs_annualized_return_rate (product_id,RR_NEARLY_A_YEAR ,RR_NEARLY_TWO_YEARS,RR_NEARLY_THREE_YEARS,RR_NEARLY_FIVE_YEARS,RR_SINCE_ITS_ESTABLISHMENT,product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getProduct_id());
                ps.setDouble(2, po.getRR_NEARLY_A_YEAR());
                ps.setDouble(3, po.getRR_NEARLY_TWO_YEARS());
                ps.setDouble(4, po.getRR_NEARLY_THREE_YEARS());
                ps.setDouble(5, po.getRR_NEARLY_FIVE_YEARS());
                ps.setDouble(6, po.getRR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(7, po.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int product_id) {
        String sql = "DELETE FROM bs_annualized_return_rate WHERE product_id = ?";
        jdbcTemplate.update(sql, new Object[]{product_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final AnnualizedReturnRatePo po) {
        final String sql = "UPDATE bs_annualized_return_rate SET RR_NEARLY_A_YEAR = ?, RR_NEARLY_TWO_YEARS = ?, RR_NEARLY_THREE_YEARS = ?, RR_NEARLY_FIVE_YEARS = ?, RR_SINCE_ITS_ESTABLISHMENT = ?, product_is_crawler = ? WHERE  product_id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, po.getRR_NEARLY_A_YEAR());
                ps.setDouble(2, po.getRR_NEARLY_TWO_YEARS());
                ps.setDouble(3, po.getRR_NEARLY_THREE_YEARS());
                ps.setDouble(4, po.getRR_NEARLY_FIVE_YEARS());
                ps.setDouble(5, po.getRR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(6, po.getProduct_is_crawler());
                ps.setInt(7, po.getProduct_id());
                return ps;
            }
        });
    }

    @Override
    public AnnualizedReturnRatePo find(int product_id) {
        String sql = "SELECT * FROM bs_annualized_return_rate WHERE product_id = ?";
        List<AnnualizedReturnRatePo> annualizedReturnRatePoList = jdbcTemplate.query(sql, new Object[]{product_id},
                new int[]{Types.INTEGER}, new AnnualizedReturnRatePo());
        if (annualizedReturnRatePoList.isEmpty()) {
            return null;
        } else {
            return annualizedReturnRatePoList.get(0);
        }
    }
}
