package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.IncomePo;
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
 * Created by Jerry on 2015/9/20.
 * 收益率
 */

@Repository
public class IncomeDao implements IIncomeDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final IncomePo incomePo) {
        final String sql = "INSERT INTO bs_income(product_id ,I_UPDATE_DATE ,I_LATEST_NET_WORTH ,I_SINCE_THIS_YEAR ,I_NEARLY_A_MONTH ," +
                "I_NEARLY_THREE_MONTHS ,I_NEARLY_HALF_A_YEAR ,I_NEARLY_A_YEAR ,I_NEARLY_TWO_YEARS ,I_NEARLY_THREE_YEARS ," +
                "I_NEARLY_FIVE_YEARS ,I_SINCE_ITS_ESTABLISHMENT,product_is_crawler) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, incomePo.getProduct_id());
                ps.setString(2, incomePo.getI_UPDATE_DATE());
                ps.setDouble(3, incomePo.getI_LATEST_NET_WORTH());
                ps.setDouble(4, incomePo.getI_SINCE_THIS_YEAR());
                ps.setDouble(5, incomePo.getI_NEARLY_A_MONTH());

                ps.setDouble(6, incomePo.getI_NEARLY_THREE_MONTHS());
                ps.setDouble(7, incomePo.getI_NEARLY_HALF_A_YEAR());
                ps.setDouble(8, incomePo.getI_NEARLY_A_YEAR());
                ps.setDouble(9, incomePo.getI_NEARLY_TWO_YEARS());
                ps.setDouble(10, incomePo.getI_NEARLY_THREE_YEARS());

                ps.setDouble(11, incomePo.getI_NEARLY_FIVE_YEARS());
                ps.setDouble(12, incomePo.getI_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(13, incomePo.getProduct_is_crawler());

                return ps;
            }
        });
    }

    @Override
    public void remove(int product_id) {
        String sql = "DELETE FROM bs_income WHERE product_id =" + product_id;
        jdbcTemplate.update(sql, new Object[]{product_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final IncomePo incomePo) {
        final String sql = "update  bs_income set I_UPDATE_DATE = ? ,I_LATEST_NET_WORTH = ? ,I_SINCE_THIS_YEAR = ? ,I_NEARLY_A_MONTH = ? ," +
                "I_NEARLY_THREE_MONTHS = ? ,I_NEARLY_HALF_A_YEAR = ? ,I_NEARLY_A_YEAR = ? ,I_NEARLY_TWO_YEARS = ? ,I_NEARLY_THREE_YEARS = ? ," +
                "I_NEARLY_FIVE_YEARS = ? ,I_SINCE_ITS_ESTABLISHMENT = ?,product_is_crawler = ?  where product_id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, incomePo.getI_UPDATE_DATE());
                ps.setDouble(2, incomePo.getI_LATEST_NET_WORTH());
                ps.setDouble(3, incomePo.getI_SINCE_THIS_YEAR());
                ps.setDouble(4, incomePo.getI_NEARLY_A_MONTH());

                ps.setDouble(5, incomePo.getI_NEARLY_THREE_MONTHS());
                ps.setDouble(6, incomePo.getI_NEARLY_HALF_A_YEAR());
                ps.setDouble(7, incomePo.getI_NEARLY_A_YEAR());
                ps.setDouble(8, incomePo.getI_NEARLY_TWO_YEARS());
                ps.setDouble(9, incomePo.getI_NEARLY_THREE_YEARS());

                ps.setDouble(10, incomePo.getI_NEARLY_FIVE_YEARS());
                ps.setDouble(11, incomePo.getI_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(12, incomePo.getProduct_is_crawler());

                ps.setInt(13, incomePo.getProduct_id());
                return ps;
            }
        });
    }

    @Override
    public IncomePo find(int product_id) {
        String sql = "SELECT * FROM bs_income WHERE product_id = ?" ;
        List<IncomePo> incomePoList = jdbcTemplate.query(sql,new Object[]{product_id},
                new int[]{Types.INTEGER}, new IncomePo());
        if (incomePoList.isEmpty()) {
            return null;
        } else {
            return incomePoList.get(0);
        }
    }
}
