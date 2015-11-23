package com.jerry.financecrawler.vo;

/**
 * 年化收益率
 * Created by Jerry on 15/11/12.
 */
public class AnnualizedReturnRateVo {
    private int product_id;
    private double RR_NEARLY_A_YEAR ; //近一年
    private double RR_NEARLY_TWO_YEARS ;//近两年
    private double RR_NEARLY_THREE_YEARS ;// 近三年
    private double RR_NEARLY_FIVE_YEARS; //近5年
    private double RR_SINCE_ITS_ESTABLISHMENT ;//成立以来
    private int product_is_crawler = 1; //是否为爬取 1 是 0 不是

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getRR_NEARLY_A_YEAR() {
        return RR_NEARLY_A_YEAR;
    }

    public void setRR_NEARLY_A_YEAR(double RR_NEARLY_A_YEAR) {
        this.RR_NEARLY_A_YEAR = RR_NEARLY_A_YEAR;
    }

    public double getRR_NEARLY_TWO_YEARS() {
        return RR_NEARLY_TWO_YEARS;
    }

    public void setRR_NEARLY_TWO_YEARS(double RR_NEARLY_TWO_YEARS) {
        this.RR_NEARLY_TWO_YEARS = RR_NEARLY_TWO_YEARS;
    }

    public double getRR_NEARLY_THREE_YEARS() {
        return RR_NEARLY_THREE_YEARS;
    }

    public void setRR_NEARLY_THREE_YEARS(double RR_NEARLY_THREE_YEARS) {
        this.RR_NEARLY_THREE_YEARS = RR_NEARLY_THREE_YEARS;
    }

    public double getRR_NEARLY_FIVE_YEARS() {
        return RR_NEARLY_FIVE_YEARS;
    }

    public void setRR_NEARLY_FIVE_YEARS(double RR_NEARLY_FIVE_YEARS) {
        this.RR_NEARLY_FIVE_YEARS = RR_NEARLY_FIVE_YEARS;
    }

    public double getRR_SINCE_ITS_ESTABLISHMENT() {
        return RR_SINCE_ITS_ESTABLISHMENT;
    }

    public void setRR_SINCE_ITS_ESTABLISHMENT(double RR_SINCE_ITS_ESTABLISHMENT) {
        this.RR_SINCE_ITS_ESTABLISHMENT = RR_SINCE_ITS_ESTABLISHMENT;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "AnnualizedReturnRateVo{" +
                "product_id=" + product_id +
                ", RR_NEARLY_A_YEAR=" + RR_NEARLY_A_YEAR +
                ", RR_NEARLY_TWO_YEARS=" + RR_NEARLY_TWO_YEARS +
                ", RR_NEARLY_THREE_YEARS=" + RR_NEARLY_THREE_YEARS +
                ", RR_NEARLY_FIVE_YEARS=" + RR_NEARLY_FIVE_YEARS +
                ", RR_SINCE_ITS_ESTABLISHMENT=" + RR_SINCE_ITS_ESTABLISHMENT +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
