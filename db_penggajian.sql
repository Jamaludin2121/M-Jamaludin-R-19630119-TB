-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Jan 2022 pada 15.24
-- Versi server: 10.4.19-MariaDB
-- Versi PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_penggajian`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bulan`
--

CREATE TABLE `bulan` (
  `nama_bulan` varchar(20) NOT NULL,
  `id_bulan` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bulan`
--

INSERT INTO `bulan` (`nama_bulan`, `id_bulan`) VALUES
('Januari', 1),
('Februari', 2),
('Maret', 3),
('April', 4),
('Mei', 5),
('Juni', 6),
('Juli', 7),
('Agustus', 8),
('September', 9),
('Oktober', 10),
('November', 11),
('Desember', 12);

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_gaji`
--

CREATE TABLE `data_gaji` (
  `kd_karyawan` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `id_bulan` int(2) NOT NULL,
  `id_gaji` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data_gaji`
--

INSERT INTO `data_gaji` (`kd_karyawan`, `tanggal`, `id_bulan`, `id_gaji`) VALUES
('KR001', '2022-01-03', 1, 7),
('KR002', '2022-01-03', 1, 8),
('KR003', '2022-01-03', 1, 9),
('KR004', '2022-01-03', 1, 10);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `q_data`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `q_data` (
`kd_karyawan` varchar(5)
,`nama_karyawan` varchar(50)
,`umur` int(2)
,`jenis_kelamin` varchar(9)
,`jabatan` varchar(25)
,`alamat` text
,`tanggal` date
,`nama_bulan` varchar(20)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `q_gaji`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `q_gaji` (
`kd_karyawan` varchar(5)
,`nama_karyawan` varchar(50)
,`jabatan` varchar(25)
,`gaji_pokok` int(99)
,`tunjangan` int(99)
,`lembur` int(99)
,`bonus` int(99)
,`potongan` int(99)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `q_gajih`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `q_gajih` (
`kd_karyawan` varchar(5)
,`nama_karyawan` varchar(50)
,`umur` int(2)
,`jenis_kelamin` varchar(9)
,`jabatan` varchar(25)
,`alamat` text
,`tanggal` date
,`id_bulan` int(2)
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_gaji`
--

CREATE TABLE `tb_gaji` (
  `kd_karyawan` varchar(5) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `gaji_pokok` int(99) NOT NULL,
  `tunjangan` int(99) NOT NULL,
  `lembur` int(99) NOT NULL,
  `bonus` int(99) NOT NULL,
  `potongan` int(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_gaji`
--

INSERT INTO `tb_gaji` (`kd_karyawan`, `nama_karyawan`, `gaji_pokok`, `tunjangan`, `lembur`, `bonus`, `potongan`) VALUES
('KR002', 'Ali', 5000000, 2000000, 1000000, 1200000, 500000),
('KR001', 'Bayu', 4000000, 2000000, 1000000, 1000000, 700000),
('KR003', 'Adisti', 5000000, 3000000, 2000000, 1000000, 400000),
('KR005', 'Jess No Dilong', 100000000, 9999999, 999999, 9999999, 2000),
('KR004', 'Bagas', 3000000, 2000000, 1000000, 1100000, 500000),
('KR006', 'Baru', 1, 2, 3, 4, 6),
('KR007', 'Arif', 2, 3, 5, 6, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_karyawan`
--

CREATE TABLE `tb_karyawan` (
  `kd_karyawan` varchar(5) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `umur` int(2) NOT NULL,
  `jenis_kelamin` varchar(9) NOT NULL,
  `jabatan` varchar(25) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_karyawan`
--

INSERT INTO `tb_karyawan` (`kd_karyawan`, `nama_karyawan`, `umur`, `jenis_kelamin`, `jabatan`, `alamat`) VALUES
('KR001', 'Bayu', 19, 'Laki-laki', 'General Manager', 'Banjarmasin'),
('KR002', 'Ali', 20, 'Laki-laki', 'Manager', 'Banjarmasin'),
('KR003', 'Adisti', 18, 'Perempuan', 'Kepala Cabang', 'Banjarbaru'),
('KR004', 'Bagas', 19, 'Laki-laki', 'Supervisor', 'Pelaihari');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_user`
--

INSERT INTO `tb_user` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur untuk view `q_data`
--
DROP TABLE IF EXISTS `q_data`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `q_data`  AS SELECT `tb_karyawan`.`kd_karyawan` AS `kd_karyawan`, `tb_karyawan`.`nama_karyawan` AS `nama_karyawan`, `tb_karyawan`.`umur` AS `umur`, `tb_karyawan`.`jenis_kelamin` AS `jenis_kelamin`, `tb_karyawan`.`jabatan` AS `jabatan`, `tb_karyawan`.`alamat` AS `alamat`, `data_gaji`.`tanggal` AS `tanggal`, `bulan`.`nama_bulan` AS `nama_bulan` FROM ((`data_gaji` join `tb_karyawan` on(`data_gaji`.`kd_karyawan` = `tb_karyawan`.`kd_karyawan`)) join `bulan` on(`data_gaji`.`id_bulan` = `bulan`.`id_bulan`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `q_gaji`
--
DROP TABLE IF EXISTS `q_gaji`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `q_gaji`  AS SELECT `tb_karyawan`.`kd_karyawan` AS `kd_karyawan`, `tb_karyawan`.`nama_karyawan` AS `nama_karyawan`, `tb_karyawan`.`jabatan` AS `jabatan`, `tb_gaji`.`gaji_pokok` AS `gaji_pokok`, `tb_gaji`.`tunjangan` AS `tunjangan`, `tb_gaji`.`lembur` AS `lembur`, `tb_gaji`.`bonus` AS `bonus`, `tb_gaji`.`potongan` AS `potongan` FROM (`tb_karyawan` join `tb_gaji` on(`tb_karyawan`.`kd_karyawan` = `tb_gaji`.`kd_karyawan`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `q_gajih`
--
DROP TABLE IF EXISTS `q_gajih`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `q_gajih`  AS SELECT `tb_karyawan`.`kd_karyawan` AS `kd_karyawan`, `tb_karyawan`.`nama_karyawan` AS `nama_karyawan`, `tb_karyawan`.`umur` AS `umur`, `tb_karyawan`.`jenis_kelamin` AS `jenis_kelamin`, `tb_karyawan`.`jabatan` AS `jabatan`, `tb_karyawan`.`alamat` AS `alamat`, `data_gaji`.`tanggal` AS `tanggal`, `data_gaji`.`id_bulan` AS `id_bulan` FROM (`tb_karyawan` left join `data_gaji` on(`tb_karyawan`.`kd_karyawan` = `data_gaji`.`kd_karyawan`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `bulan`
--
ALTER TABLE `bulan`
  ADD PRIMARY KEY (`id_bulan`);

--
-- Indeks untuk tabel `data_gaji`
--
ALTER TABLE `data_gaji`
  ADD PRIMARY KEY (`id_gaji`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `data_gaji`
--
ALTER TABLE `data_gaji`
  MODIFY `id_gaji` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
