package com.jerry.financecrawler.commons;

/**
 * Created by Jerry on 2015/9/18.
 */
public class CommonsUrl {

    public static final String EAST_FINANCE_URL = "http://simu.eastmoney.com/Handler/SimuJJDataAPI.ashx?callback=fundData&sf=PDATE&st=desc&ft=&pi=%s&pn=%s&m=1";


    public static String getUrl(String baseUrl,int index, int pageNum, int totalPage) {
        String url = "";
        if (pageNum <= totalPage || totalPage == 0) {
             url = String.format(baseUrl, index, pageNum);
        }else{
            url = String.format(baseUrl,index,totalPage);
        }
        return url;
    }
}
