-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 29 Jul 2019 pada 04.27
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpoliklinik`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `catatan_medik`
--

CREATE TABLE `catatan_medik` (
  `kode_catatan` char(10) NOT NULL,
  `no_resep` char(10) NOT NULL,
  `catatan_medik` text NOT NULL,
  `tgl_catatan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `catatan_medik`
--

INSERT INTO `catatan_medik` (`kode_catatan`, `no_resep`, `catatan_medik`, `tgl_catatan`) VALUES
('0812981293', 'AAAA123456', 'Terdapat lendir yang menggangku tenggorokan anak dan mengalami sesak', '2019-07-27'),
('8891283912', 'AAAA123123', 'polip pada gigi membengkak dan terdapat kelainan rangka pada gigi', '2019-07-27');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_obat`
--

CREATE TABLE `detail_obat` (
  `no_resep` char(10) NOT NULL,
  `kode_obat` char(5) NOT NULL,
  `jumlah` int(3) DEFAULT NULL,
  `aturan_pakai` varchar(50) DEFAULT NULL,
  `sub_harga_obat` int(7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detail_obat`
--

INSERT INTO `detail_obat` (`no_resep`, `kode_obat`, `jumlah`, `aturan_pakai`, `sub_harga_obat`) VALUES
('AAAA123456', 'AA123', 1, '3 x 1, 1 sendok makan sebelum makan', 20000),
('AAAA123456', 'AA321', 1, '1 x 1, sesudah makan', 100000),
('AAAA123123', 'AA321', 1, '1 x 1, sesudah makan', 100000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_tindakan`
--

CREATE TABLE `detail_tindakan` (
  `no_resep` char(10) NOT NULL,
  `kode_tindakan` char(5) NOT NULL,
  `sub_harga_obat` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detail_tindakan`
--

INSERT INTO `detail_tindakan` (`no_resep`, `kode_tindakan`, `sub_harga_obat`) VALUES
('AAAA123456', 'TDK01', NULL),
('AAAA123456', 'TDK02', NULL),
('AAAA123123', 'TDK02', NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `obat`
--

CREATE TABLE `obat` (
  `kode_obat` char(5) NOT NULL,
  `nama_obat` varchar(30) NOT NULL,
  `stok` int(3) NOT NULL,
  `harga_obat` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `obat`
--

INSERT INTO `obat` (`kode_obat`, `nama_obat`, `stok`, `harga_obat`) VALUES
('AA123', 'ABIDEC DROP 15 ML', 200, 20000),
('AA321', 'ACNACARE GEL 5 G', 200, 100000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasien`
--

CREATE TABLE `pasien` (
  `no_pasien` char(10) NOT NULL,
  `nama_pasien` varchar(40) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `tgl_lahir_pasien` date NOT NULL,
  `not_telp_pasien` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pasien`
--

INSERT INTO `pasien` (`no_pasien`, `nama_pasien`, `alamat`, `tgl_lahir_pasien`, `not_telp_pasien`) VALUES
('AAAAA08912', 'Hery Sunadi', 'Jl. Rambutan GG 1 No.30, Bandung', '1996-07-04', '083899120312'),
('AAAAB99128', 'Rudi Komala', 'Jl. Soekarno No.02, Bandung', '2012-07-03', '082921920309');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `nip` char(18) NOT NULL,
  `kode_spesialis` char(3) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(12) NOT NULL,
  `nama_pegawai` varchar(40) NOT NULL,
  `pekerjaan` enum('dokter','resepsionis','apoteker') DEFAULT NULL,
  `tgl_lahir_pegawai` date NOT NULL,
  `alamat_pegawai` varchar(50) NOT NULL,
  `no_telp_pegawai` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`nip`, `kode_spesialis`, `username`, `password`, `nama_pegawai`, `pekerjaan`, `tgl_lahir_pegawai`, `alamat_pegawai`, `no_telp_pegawai`) VALUES
('198203302003122001', 's01', 'aa', '123', 'Dr. Suzy Irawati Sjahid, Sp.A', 'dokter', '1982-03-30', 'Jl. Kebonjati No. 38, Bandung', '083812929191'),
('198206102004081001', 's02', 'bb', '123', 'Dr. Kelly Munazar, Sp.BM', 'dokter', '1982-06-10', 'Jl. Maulana Yusuf No. 6 Dago Bandung', '098182812731'),
('199001052018081007', NULL, 'cc', '123', 'Riki Wijjayanto', 'resepsionis', '1990-01-05', 'Jl. Sekeloa GG Loa1 No 12, Bandung', '083812990987'),
('199001152018051015', NULL, 'dd', '123', 'Kemal Bahrudin', 'apoteker', '1990-01-15', 'Jl. Sekeloa GG.Loa 1 No. 20, Bandung', '0812177812123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `resep`
--

CREATE TABLE `resep` (
  `no_resep` char(10) NOT NULL,
  `nip` char(18) NOT NULL,
  `no_pasien` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `resep`
--

INSERT INTO `resep` (`no_resep`, `nip`, `no_pasien`) VALUES
('AAAA123123', '198206102004081001', 'AAAAA08912'),
('AAAA123456', '198203302003122001', 'AAAAB99128'),
('GTCK455900', '198203302003122001', 'AAAAA08912');

-- --------------------------------------------------------

--
-- Struktur dari tabel `spesialis`
--

CREATE TABLE `spesialis` (
  `kode_spesialis` char(3) NOT NULL,
  `nama_spesialis` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `spesialis`
--

INSERT INTO `spesialis` (`kode_spesialis`, `nama_spesialis`) VALUES
('s01', 'anak'),
('s02', 'Bedah Mulut');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tindakan`
--

CREATE TABLE `tindakan` (
  `kode_tindakan` char(5) NOT NULL,
  `nama_tindakan` varchar(25) NOT NULL,
  `harga_tindakan` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tindakan`
--

INSERT INTO `tindakan` (`kode_tindakan`, `nama_tindakan`, `harga_tindakan`) VALUES
('TDK01', 'Rontgen', 200000),
('TDK02', 'Test Darah', 100000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `no_nota` char(10) NOT NULL,
  `no_resep` char(10) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `total_harga_tindakan` int(8) NOT NULL,
  `total_harga_obat` int(8) NOT NULL,
  `total_pembayaran` int(8) NOT NULL,
  `pembayaran` int(8) NOT NULL,
  `kembalian` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `catatan_medik`
--
ALTER TABLE `catatan_medik`
  ADD PRIMARY KEY (`kode_catatan`),
  ADD KEY `no_resep` (`no_resep`);

--
-- Indeks untuk tabel `detail_obat`
--
ALTER TABLE `detail_obat`
  ADD KEY `no_resep` (`no_resep`),
  ADD KEY `kode_obat` (`kode_obat`);

--
-- Indeks untuk tabel `detail_tindakan`
--
ALTER TABLE `detail_tindakan`
  ADD KEY `no_resep` (`no_resep`),
  ADD KEY `kode_tindakan` (`kode_tindakan`);

--
-- Indeks untuk tabel `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`kode_obat`);

--
-- Indeks untuk tabel `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`no_pasien`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`nip`),
  ADD KEY `kode_spesialis` (`kode_spesialis`);

--
-- Indeks untuk tabel `resep`
--
ALTER TABLE `resep`
  ADD PRIMARY KEY (`no_resep`),
  ADD KEY `nip` (`nip`),
  ADD KEY `no_pasien` (`no_pasien`);

--
-- Indeks untuk tabel `spesialis`
--
ALTER TABLE `spesialis`
  ADD PRIMARY KEY (`kode_spesialis`);

--
-- Indeks untuk tabel `tindakan`
--
ALTER TABLE `tindakan`
  ADD PRIMARY KEY (`kode_tindakan`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`no_nota`),
  ADD KEY `no_resep` (`no_resep`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `catatan_medik`
--
ALTER TABLE `catatan_medik`
  ADD CONSTRAINT `catatan_medik_ibfk_2` FOREIGN KEY (`no_resep`) REFERENCES `resep` (`no_resep`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `detail_obat`
--
ALTER TABLE `detail_obat`
  ADD CONSTRAINT `detail_obat_ibfk_1` FOREIGN KEY (`no_resep`) REFERENCES `resep` (`no_resep`) ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_obat_ibfk_2` FOREIGN KEY (`kode_obat`) REFERENCES `obat` (`kode_obat`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `detail_tindakan`
--
ALTER TABLE `detail_tindakan`
  ADD CONSTRAINT `detail_tindakan_ibfk_1` FOREIGN KEY (`no_resep`) REFERENCES `resep` (`no_resep`) ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_tindakan_ibfk_2` FOREIGN KEY (`kode_tindakan`) REFERENCES `tindakan` (`kode_tindakan`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `pegawai_ibfk_1` FOREIGN KEY (`kode_spesialis`) REFERENCES `spesialis` (`kode_spesialis`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `resep`
--
ALTER TABLE `resep`
  ADD CONSTRAINT `resep_ibfk_1` FOREIGN KEY (`nip`) REFERENCES `pegawai` (`nip`) ON UPDATE CASCADE,
  ADD CONSTRAINT `resep_ibfk_2` FOREIGN KEY (`no_pasien`) REFERENCES `pasien` (`no_pasien`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`no_resep`) REFERENCES `resep` (`no_resep`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
