package com.jerry.financecrawler.vo;

/**
 * Created by Jerry on 2015/10/9.
 * 收益率
 */
public class IncomeVo {
    private int product_id;
    private String I_UPDATE_DATE;// date 更新时间
    private double I_LATEST_NET_WORTH; // 最新净值
    private double I_SINCE_THIS_YEAR; // 今年以来
    private double I_NEARLY_A_MONTH; // 近一月
    private double I_NEARLY_THREE_MONTHS; // 近三月
    private double I_NEARLY_HALF_A_YEAR; //近半年
    private double I_NEARLY_A_YEAR; // 近一年
    private double I_NEARLY_TWO_YEARS; //近两年
    private double I_NEARLY_THREE_YEARS; //近三年
    private double I_NEARLY_FIVE_YEARS; //近5年
    private double I_SINCE_ITS_ESTABLISHMENT; //成立以来
    private int product_is_crawler = 1; //是否为爬取 1 是 0 不是

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getI_UPDATE_DATE() {
        return I_UPDATE_DATE;
    }

    public void setI_UPDATE_DATE(String i_UPDATE_DATE) {
        I_UPDATE_DATE = i_UPDATE_DATE;
    }

    public double getI_LATEST_NET_WORTH() {
        return I_LATEST_NET_WORTH;
    }

    public void setI_LATEST_NET_WORTH(double i_LATEST_NET_WORTH) {
        I_LATEST_NET_WORTH = i_LATEST_NET_WORTH;
    }

    public double getI_SINCE_THIS_YEAR() {
        return I_SINCE_THIS_YEAR;
    }

    public void setI_SINCE_THIS_YEAR(double i_SINCE_THIS_YEAR) {
        I_SINCE_THIS_YEAR = i_SINCE_THIS_YEAR;
    }

    public double getI_NEARLY_A_MONTH() {
        return I_NEARLY_A_MONTH;
    }

    public void setI_NEARLY_A_MONTH(double i_NEARLY_A_MONTH) {
        I_NEARLY_A_MONTH = i_NEARLY_A_MONTH;
    }

    public double getI_NEARLY_THREE_MONTHS() {
        return I_NEARLY_THREE_MONTHS;
    }

    public void setI_NEARLY_THREE_MONTHS(double i_NEARLY_THREE_MONTHS) {
        I_NEARLY_THREE_MONTHS = i_NEARLY_THREE_MONTHS;
    }

    public double getI_NEARLY_HALF_A_YEAR() {
        return I_NEARLY_HALF_A_YEAR;
    }

    public void setI_NEARLY_HALF_A_YEAR(double i_NEARLY_HALF_A_YEAR) {
        I_NEARLY_HALF_A_YEAR = i_NEARLY_HALF_A_YEAR;
    }

    public double getI_NEARLY_A_YEAR() {
        return I_NEARLY_A_YEAR;
    }

    public void setI_NEARLY_A_YEAR(double i_NEARLY_A_YEAR) {
        I_NEARLY_A_YEAR = i_NEARLY_A_YEAR;
    }

    public double getI_NEARLY_TWO_YEARS() {
        return I_NEARLY_TWO_YEARS;
    }

    public void setI_NEARLY_TWO_YEARS(double i_NEARLY_TWO_YEARS) {
        I_NEARLY_TWO_YEARS = i_NEARLY_TWO_YEARS;
    }

    public double getI_NEARLY_THREE_YEARS() {
        return I_NEARLY_THREE_YEARS;
    }

    public void setI_NEARLY_THREE_YEARS(double i_NEARLY_THREE_YEARS) {
        I_NEARLY_THREE_YEARS = i_NEARLY_THREE_YEARS;
    }

    public double getI_NEARLY_FIVE_YEARS() {
        return I_NEARLY_FIVE_YEARS;
    }

    public void setI_NEARLY_FIVE_YEARS(double i_NEARLY_FIVE_YEARS) {
        I_NEARLY_FIVE_YEARS = i_NEARLY_FIVE_YEARS;
    }

    public double getI_SINCE_ITS_ESTABLISHMENT() {
        return I_SINCE_ITS_ESTABLISHMENT;
    }

    public void setI_SINCE_ITS_ESTABLISHMENT(double i_SINCE_ITS_ESTABLISHMENT) {
        I_SINCE_ITS_ESTABLISHMENT = i_SINCE_ITS_ESTABLISHMENT;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "IncomeVo{" +
                "product_id=" + product_id +
                ", I_UPDATE_DATE='" + I_UPDATE_DATE + '\'' +
                ", I_LATEST_NET_WORTH=" + I_LATEST_NET_WORTH +
                ", I_SINCE_THIS_YEAR=" + I_SINCE_THIS_YEAR +
                ", I_NEARLY_A_MONTH=" + I_NEARLY_A_MONTH +
                ", I_NEARLY_THREE_MONTHS=" + I_NEARLY_THREE_MONTHS +
                ", I_NEARLY_HALF_A_YEAR=" + I_NEARLY_HALF_A_YEAR +
                ", I_NEARLY_A_YEAR=" + I_NEARLY_A_YEAR +
                ", I_NEARLY_TWO_YEARS=" + I_NEARLY_TWO_YEARS +
                ", I_NEARLY_THREE_YEARS=" + I_NEARLY_THREE_YEARS +
                ", I_NEARLY_FIVE_YEARS=" + I_NEARLY_FIVE_YEARS +
                ", I_SINCE_ITS_ESTABLISHMENT=" + I_SINCE_ITS_ESTABLISHMENT +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
