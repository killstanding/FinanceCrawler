package com.jerry.financecrawler.vo;

/**
 * 基金管理人
 * Created by Jerry on 15/11/12.
 */
public class FundManagePeopleVo {
    private int id ;
    private String fund_name ;// 基金管理人
    private String fund_date ;// 成立时间
    private String fund_assets;// 管理人管理资产
    private int fund_product_no;// 管理人管理产品数量
    private String fund_count;//投研人数
    private int product_is_crawler;// 是否为爬取 1 是 0 不是

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFund_name() {
        return fund_name;
    }

    public void setFund_name(String fund_name) {
        this.fund_name = fund_name;
    }

    public String getFund_date() {
        return fund_date;
    }

    public void setFund_date(String fund_date) {
        this.fund_date = fund_date;
    }

    public String getFund_assets() {
        return fund_assets;
    }

    public void setFund_assets(String fund_assets) {
        this.fund_assets = fund_assets;
    }

    public int getFund_product_no() {
        return fund_product_no;
    }

    public void setFund_product_no(int fund_product_no) {
        this.fund_product_no = fund_product_no;
    }

    public String getFund_count() {
        return fund_count;
    }

    public void setFund_count(String fund_count) {
        this.fund_count = fund_count;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "FundManagePeople{" +
                "id=" + id +
                ", fund_name='" + fund_name + '\'' +
                ", fund_date='" + fund_date + '\'' +
                ", fund_assets='" + fund_assets + '\'' +
                ", fund_product_no=" + fund_product_no +
                ", fund_count='" + fund_count + '\'' +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
