package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.FundManagerPo;

/**
 * Created by Jerry on 15/11/17.
 */
public interface IFundManager {
    void save(FundManagerPo po);

    void remove(int fundmanager_id);

    void modify(FundManagerPo po);

    FundManagerPo find(int fundmanager_id);

    Integer getMaxId();
}
