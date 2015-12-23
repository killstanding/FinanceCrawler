package com.jerry.financecrawler.vo;

/**
 * 基金经理
 * Created by Jerry on 15/11/12.
 */
public class FundManagerVo {
    private int fundmanager_id ;
    private int ID ;
    private String BS_NAME; //基金经理
    private String BS_FUND_MANAGEMENT_START_DATE; // 基金起始管理日期
    private String BS_FUND_MANAGEMENT_END_DATE ; //  基金结束管理日期
    private int BS_MANAGEMENT_FUND_NUM ; // 管理基金数
    private int BS_HISTORICAL_MANANGEMENT_FUND_NUM ; //  历史管理基金
    private String BS_UNIVERSITY ; //  毕业院校
    private String BS_EDUCATION ; //  学历
    private String BS_PROFESSIONAL; //  专业
    private int BS_WORKING_TIME; //  从业时间
    private String BS_WORKING_YEAR; // 从业年限
    private int product_is_crawler ; // 是否为爬取 1 是 0 不是
    private String detail_url; //地址

    public int getFundmanager_id() {
        return fundmanager_id;
    }

    public void setFundmanager_id(int fundmanager_id) {
        this.fundmanager_id = fundmanager_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBS_NAME() {
        return BS_NAME;
    }

    public void setBS_NAME(String BS_NAME) {
        this.BS_NAME = BS_NAME;
    }

    public String getBS_FUND_MANAGEMENT_START_DATE() {
        return BS_FUND_MANAGEMENT_START_DATE;
    }

    public void setBS_FUND_MANAGEMENT_START_DATE(String BS_FUND_MANAGEMENT_START_DATE) {
        this.BS_FUND_MANAGEMENT_START_DATE = BS_FUND_MANAGEMENT_START_DATE;
    }

    public String getBS_FUND_MANAGEMENT_END_DATE() {
        return BS_FUND_MANAGEMENT_END_DATE;
    }

    public void setBS_FUND_MANAGEMENT_END_DATE(String BS_FUND_MANAGEMENT_END_DATE) {
        this.BS_FUND_MANAGEMENT_END_DATE = BS_FUND_MANAGEMENT_END_DATE;
    }

    public int getBS_MANAGEMENT_FUND_NUM() {
        return BS_MANAGEMENT_FUND_NUM;
    }

    public void setBS_MANAGEMENT_FUND_NUM(int BS_MANAGEMENT_FUND_NUM) {
        this.BS_MANAGEMENT_FUND_NUM = BS_MANAGEMENT_FUND_NUM;
    }

    public int getBS_HISTORICAL_MANANGEMENT_FUND_NUM() {
        return BS_HISTORICAL_MANANGEMENT_FUND_NUM;
    }

    public void setBS_HISTORICAL_MANANGEMENT_FUND_NUM(int BS_HISTORICAL_MANANGEMENT_FUND_NUM) {
        this.BS_HISTORICAL_MANANGEMENT_FUND_NUM = BS_HISTORICAL_MANANGEMENT_FUND_NUM;
    }

    public String getBS_UNIVERSITY() {
        return BS_UNIVERSITY;
    }

    public void setBS_UNIVERSITY(String BS_UNIVERSITY) {
        this.BS_UNIVERSITY = BS_UNIVERSITY;
    }

    public String getBS_EDUCATION() {
        return BS_EDUCATION;
    }

    public void setBS_EDUCATION(String BS_EDUCATION) {
        this.BS_EDUCATION = BS_EDUCATION;
    }

    public String getBS_PROFESSIONAL() {
        return BS_PROFESSIONAL;
    }

    public void setBS_PROFESSIONAL(String BS_PROFESSIONAL) {
        this.BS_PROFESSIONAL = BS_PROFESSIONAL;
    }

    public int getBS_WORKING_TIME() {
        return BS_WORKING_TIME;
    }

    public void setBS_WORKING_TIME(int BS_WORKING_TIME) {
        this.BS_WORKING_TIME = BS_WORKING_TIME;
    }

    public String getBS_WORKING_YEAR() {
        return BS_WORKING_YEAR;
    }

    public void setBS_WORKING_YEAR(String BS_WORKING_YEAR) {
        this.BS_WORKING_YEAR = BS_WORKING_YEAR;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    public String getDetail_url() {
        return detail_url;
    }

    public void setDetail_url(String detail_url) {
        this.detail_url = detail_url;
    }

    @Override
    public String toString() {
        return "FundManagerVo{" +
                "fundmanager_id=" + fundmanager_id +
                ", ID=" + ID +
                ", BS_NAME='" + BS_NAME + '\'' +
                ", BS_FUND_MANAGEMENT_START_DATE='" + BS_FUND_MANAGEMENT_START_DATE + '\'' +
                ", BS_FUND_MANAGEMENT_END_DATE='" + BS_FUND_MANAGEMENT_END_DATE + '\'' +
                ", BS_MANAGEMENT_FUND_NUM=" + BS_MANAGEMENT_FUND_NUM +
                ", BS_HISTORICAL_MANANGEMENT_FUND_NUM=" + BS_HISTORICAL_MANANGEMENT_FUND_NUM +
                ", BS_UNIVERSITY='" + BS_UNIVERSITY + '\'' +
                ", BS_EDUCATION='" + BS_EDUCATION + '\'' +
                ", BS_PROFESSIONAL='" + BS_PROFESSIONAL + '\'' +
                ", BS_WORKING_TIME='" + BS_WORKING_TIME + '\'' +
                ", BS_WORKING_YEAR='" + BS_WORKING_YEAR + '\'' +
                ", product_is_crawler=" + product_is_crawler +
                ", detail_url='" + detail_url + '\'' +
                '}';
    }
}
