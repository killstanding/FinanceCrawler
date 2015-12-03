package com.jerry.financecrawler.vo;

/**
 *Sterling比率
 * Created by Jerry on 15/11/12.
 */
public class SterlingRatioVo {
    private int product_id;
    private double SR_NEARLY_A_YEAR;// '近一年'
    private double SR_NEARLY_TWO_YEARS;// '近两年'
    private double SR_NEARLY_THREE_YEARS;//'近三年'
    private double SR_NEARLY_FIVE_YEARS ;//'近5年'
    private double SR_SINCE_ITS_ESTABLISHMENT ;// '成立以来'
    private int product_is_crawler = 1;// '是否为爬取 1 是 0 不是'

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getSR_NEARLY_A_YEAR() {
        return SR_NEARLY_A_YEAR;
    }

    public void setSR_NEARLY_A_YEAR(double SR_NEARLY_A_YEAR) {
        this.SR_NEARLY_A_YEAR = SR_NEARLY_A_YEAR;
    }

    public double getSR_NEARLY_TWO_YEARS() {
        return SR_NEARLY_TWO_YEARS;
    }

    public void setSR_NEARLY_TWO_YEARS(double SR_NEARLY_TWO_YEARS) {
        this.SR_NEARLY_TWO_YEARS = SR_NEARLY_TWO_YEARS;
    }

    public double getSR_NEARLY_THREE_YEARS() {
        return SR_NEARLY_THREE_YEARS;
    }

    public void setSR_NEARLY_THREE_YEARS(double SR_NEARLY_THREE_YEARS) {
        this.SR_NEARLY_THREE_YEARS = SR_NEARLY_THREE_YEARS;
    }

    public double getSR_NEARLY_FIVE_YEARS() {
        return SR_NEARLY_FIVE_YEARS;
    }

    public void setSR_NEARLY_FIVE_YEARS(double SR_NEARLY_FIVE_YEARS) {
        this.SR_NEARLY_FIVE_YEARS = SR_NEARLY_FIVE_YEARS;
    }

    public double getSR_SINCE_ITS_ESTABLISHMENT() {
        return SR_SINCE_ITS_ESTABLISHMENT;
    }

    public void setSR_SINCE_ITS_ESTABLISHMENT(double SR_SINCE_ITS_ESTABLISHMENT) {
        this.SR_SINCE_ITS_ESTABLISHMENT = SR_SINCE_ITS_ESTABLISHMENT;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    @Override
    public String toString() {
        return "SharpRatioVo{" +
                "product_id=" + product_id +
                ", SR_NEARLY_A_YEAR=" + SR_NEARLY_A_YEAR +
                ", SR_NEARLY_TWO_YEARS=" + SR_NEARLY_TWO_YEARS +
                ", SR_NEARLY_THREE_YEARS=" + SR_NEARLY_THREE_YEARS +
                ", SR_NEARLY_FIVE_YEARS=" + SR_NEARLY_FIVE_YEARS +
                ", SR_SINCE_ITS_ESTABLISHMENT=" + SR_SINCE_ITS_ESTABLISHMENT +
                ", product_is_crawler=" + product_is_crawler +
                '}';
    }
}
