/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50090
Source Host           : localhost:3306
Source Database       : jeecg

Target Server Type    : MYSQL
Target Server Version : 50090
File Encoding         : 65001

Date: 2014-08-14 17:27:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cgform_button
-- ----------------------------
DROP TABLE IF EXISTS `cgform_button`;
CREATE TABLE `cgform_button` (
  `ID` varchar(32) NOT NULL,
  `BUTTON_CODE` varchar(50) default NULL,
  `button_icon` varchar(20) default NULL,
  `BUTTON_NAME` varchar(50) default NULL,
  `BUTTON_STATUS` varchar(2) default NULL,
  `BUTTON_STYLE` varchar(20) default NULL,
  `EXP` varchar(255) default NULL,
  `FORM_ID` varchar(32) default NULL,
  `OPT_TYPE` varchar(20) default NULL,
  `order_num` int(11) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cgform_button
-- ----------------------------

-- ----------------------------
-- Table structure for cgform_button_sql
-- ----------------------------
DROP TABLE IF EXISTS `cgform_button_sql`;
CREATE TABLE `cgform_button_sql` (
  `ID` varchar(32) NOT NULL,
  `BUTTON_CODE` varchar(50) default NULL,
  `CGB_SQL` tinyblob,
  `CGB_SQL_NAME` varchar(50) default NULL,
  `CONTENT` longtext,
  `FORM_ID` varchar(32) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cgform_button_sql
-- ----------------------------

-- ----------------------------
-- Table structure for cgform_enhance_js
-- ----------------------------
DROP TABLE IF EXISTS `cgform_enhance_js`;
CREATE TABLE `cgform_enhance_js` (
  `ID` varchar(32) NOT NULL,
  `CG_JS` blob,
  `CG_JS_TYPE` varchar(20) default NULL,
  `CONTENT` longtext,
  `FORM_ID` varchar(32) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cgform_enhance_js
-- ----------------------------

-- ----------------------------
-- Table structure for cgform_field
-- ----------------------------
DROP TABLE IF EXISTS `cgform_field`;
CREATE TABLE `cgform_field` (
  `id` varchar(32) NOT NULL,
  `content` varchar(200) NOT NULL,
  `create_by` varchar(255) default NULL,
  `create_date` datetime default NULL,
  `create_name` varchar(32) default NULL,
  `dict_field` varchar(100) default NULL,
  `dict_table` varchar(100) default NULL,
  `dict_text` varchar(100) default NULL,
  `field_default` varchar(20) default NULL,
  `field_href` varchar(200) default NULL,
  `field_length` int(11) default NULL,
  `field_name` varchar(32) NOT NULL,
  `field_valid_type` varchar(10) default NULL,
  `is_key` varchar(2) default NULL,
  `is_null` varchar(5) default NULL,
  `is_query` varchar(5) default NULL,
  `is_show` varchar(5) default NULL,
  `is_show_list` varchar(5) default NULL,
  `length` int(11) NOT NULL,
  `main_field` varchar(100) default NULL,
  `main_table` varchar(100) default NULL,
  `old_field_name` varchar(32) default NULL,
  `order_num` int(11) default NULL,
  `point_length` int(11) default NULL,
  `query_mode` varchar(10) default NULL,
  `show_type` varchar(10) default NULL,
  `type` varchar(32) NOT NULL,
  `update_by` varchar(32) default NULL,
  `update_date` datetime default NULL,
  `update_name` varchar(32) default NULL,
  `table_id` varchar(32) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cgform_field
-- ----------------------------
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda804e0132', '主键', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'id', null, 'Y', 'N', 'N', 'N', 'N', '36', '', '', null, '0', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda8033012d');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80550133', '订单号', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'order_code', null, 'N', 'Y', 'Y', 'Y', 'Y', '50', '', '', null, '1', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda8033012d');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80590134', '订单日期', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'order_date', null, 'N', 'Y', 'Y', 'Y', 'Y', '20', '', '', null, '2', '0', 'single', 'date', 'Date', null, null, null, '402882e446efd9fd0146efda8033012d');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda805d0135', '订单金额', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'order_money', null, 'N', 'Y', 'Y', 'Y', 'Y', '10', '', '', null, '3', '3', 'single', 'text', 'double', null, null, null, '402882e446efd9fd0146efda8033012d');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80610136', '备注', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'content', null, 'N', 'Y', 'Y', 'Y', 'Y', '255', '', '', null, '4', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda8033012d');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80700137', '主键', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'id', null, 'Y', 'N', 'N', 'N', 'N', '36', '', '', null, '0', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80750138', '请假标题', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'title', null, 'N', 'N', 'N', 'Y', 'Y', '50', '', '', null, '1', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80780139', '请假人', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'people', null, 'N', 'N', 'Y', 'Y', 'Y', '20', '', '', null, '2', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda807b013a', '性别', 'admin', '2014-07-01 10:56:52', '管理员', 'sex', '', null, null, null, '0', 'sex', null, 'N', 'N', 'Y', 'Y', 'Y', '10', '', '', null, '3', '0', 'single', 'list', 'string', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda807e013b', '请假开始时间', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'begindate', null, 'N', 'N', 'N', 'Y', 'Y', '0', '', '', null, '4', '0', 'group', 'date', 'Date', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda8080013c', '请假结束时间', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'enddate', null, 'N', 'N', 'N', 'Y', 'Y', '0', '', '', null, '5', '0', 'group', 'datetime', 'Date', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda8083013d', '所属部门', 'admin', '2014-07-01 10:56:52', '管理员', 'id', 't_s_depart', 'departname', null, null, '0', 'hol_dept', null, 'N', 'N', 'N', 'Y', 'Y', '32', '', '', null, '7', '0', 'single', 'list', 'string', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda8086013e', '请假原因', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'hol_reson', null, 'N', 'N', 'N', 'Y', 'Y', '255', '', '', null, '8', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda8089013f', '部门审批人', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'dep_leader', null, 'N', 'N', 'N', 'Y', 'Y', '20', '', '', null, '9', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda808b0140', '部门审批意见', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'content', null, 'N', 'N', 'N', 'Y', 'Y', '255', '', '', null, '10', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda808e0141', '请假天数', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '120', 'day_num', null, 'N', 'Y', 'N', 'Y', 'Y', '10', '', '', null, '6', '0', 'single', 'text', 'int', null, null, null, '402882e446efd9fd0146efda803c012e');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda809c0142', '主键', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'id', null, 'Y', 'N', 'N', 'N', 'N', '36', '', '', null, '0', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803f012f');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda809f0143', '客户名', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'name', null, 'N', 'Y', 'Y', 'Y', 'Y', '32', '', '', null, '1', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803f012f');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80a30144', '单价', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'money', null, 'N', 'Y', 'Y', 'Y', 'Y', '10', '', '', null, '2', '2', 'group', 'text', 'double', null, null, null, '402882e446efd9fd0146efda803f012f');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80a60145', '外键', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '120', 'fk_id', null, 'N', 'N', 'Y', 'N', 'N', '36', 'id', 'jform_order_main', null, '5', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803f012f');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80a80146', '电话', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '120', 'telphone', null, 'N', 'Y', 'Y', 'Y', 'Y', '32', '', '', null, '4', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda803f012f');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80ac0147', '性别', 'admin', '2014-07-01 10:56:52', '管理员', 'sex', '', null, null, null, '120', 'sex', null, 'N', 'Y', 'Y', 'Y', 'Y', '4', '', '', null, '3', '0', 'single', 'radio', 'string', null, null, null, '402882e446efd9fd0146efda803f012f');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80b30148', '主键', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '120', 'id', null, 'Y', 'N', 'N', 'N', 'N', '36', '', '', null, '0', '0', 'single', 'checkbox', 'string', null, null, null, '402882e446efd9fd0146efda80420130');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80b70149', '航班号', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '120', 'ticket_code', null, 'N', 'N', 'Y', 'Y', 'Y', '100', '', '', null, '1', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80420130');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80ba014a', '航班时间', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '120', 'tickect_date', null, 'N', 'N', 'Y', 'Y', 'Y', '10', '', '', null, '2', '0', 'single', 'datetime', 'Date', null, null, null, '402882e446efd9fd0146efda80420130');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80bc014b', '外键', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '120', 'fck_id', null, 'N', 'N', 'N', 'N', 'N', '36', 'id', 'jform_order_main', null, '3', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80420130');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80c4014c', '主键', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'id', null, 'Y', 'N', 'N', 'N', 'N', '36', '', '', null, '0', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80c9014d', '机构合计', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'a', null, 'N', 'N', 'Y', 'Y', 'Y', '10', '', '', null, '1', '2', 'group', 'text', 'double', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80cd014e', '行政小计', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'b1', null, 'N', 'N', 'N', 'Y', 'Y', '10', '', '', null, '2', '2', 'group', 'text', 'double', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80d0014f', '行政省', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'b11', null, 'N', 'N', 'N', 'Y', 'Y', '100', '', '', null, '3', '0', 'group', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80d30150', '行政市', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'b12', null, 'N', 'N', 'N', 'Y', 'Y', '100', '', '', null, '4', '0', 'group', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80d60151', '行政县', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'b13', null, 'N', 'N', 'N', 'Y', 'Y', '100', '', '', null, '5', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80dc0152', '事业合计', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'b2', null, 'N', 'N', 'N', 'Y', 'Y', '10', '', '', null, '6', '2', 'single', 'text', 'double', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80e00153', '参公小计', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'b3', null, 'N', 'N', 'N', 'Y', 'Y', '10', '', '', null, '7', '2', 'single', 'text', 'double', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80e30154', '参公省', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'b31', null, 'N', 'N', 'N', 'Y', 'Y', '100', '', '', null, '8', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80e60155', '参公市', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'b32', null, 'N', 'N', 'N', 'Y', 'Y', '100', '', '', null, '9', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80e90156', '参公县', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'b33', null, 'N', 'N', 'N', 'Y', 'Y', '100', '', '', null, '10', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80ec0157', '全额拨款', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'c1', null, 'N', 'N', 'N', 'Y', 'Y', '10', '', '', null, '11', '2', 'single', 'text', 'double', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80ef0158', '差额拨款', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'c2', null, 'N', 'N', 'N', 'Y', 'Y', '10', '', '', null, '12', '2', 'single', 'text', 'double', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80f30159', '自收自支', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'c3', null, 'N', 'N', 'N', 'Y', 'Y', '10', '', '', null, '13', '2', 'single', 'text', 'double', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80f5015a', '经费合计', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'd', null, 'N', 'N', 'Y', 'Y', 'Y', '10', '', '', null, '14', '2', 'single', 'text', 'int', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446efd9fd0146efda80f8015b', '机构资质', 'admin', '2014-07-01 10:56:52', '管理员', '', '', null, null, null, '0', 'd1', null, 'N', 'N', 'N', 'Y', 'Y', '1000', '', '', null, '15', '0', 'single', 'text', 'string', null, null, null, '402882e446efd9fd0146efda80450131');
INSERT INTO `cgform_field` VALUES ('402882e446f088f00146f090033e0002', '主键', 'admin', '2014-07-01 14:15:08', '管理员', '', '', '', '', '', '120', 'id', '', 'Y', 'N', 'N', 'N', 'N', '36', '', '', 'id', '1', '0', 'single', 'text', 'string', null, null, null, '402882e446f088f00146f090033a0001');
INSERT INTO `cgform_field` VALUES ('402882e446f088f00146f09003520003', '标题', 'admin', '2014-07-01 14:15:08', '管理员', '', '', '', '', '', '200', 'title', '', 'N', 'N', 'N', 'Y', 'Y', '100', '', '', 'title', '2', '0', 'single', 'text', 'string', 'admin', '2014-07-02 09:53:51', '管理员', '402882e446f088f00146f090033a0001');
INSERT INTO `cgform_field` VALUES ('402882e446f088f00146f09003570004', '内容', 'admin', '2014-07-01 14:15:08', '管理员', '', '', '', '', '', '200', 'content', '', 'N', 'N', 'N', 'Y', 'Y', '0', '', '', 'content', '6', '0', 'single', 'textarea', 'Text', 'admin', '2014-07-02 09:53:51', '管理员', '402882e446f088f00146f090033a0001');
INSERT INTO `cgform_field` VALUES ('402882e446f088f00146f090035d0005', '生效时间', 'admin', '2014-07-01 14:15:08', '管理员', '', '', '', '', '', '200', 'validtime', '', 'N', 'N', 'N', 'Y', 'Y', '0', '', '', 'validtime', '4', '0', 'single', 'date', 'Date', 'admin', '2014-07-02 09:53:51', '管理员', '402882e446f088f00146f090033a0001');
INSERT INTO `cgform_field` VALUES ('402882e446f088f00146f09003630006', '失效时间', 'admin', '2014-07-01 14:15:08', '管理员', '', '', '', '', '', '200', 'invalidtime', '', 'N', 'N', 'N', 'Y', 'Y', '0', '', '', 'invalidtime', '5', '0', 'single', 'date', 'Date', 'admin', '2014-07-02 09:53:51', '管理员', '402882e446f088f00146f090033a0001');
INSERT INTO `cgform_field` VALUES ('402882e446f088f00146f09003760007', '是否置顶', 'admin', '2014-07-01 14:15:08', '管理员', 'yesorno', '', '', '', '', '200', 'is_on_top', '', 'N', 'N', 'N', 'Y', 'Y', '50', '', '', 'is_on_top', '3', '0', 'single', 'list', 'string', 'admin', '2014-07-02 09:53:51', '管理员', '402882e446f088f00146f090033a0001');
INSERT INTO `cgform_field` VALUES ('8a8080ef46f4e8a50146f5094c020006', '主键', 'admin', '2014-07-02 11:06:05', '管理员', '', '', '', '', '', '120', 'id', '', 'Y', 'N', 'N', 'N', 'N', '36', '', '', 'id', '1', '0', 'single', 'text', 'string', null, null, null, '8a8080ef46f4e8a50146f5094bfc0005');
INSERT INTO `cgform_field` VALUES ('8a8080ef46f4e8a50146f5094c160007', '类型名称', 'admin', '2014-07-02 11:06:05', '管理员', '', '', '', '', '', '120', 'name', '', 'N', 'N', 'N', 'Y', 'Y', '100', '', '', 'name', '2', '0', 'single', 'text', 'string', null, null, null, '8a8080ef46f4e8a50146f5094bfc0005');
INSERT INTO `cgform_field` VALUES ('8a8080ef46f4e8a50146f5094c1a0008', '类型单位名', 'admin', '2014-07-02 11:06:05', '管理员', '', '', '', '', '', '120', 'unit_name', '', 'N', 'N', 'N', 'Y', 'Y', '100', '', '', 'unit_name', '3', '0', 'single', 'text', 'string', null, null, null, '8a8080ef46f4e8a50146f5094bfc0005');
INSERT INTO `cgform_field` VALUES ('8a8080ef46f4e8a50146f51264790017', '设备数量', 'admin', '2014-07-02 11:16:01', '管理员', '', '', '', '', '', '120', 'amount', '', 'N', 'N', 'N', 'Y', 'Y', '22', '', '', 'amount', '4', '0', 'group', 'textarea', 'double', 'admin', '2014-07-26 23:12:07', '管理员', '8a8080ef46f4e8a50146f512646c0013');
INSERT INTO `cgform_field` VALUES ('8a8080ef46f4e8a50146f51264730015', '设备名称', 'admin', '2014-07-02 11:16:01', '管理员', '', '', '', '', '', '120', 'name', '', 'N', 'N', 'N', 'Y', 'Y', '100', '', '', 'name', '2', '0', 'group', 'text', 'string', 'admin', '2014-07-02 11:16:44', '管理员', '8a8080ef46f4e8a50146f512646c0013');
INSERT INTO `cgform_field` VALUES ('8a8080ef46f4e8a50146f51264760016', '设备类型', 'admin', '2014-07-02 11:16:01', '管理员', '', '', '', '', '', '120', 'type', '', 'N', 'N', 'N', 'Y', 'Y', '50', 'id', 't_oa_enquipment_type', 'type', '3', '0', 'group', 'list', 'string', 'admin', '2014-07-02 14:05:45', '管理员', '8a8080ef46f4e8a50146f512646c0013');
INSERT INTO `cgform_field` VALUES ('8a8080ef46f4e8a50146f512646d0014', 'id', 'admin', '2014-07-02 11:16:01', '管理员', '', '', '', '', '', '120', 'id', '', 'Y', 'N', 'N', 'N', 'N', '36', '', '', 'id', '1', '0', 'group', 'text', 'string', 'admin', '2014-07-02 11:16:44', '管理员', '8a8080ef46f4e8a50146f512646c0013');
INSERT INTO `cgform_field` VALUES ('402880e7477349520147785aa619002c', '主键', 'admin', '2014-07-27 23:05:12', '管理员', '', '', '', '', '', '120', 'id', '', 'Y', 'N', 'N', 'N', 'N', '36', '', '', 'id', '1', '0', 'single', 'text', 'string', null, null, null, '402880e7477349520147785aa615002b');
INSERT INTO `cgform_field` VALUES ('402880e7477349520147785aa635002d', '活动地点', 'admin', '2014-07-27 23:05:12', '管理员', '', '', '', '', '', '120', 'address', '', 'N', 'N', 'N', 'Y', 'Y', '1000', '', '', 'address', '2', '0', 'single', 'text', 'string', null, null, null, '402880e7477349520147785aa615002b');
INSERT INTO `cgform_field` VALUES ('402880e7477349520147785aa639002e', '活动内容', 'admin', '2014-07-27 23:05:12', '管理员', '', '', '', '', '', '120', 'content', '', 'N', 'N', 'N', 'Y', 'Y', '1000', '', '', 'content', '3', '0', 'single', 'textarea', 'string', null, null, null, '402880e7477349520147785aa615002b');
INSERT INTO `cgform_field` VALUES ('402880e7477349520147785aa63e002f', ' 活动时间', 'admin', '2014-07-27 23:05:12', '管理员', '', '', '', '', '', '120', 'executetime', '', 'N', 'N', 'N', 'Y', 'Y', '0', '', '', 'executetime', '4', '0', 'single', 'datetime', 'Date', null, null, null, '402880e7477349520147785aa615002b');
INSERT INTO `cgform_field` VALUES ('402882e4477b800f01477b8ed9890009', '主键', 'admin', '2014-07-28 14:01:05', '管理员', '', '', '', '', '', '120', 'id', '', 'Y', 'N', 'N', 'N', 'N', '36', '', '', 'id', '1', '0', 'single', 'text', 'string', null, null, null, '402882e4477b800f01477b8ed9860008');
INSERT INTO `cgform_field` VALUES ('402882e4477b800f01477b8ed99a000a', '会议时间', 'admin', '2014-07-28 14:01:05', '管理员', '', '', '', '', '', '120', 'executetime', '', 'N', 'Y', 'N', 'Y', 'Y', '0', '', '', 'executetime', '2', '0', 'single', 'datetime', 'Date', null, null, null, '402882e4477b800f01477b8ed9860008');
INSERT INTO `cgform_field` VALUES ('402882e4477b800f01477b8ed99d000b', '会议内容', 'admin', '2014-07-28 14:01:05', '管理员', '', '', '', '', '', '120', 'content', '', 'N', 'Y', 'N', 'Y', 'Y', '1000', '', '', 'content', '3', '0', 'single', 'textarea', 'string', null, null, null, '402882e4477b800f01477b8ed9860008');
INSERT INTO `cgform_field` VALUES ('402882e4477b800f01477b8ed9a0000c', '会议地点', 'admin', '2014-07-28 14:01:05', '管理员', 'roomtype', '', '', '', '', '120', 'roomtype', '', 'N', 'Y', 'N', 'Y', 'Y', '50', '', '', 'roomtype', '4', '0', 'single', 'list', 'string', null, null, null, '402882e4477b800f01477b8ed9860008');

-- ----------------------------
-- Table structure for cgform_ftl
-- ----------------------------
DROP TABLE IF EXISTS `cgform_ftl`;
CREATE TABLE `cgform_ftl` (
  `ID` varchar(32) NOT NULL,
  `CGFORM_ID` varchar(36) NOT NULL,
  `CGFORM_NAME` varchar(100) NOT NULL,
  `CREATE_BY` varchar(36) default NULL,
  `CREATE_DATE` datetime default NULL,
  `CREATE_NAME` varchar(32) default NULL,
  `FTL_CONTENT` longtext,
  `FTL_STATUS` varchar(50) default NULL,
  `FTL_VERSION` int(11) NOT NULL,
  `FTL_WORD_URL` varchar(200) default NULL,
  `UPDATE_BY` varchar(36) default NULL,
  `UPDATE_DATE` datetime default NULL,
  `UPDATE_NAME` varchar(32) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cgform_ftl
-- ----------------------------

-- ----------------------------
-- Table structure for cgform_head
-- ----------------------------
DROP TABLE IF EXISTS `cgform_head`;
CREATE TABLE `cgform_head` (
  `id` varchar(32) NOT NULL,
  `content` varchar(200) NOT NULL,
  `create_by` varchar(32) default NULL,
  `create_date` datetime default NULL,
  `create_name` varchar(32) default NULL,
  `is_checkbox` varchar(5) NOT NULL,
  `is_dbsynch` varchar(20) NOT NULL,
  `is_pagination` varchar(5) NOT NULL,
  `is_tree` varchar(5) NOT NULL,
  `jform_pk_sequence` varchar(200) default NULL,
  `jform_pk_type` varchar(100) default NULL,
  `jform_type` int(11) NOT NULL,
  `jform_version` varchar(10) NOT NULL,
  `querymode` varchar(10) NOT NULL,
  `relation_type` int(11) default NULL,
  `sub_table_str` longtext,
  `tab_order` int(11) default NULL,
  `table_name` varchar(20) NOT NULL,
  `update_by` varchar(32) default NULL,
  `update_date` datetime default NULL,
  `update_name` varchar(32) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cgform_head
-- ----------------------------
INSERT INTO `cgform_head` VALUES ('402882e446efd9fd0146efda8033012d', '订单主信息', 'admin', '2014-07-01 10:56:52', '管理员', 'N', 'N', 'Y', 'N', null, 'UUID', '2', '59', 'group', '0', 'jform_order_ticket,jform_order_customer', null, 'jform_order_main', 'admin', '2014-07-02 11:19:32', '管理员');
INSERT INTO `cgform_head` VALUES ('402882e446efd9fd0146efda803c012e', '请假单', 'admin', '2014-07-01 10:56:52', '管理员', 'N', 'N', 'Y', 'N', null, 'UUID', '1', '51', 'group', '0', null, null, 'jform_leave', null, null, null);
INSERT INTO `cgform_head` VALUES ('402882e446efd9fd0146efda803f012f', '订单客户信息', 'admin', '2014-07-01 10:56:52', '管理员', 'Y', 'Y', 'Y', 'N', null, 'UUID', '3', '16', 'single', '0', null, null, 'jform_order_customer', 'admin', '2014-07-02 11:13:34', '管理员');
INSERT INTO `cgform_head` VALUES ('402882e446efd9fd0146efda80420130', '订单机票信息', 'admin', '2014-07-01 10:56:52', '管理员', 'N', 'N', 'Y', 'N', null, 'UUID', '3', '20', 'single', '0', null, null, 'jform_order_ticket', null, null, null);
INSERT INTO `cgform_head` VALUES ('402882e446efd9fd0146efda80450131', '价格认证机构统计表', 'admin', '2014-07-01 10:56:52', '管理员', 'N', 'N', 'Y', 'N', null, 'UUID', '1', '3', 'group', '0', null, null, 'jform_price1', null, null, null);
INSERT INTO `cgform_head` VALUES ('402882e446f088f00146f090033a0001', '公告通知', 'admin', '2014-07-01 14:15:08', '管理员', 'N', 'Y', 'Y', 'N', '', 'UUID', '1', '7', 'single', '0', null, null, 't_oa_announcement', 'admin', '2014-07-02 09:53:58', '管理员');
INSERT INTO `cgform_head` VALUES ('8a8080ef46f4e8a50146f5094bfc0005', '设备类型', 'admin', '2014-07-02 11:06:05', '管理员', 'N', 'Y', 'Y', 'N', '', 'UUID', '1', '17', 'single', '0', 't_oa_enquipment', null, 't_oa_enquipment_type', 'admin', '2014-07-26 23:12:07', '管理员');
INSERT INTO `cgform_head` VALUES ('8a8080ef46f4e8a50146f512646c0013', '办公设备', 'admin', '2014-07-02 11:16:01', '管理员', 'Y', 'Y', 'Y', 'N', '', 'UUID', '1', '11', 'single', '1', null, null, 't_oa_enquipment', 'admin', '2014-07-26 23:12:07', '管理员');
INSERT INTO `cgform_head` VALUES ('402880e7477349520147785aa615002b', '日程安排', 'admin', '2014-07-27 23:05:12', '管理员', 'N', 'Y', 'Y', 'N', '', 'UUID', '1', '1', 'single', '0', null, null, 't_oa_schedule', 'admin', '2014-07-27 23:05:20', '管理员');
INSERT INTO `cgform_head` VALUES ('402882e4477b800f01477b8ed9860008', '会议管理', 'admin', '2014-07-28 14:01:05', '管理员', 'N', 'Y', 'Y', 'N', '', 'UUID', '1', '1', 'single', '0', null, null, 't_oa_conference', 'admin', '2014-07-28 14:01:10', '管理员');

-- ----------------------------
-- Table structure for cgform_uploadfiles
-- ----------------------------
DROP TABLE IF EXISTS `cgform_uploadfiles`;
CREATE TABLE `cgform_uploadfiles` (
  `CGFORM_FIELD` varchar(100) NOT NULL,
  `CGFORM_ID` varchar(36) NOT NULL,
  `CGFORM_NAME` varchar(100) NOT NULL,
  `id` varchar(32) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_qwig8sn3okhvh4wye8nn8gdeg` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cgform_uploadfiles
-- ----------------------------

-- ----------------------------
-- Table structure for ck_editor
-- ----------------------------
DROP TABLE IF EXISTS `ck_editor`;
CREATE TABLE `ck_editor` (
  `ID` varchar(32) NOT NULL,
  `CONTENTS` blob,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ck_editor
-- ----------------------------
INSERT INTO `ck_editor` VALUES ('402882e446efd9fd0146efda802e012c', 0x3C68746D6C3E3C686561643E3C7469746C653E3C2F7469746C653E3C6C696E6B20687265663D27706C75672D696E2F6561737975692F7468656D65732F64656661756C742F6561737975692E637373272069643D276561737975695468656D65272072656C3D277374796C6573686565742720747970653D27746578742F63737327202F3E3C6C696E6B20687265663D27706C75672D696E2F6561737975692F7468656D65732F69636F6E2E637373272072656C3D277374796C6573686565742720747970653D27746578742F63737327202F3E3C6C696E6B20687265663D27706C75672D696E2F6163636F7264696F6E2F6373732F6163636F7264696F6E2E637373272072656C3D277374796C6573686565742720747970653D27746578742F63737327202F3E3C6C696E6B20687265663D27706C75672D696E2F56616C6964666F726D2F6373732F7374796C652E637373272072656C3D277374796C6573686565742720747970653D27746578742F63737327202F3E3C6C696E6B20687265663D27706C75672D696E2F56616C6964666F726D2F6373732F7461626C6566726F6D2E637373272072656C3D277374796C6573686565742720747970653D27746578742F63737327202F3E3C7374796C6520747970653D27746578742F637373273E626F64797B666F6E742D73697A653A313270783B7D7461626C65207B626F726465723A31707820736F6C696420233030303030303B626F726465722D636F6C6C617073653A20636F6C6C617073653B7D7464207B626F726465723A31707820736F6C696420233030303030303B6261636B67726F756E643A77686974653B666F6E742D73697A653A313270783B666F6E742D66616D696C793A20E696B0E5AE8BE4BD933B636F6C6F723A20233333333B3C2F7374796C653E3C2F686561643E3C626F64793E3C6469763E3C703EE99984E4BBB632EFBC9A3C2F703E3C6831207374796C653D27746578742D616C69676E3A63656E746572273E3C7370616E207374796C653D27666F6E742D73697A653A32347078273E3C7374726F6E673EE4BBB7E6A0BCE8AEA4E8AF81E4BABAE59198E7BB9FE8AEA1E8A1A83C2F7374726F6E673E3C2F7370616E3E3C2F68313E3C703EE5A1ABE68AA5E58D95E4BD8DEFBC88E79B96E7ABA0EFBC89EFBC9A3C696E707574206E616D653D276F72675F6E616D652720747970653D2774657874272076616C75653D27247B6F72675F6E616D653F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C703EE58D95E4BD8DE4BBA3E7A081E58FB7EFBC9A3C696E707574206E616D653D276E756D2720747970653D2774657874272076616C75653D27247B6E756D3F69665F6578697374733F68746D6C7D27202F3E20266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703BE58D95E4BD8DEFBC9AE4BABAE5A1AB266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B20E68AA5E697A5E69C9FEFBC9A266E6273703B266E6273703B266E6273703B266E6273703B266E6273703B20E5B9B4266E6273703B266E6273703B20E69C88266E6273703B266E6273703B20E697A53C2F703E3C666F726D20616374696F6E3D276367466F726D4275696C64436F6E74726F6C6C65722E646F3F736176654F72557064617465272069643D27666F726D6F626A27206D6574686F643D27706F737427206E616D653D27666F726D6F626A273E3C696E707574206E616D653D277461626C654E616D652720747970653D2768696464656E272076616C75653D27247B7461626C654E616D653F69665F6578697374733F68746D6C7D27202F3E203C696E707574206E616D653D2769642720747970653D2768696464656E272076616C75653D27247B69643F69665F6578697374733F68746D6C7D27202F3E237B6A666F726D5F68696464656E5F6669656C647D3C696E70757420747970653D2768696464656E27202F3E3C703E266E6273703B3C2F703E3C7461626C6520626F726465723D2731272063656C6C70616464696E673D2730272063656C6C73706163696E673D273027207374796C653D2777696474683A313031367078273E3C74626F64793E3C74723E3C746420726F777370616E3D2734273E3C703E266E6273703B3C2F703E3C703E266E6273703B3C2F703E3C703EE59088E8AEA13C2F703E3C703E266E6273703B3C2F703E3C2F74643E3C746420636F6C7370616E3D27362720726F777370616E3D2732273E3C703E266E6273703B3C2F703E3C703EE4BABAE695B03C2F703E3C2F74643E3C746420636F6C7370616E3D27352720726F777370616E3D2732273E3C703E266E6273703B3C2F703E3C703EE5ADA6E58E863C2F703E3C2F74643E3C746420636F6C7370616E3D27342720726F777370616E3D2732273E3C703E266E6273703B3C2F703E3C703EE58F96E5BE97E79A84EFBC88E4B88AE5B297EFBC89E689A7E4B89AE8B584E6A0BC3C2F703E3C2F74643E3C746420636F6C7370616E3D2734273E3C703EE4B893E4B89AE68A80E69CAFE8818CE7A7B03C2F703E3C2F74643E3C2F74723E3C74723E3C746420636F6C7370616E3D2734273E3C703EEFBC88E7BB8FE6B58EE7B3BBE58897E38081E5B7A5E7A88BE7B3BBE58897EFBC893C2F703E3C2F74643E3C2F74723E3C74723E3C746420636F6C7370616E3D2733273E3C703EE59CA8E7BC96E4BABAE591983C2F703E3C2F74643E3C746420636F6C7370616E3D2732273E3C703EE88198E794A8E4BABAE591983C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE4B8B4E697B628E5809FE794A829E4BABAE591983C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE9AB98E4B8AD3C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE5A4A7E4B8933C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE69CACE7A7913C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE7A094E7A9B6E7949F3C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE585B6E5AE833C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE4BBB7E6A0BC3C2F703E3C703EE989B4E8AF81E591983C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE4BBB7E6A0BC3C2F703E3C703EE989B4E8AF81E5B8883C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE5A48DE6A0B83C2F703E3C703EE8A381E5AE9AE591983C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE585B6E5AE833C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE5889DE7BAA73C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE4B8ADE7BAA73C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE9AB98E7BAA73C2F703E3C2F74643E3C746420726F777370616E3D2732273E3C703EE585B6E5AE833C2F703E3C2F74643E3C2F74723E3C74723E3C74643E3C703EE69CACE58D95E4BD8D3C2F703E3C2F74643E3C746420636F6C7370616E3D2732273E3C703EE585B6E5AE833C2F703E3C2F74643E3C74643E3C703EE995BFE69C9F3C2F703E3C2F74643E3C74643E3C703EE79FADE69C9F3C2F703E3C2F74643E3C2F74723E3C74723E3C74643E3C703E41313C2F703E3C2F74643E3C74643E3C703E42313C2F703E3C2F74643E3C74643E3C703E42323C2F703E3C2F74643E3C746420636F6C7370616E3D2732273E3C703E42333C2F703E3C2F74643E3C74643E3C703E42343C2F703E3C2F74643E3C74643E3C703E42353C2F703E3C2F74643E3C74643E3C703E43313C2F703E3C2F74643E3C74643E3C703E43323C2F703E3C2F74643E3C74643E3C703E43333C2F703E3C2F74643E3C74643E3C703E43343C2F703E3C2F74643E3C74643E3C703E43353C2F703E3C2F74643E3C74643E3C703E44313C2F703E3C2F74643E3C74643E3C703E44323C2F703E3C2F74643E3C74643E3C703E44333C2F703E3C2F74643E3C74643E3C703E44343C2F703E3C2F74643E3C74643E3C703E45313C2F703E3C2F74643E3C74643E3C703E45323C2F703E3C2F74643E3C74643E3C703E45333C2F703E3C2F74643E3C74643E3C703E45343C2F703E3C2F74643E3C2F74723E3C74723E3C74643E3C703E3C696E707574206E616D653D276131272073697A653D27342720747970653D2774657874272076616C75653D27247B61313F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276231272073697A653D27342720747970653D2774657874272076616C75653D27247B62313F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276232272073697A653D27342720747970653D2774657874272076616C75653D27247B62323F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C746420636F6C7370616E3D2732273E3C703E3C696E707574206E616D653D276233272073697A653D27342720747970653D2774657874272076616C75653D27247B62333F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276234272073697A653D27342720747970653D2774657874272076616C75653D27247B62343F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276235272073697A653D27342720747970653D2774657874272076616C75653D27247B62353F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276331272073697A653D27342720747970653D2774657874272076616C75653D27247B63313F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276332272073697A653D27342720747970653D2774657874272076616C75653D27247B63323F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276333272073697A653D27342720747970653D2774657874272076616C75653D27247B63333F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276334272073697A653D27342720747970653D2774657874272076616C75653D27247B63343F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276335272073697A653D27342720747970653D2774657874272076616C75653D27247B63353F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276431272073697A653D27342720747970653D2774657874272076616C75653D27247B64313F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276432272073697A653D27342720747970653D2774657874272076616C75653D27247B64323F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276433272073697A653D27342720747970653D2774657874272076616C75653D27247B64333F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276434272073697A653D27342720747970653D2774657874272076616C75653D27247B64343F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276531272073697A653D27342720747970653D2774657874272076616C75653D27247B65313F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276532272073697A653D27342720747970653D2774657874272076616C75653D27247B65323F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276533272073697A653D27342720747970653D2774657874272076616C75653D27247B65333F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C74643E3C703E3C696E707574206E616D653D276534272073697A653D27342720747970653D2774657874272076616C75653D27247B65343F69665F6578697374733F68746D6C7D27202F3E3C2F703E3C2F74643E3C2F74723E3C74723E3C746420636F6C7370616E3D273230273E3C703E266E6273703B3C2F703E3C703EE5A1ABE68AA5E8AFB4E6988EEFBC9A3C2F703E3C703EE4B880E38081E59088E8AEA1EFBC8841EFBC89EFBC9AE5A1ABE68AA5E887B3E7BB9FE8AEA1E688AAE6ADA2E69C9FE79A84E69CACE69CBAE69E84E79A84E4BABAE59198E680BBE695B0E380823C2F703E3C703EE4BA8CE38081E4BABAE695B0EFBC9A3C2F703E3C703EE59CA8E7BC96E4BABAE59198EFBC9AE58886E588ABE68C89E785A7E4BBB7E6A0BCE8AEA4E8AF81E69CBAE69E84E7BC96E588B6E58685E58F8AE585B6E5AE83E585B7E69C89E4BBB7E6A0BCE4B8BBE7AEA1E983A8E997A8E7BC96E588B6E79A84E5AE9EE69C89E4BABAE695B0E5A1ABE68AA5E59CA84231E380814232E6A08FE58685E380823C2F703E3C703EE88198E794A8E4BABAE59198EFBC9AE68C89E785A7E7BB8FE4BBB7E6A0BCE4B8BBE7AEA1E983A8E997A8E68896E4BBB7E6A0BCE8AEA4E8AF81E69CBAE69E84E4BABAE4BA8BE983A8E997A8E8AEA4E58FAFE79A84E5B9B6E7ADBEE8AEA2E4B889E5B9B4E4BBA5E4B88AE79A84E5B7A5E4BD9CE59088E5908CE79A84E4BABAE59198EFBC884233EFBC89EFBC9BE4BBA5E58F8AE6B2A1E69C89E7BB8FE8BF87E4BBB7E6A0BCE4B8BBE7AEA1E983A8E997A8E68896E4BBB7E6A0BCE8AEA4E8AF81E69CBAE69E84E4BABAE4BA8BE983A8E997A8E8AEA4E58FAFE79A84E7ADBEE8AEA2E59088E5908CE5B091E4BA8EE4B889E5B9B4E79A84E4BABAE59198EFBC884234EFBC89E58886E588ABE69DA5E8BF9BE8A18CE7BB9FE8AEA1E380823C2F703E3C703EE4B8B4E697B6EFBC88E5809FE794A8EFBC89E4BABAE59198EFBC884235EFBC89EFBC9AE789B9E68C87E5A496E88198E79A84E4B8B4E697B6E5B7A5EFBC8CE68896E88085E5B7A5E4BD9CE585B3E7B3BBE4B88DE59CA8E69CACE58D95E4BD8DE4B894E697A0E995BFE69C9FE88198E794A8E59088E5908CE79A84E5809FE8B083E4BABAE59198E7AD89E380823C2F703E3C703EE4B889E38081E8A1A8E58685E59084E6A08FE79BAEE585B3E7B3BB3C2F703E3C703E413D42312B42322B42332B42342B42353D43312B43322B43332B43342B43353D44312B44322B44332B44343D45312B45322B45332B45343C2F703E3C2F74643E3C2F74723E3C2F74626F64793E3C2F7461626C653E3C2F666F726D3E3C2F6469763E3C2F626F64793E3C2F68746D6C3E);

-- ----------------------------
-- Table structure for ck_finder
-- ----------------------------
DROP TABLE IF EXISTS `ck_finder`;
CREATE TABLE `ck_finder` (
  `ID` varchar(32) NOT NULL,
  `ATTACHMENT` varchar(255) default NULL,
  `IMAGE` varchar(255) default NULL,
  `REMARK` longtext,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ck_finder
-- ----------------------------

-- ----------------------------
-- Table structure for doc
-- ----------------------------
DROP TABLE IF EXISTS `doc`;
CREATE TABLE `doc` (
  `ID` int(11) NOT NULL auto_increment,
  `DOCCONTENT` longblob,
  `DOCDATE` datetime default NULL,
  `DOCID` varchar(255) default NULL,
  `DOCTITLE` varchar(255) default NULL,
  `DOCTYPE` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc
-- ----------------------------

-- ----------------------------
-- Table structure for jeecg_demo
-- ----------------------------
DROP TABLE IF EXISTS `jeecg_demo`;
CREATE TABLE `jeecg_demo` (
  `ID` varchar(32) NOT NULL,
  `AGE` int(11) default NULL,
  `BIRTHDAY` datetime default NULL,
  `content` varchar(255) default NULL,
  `create_date` datetime default NULL,
  `DEP_ID` varchar(255) default NULL,
  `EMAIL` varchar(255) default NULL,
  `MOBILE_PHONE` varchar(255) default NULL,
  `OFFICE_PHONE` varchar(255) default NULL,
  `SALARY` decimal(19,2) default NULL,
  `SEX` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `USER_NAME` varchar(255) NOT NULL,
  `CREATE_TIME` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jeecg_demo
-- ----------------------------
INSERT INTO `jeecg_demo` VALUES ('402882e446efd9fd0146efda827b0161', '12', '2014-02-14 00:00:00', null, null, '123', 'demo@jeecg.com', '13111111111', '66666666', '111111.00', '1', null, '小明', null);

-- ----------------------------
-- Table structure for jeecg_demo_course
-- ----------------------------
DROP TABLE IF EXISTS `jeecg_demo_course`;
CREATE TABLE `jeecg_demo_course` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(25) default NULL,
  `teacher_ID` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_g3jn8mfod69i7jfv5gnrcvgbx` (`teacher_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jeecg_demo_course
-- ----------------------------
INSERT INTO `jeecg_demo_course` VALUES ('402882e446efd9fd0146efda8102015e', '海贼王', '402882e446efd9fd0146efda80ff015d');

-- ----------------------------
-- Table structure for jeecg_demo_student
-- ----------------------------
DROP TABLE IF EXISTS `jeecg_demo_student`;
CREATE TABLE `jeecg_demo_student` (
  `ID` varchar(32) NOT NULL,
  `BIRTHDAY` datetime default NULL,
  `NAME` varchar(32) default NULL,
  `SEX` varchar(1) default NULL,
  `COURSE_ID` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_r86q81koyocgod3cx6529hbpw` (`COURSE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jeecg_demo_student
-- ----------------------------
INSERT INTO `jeecg_demo_student` VALUES ('402882e446efd9fd0146efda8108015f', null, '卓洛', '0', '402882e446efd9fd0146efda8102015e');
INSERT INTO `jeecg_demo_student` VALUES ('402882e446efd9fd0146efda810d0160', null, '山治 ', '0', '402882e446efd9fd0146efda8102015e');

-- ----------------------------
-- Table structure for jeecg_demo_teacher
-- ----------------------------
DROP TABLE IF EXISTS `jeecg_demo_teacher`;
CREATE TABLE `jeecg_demo_teacher` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(12) default NULL,
  `pic` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jeecg_demo_teacher
-- ----------------------------
INSERT INTO `jeecg_demo_teacher` VALUES ('402882e446efd9fd0146efda80ff015d', '路飞', 'upload/Teacher/pic3345280233.PNG');

-- ----------------------------
-- Table structure for jeecg_matter_bom
-- ----------------------------
DROP TABLE IF EXISTS `jeecg_matter_bom`;
CREATE TABLE `jeecg_matter_bom` (
  `ID` varchar(32) NOT NULL,
  `address` varchar(255) default NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(21,6) NOT NULL,
  `productionDate` datetime default NULL,
  `quantity` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `unit` varchar(50) default NULL,
  `weight` varchar(50) default NULL,
  `parent_ID` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_fldfyrevj0li4hej5b2gu2q7w` (`parent_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jeecg_matter_bom
-- ----------------------------
INSERT INTO `jeecg_matter_bom` VALUES ('402882e446efd9fd0146efda828c0166', '广东深圳', '001', '电脑', '5000.000000', '2014-07-01 10:56:53', '5', '10', '台', '100', null);
INSERT INTO `jeecg_matter_bom` VALUES ('402882e446efd9fd0146efda828f0167', '上海', '001001', '主板', '800.000000', '2014-07-01 10:56:53', '6', '18', '个', '60', '402882e446efd9fd0146efda828c0166');

-- ----------------------------
-- Table structure for jeecg_minidao
-- ----------------------------
DROP TABLE IF EXISTS `jeecg_minidao`;
CREATE TABLE `jeecg_minidao` (
  `ID` varchar(32) NOT NULL,
  `AGE` int(11) default NULL,
  `BIRTHDAY` datetime default NULL,
  `CONTENT` varchar(255) default NULL,
  `CREATE_TIME` datetime default NULL,
  `DEP_ID` varchar(255) default NULL,
  `EMAIL` varchar(255) default NULL,
  `MOBILE_PHONE` varchar(255) default NULL,
  `OFFICE_PHONE` varchar(255) default NULL,
  `SALARY` decimal(19,2) default NULL,
  `SEX` int(11) default NULL,
  `STATUS` varchar(255) default NULL,
  `USER_NAME` varchar(255) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jeecg_minidao
-- ----------------------------

-- ----------------------------
-- Table structure for jeecg_order_custom
-- ----------------------------
DROP TABLE IF EXISTS `jeecg_order_custom`;
CREATE TABLE `jeecg_order_custom` (
  `ID` varchar(32) NOT NULL,
  `CREATE_DT` datetime default NULL,
  `CRTUSER` varchar(12) default NULL,
  `CRTUSER_NAME` varchar(10) default NULL,
  `DEL_DT` datetime default NULL,
  `DELFLAG` int(11) default NULL,
  `GO_ORDER_CODE` varchar(12) NOT NULL,
  `GOC_BUSS_CONTENT` varchar(33) default NULL,
  `GOC_CONTENT` varchar(66) default NULL,
  `GOC_CUS_NAME` varchar(16) default NULL,
  `GOC_IDCARD` varchar(18) default NULL,
  `GOC_PASSPORT_CODE` varchar(10) default NULL,
  `GOC_SEX` varchar(255) default NULL,
  `MODIFIER` varchar(12) default NULL,
  `MODIFIER_NAME` varchar(10) default NULL,
  `MODIFY_DT` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jeecg_order_custom
-- ----------------------------
INSERT INTO `jeecg_order_custom` VALUES ('402882e446efd9fd0146efda82890165', null, null, null, null, null, '11111AAA', null, null, '小明', null, null, '1', null, null, null);

-- ----------------------------
-- Table structure for jeecg_order_main
-- ----------------------------
DROP TABLE IF EXISTS `jeecg_order_main`;
CREATE TABLE `jeecg_order_main` (
  `ID` varchar(32) NOT NULL,
  `CREATE_DT` datetime default NULL,
  `CRTUSER` varchar(12) default NULL,
  `CRTUSER_NAME` varchar(10) default NULL,
  `DEL_DT` datetime default NULL,
  `DELFLAG` int(11) default NULL,
  `GO_ALL_PRICE` decimal(10,2) default NULL,
  `GO_CONTACT_NAME` varchar(16) default NULL,
  `GO_CONTENT` varchar(66) default NULL,
  `GO_ORDER_CODE` varchar(12) NOT NULL,
  `GO_ORDER_COUNT` int(11) default NULL,
  `GO_RETURN_PRICE` decimal(10,2) default NULL,
  `GO_TELPHONE` varchar(11) default NULL,
  `GODER_TYPE` varchar(255) default NULL,
  `MODIFIER` varchar(12) default NULL,
  `MODIFIER_NAME` varchar(10) default NULL,
  `MODIFY_DT` datetime default NULL,
  `USERTYPE` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jeecg_order_main
-- ----------------------------
INSERT INTO `jeecg_order_main` VALUES ('402882e446efd9fd0146efda82820163', null, null, null, null, null, '1111111.00', 'alex', '别放辣椒', '11111AAA', '1', '100.00', null, '1', null, null, null, '1');

-- ----------------------------
-- Table structure for jeecg_order_product
-- ----------------------------
DROP TABLE IF EXISTS `jeecg_order_product`;
CREATE TABLE `jeecg_order_product` (
  `ID` varchar(32) NOT NULL,
  `CREATE_DT` datetime default NULL,
  `CRTUSER` varchar(12) default NULL,
  `CRTUSER_NAME` varchar(10) default NULL,
  `DEL_DT` datetime default NULL,
  `DELFLAG` int(11) default NULL,
  `GO_ORDER_CODE` varchar(12) NOT NULL,
  `GOP_CONTENT` varchar(66) default NULL,
  `GOP_COUNT` int(11) default NULL,
  `GOP_ONE_PRICE` decimal(10,2) default NULL,
  `GOP_PRODUCT_NAME` varchar(33) default NULL,
  `GOP_PRODUCT_TYPE` varchar(1) NOT NULL,
  `GOP_SUM_PRICE` decimal(10,2) default NULL,
  `MODIFIER` varchar(12) default NULL,
  `MODIFIER_NAME` varchar(10) default NULL,
  `MODIFY_DT` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jeecg_order_product
-- ----------------------------
INSERT INTO `jeecg_order_product` VALUES ('402882e446efd9fd0146efda82850164', null, null, null, null, null, '11111AAA', null, '1', '100.00', '最最美味的地锅鸡', '1', '100.00', null, null, null);

-- ----------------------------
-- Table structure for jform_cgreport_head
-- ----------------------------
DROP TABLE IF EXISTS `jform_cgreport_head`;
CREATE TABLE `jform_cgreport_head` (
  `ID` varchar(36) NOT NULL,
  `CGR_SQL` longtext NOT NULL,
  `CODE` varchar(36) NOT NULL,
  `CONTENT` longtext NOT NULL,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jform_cgreport_head
-- ----------------------------

-- ----------------------------
-- Table structure for jform_cgreport_item
-- ----------------------------
DROP TABLE IF EXISTS `jform_cgreport_item`;
CREATE TABLE `jform_cgreport_item` (
  `ID` varchar(36) NOT NULL,
  `S_FLAG` varchar(2) default NULL,
  `S_MODE` varchar(10) default NULL,
  `CGRHEAD_ID` varchar(36) default NULL,
  `DICT_CODE` varchar(36) default NULL,
  `FIELD_HREF` varchar(120) default NULL,
  `FIELD_NAME` varchar(36) default NULL,
  `FIELD_TXT` longtext,
  `FIELD_TYPE` varchar(10) default NULL,
  `IS_SHOW` varchar(5) default NULL,
  `ORDER_NUM` int(11) default NULL,
  `REPLACE_VA` varchar(36) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jform_cgreport_item
-- ----------------------------

-- ----------------------------
-- Table structure for jform_order_customer
-- ----------------------------
DROP TABLE IF EXISTS `jform_order_customer`;
CREATE TABLE `jform_order_customer` (
  `id` varchar(36) NOT NULL,
  `name` varchar(32) default NULL COMMENT '客户名',
  `money` double default NULL COMMENT '单价',
  `sex` varchar(4) default NULL COMMENT '性别',
  `telphone` varchar(32) default NULL COMMENT '电话',
  `fk_id` varchar(36) NOT NULL COMMENT '外键',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jform_order_customer
-- ----------------------------

-- ----------------------------
-- Table structure for jg_person
-- ----------------------------
DROP TABLE IF EXISTS `jg_person`;
CREATE TABLE `jg_person` (
  `ID` varchar(32) NOT NULL,
  `AGE` int(11) default NULL,
  `BIRTHDAY` datetime default NULL,
  `CREATEDT` datetime default NULL,
  `NAME` varchar(255) NOT NULL,
  `SALARY` decimal(19,2) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jg_person
-- ----------------------------
INSERT INTO `jg_person` VALUES ('402882e446efd9fd0146efda827f0162', '10', '2014-07-01 10:56:53', '2014-07-01 10:56:53', '小红', '1000.00');

-- ----------------------------
-- Table structure for optimistic_locking
-- ----------------------------
DROP TABLE IF EXISTS `optimistic_locking`;
CREATE TABLE `optimistic_locking` (
  `ID` varchar(32) NOT NULL,
  `ACCOUNT` int(11) default NULL,
  `AGE` int(11) default NULL,
  `NAME` varchar(85) default NULL,
  `VER` int(11) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of optimistic_locking
-- ----------------------------

-- ----------------------------
-- Table structure for t_finance
-- ----------------------------
DROP TABLE IF EXISTS `t_finance`;
CREATE TABLE `t_finance` (
  `ID` varchar(32) NOT NULL,
  `APPROFILETYPE` varchar(255) default NULL,
  `BUYMONEY` float default NULL,
  `BUYPROJECTNO` varchar(255) default NULL,
  `BUYPROJECTORG` varchar(255) default NULL,
  `BUYUSE` varchar(255) default NULL,
  `BUYYEAR` varchar(255) default NULL,
  `CATEGORY` varchar(255) default NULL,
  `COLLECTORG` varchar(255) default NULL,
  `EXPENSEACCOUNT` varchar(255) default NULL,
  `HAPPENYEAR` int(11) default NULL,
  `MONEYAREA` varchar(255) default NULL,
  `MONEYSOURCE` varchar(255) default NULL,
  `MONEYTOTAL` float default NULL,
  `MONEYUSE` varchar(255) default NULL,
  `PAYTIME` datetime default NULL,
  `ZBWNO` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_finance
-- ----------------------------

-- ----------------------------
-- Table structure for t_finance_files
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_files`;
CREATE TABLE `t_finance_files` (
  `id` varchar(32) NOT NULL,
  `financeId` varchar(32) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_ij2p74feypwcda4n0n96pyd10` (`financeId`),
  KEY `FK_28m7vvi0cy5r5keke68b6f7rt` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_finance_files
-- ----------------------------

-- ----------------------------
-- Table structure for t_oa_announcement
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_announcement`;
CREATE TABLE `t_oa_announcement` (
  `id` varchar(36) NOT NULL,
  `title` varchar(100) NOT NULL COMMENT '标题',
  `is_on_top` varchar(50) default NULL COMMENT '是否置顶',
  `validtime` datetime NOT NULL COMMENT '生效时间',
  `invalidtime` datetime NOT NULL COMMENT '失效时间',
  `content` longtext NOT NULL COMMENT '内容',
  `executeTime` datetime default NULL COMMENT '活动时间',
  `master_dep_id` varchar(36) NOT NULL,
  `departsName` varchar(255) default NULL,
  `usersName` varchar(255) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_announcement
-- ----------------------------
INSERT INTO `t_oa_announcement` VALUES ('40288be747bf1de00147bf50db730006', '大会议室', null, '2014-08-11 17:47:22', '2014-08-14 17:47:25', 'rerewrewrewr', null, '402882e446efd9fd0146efda7ad20016', '研发室', '李博', '0');
INSERT INTO `t_oa_announcement` VALUES ('40288be747bf10b80147bf1333ed0001', '大会议室', null, '2014-08-11 16:40:05', '2014-08-13 16:40:08', 'grgrgrgrg', null, '402882e446efd9fd0146efda7ab50015', '信息部', '曾正', '0');
INSERT INTO `t_oa_announcement` VALUES ('40288be747bf1de00147bf21de1d0001', '小会议室', null, '2014-08-13 16:56:04', '2014-08-15 16:56:08', 'grrgrgrgrg', null, '402882e446efd9fd0146efda7ab50015', '信息部', '采购员', '0');

-- ----------------------------
-- Table structure for t_oa_announce_depart
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_announce_depart`;
CREATE TABLE `t_oa_announce_depart` (
  `announce_id` varchar(36) NOT NULL COMMENT '通知id',
  `depart_id` varchar(36) NOT NULL COMMENT '部门id',
  KEY `foreignkey_announce_depart_1` (`announce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_announce_depart
-- ----------------------------
INSERT INTO `t_oa_announce_depart` VALUES ('40288be747bf10b80147bf1333ed0001', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_oa_announce_depart` VALUES ('40288be747bf1de00147bf21de1d0001', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_oa_announce_depart` VALUES ('40288be747bf1de00147bf50db730006', '402882e446efd9fd0146efda7ad50017');

-- ----------------------------
-- Table structure for t_oa_announce_user
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_announce_user`;
CREATE TABLE `t_oa_announce_user` (
  `announce_id` varchar(36) NOT NULL COMMENT '通知id',
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  PRIMARY KEY  (`announce_id`,`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_announce_user
-- ----------------------------
INSERT INTO `t_oa_announce_user` VALUES ('40288be747bf10b80147bf1333ed0001', '402880e447a6c4820147a6c5b6040001');
INSERT INTO `t_oa_announce_user` VALUES ('40288be747bf1de00147bf21de1d0001', '402882e446efd9fd0146efda7bde0046');
INSERT INTO `t_oa_announce_user` VALUES ('40288be747bf1de00147bf50db730006', '402882e4477f8f0201477f926ede0006');

-- ----------------------------
-- Table structure for t_oa_conference
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_conference`;
CREATE TABLE `t_oa_conference` (
  `id` varchar(36) NOT NULL,
  `executetime` datetime NOT NULL COMMENT '会议时间',
  `content` longtext NOT NULL COMMENT '会议内容',
  `roomtype` varchar(50) NOT NULL COMMENT '会议地点',
  `master_dep_id` varchar(36) NOT NULL,
  `departsName` varchar(255) default NULL,
  `usersName` varchar(255) default NULL,
  `anno_id` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_conference
-- ----------------------------
INSERT INTO `t_oa_conference` VALUES ('40288be747bf1de00147bf21de850003', '2014-08-15 16:56:08', 'grrgrgrgrg', '2', '402882e446efd9fd0146efda7ab50015', '信息部', '采购员', '40288be747bf1de00147bf21de1d0001');
INSERT INTO `t_oa_conference` VALUES ('40288be747bf10b80147bf1334420003', '2014-08-13 16:40:08', 'grgrgrgrg', '1', '402882e446efd9fd0146efda7ab50015', '信息部', '曾正', '40288be747bf10b80147bf1333ed0001');
INSERT INTO `t_oa_conference` VALUES ('40288be747bf1de00147bf50dbd20008', '2014-08-14 17:47:25', 'rerewrewrewr', '1', '402882e446efd9fd0146efda7ad20016', '研发室', '李博', '40288be747bf1de00147bf50db730006');

-- ----------------------------
-- Table structure for t_oa_conference_depart
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_conference_depart`;
CREATE TABLE `t_oa_conference_depart` (
  `conference_id` varchar(36) NOT NULL,
  `depart_id` varchar(36) NOT NULL,
  PRIMARY KEY  (`conference_id`,`depart_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_conference_depart
-- ----------------------------
INSERT INTO `t_oa_conference_depart` VALUES ('40288be747bf03af0147bf04fa6c0003', '402882e446efd9fd0146efda7ad20016');
INSERT INTO `t_oa_conference_depart` VALUES ('40288be747bf10b80147bf1334420003', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_oa_conference_depart` VALUES ('40288be747bf1de00147bf21de850003', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_oa_conference_depart` VALUES ('40288be747bf1de00147bf50dbd20008', '402882e446efd9fd0146efda7ad50017');

-- ----------------------------
-- Table structure for t_oa_conference_user
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_conference_user`;
CREATE TABLE `t_oa_conference_user` (
  `conference_id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY  (`conference_id`,`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_conference_user
-- ----------------------------
INSERT INTO `t_oa_conference_user` VALUES ('40288be747bf03af0147bf04fa6c0003', '402882e4477f8f0201477f926ede0006');
INSERT INTO `t_oa_conference_user` VALUES ('40288be747bf10b80147bf1334420003', '402880e447a6c4820147a6c5b6040001');
INSERT INTO `t_oa_conference_user` VALUES ('40288be747bf1de00147bf21de850003', '402882e446efd9fd0146efda7bde0046');
INSERT INTO `t_oa_conference_user` VALUES ('40288be747bf1de00147bf50dbd20008', '402882e4477f8f0201477f926ede0006');

-- ----------------------------
-- Table structure for t_oa_enquipment
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_enquipment`;
CREATE TABLE `t_oa_enquipment` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '设备名称',
  `type` varchar(50) NOT NULL COMMENT '设备类型',
  `amount` double NOT NULL COMMENT '设备数量',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_enquipment
-- ----------------------------

-- ----------------------------
-- Table structure for t_oa_enquipment_type
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_enquipment_type`;
CREATE TABLE `t_oa_enquipment_type` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '类型名称',
  `unit_name` varchar(100) NOT NULL COMMENT '类型单位名',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_enquipment_type
-- ----------------------------
INSERT INTO `t_oa_enquipment_type` VALUES ('402882e446f5b61f0146f5baf1a0000c', '123123', '123123');

-- ----------------------------
-- Table structure for t_oa_schedule
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_schedule`;
CREATE TABLE `t_oa_schedule` (
  `id` varchar(36) NOT NULL,
  `address` longtext NOT NULL COMMENT '活动地点',
  `content` longtext NOT NULL COMMENT '活动内容',
  `executetime` datetime NOT NULL COMMENT '活动时间',
  `master_dep_id` varchar(36) NOT NULL,
  `departsName` varchar(255) default NULL,
  `usersName` varchar(255) default NULL,
  `anno_id` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_schedule
-- ----------------------------
INSERT INTO `t_oa_schedule` VALUES ('40288be747bf10b80147bf13348e0004', '大会议室', 'grgrgrgrg', '2014-08-13 16:40:08', '402882e446efd9fd0146efda7ab50015', '信息部', '曾正', '40288be747bf10b80147bf1333ed0001');
INSERT INTO `t_oa_schedule` VALUES ('40288be747bf1de00147bf21deae0004', '小会议室', 'grrgrgrgrg', '2014-08-15 16:56:08', '402882e446efd9fd0146efda7ab50015', '信息部', '采购员', '40288be747bf1de00147bf21de1d0001');
INSERT INTO `t_oa_schedule` VALUES ('40288be747bf1de00147bf50dbec0009', '大会议室', 'rerewrewrewr', '2014-08-14 17:47:25', '402882e446efd9fd0146efda7ad20016', '研发室', '李博', '40288be747bf1de00147bf50db730006');

-- ----------------------------
-- Table structure for t_oa_schedule_depart
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_schedule_depart`;
CREATE TABLE `t_oa_schedule_depart` (
  `schedule_id` varchar(36) NOT NULL,
  `depart_id` varchar(36) NOT NULL,
  PRIMARY KEY  (`schedule_id`,`depart_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_schedule_depart
-- ----------------------------
INSERT INTO `t_oa_schedule_depart` VALUES ('40288be747bf03af0147bf04fa840004', '402882e446efd9fd0146efda7ad20016');
INSERT INTO `t_oa_schedule_depart` VALUES ('40288be747bf10b80147bf13348e0004', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_oa_schedule_depart` VALUES ('40288be747bf1de00147bf21deae0004', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_oa_schedule_depart` VALUES ('40288be747bf1de00147bf50dbec0009', '402882e446efd9fd0146efda7ad50017');

-- ----------------------------
-- Table structure for t_oa_schedule_user
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_schedule_user`;
CREATE TABLE `t_oa_schedule_user` (
  `schedule_id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY  (`schedule_id`,`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_schedule_user
-- ----------------------------
INSERT INTO `t_oa_schedule_user` VALUES ('40288be747bf03af0147bf04fa840004', '402882e4477f8f0201477f926ede0006');
INSERT INTO `t_oa_schedule_user` VALUES ('40288be747bf10b80147bf13348e0004', '402880e447a6c4820147a6c5b6040001');
INSERT INTO `t_oa_schedule_user` VALUES ('40288be747bf1de00147bf21deae0004', '402882e446efd9fd0146efda7bde0046');
INSERT INTO `t_oa_schedule_user` VALUES ('40288be747bf1de00147bf50dbec0009', '402882e4477f8f0201477f926ede0006');

-- ----------------------------
-- Table structure for t_s_attachment
-- ----------------------------
DROP TABLE IF EXISTS `t_s_attachment`;
CREATE TABLE `t_s_attachment` (
  `ID` varchar(32) NOT NULL,
  `attachmentcontent` longblob,
  `attachmenttitle` varchar(100) default NULL,
  `businesskey` varchar(32) default NULL,
  `createdate` datetime default NULL,
  `extend` varchar(32) default NULL,
  `note` longtext,
  `realpath` varchar(100) default NULL,
  `subclassname` longtext,
  `swfpath` longtext,
  `BUSENTITYNAME` varchar(100) default NULL,
  `INFOTYPEID` varchar(32) default NULL,
  `USERID` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_mnq23hlc835n4ufgjl7nkn3bd` (`USERID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_attachment
-- ----------------------------
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7a900008', null, 'JR079839867R90000001000', null, null, 'doc', null, 'JR079839867R90000001000', null, 'upload/files/20130719201109hDr31jP1.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7a940009', null, 'JEECG平台协议', null, null, 'docx', null, 'JEECG平台协议', null, 'upload/files/20130719201156sYHjSFJj.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7a96000a', null, '分析JEECG与其他的开源项目的不足和优势', null, null, 'docx', null, '分析JEECG与其他的开源项目的不足和优势', null, 'upload/files/20130719201727ZLEX1OSf.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7a98000b', null, 'DMS-T3第三方租赁业务接口开发说明', null, null, 'docx', null, 'DMS-T3第三方租赁业务接口开发说明', null, 'upload/files/20130719201841LzcgqUek.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7a9a000c', null, 'SAP-需求说明书-金融服务公司-第三方租赁业务需求V1.7-研发', null, null, 'doc', null, 'SAP-需求说明书-金融服务公司-第三方租赁业务需求V1.7-研发', null, 'upload/files/20130719201925mkCrU47P.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7aa1000d', null, 'JEECG团队开发规范', null, null, 'txt', null, 'JEECG团队开发规范', null, 'upload/files/20130724103633fvOTwNSV.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7aa3000e', null, '第一模板', null, null, 'doc', null, '第一模板', null, 'upload/files/20130724104603pHDw4QUT.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7aa5000f', null, 'github入门使用教程', null, null, 'doc', null, 'github入门使用教程', null, 'upload/files/20130704200345EakUH3WB.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7aa80010', null, 'github入门使用教程', null, null, 'doc', null, 'github入门使用教程', null, 'upload/files/20130704200651IE8wPdZ4.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7aaa0011', null, '（张代浩）-金融服务公司机构岗位职责与任职资格设置表(根据模板填写）', null, null, 'xlsx', null, '（张代浩）-金融服务公司机构岗位职责与任职资格设置表(根据模板填写）', null, 'upload/files/20130704201022KhdRW1Gd.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7aad0012', null, 'EIM201_CN', null, null, 'pdf', null, 'EIM201_CN', null, 'upload/files/20130704201046JVAkvvOt.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7aaf0013', null, 'github入门使用教程', null, null, 'doc', null, 'github入门使用教程', null, 'upload/files/20130704201116Z8NhEK57.swf', null, null, null);
INSERT INTO `t_s_attachment` VALUES ('402882e446efd9fd0146efda7ab20014', null, 'JEECGUI标签库帮助文档v3.2', null, null, 'pdf', null, 'JEECGUI标签库帮助文档v3.2', null, 'upload/files/20130704201125DQg8hi2x.swf', null, null, null);

-- ----------------------------
-- Table structure for t_s_base_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_base_user`;
CREATE TABLE `t_s_base_user` (
  `ID` varchar(32) NOT NULL,
  `activitiSync` smallint(6) default NULL,
  `browser` varchar(20) default NULL,
  `password` varchar(100) default NULL,
  `realname` varchar(50) default NULL,
  `icon` varchar(1000) default NULL,
  `signature` blob,
  `status` smallint(6) default NULL,
  `userkey` varchar(200) default NULL,
  `username` varchar(10) NOT NULL,
  `departid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_15jh1g4iem1857546ggor42et` (`departid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_base_user
-- ----------------------------
INSERT INTO `t_s_base_user` VALUES ('402882e446efd9fd0146efda7bcc0044', '1', null, 'c44b01947c9e6e3f', '管理员', null, null, '1', null, 'admin', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_s_base_user` VALUES ('402882e4477f8f0201477f926ede0006', null, null, '6940b3510409259b', '李博', null, null, '1', null, 'libo', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_s_base_user` VALUES ('402882e446efd9fd0146efda7bde0046', '0', null, 'f2322ec2fb9f40d1', '采购员', null, null, '1', null, 'cgy', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_s_base_user` VALUES ('402882e446efd9fd0146efda7be40047', '1', null, 'a324509dc1a3089a', '采购审批员', null, null, '1', null, 'cgspy', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_s_base_user` VALUES ('402880e447a6c4820147a6c753b4000a', null, null, 'd1497867b183db8b1d1aec8a0c4276a9', '陈龙', null, null, '1', null, 'chenlong', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_s_base_user` VALUES ('402880e447a6c4820147a6c6d4c90007', null, null, '169075b8d3de4e74', '陈浩', null, null, '1', null, 'chenhao', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_s_base_user` VALUES ('402880e447a6c4820147a6c6593a0004', null, null, 'dcd000da3d282c3e', '陈迟', null, null, '1', null, 'chenchi', '402882e446efd9fd0146efda7ab50015');
INSERT INTO `t_s_base_user` VALUES ('402880e447a6c4820147a6c5b6040001', null, null, '6fd2bbc2d5878058c494fe18af395a8d', '曾正', null, null, '1', null, 'zengzheng', '402882e446efd9fd0146efda7ab50015');

-- ----------------------------
-- Table structure for t_s_config
-- ----------------------------
DROP TABLE IF EXISTS `t_s_config`;
CREATE TABLE `t_s_config` (
  `ID` varchar(32) NOT NULL,
  `code` varchar(100) default NULL,
  `content` longtext,
  `name` varchar(100) NOT NULL,
  `note` longtext,
  `userid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_m3q8r50ror4fl7fjkvd82tqgn` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_config
-- ----------------------------

-- ----------------------------
-- Table structure for t_s_demo
-- ----------------------------
DROP TABLE IF EXISTS `t_s_demo`;
CREATE TABLE `t_s_demo` (
  `ID` varchar(32) NOT NULL,
  `democode` longtext,
  `demoorder` smallint(6) default NULL,
  `demotitle` varchar(200) default NULL,
  `demourl` varchar(200) default NULL,
  `demopid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_fni8e3v88wcf2sahhlv57u4nm` (`demopid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_demo
-- ----------------------------
INSERT INTO `t_s_demo` VALUES ('402882e446efd9fd0146efda7ee400c7', '<div class=\"form\">\r\n   <label class=\"Validform_label\">\r\n     非空验证：\r\n    </label>\r\n    <input name=\"demotitle\" id=\"demotitle\" datatype=\"*\" errormsg=\"该字段不为空\">\r\n    <span class=\"Validform_checktip\"></span>\r\n   </div>\r\n   <div class=\"form\">\r\n     <label class=\"Validform_label\">\r\n     URL验证：\r\n    </label>\r\n    <input name=\"demourl\" id=\"demourl\" datatype=\"url\" errormsg=\"必须是URL\">\r\n    <span class=\"Validform_checktip\"></span>\r\n   </div>\r\n   <div class=\"form\">\r\n     <label class=\"Validform_label\">\r\n     至少选择2项：\r\n    </label>\r\n    <input name=\"shoppingsite1\" class=\"rt2\" id=\"shoppingsite21\" type=\"checkbox\" value=\"1\" datatype=\"need2\" nullmsg=\"请选择您的爱好！\" />\r\n  \r\n     阅读\r\n  \r\n    <input name=\"shoppingsite1\" class=\"rt2\" id=\"shoppingsite22\" type=\"checkbox\" value=\"2\" />\r\n    \r\n     音乐\r\n  \r\n    <input name=\"shoppingsite1\" class=\"rt2\" id=\"shoppingsite23\" type=\"checkbox\" value=\"3\" />\r\n  \r\n     运动\r\n   \r\n    <span class=\"Validform_checktip\"></span>\r\n   </div>\r\n   <div class=\"form\">\r\n     <label class=\"Validform_label\">\r\n     邮箱：\r\n    </label>\r\n    <input name=\"demoorder\" id=\"demoorder\" datatype=\"e\" errormsg=\"邮箱非法\">\r\n    <span class=\"Validform_checktip\"></span>\r\n   </div>\r\n   <div class=\"form\">\r\n     <label class=\"Validform_label\">\r\n     手机号：\r\n    </label>\r\n    <input name=\"phone\" id=\"phone\" datatype=\"m\" errormsg=\"手机号非法\">\r\n    <span class=\"Validform_checktip\"></span>\r\n   </div>\r\n   <div class=\"form\">\r\n     <label class=\"Validform_label\">\r\n     金额：\r\n    </label>\r\n    <input name=\"money\" id=\"money\" datatype=\"d\" errormsg=\"金额非法\">\r\n    <span class=\"Validform_checktip\"></span>\r\n   </div>\r\n   <div class=\"form\">\r\n     <label class=\"Validform_label\">\r\n     日期：\r\n    </label>\r\n    <input name=\"date\" id=\"date\" class=\"easyui-datebox\">\r\n    <span class=\"Validform_checktip\"></span>\r\n   </div>\r\n   <div class=\"form\">\r\n     <label class=\"Validform_label\">\r\n     时间：\r\n    </label>\r\n    <input name=\"time\" id=\"time\" class=\"easyui-datetimebox\">\r\n    <span class=\"Validform_checktip\"></span>\r\n   </div>', null, '表单验证', null, null);

-- ----------------------------
-- Table structure for t_s_depart
-- ----------------------------
DROP TABLE IF EXISTS `t_s_depart`;
CREATE TABLE `t_s_depart` (
  `ID` varchar(32) NOT NULL,
  `departname` varchar(100) NOT NULL,
  `description` longtext,
  `parentdepartid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_knnm3wb0bembwvm0il7tf6686` (`parentdepartid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_depart
-- ----------------------------
INSERT INTO `t_s_depart` VALUES ('402882e446efd9fd0146efda7ab50015', '信息部', '12', null);
INSERT INTO `t_s_depart` VALUES ('402882e446efd9fd0146efda7ad20016', '设计部', null, null);
INSERT INTO `t_s_depart` VALUES ('402882e446efd9fd0146efda7ad50017', '研发室', '研发技术难题', '402882e446efd9fd0146efda7ad20016');

-- ----------------------------
-- Table structure for t_s_document
-- ----------------------------
DROP TABLE IF EXISTS `t_s_document`;
CREATE TABLE `t_s_document` (
  `documentstate` smallint(6) default NULL,
  `documenttitle` varchar(100) default NULL,
  `pictureindex` blob,
  `showhome` smallint(6) default NULL,
  `id` varchar(32) NOT NULL,
  `typeid` varchar(32) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_qr3qlmgkflj35m5ci1xv0vvg3` (`typeid`),
  KEY `FK_f2mc12eu0umghp2i70apmtxjl` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_document
-- ----------------------------

-- ----------------------------
-- Table structure for t_s_fileno
-- ----------------------------
DROP TABLE IF EXISTS `t_s_fileno`;
CREATE TABLE `t_s_fileno` (
  `ID` varchar(32) NOT NULL,
  `filenobefore` varchar(32) default NULL,
  `filenonum` int(11) default NULL,
  `filenotype` varchar(32) default NULL,
  `filenoYear` date default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_fileno
-- ----------------------------

-- ----------------------------
-- Table structure for t_s_function
-- ----------------------------
DROP TABLE IF EXISTS `t_s_function`;
CREATE TABLE `t_s_function` (
  `ID` varchar(32) NOT NULL,
  `functioniframe` smallint(6) default NULL,
  `functionlevel` smallint(6) default NULL,
  `functionname` varchar(50) NOT NULL,
  `functionorder` varchar(255) default NULL,
  `functionurl` varchar(100) default NULL,
  `parentfunctionid` varchar(32) default NULL,
  `iconid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_brd7b3keorj8pmxcv8bpahnxp` (`parentfunctionid`),
  KEY `FK_q5tqo3v4ltsp1pehdxd59rccx` (`iconid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_function
-- ----------------------------
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7aed0018', null, '0', 'Online 开发', '1', '', null, '402882e446efd9fd0146efda7a8d0007');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7af20019', null, '0', '系统配置', '5', '', null, '402882e446efd9fd0146efda7a8a0005');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7af5001a', null, '0', '统计查询', '3', '', null, '402882e446efd9fd0146efda7a8d0007');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7af9001b', null, '0', '常用示例', '8', '', null, '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7afc001c', null, '0', '系统监控', '11', '', null, '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7aff001d', null, '1', '用户管理', '5', 'userController.do?user', '402880e5475432770147543970400001', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b03001e', null, '1', '角色管理', '6', 'roleController.do?role', '402880e5475432770147543970400001', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b07001f', null, '1', '菜单管理', '7', 'functionController.do?function', '402882e446efd9fd0146efda7af20019', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b0e0020', null, '1', '数据字典', '6', 'systemController.do?typeGroupList', '402882e446efd9fd0146efda7af20019', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b120021', null, '1', '图标管理', '18', 'iconController.do?icon', '402882e446efd9fd0146efda7af20019', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b160022', null, '1', '部门管理', '22', 'departController.do?depart', '402880e5475432770147543970400001', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b1a0023', null, '1', '地域管理', '22', 'territoryController.do?territory', '402882e446efd9fd0146efda7af20019', '402882e446efd9fd0146efda7a800001');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b1e0024', null, '1', '用户分析', '17', 'logController.do?statisticTabs&isIframe', '402882e446efd9fd0146efda7af5001a', '402882e446efd9fd0146efda7a800001');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b230025', null, '1', '表单配置', '1', 'cgFormHeadController.do?cgFormHeadList', '402882e446efd9fd0146efda7aed0018', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b270026', null, '1', '动态报表配置', '2', 'cgreportConfigHeadController.do?cgreportConfigHead', '402882e446efd9fd0146efda7aed0018', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b2c0027', null, '1', '数据监控', '11', 'dataSourceController.do?goDruid&isIframe', '402882e446efd9fd0146efda7afc001c', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b300028', null, '1', '系统日志', '21', 'logController.do?log', '402882e446efd9fd0146efda7afc001c', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b350029', null, '1', '定时任务', '21', 'timeTaskController.do?timeTask', '402882e446efd9fd0146efda7afc001c', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b3a002a', null, '1', '表单验证', '1', 'demoController.do?formTabs', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b3e002b', null, '1', 'Demo示例', '2', 'jeecgDemoController.do?jeecgDemo', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b45002c', null, '1', 'Minidao例子', '2', 'jeecgMinidaoController.do?jeecgMinidao', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b4e002d', null, '1', '单表模型', '3', 'jeecgNoteController.do?jeecgNote', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b55002e', null, '1', '一对多模型', '4', 'jeecgOrderMainController.do?jeecgOrderMain', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b5b002f', null, '1', 'Excel导入导出', '5', 'courseController.do?course', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b610030', null, '1', '上传下载', '6', 'commonController.do?listTurn&turn=system/document/filesList', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b660031', null, '1', 'JqueryFileUpload示例', '6', 'fileUploadController.do?fileUploadSample&isIframe', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b6b0032', null, '1', '无分页列表', '7', 'userNoPageController.do?user', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b710033', null, '1', 'jdbc示例', '8', 'jeecgJdbcController.do?jeecgJdbc', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b750034', null, '1', 'SQL分离', '9', 'jeecgJdbcController.do?dictParameter', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b7a0035', null, '1', '字典标签', '10', 'demoController.do?dictSelect', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b7e0036', null, '1', '表单弹出风格', '11', 'demoController.do?demoList', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b840037', null, '1', '特殊布局', '12', 'demoController.do?demoIframe', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b8a0038', null, '1', '单表例子(无Tag)', '13', 'jeecgEasyUIController.do?jeecgEasyUI', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b920039', null, '1', '一对多例子(无Tag)', '14', 'jeecgOrderMainNoTagController.do?jeecgOrderMainNoTag', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b98003a', null, '1', 'HTML编辑器', '15', 'jeecgDemoController.do?ckeditor&isIframe', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7b9f003b', null, '1', '在线word(IE)', '16', 'webOfficeController.do?webOffice', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7ba5003c', null, '1', 'WebOffice官方例子', '17', 'webOfficeController.do?webOfficeSample&isIframe', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7ba8003d', null, '1', '多附件管理', '18', 'tFinanceController.do?tFinance', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7bac003e', null, '1', 'Datagrid手工Html', '19', 'userController.do?userDemo', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7bb0003f', null, '1', '物料Bom', '20', 'jeecgMatterBomController.do?goList', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7bb40040', null, '1', '报表示例', '21', 'reportDemoController.do?studentStatisticTabs&isIframe', '402882e446efd9fd0146efda7af5001a', '402882e446efd9fd0146efda7a800001');
INSERT INTO `t_s_function` VALUES ('402882e446efd9fd0146efda7bb70041', null, '1', 'ckfinder例子', '100', 'jeecgDemoCkfinderController.do?jeecgDemoCkfinder', '402882e446efd9fd0146efda7af9001b', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446f0a2220146f0b60c970001', null, '0', '协同办公', '0', '', null, '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e446f0a2220146f0b6bbb20003', null, '1', '公告通知', '1', 'announcementController.do?announcement', '402882e446f0a2220146f0b60c970001', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402882e4477ba0ef01477ba2582c0001', null, '1', '会议管理', '3', 'conferenceController.do?conference', '402882e446f0a2220146f0b60c970001', '402882e446efd9fd0146efda7a820002');
INSERT INTO `t_s_function` VALUES ('402880e547787aab0147787dd34e0003', null, '1', '日程安排', '2', 'scheduleController.do?schedule', '402882e446f0a2220146f0b60c970001', '402882e446efd9fd0146efda7a8d0007');
INSERT INTO `t_s_function` VALUES ('402880e5475432770147543970400001', null, '0', '人事管理', '2', '', null, '402882e446efd9fd0146efda7a8a0005');

-- ----------------------------
-- Table structure for t_s_icon
-- ----------------------------
DROP TABLE IF EXISTS `t_s_icon`;
CREATE TABLE `t_s_icon` (
  `ID` varchar(32) NOT NULL,
  `extend` varchar(255) default NULL,
  `iconclas` varchar(200) default NULL,
  `content` blob,
  `name` varchar(100) NOT NULL,
  `path` longtext,
  `type` smallint(6) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_icon
-- ----------------------------
INSERT INTO `t_s_icon` VALUES ('402882e446efd9fd0146efda7a3b0000', 'png', 'back', null, '返回', 'plug-in/accordion/images/back.png', '1');
INSERT INTO `t_s_icon` VALUES ('402882e446efd9fd0146efda7a800001', 'png', 'pie', null, '饼图', 'plug-in/accordion/images/pie.png', '1');
INSERT INTO `t_s_icon` VALUES ('402882e446efd9fd0146efda7a820002', 'png', 'pictures', null, '图片', 'plug-in/accordion/images/pictures.png', '1');
INSERT INTO `t_s_icon` VALUES ('402882e446efd9fd0146efda7a840003', 'png', 'pencil', null, '笔', 'plug-in/accordion/images/pencil.png', '1');
INSERT INTO `t_s_icon` VALUES ('402882e446efd9fd0146efda7a860004', 'png', 'map', null, '地图', 'plug-in/accordion/images/map.png', '1');
INSERT INTO `t_s_icon` VALUES ('402882e446efd9fd0146efda7a8a0005', 'png', 'group_add', null, '组', 'plug-in/accordion/images/group_add.png', '1');
INSERT INTO `t_s_icon` VALUES ('402882e446efd9fd0146efda7a8b0006', 'png', 'calculator', null, '计算器', 'plug-in/accordion/images/calculator.png', '1');
INSERT INTO `t_s_icon` VALUES ('402882e446efd9fd0146efda7a8d0007', 'png', 'folder', null, '文件夹', 'plug-in/accordion/images/folder.png', '1');

-- ----------------------------
-- Table structure for t_s_log
-- ----------------------------
DROP TABLE IF EXISTS `t_s_log`;
CREATE TABLE `t_s_log` (
  `ID` varchar(32) NOT NULL,
  `broswer` varchar(100) default NULL,
  `logcontent` longtext NOT NULL,
  `loglevel` smallint(6) default NULL,
  `note` longtext,
  `operatetime` datetime NOT NULL,
  `operatetype` smallint(6) default NULL,
  `userid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_oe64k4852uylhyc5a00rfwtay` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_log
-- ----------------------------
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7ef000c8', 'Chrome', '用户: admin登录成功', '1', '169.254.200.136', '2013-04-24 16:22:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7efa00c9', 'Chrome', '用户: admin登录成功', '1', '10.10.10.1', '2013-04-24 17:12:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7efd00ca', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-10 15:37:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f0200cb', 'Chrome', '用户admin已退出', '2', '169.254.218.201', '2013-03-10 15:38:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f0500cc', 'MSIE 9.0', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-10 15:38:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f0900cd', 'MSIE 9.0', 'JeecgDemo例子: 12被删除 成功', '4', '169.254.218.201', '2013-03-10 15:39:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f0c00ce', 'MSIE 9.0', 'JeecgDemo例子: 12被删除 成功', '4', '169.254.218.201', '2013-03-10 15:39:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f1000cf', 'Chrome', 'JeecgDemo例子: 12被删除 成功', '4', '169.254.218.201', '2013-03-10 15:39:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f1300d0', 'MSIE 9.0', '权限: 单表模型被更新成功', '5', '169.254.218.201', '2013-03-10 15:39:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f1600d1', 'Chrome', '删除成功', '4', '169.254.218.201', '2013-03-10 15:39:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f1a00d2', 'MSIE 9.0', '删除成功', '4', '169.254.218.201', '2013-03-10 15:39:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f1e00d3', 'Chrome', '删除成功', '4', '169.254.218.201', '2013-03-10 15:39:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f2100d4', 'Firefox', '删除成功', '4', '169.254.218.201', '2013-03-10 15:39:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f2700d5', 'Chrome', '添加成功', '3', '169.254.218.201', '2013-03-10 15:40:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f2b00d6', 'Chrome', '更新成功', '5', '169.254.218.201', '2013-03-10 15:40:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f2f00d7', 'Chrome', 'JeecgDemo例子: 12被添加成功', '3', '169.254.218.201', '2013-03-10 15:40:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f3500d8', 'Chrome', '部门: 信息部被更新成功', '5', '169.254.218.201', '2013-03-10 15:41:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f3900d9', 'Chrome', '部门: 设计部被更新成功', '5', '169.254.218.201', '2013-03-10 15:41:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f3c00da', 'Chrome', '类型: 信息部流程被更新成功', '5', '169.254.218.201', '2013-03-10 15:46:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f4000db', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-10 15:48:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f4400dc', 'Firefox', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-21 23:23:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f4700dd', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-21 23:26:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f4b00de', 'Chrome', '权限: 一对多实例被添加成功', '3', '169.254.218.201', '2013-03-21 23:28:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f4e00df', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 08:25:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f5200e0', 'Firefox', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 09:05:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f5500e1', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 09:09:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f5a00e2', 'MSIE 8.0', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 09:28:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f5c00e3', 'Firefox', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 10:32:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f5f00e4', 'Chrome', '物品: 笔记本添加成功', '3', '169.254.218.201', '2013-03-22 10:35:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f6100e5', 'Firefox', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 10:41:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f6500e6', 'Firefox', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 16:11:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f6700e7', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 21:49:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f6a00e8', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 23:17:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f6d00e9', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-22 23:27:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f6f00ea', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-23 00:16:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f7200eb', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-23 00:22:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f7400ec', 'Firefox', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-23 00:31:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f7700ed', 'Chrome', '用户: admin登录成功', '1', '169.254.218.201', '2013-03-23 14:23:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f7900ee', 'Chrome', '流程参数: 主任审批被添加成功', '3', '169.254.218.201', '2013-03-23 15:05:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f7b00ef', 'Firefox', '业务参数: 入职申请被添加成功', '3', '169.254.218.201', '2013-03-23 15:05:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f7e00f0', 'Chrome', '权限: 入职申请被添加成功', '3', '169.254.218.201', '2013-03-23 15:12:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f8000f1', 'Firefox', '权限: 入职办理被添加成功', '3', '169.254.218.201', '2013-03-23 15:13:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f8300f2', 'Chrome', '用户: admin登录成功', '1', '10.10.10.1', '2013-05-06 15:27:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f8500f3', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 15:16:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f8800f4', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:02:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f8a00f5', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:07:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f8d00f6', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:09:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f8f00f7', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:11:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f9200f8', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:13:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f9400f9', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:16:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f9600fa', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:19:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f9900fb', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:27:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f9c00fc', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:42:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7f9f00fd', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:44:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fa200fe', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:49:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fa500ff', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:50:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fa80100', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:53:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fad0101', 'MSIE 8.0', '修改成功', '5', '192.168.197.1', '2013-07-07 16:56:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fb00102', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 16:59:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fb30103', 'MSIE 8.0', '创建成功', '3', '192.168.197.1', '2013-07-07 17:22:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fb50104', 'MSIE 8.0', '修改成功', '5', '192.168.197.1', '2013-07-07 17:26:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fb80105', 'MSIE 8.0', '删除成功', '4', '192.168.197.1', '2013-07-07 17:31:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fbb0106', 'MSIE 8.0', '修改成功', '5', '192.168.197.1', '2013-07-07 17:35:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fbe0107', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 17:46:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fc20108', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 17:55:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fc40109', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 18:08:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fc7010a', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 18:13:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fca010b', 'MSIE 8.0', '用户: admin登录成功', '1', '192.168.197.1', '2013-07-07 18:15:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fcc010c', 'MSIE 8.0', '修改成功', '5', '192.168.197.1', '2013-07-07 18:28:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fd0010d', 'MSIE 8.0', '修改成功', '5', '192.168.197.1', '2013-07-07 18:29:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fd3010e', 'MSIE 8.0', '修改成功', '5', '192.168.197.1', '2013-07-07 18:30:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fd6010f', 'MSIE 8.0', '修改成功', '5', '192.168.197.1', '2013-07-07 18:31:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fda0110', 'MSIE 8.0', '修改成功', '5', '192.168.197.1', '2013-07-07 18:31:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fde0111', 'MSIE 9.0', '物品: 555添加成功', '3', '192.168.1.103', '2013-03-20 23:03:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fe20112', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-20 23:19:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fe50113', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-21 20:09:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fe90114', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-21 20:27:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fed0115', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-21 20:44:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7fef0116', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-21 20:54:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7ff20117', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-21 21:01:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7ff50118', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-21 21:13:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7ff80119', 'MSIE 9.0', '物品: 55添加成功', '3', '192.168.1.103', '2013-03-21 21:15:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7ffb011a', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-21 21:22:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda7ffd011b', 'MSIE 9.0', '物品: 55添加成功', '3', '192.168.1.103', '2013-03-21 21:23:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda8000011c', 'MSIE 9.0', '物品: 33添加成功', '3', '192.168.1.103', '2013-03-21 21:23:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda8002011d', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-21 21:25:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda8005011e', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.103', '2013-03-21 21:27:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda8007011f', 'MSIE 9.0', '权限: 采购审批被添加成功', '3', '192.168.1.103', '2013-03-21 21:29:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda800a0120', 'MSIE 9.0', '权限: 采购审批被更新成功', '5', '192.168.1.103', '2013-03-21 21:29:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda800d0121', 'MSIE 9.0', '权限: 采购审批被更新成功', '5', '192.168.1.103', '2013-03-21 21:30:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda800f0122', 'MSIE 9.0', '用户: admin更新成功', '5', '192.168.1.103', '2013-03-21 21:31:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda80120123', 'MSIE 9.0', '流程参数: 采购审批员审批被添加成功', '3', '192.168.1.103', '2013-03-21 21:36:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda80150124', 'MSIE 9.0', '流程参数: 采购审批员审批被更新成功', '5', '192.168.1.103', '2013-03-21 21:36:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda80180125', 'MSIE 9.0', '流程参数: 采购审批员审批被更新成功', '5', '192.168.1.103', '2013-03-21 21:37:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda801b0126', 'MSIE 9.0', '流程类别: 采购审批员审批被删除 成功', '4', '192.168.1.103', '2013-03-21 21:38:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda801e0127', 'MSIE 9.0', '物品: 44添加成功', '3', '192.168.1.103', '2013-03-21 21:43:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda80220128', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.105', '2013-02-07 10:10:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda80250129', 'MSIE 9.0', '权限: 上传下载被添加成功', '3', '192.168.1.105', '2013-02-07 11:07:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda8028012a', 'MSIE 9.0', '权限: 插件演示被删除成功', '4', '192.168.1.105', '2013-02-07 11:07:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efda802b012b', 'MSIE 9.0', '用户: admin登录成功', '1', '192.168.1.105', '2013-02-07 11:07:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efd9fd0146efdaab230183', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 10:57:03', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446efdba10146efdbf6f60000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 10:58:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f085e40146f086ab340000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 14:04:55', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f088f00146f0893e8d0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 14:07:44', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f088f00146f09003800008', 'Chrome', '创建成功', '3', '192.168.2.100', '2014-07-01 14:15:08', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f088f00146f090e06a0009', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-01 14:16:04', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f092400146f0933c470000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 14:18:39', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f09ba60146f09bf9e00000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 14:28:12', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f09fb10146f0a00a180000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 14:32:38', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0a2220146f0a5a7190000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 14:38:46', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0a2220146f0b60cbf0002', 'Chrome', '权限: 协同办公被添加成功', '3', '192.168.2.100', '2014-07-01 14:56:41', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0a2220146f0b6bbb90004', 'Chrome', '权限: 公告通知被添加成功', '3', '192.168.2.100', '2014-07-01 14:57:25', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0a2220146f0b723d80007', 'Chrome', '用户admin已退出', '2', '192.168.2.100', '2014-07-01 14:57:52', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0a2220146f0b736800008', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 14:57:57', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0b8060146f0b85ff70000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 14:59:13', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0c95c0146f0c9b15d0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 15:18:08', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0dff10146f0e04ac40000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 15:42:49', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0e4c40146f0e50edf0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 15:48:01', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0e6340146f0e67f8d0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 15:49:36', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0e6340146f0e7d0720001', 'Chrome', '权限: 公告通知被更新成功', '5', '192.168.2.100', '2014-07-01 15:51:02', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f0640146f0f0b6a40000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 16:00:45', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f1c70146f0f218450000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 16:02:16', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f36f0146f0f3c4a20000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 16:04:05', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f50a0146f0f55b200000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 16:05:49', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f50a0146f0f5f0450001', 'Chrome', '权限: 公告通知被更新成功', '5', '192.168.2.100', '2014-07-01 16:06:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f50a0146f0f6fa810002', 'Chrome', '用户admin已退出', '2', '192.168.2.100', '2014-07-01 16:07:36', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f50a0146f0f70d3c0003', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-01 16:07:41', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f50a0146f142aeda0004', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-01 17:30:17', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f50a0146f142ed790005', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-01 17:30:33', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f50a0146f14446a80006', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-01 17:32:02', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f0f50a0146f145f97b0007', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-01 17:33:53', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4ac850146f4acf2e40000', 'Chrome', '用户: admin[信息部]登录成功', '1', '10.0.0.111', '2014-07-02 09:25:13', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4bd9d0146f4be9cc00000', 'Chrome', '用户: admin[信息部]登录成功', '1', '10.0.0.111', '2014-07-02 09:44:31', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4bd9d0146f4c72b680001', 'Chrome', '修改成功', '5', '10.0.0.111', '2014-07-02 09:53:51', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f4e911700000', 'Chrome', '用户: admin[信息部]登录成功', '1', '10.0.0.111', '2014-07-02 10:30:53', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f4f054ff0002', 'Chrome', '公告通知添加成功', '3', '10.0.0.111', '2014-07-02 10:38:49', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f4f244280004', 'Chrome', '公告通知添加成功', '3', '10.0.0.111', '2014-07-02 10:40:56', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5094c1f0009', 'Chrome', '创建成功', '3', '10.0.0.111', '2014-07-02 11:06:05', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f50f495e000f', 'Chrome', '创建成功', '3', '10.0.0.111', '2014-07-02 11:12:38', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f510c5920010', 'Chrome', '修改成功', '5', '10.0.0.111', '2014-07-02 11:14:15', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5110bb20011', 'Chrome', '修改成功', '5', '10.0.0.111', '2014-07-02 11:14:33', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f512193a0012', 'Chrome', '移除成功', '4', '10.0.0.111', '2014-07-02 11:15:42', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5130a070018', 'Chrome', '修改成功', '5', '10.0.0.111', '2014-07-02 11:16:44', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f513dd7d0019', 'Chrome', '修改成功', '5', '10.0.0.111', '2014-07-02 11:17:38', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5a6b0b4001a', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-02 13:58:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5ab16b2001b', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-02 14:02:48', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5ac6266001c', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-02 14:04:13', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5aceb5c001d', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-02 14:04:48', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5ad0da6001e', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-02 14:04:57', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5ad580c001f', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-02 14:05:16', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5adc7360020', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-02 14:05:45', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080ef46f4e8a50146f5aef5840021', 'Chrome', '修改成功', '5', '192.168.2.100', '2014-07-02 14:07:02', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5b61f0146f5b684b10000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-02 14:15:17', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5b61f0146f5b86f650002', 'Chrome', '权限: 办公设备被添加成功', '3', '192.168.2.100', '2014-07-02 14:17:23', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5b61f0146f5b92e620004', 'Chrome', '权限: 办公设备类型被添加成功', '3', '192.168.2.100', '2014-07-02 14:18:12', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5b61f0146f5b995a70007', 'Chrome', '用户admin已退出', '2', '192.168.2.100', '2014-07-02 14:18:38', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5b61f0146f5b9a82f0008', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-02 14:18:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5b61f0146f5bac422000a', 'Chrome', '设备类型添加成功', '3', '192.168.2.100', '2014-07-02 14:19:56', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5b61f0146f5bad31b000b', 'Chrome', '设备类型删除成功', '4', '192.168.2.100', '2014-07-02 14:20:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5b61f0146f5baf1a4000d', 'Chrome', '设备类型添加成功', '3', '192.168.2.100', '2014-07-02 14:20:07', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5f5670146f5f74ca80000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-02 15:26:03', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e446f5f5670146f65eeb220001', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-02 17:19:14', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('297e1abe46fb50520146fb51d3790000', 'Chrome', '用户: admin[信息部]登录成功', '1', '169.254.154.62', '2014-07-03 16:23:02', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('297e1abe46fb50520146fb83cad10001', 'Chrome', '用户: admin[信息部]登录成功', '1', '169.254.154.62', '2014-07-03 17:17:36', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('297e1abe46ffee670146ffeefda20000', 'Chrome', '用户: admin[信息部]登录成功', '1', '169.254.154.62', '2014-07-04 13:53:11', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('297e1abe46fff6c80146fff715b20000', 'Chrome', '用户: admin[信息部]登录成功', '1', '169.254.154.62', '2014-07-04 14:02:01', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080f34700468e01470046dd4b0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '10.0.0.115', '2014-07-04 15:29:09', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080f34700468e0147004869e30003', 'Chrome', '公告通知添加成功', '3', '10.0.0.115', '2014-07-04 15:30:51', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080f347004ad30147004ca0bc0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-04 15:35:27', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('8a8080f347004ad30147004d0bfc0001', 'Chrome', '公告通知删除成功', '4', '192.168.2.100', '2014-07-04 15:35:55', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e447004fc701470050124f0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-04 15:39:13', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470057b101470059f4d00000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-04 15:50:01', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470079f10147007a59420000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-04 16:25:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470079f10147007c2d1c0002', 'Chrome', '公告通知添加成功', '3', '192.168.2.100', '2014-07-04 16:27:23', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470079f10147007ea0a90004', 'Chrome', '公告通知添加成功', '3', '192.168.2.100', '2014-07-04 16:30:04', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470079f10147007f66ea0006', 'Chrome', '公告通知添加成功', '3', '192.168.2.100', '2014-07-04 16:30:55', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470081cf0147008264aa0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-04 16:34:11', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470081cf0147008296590002', 'Chrome', '公告通知更新成功', '5', '192.168.2.100', '2014-07-04 16:34:23', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470081cf0147008343140004', 'Chrome', '公告通知更新成功', '5', '192.168.2.100', '2014-07-04 16:35:08', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e44700854b01470085a1bc0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-04 16:37:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e44700854b01470085e80e0001', 'Chrome', '公告通知更新成功', '5', '192.168.2.100', '2014-07-04 16:38:01', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e44700854b014700860d610002', 'Chrome', '公告通知删除成功', '4', '192.168.2.100', '2014-07-04 16:38:11', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e44700854b01470086158a0003', 'Chrome', '公告通知删除成功', '4', '192.168.2.100', '2014-07-04 16:38:13', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470087d701470088255d0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-04 16:40:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470087d701470088b25c0001', 'Chrome', '公告通知更新成功', '5', '192.168.2.100', '2014-07-04 16:41:04', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470087d70147008902680002', 'Chrome', '公告通知更新成功', '5', '192.168.2.100', '2014-07-04 16:41:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e447009cdc0147009d23f00000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-04 17:03:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e447009cdc014700a5888e0001', 'Chrome', '公告通知更新成功', '5', '192.168.2.100', '2014-07-04 17:12:34', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e447009cdc014700a5ae7a0002', 'Chrome', '公告通知更新成功', '5', '192.168.2.100', '2014-07-04 17:12:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e447009cdc014700b7c3ac0003', 'Chrome', '公告通知更新成功', '5', '192.168.2.100', '2014-07-04 17:32:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e447009cdc014707150c6f0004', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.1.108', '2014-07-05 23:12:05', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470e769201470e7774a80000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-07 09:36:55', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470e769201470e8176bc0001', 'MSIE 9.0', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-07 09:47:51', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470e769201470e84648c0002', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-07 09:51:03', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4470e769201470e8ecab70003', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-07 10:02:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e447100d0c0147100eadd40000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-07 17:01:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e447100d0c01471486e5a30001', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-08 13:51:30', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147543738850000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-20 22:40:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147543970490002', 'Chrome', '权限: 人事管理被添加成功', '3', '192.168.0.101', '2014-07-20 22:42:36', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147543adfc80003', 'Chrome', '权限: 角色管理被更新成功', '5', '192.168.0.101', '2014-07-20 22:44:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147543c09140004', 'Chrome', '权限: 用户管理被更新成功', '5', '192.168.0.101', '2014-07-20 22:45:26', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147543c32f60005', 'Chrome', '权限: 部门管理被更新成功', '5', '192.168.0.101', '2014-07-20 22:45:37', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147543ca14e0006', 'Chrome', '权限: 系统配置被更新成功', '5', '192.168.0.101', '2014-07-20 22:46:05', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147543d7e180008', 'Chrome', '用户admin已退出', '2', '192.168.0.101', '2014-07-20 22:47:01', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147543d9ba20009', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-20 22:47:09', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547543277014754431620000b', 'Chrome', '用户: scott更新成功', '5', '192.168.0.101', '2014-07-20 22:53:08', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547543277014754432eb4000c', 'Chrome', '角色: 普通用户被删除成功', '4', '192.168.0.101', '2014-07-20 22:53:14', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e54754327701475444296b000d', 'Chrome', '用户admin已退出', '2', '192.168.0.101', '2014-07-20 22:54:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147544448ac000e', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-20 22:54:26', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547543277014754463174000f', 'Chrome', '用户admin已退出', '2', '192.168.0.101', '2014-07-20 22:56:32', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e54754327701475448d3c70010', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-20 22:59:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147544b59630011', 'Chrome', '用户admin已退出', '2', '192.168.0.101', '2014-07-20 23:02:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5475432770147544b8b7d0012', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-20 23:02:22', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e747731ebc0147732047c60000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.103', '2014-07-26 22:43:21', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e747731ebc0147733a0c7f0004', 'Chrome', '用户admin已退出', '2', '192.168.0.103', '2014-07-26 23:11:29', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e747731ebc0147733a352f0005', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.103', '2014-07-26 23:11:40', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e747731ebc0147733a9eec0006', 'Chrome', '修改成功', '5', '192.168.0.103', '2014-07-26 23:12:07', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e74773448a01477344e1da0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.103', '2014-07-26 23:23:19', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477349520147734ffe5a0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.103', '2014-07-26 23:35:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e747734952014778156ac80002', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-27 21:49:35', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477349520147781c5d9a0008', 'Chrome', '公告通知添加成功', '3', '192.168.0.101', '2014-07-27 21:57:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477349520147782307580021', 'Chrome', '用户admin已退出', '2', '192.168.0.101', '2014-07-27 22:04:27', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477349520147782325ee0022', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-27 22:04:35', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477349520147782d27540023', 'Chrome', '公告通知更新成功', '5', '192.168.0.101', '2014-07-27 22:15:30', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e747734952014778442a290025', 'Chrome', '公告通知添加成功', '3', '192.168.0.101', '2014-07-27 22:40:38', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e747734952014778452aea0027', 'Chrome', '公告通知添加成功', '3', '192.168.0.101', '2014-07-27 22:41:44', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477349520147784542190028', 'Chrome', '公告通知更新成功', '5', '192.168.0.101', '2014-07-27 22:41:50', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477349520147784593d60029', 'Chrome', '公告通知更新成功', '5', '192.168.0.101', '2014-07-27 22:42:11', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e74773495201477845bc04002a', 'Chrome', '公告通知更新成功', '5', '192.168.0.101', '2014-07-27 22:42:21', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477349520147785aa64d0030', 'Chrome', '创建成功', '3', '192.168.0.101', '2014-07-27 23:05:12', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547787aab0147787b287a0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-27 23:40:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547787aab0147787cb5cc0001', 'Chrome', '权限: 办公设备被删除成功', '4', '192.168.0.101', '2014-07-27 23:42:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547787aab0147787cccfd0002', 'Chrome', '权限: 办公设备类型被删除成功', '4', '192.168.0.101', '2014-07-27 23:42:30', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547787aab0147787dd35f0004', 'Chrome', '权限: 日程安排被添加成功', '3', '192.168.0.101', '2014-07-27 23:43:37', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547787aab0147787e6b9c0006', 'Chrome', '用户admin已退出', '2', '192.168.0.101', '2014-07-27 23:44:16', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547787aab0147787e98df0007', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-27 23:44:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5477884bf0147788546460000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-27 23:51:45', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5477895b3014778965d6a0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-28 00:10:26', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5477895b3014778970c870001', 'Chrome', '权限: 日程安排被更新成功', '5', '192.168.0.101', '2014-07-28 00:11:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5477895b30147789755c60002', 'Chrome', '用户admin已退出', '2', '192.168.0.101', '2014-07-28 00:11:29', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e5477895b30147789770f80003', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-28 00:11:36', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547789abe0147789b3bf80000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-28 00:15:45', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e547789d6c0147789de9400000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-28 00:18:40', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e54778a287014778a31dd90000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.101', '2014-07-28 00:24:21', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477a795601477a79f95c0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 08:58:39', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477a7e5601477a80062a0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 09:05:16', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477a826a01477a830ddf0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 09:08:34', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477a919a01477a91ee180000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 09:24:49', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ac98401477adc665b0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 10:46:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ae19e01477ae244fe0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 10:52:34', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ae19e01477ae369160002', 'Chrome', '日程安排添加成功', '3', '192.168.2.100', '2014-07-28 10:53:49', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ae93e01477ae9b0da0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 11:00:41', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ae93e01477aed291b0001', 'Chrome', '日程安排更新成功', '5', '192.168.2.100', '2014-07-28 11:04:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ae93e01477aed45ab0002', 'Chrome', '日程安排更新成功', '5', '192.168.2.100', '2014-07-28 11:04:36', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ae93e01477aee84a90003', 'Chrome', '部门: 研发室被更新成功', '5', '192.168.2.100', '2014-07-28 11:05:57', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ae93e01477aeecd690004', 'Chrome', '部门: 研发室被更新成功', '5', '192.168.2.100', '2014-07-28 11:06:16', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477b800f01477b81f4ec0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 13:47:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477b800f01477b893e1b0002', 'Chrome', '类型分组: 会议室类型被添加成功', '3', '192.168.2.100', '2014-07-28 13:54:57', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477b800f01477b898a860004', 'Chrome', '类型: 大会议室被添加成功', '3', '192.168.2.100', '2014-07-28 13:55:17', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477b800f01477b89b5650006', 'Chrome', '类型: 小会议室被添加成功', '3', '192.168.2.100', '2014-07-28 13:55:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477b800f01477b8df1530007', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 14:00:05', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477b800f01477b8ed9ad000d', 'Chrome', '创建成功', '3', '192.168.2.100', '2014-07-28 14:01:05', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ba0ef01477ba157500000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 14:21:17', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ba0ef01477ba2583e0002', 'Chrome', '权限: 会议管理被添加成功', '3', '192.168.2.100', '2014-07-28 14:22:22', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ba0ef01477ba3071a0004', 'Chrome', '用户admin已退出', '2', '192.168.2.100', '2014-07-28 14:23:07', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477ba0ef01477ba3208c0005', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 14:23:14', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477bad10480000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 14:34:05', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477bad78420002', 'Chrome', '会议管理添加成功', '3', '192.168.2.100', '2014-07-28 14:34:31', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477bada9750003', 'Chrome', '会议管理删除成功', '4', '192.168.2.100', '2014-07-28 14:34:44', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477baded5f0005', 'Chrome', '会议管理添加成功', '3', '192.168.2.100', '2014-07-28 14:35:01', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477bae29bd0006', 'Chrome', '会议管理更新成功', '5', '192.168.2.100', '2014-07-28 14:35:17', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477bfe89f30007', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-28 16:03:04', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477bff010a0009', 'Chrome', '会议管理添加成功', '3', '192.168.2.100', '2014-07-28 16:03:35', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477d4bddb6000a', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.103', '2014-07-28 22:07:09', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477d4ccc52000b', 'Chrome', '会议管理更新成功', '5', '192.168.0.103', '2014-07-28 22:08:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477d701a4f000c', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.103', '2014-07-28 22:46:44', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477d70b6fe000e', 'Chrome', '会议管理添加成功', '3', '192.168.0.103', '2014-07-28 22:47:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477d9bccff0010', 'Chrome', '会议管理添加成功', '3', '192.168.0.103', '2014-07-28 23:34:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477da3d00c0011', 'Chrome', '公告通知更新成功', '5', '192.168.0.103', '2014-07-28 23:43:13', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477da478310012', 'Chrome', '公告通知更新成功', '5', '192.168.0.103', '2014-07-28 23:43:56', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477da79c740013', 'Chrome', '公告通知更新成功', '5', '192.168.0.103', '2014-07-28 23:47:22', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477da8f2c50014', 'Chrome', '公告通知删除成功', '4', '192.168.0.103', '2014-07-28 23:48:49', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477da8f2f00015', 'Chrome', '公告通知删除成功', '4', '192.168.0.103', '2014-07-28 23:48:50', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477da977c90017', 'Chrome', '公告通知添加成功', '3', '192.168.0.103', '2014-07-28 23:49:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477daa15620018', 'Chrome', '公告通知删除成功', '4', '192.168.0.103', '2014-07-28 23:50:04', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477bacae01477dab1cce001a', 'Chrome', '公告通知添加成功', '3', '192.168.0.103', '2014-07-28 23:51:11', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477dbce501477dbd37da0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.103', '2014-07-29 00:10:58', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477dbce501477dbe0ec90002', 'Chrome', '公告通知添加成功', '3', '192.168.0.103', '2014-07-29 00:11:53', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477dbce501477dc2e51a0003', 'Chrome', '会议管理删除成功', '4', '192.168.0.103', '2014-07-29 00:17:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477dbce501477dc2e5270004', 'Chrome', '会议管理删除成功', '4', '192.168.0.103', '2014-07-29 00:17:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477dbce501477dc2e5360005', 'Chrome', '会议管理删除成功', '4', '192.168.0.103', '2014-07-29 00:17:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477dbce501477dc2e5460006', 'Chrome', '会议管理删除成功', '4', '192.168.0.103', '2014-07-29 00:17:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477dbce501477dc32e750008', 'Chrome', '会议管理添加成功', '3', '192.168.0.103', '2014-07-29 00:17:29', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e7477dbce501477dc38e500009', 'Chrome', '会议管理更新成功', '5', '192.168.0.103', '2014-07-29 00:17:53', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477f8f0201477f8fcea90000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-29 08:40:36', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477f8f0201477f906daf0001', 'Chrome', '用户admin已退出', '2', '192.168.2.100', '2014-07-29 08:41:17', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477f8f0201477f9089310002', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.2.100', '2014-07-29 08:41:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477f8f0201477f9118130003', 'Chrome', '用户：scott删除成功', '4', '192.168.2.100', '2014-07-29 08:42:01', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477f8f0201477f91bb760005', 'Chrome', '角色: 普通用户被添加成功', '3', '192.168.2.100', '2014-07-29 08:42:42', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402882e4477f8f0201477f926ef10008', 'Chrome', '用户: libo添加成功', '3', '192.168.2.100', '2014-07-29 08:43:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e847923099014792316d480000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.0.104', '2014-08-01 23:30:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e8479230990147923227fc0002', 'Firefox', '日程安排添加成功', '3', '192.168.0.104', '2014-08-01 23:31:06', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e84792309901479232ab6b0004', 'Firefox', '日程安排添加成功', '3', '192.168.0.104', '2014-08-01 23:31:40', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e847923bc20147923cc3680000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.0.104', '2014-08-01 23:42:41', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e847923bc20147923fa1900001', 'Firefox', '日程安排更新成功', '5', '192.168.0.104', '2014-08-01 23:45:49', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e847924ca70147924d724c0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.0.104', '2014-08-02 00:00:54', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e847924ca70147924dced10002', 'Firefox', '日程安排添加成功', '3', '192.168.0.104', '2014-08-02 00:01:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880ea479bfde401479c12ba690000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.0.106', '2014-08-03 21:32:58', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880ea479c290301479c29e9420000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.0.106', '2014-08-03 21:58:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a627bb0147a634b3010000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.100', '2014-08-05 20:46:17', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a63f6b0147a6410e860000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.100', '2014-08-05 20:59:47', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a63f6b0147a641fa000003', 'Chrome', '用户: test添加成功', '3', '192.168.0.100', '2014-08-05 21:00:47', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a63f6b0147a6454e160005', 'Chrome', '图标: test被删除成功。', '4', '192.168.0.100', '2014-08-05 21:04:25', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a66d420147a66da10f0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.100', '2014-08-05 21:48:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a673060147a673dd600000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.100', '2014-08-05 21:55:16', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a6b2b00147a6b330020000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.100', '2014-08-05 23:04:26', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a6c4820147a6c4f8420000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.100', '2014-08-05 23:23:52', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a6c4820147a6c5b6270003', 'Chrome', '用户: zengzheng添加成功', '3', '192.168.0.100', '2014-08-05 23:24:40', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a6c4820147a6c659460006', 'Chrome', '用户: chenchi添加成功', '3', '192.168.0.100', '2014-08-05 23:25:22', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a6c4820147a6c6d4d40009', 'Chrome', '用户: chenhao添加成功', '3', '192.168.0.100', '2014-08-05 23:25:54', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e447a6c4820147a6c753c2000c', 'Chrome', '用户: chenlong添加成功', '3', '192.168.0.100', '2014-08-05 23:26:26', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e647abe7700147abe957c50000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.102', '2014-08-06 23:21:42', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e647abe7700147abe9f4150002', 'Chrome', '用户: libo更新成功', '5', '192.168.0.102', '2014-08-06 23:22:22', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e647ac278c0147ac287d8a0000', 'Chrome', '用户: admin[信息部]登录成功', '1', '192.168.0.102', '2014-08-07 00:30:40', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('402880e647ac278c0147ac2925e60002', 'Chrome', '公告通知添加成功', '3', '192.168.0.102', '2014-08-07 00:31:23', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b977fb0147b9792b5e0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 14:33:51', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b97c800147b98020e60000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 14:41:27', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b999610147b999c4370000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 15:09:27', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b99a8a0147b99ad9fc0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 15:10:39', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288ce447b99e840147b99fcd240000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 15:16:03', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9ab290147b9ab94ac0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 15:28:55', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9ab290147b9ad74f80003', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 15:30:58', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9af500147b9afb9cb0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 15:33:27', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9af500147b9b380be0002', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 15:37:34', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9ba5c0147b9baf5c40000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 15:45:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9bd870147b9bde6750000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 15:48:56', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9bd870147b9be40e70002', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 15:49:19', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9c19e0147b9c1ec480000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 15:53:19', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9d4050147b9d51d650000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 16:14:17', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9d4050147b9d5fd170002', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 16:15:14', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9d4050147b9e503030003', 'Firefox', '会议管理删除成功', '4', '192.168.11.106', '2014-08-09 16:31:39', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9d4050147b9e511b90004', 'Firefox', '会议管理删除成功', '4', '192.168.11.106', '2014-08-09 16:31:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9d4050147b9e511d80005', 'Firefox', '会议管理删除成功', '4', '192.168.11.106', '2014-08-09 16:31:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9d4050147b9e552990007', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 16:31:59', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9e93a0147b9e9b44f0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 16:36:46', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9e93a0147b9ea9ee80002', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 16:37:46', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9f2c00147b9f321540000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 16:47:04', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47b9f2c00147b9f3788f0002', 'Firefox', '日程安排添加成功', '3', '192.168.11.106', '2014-08-09 16:47:26', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba12660147ba1394b50000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 17:22:31', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba12660147ba13fe980001', 'Firefox', '会议管理删除成功', '4', '192.168.11.106', '2014-08-09 17:22:58', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba12660147ba13feaf0002', 'Firefox', '会议管理删除成功', '4', '192.168.11.106', '2014-08-09 17:22:58', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba12660147ba146a860004', 'Firefox', '会议管理添加成功', '3', '192.168.12.100', '2014-08-09 17:23:25', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba12660147ba1626c10006', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 17:25:19', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba12660147ba1be98e0008', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 17:31:37', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba1d1c0147ba1dd74b0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 17:33:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba1d1c0147ba1e282b0002', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 17:34:04', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba1d1c0147ba1fb0ed0004', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 17:35:44', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba21cd0147ba23b8bc0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 17:40:09', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba21cd0147ba2403540002', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 17:40:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba21cd0147ba2619f50004', 'Firefox', '日程安排添加成功', '3', '192.168.11.106', '2014-08-09 17:42:44', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba27740147ba27e8e30000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 17:44:43', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba27740147ba284a6d0002', 'Firefox', '公告通知添加成功', '3', '192.168.11.106', '2014-08-09 17:45:08', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba27740147ba289a3b0003', 'Firefox', '公告通知删除成功', '4', '192.168.11.106', '2014-08-09 17:45:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba27740147ba2912c80005', 'Firefox', '公告通知添加成功', '3', '192.168.11.106', '2014-08-09 17:45:59', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba27740147ba37bddd0006', 'Firefox', '图标: test被删除成功。', '4', '192.168.11.106', '2014-08-09 18:02:01', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba27740147ba3f9e460008', 'Firefox', '公告通知添加成功', '3', '192.168.11.106', '2014-08-09 18:10:37', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba27740147ba401368000a', 'Firefox', '公告通知添加成功', '3', '192.168.11.106', '2014-08-09 18:11:07', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47ba27740147ba4092a1000c', 'Firefox', '公告通知添加成功', '3', '192.168.11.106', '2014-08-09 18:11:39', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47baaa710147baab0cc40000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 20:07:57', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47baaa710147baedd6ff0001', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 21:20:55', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47baf7620147baf8c4b90000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 21:32:51', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bafa3a0147bafa97f30000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 21:34:50', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb05040147bb06d1230000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 21:48:11', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb09a00147bb0a91bb0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 21:52:17', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb09a00147bb0b64840003', 'Firefox', '公告通知添加成功', '3', '192.168.11.106', '2014-08-09 21:53:11', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb182a0147bb18b7550000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 22:07:44', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb182a0147bb1afb3e0002', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 22:10:13', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb182a0147bb1c89ef0004', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 22:11:55', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb1e8a0147bb1ec9d00000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 22:14:22', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb1e8a0147bb1ef9c30001', 'Firefox', '会议管理删除成功', '4', '192.168.11.106', '2014-08-09 22:14:35', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb1e8a0147bb1ef9e00002', 'Firefox', '会议管理删除成功', '4', '192.168.11.106', '2014-08-09 22:14:35', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb1e8a0147bb1f5ce70004', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 22:15:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb1e8a0147bb2185300006', 'Firefox', '会议管理添加成功', '3', '192.168.11.106', '2014-08-09 22:17:21', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb538c5f0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 23:12:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb54ad8e0002', 'Firefox', '公告通知添加成功', '3', '192.168.11.106', '2014-08-09 23:13:14', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb5560d60004', 'Firefox', '公告通知添加成功', '3', '192.168.11.106', '2014-08-09 23:14:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb6d266b0005', 'Firefox', '公告通知删除成功', '4', '192.168.11.106', '2014-08-09 23:39:58', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb6d735e0006', 'Firefox', '公告通知更新成功', '5', '192.168.11.106', '2014-08-09 23:40:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb6dc76a0007', 'Firefox', '公告通知更新成功', '5', '192.168.11.106', '2014-08-09 23:40:39', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb74b3da0008', 'Firefox', '会议管理更新成功', '5', '192.168.11.106', '2014-08-09 23:48:13', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb75ef1d0009', 'Firefox', '会议管理更新成功', '5', '192.168.11.106', '2014-08-09 23:49:34', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb76ab4a000a', 'Firefox', '会议管理更新成功', '5', '192.168.11.106', '2014-08-09 23:50:22', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb778ed5000b', 'Firefox', '会议管理更新成功', '5', '192.168.11.106', '2014-08-09 23:51:20', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb52d40147bb78cf3f000c', 'Firefox', '会议管理更新成功', '5', '192.168.11.106', '2014-08-09 23:52:42', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb7a1d0147bb7a9dcf0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.106', '2014-08-09 23:54:40', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb7a1d0147bb7b26ed0001', 'Firefox', '会议管理更新成功', '5', '192.168.11.106', '2014-08-09 23:55:16', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb7d2f0147bb7e19750000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.12.100', '2014-08-09 23:58:29', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb7d2f0147bb7eae750002', 'Firefox', '日程安排添加成功', '3', '192.168.11.106', '2014-08-09 23:59:07', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb7d2f0147bb7ed9810003', 'Firefox', '日程安排更新成功', '5', '192.168.11.106', '2014-08-09 23:59:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288bea47bb7d2f0147bb7efb190004', 'Firefox', '日程安排更新成功', '5', '192.168.11.106', '2014-08-09 23:59:27', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288ce647bdef5b0147bdefd1bf0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.12.102', '2014-08-10 11:21:56', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be6815c20000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.103', '2014-08-10 13:33:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be686ca70002', 'Firefox', '类型分组: 公告类型被添加成功', '3', '192.168.11.103', '2014-08-10 13:33:40', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be68a1fc0004', 'Firefox', '类型: 0被添加成功', '3', '192.168.11.103', '2014-08-10 13:33:54', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be694e070006', 'Firefox', '类型: 1被添加成功', '3', '192.168.11.103', '2014-08-10 13:34:38', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be697ea40007', 'Firefox', '类型: 0被更新成功', '5', '192.168.11.103', '2014-08-10 13:34:50', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be6ce1970008', 'Firefox', '类型: 会议通知被更新成功', '5', '192.168.11.103', '2014-08-10 13:38:32', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be6d06140009', 'Firefox', '类型: 公告通知被更新成功', '5', '192.168.11.103', '2014-08-10 13:38:41', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be6e85ef000b', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:40:20', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be6ea82d000c', 'Firefox', '公告通知更新成功', '5', '192.168.11.103', '2014-08-10 13:40:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be6f357f000d', 'Firefox', '公告通知更新成功', '5', '192.168.11.103', '2014-08-10 13:41:05', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be797dc0000f', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:52:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7a27140011', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:53:02', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7ab2da0013', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:53:38', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7b51160015', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:54:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7c172b0017', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:55:09', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7c617e0018', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 13:55:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7c61ad0019', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 13:55:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7c61d5001a', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 13:55:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7c61ff001b', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 13:55:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7c6229001c', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 13:55:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7c625d001d', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 13:55:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7c6284001e', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 13:55:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7c62ba001f', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 13:55:28', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7cd9fa0021', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:55:59', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7e41900023', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:57:31', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be7f3f600025', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:58:36', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be8040db0027', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 13:59:42', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be90c8d20029', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 14:17:45', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be912a24002a', 'Firefox', '会议管理删除成功', '4', '192.168.11.103', '2014-08-10 14:18:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be912a47002b', 'Firefox', '会议管理删除成功', '4', '192.168.11.103', '2014-08-10 14:18:10', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be914e5b002c', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 14:18:19', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be914e84002d', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 14:18:19', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be914eb6002e', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 14:18:19', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be914ee0002f', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 14:18:19', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be914f090030', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 14:18:19', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be9162a80031', 'Firefox', '日程安排删除成功', '4', '192.168.11.103', '2014-08-10 14:18:24', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747be67b20147be929b940033', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 14:19:44', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747beceb90147becfa53d0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.103', '2014-08-10 15:26:25', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747beceb90147bed031510002', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 15:27:00', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bed25c0147bed2d85e0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.103', '2014-08-10 15:29:54', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bed25c0147bed2fca30001', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 15:30:04', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bed25c0147bed36ab00003', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 15:30:32', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bed25c0147bed6eec10007', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 15:34:22', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bed25c0147bed88523000b', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 15:36:06', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bed25c0147bef4d786000f', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 16:07:02', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bed25c0147bef9d4bd0012', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 16:12:29', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bed25c0147bef9d4ee0013', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 16:12:29', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bed25c0147befa35fe0015', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 16:12:54', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf03af0147bf0407010000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.103', '2014-08-10 16:23:37', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf03af0147bf04fa650002', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 16:24:40', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf07820147bf08951b0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.103', '2014-08-10 16:28:36', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf07820147bf08f5530002', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 16:29:01', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf07820147bf0938740005', 'Firefox', '公告通知删除成功', '4', '192.168.11.103', '2014-08-10 16:29:18', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf10b80147bf12cedd0000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.103', '2014-08-10 16:39:46', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf10b80147bf1334340002', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 16:40:12', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf1de00147bf209ab10000', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.103', '2014-08-10 16:54:50', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf1de00147bf21de780002', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 16:56:13', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf1de00147bf5035a10005', 'Firefox', '用户: admin[信息部]登录成功', '1', '192.168.11.103', '2014-08-10 17:46:50', '1', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_log` VALUES ('40288be747bf1de00147bf50dbcc0007', 'Firefox', '公告通知添加成功', '3', '192.168.11.103', '2014-08-10 17:47:33', '1', '402882e446efd9fd0146efda7bcc0044');

-- ----------------------------
-- Table structure for t_s_operation
-- ----------------------------
DROP TABLE IF EXISTS `t_s_operation`;
CREATE TABLE `t_s_operation` (
  `ID` varchar(32) NOT NULL,
  `operationcode` varchar(50) default NULL,
  `operationicon` varchar(100) default NULL,
  `operationname` varchar(50) default NULL,
  `status` smallint(6) default NULL,
  `functionid` varchar(32) default NULL,
  `iconid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_pceuy41wr2fjbcilyc7mk3m1f` (`functionid`),
  KEY `FK_ny5de7922l39ta2pkhyspd5f` (`iconid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_operation
-- ----------------------------
INSERT INTO `t_s_operation` VALUES ('402882e446efd9fd0146efda7cb9006a', 'add', null, '录入', null, '402882e446efd9fd0146efda7b3e002b', '402882e446efd9fd0146efda7a3b0000');
INSERT INTO `t_s_operation` VALUES ('402882e446efd9fd0146efda7cbe006b', 'edit', null, '编辑', null, '402882e446efd9fd0146efda7b3e002b', '402882e446efd9fd0146efda7a3b0000');
INSERT INTO `t_s_operation` VALUES ('402882e446efd9fd0146efda7cc2006c', 'del', null, '删除', null, '402882e446efd9fd0146efda7b3e002b', '402882e446efd9fd0146efda7a3b0000');
INSERT INTO `t_s_operation` VALUES ('402882e446efd9fd0146efda7cc7006d', 'szqm', null, '审核', null, '402882e446efd9fd0146efda7b3e002b', '402882e446efd9fd0146efda7a3b0000');

-- ----------------------------
-- Table structure for t_s_opintemplate
-- ----------------------------
DROP TABLE IF EXISTS `t_s_opintemplate`;
CREATE TABLE `t_s_opintemplate` (
  `ID` varchar(32) NOT NULL,
  `descript` varchar(100) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_opintemplate
-- ----------------------------

-- ----------------------------
-- Table structure for t_s_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role`;
CREATE TABLE `t_s_role` (
  `ID` varchar(32) NOT NULL,
  `rolecode` varchar(10) default NULL,
  `rolename` varchar(100) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_role
-- ----------------------------
INSERT INTO `t_s_role` VALUES ('402882e446efd9fd0146efda7bbc0042', 'admin', '管理员');
INSERT INTO `t_s_role` VALUES ('402882e4477f8f0201477f91bb710004', 'normaluser', '普通用户');

-- ----------------------------
-- Table structure for t_s_role_function
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role_function`;
CREATE TABLE `t_s_role_function` (
  `ID` varchar(32) NOT NULL,
  `operation` varchar(100) default NULL,
  `functionid` varchar(32) default NULL,
  `roleid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_fvsillj2cxyk5thnuu625urab` (`functionid`),
  KEY `FK_9dww3p4w8jwvlrgwhpitsbfif` (`roleid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_role_function
-- ----------------------------
INSERT INTO `t_s_role_function` VALUES ('402882e446efd9fd0146efda7ce60070', null, '402882e446efd9fd0146efda7af20019', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402882e446efd9fd0146efda7d100078', null, '402882e446efd9fd0146efda7aff001d', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402882e446efd9fd0146efda7d18007a', null, '402882e446efd9fd0146efda7b03001e', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402882e446efd9fd0146efda7d20007c', null, '402882e446efd9fd0146efda7b07001f', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402882e446efd9fd0146efda7d2a007e', null, '402882e446efd9fd0146efda7b0e0020', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402882e446efd9fd0146efda7d340080', null, '402882e446efd9fd0146efda7b120021', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402882e446efd9fd0146efda7d3f0082', null, '402882e446efd9fd0146efda7b160022', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402882e446f0a2220146f0b7051c0005', null, '402882e446f0a2220146f0b6bbb20003', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402882e446f0a2220146f0b7051f0006', null, '402882e446f0a2220146f0b60c970001', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402882e4477ba0ef01477ba29a340003', null, '402882e4477ba0ef01477ba2582c0001', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402880e547787aab0147787e3a2d0005', null, '402880e547787aab0147787dd34e0003', '402882e446efd9fd0146efda7bbc0042');
INSERT INTO `t_s_role_function` VALUES ('402880e5475432770147543d62960007', null, '402880e5475432770147543970400001', '402882e446efd9fd0146efda7bbc0042');

-- ----------------------------
-- Table structure for t_s_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role_user`;
CREATE TABLE `t_s_role_user` (
  `ID` varchar(32) NOT NULL,
  `roleid` varchar(32) default NULL,
  `userid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_n2ucxeorvpjy7qhnmuem01kbx` (`roleid`),
  KEY `FK_d4qb5xld2pfb0bkjx9iwtolda` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_role_user
-- ----------------------------
INSERT INTO `t_s_role_user` VALUES ('402882e446efd9fd0146efda7e3900c2', '402882e446efd9fd0146efda7bbc0042', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_role_user` VALUES ('402882e446efd9fd0146efda7e3e00c3', '402882e446efd9fd0146efda7bbc0042', '402882e446efd9fd0146efda7bcc0044');
INSERT INTO `t_s_role_user` VALUES ('402880e647abe7700147abe9f40f0001', '402882e4477f8f0201477f91bb710004', '402882e4477f8f0201477f926ede0006');
INSERT INTO `t_s_role_user` VALUES ('402882e446efd9fd0146efda7e4400c5', '402882e446efd9fd0146efda7bbc0042', '402882e446efd9fd0146efda7bde0046');
INSERT INTO `t_s_role_user` VALUES ('402882e446efd9fd0146efda7e4700c6', '402882e446efd9fd0146efda7bbc0042', '402882e446efd9fd0146efda7be40047');
INSERT INTO `t_s_role_user` VALUES ('402880e447a63f6b0147a641f9fa0002', '402882e4477f8f0201477f91bb710004', '402880e447a63f6b0147a641f9e80001');
INSERT INTO `t_s_role_user` VALUES ('402880e447a6c4820147a6c5b61b0002', '402882e4477f8f0201477f91bb710004', '402880e447a6c4820147a6c5b6040001');
INSERT INTO `t_s_role_user` VALUES ('402880e447a6c4820147a6c659420005', '402882e4477f8f0201477f91bb710004', '402880e447a6c4820147a6c6593a0004');
INSERT INTO `t_s_role_user` VALUES ('402880e447a6c4820147a6c6d4d00008', '402882e4477f8f0201477f91bb710004', '402880e447a6c4820147a6c6d4c90007');
INSERT INTO `t_s_role_user` VALUES ('402880e447a6c4820147a6c753bd000b', '402882e4477f8f0201477f91bb710004', '402880e447a6c4820147a6c753b4000a');

-- ----------------------------
-- Table structure for t_s_student
-- ----------------------------
DROP TABLE IF EXISTS `t_s_student`;
CREATE TABLE `t_s_student` (
  `ID` varchar(32) NOT NULL,
  `classname` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_student
-- ----------------------------
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82920168', '1班', '张三', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82950169', '1班', '李四', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda8296016a', '1班', '王五', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda8298016b', '1班', '赵六', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda829a016c', '2班', '张三', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda829c016d', '2班', '李四', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82a0016e', '2班', '王五', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82a2016f', '2班', '赵六', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82a60170', '3班', '张三', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82a90171', '3班', '李四', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82ae0172', '3班', '王五', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82b40173', '3班', '李四', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82bd0174', '3班', '王五', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82c00175', '3班', '赵六', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82c20176', '4班', '张三', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82c40177', '4班', '李四', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82c60178', '4班', '王五', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82c80179', '4班', '赵六', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82c9017a', '5班', '张三', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82cb017b', '5班', '李四', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82cc017c', '5班', '王五', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82ce017d', '5班', '赵六', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82cf017e', '5班', '赵六', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82d1017f', '5班', '李四', 'f');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82d20180', '5班', '王五', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82d30181', '5班', '赵六', 'm');
INSERT INTO `t_s_student` VALUES ('402882e446efd9fd0146efda82d50182', '5班', '赵六', 'm');

-- ----------------------------
-- Table structure for t_s_territory
-- ----------------------------
DROP TABLE IF EXISTS `t_s_territory`;
CREATE TABLE `t_s_territory` (
  `ID` varchar(32) NOT NULL,
  `territorycode` varchar(10) NOT NULL,
  `territorylevel` smallint(6) NOT NULL,
  `territoryname` varchar(50) NOT NULL,
  `territory_pinyin` varchar(40) default NULL,
  `territorysort` varchar(3) NOT NULL,
  `x_wgs84` double NOT NULL,
  `y_wgs84` double NOT NULL,
  `territoryparentid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_territory
-- ----------------------------
INSERT INTO `t_s_territory` VALUES ('1', '100', '1', '全国', 'qg', '0', '106.258754', '38.471318', '0');
INSERT INTO `t_s_territory` VALUES ('100', '371300', '3', '临沂市', 'LYS', '0', '118.356448', '35.104672', '18');
INSERT INTO `t_s_territory` VALUES ('101', '371400', '3', '德州市', 'DZS', '0', '116.357465', '37.434093', '18');
INSERT INTO `t_s_territory` VALUES ('102', '371500', '3', '聊城市', 'LCS', '0', '115.985371', '36.4567039', '18');
INSERT INTO `t_s_territory` VALUES ('103', '371600', '3', '滨州市', 'BZS', '0', '117.970703', '37.38199', '18');
INSERT INTO `t_s_territory` VALUES ('104', '371700', '3', '菏泽市', 'HZS', '0', '115.480656', '35.23375', '18');
INSERT INTO `t_s_territory` VALUES ('195', '370100', '3', '济南市', 'JNS', '0', '116.994917', '36.665282', '18');
INSERT INTO `t_s_territory` VALUES ('89', '370200', '3', '青岛市', 'QDS', '0', '120.382504', '36.06722', '18');
INSERT INTO `t_s_territory` VALUES ('90', '370300', '3', '淄博市', 'ZBS', '0', '118.055007', '36.813497', '18');
INSERT INTO `t_s_territory` VALUES ('91', '370400', '3', '枣庄市', 'ZZS', '0', '117.323725', '34.810488', '18');
INSERT INTO `t_s_territory` VALUES ('92', '370500', '3', '东营市', 'DYS', '0', '118.674767', '37.434751', '18');
INSERT INTO `t_s_territory` VALUES ('93', '370600', '3', '烟台市', 'YTS', '0', '121.447926', '37.463819', '18');
INSERT INTO `t_s_territory` VALUES ('94', '370700', '3', '潍坊市', 'WFS', '0', '119.16193', '36.706691', '18');
INSERT INTO `t_s_territory` VALUES ('95', '370800', '3', '济宁市', 'JNS', '0', '116.587099', '35.414921', '18');
INSERT INTO `t_s_territory` VALUES ('10', '00000016', '2', '河南省', 'HNS', '0', '113.687228', '34.76819', '1');
INSERT INTO `t_s_territory` VALUES ('11', '00000008', '2', '黑龙江省', 'HLJS', '0', '126.662507', '45.7421699', '1');
INSERT INTO `t_s_territory` VALUES ('12', '20000000', '2', '上海市', 'SHS', '0', '121.473704', '31.230393', '1');
INSERT INTO `t_s_territory` VALUES ('13', '00000010', '2', '江苏省', 'JSS', '0', '118.763232', '32.061707', '1');
INSERT INTO `t_s_territory` VALUES ('14', '00000011', '2', '浙江省', 'ZJS', '0', '120.153676', '30.26586', '1');
INSERT INTO `t_s_territory` VALUES ('15', '00000012', '2', '安徽省', 'AHS', '0', '117.284923', '31.861184', '1');
INSERT INTO `t_s_territory` VALUES ('16', '00000013', '2', '福建省', 'FJS', '0', '119.296506', '26.099933', '1');
INSERT INTO `t_s_territory` VALUES ('17', '00000014', '2', '江西省', 'JXS', '0', '115.909175', '28.674424', '1');
INSERT INTO `t_s_territory` VALUES ('18', '00000015', '2', '山东省', 'SDS', '0', '117.020411', '36.668627', '1');
INSERT INTO `t_s_territory` VALUES ('19', '00000017', '2', '湖北省', 'HBS', '0', '114.341921', '30.545861', '1');
INSERT INTO `t_s_territory` VALUES ('20', '00000018', '2', '湖南省', 'HNS', '0', '112.98381', '28.112444', '1');
INSERT INTO `t_s_territory` VALUES ('21', '40000000', '2', '重庆市', 'ZQS', '0', '106.551557', '29.56301', '1');
INSERT INTO `t_s_territory` VALUES ('22', '00000022', '2', '四川省', 'SCS', '0', '104.075931', '30.651652', '1');
INSERT INTO `t_s_territory` VALUES ('23', '00000019', '2', '广东省', 'GDS', '0', '113.266531', '23.132191', '1');
INSERT INTO `t_s_territory` VALUES ('24', '00000020', '2', '广西壮族自治区', 'GXZZZZQ', '0', '108.327546', '22.815478', '1');
INSERT INTO `t_s_territory` VALUES ('25', '00000021', '2', '海南省', 'HNS', '0', '110.349229', '20.017378', '1');
INSERT INTO `t_s_territory` VALUES ('26', '810000', '2', '香港特别行政区', 'XGTBXZQ', '0', '114.109497', '22.396428', '1');
INSERT INTO `t_s_territory` VALUES ('27', '820000', '2', '澳门特别行政区', 'AMTBXZQ', '0', '113.543873', '22.198745', '1');
INSERT INTO `t_s_territory` VALUES ('28', '00000023', '2', '贵州省', 'GZS', '0', '106.707116', '26.598026', '1');
INSERT INTO `t_s_territory` VALUES ('29', '00000024', '2', '云南省', 'YNS', '0', '102.709812', '25.045359', '1');
INSERT INTO `t_s_territory` VALUES ('3', '00000006', '2', '辽宁省', 'LNS', '0', '123.42944', '41.835441', '1');
INSERT INTO `t_s_territory` VALUES ('30', '00000025', '2', '西藏自治区', 'XCZZQ', '0', '91.1170059', '29.647951', '1');
INSERT INTO `t_s_territory` VALUES ('31', '00000026', '2', '陕西省', 'SXS', '0', '108.954239', '34.265472', '1');
INSERT INTO `t_s_territory` VALUES ('32', '00000027', '2', '甘肃省', 'GSS', '0', '103.826308', '36.059421', '1');
INSERT INTO `t_s_territory` VALUES ('33', '00000028', '2', '青海省', 'QHS', '0', '101.780199', '36.620901', '1');
INSERT INTO `t_s_territory` VALUES ('34', '00000029', '2', '宁夏回族自治区', 'NXHZZZQ', '0', '106.258754', '38.471318', '1');
INSERT INTO `t_s_territory` VALUES ('35', '00000030', '2', '新疆维吾尔自治区', 'XJWWEZZQ', '0', '87.6278119', '43.793028', '1');
INSERT INTO `t_s_territory` VALUES ('4', '00000007', '2', '吉林省', 'JLS', '0', '125.326065', '43.896082', '1');
INSERT INTO `t_s_territory` VALUES ('5', '10000000', '2', '北京市', 'BJS', '0', '116.407413', '39.904214', '1');
INSERT INTO `t_s_territory` VALUES ('6', '30000000', '2', '天津市', 'TJS', '0', '117.200983', '39.084158', '1');
INSERT INTO `t_s_territory` VALUES ('7', '00000003', '2', '河北省', 'HBS', '0', '114.468665', '38.037057', '1');
INSERT INTO `t_s_territory` VALUES ('8', '00000004', '2', '山西省', 'SXS', '0', '112.562569', '37.873376', '1');
INSERT INTO `t_s_territory` VALUES ('9', '00000005', '2', '内蒙古自治区', 'NMGZZQ', '0', '111.765618', '40.817498', '1');
INSERT INTO `t_s_territory` VALUES ('1000', '370903', '4', '岱岳区', 'DYQ', '0', '117.041582', '36.18799', '96');
INSERT INTO `t_s_territory` VALUES ('1001', '370921', '4', '宁阳县', 'NYX', '0', '116.805797', '35.758787', '96');
INSERT INTO `t_s_territory` VALUES ('1002', '370923', '4', '东平县', 'DPX', '0', '116.470304', '35.937102', '96');
INSERT INTO `t_s_territory` VALUES ('1003', '370982', '4', '新泰市', 'XTS', '0', '117.767953', '35.909032', '96');
INSERT INTO `t_s_territory` VALUES ('1004', '370983', '4', '肥城市', 'FCS', '0', '116.768358', '36.182571', '96');
INSERT INTO `t_s_territory` VALUES ('1005', '371002', '4', '环翠区', 'HCQ', '0', '122.123444', '37.501991', '97');
INSERT INTO `t_s_territory` VALUES ('1006', '371081', '4', '文登市', 'WDS', '0', '122.058128', '37.1939129', '97');
INSERT INTO `t_s_territory` VALUES ('1007', '371082', '4', '荣成市', 'RCS', '0', '122.486676', '37.165249', '97');
INSERT INTO `t_s_territory` VALUES ('1008', '371083', '4', '乳山市', 'RSS', '0', '121.539764', '36.919816', '97');
INSERT INTO `t_s_territory` VALUES ('1009', '371102', '4', '东港区', 'DGQ', '0', '119.462228', '35.425475', '98');
INSERT INTO `t_s_territory` VALUES ('1010', '371103', '4', '岚山区', 'LSQ', '0', '119.318813', '35.121816', '98');
INSERT INTO `t_s_territory` VALUES ('1011', '371121', '4', '五莲县', 'WLX', '0', '119.208744', '35.750095', '98');
INSERT INTO `t_s_territory` VALUES ('1012', '371122', '4', '莒县', 'JX', '0', '118.837131', '35.579868', '98');
INSERT INTO `t_s_territory` VALUES ('1013', '371202', '4', '莱城区', 'LCQ', '0', '117.659864', '36.203208', '99');
INSERT INTO `t_s_territory` VALUES ('1014', '371203', '4', '钢城区', 'GCQ', '0', '117.811355', '36.058572', '99');
INSERT INTO `t_s_territory` VALUES ('1015', '371302', '4', '兰山区', 'LSQ', '0', '118.347707', '35.051729', '100');
INSERT INTO `t_s_territory` VALUES ('1016', '371311', '4', '罗庄区', 'LZQ', '0', '118.284786', '34.996741', '100');
INSERT INTO `t_s_territory` VALUES ('1017', '371312', '4', '河东区', 'HDQ', '0', '118.402893', '35.089917', '100');
INSERT INTO `t_s_territory` VALUES ('1018', '371321', '4', '沂南县', 'YNX', '0', '118.465213', '35.549976', '100');
INSERT INTO `t_s_territory` VALUES ('1019', '371322', '4', '郯城县', 'TCX', '0', '118.367263', '34.613557', '100');
INSERT INTO `t_s_territory` VALUES ('1020', '371323', '4', '沂水县', 'YSX', '0', '118.627918', '35.79045', '100');
INSERT INTO `t_s_territory` VALUES ('1021', '371324', '4', '苍山县', 'CSX', '0', '118.07065', '34.857149', '100');
INSERT INTO `t_s_territory` VALUES ('1022', '371325', '4', '费县', 'FX', '0', '117.977868', '35.26634', '100');
INSERT INTO `t_s_territory` VALUES ('1023', '371326', '4', '平邑县', 'PYX', '0', '117.640352', '35.5059429', '100');
INSERT INTO `t_s_territory` VALUES ('1024', '371327', '4', '莒南县', 'JNX', '0', '118.835163', '35.174846', '100');
INSERT INTO `t_s_territory` VALUES ('1025', '371328', '4', '蒙阴县', 'MYX', '0', '117.945085', '35.710032', '100');
INSERT INTO `t_s_territory` VALUES ('1026', '371329', '4', '临沭县', 'LSX', '0', '118.650782', '34.919852', '100');
INSERT INTO `t_s_territory` VALUES ('1027', '371402', '4', '德城区', 'DCQ', '0', '116.299434', '37.451272', '101');
INSERT INTO `t_s_territory` VALUES ('1028', '371421', '4', '陵县', 'LX', '0', '116.576176', '37.33579', '101');
INSERT INTO `t_s_territory` VALUES ('1029', '371422', '4', '宁津县', 'NJX', '0', '116.800324', '37.652329', '101');
INSERT INTO `t_s_territory` VALUES ('1030', '371423', '4', '庆云县', 'QYX', '0', '117.385123', '37.77539', '101');
INSERT INTO `t_s_territory` VALUES ('1031', '371424', '4', '临邑县', 'LYX', '0', '116.86665', '37.189864', '101');
INSERT INTO `t_s_territory` VALUES ('1032', '371425', '4', '齐河县', 'QHX', '0', '116.758917', '36.795011', '101');
INSERT INTO `t_s_territory` VALUES ('1033', '371426', '4', '平原县', 'PYX', '0', '116.434187', '37.165419', '101');
INSERT INTO `t_s_territory` VALUES ('1034', '371427', '4', '夏津县', 'XJX', '0', '116.001726', '36.948371', '101');
INSERT INTO `t_s_territory` VALUES ('1035', '371428', '4', '武城县', 'WCX', '0', '116.069302', '37.213311', '101');
INSERT INTO `t_s_territory` VALUES ('1036', '371481', '4', '乐陵市', 'LLS', '0', '117.231935', '37.729907', '101');
INSERT INTO `t_s_territory` VALUES ('1037', '371482', '4', '禹城市', 'YCS', '0', '116.638387', '36.934259', '101');
INSERT INTO `t_s_territory` VALUES ('1038', '371502', '4', '东昌府区', 'DCFQ', '0', '115.988484', '36.434697', '102');
INSERT INTO `t_s_territory` VALUES ('1039', '371521', '4', '阳谷县', 'YGX', '0', '115.79182', '36.114392', '102');
INSERT INTO `t_s_territory` VALUES ('1040', '371522', '4', '莘县', 'SX', '0', '115.671191', '36.233599', '102');
INSERT INTO `t_s_territory` VALUES ('1041', '371523', '4', '茌平县', 'CPX', '0', '116.255282', '36.5807639', '102');
INSERT INTO `t_s_territory` VALUES ('1042', '371524', '4', '东阿县', 'DAX', '0', '116.24758', '36.334917', '102');
INSERT INTO `t_s_territory` VALUES ('1043', '371525', '4', '冠县', 'GX', '0', '115.44274', '36.484009', '102');
INSERT INTO `t_s_territory` VALUES ('1044', '371526', '4', '高唐县', 'GTX', '0', '116.231478', '36.866062', '102');
INSERT INTO `t_s_territory` VALUES ('1045', '371581', '4', '临清市', 'LQS', '0', '115.704881', '36.838277', '102');
INSERT INTO `t_s_territory` VALUES ('1046', '371602', '4', '滨城区', 'BCQ', '0', '118.019146', '37.43206', '103');
INSERT INTO `t_s_territory` VALUES ('1047', '371621', '4', '惠民县', 'HMX', '0', '117.510451', '37.489769', '103');
INSERT INTO `t_s_territory` VALUES ('1048', '371622', '4', '阳信县', 'YXX', '0', '117.578262', '37.641106', '103');
INSERT INTO `t_s_territory` VALUES ('1049', '371623', '4', '无棣县', 'WDX', '0', '117.625696', '37.770261', '103');
INSERT INTO `t_s_territory` VALUES ('1050', '371624', '4', '沾化县', 'ZHX', '0', '118.132199', '37.698281', '103');
INSERT INTO `t_s_territory` VALUES ('1051', '371625', '4', '博兴县', 'BXX', '0', '118.131815', '37.150226', '103');
INSERT INTO `t_s_territory` VALUES ('1052', '371626', '4', '邹平县', 'ZPX', '0', '117.743109', '36.862989', '103');
INSERT INTO `t_s_territory` VALUES ('1053', '371702', '4', '牡丹区', 'MDQ', '0', '115.417827', '35.252512', '104');
INSERT INTO `t_s_territory` VALUES ('1054', '371721', '4', '曹县', 'CX', '0', '115.542328', '34.825508', '104');
INSERT INTO `t_s_territory` VALUES ('1055', '371722', '4', '单县', 'DX', '0', '116.107428', '34.778808', '104');
INSERT INTO `t_s_territory` VALUES ('1056', '371723', '4', '成武县', 'CWX', '0', '115.889765', '34.952459', '104');
INSERT INTO `t_s_territory` VALUES ('1057', '371724', '4', '巨野县', 'JYX', '0', '116.094674', '35.396261', '104');
INSERT INTO `t_s_territory` VALUES ('1058', '371725', '4', '郓城县', 'YCX', '0', '115.943613', '35.599758', '104');
INSERT INTO `t_s_territory` VALUES ('1059', '371726', '4', '鄄城县', 'JCX', '0', '115.510193', '35.563408', '104');
INSERT INTO `t_s_territory` VALUES ('1060', '371727', '4', '定陶县', 'DTX', '0', '115.573094', '35.071', '104');
INSERT INTO `t_s_territory` VALUES ('1061', '371728', '4', '东明县', 'DMX', '0', '115.089905', '35.289368', '104');
INSERT INTO `t_s_territory` VALUES ('1839', '370102', '4', '历下区', 'LXQ', '0', '117.07653', '36.666344', '195');
INSERT INTO `t_s_territory` VALUES ('1840', '370103', '4', '市中区', 'SZQ', '0', '116.997475', '36.6511749', '195');
INSERT INTO `t_s_territory` VALUES ('1841', '370104', '4', '槐荫区', 'HYQ', '0', '116.90113', '36.651301', '195');
INSERT INTO `t_s_territory` VALUES ('1842', '370105', '4', '天桥区', 'TQQ', '0', '116.987492', '36.678016', '195');
INSERT INTO `t_s_territory` VALUES ('1843', '370112', '4', '历城区', 'LCQ', '0', '117.065222', '36.680171', '195');
INSERT INTO `t_s_territory` VALUES ('926', '370113', '4', '长清区', 'CQQ', '0', '116.751959', '36.553691', '195');
INSERT INTO `t_s_territory` VALUES ('927', '370124', '4', '平阴县', 'PYX', '0', '116.456187', '36.289265', '195');
INSERT INTO `t_s_territory` VALUES ('928', '370125', '4', '济阳县', 'JYX', '0', '117.173529', '36.978547', '195');
INSERT INTO `t_s_territory` VALUES ('929', '370126', '4', '商河县', 'SHX', '0', '117.157183', '37.309045', '195');
INSERT INTO `t_s_territory` VALUES ('930', '370181', '4', '章丘市', 'ZQS', '0', '117.534326', '36.714015', '195');
INSERT INTO `t_s_territory` VALUES ('931', '370202', '4', '市南区', 'SNQ', '0', '120.412392', '36.075651', '89');
INSERT INTO `t_s_territory` VALUES ('932', '370203', '4', '市北区', 'SBQ', '0', '120.374801', '36.087661', '89');
INSERT INTO `t_s_territory` VALUES ('933', '370205', '4', '四方区', 'SFQ', '0', '120.366454', '36.103993', '89');
INSERT INTO `t_s_territory` VALUES ('934', '370211', '4', '黄岛区', 'HDQ', '0', '120.198054', '35.960935', '89');
INSERT INTO `t_s_territory` VALUES ('935', '370212', '4', '崂山区', 'LSQ', '0', '120.468956', '36.107538', '89');
INSERT INTO `t_s_territory` VALUES ('936', '370213', '4', '李沧区', 'LCQ', '0', '120.432864', '36.145476', '89');
INSERT INTO `t_s_territory` VALUES ('937', '370214', '4', '城阳区', 'CYQ', '0', '120.396529', '36.307061', '89');
INSERT INTO `t_s_territory` VALUES ('938', '370281', '4', '胶州市', 'JZS', '0', '120.033345', '36.264664', '89');
INSERT INTO `t_s_territory` VALUES ('939', '370282', '4', '即墨市', 'JMS', '0', '120.447162', '36.389401', '89');
INSERT INTO `t_s_territory` VALUES ('940', '370283', '4', '平度市', 'PDS', '0', '119.960014', '36.7867', '89');
INSERT INTO `t_s_territory` VALUES ('941', '370284', '4', '胶南市', 'JNS', '0', '120.04643', '35.8725', '89');
INSERT INTO `t_s_territory` VALUES ('942', '370285', '4', '莱西市', 'LXS', '0', '120.51769', '36.889084', '89');
INSERT INTO `t_s_territory` VALUES ('943', '370302', '4', '淄川区', 'ZCQ', '0', '117.966842', '36.643449', '90');
INSERT INTO `t_s_territory` VALUES ('944', '370303', '4', '张店区', 'ZDQ', '0', '118.017656', '36.806773', '90');
INSERT INTO `t_s_territory` VALUES ('945', '370304', '4', '博山区', 'BSQ', '0', '117.861698', '36.494752', '90');
INSERT INTO `t_s_territory` VALUES ('946', '370305', '4', '临淄区', 'LZQ', '0', '118.308977', '36.827343', '90');
INSERT INTO `t_s_territory` VALUES ('947', '370306', '4', '周村区', 'ZCQ', '0', '117.869877', '36.803109', '90');
INSERT INTO `t_s_territory` VALUES ('948', '370321', '4', '桓台县', 'HTX', '0', '118.097955', '36.959623', '90');
INSERT INTO `t_s_territory` VALUES ('949', '370322', '4', '高青县', 'GQX', '0', '117.826916', '37.171063', '90');
INSERT INTO `t_s_territory` VALUES ('950', '370323', '4', '沂源县', 'YYX', '0', '118.170979', '36.184827', '90');
INSERT INTO `t_s_territory` VALUES ('951', '370402', '4', '市中区', 'SZQ', '0', '117.556124', '34.864114', '91');
INSERT INTO `t_s_territory` VALUES ('952', '370403', '4', '薛城区', 'YCQ', '0', '117.263157', '34.795206', '91');
INSERT INTO `t_s_territory` VALUES ('953', '370404', '4', '峄城区', 'YCQ', '0', '117.590819', '34.772236', '91');
INSERT INTO `t_s_territory` VALUES ('954', '370405', '4', '台儿庄区', 'TEZQ', '0', '117.733832', '34.562528', '91');
INSERT INTO `t_s_territory` VALUES ('955', '370406', '4', '山亭区', 'STQ', '0', '117.461343', '35.099549', '91');
INSERT INTO `t_s_territory` VALUES ('956', '370481', '4', '滕州市', 'TZS', '0', '117.164388', '35.084021', '91');
INSERT INTO `t_s_territory` VALUES ('957', '370502', '4', '东营区', 'DYQ', '0', '118.582184', '37.448964', '92');
INSERT INTO `t_s_territory` VALUES ('958', '370503', '4', '河口区', 'HKQ', '0', '118.525579', '37.886138', '92');
INSERT INTO `t_s_territory` VALUES ('959', '370521', '4', '垦利县', 'KLX', '0', '118.547627', '37.58754', '92');
INSERT INTO `t_s_territory` VALUES ('960', '370522', '4', '利津县', 'LJX', '0', '118.255273', '37.49026', '92');
INSERT INTO `t_s_territory` VALUES ('961', '370523', '4', '广饶县', 'GRX', '0', '118.407045', '37.0537', '92');
INSERT INTO `t_s_territory` VALUES ('962', '370602', '4', '芝罘区', 'ZFQ', '0', '121.400031', '37.540687', '93');
INSERT INTO `t_s_territory` VALUES ('963', '370611', '4', '福山区', 'FSQ', '0', '121.267697', '37.498051', '93');
INSERT INTO `t_s_territory` VALUES ('964', '370612', '4', '牟平区', 'MPQ', '0', '121.600512', '37.386901', '93');
INSERT INTO `t_s_territory` VALUES ('965', '370613', '4', '莱山区', 'LSQ', '0', '121.445304', '37.511305', '93');
INSERT INTO `t_s_territory` VALUES ('966', '370614', '4', '开发区', 'KFQ', '0', '121.251001', '37.554683', '93');
INSERT INTO `t_s_territory` VALUES ('967', '370634', '4', '长岛县', 'CDX', '0', '120.736584', '37.921417', '93');
INSERT INTO `t_s_territory` VALUES ('968', '370681', '4', '龙口市', 'LKS', '0', '120.477836', '37.646064', '93');
INSERT INTO `t_s_territory` VALUES ('969', '370682', '4', '莱阳市', 'LYS', '0', '120.711607', '36.97891', '93');
INSERT INTO `t_s_territory` VALUES ('970', '370683', '4', '莱州市', 'LZS', '0', '119.942327', '37.177017', '93');
INSERT INTO `t_s_territory` VALUES ('971', '370684', '4', '蓬莱市', 'PLS', '0', '120.758848', '37.810661', '93');
INSERT INTO `t_s_territory` VALUES ('972', '370685', '4', '招远市', 'ZYS', '0', '120.434072', '37.355469', '93');
INSERT INTO `t_s_territory` VALUES ('973', '370686', '4', '栖霞市', 'QXS', '0', '120.849675', '37.335123', '93');
INSERT INTO `t_s_territory` VALUES ('974', '370687', '4', '海阳市', 'HYS', '0', '121.158477', '36.776425', '93');
INSERT INTO `t_s_territory` VALUES ('975', '370702', '4', '潍城区', 'WCQ', '0', '119.024836', '36.7281', '94');
INSERT INTO `t_s_territory` VALUES ('976', '370703', '4', '寒亭区', 'HTQ', '0', '119.219734', '36.775491', '94');
INSERT INTO `t_s_territory` VALUES ('977', '370704', '4', '坊子区', 'FZQ', '0', '119.166485', '36.654448', '94');
INSERT INTO `t_s_territory` VALUES ('978', '370705', '4', '奎文区', 'KWQ', '0', '119.132486', '36.707676', '94');
INSERT INTO `t_s_territory` VALUES ('979', '370724', '4', '临朐县', 'LQX', '0', '118.542982', '36.5125059', '94');
INSERT INTO `t_s_territory` VALUES ('980', '370725', '4', '昌乐县', 'CLX', '0', '118.829914', '36.706945', '94');
INSERT INTO `t_s_territory` VALUES ('981', '370781', '4', '青州市', 'QZS', '0', '118.479622', '36.684528', '94');
INSERT INTO `t_s_territory` VALUES ('982', '370782', '4', '诸城市', 'ZCS', '0', '119.410103', '35.995654', '94');
INSERT INTO `t_s_territory` VALUES ('983', '370783', '4', '寿光市', 'SGS', '0', '118.790652', '36.85548', '94');
INSERT INTO `t_s_territory` VALUES ('984', '370784', '4', '安丘市', 'AQS', '0', '119.218978', '36.478494', '94');
INSERT INTO `t_s_territory` VALUES ('985', '370785', '4', '高密市', 'GMS', '0', '119.755597', '36.3825949', '94');
INSERT INTO `t_s_territory` VALUES ('986', '370786', '4', '昌邑市', 'CYS', '0', '119.398525', '36.85882', '94');
INSERT INTO `t_s_territory` VALUES ('987', '370802', '4', '市中区', 'SZQ', '0', '116.596614', '35.40819', '95');
INSERT INTO `t_s_territory` VALUES ('988', '370811', '4', '任城区', 'RCQ', '0', '116.628562', '35.433727', '95');
INSERT INTO `t_s_territory` VALUES ('989', '370826', '4', '微山县', 'WSX', '0', '117.128946', '34.8071', '95');
INSERT INTO `t_s_territory` VALUES ('990', '370827', '4', '鱼台县', 'YTX', '0', '116.650608', '35.012749', '95');
INSERT INTO `t_s_territory` VALUES ('991', '370828', '4', '金乡县', 'JXX', '0', '116.311532', '35.06662', '95');
INSERT INTO `t_s_territory` VALUES ('992', '370829', '4', '嘉祥县', 'JXX', '0', '116.342442', '35.407829', '95');
INSERT INTO `t_s_territory` VALUES ('993', '370830', '4', '汶上县', 'WSX', '0', '116.489043', '35.732799', '95');
INSERT INTO `t_s_territory` VALUES ('994', '370831', '4', '泗水县', 'SSX', '0', '117.251195', '35.664323', '95');
INSERT INTO `t_s_territory` VALUES ('995', '370832', '4', '梁山县', 'LSX', '0', '116.096044', '35.802306', '95');
INSERT INTO `t_s_territory` VALUES ('996', '370881', '4', '曲阜市', 'QFS', '0', '116.986532', '35.581137', '95');
INSERT INTO `t_s_territory` VALUES ('997', '370882', '4', '兖州市', 'YZS', '0', '116.783834', '35.553144', '95');
INSERT INTO `t_s_territory` VALUES ('998', '370883', '4', '邹城市', 'ZCS', '0', '117.003743', '35.405185', '95');
INSERT INTO `t_s_territory` VALUES ('999', '370902', '4', '泰山区', 'TSQ', '0', '117.135354', '36.192084', '96');
INSERT INTO `t_s_territory` VALUES ('184', '360100', '3', '南昌市', 'NCS', '0', '115.858089', '28.68316', '17');
INSERT INTO `t_s_territory` VALUES ('185', '360200', '3', '景德镇市', 'JDZS', '0', '117.17842', '29.268836', '17');
INSERT INTO `t_s_territory` VALUES ('186', '360300', '3', '萍乡市', 'PXS', '0', '113.854676', '27.622865', '17');
INSERT INTO `t_s_territory` VALUES ('187', '360400', '3', '九江市', 'JJS', '0', '116.001951', '29.705103', '17');
INSERT INTO `t_s_territory` VALUES ('188', '360500', '3', '新余市', 'XYS', '0', '114.91741', '27.817819', '17');
INSERT INTO `t_s_territory` VALUES ('189', '360600', '3', '鹰潭市', 'YTS', '0', '117.069202', '28.260189', '17');
INSERT INTO `t_s_territory` VALUES ('190', '360700', '3', '赣州市', 'GZS', '0', '114.935025', '25.831925', '17');
INSERT INTO `t_s_territory` VALUES ('191', '360800', '3', '吉安市', 'JAS', '0', '114.992912', '27.113039', '17');
INSERT INTO `t_s_territory` VALUES ('192', '360900', '3', '宜春市', 'YCS', '0', '114.416778', '27.815619', '17');
INSERT INTO `t_s_territory` VALUES ('193', '361000', '3', '抚州市', 'FZS', '0', '116.358176', '27.9492', '17');
INSERT INTO `t_s_territory` VALUES ('194', '361100', '3', '上饶市', 'SRS', '0', '117.943433', '28.454863', '17');
INSERT INTO `t_s_territory` VALUES ('1739', '360102', '4', '东湖区', 'DHQ', '0', '115.89901', '28.6849159', '184');
INSERT INTO `t_s_territory` VALUES ('1740', '360103', '4', '西湖区', 'XHQ', '0', '115.877287', '28.656887', '184');
INSERT INTO `t_s_territory` VALUES ('1741', '360104', '4', '青云谱区', 'QYPQ', '0', '115.925749', '28.621169', '184');
INSERT INTO `t_s_territory` VALUES ('1742', '360105', '4', '湾里区', 'WLQ', '0', '115.730994', '28.714869', '184');
INSERT INTO `t_s_territory` VALUES ('1743', '360111', '4', '青山湖区', 'QSHQ', '0', '115.962144', '28.682985', '184');
INSERT INTO `t_s_territory` VALUES ('1744', '360121', '4', '南昌县', 'NCX', '0', '115.944162', '28.545459', '184');
INSERT INTO `t_s_territory` VALUES ('1745', '360122', '4', '新建县', 'XJX', '0', '115.815233', '28.692437', '184');
INSERT INTO `t_s_territory` VALUES ('1746', '360123', '4', '安义县', 'AYX', '0', '115.549199', '28.844429', '184');
INSERT INTO `t_s_territory` VALUES ('1747', '360124', '4', '进贤县', 'JXX', '0', '116.240924', '28.376918', '184');
INSERT INTO `t_s_territory` VALUES ('1748', '360202', '4', '昌江区', 'CJQ', '0', '117.183688', '29.27342', '185');
INSERT INTO `t_s_territory` VALUES ('1749', '360203', '4', '珠山区', 'ZSQ', '0', '117.202336', '29.301272', '185');
INSERT INTO `t_s_territory` VALUES ('1750', '360222', '4', '浮梁县', 'FLX', '0', '117.215061', '29.351739', '185');
INSERT INTO `t_s_territory` VALUES ('1751', '360281', '4', '乐平市', 'LPS', '0', '117.129169', '28.961902', '185');
INSERT INTO `t_s_territory` VALUES ('1752', '360302', '4', '安源区', 'AYQ', '0', '113.87073', '27.615202', '186');
INSERT INTO `t_s_territory` VALUES ('1753', '360313', '4', '湘东区', 'XDQ', '0', '113.733059', '27.640075', '186');
INSERT INTO `t_s_territory` VALUES ('1754', '360321', '4', '莲花县', 'LHX', '0', '113.961465', '27.127669', '186');
INSERT INTO `t_s_territory` VALUES ('1755', '360322', '4', '上栗县', 'SLX', '0', '113.795219', '27.880567', '186');
INSERT INTO `t_s_territory` VALUES ('1756', '360323', '4', '芦溪县', 'LXX', '0', '114.029595', '27.631145', '186');
INSERT INTO `t_s_territory` VALUES ('1757', '360402', '4', '庐山区', 'LSQ', '0', '115.989212', '29.671775', '187');
INSERT INTO `t_s_territory` VALUES ('1758', '360403', '4', '浔阳区', 'XYQ', '0', '115.990399', '29.72746', '187');
INSERT INTO `t_s_territory` VALUES ('1759', '360421', '4', '九江县', 'JJX', '0', '115.911314', '29.608456', '187');
INSERT INTO `t_s_territory` VALUES ('1760', '360423', '4', '武宁县', 'WNX', '0', '115.100579', '29.256323', '187');
INSERT INTO `t_s_territory` VALUES ('1761', '360424', '4', '修水县', 'XSX', '0', '114.547356', '29.025707', '187');
INSERT INTO `t_s_territory` VALUES ('1762', '360425', '4', '永修县', 'YXX', '0', '115.809111', '29.021824', '187');
INSERT INTO `t_s_territory` VALUES ('1763', '360426', '4', '德安县', 'DAX', '0', '115.756883', '29.314348', '187');
INSERT INTO `t_s_territory` VALUES ('1764', '360427', '4', '星子县', 'XZX', '0', '116.044893', '29.448037', '187');
INSERT INTO `t_s_territory` VALUES ('1765', '360428', '4', '都昌县', 'DCX', '0', '116.204099', '29.273194', '187');
INSERT INTO `t_s_territory` VALUES ('1766', '360429', '4', '湖口县', 'HKX', '0', '116.220266', '29.73944', '187');
INSERT INTO `t_s_territory` VALUES ('1767', '360430', '4', '彭泽县', 'PZX', '0', '116.549359', '29.896061', '187');
INSERT INTO `t_s_territory` VALUES ('1768', '360481', '4', '瑞昌市', 'RCS', '0', '115.681504', '29.673795', '187');
INSERT INTO `t_s_territory` VALUES ('1769', '360499', '4', '共青城', 'GQC', '0', '115.774', '29.2417', '187');
INSERT INTO `t_s_territory` VALUES ('1770', '360502', '4', '渝水区', 'YSQ', '0', '114.944574', '27.80038', '188');
INSERT INTO `t_s_territory` VALUES ('1771', '360521', '4', '分宜县', 'FYX', '0', '114.692039', '27.814628', '188');
INSERT INTO `t_s_territory` VALUES ('1772', '360602', '4', '月湖区', 'YHQ', '0', '117.036676', '28.238797', '189');
INSERT INTO `t_s_territory` VALUES ('1773', '360622', '4', '余江县', 'YJX', '0', '116.818871', '28.204174', '189');
INSERT INTO `t_s_territory` VALUES ('1774', '360681', '4', '贵溪市', 'GXS', '0', '117.245497', '28.292519', '189');
INSERT INTO `t_s_territory` VALUES ('1775', '360702', '4', '章贡区', 'ZGQ', '0', '114.941826', '25.862827', '190');
INSERT INTO `t_s_territory` VALUES ('1776', '360721', '4', '赣县', 'GX', '0', '115.011561', '25.860691', '190');
INSERT INTO `t_s_territory` VALUES ('1777', '360722', '4', '信丰县', 'XFX', '0', '114.922963', '25.386278', '190');
INSERT INTO `t_s_territory` VALUES ('1778', '360723', '4', '大余县', 'DYX', '0', '114.362094', '25.401283', '190');
INSERT INTO `t_s_territory` VALUES ('1779', '360724', '4', '上犹县', 'SYX', '0', '114.551371', '25.784978', '190');
INSERT INTO `t_s_territory` VALUES ('1780', '360725', '4', '崇义县', 'CYX', '0', '114.308273', '25.681879', '190');
INSERT INTO `t_s_territory` VALUES ('1781', '360726', '4', '安远县', 'AYX', '0', '115.393922', '25.136925', '190');
INSERT INTO `t_s_territory` VALUES ('1782', '360727', '4', '龙南县', 'LNX', '0', '114.789811', '24.911107', '190');
INSERT INTO `t_s_territory` VALUES ('1783', '360728', '4', '定南县', 'DNX', '0', '115.027845', '24.78441', '190');
INSERT INTO `t_s_territory` VALUES ('1784', '360729', '4', '全南县', 'QNX', '0', '114.530125', '24.742401', '190');
INSERT INTO `t_s_territory` VALUES ('1785', '360730', '4', '宁都县', 'NDX', '0', '116.009472', '26.470116', '190');
INSERT INTO `t_s_territory` VALUES ('1786', '360731', '4', '于都县', 'YDX', '0', '115.41551', '25.952066', '190');
INSERT INTO `t_s_territory` VALUES ('1787', '360732', '4', '兴国县', 'XGX', '0', '115.36319', '26.337937', '190');
INSERT INTO `t_s_territory` VALUES ('1788', '360733', '4', '会昌县', 'HCX', '0', '115.786057', '25.600272', '190');
INSERT INTO `t_s_territory` VALUES ('1789', '360734', '4', '寻乌县', 'YWX', '0', '115.646525', '24.963322', '190');
INSERT INTO `t_s_territory` VALUES ('1790', '360735', '4', '石城县', 'SCX', '0', '116.354201', '26.32686', '190');
INSERT INTO `t_s_territory` VALUES ('1791', '360781', '4', '瑞金市', 'RJS', '0', '116.02713', '25.885561', '190');
INSERT INTO `t_s_territory` VALUES ('1792', '360782', '4', '南康市', 'NKS', '0', '114.765238', '25.661356', '190');
INSERT INTO `t_s_territory` VALUES ('1793', '360802', '4', '吉州区', 'JZQ', '0', '114.994307', '27.129975', '191');
INSERT INTO `t_s_territory` VALUES ('1794', '360803', '4', '青原区', 'QYQ', '0', '115.01424', '27.081719', '191');
INSERT INTO `t_s_territory` VALUES ('1795', '360821', '4', '吉安县', 'JAX', '0', '114.907659', '27.040142', '191');
INSERT INTO `t_s_territory` VALUES ('1796', '360822', '4', '吉水县', 'JSX', '0', '115.135507', '27.229632', '191');
INSERT INTO `t_s_territory` VALUES ('1797', '360823', '4', '峡江县', 'XJX', '0', '115.316566', '27.582901', '191');
INSERT INTO `t_s_territory` VALUES ('1798', '360824', '4', '新干县', 'XGX', '0', '115.393043', '27.740809', '191');
INSERT INTO `t_s_territory` VALUES ('1799', '360825', '4', '永丰县', 'YFX', '0', '115.441477', '27.317869', '191');
INSERT INTO `t_s_territory` VALUES ('1800', '360826', '4', '泰和县', 'THX', '0', '114.908861', '26.790231', '191');
INSERT INTO `t_s_territory` VALUES ('1801', '360827', '4', '遂川县', 'SCX', '0', '114.52098', '26.311894', '191');
INSERT INTO `t_s_territory` VALUES ('1802', '360828', '4', '万安县', 'WAX', '0', '114.786256', '26.458257', '191');
INSERT INTO `t_s_territory` VALUES ('1803', '360829', '4', '安福县', 'AFX', '0', '114.619893', '27.392874', '191');
INSERT INTO `t_s_territory` VALUES ('1804', '360830', '4', '永新县', 'YXX', '0', '114.242675', '26.945233', '191');
INSERT INTO `t_s_territory` VALUES ('1805', '360881', '4', '井冈山市', 'JGSS', '0', '114.289182', '26.748186', '191');
INSERT INTO `t_s_territory` VALUES ('1806', '360902', '4', '袁州区', 'YZQ', '0', '114.424657', '27.798846', '192');
INSERT INTO `t_s_territory` VALUES ('1807', '360921', '4', '奉新县', 'FXX', '0', '115.384904', '28.700806', '192');
INSERT INTO `t_s_territory` VALUES ('1808', '360922', '4', '万载县', 'WZX', '0', '114.447551', '28.10455', '192');
INSERT INTO `t_s_territory` VALUES ('1809', '360923', '4', '上高县', 'SGX', '0', '114.924494', '28.232827', '192');
INSERT INTO `t_s_territory` VALUES ('1810', '360924', '4', '宜丰县', 'YFX', '0', '114.803542', '28.393613', '192');
INSERT INTO `t_s_territory` VALUES ('1811', '360925', '4', '靖安县', 'JAX', '0', '115.362629', '28.861475', '192');
INSERT INTO `t_s_territory` VALUES ('1812', '360926', '4', '铜鼓县', 'TGX', '0', '114.37098', '28.520747', '192');
INSERT INTO `t_s_territory` VALUES ('1813', '360981', '4', '丰城市', 'FCS', '0', '115.771195', '28.159325', '192');
INSERT INTO `t_s_territory` VALUES ('1814', '360982', '4', '樟树市', 'ZSS', '0', '115.546063', '28.055796', '192');
INSERT INTO `t_s_territory` VALUES ('1815', '360983', '4', '高安市', 'GAS', '0', '115.375618', '28.417261', '192');
INSERT INTO `t_s_territory` VALUES ('1816', '361002', '4', '临川区', 'LCQ', '0', '116.31136', '27.934529', '193');
INSERT INTO `t_s_territory` VALUES ('1817', '361021', '4', '南城县', 'NCX', '0', '116.644658', '27.552748', '193');
INSERT INTO `t_s_territory` VALUES ('1818', '361022', '4', '黎川县', 'LCX', '0', '116.907508', '27.282382', '193');
INSERT INTO `t_s_territory` VALUES ('1819', '361023', '4', '南丰县', 'NFX', '0', '116.525725', '27.218445', '193');
INSERT INTO `t_s_territory` VALUES ('1820', '361024', '4', '崇仁县', 'CRX', '0', '116.061164', '27.764681', '193');
INSERT INTO `t_s_territory` VALUES ('1821', '361025', '4', '乐安县', 'LAX', '0', '115.837895', '27.420441', '193');
INSERT INTO `t_s_territory` VALUES ('1822', '361026', '4', '宜黄县', 'YHX', '0', '116.222128', '27.546146', '193');
INSERT INTO `t_s_territory` VALUES ('1823', '361027', '4', '金溪县', 'JXX', '0', '116.775435', '27.908337', '193');
INSERT INTO `t_s_territory` VALUES ('1824', '361028', '4', '资溪县', 'ZXX', '0', '117.060264', '27.706102', '193');
INSERT INTO `t_s_territory` VALUES ('1825', '361029', '4', '东乡县', 'DXX', '0', '116.590465', '28.236118', '193');
INSERT INTO `t_s_territory` VALUES ('1826', '361030', '4', '广昌县', 'GCX', '0', '116.325757', '26.837267', '193');
INSERT INTO `t_s_territory` VALUES ('1827', '361102', '4', '信州区', 'XZQ', '0', '117.966823', '28.43121', '194');
INSERT INTO `t_s_territory` VALUES ('1828', '361121', '4', '上饶县', 'SRX', '0', '117.90785', '28.448983', '194');
INSERT INTO `t_s_territory` VALUES ('1829', '361122', '4', '广丰县', 'GFX', '0', '118.19124', '28.436286', '194');
INSERT INTO `t_s_territory` VALUES ('1830', '361123', '4', '玉山县', 'YSX', '0', '118.245124', '28.682055', '194');
INSERT INTO `t_s_territory` VALUES ('1831', '361124', '4', '铅山县', 'QSX', '0', '117.709451', '28.315217', '194');
INSERT INTO `t_s_territory` VALUES ('1832', '361125', '4', '横峰县', 'HFX', '0', '117.596452', '28.407118', '194');
INSERT INTO `t_s_territory` VALUES ('1833', '361126', '4', '弋阳县', 'YYX', '0', '117.449588', '28.378044', '194');
INSERT INTO `t_s_territory` VALUES ('1834', '361127', '4', '余干县', 'YGX', '0', '116.695647', '28.702302', '194');
INSERT INTO `t_s_territory` VALUES ('1835', '361128', '4', '鄱阳县', 'PYX', '0', '116.699746', '29.011699', '194');
INSERT INTO `t_s_territory` VALUES ('1836', '361129', '4', '万年县', 'WNX', '0', '117.058445', '28.694582', '194');
INSERT INTO `t_s_territory` VALUES ('1837', '361130', '4', '婺源县', 'WYX', '0', '117.861911', '29.2480249', '194');
INSERT INTO `t_s_territory` VALUES ('1838', '361181', '4', '德兴市', 'DXS', '0', '117.578713', '28.946464', '194');

-- ----------------------------
-- Table structure for t_s_timetask
-- ----------------------------
DROP TABLE IF EXISTS `t_s_timetask`;
CREATE TABLE `t_s_timetask` (
  `ID` varchar(32) NOT NULL,
  `CREATE_BY` varchar(32) default NULL,
  `CREATE_DATE` datetime default NULL,
  `CREATE_NAME` varchar(32) default NULL,
  `CRON_EXPRESSION` varchar(100) NOT NULL,
  `IS_EFFECT` varchar(1) NOT NULL,
  `IS_START` varchar(1) NOT NULL,
  `TASK_DESCRIBE` varchar(50) NOT NULL,
  `TASK_ID` varchar(100) NOT NULL,
  `UPDATE_BY` varchar(32) default NULL,
  `UPDATE_DATE` datetime default NULL,
  `UPDATE_NAME` varchar(32) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_timetask
-- ----------------------------
INSERT INTO `t_s_timetask` VALUES ('402882e446efd9fd0146efda80fc015c', null, null, null, '0 0/1 * * * ?', '0', '0', '测试Demo', 'taskDemoServiceTaskCronTrigger', null, null, null);

-- ----------------------------
-- Table structure for t_s_type
-- ----------------------------
DROP TABLE IF EXISTS `t_s_type`;
CREATE TABLE `t_s_type` (
  `ID` varchar(32) NOT NULL,
  `typecode` varchar(50) default NULL,
  `typename` varchar(50) default NULL,
  `typepid` varchar(32) default NULL,
  `typegroupid` varchar(32) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_nw2b22gy7plh7pqows186odmq` (`typepid`),
  KEY `FK_3q40mr4ebtd0cvx79matl39x1` (`typegroupid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_type
-- ----------------------------
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c460052', '2', '菜单图标', null, '402882e446efd9fd0146efda7bea0048');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c4b0053', '1', '系统图标', null, '402882e446efd9fd0146efda7bea0048');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c4f0054', 'files', '附件', null, '402882e446efd9fd0146efda7c110050');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c540055', '1', '优质订单', null, '402882e446efd9fd0146efda7bf10049');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c580056', '2', '普通订单', null, '402882e446efd9fd0146efda7bf10049');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c5c0057', '1', '签约客户', null, '402882e446efd9fd0146efda7bf5004a');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c600058', '2', '普通客户', null, '402882e446efd9fd0146efda7bf5004a');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c650059', '1', '特殊服务', null, '402882e446efd9fd0146efda7bfa004b');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c6c005a', '2', '普通服务', null, '402882e446efd9fd0146efda7bfa004b');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c70005b', 'single', '单条件查询', null, '402882e446efd9fd0146efda7bfe004c');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c75005c', 'group', '范围查询', null, '402882e446efd9fd0146efda7bfe004c');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c79005d', 'Y', '是', null, '402882e446efd9fd0146efda7c02004d');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c7e005e', 'N', '否', null, '402882e446efd9fd0146efda7c02004d');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c83005f', 'Integer', 'Integer', null, '402882e446efd9fd0146efda7c07004e');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c880060', 'Date', 'Date', null, '402882e446efd9fd0146efda7c07004e');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c8c0061', 'String', 'String', null, '402882e446efd9fd0146efda7c07004e');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c920062', 'Long', 'Long', null, '402882e446efd9fd0146efda7c07004e');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c950063', 'act', '工作流引擎表', null, '402882e446efd9fd0146efda7c0b004f');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c990064', 't_s', '系统基础表', null, '402882e446efd9fd0146efda7c0b004f');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7c9d0065', 't_b', '业务表', null, '402882e446efd9fd0146efda7c0b004f');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7ca10066', 't_p', '自定义引擎表', null, '402882e446efd9fd0146efda7c0b004f');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7ca50067', 'news', '新闻', null, '402882e446efd9fd0146efda7c110050');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7ca90068', '0', '男性', null, '402882e446efd9fd0146efda7c160051');
INSERT INTO `t_s_type` VALUES ('402882e446efd9fd0146efda7cad0069', '1', '女性', null, '402882e446efd9fd0146efda7c160051');
INSERT INTO `t_s_type` VALUES ('402882e4477b800f01477b898a800003', '1', '大会议室', null, '402882e4477b800f01477b893e100001');
INSERT INTO `t_s_type` VALUES ('402882e4477b800f01477b89b5600005', '2', '小会议室', null, '402882e4477b800f01477b893e100001');
INSERT INTO `t_s_type` VALUES ('40288be747be67b20147be68a1f50003', '0', '会议通知', null, '40288be747be67b20147be686c9d0001');
INSERT INTO `t_s_type` VALUES ('40288be747be67b20147be694e010005', '1', '公告通知', null, '40288be747be67b20147be686c9d0001');

-- ----------------------------
-- Table structure for t_s_typegroup
-- ----------------------------
DROP TABLE IF EXISTS `t_s_typegroup`;
CREATE TABLE `t_s_typegroup` (
  `ID` varchar(32) NOT NULL,
  `typegroupcode` varchar(50) default NULL,
  `typegroupname` varchar(50) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_typegroup
-- ----------------------------
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7bea0048', 'icontype', '图标类型');
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7bf10049', 'order', '订单类型');
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7bf5004a', 'custom', '客户类型');
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7bfa004b', 'service', '服务项目类型');
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7bfe004c', 'searchmode', '查询模式');
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7c02004d', 'yesorno', '逻辑条件');
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7c07004e', 'fieldtype', '字段类型');
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7c0b004f', 'database', '数据表');
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7c110050', 'fieltype', '文档分类');
INSERT INTO `t_s_typegroup` VALUES ('402882e446efd9fd0146efda7c160051', 'sex', '性别类');
INSERT INTO `t_s_typegroup` VALUES ('402882e4477b800f01477b893e100001', 'roomtype', '会议室类型');
INSERT INTO `t_s_typegroup` VALUES ('40288be747be67b20147be686c9d0001', 'annotype', '公告类型');

-- ----------------------------
-- Table structure for t_s_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user`;
CREATE TABLE `t_s_user` (
  `email` varchar(50) default NULL,
  `mobilePhone` varchar(30) default NULL,
  `officePhone` varchar(20) default NULL,
  `signatureFile` varchar(100) default NULL,
  `id` varchar(32) NOT NULL,
  `officno` varchar(200) default NULL COMMENT '办公室门号',
  PRIMARY KEY  (`id`),
  KEY `FK_2cuji5h6yorrxgsr8ojndlmal` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_user
-- ----------------------------
INSERT INTO `t_s_user` VALUES (null, '13426432910', '13426432910', 'images/renfang/qm/licf.gif', '402882e446efd9fd0146efda7bcc0044', '200');
INSERT INTO `t_s_user` VALUES ('libo@gmail.com', '13789098909', '87339999', null, '402882e4477f8f0201477f926ede0006', '');
INSERT INTO `t_s_user` VALUES (null, '13426432910', '7496661', null, '402882e446efd9fd0146efda7bde0046', '202');
INSERT INTO `t_s_user` VALUES (null, '13426432910', '7496662', null, '402882e446efd9fd0146efda7be40047', '203');
INSERT INTO `t_s_user` VALUES ('123@456.com', '13676787898', '87676767', null, '402880e447a63f6b0147a641f9e80001', '202');
INSERT INTO `t_s_user` VALUES ('123@456.com', '13678987898', '87989090', null, '402880e447a6c4820147a6c5b6040001', '211');
INSERT INTO `t_s_user` VALUES ('', '13654565654', '87676767', null, '402880e447a6c4820147a6c6593a0004', '212');
INSERT INTO `t_s_user` VALUES ('123@456.com', '13687878787', '87878787', null, '402880e447a6c4820147a6c6d4c90007', '213');
INSERT INTO `t_s_user` VALUES ('123@456.com', '13445454545', '87454545', null, '402880e447a6c4820147a6c753b4000a', '214');

-- ----------------------------
-- Table structure for t_s_version
-- ----------------------------
DROP TABLE IF EXISTS `t_s_version`;
CREATE TABLE `t_s_version` (
  `ID` varchar(32) NOT NULL,
  `loginpage` varchar(100) default NULL,
  `versioncode` varchar(50) default NULL,
  `versionname` varchar(30) default NULL,
  `versionnum` varchar(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_version
-- ----------------------------
