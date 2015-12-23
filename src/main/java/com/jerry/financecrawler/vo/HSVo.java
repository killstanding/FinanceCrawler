package com.jerry.financecrawler.vo;

/**
 * Created by Jerry on 15/12/21.
 * 沪深300
 */
public class HSVo {
    private int id;
    private String date;//日期
    private double kpj;//开盘价
    private double zgj;//最高价
    private double spj;//收盘价
    private double zdj;//最低价
    private double jyl;//交易量(股)
    private double jyje;//交易金额(元)
    private double zdf;//涨跌幅

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getKpj() {
        return kpj;
    }

    public void setKpj(double kpj) {
        this.kpj = kpj;
    }

    public double getZgj() {
        return zgj;
    }

    public void setZgj(double zgj) {
        this.zgj = zgj;
    }

    public double getSpj() {
        return spj;
    }

    public void setSpj(double spj) {
        this.spj = spj;
    }

    public double getZdj() {
        return zdj;
    }

    public void setZdj(double zdj) {
        this.zdj = zdj;
    }

    public double getJyl() {
        return jyl;
    }

    public void setJyl(double jyl) {
        this.jyl = jyl;
    }

    public double getJyje() {
        return jyje;
    }

    public void setJyje(double jyje) {
        this.jyje = jyje;
    }

    public double getZdf() {
        return zdf;
    }

    public void setZdf(double zdf) {
        this.zdf = zdf;
    }

    @Override
    public String toString() {
        return "HSVo{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", kpj=" + kpj +
                ", zgj=" + zgj +
                ", spj=" + spj +
                ", zdj=" + zdj +
                ", jyl=" + jyl +
                ", jyje=" + jyje +
                ", zdf=" + zdf +
                '}';
    }
}
 