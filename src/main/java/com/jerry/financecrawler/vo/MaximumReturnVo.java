package com.jerry.financecrawler.vo;

/**
 * Created by Jerry on 15/11/12.
 */
public class MaximumReturnVo {
    private int product_id;
    private double MR_NEARLY_A_YEAR;//近一年
    private double MR_NEARLY_TWO_YEARS ;//近两年
    private double MR_NEARLY_THREE_YEARS ;//近三年
    private double MR_NEARLY_FIVE_YEARS ;//近5年
    private double MR_SINCE_ITS_ESTABLISHMENT;//成立以来
    private int product_is_crawler = 1;//是否为爬取 1 是 0 不是

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getMR_NEARLY_A_YEAR() {
        return MR_NEARLY_A_YEAR;
    }

    public void setMR_NEARLY_A_YEAR(double MR_NEARLY_A_YEAR) {
        this.MR_NEARLY_A_YEAR = MR_NEARLY_A_YEAR;
    }

    public double getMR_NEARLY_TWO_YEARS() {
        return MR_NEARLY_TWO_YEARS;
    }

    public void setMR_NEARLY_TWO_YEARS(double MR_NEARLY_TWO_YEARS) {
        this.MR_NEARLY_TWO_YEARS = MR_NEARLY_TWO_YEARS;
    }

    public double getMR_NEARLY_THREE_YEARS() {
        return MR_NEARLY_THREE_YEARS;
    }

    public void setMR_NEARLY_THREE_YEARS(double MR_NEARLY_THREE_YEARS) {
        this.MR_NEARLY_THREE_YEARS = MR_NEARLY_THREE_YEARS;
    }

    public double getMR_NEARLY_FIVE_YEARS() {
        return MR_NEARLY_FIVE_YEARS;
    }

    public void setMR_NEARLY_FIVE_YEARS(double MR_NEARLY_FIVE_YEARS) {
        this.MR_NEARLY_FIVE_YEARS = MR_NEARLY_FIVE_YEARS;
    }

    public double getMR_SINCE_ITS_ESTABLISHMENT() {
        return MR_SINCE_ITS_ESTABLISHMENT;
    }

    public void setMR_SINCE_ITS_ESTABLISHMENT(double MR_SINCE_ITS_ESTABLISHMENT) {
        this.MR_SINCE_ITS_ESTABLISHMENT = MR_SINCE_ITS_ESTABLISHMENT;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "MaximumReturnVo{" +
                "product_id=" + product_id +
                ", MR_NEARLY_A_YEAR=" + MR_NEARLY_A_YEAR +
                ", MR_NEARLY_TWO_YEARS=" + MR_NEARLY_TWO_YEARS +
                ", MR_NEARLY_THREE_YEARS=" + MR_NEARLY_THREE_YEARS +
                ", MR_NEARLY_FIVE_YEARS=" + MR_NEARLY_FIVE_YEARS +
                ", MR_SINCE_ITS_ESTABLISHMENT=" + MR_SINCE_ITS_ESTABLISHMENT +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
