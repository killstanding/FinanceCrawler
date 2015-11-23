package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.HistoricalNetPo;

/**
 * Created by Jerry on 2015/9/20
 * 历史净值 接口.
 */
public interface IHistoricalNet {
    void save(HistoricalNetPo historicalNetPo);

    void remove(int id);

    void modify(HistoricalNetPo historicalNetPo);

    HistoricalNetPo find(int id);

    HistoricalNetPo findByProductIDAndDate(String product_id, String date);

    Integer getMaxId();
}
