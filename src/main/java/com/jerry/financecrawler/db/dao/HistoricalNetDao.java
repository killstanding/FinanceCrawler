package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.HistoricalNetPo;
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
public class HistoricalNetDao implements IHistoricalNet {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final HistoricalNetPo historicalNetPo) {
        final String sql = "INSERT INTO bs_networth(id ,product_id ,product_code ,net_worth_date ," +
                "unit_net_worth ,add_net_worth ,Chg ,product_is_crawler) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, historicalNetPo.getId());
                ps.setInt(2, historicalNetPo.getProduct_id());
                ps.setString(3, historicalNetPo.getProduct_code());
                ps.setString(4, historicalNetPo.getNet_worth_date());
                ps.setDouble(5, historicalNetPo.getUnit_net_worth());

                ps.setDouble(6, historicalNetPo.getAdd_net_worth());
                ps.setDouble(7, historicalNetPo.getChg());
                ps.setInt(8, historicalNetPo.getProduct_is_crawler());

                return ps;
            }
        });
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM bs_networth WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final HistoricalNetPo historicalNetPo) {
        final String sql = "update bs_networth set product_id = ? ,product_code = ? ,net_worth_date = ? ," +
                "unit_net_worth = ? ,add_net_worth = ? ,Chg = ? ,product_is_crawler = ? where id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setInt(1, historicalNetPo.getProduct_id());
                ps.setString(2, historicalNetPo.getProduct_code());
                ps.setString(3, historicalNetPo.getNet_worth_date());
                ps.setDouble(4, historicalNetPo.getUnit_net_worth());

                ps.setDouble(5, historicalNetPo.getAdd_net_worth());
                ps.setDouble(6, historicalNetPo.getChg());
                ps.setInt(7, historicalNetPo.getProduct_is_crawler());

                ps.setInt(8, historicalNetPo.getId());
                return ps;
            }
        });
    }

    @Override
    public HistoricalNetPo find(int id) {
        String sql = "SELECT * FROM bs_networth WHERE id = ?";
        List<HistoricalNetPo> historicalNetPoList = jdbcTemplate.query(sql, new Object[]{id},
                new int[]{Types.INTEGER}, new HistoricalNetPo());
        if (historicalNetPoList.isEmpty()) {
            return null;
        } else {
            return historicalNetPoList.get(0);
        }
    }

    @Override
    public HistoricalNetPo findByProductIDAndDate(String product_code, String net_worth_date) {
        String sql = "SELECT * FROM bs_networth WHERE product_code =  ? and net_worth_date =  ?";
        List<HistoricalNetPo> historicalNetPoList = jdbcTemplate.query(sql, new Object[]{product_code, net_worth_date},
                new int[]{Types.VARCHAR,Types.VARCHAR}, new HistoricalNetPo());
        if (historicalNetPoList.isEmpty()) {
            return null;
        } else {
            return historicalNetPoList.get(0);
        }
    }

    @Override
    public Integer getMaxId() {
        String sql = "select max(id) as maxid from bs_networth";
        Integer maxId = jdbcTemplate.queryForObject(sql, Integer.class);
        return maxId;
    }
}
