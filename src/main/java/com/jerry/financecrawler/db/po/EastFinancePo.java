package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.EastFinanceVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jerry on 2015/9/20.
 */
public class EastFinancePo extends EastFinanceVo implements RowMapper<EastFinancePo> {
    @Override
    public int hashCode() {
        return getId().hashCode() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        EastFinancePo eastFinancePo = (EastFinancePo) obj;
        if (!this.getId() .equals( eastFinancePo.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public EastFinancePo mapRow(ResultSet rs, int rowNum) throws SQLException {
        EastFinancePo eastFinancePo = new EastFinancePo();
        eastFinancePo.setId(rs.getString("id"));
        eastFinancePo.setFINCODE(rs.getString("FINCODE"));
        eastFinancePo.setFINCODE(rs.getString("FINCODE"));
        eastFinancePo.setSHORTNAME(rs.getString("SHORTNAME"));
        eastFinancePo.setESTABDATE(rs.getString("ESTABDATE"));
        eastFinancePo.setMANAGERCODE(rs.getString("MANAGERCODE"));
        eastFinancePo.setMANAGER(rs.getString("MANAGER"));
        eastFinancePo.setSMANAGER(rs.getString("SMANAGER"));
        eastFinancePo.setTRUSTEECODE(rs.getString("TRUSTEECODE"));
        eastFinancePo.setTRUSTEE(rs.getString("TRUSTEE"));
        eastFinancePo.setSTRUSTEE(rs.getString("STRUSTEE"));
        eastFinancePo.setSCUSTDN(rs.getString("SCUSTDN"));
        eastFinancePo.setMGRNAME(rs.getString("MGRNAME"));
        eastFinancePo.setPDATE(rs.getString("PDATE"));
        eastFinancePo.setNAV(rs.getString("NAV"));
        eastFinancePo.setACCNAV(rs.getString("ACCNAV"));
        eastFinancePo.setHY(rs.getString("HY"));
        eastFinancePo.setY(rs.getString("Y"));
        eastFinancePo.setTWY(rs.getString("TWY"));
        eastFinancePo.setSY(rs.getString("SY"));
        return eastFinancePo;
    }
}
