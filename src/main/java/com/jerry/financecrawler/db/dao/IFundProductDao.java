package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.FundProductPo;

import java.util.List;

/**
 * Created by Jerry on 2015/9/20.
 * 基金产品
 */
public interface IFundProductDao {
    void save(FundProductPo fundProductPo);

    void remove(String id);

    void modify(FundProductPo fundProductPo);

    FundProductPo find(String id);

    List<FundProductPo> findAll();
}
