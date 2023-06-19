-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 30 Juin 2016 à 05:43
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gestionprocessus`
--

-- --------------------------------------------------------

--
-- Structure de la table `action`
--

CREATE TABLE IF NOT EXISTS `action` (
  `Id_Action` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) COLLATE utf8_bin NOT NULL,
  `Description` text COLLATE utf8_bin NOT NULL,
  `id_Anomalie` int(11) NOT NULL,
  PRIMARY KEY (`Id_Action`),
  KEY `id_Anomalie` (`id_Anomalie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `activite`
--

CREATE TABLE IF NOT EXISTS `activite` (
  `Id_Activite` int(11) NOT NULL AUTO_INCREMENT,
  `Libelle` varchar(80) COLLATE utf8_bin NOT NULL,
  `Description` text COLLATE utf8_bin NOT NULL,
  `duree` int(11) NOT NULL,
  `etat` tinyint(1) NOT NULL,
  `Id_Processus` int(11) NOT NULL,
  PRIMARY KEY (`Id_Activite`),
  KEY `Id_Processus` (`Id_Processus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8_bin NOT NULL,
  `id_profile` int(11) NOT NULL,
  PRIMARY KEY (`id_admin`),
  KEY `id_profile` (`id_profile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `anomalie`
--

CREATE TABLE IF NOT EXISTS `anomalie` (
  `id_Anomalie` int(11) NOT NULL AUTO_INCREMENT,
  `Libelle` varchar(50) COLLATE utf8_bin NOT NULL,
  `detaille` text COLLATE utf8_bin NOT NULL,
  `id_Processus` int(11) NOT NULL,
  PRIMARY KEY (`id_Anomalie`),
  KEY `id_Processus` (`id_Processus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `archive_employe`
--

CREATE TABLE IF NOT EXISTS `archive_employe` (
  `id_Archive` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Cin` varchar(8) NOT NULL,
  `nombreAnnee` int(11) NOT NULL,
  `date_Changement` date NOT NULL,
  `Role` varchar(20) NOT NULL,
  PRIMARY KEY (`id_Archive`),
  UNIQUE KEY `id_Archive` (`id_Archive`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `archive_employe`
--

INSERT INTO `archive_employe` (`id_Archive`, `Cin`, `nombreAnnee`, `date_Changement`, `Role`) VALUES
(1, 'c41231', 1, '1999-05-08', 'Pilote'),
(2, 'c41231', 7, '2005-03-08', 'Responsable'),
(3, 'c41231', 6, '2010-08-25', 'Employe'),
(4, 'c41231', 6, '2015-05-31', 'Responsable'),
(6, 'c220', 1, '2016-05-15', 'Pilote'),
(7, 'm123ml', 1, '2016-05-15', 'Pilote'),
(8, 'c41231', 1, '2016-05-18', 'Employe'),
(10, 'c220', 1, '2016-05-19', 'Pilote'),
(11, 'm123ml', 1, '2016-05-19', 'Responsable'),
(12, 'c220', 1, '2016-05-22', 'Pilote'),
(13, 'c220', 1, '2016-05-22', 'Pilote'),
(15, 'c220', 1, '2016-05-22', 'Pilote'),
(16, 'c220', 1, '2016-05-26', 'Employe');

-- --------------------------------------------------------

--
-- Structure de la table `audit`
--

CREATE TABLE IF NOT EXISTS `audit` (
  `id_audit` int(11) NOT NULL AUTO_INCREMENT,
  `id_Processus` int(11) NOT NULL,
  `detaille` text COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_audit`),
  KEY `id_Processus` (`id_Processus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `Id_Employe` int(20) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(50) COLLATE utf8_bin NOT NULL,
  `Cin` varchar(12) COLLATE utf8_bin NOT NULL,
  `Date_Naissance` date NOT NULL,
  `sexe` enum('M','F') COLLATE utf8_bin NOT NULL,
  `adresse` varchar(100) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `telephone` varchar(50) COLLATE utf8_bin NOT NULL,
  `Date_Recrutement` date NOT NULL,
  PRIMARY KEY (`Id_Employe`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1134 ;

--
-- Contenu de la table `employe`
--

INSERT INTO `employe` (`Id_Employe`, `Nom`, `Prenom`, `Cin`, `Date_Naissance`, `sexe`, `adresse`, `email`, `telephone`, `Date_Recrutement`) VALUES
(1119, 'Gabbadi', 'Abdelkarim', 'CD239711', '1995-06-08', 'M', 'Rabat Agdal	', 'abdelkarim.gabbadi@gmail.com', '06-51-12-31-71', '2016-05-27'),
(1121, 'k', 'k', 'kk5', '2016-05-27', 'M', '	ofk	f', 'aa@aa.aa', '06-77-77-77-77', '2016-05-27'),
(1122, 'jj', 'jj', 'jj', '2016-05-27', 'M', 'ok', 'ok@ok.ok', '06-88-88-88-88', '2016-05-27'),
(1132, 'a', 'a', 'a', '2016-05-28', 'M', 'a', 'aa@aa.aa', '06-__-__-__-__', '2016-05-28'),
(1133, 'diarra', 'youssouf', 'C220', '1993-09-11', 'M', 'Salé Bab Sebta', 'youssoufdiarra21@yahoo.com', '06-95-32-48-09', '2016-06-26');

-- --------------------------------------------------------

--
-- Structure de la table `exigence`
--

CREATE TABLE IF NOT EXISTS `exigence` (
  `id_Exigence` int(11) NOT NULL AUTO_INCREMENT,
  `Libelle` varchar(80) COLLATE utf8_bin NOT NULL,
  `Description` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_Exigence`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Contenu de la table `exigence`
--

INSERT INTO `exigence` (`id_Exigence`, `Libelle`, `Description`) VALUES
(1, 'Exigence 1', ' C:UsersyoussoufDesktopid itune.txt');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `id_message` int(11) NOT NULL AUTO_INCREMENT,
  `id_employe_Emet` int(11) NOT NULL,
  `id_employe_desti` int(11) NOT NULL,
  `date_envoie` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `text` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_message`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=35 ;

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`id_message`, `id_employe_Emet`, `id_employe_desti`, `date_envoie`, `text`) VALUES
(27, 1119, 1119, '2016-06-01 23:10:06', 'd'),
(28, 1119, 1132, '2016-06-02 01:57:41', 'hello'),
(29, 1119, 1122, '2016-06-02 01:57:54', 'hello ca va ?'),
(30, 1119, 1119, '2016-06-02 02:29:57', 'ùknfe\nfdzjkvns\nsdv!lndv\nzdv!'),
(31, 1119, 1119, '2016-06-02 02:32:25', 'ùknfe\nfdzjkvns\nsdv!lndv\nzdv!'),
(32, 1119, 1119, '2016-06-02 12:35:40', 'salut'),
(33, 1119, 1121, '2016-06-02 12:36:06', 'salut'),
(34, 1119, 1132, '2016-06-26 15:01:00', 'Salut comment cava bien?');

-- --------------------------------------------------------

--
-- Structure de la table `processus`
--

CREATE TABLE IF NOT EXISTS `processus` (
  `Id_Processus` int(11) NOT NULL AUTO_INCREMENT,
  `Libelle` varchar(80) COLLATE utf8_bin NOT NULL,
  `Description` text COLLATE utf8_bin NOT NULL,
  `Id_Exigence` int(11) NOT NULL,
  PRIMARY KEY (`Id_Processus`),
  KEY `Id_Exigence` (`Id_Exigence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE IF NOT EXISTS `profil` (
  `id_profil` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) COLLATE utf8_bin NOT NULL,
  `passwrd` varchar(30) COLLATE utf8_bin NOT NULL,
  `id_employe` int(11) NOT NULL,
  `role` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_profil`),
  UNIQUE KEY `id_employe` (`id_employe`),
  UNIQUE KEY `id_employe_2` (`id_employe`),
  UNIQUE KEY `id_employe_3` (`id_employe`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=147 ;

--
-- Contenu de la table `profil`
--

INSERT INTO `profil` (`id_profil`, `login`, `passwrd`, `id_employe`, `role`) VALUES
(119, 'Admin', 'admin', 1119, 'Admin'),
(143, 'Employe', 'employe', 1132, 'Employe'),
(144, 'Pilote', 'pilote', 1121, 'Responsable'),
(145, 'diarra21', 'diarra21', 1122, 'Admin'),
(146, 'Responsable', 'responsable', 1133, 'Responsable');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE IF NOT EXISTS `reclamation` (
  `Id_Reclamation` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(50) COLLATE utf8_bin NOT NULL,
  `Description` text COLLATE utf8_bin NOT NULL,
  `id_Employe` int(20) NOT NULL,
  `Id_Activite` int(11) NOT NULL,
  PRIMARY KEY (`Id_Reclamation`),
  KEY `id_Employe` (`id_Employe`),
  KEY `Id_Activite` (`Id_Activite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `suivie`
--

CREATE TABLE IF NOT EXISTS `suivie` (
  `id_Suivie` int(11) NOT NULL AUTO_INCREMENT,
  `id_Employe` int(11) NOT NULL,
  `id_Processus` int(11) NOT NULL,
  `rapport` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_Suivie`),
  KEY `id_Processus` (`id_Processus`),
  KEY `id_Employe` (`id_Employe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `action`
--
ALTER TABLE `action`
  ADD CONSTRAINT `action_ibfk_1` FOREIGN KEY (`id_Anomalie`) REFERENCES `anomalie` (`id_Anomalie`);

--
-- Contraintes pour la table `activite`
--
ALTER TABLE `activite`
  ADD CONSTRAINT `activite_ibfk_1` FOREIGN KEY (`Id_Processus`) REFERENCES `processus` (`Id_Processus`);

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_profile`) REFERENCES `profil` (`id_profil`);

--
-- Contraintes pour la table `anomalie`
--
ALTER TABLE `anomalie`
  ADD CONSTRAINT `anomalie_ibfk_1` FOREIGN KEY (`id_Processus`) REFERENCES `processus` (`Id_Processus`);

--
-- Contraintes pour la table `audit`
--
ALTER TABLE `audit`
  ADD CONSTRAINT `audit_ibfk_1` FOREIGN KEY (`id_Processus`) REFERENCES `processus` (`Id_Processus`);

--
-- Contraintes pour la table `processus`
--
ALTER TABLE `processus`
  ADD CONSTRAINT `processus_ibfk_1` FOREIGN KEY (`Id_Exigence`) REFERENCES `exigence` (`id_Exigence`);

--
-- Contraintes pour la table `profil`
--
ALTER TABLE `profil`
  ADD CONSTRAINT `FK_ProfilEmploye` FOREIGN KEY (`id_employe`) REFERENCES `employe` (`Id_Employe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `reclamation_ibfk_2` FOREIGN KEY (`Id_Activite`) REFERENCES `activite` (`Id_Activite`),
  ADD CONSTRAINT `reclamation_ibfk_3` FOREIGN KEY (`id_Employe`) REFERENCES `employe` (`Id_Employe`);

--
-- Contraintes pour la table `suivie`
--
ALTER TABLE `suivie`
  ADD CONSTRAINT `suivie_ibfk_1` FOREIGN KEY (`id_Processus`) REFERENCES `processus` (`Id_Processus`),
  ADD CONSTRAINT `suivie_ibfk_2` FOREIGN KEY (`id_Employe`) REFERENCES `employe` (`Id_Employe`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
