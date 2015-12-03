package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.FundManagerPo;
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
public class FundManagerDao implements IFundManager {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final FundManagerPo po) {
        final String sql = "INSERT INTO bs_fundmanager(fundmanager_id, ID, BS_NAME, BS_FUND_MANAGEMENT_START_DATE, BS_FUND_MANAGEMENT_END_DATE, BS_MANAGEMENT_FUND_NUM, BS_HISTORICAL_MANANGEMENT_FUND_NUM, BS_UNIVERSITY, BS_EDUCATION, BS_PROFESSIONAL, BS_WORKING_TIME, BS_WORKING_YEAR, product_is_crawler) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getFundmanager_id());
                ps.setInt(2, po.getID());
                ps.setString(3, po.getBS_NAME());
                ps.setString(4, po.getBS_FUND_MANAGEMENT_START_DATE());
                ps.setString(5, po.getBS_FUND_MANAGEMENT_END_DATE());
                ps.setInt(6, po.getBS_MANAGEMENT_FUND_NUM());
                ps.setInt(7, po.getBS_HISTORICAL_MANANGEMENT_FUND_NUM());
                ps.setString(8, po.getBS_UNIVERSITY());
                ps.setString(9, po.getBS_EDUCATION());
                ps.setString(10, po.getBS_PROFESSIONAL());
                ps.setString(11, po.getBS_WORKING_TIME());
                ps.setString(12, po.getBS_WORKING_YEAR());
                ps.setInt(13, po.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int fundmanager_id) {
        String sql = "DELETE FROM bs_fundmanager WHERE fundmanager_id = ?";
        jdbcTemplate.update(sql, new Object[]{fundmanager_id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final FundManagerPo po) {
        final String sql = "UPDATE bs_fundmanager SET ID = ?, BS_NAME = ?, BS_FUND_MANAGEMENT_START_DATE = ?, BS_FUND_MANAGEMENT_END_DATE = ?, BS_MANAGEMENT_FUND_NUM = ?, BS_HISTORICAL_MANANGEMENT_FUND_NUM = ?, BS_UNIVERSITY = ?, BS_EDUCATION = ?, BS_PROFESSIONAL = ?, BS_WORKING_TIME = ?, BS_WORKING_YEAR = ?, product_is_crawler = ? where fundmanager_id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, po.getID());
                ps.setString(2, po.getBS_NAME());
                ps.setString(3, po.getBS_FUND_MANAGEMENT_START_DATE());
                ps.setString(4, po.getBS_FUND_MANAGEMENT_END_DATE());
                ps.setInt(5, po.getBS_MANAGEMENT_FUND_NUM());
                ps.setInt(6, po.getBS_HISTORICAL_MANANGEMENT_FUND_NUM());
                ps.setString(7, po.getBS_UNIVERSITY());
                ps.setString(8, po.getBS_EDUCATION());
                ps.setString(9, po.getBS_PROFESSIONAL());
                ps.setString(10, po.getBS_WORKING_TIME());
                ps.setString(11, po.getBS_WORKING_YEAR());
                ps.setInt(12, po.getProduct_is_crawler());
                ps.setInt(13, po.getFundmanager_id());
                return ps;
            }
        });
    }

    @Override
    public FundManagerPo find(int fundmanager_id) {
        String sql = "SELECT * FROM bs_fundmanager WHERE fundmanager_id = ?";
        List<FundManagerPo> fundManagerPoList = jdbcTemplate.query(sql, new Object[]{fundmanager_id},
                new int[]{Types.INTEGER}, new FundManagerPo());
        if (fundManagerPoList.isEmpty()) {
            return null;
        } else {
            return fundManagerPoList.get(0);
        }
    }

    @Override
    public Integer getMaxId() {
        String sql = "select max(id) as maxid from bs_fundmanager";
        Integer maxId = jdbcTemplate.queryForObject(sql, Integer.class);
        return maxId;
    }
}
