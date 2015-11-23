package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.FundManagePeopleVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 基金管理人
 * Created by Jerry on 15/11/12.
 */
public class FundManagePeoplePo extends FundManagePeopleVo implements RowMapper<FundManagePeoplePo> {

    @Override
    public int hashCode() {
        return getId() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        FundManagePeoplePo fundManagePeoplePo = (FundManagePeoplePo) obj;
        if (this.getId() != fundManagePeoplePo.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public FundManagePeoplePo mapRow(ResultSet rs, int rowNum) throws SQLException {
        FundManagePeoplePo fundManagePeoplePo = new FundManagePeoplePo();
        fundManagePeoplePo.setId(rs.getInt("id"));
        fundManagePeoplePo.setFund_name(rs.getString("fund_name"));// 基金管理人
        fundManagePeoplePo.setFund_date(rs.getString("fund_date"));//成立时间
        fundManagePeoplePo.setFund_assets(rs.getString("fund_assets"));//管理人管理资产
        fundManagePeoplePo.setFund_product_no(rs.getInt("fund_product_no"));//管理人管理产品数量
        fundManagePeoplePo.setFund_count(rs.getString("fund_count"));//投研人数
        fundManagePeoplePo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return fundManagePeoplePo;
    }
}
