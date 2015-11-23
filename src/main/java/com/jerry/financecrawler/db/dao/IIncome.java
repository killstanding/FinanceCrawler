package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.IncomePo;

/**
 * Created by Jerry on 2015/9/20.
 * 收益率
 */
public interface IIncome {
    void save(IncomePo incomePo);

    void remove(int product_id);

    void modify(IncomePo incomePo);

    IncomePo find(int product_id);
}
