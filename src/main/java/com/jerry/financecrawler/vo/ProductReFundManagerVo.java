package com.jerry.financecrawler.vo;

/**
 * Created by Jerry on 15/11/12.
 */
public class ProductReFundManagerVo {
    private int id ;
    private int product_id;//产品ID
    private int bs_fundmanager; //基金经理
    private int product_is_crawler = 1;//是否为爬取 1 是 0 不是

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getBs_fundmanager() {
        return bs_fundmanager;
    }

    public void setBs_fundmanager(int bs_fundmanager) {
        this.bs_fundmanager = bs_fundmanager;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }


    @Override
    public String toString() {
        return "ProductReFundManagerVo{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", bs_fundmanager=" + bs_fundmanager +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
