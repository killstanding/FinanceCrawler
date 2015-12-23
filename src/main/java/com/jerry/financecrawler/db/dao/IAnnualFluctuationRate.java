package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.AnnualFluctuationRatePo;

/**
 * Created by Jerry on 15/11/16.
 */
public interface IAnnualFluctuationRate {

    void save(AnnualFluctuationRatePo po);

    void remove(int product_id);

    void modify(AnnualFluctuationRatePo po);

    AnnualFluctuationRatePo find(int product_id);

}
