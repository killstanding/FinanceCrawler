package com.jerry.financecrawler.translate.hs;

import com.jerry.financecrawler.commons.CommonsCharset;
import com.jerry.financecrawler.commons.HtmlParserUtil;
import com.jerry.financecrawler.commons.StringUtil;
import com.jerry.financecrawler.vo.HSVo;
import org.htmlparser.Node;
import org.htmlparser.util.NodeList;
import org.springframework.stereotype.Component;


/**
 * Created by Jerry on 2015/9/18.
 */
@Component
public class HtmlToHSVo {
    public HSVo parseToHSData(String html) throws Exception {
        if (html == null || html.equals("")) return null;
        HSVo hsVo = new HSVo();
        //获取表格信息
        NodeList table = HtmlParserUtil.filterTargetNode(html, CommonsCharset.GB2312, "id", "FundHoldSharesTable");
            if (table != null && table.elementAt(0) != null && table.size() > 0) {
                NodeList trs = HtmlParserUtil.filterNode(table.elementAt(0), "tr");
                if (trs != null && trs.size() > 0) {
                    for (int i = 0; i < trs.size(); i++) {
                        if (i == 2) {//只是取最新的数据
                            NodeList tds = HtmlParserUtil.filterNode(trs.elementAt(i), "td");
                            if (tds != null && tds.size() > 0) {
                                for (int j = 0; j < tds.size(); j++) {
                                    Node td = tds.elementAt(j);
                                    String fVal = HtmlParserUtil.getPlainTextString(td);
                                    fVal = fVal.trim();
                                    //System.out.println("fVal = [" + fVal + "]" + ", j = [" + j + "]");
                                    //赋值
                                    switch (j) {
                                        case 0:
                                            if (!StringUtil.isEmpty(fVal)) hsVo.setDate(fVal);//日期
                                            break;
                                        case 1:
                                            if (!StringUtil.isEmpty(fVal)) hsVo.setKpj(StringUtil.StringToDouble(fVal)); //开盘价
                                                break;
                                        case 2:
                                            if (!StringUtil.isEmpty(fVal)) hsVo.setZgj(StringUtil.StringToDouble(fVal));//最高价
                                            break;
                                        case 3:
                                            if (!StringUtil.isEmpty(fVal)) hsVo.setSpj(StringUtil.StringToDouble(fVal));//收盘价
                                            break;
                                        case 4:
                                            if (!StringUtil.isEmpty(fVal))
                                                hsVo.setZdj(StringUtil.StringToDouble(fVal));
                                            break;//最低价
                                        case 5:
                                            if (!StringUtil.isEmpty(fVal))
                                                hsVo.setJyl(StringUtil.StringToDouble(fVal));
                                            break;//交易量(股)
                                        case 6:
                                            if (!StringUtil.isEmpty(fVal))
                                                hsVo.setJyje(StringUtil.StringToDouble(fVal));
                                            break;//交易金额(元)
                                    }
                                }//for tds
                            }//tds
                            break;
                        }//if  i
                    }//for trs

                }//if trs
            }//if table
        return hsVo;
    }
}
