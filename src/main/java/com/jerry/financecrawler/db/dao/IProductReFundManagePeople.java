package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.ProductReFundManagePeoplePo;

/**
 * Created by Jerry on 15/11/17.
 */
public interface IProductReFundManagePeople {
    void save(ProductReFundManagePeoplePo po);

    void remove(int id);

    void modify(ProductReFundManagePeoplePo po);

    ProductReFundManagePeoplePo find(int id);

    ProductReFundManagePeoplePo findByProductIDAndFundPeopleID(int product_id, int bs_fund);

    Integer getMaxId();
}
