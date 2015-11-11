package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.FundProductPo;

import java.util.List;

/**
 * Created by Jerry on 2015/9/20.
 * 基金产品
 */
public interface IFundProductDao {
    void save(FundProductPo fundProductPo);

    void remove(int id);

    void modify(FundProductPo fundProductPo);

    FundProductPo find(int id);

    List<FundProductPo> findAll();

    FundProductPo findByCodeOrName(String product_code, String product_name);

    Integer getMaxId();
}
