package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.ProductReFundManagerPo;

/**
 * Created by Jerry on 15/11/17.
 */
public interface IProductReFundManager {
    void save(ProductReFundManagerPo po);

    void remove(int id);

    void modify(ProductReFundManagerPo po);

    ProductReFundManagerPo find(int id);

    ProductReFundManagerPo findByProductIDAndFundManagerID(int product_id, int bs_fundmanager);

    Integer getMaxId();
}
