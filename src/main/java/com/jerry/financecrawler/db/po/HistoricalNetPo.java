package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.HistoricalNetVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jerry on 2015/9/20.
 */
public class HistoricalNetPo extends HistoricalNetVo implements RowMapper<HistoricalNetPo> {
    @Override
    public int hashCode() {
        return getId() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        HistoricalNetPo eastFinancePo = (HistoricalNetPo) obj;
        if (this.getId() != eastFinancePo.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public HistoricalNetPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        HistoricalNetPo historicalNetPo = new HistoricalNetPo();
        historicalNetPo.setId(rs.getInt("id"));
        historicalNetPo.setProduct_id(rs.getInt("product_id"));//产品id-唯一值
        historicalNetPo.setProduct_code(rs.getString("product_code"));//产品代码
        historicalNetPo.setNet_worth_date(rs.getString("net_worth_date")); //date 净值日期
        historicalNetPo.setUnit_net_worth(rs.getDouble("unit_net_worth"));//单位净值
        historicalNetPo.setAdd_net_worth(rs.getDouble("add_net_worth"));//累计净值
        historicalNetPo.setChg(rs.getDouble("Chg")); //涨跌幅
        historicalNetPo.setProduct_is_crawler(rs.getInt("product_is_crawler"));//是否为爬取 1 是 0 不是
        return historicalNetPo;
    }
}
