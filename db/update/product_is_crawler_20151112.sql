ALTER TABLE `bs_annual_fluctuation_rate`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `FR_MAXIMUM_CONTINUOUS_LOSS_DAYS`;
ALTER TABLE `bs_annualized_return_rate`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `RR_SINCE_ITS_ESTABLISHMENT`;
ALTER TABLE `bs_calmar_ratio`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `CR_SINCE_ITS_ESTABLISHMENT`;
ALTER TABLE `bs_cost_rate`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `CR_PERFORMANCE_PAY_RATE`;
ALTER TABLE `bs_income_ranking`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `IR_NEARLY_FIVE_YEARS`;
ALTER TABLE `bs_maximum_return`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `MR_SINCE_ITS_ESTABLISHMENT`;
ALTER TABLE `bs_sharp_ratio`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `SR_SINCE_ITS_ESTABLISHMENT`;
ALTER TABLE `bs_sterling_ratio`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `SR_SINCE_ITS_ESTABLISHMENT`;
ALTER TABLE `bs_productfund`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `bs_fund`;

ALTER TABLE `bs_productfundmanager`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `bs_fundmanager`;


ALTER TABLE `bs_fund`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `fund_count`;
ALTER TABLE `bs_fundmanager`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否为爬取 1 是 0 不是' AFTER `BS_WORKING_YEAR`;