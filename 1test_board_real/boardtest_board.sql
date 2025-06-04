-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: boardtest
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `board_no` int NOT NULL AUTO_INCREMENT,
  `board_title` varchar(200) NOT NULL,
  `board_content` text NOT NULL,
  `board_writer` varchar(100) NOT NULL,
  `board_date` date NOT NULL,
  `valid` char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`board_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'지식산업센터 반짝마켓 참여기업 모집','강서구는 관내 지식산업센터 입주기업과 소상공인이 함께하는 지식산업센터 반짝마켓을 운영하여 입주기업 및 소상공인의 물품을 홍보하고 판매증대에 기여하고자 합니다. 이에 지식산업센터 반짝마켓에 참여할 대상자을 모집하고자 하오니 많은 관심과 참여 부탁드립니다.\r\n\r\n \r\n\r\n< 사업개요 >\r\n\r\n□ 사 업 명: 지식산업센터 반짝마켓\r\n\r\n□ 사업일시: 2025. 6. 19.(목) 10:00 ~ 19:00\r\n\r\n□ 장    소: 우림블루나인비즈니스센터 앞 공개공지 일대(강서구 양천로 583)\r\n\r\n□ 지원대상: 강서구 소재 지식산업센터 입주기업 및 소상공인\r\n\r\n             (신선‧조리식품 제외 전품목 대상)\r\n\r\n□ 지원사항\r\n\r\n  - 우림블루나인비즈니스센터 앞 공간 무상 제공\r\n\r\n  - 제품 전시‧판매를 위한 참여대상별 전시 환경 조성(판매대, 제품홍보 현수막 제작 등)\r\n\r\n  - 강서구자원 활용 홍보 마케팅 지원(SNS, 보도자료 등)\r\n\r\n  - 기타 현장 운영 관련 지원(상품관리, 고객응대 지원 등)','jinssvg','2025-05-28','Y'),(2,'2025년 강서구 경력보유(단절)여성 교육훈련 과정 운영','2025년 강서구 경력보유여성 교육훈련 과정 운영합니다!\r\n- 참여대상: 강서구 거주 경력보유여성\r\n*경력보유여성: 혼인, 임신, 출산, 돌봄노동으로 인하여 경력이 단절되었으며 재취업을 희망하는 여성\r\n- 운영과정: 이커머스 여성창업가 양성과정, 홈케어 마스터 양성과정, 실버복지 행정사무원 양성과정\r\n- 교육장소: 서울 호서직업전문학교\r\n- 교육비: 무료(자격증 취득비 등은 별도)\r\n자세한 사항은 첨부 이미지 참고 바랍니다!','jinssvg','2025-05-28','Y'),(3,'시내버스 파업 유보에 따른 시내버스 정상운행 안내','서울 시내버스 파업 유보에 따라 2025. 5. 28.(수) 첫차부터 시내버스가 정상운행됨을 안내드립니다. ','jinssvg','2025-05-28','Y'),(4,'인근 국가에서 코로나19 발생 증가, 일상 속 예방수칙 준수!','코로나19 발생 증가와 관련하여, 아직까지 국내는 안정적으로 관리 중이나, 예년의 양상을 참고할 때,\r\n\r\n​여름철 유행 가능성을 배제할 수 없는 만큼,  일상 에서 호흡기감염병 예방수칙 준수가 필요하며, 고위험군은 예방접종을 권고!\r\n\r\n\r\n○ (발생 동향) 코로나19 표본감시 입원환자 100명, 최근 4주 유사한 수준\r\n\r\n* (최근 4주 현황) 17주 127명 → 18주 115명 → 19주 146명 → 20주 100명\r\n\r\n \r\n\r\n○ (병원체 감시) 코로나19 바이러스 8.6% 검출로 지난 주 대비 5.8%p 증가\r\n\r\n* (최근 4주 현황) 17주 6.9% → 18주 4.2% → 19주 2.8% → 20주 8.6%\r\n\r\n \r\n\r\n○ (국외 동향) 홍콩, 중국, 대만 등 아시아 국가에서 증가세, 미국, 영국, 일본 등 전세계적으로는 감소\r\n\r\n* (홍콩) 20주차 양성률 13.80%로 1년 새 최고치, (중국) 18주차 양성률 16.2%로 24년 최고치 근접 중, (전세계) 18주차(4.28.~5.4.) 양성률은 3.4%\r\n\r\n \r\n\r\n○ (예방접종) 65세 이상 어르신, 면역저하자 등 고위험군 대상 예방접종 적극 권고','hyeji','2025-05-28','N'),(5,'청년 1인가구 대상 나DO한끼 프로그램 안내','- 기간: 2025. 6. 14.(토)/21(토) 10시30분~12시30분\r\n\r\n- 장소: 센터스퀘어 2층 공유주방\r\n\r\n- 대상: 관내 청년 1인 가구 20명\r\n\r\n- 프로그램 내용','hyeji','2025-05-28','Y'),(6,'삭제할테면 해봐라','삭제가되나 낄낄낄','hyeji','2025-05-28','N');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-29 10:27:26
