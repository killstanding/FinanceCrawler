package com.jerry.financecrawler.vo;

/**
 * Created by Jerry on 2015/10/9.
 * 基金产品
 */
public class FundProductVo {
    private int id;
    private String fincode; //基金编号
    private String product_name;  //产品名称
    private String product_shortname;//产品简称
    private String product_code;//产品代码
    private String isactice;//产品状态
    private String supplier_code;//基金发行人
    private String product_nature; //基金性质
    private String product_bank;  //托管行
    private String product_COOPERATIVE_SECURITIES_INSTITUTION;   //合作证券机构
    private String product_COOPERATIVE_FUTURES_AGENCY; //合作期货机构
    private String product_ESTABLISHMENT_DATE; //   date 成立日期
    private int product_DURATION_YEAR;    //存续期间(年)
    private int product_DURATION_EXISTENCE_YEAR;  //存续期限(年)
    private String product_TERMINATION_CONTION;  //终止条件
    private String product_TYPE;   //基金类型
    private String product_INVESTMENT_TYPE;   //投资类型
    private String product_INVESTMENT_TYPE_DETAIL;   //投资类型细分
    private String product_info;    // 产品信息
    private String product_INVESTMENT_TARGETS;   //投资标的
    private String product_INVESTMENT_RATIO;    //投资比例
    private double product_EXPECTED_RETURN;  //预期收益
    private double product_HEDGE_RATIO;    //对冲比例
    private int product_INVESTMENT_THRESHOLD;    //投资门槛（万）
    private int product_ADDITIONAL_AMOUNT;   //追加金额（万）
    private String product_OPEN_PERIOD;    //开放期
    private String product_OPEN_FREQUENCY;   //开放频度
    private int product_CLOSURE_PERIOD;    //封闭期(天)（转换下）
    private double product_EARLY_WARNING_LINE;    //预警线
    private double product_STOP_LINE;    //止损线
    private String product_CLASSIFICATON;    //是否分级 0 否 1 是
    private String product_GRADING_SCALE;    //分级比例
    private String product_OTHERS; //其他说明
    private double product_price;   //产品价格
    private String createdate;    //datetime
    private String productcategory_code;  //产品分类代码
    private String product_image_url;    //图片url
    private int product_is_crawler = 1; //是否为爬取 1 是 0 不是
    private IncomeVo incomeVo;

    public String getFincode() {
        return fincode;
    }

    public void setFincode(String fincode) {
        this.fincode = fincode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_shortname() {
        return product_shortname;
    }

    public void setProduct_shortname(String product_shortname) {
        this.product_shortname = product_shortname;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getIsactice() {
        return isactice;
    }

    public void setIsactice(String isactice) {
        this.isactice = isactice;
    }

    public String getSupplier_code() {
        return supplier_code;
    }

    public void setSupplier_code(String supplier_code) {
        this.supplier_code = supplier_code;
    }

    public String getProduct_nature() {
        return product_nature;
    }

    public void setProduct_nature(String product_nature) {
        this.product_nature = product_nature;
    }

    public String getProduct_bank() {
        return product_bank;
    }

    public void setProduct_bank(String product_bank) {
        this.product_bank = product_bank;
    }

    public String getProduct_COOPERATIVE_SECURITIES_INSTITUTION() {
        return product_COOPERATIVE_SECURITIES_INSTITUTION;
    }

    public void setProduct_COOPERATIVE_SECURITIES_INSTITUTION(String product_COOPERATIVE_SECURITIES_INSTITUTION) {
        this.product_COOPERATIVE_SECURITIES_INSTITUTION = product_COOPERATIVE_SECURITIES_INSTITUTION;
    }

    public String getProduct_COOPERATIVE_FUTURES_AGENCY() {
        return product_COOPERATIVE_FUTURES_AGENCY;
    }

    public void setProduct_COOPERATIVE_FUTURES_AGENCY(String product_COOPERATIVE_FUTURES_AGENCY) {
        this.product_COOPERATIVE_FUTURES_AGENCY = product_COOPERATIVE_FUTURES_AGENCY;
    }

    public String getProduct_ESTABLISHMENT_DATE() {
        return product_ESTABLISHMENT_DATE;
    }

    public void setProduct_ESTABLISHMENT_DATE(String product_ESTABLISHMENT_DATE) {
        this.product_ESTABLISHMENT_DATE = product_ESTABLISHMENT_DATE;
    }

    public int getProduct_DURATION_YEAR() {
        return product_DURATION_YEAR;
    }

    public void setProduct_DURATION_YEAR(int product_DURATION_YEAR) {
        this.product_DURATION_YEAR = product_DURATION_YEAR;
    }

    public int getProduct_DURATION_EXISTENCE_YEAR() {
        return product_DURATION_EXISTENCE_YEAR;
    }

    public void setProduct_DURATION_EXISTENCE_YEAR(int product_DURATION_EXISTENCE_YEAR) {
        this.product_DURATION_EXISTENCE_YEAR = product_DURATION_EXISTENCE_YEAR;
    }

    public String getProduct_TERMINATION_CONTION() {
        return product_TERMINATION_CONTION;
    }

    public void setProduct_TERMINATION_CONTION(String product_TERMINATION_CONTION) {
        this.product_TERMINATION_CONTION = product_TERMINATION_CONTION;
    }

    public String getProduct_TYPE() {
        return product_TYPE;
    }

    public void setProduct_TYPE(String product_TYPE) {
        this.product_TYPE = product_TYPE;
    }

    public String getProduct_INVESTMENT_TYPE() {
        return product_INVESTMENT_TYPE;
    }

    public void setProduct_INVESTMENT_TYPE(String product_INVESTMENT_TYPE) {
        this.product_INVESTMENT_TYPE = product_INVESTMENT_TYPE;
    }

    public String getProduct_INVESTMENT_TYPE_DETAIL() {
        return product_INVESTMENT_TYPE_DETAIL;
    }

    public void setProduct_INVESTMENT_TYPE_DETAIL(String product_INVESTMENT_TYPE_DETAIL) {
        this.product_INVESTMENT_TYPE_DETAIL = product_INVESTMENT_TYPE_DETAIL;
    }

    public String getProduct_info() {
        return product_info;
    }

    public void setProduct_info(String product_info) {
        this.product_info = product_info;
    }

    public String getProduct_INVESTMENT_TARGETS() {
        return product_INVESTMENT_TARGETS;
    }

    public void setProduct_INVESTMENT_TARGETS(String product_INVESTMENT_TARGETS) {
        this.product_INVESTMENT_TARGETS = product_INVESTMENT_TARGETS;
    }

    public String getProduct_INVESTMENT_RATIO() {
        return product_INVESTMENT_RATIO;
    }

    public void setProduct_INVESTMENT_RATIO(String product_INVESTMENT_RATIO) {
        this.product_INVESTMENT_RATIO = product_INVESTMENT_RATIO;
    }

    public double getProduct_EXPECTED_RETURN() {
        return product_EXPECTED_RETURN;
    }

    public void setProduct_EXPECTED_RETURN(double product_EXPECTED_RETURN) {
        this.product_EXPECTED_RETURN = product_EXPECTED_RETURN;
    }

    public double getProduct_HEDGE_RATIO() {
        return product_HEDGE_RATIO;
    }

    public void setProduct_HEDGE_RATIO(double product_HEDGE_RATIO) {
        this.product_HEDGE_RATIO = product_HEDGE_RATIO;
    }

    public int getProduct_INVESTMENT_THRESHOLD() {
        return product_INVESTMENT_THRESHOLD;
    }

    public void setProduct_INVESTMENT_THRESHOLD(int product_INVESTMENT_THRESHOLD) {
        this.product_INVESTMENT_THRESHOLD = product_INVESTMENT_THRESHOLD;
    }

    public int getProduct_ADDITIONAL_AMOUNT() {
        return product_ADDITIONAL_AMOUNT;
    }

    public void setProduct_ADDITIONAL_AMOUNT(int product_ADDITIONAL_AMOUNT) {
        this.product_ADDITIONAL_AMOUNT = product_ADDITIONAL_AMOUNT;
    }

    public String getProduct_OPEN_PERIOD() {
        return product_OPEN_PERIOD;
    }

    public void setProduct_OPEN_PERIOD(String product_OPEN_PERIOD) {
        this.product_OPEN_PERIOD = product_OPEN_PERIOD;
    }

    public String getProduct_OPEN_FREQUENCY() {
        return product_OPEN_FREQUENCY;
    }

    public void setProduct_OPEN_FREQUENCY(String product_OPEN_FREQUENCY) {
        this.product_OPEN_FREQUENCY = product_OPEN_FREQUENCY;
    }

    public int getProduct_CLOSURE_PERIOD() {
        return product_CLOSURE_PERIOD;
    }

    public void setProduct_CLOSURE_PERIOD(int product_CLOSURE_PERIOD) {
        this.product_CLOSURE_PERIOD = product_CLOSURE_PERIOD;
    }

    public double getProduct_EARLY_WARNING_LINE() {
        return product_EARLY_WARNING_LINE;
    }

    public void setProduct_EARLY_WARNING_LINE(double product_EARLY_WARNING_LINE) {
        this.product_EARLY_WARNING_LINE = product_EARLY_WARNING_LINE;
    }

    public double getProduct_STOP_LINE() {
        return product_STOP_LINE;
    }

    public void setProduct_STOP_LINE(double product_STOP_LINE) {
        this.product_STOP_LINE = product_STOP_LINE;
    }

    public String getProduct_CLASSIFICATON() {
        return product_CLASSIFICATON;
    }

    public void setProduct_CLASSIFICATON(String product_CLASSIFICATON) {
        this.product_CLASSIFICATON = product_CLASSIFICATON;
    }

    public String getProduct_GRADING_SCALE() {
        return product_GRADING_SCALE;
    }

    public void setProduct_GRADING_SCALE(String product_GRADING_SCALE) {
        this.product_GRADING_SCALE = product_GRADING_SCALE;
    }

    public String getProduct_OTHERS() {
        return product_OTHERS;
    }

    public void setProduct_OTHERS(String product_OTHERS) {
        this.product_OTHERS = product_OTHERS;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getProductcategory_code() {
        return productcategory_code;
    }

    public void setProductcategory_code(String productcategory_code) {
        this.productcategory_code = productcategory_code;
    }

    public String getProduct_image_url() {
        return product_image_url;
    }

    public void setProduct_image_url(String product_image_url) {
        this.product_image_url = product_image_url;
    }

    public int getProduct_is_crawler() {
        return product_is_crawler;
    }

    public void setProduct_is_crawler(int product_is_crawler) {
        this.product_is_crawler = product_is_crawler;
    }

    public IncomeVo getIncomeVo() {
        return incomeVo;
    }

    public void setIncomeVo(IncomeVo incomeVo) {
        this.incomeVo = incomeVo;
    }

    @Override
    public String toString() {
        return "FundProductVo{" +
                "id=" + id +
                ", fincode='" + fincode + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_shortname='" + product_shortname + '\'' +
                ", product_code='" + product_code + '\'' +
                ", isactice='" + isactice + '\'' +
                ", supplier_code='" + supplier_code + '\'' +
                ", product_nature='" + product_nature + '\'' +
                ", product_bank='" + product_bank + '\'' +
                ", product_COOPERATIVE_SECURITIES_INSTITUTION='" + product_COOPERATIVE_SECURITIES_INSTITUTION + '\'' +
                ", product_COOPERATIVE_FUTURES_AGENCY='" + product_COOPERATIVE_FUTURES_AGENCY + '\'' +
                ", product_ESTABLISHMENT_DATE='" + product_ESTABLISHMENT_DATE + '\'' +
                ", product_DURATION_YEAR=" + product_DURATION_YEAR +
                ", product_DURATION_EXISTENCE_YEAR=" + product_DURATION_EXISTENCE_YEAR +
                ", product_TERMINATION_CONTION='" + product_TERMINATION_CONTION + '\'' +
                ", product_TYPE='" + product_TYPE + '\'' +
                ", product_INVESTMENT_TYPE='" + product_INVESTMENT_TYPE + '\'' +
                ", product_INVESTMENT_TYPE_DETAIL='" + product_INVESTMENT_TYPE_DETAIL + '\'' +
                ", product_info='" + product_info + '\'' +
                ", product_INVESTMENT_TARGETS='" + product_INVESTMENT_TARGETS + '\'' +
                ", product_INVESTMENT_RATIO='" + product_INVESTMENT_RATIO + '\'' +
                ", product_EXPECTED_RETURN=" + product_EXPECTED_RETURN +
                ", product_HEDGE_RATIO=" + product_HEDGE_RATIO +
                ", product_INVESTMENT_THRESHOLD=" + product_INVESTMENT_THRESHOLD +
                ", product_ADDITIONAL_AMOUNT=" + product_ADDITIONAL_AMOUNT +
                ", product_OPEN_PERIOD='" + product_OPEN_PERIOD + '\'' +
                ", product_OPEN_FREQUENCY='" + product_OPEN_FREQUENCY + '\'' +
                ", product_CLOSURE_PERIOD=" + product_CLOSURE_PERIOD +
                ", product_EARLY_WARNING_LINE=" + product_EARLY_WARNING_LINE +
                ", product_STOP_LINE=" + product_STOP_LINE +
                ", product_CLASSIFICATON='" + product_CLASSIFICATON + '\'' +
                ", product_GRADING_SCALE='" + product_GRADING_SCALE + '\'' +
                ", product_OTHERS='" + product_OTHERS + '\'' +
                ", product_price=" + product_price +
                ", createdate='" + createdate + '\'' +
                ", productcategory_code='" + productcategory_code + '\'' +
                ", product_image_url='" + product_image_url + '\'' +
                ", product_is_crawler=" + product_is_crawler +
                ", incomeVo=" + incomeVo +
                '}';
    }
}
