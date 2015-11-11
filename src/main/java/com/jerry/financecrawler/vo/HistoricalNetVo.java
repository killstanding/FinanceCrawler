package com.jerry.financecrawler.vo;

/**
 * Created by Jerry on 2015/10/9.
 * 历史净值
 */
public class HistoricalNetVo {
    private int id;
    private int product_id; //产品id-唯一值
    private String product_code; //产品代码
    private String net_worth_date; //date 净值日期
    private double unit_net_worth; //单位净值
    private double add_net_worth; //累计净值
    private double Chg; //涨跌幅
    private int product_is_crawler = 1; //是否为爬取 1 是 0 不是

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

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getNet_worth_date() {
        return net_worth_date;
    }

    public void setNet_worth_date(String net_worth_date) {
        this.net_worth_date = net_worth_date;
    }

    public double getUnit_net_worth() {
        return unit_net_worth;
    }

    public void setUnit_net_worth(double unit_net_worth) {
        this.unit_net_worth = unit_net_worth;
    }

    public double getAdd_net_worth() {
        return add_net_worth;
    }

    public void setAdd_net_worth(double add_net_worth) {
        this.add_net_worth = add_net_worth;
    }

    public double getChg() {
        return Chg;
    }

    public void setChg(double chg) {
        Chg = chg;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "HistoricalNetVo{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", product_code='" + product_code + '\'' +
                ", net_worth_date='" + net_worth_date + '\'' +
                ", unit_net_worth=" + unit_net_worth +
                ", add_net_worth=" + add_net_worth +
                ", Chg=" + Chg +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
