-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2023 at 08:31 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `film_artis`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `ID_AKUN` int(11) NOT NULL,
  `USERNAME` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`ID_AKUN`, `USERNAME`, `EMAIL`, `PASSWORD`) VALUES
(1, 'fachri', 'fachri@gmail.com', 'fachri');

-- --------------------------------------------------------

--
-- Table structure for table `artis`
--

CREATE TABLE `artis` (
  `ID_ARTIS` int(11) NOT NULL,
  `NAMA_ARTIS` varchar(100) NOT NULL,
  `GAMBAR_ARTIS` varchar(100) DEFAULT NULL,
  `JUMLAH_FILM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `artis`
--

INSERT INTO `artis` (`ID_ARTIS`, `NAMA_ARTIS`, `GAMBAR_ARTIS`, `JUMLAH_FILM`) VALUES
(1, 'fachri', 'rpl.jpg', 2),
(5, 'rahmaa', 'Planet9_3840x2160.jpg', 1),
(6, 'tahutuh', 'VB MY LC.png', 2);

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `ID_FILM` int(11) NOT NULL,
  `NAMA_FILM` varchar(100) NOT NULL,
  `RATING_FILM` int(11) NOT NULL,
  `GAMBAR_FILM` varchar(100) DEFAULT NULL,
  `JUMLAH_ARTIS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`ID_FILM`, `NAMA_FILM`, `RATING_FILM`, `GAMBAR_FILM`, `JUMLAH_ARTIS`) VALUES
(7, 'pesawat kertas', 100, 'sebenernya bg web tapi yaudah.png', 2),
(8, 'kapal bawang', 12, 'VBG Panitia.png', 1),
(9, 'film yang bagus', 100, 'rpl.jpg', 1),
(10, 'yah gitu lah', 13, 'sebenernya bg web tapi yaudah.png', 1);

-- --------------------------------------------------------

--
-- Table structure for table `film_artis`
--

CREATE TABLE `film_artis` (
  `ID_FILM` int(11) NOT NULL,
  `ID_ARTIS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `film_artis`
--

INSERT INTO `film_artis` (`ID_FILM`, `ID_ARTIS`) VALUES
(7, 1),
(7, 6),
(8, 6),
(9, 1),
(10, 5);

--
-- Triggers `film_artis`
--
DELIMITER $$
CREATE TRIGGER `TR_DELETE` AFTER DELETE ON `film_artis` FOR EACH ROW begin
UPDATE film SET film.jumlah_artis=film.jumlah_artis-1
WHERE id_film=OLD.id_film;
UPDATE artis SET artis.jumlah_film=artis.jumlah_film-1
WHERE id_artis=OLD.id_artis;
end
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `TR_INSERT` AFTER INSERT ON `film_artis` FOR EACH ROW begin
UPDATE film SET film.jumlah_artis=film.jumlah_artis+1
WHERE id_film=NEW.id_film;
UPDATE artis SET artis.jumlah_film=artis.jumlah_film+1
WHERE id_artis=NEW.id_artis;
end
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `TR_UPDATE` AFTER UPDATE ON `film_artis` FOR EACH ROW begin
UPDATE film SET film.jumlah_artis=film.jumlah_artis-1
WHERE id_film=OLD.id_film;
UPDATE artis SET artis.jumlah_film=artis.jumlah_film-1
WHERE id_artis=OLD.id_artis;
UPDATE film SET film.jumlah_artis=film.jumlah_artis+1
WHERE id_film=NEW.id_film;
UPDATE artis SET artis.jumlah_film=artis.jumlah_film+1
WHERE id_artis=NEW.id_artis;
end
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`ID_AKUN`);

--
-- Indexes for table `artis`
--
ALTER TABLE `artis`
  ADD PRIMARY KEY (`ID_ARTIS`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`ID_FILM`);

--
-- Indexes for table `film_artis`
--
ALTER TABLE `film_artis`
  ADD PRIMARY KEY (`ID_FILM`,`ID_ARTIS`),
  ADD KEY `FK_FILM_ART_RELATIONS_ARTIS` (`ID_ARTIS`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `ID_AKUN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `artis`
--
ALTER TABLE `artis`
  MODIFY `ID_ARTIS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `ID_FILM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `film_artis`
--
ALTER TABLE `film_artis`
  ADD CONSTRAINT `FK_FILM_ART_RELATIONS_ARTIS` FOREIGN KEY (`ID_ARTIS`) REFERENCES `artis` (`ID_ARTIS`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_FILM_ART_RELATIONS_FILM` FOREIGN KEY (`ID_FILM`) REFERENCES `film` (`ID_FILM`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
