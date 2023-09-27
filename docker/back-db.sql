-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : Dim 13 mars 2022 à 14:31
-- Version du serveur :  8.0.21
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données : `back-java`
--
CREATE DATABASE IF NOT EXISTS `back-java` DEFAULT CHARACTER SET utf8;
USE `back-java`;

-- --------------------------------------------------------


--
-- Structure de la table `city`
--

DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_code` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `city`
--

INSERT INTO `city` (`id`, `post_code`, `name`, `country`) VALUES
(1, 57000, 'Metz', 'France'),
(2, 75000, 'Paris', 'France');

-- --------------------------------------------------------

--
-- Structure de la table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NOT NULL,
  `street` varchar(255) NOT NULL,
  `id_city` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_city` (`id_city`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `address`
--

INSERT INTO `address` (`id`, `number`, `street`, `id_city`) VALUES
(1, 10, 'rue de la forêt', 1),
(2, 17, 'rue du port', 2),
(3, 22, 'rue des près', 3),
(4, 17, 'rue de la gare', 2);

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lastname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `gender` int NOT NULL,
  `id_address` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_address` (`id_address`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `person`
--

INSERT INTO `person` (`id`, `lastname`, `firstname`, `birthdate`, `phone_number`, `gender`) VALUES
(1, 'Doe', 'John', '1990-12-12', '0601020304', 1),
(2, 'Jane', 'John', '1990-10-01', '0601020305', 1),
(3, 'Coilin', 'Marguerite', '1958-08-01', '0678954621', 0),
(4, 'Newton', 'Carole', '1978-08-10', '0678954621', 0),
(5, 'Newton', 'Isaac', '1974-08-07', '0688954621', 1);

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(2047) NOT NULL,
  `author_id` int NOT NULL,
  `published` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `post`
--

INSERT INTO `post` (`id`, `content`, `author_id`, `published`) VALUES
(1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis eros congue, tincidunt neque id, eleifend ex. Nullam ut felis sit amet nulla tristique facilisis. Aliquam ut libero tincidunt, fringilla tortor rutrum, tincidunt lacus. Cras eget urna quis nisi dignissim lacinia sed in mauris. Aliquam blandit mi a ipsum pulvinar pretium. Sed condimentum, sapien id ullamcorper rutrum, neque lorem aliquet odio, quis accumsan ligula nisi at turpis.', 1, '1990-12-12'),
(2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis eros congue, tincidunt neque id, eleifend ex. Nullam ut felis sit amet nulla tristique facilisis. Aliquam ut libero tincidunt, fringilla tortor rutrum, tincidunt lacus. Cras eget urna quis nisi dignissim lacinia sed in mauris. Aliquam blandit mi a ipsum pulvinar pretium. Sed condimentum, sapien id ullamcorper rutrum, neque lorem aliquet odio, quis accumsan ligula nisi at turpis.', 2, '1990-10-01');

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(2047) NOT NULL,
  `author_id` int NOT NULL,
  `published` date NOT NULL,
  `post_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `authorId` (`author_id`),
  KEY `post_id` (`post_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `comment`
--

INSERT INTO `comment` (`id`, `content`, `author_id`, `post_id`, `published`) VALUES
(1, 'CECI EST UN COMMENTAIRE 2', 1, 1, '1990-12-12'),
(2, 'CECI EST UN COMMENTAIRE 2', 2, 2, '1990-10-01');

-- --------------------------------------------------------

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;