package com.jerry.financecrawler.vo;

import java.util.List;

/**
 * Created by Jerry on 2015/9/18.
 */
public class EastFinanceTotalVo {
    private List<EastFinanceVo> Datas;

    private int PageIndex;

    private int TotalCount;

    private int ErrCode;

    private int PageSize;

    private int AllPages;

    public int getAllPages() {
        return AllPages;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public int getErrCode() {
        return ErrCode;
    }

    public int getPageSize() {
        return PageSize;
    }

    public List<EastFinanceVo> getDatas() {
        return Datas;
    }

    public void setDatas(List<EastFinanceVo> datas) {
        Datas = datas;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
    }

    public void setErrCode(int errCode) {
        ErrCode = errCode;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public void setAllPages(int allPages) {
        AllPages = allPages;
    }

    @Override
    public String toString() {
        return "EastFinanceTotalModel{" +
                "Datas=" + Datas +
                ", PageIndex=" + PageIndex +
                ", TotalCount=" + TotalCount +
                ", ErrCode=" + ErrCode +
                ", PageSize=" + PageSize +
                ", AllPages=" + AllPages +
                '}';
    }
}
