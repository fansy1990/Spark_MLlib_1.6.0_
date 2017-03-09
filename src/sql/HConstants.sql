CREATE TABLE `hconstants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custKey` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `custValue` longtext COLLATE utf8_bin,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;