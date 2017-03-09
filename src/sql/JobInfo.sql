CREATE TABLE `jobInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `algoArgs` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `algoType` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `errorInfo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `finished` bit(1) NOT NULL,
  `jobId` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `jobName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `runState` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;