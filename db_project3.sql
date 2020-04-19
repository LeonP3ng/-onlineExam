/*
 Navicat MySQL Data Transfer

 Source Server         : lp
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : 152.136.68.17:3306
 Source Schema         : db_project3

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 09/08/2019 09:11:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `studentId` varchar(255) NOT NULL COMMENT '学生编号',
  `studentName` varchar(255) DEFAULT NULL COMMENT '学生姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '学生密码',
  `score` int(11) DEFAULT NULL COMMENT '学生成绩',
  `sclass` varchar(255) DEFAULT NULL COMMENT '班级，与关键字class重名，所以叫sclass',
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
BEGIN;
INSERT INTO `tb_student` VALUES ('123', 'admin', '123123', NULL, '1');
INSERT INTO `tb_student` VALUES ('161003530106', '刘鹏1', '123', 70, '软件一班');
INSERT INTO `tb_student` VALUES ('161003530107', '小明', '1234', 50, '软件二班');
INSERT INTO `tb_student` VALUES ('161003530108', '小红', '1234', 60, '软件四班');
INSERT INTO `tb_student` VALUES ('161003530109', '刘鹏', '1234', 50, '软件一班');
INSERT INTO `tb_student` VALUES ('161003530110', '小刚', '1234', 80, '软件二班');
INSERT INTO `tb_student` VALUES ('161003530111', '刘鹏', '1234', 59, '软件一班');
INSERT INTO `tb_student` VALUES ('161003530113', '哈哈', '1234', 79, '软件一班');
INSERT INTO `tb_student` VALUES ('161003530114', '刘鹏', '1234', 12, '软件一班');
INSERT INTO `tb_student` VALUES ('161003530115', '刘鹏', '1234', 34, '软件二班');
INSERT INTO `tb_student` VALUES ('161003530116', '刘鹏2', '1234', 57, '软件二班');
INSERT INTO `tb_student` VALUES ('161003530117', '刘鹏3', '1234', 95, '软件一班');
INSERT INTO `tb_student` VALUES ('161003530118', '刘鹏5', '1234', 92, '软件四班');
INSERT INTO `tb_student` VALUES ('161003530119', '刘鹏', '1234', 93, '软件一班');
INSERT INTO `tb_student` VALUES ('161003530120', '刘鹏7', '1234', 90, '软件一班');
INSERT INTO `tb_student` VALUES ('161003530999', '张三', '123', 95, '软件四班');
INSERT INTO `tb_student` VALUES ('201611048', 'lsy', '123456', NULL, '1602');
INSERT INTO `tb_student` VALUES ('2017012698', 'OLIVIA', '123456', 80, '软件二班');
INSERT INTO `tb_student` VALUES ('2017013053', '刘鹏', '123', 90, '软件一班');
INSERT INTO `tb_student` VALUES ('66666', '刘鹏', '123', 100, '软件一班');
COMMIT;

-- ----------------------------
-- Table structure for tb_subject
-- ----------------------------
DROP TABLE IF EXISTS `tb_subject`;
CREATE TABLE `tb_subject` (
  `subjectId` int(11) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subjectTitle` varchar(255) DEFAULT NULL COMMENT '试题题目',
  `subjectOptionA` varchar(255) DEFAULT NULL COMMENT '试题选项',
  `subjectOptionB` varchar(255) DEFAULT NULL,
  `subjectOptionC` varchar(255) DEFAULT NULL,
  `subjectOptionD` varchar(255) DEFAULT NULL,
  `subjectAnswer` varchar(255) DEFAULT NULL COMMENT '正确答案',
  `subjectParse` text COMMENT '试题解析',
  PRIMARY KEY (`subjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_subject
-- ----------------------------
BEGIN;
INSERT INTO `tb_subject` VALUES (2, '1+1=?', '4', '2', '5', '7', 'B', '一年级小朋友都会的！');
INSERT INTO `tb_subject` VALUES (3, '下列正确的标识符是（）', '-a1', 'a[i]', 'a2_i', 'int t', 'C', '（1）只能由字母、数字、下划线构成。（2）数字不能作为标识符的开头。（3）关键字不能作为标识符。');
INSERT INTO `tb_subject` VALUES (4, 'C语言中的简单数据类型包括（）', '整型、实型、逻辑型', '整型、实型、逻辑型、字符型', '整型、字符型、逻辑型', '整型、实型、字符型', 'D', 'C语言中的简单数据类型包括：整型、实型、字符型。');
INSERT INTO `tb_subject` VALUES (5, '在C语言程序中，表达式5%2的结果是（）', '2.5', '2', '3', '1', 'D', '%为求余运算符，该运算符只能对整型数据进行运算。且符号与被模数相同。5%2=1；');
INSERT INTO `tb_subject` VALUES (6, '若有说明：int a[][3]={{1,2,3},{4,5},{6,7}}; 则数组a的第一维的大小为: ( )', '2', '3', '4', '无确定值', 'B', '二维数组的一维大小，即指二维数组的行数，在本题中，按行对二维数组赋值，因此内层有几个大括号，数组就有几行');
INSERT INTO `tb_subject` VALUES (7, '十进制5转化为二进制是()', '0101', '1010', '1100', '1001', 'A', '进制转换');
INSERT INTO `tb_subject` VALUES (8, 'C语言中函数返回值的类型是由（）决定的', '函数定义时指定的类型', 'return语句中的表达式类型', '调用该函数时的实参的数据类型', '形参的数据类型', 'A', 'C语言中函数返回值的类型是由函数定义时指定的类型决定的');
INSERT INTO `tb_subject` VALUES (9, '在C语言中，表示静态存储类别的关键字是', 'auto', 'register', 'static', 'extern', 'C', 'static');
INSERT INTO `tb_subject` VALUES (10, '在C语言程序中，表达式5%2的结果是（）', '4', '3', '2', '1', 'A', '');
INSERT INTO `tb_subject` VALUES (11, '()是构成C语言程序的基本单位。', '函数', '过程', '子程序', '子例程', 'A', '函数是构成C语言程序的基本单位');
INSERT INTO `tb_subject` VALUES (13, '在C语言程序中，表达式5%2的结果是（）', '1', '2', '3', '0', 'A', '');
INSERT INTO `tb_subject` VALUES (14, '在C语言中，表示静态存储类别的关键字是', 'auto', 'register', 'static', 'extern', 'C', 'static');
INSERT INTO `tb_subject` VALUES (15, '在C语言程序中，表达式5%2的结果是（）', '2.5', '2', '3', '1', 'A', '');
INSERT INTO `tb_subject` VALUES (16, 'C语言中的简单数据类型包括（）', '整型、实型、逻辑型', '整型、实型、逻辑型、字符型', '整型、字符型、逻辑型', '整型、实型、字符型', 'D', 'C语言中的简单数据类型包括：整型、实型、字符型。');
INSERT INTO `tb_subject` VALUES (17, '下列正确的标识符是（）', '-a1', 'a[i]', 'a2_i', 'int t', 'C', '（1）只能由字母、数字、下划线构成。（2）数字不能作为标识符的开头。（3）关键字不能作为标识符。');
INSERT INTO `tb_subject` VALUES (20, '下列关于C语言的说法错误的是（）', 'C程序的工作过程是编辑、编译、连接、运行', 'C语言不区分大小写', 'C程序的三种基本结构是顺序、选择、循环', 'C程序从main函数开始执行', 'B', '   							C语言区分大小写\r\n   						');
INSERT INTO `tb_subject` VALUES (21, '若有说明：int a[][3]={{1,2,3},{4,5},{6,7}}; 则数组a的第一维的大小为: ( )', '2', '3', '4', '无确定值', 'B', '   							二维数组的一维大小，即指二维数组的行数，在本题中，按行对二维数组赋值，因此内层有几个大括号，数组就有几行\r\n   						');
INSERT INTO `tb_subject` VALUES (22, '下列C语言用户标识符中合法的是（）', '3ax', 'x', 'case', '-e2', 'B', '   							选项A中的标识符以数字开头不满足；选项C为关键字；选项D中的“-”开头\r\n   						');
INSERT INTO `tb_subject` VALUES (24, '以下哪种耦合耦合度最低？', '数据耦合', '过程耦合', '公共耦合', '控制耦合', 'A', '');
INSERT INTO `tb_subject` VALUES (27, '谁是最帅的人', '吴亦凡', '坤坤', '吴彦祖', '刘鹏', 'D', '废话');
INSERT INTO `tb_subject` VALUES (28, '在C语言程序中，表达式5%2的结果是（）', '2.5', '2', '3', '1', 'A', '');
INSERT INTO `tb_subject` VALUES (32, '今天是6月？日', '3', '4', '5', '6', 'A', 'Not today!');
COMMIT;

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `teacherId` varchar(255) NOT NULL COMMENT '老师编号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
BEGIN;
INSERT INTO `tb_teacher` VALUES ('2017', '123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
