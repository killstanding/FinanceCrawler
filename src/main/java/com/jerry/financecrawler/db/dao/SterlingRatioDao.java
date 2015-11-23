package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.SterlingRatioPo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by Jerry on 15/11/18.
 */
public class SterlingRatioDao implements ISterlingRatio{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final SterlingRatioPo po) {
        final String sql = "INSERT INTO bs_sterling_ratio(product_id, SR_NEARLY_A_YEAR, SR_NEARLY_TWO_YEARS, SR_NEARLY_THREE_YEARS, SR_NEARLY_FIVE_YEARS, SR_SINCE_ITS_ESTABLISHMENT, product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getProduct_id());
                ps.setDouble(2, po.getSR_NEARLY_A_YEAR());
                ps.setDouble(3, po.getSR_NEARLY_TWO_YEARS());
                ps.setDouble(4, po.getSR_NEARLY_THREE_YEARS());
                ps.setDouble(5, po.getSR_NEARLY_FIVE_YEARS());
                ps.setDouble(6, po.getSR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(7, po.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int product_id) {
        String sql = "DELETE FROM bs_sterling_ratio WHERE product_id = ?";
        jdbcTemplate.update(sql, new Object[]{product_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final SterlingRatioPo po) {
        final String sql = "UPDATE bs_sterling_ratio  SET SR_NEARLY_A_YEAR = ?, SR_NEARLY_TWO_YEARS  = ?,SR_NEARLY_THREE_YEARS = ?, SR_NEARLY_FIVE_YEARS = ?, SR_SINCE_ITS_ESTABLISHMENT  = ?, product_is_crawler = ? WHERE product_id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, po.getSR_NEARLY_A_YEAR());
                ps.setDouble(2, po.getSR_NEARLY_TWO_YEARS());
                ps.setDouble(3, po.getSR_NEARLY_THREE_YEARS());
                ps.setDouble(4, po.getSR_NEARLY_FIVE_YEARS());
                ps.setDouble(5, po.getSR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(6, po.getProduct_is_crawler());
                ps.setInt(7, po.getProduct_id());
                return ps;
            }
        });
    }

    @Override
    public SterlingRatioPo find(int product_id) {
        String sql = "SELECT * FROM bs_sterling_ratio WHERE product_id = ?";
        List<SterlingRatioPo> sterlingRatioPoList = jdbcTemplate.query(sql, new Object[]{product_id},
                new int[]{Types.INTEGER}, new SterlingRatioPo());
        if (sterlingRatioPoList.isEmpty()) {
            return null;
        } else {
            return sterlingRatioPoList.get(0);
        }
    }
}
