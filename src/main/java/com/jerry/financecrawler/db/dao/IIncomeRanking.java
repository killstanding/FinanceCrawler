package com.jerry.financecrawler.db.dao;

import com.jerry.financecrawler.db.po.AnnualFluctuationRatePo;
import com.jerry.financecrawler.db.po.IncomeRankingPo;
import com.jerry.financecrawler.vo.IncomeRankingVo;

/**
 * Created by Jerry on 15/11/17.
 */
public interface IIncomeRanking {

    void save(IncomeRankingPo po);

    void remove(int product_id);

    void modify(IncomeRankingPo po);

    IncomeRankingPo find(int product_id);
}
