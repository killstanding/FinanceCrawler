package com.jerry.financecrawler.vo;

/**
 * 管理人产品关联关系表
 * Created by Jerry on 15/11/12.
 */
public class ProductReFundManagePeopleVo {

    private int id ;
    private int product_id;//产品ID
    private int bs_fund; //管理人
    private int product_is_crawler;//是否为爬取 1 是 0 不是
    private String url; //管理人关联url

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

    public int getBs_fund() {
        return bs_fund;
    }

    public void setBs_fund(int bs_fund) {
        this.bs_fund = bs_fund;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ProductReFundVo{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", bs_fund=" + bs_fund +
                ", product_is_crawler=" + product_is_crawler +
                ", url='" + url + '\'' +
                '}';
    }
}
