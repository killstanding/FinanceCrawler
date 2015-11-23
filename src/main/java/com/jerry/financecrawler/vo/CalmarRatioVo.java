package com.jerry.financecrawler.vo;

/**
 * CALMAR比率
 * Created by Jerry on 15/11/12.
 */
public class CalmarRatioVo {
    private int product_id;
    private double CR_NEARLY_A_YEAR;// 近一年
    private double CR_NEARLY_TWO_YEARS;// 近两年
    private double CR_NEARLY_THREE_YEARS ;// 近三年
    private double CR_NEARLY_FIVE_YEARS ;// 近5年
    private double CR_SINCE_ITS_ESTABLISHMENT;// 成立以来
    private int product_is_crawler;// 是否为爬取 1 是 0 不是

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getCR_NEARLY_A_YEAR() {
        return CR_NEARLY_A_YEAR;
    }

    public void setCR_NEARLY_A_YEAR(double CR_NEARLY_A_YEAR) {
        this.CR_NEARLY_A_YEAR = CR_NEARLY_A_YEAR;
    }

    public double getCR_NEARLY_TWO_YEARS() {
        return CR_NEARLY_TWO_YEARS;
    }

    public void setCR_NEARLY_TWO_YEARS(double CR_NEARLY_TWO_YEARS) {
        this.CR_NEARLY_TWO_YEARS = CR_NEARLY_TWO_YEARS;
    }

    public double getCR_NEARLY_THREE_YEARS() {
        return CR_NEARLY_THREE_YEARS;
    }

    public void setCR_NEARLY_THREE_YEARS(double CR_NEARLY_THREE_YEARS) {
        this.CR_NEARLY_THREE_YEARS = CR_NEARLY_THREE_YEARS;
    }

    public double getCR_NEARLY_FIVE_YEARS() {
        return CR_NEARLY_FIVE_YEARS;
    }

    public void setCR_NEARLY_FIVE_YEARS(double CR_NEARLY_FIVE_YEARS) {
        this.CR_NEARLY_FIVE_YEARS = CR_NEARLY_FIVE_YEARS;
    }

    public double getCR_SINCE_ITS_ESTABLISHMENT() {
        return CR_SINCE_ITS_ESTABLISHMENT;
    }

    public void setCR_SINCE_ITS_ESTABLISHMENT(double CR_SINCE_ITS_ESTABLISHMENT) {
        this.CR_SINCE_ITS_ESTABLISHMENT = CR_SINCE_ITS_ESTABLISHMENT;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "CalmarRatioVo{" +
                "product_id=" + product_id +
                ", CR_NEARLY_A_YEAR=" + CR_NEARLY_A_YEAR +
                ", CR_NEARLY_TWO_YEARS=" + CR_NEARLY_TWO_YEARS +
                ", CR_NEARLY_THREE_YEARS=" + CR_NEARLY_THREE_YEARS +
                ", CR_NEARLY_FIVE_YEARS=" + CR_NEARLY_FIVE_YEARS +
                ", CR_SINCE_ITS_ESTABLISHMENT=" + CR_SINCE_ITS_ESTABLISHMENT +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
