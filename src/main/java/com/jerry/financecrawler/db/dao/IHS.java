package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.HSPo;

/**
 * Created by Jerry on 2015/9/20.
 * 沪深300
 */
public interface IHS {
    void save(HSPo hsPo);

    void remove(int id);

    void modify(HSPo hsPo);

    HSPo find(int id);

    HSPo findByDate(String date);

    public Integer getMaxId();

    HSPo findPreData(String date);

}
