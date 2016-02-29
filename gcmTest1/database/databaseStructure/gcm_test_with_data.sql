-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 29, 2016 at 05:41 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gcm_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `api_key`
--

CREATE TABLE `api_key` (
  `userid` varchar(50) DEFAULT NULL,
  `deviceid` int(10) UNSIGNED NOT NULL,
  `registration_id` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `api_key`
--

INSERT INTO `api_key` (`userid`, `deviceid`, `registration_id`, `timestamp`) VALUES
('Testing Android', 7, 'eE1k3c3oTn8:APA91bHp91A5wtvJThHatU_Atn7jR4UZ4c84uw4DJWLagufCYLuOSJzRTlbpwZgZkT0URMo9I5bmYpV3pyF3roaaByDZMxIurP17SgUq-XCQ5jDR0IiqSFh_dyp5MOo3VDthRRS0ZWKc', '2016-02-28 20:06:06'),
('Testing Android', 8, 'e2FaQFC4Y2c:APA91bFqj6cD9yhQTPrrDGL6ZVUjRRkWZiyAS_T6eFnoU2QKQXQacPpVr1n7PR_kMgnu6mpYnmAyIfILzthOm_Nw41OQTVdWpAbhDFD1nbIyFp3AifCnxr99eeosp6IiQxMj5-zVX-y_', '2016-02-28 20:25:14');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `newsid` int(10) UNSIGNED NOT NULL,
  `title` varchar(100) NOT NULL,
  `s_desc` varchar(250) NOT NULL,
  `l_desc` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `imageurl` varchar(250) DEFAULT '',
  `author` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`newsid`, `title`, `s_desc`, `l_desc`, `timestamp`, `imageurl`, `author`) VALUES
(16, 'Syria conflict: Temporary truce comes into effect', 'The first major temporary truce in Syrias five-year civil war has come into effect', 'A few hours after the deadline passed, a car bomb killed two people outside the government-held town of Salamiyeh, near Hama, Syrian state media reported. It is not clear who carried out the attack.', '2016-02-27 10:04:55', '', 'test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `api_key`
--
ALTER TABLE `api_key`
  ADD PRIMARY KEY (`deviceid`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`newsid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `api_key`
--
ALTER TABLE `api_key`
  MODIFY `deviceid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `newsid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
