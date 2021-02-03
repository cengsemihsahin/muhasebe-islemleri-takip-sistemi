-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 03 Şub 2021, 13:42:14
-- Sunucu sürümü: 10.4.17-MariaDB
-- PHP Sürümü: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `vt_muhasebe`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin_tablosu`
--

CREATE TABLE `admin_tablosu` (
  `kullanici_id` int(11) NOT NULL,
  `kullanici_adi` varchar(10) NOT NULL,
  `kullanici_parola` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `admin_tablosu`
--

INSERT INTO `admin_tablosu` (`kullanici_id`, `kullanici_adi`, `kullanici_parola`) VALUES
(1999, 'adminsemih', 'semih123');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici_tablosu`
--

CREATE TABLE `kullanici_tablosu` (
  `kullanici_id` int(11) NOT NULL,
  `kullanici_adi` varchar(10) NOT NULL,
  `kullanici_parola` varchar(10) NOT NULL,
  `kullanici_borc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `kullanici_tablosu`
--

INSERT INTO `kullanici_tablosu` (`kullanici_id`, `kullanici_adi`, `kullanici_parola`, `kullanici_borc`) VALUES
(3, 'abcd', 'cbad', 1100),
(6, 'selam', 'selam123', 780),
(73, 'birisi', 'biri', 2525),
(79, 'kull', 'sif', 1300),
(86, 'kullanici2', 'sifre', 7000),
(87, 'alice', 'cromwell', 1460),
(88, 'mehmet', 'cengiz', 420000000);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admin_tablosu`
--
ALTER TABLE `admin_tablosu`
  ADD PRIMARY KEY (`kullanici_id`);

--
-- Tablo için indeksler `kullanici_tablosu`
--
ALTER TABLE `kullanici_tablosu`
  ADD PRIMARY KEY (`kullanici_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admin_tablosu`
--
ALTER TABLE `admin_tablosu`
  MODIFY `kullanici_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2000;

--
-- Tablo için AUTO_INCREMENT değeri `kullanici_tablosu`
--
ALTER TABLE `kullanici_tablosu`
  MODIFY `kullanici_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
