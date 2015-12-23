package com.jerry.financecrawler.db.po;

import com.jerry.financecrawler.vo.FundManagerVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 基金经理
 * Created by Jerry on 15/11/12.
 */
public class FundManagerPo extends FundManagerVo implements RowMapper<FundManagerPo> {

    @Override
    public int hashCode() {
        return getFundmanager_id() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        FundManagerPo fundManagerPo = (FundManagerPo) obj;
        if (this.getFundmanager_id() != fundManagerPo.getFundmanager_id()) {
            return false;
        }
        return true;
    }

    @Override
    public FundManagerPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        FundManagerPo fundManagerPo = new FundManagerPo();
        fundManagerPo.setFundmanager_id(rs.getInt("fundmanager_id"));
        fundManagerPo.setID(rs.getInt("ID"));
        fundManagerPo.setBS_NAME(rs.getString("BS_NAME"));//基金经理
        fundManagerPo.setBS_FUND_MANAGEMENT_START_DATE(rs.getString("BS_FUND_MANAGEMENT_START_DATE"));//基金起始管理日期
        fundManagerPo.setBS_FUND_MANAGEMENT_END_DATE(rs.getString("BS_FUND_MANAGEMENT_END_DATE"));//基金结束管理日期
        fundManagerPo.setBS_MANAGEMENT_FUND_NUM(rs.getInt("BS_MANAGEMENT_FUND_NUM"));//管理基金数
        fundManagerPo.setBS_HISTORICAL_MANANGEMENT_FUND_NUM(rs.getInt("BS_HISTORICAL_MANANGEMENT_FUND_NUM"));//历史管理基金数
        fundManagerPo.setBS_UNIVERSITY(rs.getString("BS_UNIVERSITY"));//毕业院校
        fundManagerPo.setBS_EDUCATION(rs.getString("BS_EDUCATION"));//学历
        fundManagerPo.setBS_PROFESSIONAL(rs.getString("BS_PROFESSIONAL"));//专业
        fundManagerPo.setBS_WORKING_TIME(rs.getInt("BS_WORKING_TIME"));//从业时间
        fundManagerPo.setBS_WORKING_YEAR(rs.getString("BS_WORKING_YEAR"));//从业年限
        fundManagerPo.setProduct_is_crawler(rs.getInt("product_is_crawler")); //是否为爬取 1 是 0 不是
        return fundManagerPo;
    }

}
