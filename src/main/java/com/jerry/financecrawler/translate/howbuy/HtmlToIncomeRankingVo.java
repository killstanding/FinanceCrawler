package com.jerry.financecrawler.translate.howbuy;

import com.jerry.financecrawler.vo.IncomeRankingVo;
import org.springframework.stereotype.Component;

/**
 * Created by Jerry on 15/11/30.
 */
@Component
public class HtmlToIncomeRankingVo {
    public IncomeRankingVo parseToIncomeRankingData(String html, int product_id) throws Exception{
        IncomeRankingVo incomeRankingVo = new IncomeRankingVo();

        return incomeRankingVo;
    }

}
