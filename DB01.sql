SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` bigint NOT NULL AUTO_INCREMENT,
  `dname` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` VALUES (1, '开发部', 'db01');
INSERT INTO `dept` VALUES (2, '人事部', 'db01');
INSERT INTO `dept` VALUES (3, '财务部', 'db01');
INSERT INTO `dept` VALUES (4, '市场部', 'db01');
INSERT INTO `dept` VALUES (5, '运维部', 'db01');
INSERT INTO `dept` VALUES (6, '\"游戏部\"', 'db01');
INSERT INTO `dept` VALUES (7, NULL, 'db01');
INSERT INTO `dept` VALUES (8, NULL, 'db01');
INSERT INTO `dept` VALUES (9, NULL, 'db01');
INSERT INTO `dept` VALUES (10, NULL, 'db01');
INSERT INTO `dept` VALUES (11, NULL, 'db01');
INSERT INTO `dept` VALUES (12, 'xxx', 'db01');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
