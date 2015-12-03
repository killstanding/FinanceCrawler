package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.SharpRatioPo;
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
public class SharpRatioDao implements ISharpRatio {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final SharpRatioPo po) {
        final String sql = "INSERT INTO bs_sharp_ratio(product_id, SR_NEARLY_A_YEAR, SR_NEARLY_TWO_YEARS, SR_NEARLY_THREE_YEARS, SR_NEARLY_FIVE_YEARS, SR_SINCE_ITS_ESTABLISHMENT, product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?)";
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
        String sql = "DELETE FROM bs_sharp_ratio WHERE product_id = ?";
        jdbcTemplate.update(sql, new Object[]{product_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final SharpRatioPo po) {
        final String sql = "UPDATE bs_sharp_ratio  SET SR_NEARLY_A_YEAR = ?, SR_NEARLY_TWO_YEARS  = ?,SR_NEARLY_THREE_YEARS = ?, SR_NEARLY_FIVE_YEARS = ?, SR_SINCE_ITS_ESTABLISHMENT  = ?, product_is_crawler = ? WHERE product_id = ?";
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
    public SharpRatioPo find(int product_id) {
        String sql = "SELECT * FROM bs_sharp_ratio WHERE product_id = ?";
        List<SharpRatioPo> sharpRatioPoList = jdbcTemplate.query(sql, new Object[]{product_id},
                new int[]{Types.INTEGER}, new SharpRatioPo());
        if (sharpRatioPoList.isEmpty()) {
            return null;
        } else {
            return sharpRatioPoList.get(0);
        }
    }
}
