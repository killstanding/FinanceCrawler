package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.CalmarRatioPo;

/**
 * Created by Jerry on 15/11/16.
 */
public interface ICalmarRatio {
    void save(CalmarRatioPo po);

    void remove(int product_id);

    void modify(CalmarRatioPo po);

    CalmarRatioPo find(int product_id);
}
