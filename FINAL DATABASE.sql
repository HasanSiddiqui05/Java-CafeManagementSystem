-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2022 at 09:39 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `store`
--
CREATE DATABASE IF NOT EXISTS `store` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `store`;

-- --------------------------------------------------------

--
-- Table structure for table `allsale`
--

CREATE TABLE `allsale` (
  `sname` varchar(50) NOT NULL,
  `stype` varchar(10) NOT NULL,
  `sprice` int(10) NOT NULL,
  `squantity` int(10) NOT NULL,
  `stotalamou` int(10) NOT NULL,
  `sendprice` int(10) NOT NULL,
  `scashs` int(10) NOT NULL,
  `sbalances` int(10) NOT NULL,
  `sid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `allsale`
--

INSERT INTO `allsale` (`sname`, `stype`, `sprice`, `squantity`, `stotalamou`, `sendprice`, `scashs`, `sbalances`, `sid`) VALUES
('salan', 'Normal', 50, 1, 240, 55, 50, 5, 1),
('salan', 'Normal', 50, 1, 55, 55, 5, 5, 2),
('chinese rice', 'Full', 200, 1, 200, 190, 200, 190, 3),
('chinese rice', 'Full', 200, 1, 400, 190, 200, 190, 4),
('chinese rice', 'Full', 200, 2, 400, 400, 400, 0, 5);

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE `foods` (
  `fname` varchar(20) NOT NULL,
  `ftype` varchar(10) NOT NULL,
  `fprice` int(10) NOT NULL,
  `fid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`fname`, `ftype`, `fprice`, `fid`) VALUES
('roti', 'Normal', 20, 1),
('salan', 'Normal', 120, 2),
('shorma', 'Full', 120, 3),
('salan', 'Normal', 50, 4),
('asd', 'Normal', 44, 5),
('chinese rice', 'Full', 200, 6);

-- --------------------------------------------------------

--
-- Table structure for table `inzert`
--

CREATE TABLE `inzert` (
  `iname` varchar(11) NOT NULL,
  `itype` varchar(11) NOT NULL,
  `iprize` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `oitem` varchar(10) NOT NULL,
  `oprice` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `regis`
--

CREATE TABLE `regis` (
  `rname` varchar(15) NOT NULL,
  `ruser` varchar(15) NOT NULL,
  `ridnumber` varchar(10) NOT NULL,
  `rpass` varchar(15) NOT NULL,
  `rrepass` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `regis`
--

INSERT INTO `regis` (`rname`, `ruser`, `ridnumber`, `rpass`, `rrepass`) VALUES
('bilal', 'admin', '031', '123', '123'),
('billi', 'admin2', '032', '123', '123'),
('sohail', 'admiN', '045', '111', '111'),
('Bilal', 'bilalkhan721', '031', 'bilalkhan123', 'bilalkhan123'),
('jawad', 'm.jawad', '105', '123', '123'),
('Bilal', 'admin', '031', 'bilalkhan', 'bilalkhan'),
('Bilal', 'admin', '222', 'bilalkhan', 'bilalkhan'),
('asjad', 'ajju', '23', '1234', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `rname` varchar(10) NOT NULL,
  `rposition` varchar(10) NOT NULL,
  `rphone` varchar(11) NOT NULL,
  `rid` int(15) NOT NULL,
  `raddress` varchar(25) NOT NULL,
  `rage` int(5) NOT NULL,
  `rnic` varchar(15) NOT NULL,
  `rsection` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`rname`, `rposition`, `rphone`, `rid`, `raddress`, `rage`, `rnic`, `rsection`) VALUES
('aata', 'sdgsd', '0303324213', 3, 'karachi', 22, '031', '2A'),
('bilal', '75010', '0303211561', 4, 'gsths ', 22, '031', '2aad'),
('bilal', '75010', '03032115616', 5, 'nasirabad', 22, '031', '2A'),
('uiasbfbas', '2a', '03032115616', 6, 'KARACHI', 22, '021', 'section 2a'),
('asdf', 'manager', 's235235235', 7, 'smiu', 22, '031', '2a');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `rname` varchar(10) NOT NULL,
  `rphone` int(10) NOT NULL,
  `ridnumber` int(10) NOT NULL,
  `rroom` int(10) NOT NULL,
  `raddress` varchar(10) NOT NULL,
  `ravala` varchar(10) NOT NULL,
  `rrid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `bill_no` int(10) NOT NULL,
  `item_name` varchar(25) NOT NULL,
  `quantity` int(10) NOT NULL,
  `item_price` int(5) NOT NULL,
  `amount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`bill_no`, `item_name`, `quantity`, `item_price`, `amount`) VALUES
(1, '[value-2]', 0, 0, 0),
(2, 'chinese rice', 1, 200, 190),
(3, 'chinese rice', 5, 200, 1000),
(4, 'chinese rice', 2, 200, 400);

-- --------------------------------------------------------

--
-- Table structure for table `tableee`
--

CREATE TABLE `tableee` (
  `tname` varchar(50) NOT NULL,
  `tphone` varchar(11) NOT NULL,
  `tid` int(20) NOT NULL,
  `ttime` varchar(10) NOT NULL,
  `tavai` varchar(10) NOT NULL,
  `ttable` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tableee`
--

INSERT INTO `tableee` (`tname`, `tphone`, `tid`, `ttime`, `tavai`, `ttable`) VALUES
('monkey', '54', 5, '10.00 A.M', 'BOOK', 4),
('monkey', '543', 643, '10.00 A.M', 'BOOK', 2),
('FDFDF', '6', 6543, '1.00 P.M', 'BOOK', 4),
('dnfn', '323', 32323, '11.00 A.M', 'AVAILABLE', 3),
('naveed', '123456', 425097, '10.00 A.M', 'BOOK', 2),
('ASF', '3463325', 46373467, '12.00 P.M', 'AVAILABLE', 5),
('Hashim Abbas Jaffery', '03323743375', 98765438, '1.00 P.M', 'AVAILABLE', 3),
('ASF', '3463325', 463734676, '12.00 P.M', 'AVAILABLE', 6),
('Abdul Sattar ghota ghotki say aya hai ', '03352786778', 1111111111, '11.00 A.M', 'BOOK', 2),
('Biloo', '03323743375', 1234567891, '12.00 P.M', 'AVAILABLE', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allsale`
--
ALTER TABLE `allsale`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`rid`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`bill_no`);

--
-- Indexes for table `tableee`
--
ALTER TABLE `tableee`
  ADD PRIMARY KEY (`tid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allsale`
--
ALTER TABLE `allsale`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `foods`
--
ALTER TABLE `foods`
  MODIFY `fid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `rid` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `sale`
--
ALTER TABLE `sale`
  MODIFY `bill_no` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tableee`
--
ALTER TABLE `tableee`
  MODIFY `tid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1234567892;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
