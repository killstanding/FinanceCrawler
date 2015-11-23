package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.CalmarRatioPo;
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
public class CalmarRatioDao  implements  ICalmarRatio{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final CalmarRatioPo po) {
        final String sql = "INSERT INTO bs_calmar_ratio( product_id,CR_NEARLY_A_YEAR,CR_NEARLY_TWO_YEARS,CR_NEARLY_THREE_YEARS,CR_NEARLY_FIVE_YEARS,CR_SINCE_ITS_ESTABLISHMENT,product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getProduct_id());
                ps.setDouble(2, po.getCR_NEARLY_A_YEAR());
                ps.setDouble(3, po.getCR_NEARLY_TWO_YEARS());
                ps.setDouble(4, po.getCR_NEARLY_THREE_YEARS());
                ps.setDouble(5, po.getCR_NEARLY_FIVE_YEARS());
                ps.setDouble(6, po.getCR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(7, po.getProduct_is_crawler());
                return ps;
            }
        });

    }

    @Override
    public void remove(int product_id) {
        String sql = "DELETE FROM bs_calmar_ratio WHERE product_id = ?";
        jdbcTemplate.update(sql, new Object[]{product_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final CalmarRatioPo po) {
        final String sql = "UPDATE bs_calmar_ratio  SET CR_NEARLY_A_YEAR = ?, CR_NEARLY_TWO_YEARS  = ?,CR_NEARLY_THREE_YEARS = ?, CR_NEARLY_FIVE_YEARS = ?, CR_SINCE_ITS_ESTABLISHMENT  = ?, product_is_crawler = ? WHERE product_id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, po.getCR_NEARLY_A_YEAR());
                ps.setDouble(2, po.getCR_NEARLY_TWO_YEARS());
                ps.setDouble(3, po.getCR_NEARLY_THREE_YEARS());
                ps.setDouble(4, po.getCR_NEARLY_FIVE_YEARS());
                ps.setDouble(5, po.getCR_SINCE_ITS_ESTABLISHMENT());
                ps.setInt(6, po.getProduct_is_crawler());
                ps.setInt(7, po.getProduct_id());
                return ps;
            }
        });
    }

    @Override
    public CalmarRatioPo find(int product_id) {
        String sql = "SELECT * FROM bs_calmar_ratio WHERE product_id = ?";
        List<CalmarRatioPo> calmarRatioPoList = jdbcTemplate.query(sql, new Object[]{product_id},
                new int[]{Types.INTEGER}, new CalmarRatioPo());
        if (calmarRatioPoList.isEmpty()) {
            return null;
        } else {
            return calmarRatioPoList.get(0);
        }
    }
}
