-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2019 at 09:06 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mobile_lsp`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` text,
  `image_barang` text,
  `deskripsi_barang` text,
  `harga_barang` text,
  `stok_barang` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `image_barang`, `deskripsi_barang`, `harga_barang`, `stok_barang`) VALUES
(4, 'Buku', 'https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//93/MTA-2563581/livien_livien-ribe-tipe-2-kursi-meja-makan_full05.jpg', 'Mantap Gan', '5000', '1'),
(5, 'Buku', 'https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//93/MTA-2563581/livien_livien-ribe-tipe-2-kursi-meja-makan_full05.jpg', 'Mantap Gan', '5000', '40'),
(6, 'Buku', 'https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//93/MTA-2563581/livien_livien-ribe-tipe-2-kursi-meja-makan_full05.jpg', 'Mantap Gan', '5000', '3'),
(7, 'Kardus', 'https://ecs7.tokopedia.net/img/cache/700/product-1/2017/2/3/14133953/14133953_5264e69d-47b6-4723-a3ae-93871aa3b4fb_600_500.jpg', 'sangat bagus ini kardus', '638647', '636');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
