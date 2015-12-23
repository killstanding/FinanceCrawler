package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.HSVo;
import com.jerry.financecrawler.vo.IncomeVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jerry on 2015/9/20.
 */
public class HSPo extends HSVo implements RowMapper<HSPo> {
    @Override
    public int hashCode() {
        return getId() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        HSPo hsPo = (HSPo) obj;
        if (this.getId() != hsPo.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public HSPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        HSPo hsPo = new HSPo();
        hsPo.setId(rs.getInt("id"));
        hsPo.setDate(rs.getString("date"));//日期
        hsPo.setKpj(rs.getDouble("kpj"));//开盘价
        hsPo.setZgj(rs.getDouble("zgj"));//最高价
        hsPo.setSpj(rs.getDouble("spj"));//收盘价
        hsPo.setZdj(rs.getDouble("zdj"));//最低价
        hsPo.setJyl(rs.getDouble("jyl"));//交易量(股)
        hsPo.setJyje(rs.getDouble("jyje"));//交易金额(元)
        hsPo.setZdf(rs.getDouble("zdf"));//涨跌幅
        return hsPo;
    }
}
