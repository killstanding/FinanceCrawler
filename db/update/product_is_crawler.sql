ALTER TABLE `bs_product`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否爬取 1 是 0 不是' AFTER `product_image_url`;


ALTER TABLE `bs_networth`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否爬取 1 是 0 不是' AFTER `Chg`;


ALTER TABLE `bs_income`
ADD COLUMN `product_is_crawler`  int(1) NULL DEFAULT 0 COMMENT '是否爬取 1 是 0 不是' AFTER `I_SINCE_ITS_ESTABLISHMENT`;



