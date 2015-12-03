package com.jerry.financecrawler.vo;

import java.util.List;

/**
 * Created by Jerry on 15/12/2.
 */
public class HistoricalNetTotalVo {
    private List<HistoricalNetVo> Datas;

    private int PageIndex;

    private int ErrCode;

    private int PageSize;

    private int AllPages;

    public List<HistoricalNetVo> getDatas() {
        return Datas;
    }

    public void setDatas(List<HistoricalNetVo> datas) {
        Datas = datas;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getErrCode() {
        return ErrCode;
    }

    public void setErrCode(int errCode) {
        ErrCode = errCode;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getAllPages() {
        return AllPages;
    }

    public void setAllPages(int allPages) {
        AllPages = allPages;
    }

    @Override
    public String toString() {
        return "HistoricalNetTotalVo{" +
                "Datas=" + Datas +
                ", PageIndex=" + PageIndex +
                ", ErrCode=" + ErrCode +
                ", PageSize=" + PageSize +
                ", AllPages=" + AllPages +
                '}';
    }
}
