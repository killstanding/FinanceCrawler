package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.HistoricalNetPo;

/**
 * Created by Jerry on 2015/9/20
 * 历史净值 接口.
 */
public interface IHistoricalNetDao {
    void save(HistoricalNetPo historicalNetPo);

    void remove(String id);

    void modify(HistoricalNetPo historicalNetPo);

    HistoricalNetPo find(String id);

    HistoricalNetPo findByProductIDAndDate(String product_id, String date);

    int getMaxId();
}
