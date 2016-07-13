-- --------------------------------------------------------
-- 主机:                           192.168.204.129
-- 服务器版本:                        5.7.13 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- 正在导出表  ycProjectRelease.key_Vallue_config 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `key_Vallue_config` DISABLE KEYS */;
INSERT INTO `key_Vallue_config` (`id`, `rkey`, `rvalue`, `remark`, `isused`, `create_date`, `create_person`, `update_date`, `update_person`) VALUES
	(1, 'endendPublish', '0', '1', '1', '2016-07-13 16:10:41', 'DB', '2016-07-13 09:29:53', NULL);
/*!40000 ALTER TABLE `key_Vallue_config` ENABLE KEYS */;

-- 正在导出表  ycProjectRelease.releasePerson 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `releasePerson` DISABLE KEYS */;
INSERT INTO `releasePerson` (`id`, `releaseName`, `createDate`, `updateDate`, `isUsed`, `remark`, `systemCode`) VALUES
	(11, '董盼', '2016-07-13 06:35:11', '2016-07-12 23:35:11', '1', NULL, NULL),
	(12, '李月杨', '2016-07-13 07:17:25', '2016-07-13 00:17:25', '1', NULL, NULL),
	(13, '乔梦杰', '2016-07-13 07:19:09', '2016-07-13 00:19:08', '1', NULL, NULL),
	(14, '王哲', '2016-07-13 07:19:38', '2016-07-13 00:19:37', '1', NULL, NULL),
	(15, '周星', '2016-07-13 07:19:46', '2016-07-13 00:19:45', '1', NULL, NULL),
	(16, '张凯文', '2016-07-13 07:20:08', '2016-07-13 00:20:08', '1', NULL, NULL),
	(17, '李精研', '2016-07-13 07:20:35', '2016-07-13 00:20:35', '1', NULL, NULL),
	(18, '刘腾飞', '2016-07-13 07:20:51', '2016-07-13 00:20:50', '1', NULL, NULL),
	(19, '任朝建', '2016-07-13 07:21:11', '2016-07-13 00:21:11', '1', NULL, NULL),
	(20, '吴伟杰', '2016-07-13 07:21:40', '2016-07-13 00:21:39', '1', NULL, NULL),
	(21, '易佳', '2016-07-13 07:21:55', '2016-07-13 00:21:55', '1', NULL, NULL),
	(22, '赵南南', '2016-07-13 07:22:17', '2016-07-13 00:22:17', '1', NULL, NULL),
	(23, '付健', '2016-07-13 07:22:30', '2016-07-13 00:22:30', '1', NULL, NULL);
/*!40000 ALTER TABLE `releasePerson` ENABLE KEYS */;

-- 正在导出表  ycProjectRelease.releaseSystem 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `releaseSystem` DISABLE KEYS */;
INSERT INTO `releaseSystem` (`id`, `system_name`, `system_remark`, `create_persion`, `create_date`, `update_persion`, `update_date`, `is_used`) VALUES
	(1, '云仓', NULL, 'db', '2016-07-13 10:17:17', NULL, NULL, '1');
/*!40000 ALTER TABLE `releaseSystem` ENABLE KEYS */;

-- 正在导出表  ycProjectRelease.releaseSystem_person 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `releaseSystem_person` DISABLE KEYS */;
INSERT INTO `releaseSystem_person` (`id`, `releaseSystemid`, `releasepersonId`) VALUES
	(8, 1, 11),
	(9, 1, 12),
	(10, 1, 13),
	(11, 1, 14),
	(12, 1, 15),
	(13, 1, 16),
	(14, 1, 17),
	(15, 1, 18),
	(16, 1, 19),
	(17, 1, 20),
	(18, 1, 21),
	(19, 1, 22),
	(20, 1, 23);
/*!40000 ALTER TABLE `releaseSystem_person` ENABLE KEYS */;

-- 正在导出表  ycProjectRelease.Release_list 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `Release_list` DISABLE KEYS */;
INSERT INTO `Release_list` (`id`, `pathList`, `systemName`, `release_mark`, `createDate`, `createPerson`, `updateDate`, `updatePerson`, `isUsed`, `ispublish`, `releasePersonId`, `releasePersonName`, `systemID`) VALUES
	(25, 'cloud/owner/basic_biz/booking/put_in/put_in.js\ncloud/owner/basic_biz/booking/put_in/put_in.js', '云仓', 'test', '2016-07-13 10:07:57', '11', NULL, NULL, '1', '0', '11', '董盼', '1');
/*!40000 ALTER TABLE `Release_list` ENABLE KEYS */;

-- 正在导出表  ycProjectRelease.root_directories 的数据：~43 rows (大约)
/*!40000 ALTER TABLE `root_directories` DISABLE KEYS */;
INSERT INTO `root_directories` (`id`, `directoriey_name`, `isUsed`, `create_date`, `create_persion`, `update_date`, `update_persion`, `sys_id`) VALUES
	(67, '404.html', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(68, '404.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(69, '500.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(70, 'at', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(71, 'cloud', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(72, 'common', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(73, 'company.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(74, 'company.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(75, 'Copy of index.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(76, 'Copy of login.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(77, 'Copy of top.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(78, 'css', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(79, 'cut.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(80, 'cut.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(81, 'favicon.ico', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(82, 'files', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(83, 'hoverCard', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(84, 'ignorePower', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(85, 'images', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(86, 'index.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(87, 'index.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(88, 'login.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(89, 'login.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(90, 'META-INF', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(91, 'otherCompany.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(92, 'otherCompany.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(93, 'other.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(94, 'other.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(95, 'page.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(96, 'personal.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(97, 'personal.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(98, 'qrcode.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(99, 'relation.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(100, 'relation.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(101, 'search.js', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(102, 'search.jsp', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(103, 'set', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(104, 'Thumbs.db', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(105, 'upload', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(106, 'WEB-INF', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(107, 'ySteel', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(108, 'yStore', '1', '2016-07-12 11:28:42', 'Admin', NULL, NULL, '1'),
	(109, 'WEB-INF/classes', '1', '2016-07-12 12:18:13', 'Admin', NULL, NULL, '1');
/*!40000 ALTER TABLE `root_directories` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
