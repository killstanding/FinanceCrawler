package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.SterlingRatioPo;

/**
 * Created by Jerry on 15/11/17.
 */
public interface ISterlingRatio {
    void save(SterlingRatioPo po);

    void remove(int product_id);

    void modify(SterlingRatioPo po);

    SterlingRatioPo find(int product_id);
}
