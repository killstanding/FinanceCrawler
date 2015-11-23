package com.jerry.financecrawler.vo;

/**
 * 年化波动率
 * Created by Jerry on 15/11/12.
 */
public class AnnualFluctuationRateVo {

    private int product_id ;
    private double FR_NEARLY_A_YEAR ;// 近一年
    private double FR_NEARLY_TWO_YEARS ;//近两年
    private double FR_NEARLY_THREE_YEARS ;// 近三年
    private double FR_NEARLY_FIVE_YEARS ;//近5年
    private double FR_SINCE_ITS_ESTABLISHMENT ;// 成立以来
    private int FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS ;//最多连续盈利天数
    private int FR_MAXIMUM_CONTINUOUS_LOSS_DAYS ;// 最多连续亏损天数
    private int product_is_crawler = 1; //是否为爬取 1 是 0 不是

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getFR_NEARLY_A_YEAR() {
        return FR_NEARLY_A_YEAR;
    }

    public void setFR_NEARLY_A_YEAR(double FR_NEARLY_A_YEAR) {
        this.FR_NEARLY_A_YEAR = FR_NEARLY_A_YEAR;
    }

    public double getFR_NEARLY_TWO_YEARS() {
        return FR_NEARLY_TWO_YEARS;
    }

    public void setFR_NEARLY_TWO_YEARS(double FR_NEARLY_TWO_YEARS) {
        this.FR_NEARLY_TWO_YEARS = FR_NEARLY_TWO_YEARS;
    }

    public double getFR_NEARLY_THREE_YEARS() {
        return FR_NEARLY_THREE_YEARS;
    }

    public void setFR_NEARLY_THREE_YEARS(double FR_NEARLY_THREE_YEARS) {
        this.FR_NEARLY_THREE_YEARS = FR_NEARLY_THREE_YEARS;
    }

    public double getFR_NEARLY_FIVE_YEARS() {
        return FR_NEARLY_FIVE_YEARS;
    }

    public void setFR_NEARLY_FIVE_YEARS(double FR_NEARLY_FIVE_YEARS) {
        this.FR_NEARLY_FIVE_YEARS = FR_NEARLY_FIVE_YEARS;
    }

    public double getFR_SINCE_ITS_ESTABLISHMENT() {
        return FR_SINCE_ITS_ESTABLISHMENT;
    }

    public void setFR_SINCE_ITS_ESTABLISHMENT(double FR_SINCE_ITS_ESTABLISHMENT) {
        this.FR_SINCE_ITS_ESTABLISHMENT = FR_SINCE_ITS_ESTABLISHMENT;
    }

    public int getFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS() {
        return FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS;
    }

    public void setFR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS(int FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS) {
        this.FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS = FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS;
    }

    public int getFR_MAXIMUM_CONTINUOUS_LOSS_DAYS() {
        return FR_MAXIMUM_CONTINUOUS_LOSS_DAYS;
    }

    public void setFR_MAXIMUM_CONTINUOUS_LOSS_DAYS(int FR_MAXIMUM_CONTINUOUS_LOSS_DAYS) {
        this.FR_MAXIMUM_CONTINUOUS_LOSS_DAYS = FR_MAXIMUM_CONTINUOUS_LOSS_DAYS;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "AnnualFluctuationRateVo{" +
                "product_id=" + product_id +
                ", FR_NEARLY_A_YEAR=" + FR_NEARLY_A_YEAR +
                ", FR_NEARLY_TWO_YEARS=" + FR_NEARLY_TWO_YEARS +
                ", FR_NEARLY_THREE_YEARS=" + FR_NEARLY_THREE_YEARS +
                ", FR_NEARLY_FIVE_YEARS=" + FR_NEARLY_FIVE_YEARS +
                ", FR_SINCE_ITS_ESTABLISHMENT=" + FR_SINCE_ITS_ESTABLISHMENT +
                ", FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS=" + FR_MAXIMUM_CONTINUOUS_EARNINGS_DAYS +
                ", FR_MAXIMUM_CONTINUOUS_LOSS_DAYS=" + FR_MAXIMUM_CONTINUOUS_LOSS_DAYS +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
