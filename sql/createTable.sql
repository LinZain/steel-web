CREATE TABLE `tb_product` (
  `pdt_id` int(8) NOT NULL,
  `pdt_pic` varchar(64) DEFAULT NULL,
  `pdt_title` varchar(64) DEFAULT NULL,
  `pdt_price` varchar(64) DEFAULT NULL,
  `promotion_price` varchar(64) DEFAULT NULL,
  `pdt_brand` varchar(64) DEFAULT NULL,
  `pdt_category` varchar(64) DEFAULT NULL,
  `pdt_detial` longtext,
  `pdt_describe` longtext,
  `pic_dir` varchar(255) DEFAULT NULL,
  `pdt_inventory` int(10) DEFAULT NULL,
  `pdt_status` int(2) DEFAULT NULL,
  `pdt_lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;