package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.IncomeRankingPo;
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
public class IncomeRankingDao implements IIncomeRanking {
    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public void save(final IncomeRankingPo po) {
        final String sql = "INSERT INTO bs_income_ranking(product_id, IR_SINCE_THIS_YEAR, IR_NEARLY_A_MONTH, IR_NEARLY_THREE_MONTHS, IR_NEARLY_HALF_A_YEAR, IR_NEARLY_A_YEAR, IR_NEARLY_TWO_YEARS, IR_NEARLY_THREE_YEARS, IR_NEARLY_FIVE_YEARS, product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getProduct_id());
                ps.setString(2, po.getIR_SINCE_THIS_YEAR());
                ps.setString(3, po.getIR_NEARLY_A_MONTH());
                ps.setString(4, po.getIR_NEARLY_THREE_MONTHS());
                ps.setString(5, po.getIR_NEARLY_HALF_A_YEAR());
                ps.setString(6, po.getIR_NEARLY_A_YEAR());
                ps.setString(7, po.getIR_NEARLY_TWO_YEARS());
                ps.setString(8, po.getIR_NEARLY_THREE_YEARS());
                ps.setString(9, po.getIR_NEARLY_FIVE_YEARS());
                ps.setInt(10, po.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int product_id) {
        String sql = "DELETE FROM bs_income_ranking WHERE product_id = ?";
        jdbcTemplate.update(sql, new Object[]{product_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final IncomeRankingPo po) {
        final String sql = "UPDATE bs_income_ranking SET IR_SINCE_THIS_YEAR = ?, IR_NEARLY_A_MONTH = ?, IR_NEARLY_THREE_MONTHS = ?, IR_NEARLY_HALF_A_YEAR = ?, IR_NEARLY_A_YEAR = ?, IR_NEARLY_TWO_YEARS = ?, IR_NEARLY_THREE_YEARS = ?, IR_NEARLY_FIVE_YEARS = ?, product_is_crawler = ? WHERE product_id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, po.getIR_SINCE_THIS_YEAR());
                ps.setString(2, po.getIR_NEARLY_A_MONTH());
                ps.setString(3, po.getIR_NEARLY_THREE_MONTHS());
                ps.setString(4, po.getIR_NEARLY_HALF_A_YEAR());
                ps.setString(5, po.getIR_NEARLY_A_YEAR());
                ps.setString(6, po.getIR_NEARLY_TWO_YEARS());
                ps.setString(7, po.getIR_NEARLY_THREE_YEARS());
                ps.setString(8, po.getIR_NEARLY_FIVE_YEARS());
                ps.setInt(9, po.getProduct_is_crawler());
                ps.setInt(10, po.getProduct_id());
                return ps;
            }
        });
    }

    @Override
    public IncomeRankingPo find(int product_id) {
        String sql = "SELECT * FROM bs_income_ranking WHERE product_id = ?";
        List<IncomeRankingPo> incomeRankingPoList = jdbcTemplate.query(sql, new Object[]{product_id},
                new int[]{Types.INTEGER}, new IncomeRankingPo());
        if (incomeRankingPoList.isEmpty()) {
            return null;
        } else {
            return incomeRankingPoList.get(0);
        }
    }
}
