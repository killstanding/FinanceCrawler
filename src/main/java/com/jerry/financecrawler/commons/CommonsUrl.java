package com.jerry.financecrawler.commons;

/**
 * Created by Jerry on 2015/9/18.
 */
public class CommonsUrl {

    //how buy
    public static final String HOW_BUY_FINANCE_URL = "http://simu.howbuy.com/mlboard.htm?page=%s&perPage=%s";
    public static final String HOW_BUY_FINANCE_HISTORICAL_NET_URL = "http://simu.howbuy.com/touzi/%s/lsjz";
    public static final String HOW_BUY_FINANCE_PRODUCT_DETAIL_URL = "http://simu.howbuy.com/touzi/%s";
    //east money
    public static final String EAST_MONEY_URL = "http://simu.eastmoney.com/Handler/SimuJJDataAPI.ashx?callback=fundData&sf=HY&st=desc&ft=&pi=%s&pn=%s&m=0&yxzt=1&clsc=-1&glgm=-1&glgs=&v=0.1882981201633811";
    public static final String EAST_MONEY_HISTORICAL_NET_URL = "http://simu.eastmoney.com/PinzhongF10DataApi.aspx?type=lsjz&fc=%s&pageindex=%s&pagesize=%s";
    public static final String EAST_MONEY_DETAIL_URL = "http://simu.eastmoney.com/pro%s.html";
    //licai
    public static final String LI_CAI_URL = "http://www.licai.com/simu/phtype4.html";

    public static final String LI_CAI_BASE_URL = "http://www.licai.com/";

    public static String getUrl(String baseUrl, int index, int pageNum, int totalPage) {
        String url = "";
        if (pageNum <= totalPage || totalPage == 0) {
            url = String.format(baseUrl, index, pageNum);
        } else {
            url = String.format(baseUrl, index, totalPage);
        }
        return url;
    }

    public static String getUrlByCode(String baseUrl, String code) {
        return String.format(baseUrl, code);
    }

    public static String getEastMoneyFinanceHistoricalNetUrlByCode(String baseUrl,String fincode, int index, int pageNum, int totalPage){
        String url = "";
        if (pageNum <= totalPage || totalPage == 0) {
            url = String.format(baseUrl, fincode, index, pageNum);
        } else {
            url = String.format(baseUrl,fincode, index, totalPage);
        }
        return url;
    }
}
