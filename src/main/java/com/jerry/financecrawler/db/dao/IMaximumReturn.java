package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.MaximumReturnPo;

/**
 * Created by Jerry on 15/11/17.
 */
public interface IMaximumReturn {

    void save(MaximumReturnPo po);

    void remove(int product_id);

    void modify(MaximumReturnPo po);

    MaximumReturnPo find(int product_id);
}
