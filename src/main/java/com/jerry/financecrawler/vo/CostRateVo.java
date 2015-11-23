package com.jerry.financecrawler.vo;

/**
 * 费用费率
 * Created by Jerry on 15/11/12.
 */
public class CostRateVo {
    private int product_id ;
    private double CR_SUBSCRIPTION_RATE; //认购费率
    private double CR_REDEMPTION_RATE; //赎回费
    private double CR_MANAGEMENT_RATE; //管理费
    private double CR_HOSTING_RATE ; //托管费
    private double CR_PERFORMANCE_PAY_RATE ; //业绩报酬
    private int product_is_crawler ; //是否为爬取 1 是 0 不是

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getCR_SUBSCRIPTION_RATE() {
        return CR_SUBSCRIPTION_RATE;
    }

    public void setCR_SUBSCRIPTION_RATE(double CR_SUBSCRIPTION_RATE) {
        this.CR_SUBSCRIPTION_RATE = CR_SUBSCRIPTION_RATE;
    }

    public double getCR_REDEMPTION_RATE() {
        return CR_REDEMPTION_RATE;
    }

    public void setCR_REDEMPTION_RATE(double CR_REDEMPTION_RATE) {
        this.CR_REDEMPTION_RATE = CR_REDEMPTION_RATE;
    }

    public double getCR_MANAGEMENT_RATE() {
        return CR_MANAGEMENT_RATE;
    }

    public void setCR_MANAGEMENT_RATE(double CR_MANAGEMENT_RATE) {
        this.CR_MANAGEMENT_RATE = CR_MANAGEMENT_RATE;
    }

    public double getCR_HOSTING_RATE() {
        return CR_HOSTING_RATE;
    }

    public void setCR_HOSTING_RATE(double CR_HOSTING_RATE) {
        this.CR_HOSTING_RATE = CR_HOSTING_RATE;
    }

    public double getCR_PERFORMANCE_PAY_RATE() {
        return CR_PERFORMANCE_PAY_RATE;
    }

    public void setCR_PERFORMANCE_PAY_RATE(double CR_PERFORMANCE_PAY_RATE) {
        this.CR_PERFORMANCE_PAY_RATE = CR_PERFORMANCE_PAY_RATE;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "CostRateVo{" +
                "product_id=" + product_id +
                ", CR_SUBSCRIPTION_RATE=" + CR_SUBSCRIPTION_RATE +
                ", CR_REDEMPTION_RATE=" + CR_REDEMPTION_RATE +
                ", CR_MANAGEMENT_RATE=" + CR_MANAGEMENT_RATE +
                ", CR_HOSTING_RATE=" + CR_HOSTING_RATE +
                ", CR_PERFORMANCE_PAY_RATE=" + CR_PERFORMANCE_PAY_RATE +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
