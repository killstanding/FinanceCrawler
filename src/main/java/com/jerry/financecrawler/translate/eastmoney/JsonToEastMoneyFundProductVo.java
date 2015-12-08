package com.jerry.financecrawler.translate.eastmoney;

import com.jerry.financecrawler.commons.JsonParseUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.FundProductTotalVo;
import com.jerry.financecrawler.vo.FundProductVo;
import com.jerry.financecrawler.vo.IncomeVo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2015/9/18.
 */
@Component
public class JsonToEastMoneyFundProductVo {

    public FundProductTotalVo parseToEastMoneyData(String json) throws Exception{
        FundProductTotalVo fundProductTotalVo = new FundProductTotalVo();
        JSONObject jsonObject = new JSONObject(json);
        //"PageIndex":1,"TotalCount":14931,"ErrCode":0,"PageSize":20,"AllPages":747
        int pageIndex = jsonObject.getInt("PageIndex");
        int totalCount = jsonObject.getInt("TotalCount");
        int errCode = jsonObject.getInt("ErrCode");
        int pageSize = jsonObject.getInt("PageSize");
        int allPages = jsonObject.getInt("AllPages");
        if(errCode == 0){
            fundProductTotalVo.setPageIndex(pageIndex);
            fundProductTotalVo.setTotalCount(totalCount);
            fundProductTotalVo.setPageSize(pageSize);
            fundProductTotalVo.setAllPages(allPages);
            fundProductTotalVo.setErrCode(errCode);
            JSONArray datasArr = jsonObject.getJSONArray("Datas");
            List<FundProductVo> datas = new ArrayList<FundProductVo>();
            for(int i=0; i<datasArr.length(); i++){
                JSONObject dataJson=datasArr.getJSONObject(i);
                //{"_id":"1000393325","FINCODE":"1000393325","FULLNAME":"华银精选基金","SHORTNAME":"华银精选基金","ESTABDATE":"2014-11-18","DCCODE":"77013311","MGRNAME":"","PDATE":"2015-10-30","NAV":12.7192,"M":64.2204,"Q":48.0805,"HY":971.9933,"Y":"","TWY":"","TRY":"","FY":"","SY":1329.1237,"SE":1172.3017}
                String id = dataJson.getString("_id");
                String FINCODE = dataJson.getString("FINCODE");//编号
                String FULLNAME = dataJson.getString("FULLNAME");//产品全名
                String SHORTNAME = dataJson.getString("SHORTNAME");//产品短名
                String ESTABDATE = dataJson.getString("ESTABDATE");//成立日期
                String DCCODE = dataJson.getString("DCCODE");
                String MGRNAME = dataJson.getString("MGRNAME");//投资经理
                String PDATE = dataJson.getString("PDATE");//最新净值日期
                Double NAV = JsonParseUtil.getDouble(dataJson, "NAV");//最新净值

                Double M = JsonParseUtil.getDouble(dataJson , "M");//近1月
                Double Q = JsonParseUtil.getDouble(dataJson , "Q");//近3月
                Double HY = JsonParseUtil.getDouble(dataJson , "HY");//近6月
                Double Y = JsonParseUtil.getDouble(dataJson , "Y");//近1年
                Double TWY = JsonParseUtil.getDouble(dataJson , "TWY");//近2年
                Double TRY = JsonParseUtil.getDouble(dataJson , "TRY");//近3年
                Double FY = JsonParseUtil.getDouble(dataJson , "FY");//近5年
                Double SY = JsonParseUtil.getDouble(dataJson , "SY");//今年来
                Double SE = JsonParseUtil.getDouble(dataJson , "SE");//成立来

                FundProductVo fundProductVo = new FundProductVo();
                fundProductVo.setFincode(FINCODE);
                fundProductVo.setProduct_name(FULLNAME);
                fundProductVo.setProduct_shortname(SHORTNAME);
                if(!StringUtil.isEmpty(ESTABDATE))fundProductVo.setProduct_ESTABLISHMENT_DATE(ESTABDATE);
                IncomeVo incomeVo = new IncomeVo();
                incomeVo.setI_UPDATE_DATE(PDATE);
                incomeVo.setI_LATEST_NET_WORTH(NAV);
                incomeVo.setI_NEARLY_A_MONTH(M);
                incomeVo.setI_NEARLY_THREE_MONTHS(Q);
                incomeVo.setI_NEARLY_HALF_A_YEAR(HY);
                incomeVo.setI_NEARLY_A_YEAR(Y);
                incomeVo.setI_NEARLY_TWO_YEARS(TWY);
                incomeVo.setI_NEARLY_THREE_YEARS(TRY);
                incomeVo.setI_NEARLY_FIVE_YEARS(FY);
                incomeVo.setI_SINCE_THIS_YEAR(SY);
                incomeVo.setI_SINCE_ITS_ESTABLISHMENT(SE);

                fundProductVo.setIncomeVo(incomeVo);
                datas.add(fundProductVo);
            }
            fundProductTotalVo.setDatas(datas);
        }

        return fundProductTotalVo;
    }
}
