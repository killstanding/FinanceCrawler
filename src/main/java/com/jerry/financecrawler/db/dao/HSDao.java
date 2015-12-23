package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.HSPo;
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
 * 沪深300
 */

@Repository
public class HSDao implements IHS {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final HSPo hsPo) {
        final String sql = "INSERT INTO hs300(id, date, kpj, zgj, spj, zdj, jyl, jyje, zdf) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, hsPo.getId());
                ps.setString(2, hsPo.getDate());
                ps.setDouble(3, hsPo.getKpj());
                ps.setDouble(4, hsPo.getZgj());
                ps.setDouble(5, hsPo.getSpj());
                ps.setDouble(6, hsPo.getZdj());
                ps.setDouble(7, hsPo.getJyl());
                ps.setDouble(8, hsPo.getJyje());
                ps.setDouble(9, hsPo.getZdf());
                return ps;
            }
        });
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM hs300 WHERE id = ?" ;
        jdbcTemplate.update(sql, new Object[]{id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final HSPo hsPo) {
        final String sql = "UPDATE hs300 SET date = ?, kpj = ?, zgj = ?, spj = ?, zdj = ?, jyl = ?, jyje = ?, zdf = ? WHERE id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, hsPo.getDate());
                ps.setDouble(2, hsPo.getKpj());
                ps.setDouble(3, hsPo.getZgj());
                ps.setDouble(4, hsPo.getSpj());
                ps.setDouble(5, hsPo.getZdj());
                ps.setDouble(6, hsPo.getJyl());
                ps.setDouble(7, hsPo.getJyje());
                ps.setDouble(8, hsPo.getZdf());

                ps.setInt(9, hsPo.getId());
                return ps;
            }
        });
    }

    @Override
    public HSPo find(int id) {
        String sql = "SELECT * FROM hs300 WHERE id = ?" ;
        List<HSPo> hsPoList = jdbcTemplate.query(sql,new Object[]{id},
                new int[]{Types.INTEGER}, new HSPo());
        if (hsPoList.isEmpty()) {
            return null;
        } else {
            return hsPoList.get(0);
        }
    }

    @Override
    public HSPo findByDate(String date) {
        String sql = "SELECT * FROM hs300 WHERE date = ?" ;
        List<HSPo> hsPoList = jdbcTemplate.query(sql,new Object[]{date},
                new int[]{Types.VARCHAR}, new HSPo());
        if (hsPoList.isEmpty()) {
            return null;
        } else {
            return hsPoList.get(0);
        }
    }

    @Override
    public Integer getMaxId() {
        String sql = "select max(id) as maxid from hs300";
        Integer maxId = jdbcTemplate.queryForObject(sql, Integer.class);
        return maxId;
    }

    @Override
    public HSPo findPreData(String date) {
        String sql = "SELECT * FROM  hs300 where date != ? ORDER BY date DESC" ;
        List<HSPo> hsPoList = jdbcTemplate.query(sql,new Object[]{date},
                new int[]{Types.VARCHAR}, new HSPo());
        if (hsPoList.isEmpty()) {
            return null;
        } else {
            return hsPoList.get(0);
        }
    }
}
