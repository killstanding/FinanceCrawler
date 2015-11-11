package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.EastFinancePo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jerry on 2015/9/20.
 */

@Repository
public class EastFinanceDao implements IEastFinanceDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final EastFinancePo eastFinancePo) {
        final String sql = "INSERT INTO t_c_east_finance (id, FINCODE, FULLNAME,SHORTNAME, ESTABDATE, MANAGERCODE,MANAGER, SMANAGER, TRUSTEECODE,TRUSTEE, STRUSTEE, SCUSTDN, MGRNAME,PDATE, NAV, ACCNAV,HY, Y, TWY,SY) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, eastFinancePo.getId());
                ps.setString(2, eastFinancePo.getFINCODE());
                ps.setString(3, eastFinancePo.getFULLNAME());
                ps.setString(4, eastFinancePo.getSHORTNAME());
                ps.setString(5, eastFinancePo.getESTABDATE());

                ps.setString(6, eastFinancePo.getMANAGERCODE());
                ps.setString(7, eastFinancePo.getMANAGER());
                ps.setString(8, eastFinancePo.getSMANAGER());
                ps.setString(9, eastFinancePo.getTRUSTEECODE());
                ps.setString(10, eastFinancePo.getTRUSTEE());

                ps.setString(11, eastFinancePo.getSTRUSTEE());
                ps.setString(12, eastFinancePo.getSCUSTDN());
                ps.setString(13, eastFinancePo.getMGRNAME());
                ps.setString(14, eastFinancePo.getPDATE());
                ps.setString(15, eastFinancePo.getNAV());

                ps.setString(16, eastFinancePo.getACCNAV());
                ps.setString(17, eastFinancePo.getHY());
                ps.setString(18, eastFinancePo.getY());
                ps.setString(19, eastFinancePo.getTWY());
                ps.setString(20, eastFinancePo.getSY());
                return ps;
            }
        });
    }

    @Override
    public void remove(String id) {
        String sql = "DELETE FROM t_c_east_finance WHERE id=" + id;
        jdbcTemplate.update(sql);
    }

    @Override
    public void modify(final EastFinancePo eastFinancePo) {
        final String sql = "update t_c_east_finance SET FINCODE = ?, FULLNAME = ?, SHORTNAME = ?, ESTABDATE = ?, MANAGERCODE = ?, MANAGER = ?, SMANAGER = ?, TRUSTEECODE = ?, TRUSTEE = ?, STRUSTEE = ?, SCUSTDN = ?, MGRNAME = ?, PDATE = ?, NAV = ?, ACCNAV = ?, HY = ?, Y = ?, TWY = ?, SY = ? WHERE id = ? ";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, eastFinancePo.getFINCODE());
                ps.setString(2, eastFinancePo.getFULLNAME());
                ps.setString(3, eastFinancePo.getSHORTNAME());
                ps.setString(4, eastFinancePo.getESTABDATE());

                ps.setString(5, eastFinancePo.getMANAGERCODE());
                ps.setString(6, eastFinancePo.getMANAGER());
                ps.setString(7, eastFinancePo.getSMANAGER());
                ps.setString(8, eastFinancePo.getTRUSTEECODE());
                ps.setString(9, eastFinancePo.getTRUSTEE());

                ps.setString(10, eastFinancePo.getSTRUSTEE());
                ps.setString(11, eastFinancePo.getSCUSTDN());
                ps.setString(12, eastFinancePo.getMGRNAME());
                ps.setString(13, eastFinancePo.getPDATE());
                ps.setString(14, eastFinancePo.getNAV());

                ps.setString(15, eastFinancePo.getACCNAV());
                ps.setString(16, eastFinancePo.getHY());
                ps.setString(17, eastFinancePo.getY());
                ps.setString(18, eastFinancePo.getTWY());
                ps.setString(19, eastFinancePo.getSY());

                ps.setString(20, eastFinancePo.getId());
                return ps;
            }
        });
    }

    @Override
    public EastFinancePo find(String id) {
        String sql = "SELECT * FROM t_c_east_finance WHERE id=" + id;
        List<EastFinancePo> eastFinancePoList = jdbcTemplate.query(sql, new EastFinancePo());
        if (eastFinancePoList.isEmpty()) {
            return null;
        } else {
            return eastFinancePoList.get(0);
        }
    }
}
