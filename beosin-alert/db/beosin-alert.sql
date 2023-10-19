SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for risk_url
-- ----------------------------
DROP TABLE IF EXISTS `risk_url`;
CREATE TABLE `risk_url`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '网址',
  `source` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '来源，爬虫网址或者用户名',
  `detection_result` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0代表安全，1代表不安全',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `creator` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '添加者名字',
  `home_page_link` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '主页链接',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_idx_url`(`url`) USING BTREE,
  INDEX `idx_source`(`source`) USING BTREE,
  INDEX `idx_home_page_link`(`home_page_link`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1714887464251977733 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '风险网站' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for risk_url_log
-- ----------------------------
DROP TABLE IF EXISTS `risk_url_log`;
CREATE TABLE `risk_url_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户的ip',
  `domain` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户访问的域名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 154356428 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '恶意网站记录表' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
