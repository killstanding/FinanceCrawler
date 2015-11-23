package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.CostRatePo;

/**
 * Created by Jerry on 15/11/16.
 */
public interface ICostRate {
    void save(CostRatePo po);

    void remove(int product_id);

    void modify(CostRatePo po);

    CostRatePo find(int product_id);
}
