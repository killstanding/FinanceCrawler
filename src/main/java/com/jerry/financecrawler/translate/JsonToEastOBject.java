package com.jerry.financecrawler.translate;

import com.jerry.financecrawler.vo.EastFinanceTotalVo;
import com.jerry.financecrawler.vo.EastFinanceVo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2015/9/18.
 */
@Component
public class JsonToEastOBject {
    public EastFinanceTotalVo parseToEastFinanceData(String json) throws Exception{
        EastFinanceTotalVo eastFinanceTotalVo = new EastFinanceTotalVo();
        JSONObject jsonObject = new JSONObject(json);
        int pageIndex = jsonObject.getInt("PageIndex");
        int totalCount = jsonObject.getInt("TotalCount");
        int errCode = jsonObject.getInt("ErrCode");
        int pageSize = jsonObject.getInt("PageSize");
        int allPages = jsonObject.getInt("AllPages");
        if(errCode == 0){
            eastFinanceTotalVo.setPageIndex(pageIndex);
            eastFinanceTotalVo.setTotalCount(totalCount);
            eastFinanceTotalVo.setPageSize(pageSize);
            eastFinanceTotalVo.setAllPages(allPages);
            eastFinanceTotalVo.setErrCode(errCode);
            JSONArray datasArr = jsonObject.getJSONArray("Datas");
            List<EastFinanceVo> datas = new ArrayList<EastFinanceVo>();
            for(int i=0;i<datasArr.length();i++){
                EastFinanceVo eastFinanceVo = new EastFinanceVo();
                JSONObject eastFiananceJson=datasArr.getJSONObject(i);
                String id = eastFiananceJson.getString("_id");
                String FINCODE = eastFiananceJson.getString("FINCODE");
                String FULLNAME = eastFiananceJson.getString("FULLNAME");
                String SHORTNAME = eastFiananceJson.getString("SHORTNAME");
                String ESTABDATE = eastFiananceJson.getString("ESTABDATE");
                String MANAGERCODE = eastFiananceJson.getString("MANAGERCODE");
                String MANAGER = eastFiananceJson.getString("MANAGER");
                String SMANAGER = eastFiananceJson.getString("SMANAGER");
                String TRUSTEECODE = eastFiananceJson.getString("TRUSTEECODE");
                String TRUSTEE = eastFiananceJson.getString("TRUSTEE");
                String STRUSTEE = eastFiananceJson.getString("STRUSTEE");
                String SCUSTDN = eastFiananceJson.getString("SCUSTDN");
                String MGRNAME = eastFiananceJson.getString("MGRNAME");
                String PDATE = eastFiananceJson.getString("PDATE");
                String NAV = eastFiananceJson.get("NAV")+"";
                String ACCNAV = eastFiananceJson.get("ACCNAV")+"";
                String HY = eastFiananceJson.get("HY") + "";
                String Y = eastFiananceJson.get("Y")+"";
                String TWY = eastFiananceJson.get("TWY")+"";
                String SY = eastFiananceJson.get("SY") + "";

                eastFinanceVo.setId(id);
                eastFinanceVo.setFINCODE(FINCODE);
                eastFinanceVo.setFULLNAME(FULLNAME);
                eastFinanceVo.setSHORTNAME(SHORTNAME);
                eastFinanceVo.setESTABDATE(ESTABDATE);
                eastFinanceVo.setMANAGERCODE(MANAGERCODE);
                eastFinanceVo.setMANAGER(MANAGER);
                eastFinanceVo.setSMANAGER(SMANAGER);
                eastFinanceVo.setTRUSTEECODE(TRUSTEECODE);
                eastFinanceVo.setTRUSTEE(TRUSTEE);
                eastFinanceVo.setSTRUSTEE(STRUSTEE);
                eastFinanceVo.setSCUSTDN(SCUSTDN);
                eastFinanceVo.setMGRNAME(MGRNAME);
                eastFinanceVo.setPDATE(PDATE);
                eastFinanceVo.setNAV(NAV);
                eastFinanceVo.setACCNAV(ACCNAV);
                eastFinanceVo.setHY(HY);
                eastFinanceVo.setY(Y);
                eastFinanceVo.setTWY(TWY);
                eastFinanceVo.setSY(SY);
                datas.add(eastFinanceVo);
            }
            eastFinanceTotalVo.setDatas(datas);
        }

        return eastFinanceTotalVo;
    }
}
