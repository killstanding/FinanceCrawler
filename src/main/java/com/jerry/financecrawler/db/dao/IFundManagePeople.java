package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.FundManagePeoplePo;

/**
 * Created by Jerry on 15/11/16.
 */
public interface IFundManagePeople {
    void save(FundManagePeoplePo po);

    void remove(int id);

    void modify(FundManagePeoplePo po);

    FundManagePeoplePo find(int id);

    Integer getMaxId();
}
