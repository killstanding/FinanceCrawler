package com.jerry.financecrawler.vo;

/**
 * 收益排名
 * Created by Jerry on 15/11/12.
 */
public class IncomeRankingVo {
    private int product_id ;
    private String IR_SINCE_THIS_YEAR;// 今年以来
    private String IR_NEARLY_A_MONTH;//近一月
    private String IR_NEARLY_THREE_MONTHS;//近三月
    private String IR_NEARLY_HALF_A_YEAR ;//近半年
    private String IR_NEARLY_A_YEAR;//近一年
    private String IR_NEARLY_TWO_YEARS;//近两年
    private String IR_NEARLY_THREE_YEARS;//近三年
    private String IR_NEARLY_FIVE_YEARS;//近5年
    private int product_is_crawler = 1;// 是否为爬取 1 是 0 不是

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getIR_SINCE_THIS_YEAR() {
        return IR_SINCE_THIS_YEAR;
    }

    public void setIR_SINCE_THIS_YEAR(String IR_SINCE_THIS_YEAR) {
        this.IR_SINCE_THIS_YEAR = IR_SINCE_THIS_YEAR;
    }

    public String getIR_NEARLY_A_MONTH() {
        return IR_NEARLY_A_MONTH;
    }

    public void setIR_NEARLY_A_MONTH(String IR_NEARLY_A_MONTH) {
        this.IR_NEARLY_A_MONTH = IR_NEARLY_A_MONTH;
    }

    public String getIR_NEARLY_THREE_MONTHS() {
        return IR_NEARLY_THREE_MONTHS;
    }

    public void setIR_NEARLY_THREE_MONTHS(String IR_NEARLY_THREE_MONTHS) {
        this.IR_NEARLY_THREE_MONTHS = IR_NEARLY_THREE_MONTHS;
    }

    public String getIR_NEARLY_HALF_A_YEAR() {
        return IR_NEARLY_HALF_A_YEAR;
    }

    public void setIR_NEARLY_HALF_A_YEAR(String IR_NEARLY_HALF_A_YEAR) {
        this.IR_NEARLY_HALF_A_YEAR = IR_NEARLY_HALF_A_YEAR;
    }

    public String getIR_NEARLY_A_YEAR() {
        return IR_NEARLY_A_YEAR;
    }

    public void setIR_NEARLY_A_YEAR(String IR_NEARLY_A_YEAR) {
        this.IR_NEARLY_A_YEAR = IR_NEARLY_A_YEAR;
    }

    public String getIR_NEARLY_TWO_YEARS() {
        return IR_NEARLY_TWO_YEARS;
    }

    public void setIR_NEARLY_TWO_YEARS(String IR_NEARLY_TWO_YEARS) {
        this.IR_NEARLY_TWO_YEARS = IR_NEARLY_TWO_YEARS;
    }

    public String getIR_NEARLY_THREE_YEARS() {
        return IR_NEARLY_THREE_YEARS;
    }

    public void setIR_NEARLY_THREE_YEARS(String IR_NEARLY_THREE_YEARS) {
        this.IR_NEARLY_THREE_YEARS = IR_NEARLY_THREE_YEARS;
    }

    public String getIR_NEARLY_FIVE_YEARS() {
        return IR_NEARLY_FIVE_YEARS;
    }

    public void setIR_NEARLY_FIVE_YEARS(String IR_NEARLY_FIVE_YEARS) {
        this.IR_NEARLY_FIVE_YEARS = IR_NEARLY_FIVE_YEARS;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "IncomeRankingVo{" +
                "product_id=" + product_id +
                ", IR_SINCE_THIS_YEAR='" + IR_SINCE_THIS_YEAR + '\'' +
                ", IR_NEARLY_A_MONTH='" + IR_NEARLY_A_MONTH + '\'' +
                ", IR_NEARLY_THREE_MONTHS='" + IR_NEARLY_THREE_MONTHS + '\'' +
                ", IR_NEARLY_HALF_A_YEAR='" + IR_NEARLY_HALF_A_YEAR + '\'' +
                ", IR_NEARLY_A_YEAR='" + IR_NEARLY_A_YEAR + '\'' +
                ", IR_NEARLY_TWO_YEARS='" + IR_NEARLY_TWO_YEARS + '\'' +
                ", IR_NEARLY_THREE_YEARS='" + IR_NEARLY_THREE_YEARS + '\'' +
                ", IR_NEARLY_FIVE_YEARS='" + IR_NEARLY_FIVE_YEARS + '\'' +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
