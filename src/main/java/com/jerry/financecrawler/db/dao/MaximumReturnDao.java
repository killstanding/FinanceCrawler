package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.MaximumReturnPo;
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
public class MaximumReturnDao implements IMaximumReturn {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final MaximumReturnPo po) {
        final String sql = "INSERT INTO bs_maximum_return( product_id, MR_NEARLY_A_YEAR, MR_NEARLY_TWO_YEARS, MR_NEARLY_THREE_YEARS, MR_NEARLY_FIVE_YEARS, MR_SINCE_ITS_ESTABLISHMENT, product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getProduct_id());
                ps.setDouble(2, po.getMR_NEARLY_A_YEAR());
                ps.setDouble(3, po.getMR_NEARLY_TWO_YEARS());
                ps.setDouble(4, po.getMR_NEARLY_THREE_YEARS());
                ps.setDouble(5, po.getMR_NEARLY_FIVE_YEARS());
                ps.setDouble(6, po.getMR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(7, po.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int product_id) {
        String sql = "DELETE FROM bs_maximum_return WHERE product_id = ?";
        jdbcTemplate.update(sql, new Object[]{product_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final MaximumReturnPo po) {
        final String sql = "UPDATE bs_maximum_return SET MR_NEARLY_A_YEAR  = ?, MR_NEARLY_TWO_YEARS  = ?, MR_NEARLY_THREE_YEARS  = ?, MR_NEARLY_FIVE_YEARS  = ?, MR_SINCE_ITS_ESTABLISHMENT  = ?, product_is_crawler  = ? WHERE product_id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, po.getMR_NEARLY_A_YEAR());
                ps.setDouble(2, po.getMR_NEARLY_TWO_YEARS());
                ps.setDouble(3, po.getMR_NEARLY_THREE_YEARS());
                ps.setDouble(4, po.getMR_NEARLY_FIVE_YEARS());
                ps.setDouble(5, po.getMR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(6, po.getProduct_is_crawler());
                ps.setInt(7, po.getProduct_id());
                return ps;
            }
        });
    }

    @Override
    public MaximumReturnPo find(int product_id) {
        String sql = "SELECT * FROM bs_maximum_return WHERE product_id = ?";
        List<MaximumReturnPo> maximumReturnPoList = jdbcTemplate.query(sql, new Object[]{product_id},
                new int[]{Types.INTEGER}, new MaximumReturnPo());
        if (maximumReturnPoList.isEmpty()) {
            return null;
        } else {
            return maximumReturnPoList.get(0);
        }
    }
}
