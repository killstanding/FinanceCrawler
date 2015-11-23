package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.AnnualizedReturnRatePo;

/**
 * Created by Jerry on 15/11/16.
 */
public interface IAnnualizedReturnRate {
    void save(AnnualizedReturnRatePo po);

    void remove(int product_id);

    void modify(AnnualizedReturnRatePo po);

    AnnualizedReturnRatePo find(int product_id);
}
