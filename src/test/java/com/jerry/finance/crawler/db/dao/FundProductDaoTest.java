package com.jerry.finance.crawler.db.dao;

import com.jerry.finance.crawler.TestBase;
import com.jerry.financecrawler.db.dao.IFundProductDao;
import com.jerry.financecrawler.db.po.FundProductPo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by Jerry on 2015/10/20.
 */
public class FundProductDaoTest extends TestBase {
    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(FundProductDaoTest.class);
    @Resource
    private IFundProductDao fundProductDao;

    @Test
    public void testFind() {
        int id = 2;
        FundProductPo po =fundProductDao.find(id);
        log.info("[FundProductPo] = " + po.toString());
    }
}
