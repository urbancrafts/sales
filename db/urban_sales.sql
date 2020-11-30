-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 13, 2020 at 09:14 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `urban_sales`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  `tp` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `tp`) VALUES
(1, 'Michael', '4421-6653'),
(2, 'Prince Tailor', '4412-6654'),
(3, 'Loveth', '101-221'),
(4, 'Joy Okeke', '5521');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  `tp` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `tp`) VALUES
(1, 'Ebere Okereke', '08664');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  `barcode` varchar(300) NOT NULL,
  `price` varchar(50) NOT NULL,
  `qnty` int(50) NOT NULL,
  `sid` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `barcode` (`barcode`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `barcode`, `price`, `qnty`, `sid`) VALUES
(1, 'Eva Body Soap Cattons', '99100798', '4800', 2000, '2'),
(2, 'Close Up ', '324445', '300', 1200, '1');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  `tp` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `tp`) VALUES
(1, 'Mr. Gabrel', '9903'),
(2, 'Michael', '9980');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
