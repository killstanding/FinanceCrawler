package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.IncomePo;

/**
 * Created by Jerry on 2015/9/20.
 * 收益率
 */
public interface IIncomeDao {
    void save(IncomePo incomePo);

    void remove(String product_id);

    void modify(IncomePo incomePo);

    IncomePo find(String product_id);
}
