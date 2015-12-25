package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.db.po.FundProductPo;
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
 * 基金产品
 */

@Repository
public class FundProductDao implements IFundProduct {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final FundProductPo fundProductPo) {
        final String sql = "INSERT INTO bs_product(id , product_name , product_shortname ,product_code ," +
                " isactice , supplier_code ,product_nature ,product_bank ,product_COOPERATIVE_SECURITIES_INSTITUTION ," +
                " product_COOPERATIVE_FUTURES_AGENCY ,product_ESTABLISHMENT_DATE ,product_DURATION_YEAR ,product_DURATION_EXISTENCE_YEAR ," +
                " product_TERMINATION_CONTION ,product_TYPE ,product_INVESTMENT_TYPE ,product_INVESTMENT_TYPE_DETAIL ," +
                " product_info , product_INVESTMENT_TARGETS ,product_INVESTMENT_RATIO ,product_EXPECTED_RETURN ,product_HEDGE_RATIO," +
                " product_INVESTMENT_THRESHOLD ,product_ADDITIONAL_AMOUNT ,product_OPEN_PERIOD ,product_OPEN_FREQUENCY ," +
                " product_CLOSURE_PERIOD ,product_EARLY_WARNING_LINE ,product_STOP_LINE ,product_CLASSIFICATON ,product_GRADING_SCALE ," +
                " product_OTHERS ,product_price ,createdate ,productcategory_code ,product_image_url ,product_is_crawler ) " +
                "VALUES (?, ?,  ?,  ?,  ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, fundProductPo.getId());
                ps.setString(2, fundProductPo.getProduct_name());
                ps.setString(3, fundProductPo.getProduct_shortname());
                ps.setString(4, fundProductPo.getProduct_code());
                ps.setString(5, fundProductPo.getIsactice());

                ps.setString(6, fundProductPo.getSupplier_code());
                ps.setString(7, fundProductPo.getProduct_nature());
                ps.setString(8, fundProductPo.getProduct_bank());
                ps.setString(9, fundProductPo.getProduct_COOPERATIVE_SECURITIES_INSTITUTION());
                ps.setString(10, fundProductPo.getProduct_COOPERATIVE_FUTURES_AGENCY());

                ps.setString(11, fundProductPo.getProduct_ESTABLISHMENT_DATE());
                ps.setInt(12, fundProductPo.getProduct_DURATION_YEAR());
                ps.setInt(13, fundProductPo.getProduct_DURATION_EXISTENCE_YEAR());
                ps.setString(14, fundProductPo.getProduct_TERMINATION_CONTION());
                ps.setString(15, fundProductPo.getProduct_TYPE());

                ps.setString(16, fundProductPo.getProduct_INVESTMENT_TYPE());
                ps.setString(17, fundProductPo.getProduct_INVESTMENT_TYPE_DETAIL());
                ps.setString(18, fundProductPo.getProduct_info());
                ps.setString(19, fundProductPo.getProduct_INVESTMENT_TARGETS());
                ps.setString(20, fundProductPo.getProduct_INVESTMENT_RATIO());

                ps.setDouble(21, fundProductPo.getProduct_EXPECTED_RETURN());
                ps.setDouble(22, fundProductPo.getProduct_HEDGE_RATIO());
                ps.setDouble(23, fundProductPo.getProduct_INVESTMENT_THRESHOLD());
                ps.setInt(24, fundProductPo.getProduct_ADDITIONAL_AMOUNT());
                ps.setString(25, fundProductPo.getProduct_OPEN_PERIOD());

                ps.setString(26, fundProductPo.getProduct_OPEN_FREQUENCY());
                ps.setInt(27, fundProductPo.getProduct_CLOSURE_PERIOD());
                ps.setDouble(28, fundProductPo.getProduct_EARLY_WARNING_LINE());
                ps.setDouble(29, fundProductPo.getProduct_STOP_LINE());
                ps.setString(30, fundProductPo.getProduct_CLASSIFICATON());

                ps.setString(31, fundProductPo.getProduct_GRADING_SCALE());
                ps.setString(32, fundProductPo.getProduct_OTHERS());
                ps.setDouble(33, fundProductPo.getProduct_price());
                ps.setString(34, fundProductPo.getCreatedate());
                ps.setString(35, fundProductPo.getProductcategory_code());

                ps.setString(36, fundProductPo.getProduct_image_url());
                ps.setInt(37, fundProductPo.getProduct_is_crawler());
                return ps;
            }
        });
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM bs_product WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id}, new int[]{Types.INTEGER});
    }

    @Override
    public void modify(final FundProductPo fundProductPo) {
        final String sql = "update bs_product set product_name = ? , product_shortname = ? ,product_code = ?," +
                " isactice = ? , supplier_code = ? ,product_nature = ? ,product_bank = ? ,product_COOPERATIVE_SECURITIES_INSTITUTION = ? ," +
                " product_COOPERATIVE_FUTURES_AGENCY = ? ,product_ESTABLISHMENT_DATE = ? ,product_DURATION_YEAR = ? ,product_DURATION_EXISTENCE_YEAR = ? ," +
                " product_TERMINATION_CONTION = ? ,product_TYPE = ? ,product_INVESTMENT_TYPE = ? ,product_INVESTMENT_TYPE_DETAIL = ? ," +
                " product_info = ?, product_INVESTMENT_TARGETS = ? ,product_INVESTMENT_RATIO = ? ,product_EXPECTED_RETURN = ? ,product_HEDGE_RATIO = ?," +
                " product_INVESTMENT_THRESHOLD = ? ,product_ADDITIONAL_AMOUNT = ? ,product_OPEN_PERIOD = ? ,product_OPEN_FREQUENCY = ? ," +
                " product_CLOSURE_PERIOD = ? ,product_EARLY_WARNING_LINE = ? ,product_STOP_LINE = ? ,product_CLASSIFICATON = ? ,product_GRADING_SCALE = ? ," +
                " product_OTHERS = ? ,product_price = ? ,createdate = ?,productcategory_code = ? ,product_image_url = ? ,product_is_crawler = ? where id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, fundProductPo.getProduct_name());
                ps.setString(2, fundProductPo.getProduct_shortname());
                ps.setString(3, fundProductPo.getProduct_code());
                ps.setString(4, fundProductPo.getIsactice());

                ps.setString(5, fundProductPo.getSupplier_code());
                ps.setString(6, fundProductPo.getProduct_nature());
                ps.setString(7, fundProductPo.getProduct_bank());
                ps.setString(8, fundProductPo.getProduct_COOPERATIVE_SECURITIES_INSTITUTION());
                ps.setString(9, fundProductPo.getProduct_COOPERATIVE_FUTURES_AGENCY());

                ps.setString(10, fundProductPo.getProduct_ESTABLISHMENT_DATE());
                ps.setInt(11, fundProductPo.getProduct_DURATION_YEAR());
                ps.setInt(12, fundProductPo.getProduct_DURATION_EXISTENCE_YEAR());
                ps.setString(13, fundProductPo.getProduct_TERMINATION_CONTION());
                ps.setString(14, fundProductPo.getProduct_TYPE());

                ps.setString(15, fundProductPo.getProduct_INVESTMENT_TYPE());
                ps.setString(16, fundProductPo.getProduct_INVESTMENT_TYPE_DETAIL());
                ps.setString(17, fundProductPo.getProduct_info());
                ps.setString(18, fundProductPo.getProduct_INVESTMENT_TARGETS());
                ps.setString(19, fundProductPo.getProduct_INVESTMENT_RATIO());

                ps.setDouble(20, fundProductPo.getProduct_EXPECTED_RETURN());
                ps.setDouble(21, fundProductPo.getProduct_HEDGE_RATIO());
                ps.setDouble(22, fundProductPo.getProduct_INVESTMENT_THRESHOLD());
                ps.setInt(23, fundProductPo.getProduct_ADDITIONAL_AMOUNT());
                ps.setString(24, fundProductPo.getProduct_OPEN_PERIOD());

                ps.setString(25, fundProductPo.getProduct_OPEN_FREQUENCY());
                ps.setInt(26, fundProductPo.getProduct_CLOSURE_PERIOD());
                ps.setDouble(27, fundProductPo.getProduct_EARLY_WARNING_LINE());
                ps.setDouble(28, fundProductPo.getProduct_STOP_LINE());
                ps.setString(29, fundProductPo.getProduct_CLASSIFICATON());

                ps.setString(30, fundProductPo.getProduct_GRADING_SCALE());
                ps.setString(31, fundProductPo.getProduct_OTHERS());
                ps.setDouble(32, fundProductPo.getProduct_price());
                ps.setString(33, fundProductPo.getCreatedate());
                ps.setString(34, fundProductPo.getProductcategory_code());

                ps.setString(35, fundProductPo.getProduct_image_url());
                ps.setInt(36, fundProductPo.getProduct_is_crawler());

                ps.setInt(37, fundProductPo.getId());
                return ps;
            }
        });
    }

    @Override
    public FundProductPo find(int id) {
        String sql = "SELECT * FROM bs_product WHERE id = ?";
        List<FundProductPo> fundProductPoList = jdbcTemplate.query(sql, new Object[]{id},
                new int[]{Types.INTEGER}, new FundProductPo());
        if (fundProductPoList.isEmpty()) {
            return null;
        } else {
            return fundProductPoList.get(0);
        }
    }

    @Override
    public List<FundProductPo> findAll() {
        String sql = "SELECT * FROM bs_product order by id";
        List<FundProductPo> fundProductPoList = jdbcTemplate.query(sql, new FundProductPo());

        return fundProductPoList;
    }

    @Override
    public FundProductPo findByCodeOrName(String product_code, String product_name){
        List<FundProductPo> fundProductPoList = null;
        String sql = "";
        if(StringUtil.isEmpty(product_code)){
            sql = "SELECT * FROM bs_product WHERE product_name = ? or product_shortname = ?";
            fundProductPoList = jdbcTemplate.query(sql, new Object[]{product_name, product_name},
                    new int[]{Types.VARCHAR,Types.VARCHAR}, new FundProductPo());
        }else{
            sql = "SELECT * FROM bs_product WHERE product_code = ? or product_name = ? or product_shortname = ?";
            fundProductPoList = jdbcTemplate.query(sql, new Object[]{product_code, product_name, product_name},
                    new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR}, new FundProductPo());
        }

        if (fundProductPoList.isEmpty()) {
            return null;
        } else {
            return fundProductPoList.get(0);
        }
    }

    @Override
    public Integer getMaxId() {
        String sql = "select max(id) as maxid from bs_product";
        Integer maxId = jdbcTemplate.queryForObject(sql, Integer.class);
        return maxId;
    }
}
