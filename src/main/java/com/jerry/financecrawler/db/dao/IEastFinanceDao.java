package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.EastFinancePo;

/**
 * Created by Jerry on 2015/9/20.
 */
public interface IEastFinanceDao {
    void save(EastFinancePo eastFinancePo);

    void remove(String id);

    void modify(EastFinancePo eastFinancePo);

    EastFinancePo find(String id);
}
