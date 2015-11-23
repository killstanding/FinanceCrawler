package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.SharpRatioPo;

/**
 * Created by Jerry on 15/11/17.
 */
public interface ISharpRatio {

    void save(SharpRatioPo po);

    void remove(int product_id);

    void modify(SharpRatioPo po);

    SharpRatioPo find(int product_id);
}
