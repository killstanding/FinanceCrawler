package com.jerry.financecrawler.vo;

import java.util.List;

/**
 * Created by Jerry on 2015/10/9.
 */
public class FundProductTotalVo {
    private List<FundProductVo> Datas;

    private int PageIndex;

    private int TotalCount;

    private int ErrCode;

    private int PageSize;

    private int AllPages;

    public List<FundProductVo> getDatas() {
        return Datas;
    }

    public void setDatas(List<FundProductVo> datas) {
        Datas = datas;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
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
        return "FundProductTotalVo{" +
                "Datas=" + Datas +
                ", PageIndex=" + PageIndex +
                ", TotalCount=" + TotalCount +
                ", ErrCode=" + ErrCode +
                ", PageSize=" + PageSize +
                ", AllPages=" + AllPages +
                '}';
    }
}
