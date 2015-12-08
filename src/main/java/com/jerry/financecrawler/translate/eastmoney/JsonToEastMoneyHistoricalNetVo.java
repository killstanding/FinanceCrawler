package com.jerry.financecrawler.translate.eastmoney;

import com.jerry.financecrawler.commons.JsonParseUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2015/9/18.
 */
@Component
public class JsonToEastMoneyHistoricalNetVo {

    public HistoricalNetTotalVo parseToHistoricalNetData(String json, int product_id,String product_code) throws Exception{
        HistoricalNetTotalVo historicalNetTotalVo = new HistoricalNetTotalVo();
        JSONObject jsonObject = new JSONObject(json);
        //"PageSize":0,"PageIndex":3,"Pages":32,"ErrCode":0
        int pageIndex = jsonObject.getInt("PageIndex");
        int errCode = jsonObject.getInt("ErrCode");
        int pageSize = jsonObject.getInt("PageSize");
        int allPages = jsonObject.getInt("Pages");
        if(errCode == 0){
            historicalNetTotalVo.setPageIndex(pageIndex);
            historicalNetTotalVo.setPageSize(pageSize);
            historicalNetTotalVo.setAllPages(allPages);
            historicalNetTotalVo.setErrCode(errCode);
            JSONArray datasArr = jsonObject.getJSONArray("Datas");
            List<HistoricalNetVo> datas = new ArrayList<HistoricalNetVo>();
            for(int i=0;i<datasArr.length();i++){

                JSONObject dataJson=datasArr.getJSONObject(i);
                //{"_id":"10002570722015-10-23","FINCODE":"1000257072","PDATE":"2015-10-23","NAV":29.3394,"ACCNAV":29.3394,"NAVCHG":0.0,"NAVCHGRT":0.0,"TYPE":"","BONUS":""}
                String id = dataJson.getString("_id");
                String FINCODE = dataJson.getString("FINCODE");//编号
                String PDATE = dataJson.getString("PDATE");//净值日期
                Double NAV = JsonParseUtil.getDouble(dataJson , "NAV");//单位净值（元）
                Double ACCNAV = JsonParseUtil.getDouble(dataJson , "ACCNAV");//累计净值（元）
                Double NAVCHG = JsonParseUtil.getDouble(dataJson , "NAVCHG") * 100;
                Double NAVCHGRT = JsonParseUtil.getDouble(dataJson ,"NAVCHGRT") * 100;//涨跌幅
                String TYPE = StringUtil.filterAllSymbol(dataJson.getString("TYPE"));//
                //Double BONUS = JsonParseUtil.getDouble(dataJson , "BONUS") ;//

                HistoricalNetVo historicalNetVo  = new HistoricalNetVo();
                historicalNetVo.setProduct_id(product_id);
                historicalNetVo.setProduct_code(product_code);

                if(!StringUtil.isEmpty(PDATE))historicalNetVo.setNet_worth_date(PDATE);
                historicalNetVo.setUnit_net_worth(NAV);
                historicalNetVo.setAdd_net_worth(NAVCHGRT);
                historicalNetVo.setChg(NAVCHG);
                datas.add(historicalNetVo);
            }
            historicalNetTotalVo.setDatas(datas);
        }

        return historicalNetTotalVo;
    }
}
