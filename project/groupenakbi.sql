-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 10 déc. 2021 à 04:38
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `groupenakbi`
--

-- --------------------------------------------------------

--
-- Structure de la table `calendar`
--

CREATE TABLE `calendar` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `allday` tinyint(1) NOT NULL,
  `background_color` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `border_color` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `text_color` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `calendar`
--

INSERT INTO `calendar` (`id`, `title`, `start`, `end`, `description`, `allday`, `background_color`, `border_color`, `text_color`) VALUES
(2, 'majd salem', '2021-12-04 08:30:00', '2021-12-04 11:00:00', 'aaaaaaaaaaaaaaaa', 1, '#61d185', '#ff5733', '#4157f1'),
(3, 'vendredi', '2021-12-04 12:00:00', '2021-12-04 15:30:00', 'ce rendez vous est d\'une importance capitale', 0, '#5273f8', '#71e382', '#ffff00'),
(4, 'majdsalem2', '2022-01-01 10:00:00', '2016-01-01 11:00:00', 'une suite de notre seance le 4 decembre', 0, '#80ff00', '#000000', '#000000'),
(5, 'azerty', '2022-01-01 00:00:00', '2022-01-01 00:00:00', 'azaaaaaaaaaaaaaaaaa', 1, '#63c4e9', '#000000', '#000000');

-- --------------------------------------------------------

--
-- Structure de la table `categorie_evenement`
--

CREATE TABLE `categorie_evenement` (
  `id` int(11) NOT NULL,
  `nom_categorie` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `categorie_evenement`
--

INSERT INTO `categorie_evenement` (`id`, `nom_categorie`) VALUES
(1, 'categorie sante');

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL,
  `commentateur_id` int(11) NOT NULL,
  `message` varchar(2000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` date NOT NULL,
  `event_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `commentateur_id`, `message`, `date`, `event_id`) VALUES
(1, 1, 'hello', '2021-12-03', 9),
(2, 1, 'bravo c\'est bien', '2021-12-03', 9),
(3, 1, 'bravoooo', '2021-12-03', 11),
(5, 1, 'bonjour', '2021-12-03', 10),
(6, 1, 'merci beaucoup', '2021-12-06', 11),
(7, 1, 'bravooo', '2021-12-06', 16),
(8, 1, 'merci bien', '2021-12-06', 16),
(9, 1, 'salut', '2021-12-09', 10);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pwd` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `email`, `pwd`) VALUES
(1, 'arwa.douiri@esprit.tn', '1234');

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `contact`
--

INSERT INTO `contact` (`id`, `name`, `email`, `message`) VALUES
(1, 'test', 'habibekh97@gmail.com', 'test'),
(2, 'test', 'habibekh97@gmail.com', 'test'),
(3, 'test', 'habibekh97@gmail.com', 'test'),
(4, 'test', 'habibekh97@gmail.com', 'test'),
(5, 'test', 'habibekh97@gmail.com', 'test'),
(6, 'test', 'habibekh97@gmail.com', 'test'),
(7, 'test', 'habibekh97@gmail.com', 'test'),
(8, 'test', 'habibekh97@gmail.com', 'test'),
(9, 'test', 'habibekh97@gmail.com', 'test'),
(10, 'test', 'habibekh97@gmail.com', 'test'),
(11, 'test', 'habibekh97@gmail.com', 'test'),
(12, 'test', 'habibekh97@gmail.com', 'test'),
(13, 'test', 'habibekh97@gmail.com', 'test'),
(14, 'test', 'habibekh97@gmail.com', 'test'),
(15, 'test', 'habibekh97@gmail.com', 'f'),
(16, 'test', 'habibekh97@gmail.com', 'med'),
(17, 'test', 'habibekh97@gmail.com', 'ff'),
(18, 'test', 'habibekh97@gmail.com', 'ff'),
(19, 'test', 'habibekh97@gmail.com', 'ff'),
(20, 'test', 'habibekh97@gmail.com', 'ff'),
(21, 'test', 'habibekh97@gmail.com', 'ff'),
(22, 'test', 'habibekh97@gmail.com', 'ff'),
(23, 'test', 'habibekh97@gmail.com', 'ff'),
(24, 'test', 'habibekh97@gmail.com', 'ff'),
(25, 'test', 'habibekh97@gmail.com', 'ff'),
(26, 'test', 'habibekh97@gmail.com', 'ff'),
(27, 'test', 'habibekh97@gmail.com', 'ff'),
(28, 'test', 'habibekh97@gmail.com', 'ff'),
(29, 'test', 'habibekh97@gmail.com', 'ff'),
(30, 'test', 'habibekh97@gmail.com', 'ff'),
(31, 'test', 'habibekh97@gmail.com', 'ff'),
(32, 'test', 'habibekh97@gmail.com', 'ff'),
(33, 'test', 'habibekh97@gmail.com', 'ff'),
(34, 'gigi', 'habibekh97@gmail.com', 'gigi'),
(35, 'gigi', 'habibekh97@gmail.com', 'gigi'),
(36, 'gigi', 'habibekh97@gmail.com', 'gigi'),
(37, 'gigi', 'habibekh97@gmail.com', 'gigi'),
(38, 'gigi', 'habibekh97@gmail.com', 'gigi');

-- --------------------------------------------------------

--
-- Structure de la table `doctrine_migration_versions`
--

CREATE TABLE `doctrine_migration_versions` (
  `version` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20211112023917', '2021-11-26 00:08:02', 408),
('DoctrineMigrations\\Version20211112024301', '2021-11-26 00:08:03', 199),
('DoctrineMigrations\\Version20211124012817', '2021-11-26 00:10:39', 125),
('DoctrineMigrations\\Version20211129175121', '2021-11-29 18:51:35', 3673),
('DoctrineMigrations\\Version20211129183638', '2021-11-29 19:36:45', 902),
('DoctrineMigrations\\Version20211129183952', '2021-11-29 19:40:19', 160),
('DoctrineMigrations\\Version20211130211057', '2021-11-30 22:11:12', 3697),
('DoctrineMigrations\\Version20211130234646', '2021-12-01 00:47:45', 2277),
('DoctrineMigrations\\Version20211130235314', '2021-12-01 00:53:43', 604),
('DoctrineMigrations\\Version20211201212129', '2021-12-02 23:56:55', 427),
('DoctrineMigrations\\Version20211201222740', '2021-12-02 23:56:55', 2340),
('DoctrineMigrations\\Version20211201231203', '2021-12-02 23:56:58', 1516),
('DoctrineMigrations\\Version20211202005402', '2021-12-02 23:56:59', 264),
('DoctrineMigrations\\Version20211202205113', '2021-12-02 23:57:00', 1234),
('DoctrineMigrations\\Version20211202230054', '2021-12-03 00:01:10', 1072);

-- --------------------------------------------------------

--
-- Structure de la table `enligne`
--

CREATE TABLE `enligne` (
  `id` int(11) NOT NULL,
  `emailmed` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `emailpat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lien` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(11) NOT NULL,
  `titreeven` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descriptioneven` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_fin` date NOT NULL,
  `lieu_even` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `invites` int(11) NOT NULL,
  `responsable` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_debut` date NOT NULL,
  `filename` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `titreeven`, `descriptioneven`, `date_fin`, `lieu_even`, `invites`, `responsable`, `date_debut`, `filename`, `updated_at`) VALUES
(9, 'vaccin', 'dangereux', '2023-11-20', 'tunis', 15, 'clinique sokra', '2019-03-16', 'xe0XSvm-one-piece-wallpaper-1920x1080.jpg', '2021-12-03 00:45:13'),
(10, 'sport', 'bienn', '2022-11-19', 'siliana', 29, 'lotfi', '2021-01-01', 'tFJqSsf-bleach-wallpaper-1920x1080.jpg', '2021-12-03 00:46:25'),
(11, 'mmmm', 'hhhhhh', '2022-10-01', 'ariena', 13, 'ala', '2018-01-30', 'SIp1qrk-bleach-wallpaper-1920x1080.jpg', '2021-12-03 00:47:36'),
(12, 'bbbb', 'nnnnn', '2025-01-29', 'nabeul', 23, 'ahmed', '2018-03-01', 'VVBsggo-bleach-wallpaper-1920x1080.jpg', '2021-12-03 00:48:29'),
(13, 'bbbb', 'bien', '2026-09-01', 'beja', 26, 'majd', '2021-03-17', 'UZbwoVk-bleach-wallpaper-1920x1080.jpg', '2021-12-03 00:49:34'),
(14, 'nnnn', 'ffff', '2020-05-01', 'achref', 18, 'yasin', '2019-04-03', 'NF3PO73-one-piece-wallpaper-1920x1080.jpg', '2021-12-03 10:53:47'),
(15, 'sportif', 'le sport est une chose necessaire', '2023-12-01', 'siliana', 25, 'louti', '2021-01-17', 'VVBsggo-bleach-wallpaper-1920x1080.jpg', '2021-12-06 22:10:40'),
(16, 'sante', 'tres bien', '2024-01-19', 'tatouine', 40, 'achref', '2018-01-30', 'Mpmu2YI-bleach-wallpaper-1920x1080.jpg', '2021-12-06 22:13:48'),
(17, 'event1', 'test', '2018-01-01', 'tunis', 1, 'Mohamed', '2016-01-01', NULL, '2021-12-09 23:05:43'),
(18, 'event1', 'test', '2016-01-18', 'tunis', 1, 'Mohamed', '2016-01-01', NULL, '2021-12-09 23:07:37'),
(19, 'event1', 'test', '2017-01-17', 'tunis', 1, 'Mohamed', '2016-02-01', NULL, '2021-12-10 00:50:45'),
(20, 'sante', 'test', '2025-01-01', 'tunis', 1, 'Mohamed', '2016-03-01', NULL, '2021-12-10 00:51:22');

-- --------------------------------------------------------

--
-- Structure de la table `evenement_user`
--

CREATE TABLE `evenement_user` (
  `evenement_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `evenement_user`
--

INSERT INTO `evenement_user` (`evenement_id`, `user_id`) VALUES
(9, 1),
(10, 1),
(11, 1),
(12, 1);

-- --------------------------------------------------------

--
-- Structure de la table `evenement_user_event`
--

CREATE TABLE `evenement_user_event` (
  `evenement_id` int(11) NOT NULL,
  `user_event_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `formulaire`
--

CREATE TABLE `formulaire` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description_symptomes` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sexe` varchar(99) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `formulaire`
--

INSERT INTO `formulaire` (`id`, `nom`, `prenom`, `adresse`, `age`, `description_symptomes`, `Sexe`) VALUES
(3, 'sabri', 'krima', 'aaa', '31-25-1998', 'jsndqnc', 'Homme'),
(8, 'mohamed', 'fatnasa', 'monastir', '25', 'qsdqsd', ''),
(13, 'yassine', 'kab', 'tunis', '25', 'sdf', ''),
(16, 'qsdqs', 'qsd', 'qsd', 'qsd', 'qsd', ''),
(17, 'fd', 'sdf', 'sdf', 'sdf', 'sdf', ''),
(18, 'fd', 'sdf', 'sdf', 'sdf', 'sdf', ''),
(19, 'fd', 'sdf', 'sdf', 'sdf', 'sdf', ''),
(20, 'fd', 'sdf', 'sdf', 'sdf', 'sdf', ''),
(21, 'qsd', 'qd', 'dq', 'qd', 'qd', ''),
(22, 'habib', 'yahya', 'sousse', '28', 'sddsds', ''),
(23, 'bilel', 'sqdf', 'dqsf', 'qsd', 'hjqdgklsfskldsdf', ''),
(24, 'wxc', 'wxc', 'wc', 'wxc', 'wxc', ''),
(25, 'ammar', 'swayah', 'sousse', '25', 'sdjkfjskdf', ''),
(26, 'amar', 'jmal', 'monastir', '25', 'qsdqsdqsdqsdqsdqsdqsd', ''),
(27, 'amar', 'hosim', 'sousse', '28', 'j \' ai mal a tete', ''),
(28, 'qsd', 'qsd', 'qd', 'qsd', 'qsd', ''),
(29, 'esprit', 'nakbi', 'monastir', '29', 'j\' ai mal a tete', ''),
(30, 'qsdqd', 'nakbi', 'yassine', '25', 'qsdq', ''),
(31, 'nakbi', 'yassine', 'mahdia', '25', 'j ai mal a tet', ''),
(32, 'yas', 'sd', 'sdf', '28dsfsd', 'sdf', ''),
(33, 'hh', 'dtfg', 'gffg', '25', '445', ''),
(34, 'qsd', 'qsd', 'sdf', '25', 'sdf', ''),
(36, 'nakbi', 'sfdsdf', 'sdf', '25', 'dfsdf', ''),
(37, 'Mohamed', 'Khattat', 'test', '23', 'desc', ''),
(38, 'aaa', 'aaaa', 'aaaa', '23', 'medme', 'Femme'),
(39, 'med', 'med', 'test', '23', 'desc', 'Homme');

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `id_medecin` int(20) NOT NULL,
  `specialite_medecin` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `profanities`
--

CREATE TABLE `profanities` (
  `id` int(11) NOT NULL,
  `word` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `property_search`
--

CREATE TABLE `property_search` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `questionss`
--

CREATE TABLE `questionss` (
  `id` int(11) NOT NULL,
  `question1` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `question2` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `question3` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `question4` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `question5` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `question6` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `question7` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `questionss`
--

INSERT INTO `questionss` (`id`, `question1`, `question2`, `question3`, `question4`, `question5`, `question6`, `question7`) VALUES
(1, 'Je ne sais pas', 'Non', 'Je ne sais pas', 'Non', 'Je ne sais pas', 'Non', 'Je ne sais pas'),
(2, 'Oui', 'Je ne sais pas', 'Non', 'Je ne sais pas', 'Non', 'Oui', 'Je ne sais pas'),
(3, 'Oui', 'Je ne sais pas', 'Non', 'Non', 'Je ne sais pas', 'Oui', 'Oui'),
(4, 'Oui', 'Je ne sais pas', 'Non', 'Non', 'Je ne sais pas', 'Oui', 'Oui'),
(5, 'Je ne sais pas', 'Oui', 'Je ne sais pas', 'Je ne sais pas', 'Oui', 'Oui', 'Je ne sais pas'),
(6, 'Non', 'Je ne sais pas', 'Je ne sais pas', 'Je ne sais pas', 'Non', 'Non', 'Je ne sais pas'),
(7, 'Oui', 'Non', 'Je ne sais pas', 'Non', 'Je ne sais pas', 'Non', 'Je ne sais pas'),
(8, 'Je ne sais pas', 'Oui', 'Non', 'Non', 'Oui', 'Je ne sais pas', 'Oui'),
(9, 'Je ne sais pas', 'Non', 'Je ne sais pas', 'Oui', 'Je ne sais pas', 'Non', 'Non');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_reponse` varchar(255) DEFAULT NULL,
  `object` varchar(50) NOT NULL,
  `status` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `screenshot` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `$category` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`id`, `id_user`, `id_reponse`, `object`, `status`, `description`, `screenshot`, `email`, `$category`) VALUES
(163, 1, '43', 'sdqs', 'traiter', 'dsd', 'sdq', 'houssem095@gmail.com', NULL),
(164, 1, '44', 'sdsds', 'traiter', 'sqddsq', 'sqdsqd', 'houssem095@gmail.com', 'Bug'),
(165, 1, '45', 'sqdqsd', 'traiter', 'sqddq', 'sqdsqd', 'houssem095@gmail.com', 'Other'),
(166, 1, '47', 'sqdqsd', 'traiter', 'sqdqsd', 'sdqsd', 'houssem095@gmail.com', 'Event'),
(167, 1, '48', 'aaaaaaaaaaa', 'traiter', 'aaaaaaaaaaaa', 'azeaze', 'houssem095@gmail.com', 'Other'),
(168, 1, '49', 'z', 'traiter', 'z', 'z', 'houssem095@gmail.com', 'Other'),
(169, 1, '51', 'nadine', 'traiter', 'azdd', 'azeaze', 'houssem095@gmail.com', 'Event'),
(170, 1, '50', 'z', 'traiter', 'zdzqdzqdqz', 'dqzdqz', 'houssem095@gmail.com', 'Event'),
(171, 1, NULL, 'a', 'non traiter', 'a', 'a', 'houssem095@gmail.com', 'Bug'),
(172, 1, NULL, 'z', 'non traiter', 'z', 'z', 'houssem095@gmail.com', 'Event'),
(173, 1, NULL, 'z', 'non traiter', 'z', 'z', 'houssem095@gmail.com', 'Event'),
(174, 1, NULL, 'z', 'non traiter', 'z', 'z', 'houssem095@gmail.com', 'Event'),
(175, 1, NULL, 'z', 'non traiter', 'z', 'z', 'houssem095@gmail.com', 'Event'),
(176, 1, NULL, 'z', 'non traiter', 'z', 'z', 'houssem095@gmail.com', 'Event'),
(177, 1, NULL, 'z', 'non traiter', 'z', 'z', 'houssem095@gmail.com', 'Event'),
(178, 1, NULL, 'z', 'non traiter', 'z', 'z', 'houssem095@gmail.com', 'Event'),
(179, 1, NULL, 'z', 'non traiter', 'z', 'z', 'houssem095@gmail.com', 'Event'),
(180, 1, NULL, 'z', 'non traiter', 'z', 'z', 'houssem095@gmail.com', 'Event'),
(181, 1, NULL, 'zd', 'non traiter', 'zd', 'zd', 'houssem095@gmail.com', 'Event'),
(182, 1, NULL, 'zaazaz', 'non traiter', 'zazaz', 'zazaz', 'houssem095@gmail.com', 'Event'),
(187, 1, '53', 'houssem', 'traiter', 'ddd', 'dd', 'houssem095@gmail.com', 'Event'),
(188, 1, NULL, 'today', 'non traiter', 'i want to ?????', 'azert', 'houssem095@gmail.com', 'Event'),
(189, 1, '54', 'azertyu', 'traiter', 'azertyu', 'azeazeaze', 'houssem095@gmail.com', 'Other');

-- --------------------------------------------------------

--
-- Structure de la table `rendez_vous`
--

CREATE TABLE `rendez_vous` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `category` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `rendez_vous`
--

INSERT INTO `rendez_vous` (`id`, `nom`, `telephone`, `email`, `category`, `description`) VALUES
(1, 'majd', '50951499', 'majdas@esprit.com', 'generaliste', '19.01.2022 en ligne'),
(2, 'mayssen', '50465899', 'didda@hotmail.fr', 'biologiste', '10.01.2022 10h-14h'),
(3, 'asmail', '22336655', 'asmail@gmail.com', 'ophtamologue', '19-36-36-99-89');

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE `reponse` (
  `id` int(11) NOT NULL,
  `text` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reponse`
--

INSERT INTO `reponse` (`id`, `text`) VALUES
(20, 'reponse objet1'),
(21, 'Reponse2'),
(22, 'rep3'),
(23, 'reponse aaaaaaaaa'),
(24, 'hhhhhhhhhh'),
(25, 'NCHALLAH LBS'),
(26, 'i cant do anythink for you :)'),
(27, 'sss'),
(28, 'd'),
(29, 'azerty'),
(30, 'aze'),
(31, 'DDDDDD'),
(32, 'jawik bahy'),
(33, 'ftftft'),
(34, 'c bon'),
(35, 'tfg'),
(36, 'tfg'),
(37, 'tfg'),
(38, 'done'),
(39, 'ok'),
(40, 'ok'),
(41, 'ddd'),
(42, 'ddd'),
(43, 'zssssqsqqqqqqqqqqqqqqqqqqqqqqqq'),
(44, 'you must use'),
(45, 'z'),
(46, 'ok'),
(47, 'ok'),
(48, 'ok'),
(49, 'aaaaaaaaa'),
(50, 'okddd'),
(51, 'done'),
(52, 'ok'),
(53, 'ok'),
(54, 'done');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `ID` int(20) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) DEFAULT NULL,
  `datenaissance` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `numerotelephone` varchar(50) DEFAULT NULL,
  `adresse` varchar(20) NOT NULL,
  `specialite` varchar(30) NOT NULL,
  `role` varchar(30) DEFAULT NULL,
  `image` varchar(255) NOT NULL,
  `updated_at` datetime NOT NULL,
  `roles` longtext NOT NULL COMMENT '(DC2Type:json)'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`ID`, `Nom`, `Prenom`, `datenaissance`, `email`, `password`, `numerotelephone`, `adresse`, `specialite`, `role`, `image`, `updated_at`, `roles`) VALUES
(395, 'nnnnnnn', 'hhhh', '2016-01-01', 'hhh@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$VjdTS2o3NFFhTG5JWkUzTA$vLMBJHX9RjI0eA1roUOhBFg9dbWgOd/t31hZAvFirtA', '33333333', 'tunis', 'Null', 'patient', '86601669_637508523715920_5150143160634048512_n.jpg', '2021-12-03 12:57:29', 'null'),
(394, 'AHMED', 'BENAHMED', '2016-01-21', 'AHMED@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$RWFVNVVrT2F6Z25sNGFqQw$W//PBKprBS/sIiNimI0Wy8XxUZ+ErZmOhiOMKXEE0Ec', '23456789', 'tunis', 'Null', 'patient', '0e734b3049d486801cf3368830e950aa.jpg', '2021-12-03 11:06:58', 'null'),
(393, 'ab', 'abbb', '2016-01-01', 'abdddd@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$VlNzLlBRZVNnZkR5MnRNUw$rP1PrSw8/QIaEufTlfNEGBmGRCz9ZaJwMILVxQShLAc', '44556633', 'tunissss', 'Null', 'patient', 'Annotation 2020-04-12 124753.jpg', '2021-12-03 11:00:03', 'null'),
(392, 'ab', 'abbb', '2016-01-01', 'ab@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$RFFQL0d4NFFIci5ianhGNw$Ec+SkWgPwHOZUD2sTnvGU7vPzT7fFObQqkm0lazqr1s', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(391, 'ismail', 'hash', '2016-01-01', 'ismil@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$Uy95WmY2S1p6V1BRQzUuZQ$/GLu4CmLm17yRFB/nJnPtwRVXEoGcf6mX8hdVw648rk', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(449, 'douiri', 'arwa', '2016-01-01', 'arwa.d@gmail.tn', 'nnnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(450, 'douiri', 'arwa', '2016-01-01', 'arwa.ghg@gmail.tn', 'nnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(341, 'ben', 'asma', '2021-11-25', 'asma@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$MVYyQURka3RIZnRvYUpWcQ$VY7pZgDXbNvlUsRdowSK2m/yhtcnb0lAm8DxTDmKHQE', '12345645', 'tunis', 'gynecologue', 'medecin', '', '0000-00-00 00:00:00', '[\"ROLE_ADMIN\"]'),
(342, 'asma', 'asma', '2016-01-01', 'asmabbn@gmail.com', 'nnnnn', '344556633', 'tunissss', 'medecin', 'patient', '', '0000-00-00 00:00:00', 'null'),
(483, 'douiri', 'arwa', '2016-01-01', 'MOLIklkLi@gmail.tn', 'nnnnnnn', '34567890', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(345, 'benismail', 'ismail', '2016-01-25', 'ismail@gmail.com', 'nnnnn', '234543', 'ariana', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(347, 'arij', 'barij', '2009-05-12', 'benfouleni@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$d0xTU2daaVd2WnEvcFhnMQ$2GYmJezOh9ITtIWaKUU/8lYMrL6Cs1kt88ouWd6fCiY', '33333333', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(348, 'arwaa', 'arwaaaaa', '2016-01-01', 'arwaadd.douiri@gmail.tn', 'aaaaaa', '223444', 'eeeee', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(349, 'douiri', 'mohamed', '2016-01-01', 'mohamed@gmail.tn', 'nnnnn', 'nnnnnnn', 'tunis', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(350, 'benanis', 'anis', '2016-01-19', 'anis@gmail.tn', 'hhhhhh', '12223333', 'tunsi', '', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(351, 'ismail', 'smile', '2016-01-01', 'smile@gmail.tn', 'nnnnnn', '122333', 'tunis', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(355, 'asma', 'asma', '2016-01-01', 'asmnjhha@gmail.com', 'nnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(354, 'asma', 'asma', '2016-01-01', 'asmannn@gmail.com', 'nnnnnn', 'nnn', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(356, 'aaaadd', 'dddd', '2016-01-01', 'benfouleninhhh@gmail.tn', 'nnnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(357, 'asma', 'asma', '2016-01-01', 'asmanhhgh@gmail.com', 'nnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(358, 'asma', 'asma', '2016-01-01', 'asmannnnnnn@gmail.com', 'jjjjjjj', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(359, 'aaaadd', 'dddd', '2016-01-01', 'benfoulennnni@gmail.tn', 'nnnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(378, 'medecin', 'medecin', '2016-01-06', 'medecin.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$d3U5WDFrM0hRSTdGRHlxaQ$Sm10c0Vr7sr9hFftQrq4XJ19Tlp5YO6Q9nyfT91YqRU', '44556633', 'tunissss', 'pediatrie', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(377, 'douiri', 'arwa', '2016-01-01', 'arwannnnnhgg.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$TlBvV1oyNTdzb1lJaVJrNA$pwBkvM7iLEl8+6zKbGimIA2m9wwNUsoth1LFf+nnY6k', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(370, '', NULL, NULL, 'arwa112.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$aHZhWGFnVDd4L1RsclBFSg$BBLFRKmbCeS+9VvhRAmQkE2iQCHlH18ZEYvc8yByom8', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(371, 'islemm', 'is', '2016-01-01', 'islem@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$VjRrSERRZU1YdzBwT3FiWA$dhzX93kRgMq3XuHK8OmPrHpQb8v6WySAojgwkt0YJRk', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(372, 'eeee', 'hhh', '2016-03-01', 'samsoum.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$QS8zM0FTLnJBWlpPVTVkNA$10NnRpnmkOnsu0WkGXFbuMuqe79vWF4V/oS0yMJsWIA', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(373, 'asma', 'asma', '2016-01-01', 'asmannnnnnnn@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$UHRlcmpMZ1E2Uzhwb0xycg$EM1dMhCqY2jscIFHLB+UmF/Cqs8d60ox2BXhe0EqKNY', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(374, 'asma', 'asma', '2016-01-01', 'asmahhhh@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$MFZyMXA5cFI1LkFWSXQ4Vg$/1ORgTTxfHX/lJKUXr3f1CMZXE1NnKHqTD9HjlFH1bI', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(375, 'douiri', 'arwa', '2016-01-01', 'arwanhjhh.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$eUxWbVdXYTI3NVNYc1NyNA$i2yXLFgq5CmT8meRNYsZ/yzcBGFuiVc/7cZNbjdmV84', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(376, 'islem', 'islem2', '2016-03-18', 'islemmmmm.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$SWtpQnREZm1UQ0t0TE9TRA$jYmuoNjHLxU6HB9f/QgWtCe2iGnhtHAPCTtQao1csns', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(379, 'aminooo', 'aminooo', '2016-04-01', 'amine@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$MlRpdTdMUDIveHNWQVM0bA$8BRtXxI5zdSW6QX14OU1vL1IoKnaQ32MxnO5o3twThU', '22222222', 'ariana', 'Null', 'patient', '86773263_1017686055271073_2016496375356719104_n.jpg', '2021-11-30 20:51:40', 'null'),
(380, 'douiri', 'arwa', '2016-01-01', 'ag@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$aVEuRVNRME4zN2FxSzJqQg$bY9/sOSjleNS2kx4to6cqDXy4BpTOVmgSXw+MdNyxl8', '44556633', 'tunissss', 'Null', 'patient', '86773263_1017686055271073_2016496375356719104_n.jpg', '2021-11-30 20:54:47', 'null'),
(381, 'douiri', 'arwa', '2016-01-01', 'jhhgg@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$bTkyWUxnU3V0YTl3dEpEcw$TlwawPfXwRdGqtMSzsmbtFuovZZ/Sf3G2prAQNErmj8', '44556633', 'tunissss', 'Null', 'patient', '86773263_1017686055271073_2016496375356719104_n.jpg', '2021-11-30 21:25:26', 'null'),
(382, 'douiri', 'arwa', '2016-01-01', 'kjhhhji@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$akJQZG1OLzM0UmhJNUhlbA$1FBj32olDP4g67ISj5fp2XrlHm6S9L6RVvbGcgWzPJQ', '44556633', 'tunissss', 'Null', 'patient', '86773263_1017686055271073_2016496375356719104_n.jpg', '2021-11-30 21:33:58', 'null'),
(383, 'douiri', 'arwa', '2017-05-01', 'k@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$a0pBZjBSNzVBaEY1Y201Vw$yNOKZR5IpTLgLfWyi5d+GWstkq/d5q66lyrMTNQSegY', '44556633', 'tunissss', 'Null', 'patient', '86773263_1017686055271073_2016496375356719104_n.jpg', '2021-11-30 21:47:27', 'null'),
(384, 'douiri', 'arwaaa', '2016-01-01', 'arwa@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$TjE0UzRHbEZRRHVSRlpXZw$rFB382ny8vjKXwduf1+WpqNQoBU/jylqCT9ihed5FwA', '33333333', '1ben arous', 'Null', 'patient', '9-3d-robot-character-design.jpg', '2021-12-01 21:11:43', 'null'),
(385, 'llll', 'kkk', '2016-01-01', 'arwanbhg.douiri@gmail.tn', 'NNNNN', '344556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(386, 'Dridi', 'hasan', '2016-01-01', 'hasa@gmail.tn', 'nnnnn', '34567890', 'Tunisie', 'gynecologue', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(387, 'kamoun', 'hanen', '2016-01-01', 'hanen@gmail.tn', 'ggggg', '344556633', 'tunissss', 'gynecologue', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(396, 'douiri', 'arwa', '2016-01-01', 'arwaJJJJJ.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$UDBaNnRpTkJaSHp1aC9FLg$CoCVg9njaKuKGg0YeUjWIgS1QTvJ4t9FQMgLLHK/OAc', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(397, 'NNNNN', 'HHHHH', '2016-01-01', 'hhHHGh@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$bUp2aWpXRzFSTk9zR1lHZg$RysCmCQfxTmpWvARfHhafjszkl5iQxcQLceFgm/vcW4', '44556633', 'tunissss', 'biologiste', 'medecin', 'Annotation 2020-04-18 172634.jpg', '2021-12-03 13:05:41', 'null'),
(398, 'NNNNN', 'HHHHH', '2016-01-01', 'hhHhhhhHGh@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$d09xT3BxZXcxck45Wi5QUw$GN+g/yGJALOT9ehP+C7eq9h00HJOyEZjujz0EzFWyIQ', '44556633', 'tunissss', 'biologiste', 'medecin', 'Sans titre.png', '2021-12-03 13:07:01', 'null'),
(399, 'asma', 'asma', '2016-01-01', 'asmbnahgff@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$Wi9NZmQ4QVhBM1IxL0duaQ$utJq9RoP9ctnXnhYk3H/r5EytLsGBCggBOqEc865q5A', '44556633', 'tunissss', 'biologiste', 'medecin', 'sf2-banner.jpg', '2021-12-03 13:09:19', 'null'),
(400, 'asma', 'asma', '2016-01-01', 'asmbnhgggahgff@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$MkJDNjQydklYOVZmYlozMw$XRb45gA2ObpgSPWQorKJUYGfgJ4MPQiLizsB2KA5XqM', '44556633', 'tunissss', 'biologiste', 'medecin', 'Top-Reports-for-Scrum-Masters-in-Jira-1024x704.png', '2021-12-03 13:10:47', 'null'),
(401, 'asma', 'asma', '2016-01-01', 'asmbnhgghhgahgff@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$bGgxdUpHQjRqbHVqeTNVUg$njBu0GeOE8R9Sm15nxzGJWlnbNAtJrQfotq+N8Hos6U', '44556633', 'tunissss', 'biologiste', 'medecin', 'Annotation 2020-03-06 101021.jpg', '2021-12-03 13:13:49', 'null'),
(402, 'douiri', 'arwa', '2016-01-01', 'arwannnggff.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$OVlkTi9hZmxBQVR0WTZWMQ$LNS2ORHthB6dKgsyw5q0htJllgttKhfKANfA4F6Jbv4', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(403, 'asma', 'asma', '2016-01-01', 'asmhgcdva@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$Sm0xUDhQOFVvZk1WN3ZuRw$KZ8eOjX6YoLWv/ViXpQ5wDYeTzWUAVNajSlWu6k+hEw', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(404, 'asma', 'asma', '2016-01-01', 'asmhgcdvahhhh@gmail.com', 'nnnnn', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(405, 'asma', 'asma', '2016-01-01', 'asmhgcdvhhhahhhh@gmail.com', 'nnnnn', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(406, 'asma', 'asma', '2016-01-01', 'asmjjjhgcdvhhhahhhh@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$VFZwdGZqYWJaaENhSlNjag$G5Yc/VyznjW6KfjSj2Z5dfzXS/vYOhS/ZXY54rIhAfY', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(407, 'asma', 'asma', '2016-01-01', 'asmjjjhgchdvhhhahhhh@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$cU0yY2UuVEV6QVAwYTJnaA$tjUp0wxMxN3+IIo3erile5kKpniaAofoTIL3U9hzRh4', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(408, 'asma', 'asma', '2016-01-01', 'asmjjhhjhgchdvhhhahhhh@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$eTAzUndtZy4uaVJnTkhxZQ$DaLH7yIjBFWGon0qNU/1kEWTqipEUOxsMHZa2+dgmVc', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(409, 'asma', 'asma', '2016-01-01', 'asmhgfdfghja@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$NWNpWXpvSHI3TFhwSUxzWA$Fwvj0jIS/qxmorNHlXWlRsegEHDdYag7FqRH9uk7foU', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(410, 'asma', 'asma', '2016-01-01', 'asmjhhhgfdfghja@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$SGluYlNIc0piWWJCc3hBQQ$mLDNtUmIMU4DL8lPeDPF899vDVFIDwQkdShHbg/byJc', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(411, 'asma', 'asma', '2016-01-01', 'asmgggjhhhgfdfghja@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$bk9sSzd2dnI0aldCNFljZg$D/vbh3n28G4b0FCwLIrUeTweGcReuSTAw6RY25MVAIY', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(412, 'asma', 'asma', '2016-01-01', 'asmgjhjggjhhhgfdfghja@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$dnFvSC96MXVDSFEvb3RCMQ$L7y0OMSlNigzM/uw15x51SvF4IAOotczb2J1CDe6q1U', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(413, 'asma', 'asma', '2016-01-01', 'asggffmgjhjggjhhhgfdfghja@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$U1I3bDBFQk1scXBKcTE5VQ$+bfFc3mWi+K9jv/wdhCjw8cSoiv/HE5/r9yS0fZlfgA', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(414, 'asma', 'asma', '2016-01-01', 'agggsggffmgjhjggjhhhgfdfghja@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$R1FiTFEvTlp5SGVBWTZWWg$j9X1n/kbPOA+fv+5lOCGQzWjL6Q1z55QaHQd8+scJ+E', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(415, 'asma', 'asma', '2016-01-01', 'agggsjjjggffmgjhjggjhhhgfdfghja@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$N3RwUFlqb2Vid3BBaUtWSg$/lWYpbVPxoEb62cpYSY3grbZG8tWW8o8KEkrU1+8iMs', '44556633', 'tunissss', 'gynecologue', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(416, 'asma', 'asma', '2016-01-01', 'ag@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$bTNSV1dQbjFURXlEYXl1Rg$+YGZTqpOFMHOOtSYdmXJEneBn5+2VimReX7oJWEkfOw', '44556633', 'tunissss', 'gynecologue', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(417, 'asma', 'asma', '2016-01-01', 'agggg@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$VjN5N21MejkzYW9mTU82MA$LKl2eV3xKaddOr4HOLNEV9NVQg8aS7V2UcKRyDOaQ/4', '44556633', 'tunissss', 'gynecologue', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(418, 'asma', 'asma', '2016-01-01', 'asgfffma@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$VDZ2YzJOY1FCcXdITE5iZg$fmHwTzDS5TKgTNSfgMoY2iU6sRSeW5RIlu4Q81X7dVg', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(419, 'asma', 'asma', '2016-01-01', 'ashgghgfffma@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$akpucEdDNm04dDBnVmhjbQ$AuznN/Cb5NA5gpfnpfANv9IQ8M/QihCbaNOged0zxwc', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(420, 'douiri', 'arwa', '2016-01-01', 'arwa.dohffduiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$S2hMb3B5MWtHejc5M0l3Ng$au5gDbgDBnV500tD6lyGFCj31hTiPiyesjJU1QiBCkI', '44556633', 'tunissss', 'Null', 'patient', 'Top-Reports-for-Scrum-Masters-in-Jira-1024x704.png', '2021-12-03 16:50:52', 'null'),
(421, 'douiri', 'arwa', '2016-01-01', 'arwa.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$TEQwblRMVzlFN2lidXZxSw$x8UhzluZck9hvESxa8jJdf2JdUaqmKlD82wEZ2M0hww', '44556633', 'tunissss', 'Null', 'patient', '61aa5a02c86fb_gettyimages-992018186-612x612.jpg', '2021-12-03 18:55:14', 'null'),
(422, 'douiri', 'arwa', '2016-01-01', 'arwHGa.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$eXVWQWF5eFZEMHIxMnRZNg$nbYuA5BlBpc0Ec3Pe+cHu5UPYIlGAvH4nRLxJrRyZBE', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(423, 'douiri', 'arwa', '2016-01-01', 'arfgfhfwa.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$Vy4vVUtvWk9oWW9rOXhscg$E0h3BTVz3Nwz0LmRAdGdQSLPg4VoRkdt6PvhxcbMHGY', '44556633', 'tunissss', 'Null', 'patient', '61aa675e9b3cf_sf2-banner.jpg', '2021-12-03 19:52:14', 'null'),
(424, '', NULL, NULL, 'benjileni@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$eE93N05KdzBhYmNmck9LMQ$f4aymcqE3yMEtJBJ40j1Nc2k8FmrY6ILUDMVr9AcuBY', NULL, '', '', NULL, '86710950_125396792190556_5013671356487696384_n.jpg', '2021-12-04 11:49:22', 'null'),
(425, '', NULL, NULL, 'jileni@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$a1dncDVydFhQd3JPN3JrVg$AJJihxMbz0PW/XEiEnw+AiopsuwPM+xylqMms0YXOg4', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(426, '', NULL, NULL, 'nnn@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$eks0bWttTjdOZDhHVjQ3ZA$f1pJEhQYSlUb78YhqeKjLy0+VATXGDD40B0/PPKvZjQ', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(427, '', NULL, NULL, 'jankon@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$ZGdQS1pra1JIUEU2TGY1Zw$xk/YbIl/xChg/F7s24uj5GknSxLM+mf1idd6zm57/eA', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(428, '', NULL, NULL, 'joko@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$cS5tVVNucGYuUTN2WElEQg$DKmAy8MzLSxPlJYtVjxWPLO0ygv3CHVVgc5bG9zLpo8', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(429, '', NULL, NULL, 'jokobo@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$VEZ0S2dKVVhTcjF5M1lXSA$kf2g0Y8VLNGp9wG5+UecKoGRXMsRY/7gO6N075fDMQA', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(430, '', NULL, NULL, 'hhh@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$STZEbHdLc2wvSTI3WEN0bw$cEEkrPNVk71SDhzUeBf+xKq8x4QIB6x66f+DfwShtCg', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(431, '', NULL, NULL, 'hhh@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$ZjQ0MWFxcVUzWlhnaElUeQ$6S7V+1F3JZbwF24OGCrrf22ZLmev4KgPJFflV76iJto', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(432, '', NULL, NULL, 'arwa.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$ek9wVi5TUklrc3lOWGUxMw$QIJSP3EajzccwEyj5bxWYzgEEUM6EF3PDGs2AwYuD5o', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(433, '', NULL, NULL, 'arwa.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$L0RLOU5mY2wyNkhVNG1MZw$f3iPLYr7Y1kup2ydznO2visvmXp2L+iJMYfOlOlB/HM', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(434, '', NULL, NULL, 'arwa.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$RkhOSzA1cTJRcWJOZExUdQ$IscZWKFtF64fZABT03qxic01RlkjCImV+L2xMK5bUIQ', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(435, '', NULL, NULL, 'nnn@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$ZkxSOHRHUUNZU1dsOE01RQ$/79WyizwHJ7Q80vUIdrIEN1TV4VVY5qGmVQUE8Dx9YE', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(451, 'douiri', 'arwa', '2016-01-01', 'douiri.arwa1998@gmail.com', 'HHHHHHH', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(452, 'douiriH', 'arwa', '2016-01-01', 'HGHG@gmail.tn', 'NNNNNN', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(453, 'douiri', 'arwa', '2016-01-01', 'arwa.hgfffdouiri@gmail.tn', 'nnnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(454, 'douiri', 'arwa', '2016-01-01', 'ab@gmail.tn', 'nnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(455, 'douiri', 'arwa', '2016-01-01', 'arwa.douiri@esprit.tn', 'nnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', '[\"ROLE_ADMIN\"]'),
(456, 'douiri', 'arwa', '2016-01-01', 'arwaHG.douiri@gmail.tn', 'nnnnnn', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(457, 'douiri', 'arwa', '2016-01-01', 'arwaHHGG.douiri@gmail.tn', 'NNNNNNN', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(458, 'douiri', 'arwa', '2016-01-01', 'arwaHHGhghG.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$Y25GU1VqNXExQ05PeEdkVg$4KXztduPM7qq5Iv2xZhMVZO8MquLhe81fyE5HcxRoAY', '44556633', 'tunissss', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(460, 'douiri', 'arwa', '2016-01-01', 'arwkhha.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$STJSQkk2RFZ1Mnkvdkp6bQ$N09DYsluE+SZzA6+4uNV9b3oOfki8Ret/ii0z4AjGaM', '44556633', 'tunissss', 'gynecologue', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(459, 'douiri', 'arwa', '2016-01-01', 'arwgfgffga.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$UC45bnlNRTlCa2cxWU01Nw$rVdNKLdafyg2Nq1qLQz3Lkf+B1fAM87a28KJ62BFZ4o', '44556633', 'tunissss', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(461, 'douiri', 'arwa', '2016-01-01', 'hihi@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$cTFUL1M1NXU5dnRXY3BIeA$hkn0uwC/XD5v00HHxt/U6OH5lOYJekVbU8drvyPBMbc', '44556633', 'tunissss', 'gynecologue', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(447, '', NULL, NULL, NULL, NULL, NULL, '', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(482, 'douiri', 'arwa', '2016-01-01', 'MOLILi@gmail.tn', 'MMMMMM', '34567890', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(484, 'douiri', 'arwa', '2016-01-01', 'mokho@gmail.tn', 'nnnnnn', '56789065', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(462, 'douiri', 'arwa', '2016-01-01', 'hihgggi@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$ZG5hUmhjTHZVS3VselVTeA$8DmLtTIOyo+fVOWg2V2gTI+eIWAYs6XIoRy3LDofMZQ', '44556633', 'tunissss', 'gynecologue', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(463, 'nnn', 'gggg', '2016-01-01', 'ggg@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$eUhqT3BBNzhJMnpHby5pRQ$1zZoLLvYTagCoxkuatU/MIN8wAgCOtG1h8DHLtmFxIw', '44556633', 'tunissss', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(464, 'douiri', 'arwa', '2016-01-01', 'koko@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$SG9zWHgwNlRMaDJibXQzbw$5fEN+irDwnoriQKrR+EQ6UKncjqQMHJpZboWh4v44yk', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(465, 'asma', 'asma', '2016-01-01', 'oloolo@gmail.com', '$argon2id$v=19$m=65536,t=4,p=1$OEFYTy9HM3MxR3RkUjUxWA$QBFQ2/8uws+HpTEsEE+05FVfiAI153R/0QX9APy4lzY', '44556633', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(466, 'douiri', 'arwa', '2016-01-01', 'kiki.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$TktWWWlaZ2V6ZVM3OXFMbg$l4Ig/k6E514KU0W/YY/2Izi2U2a0eX95UGuCaWFPOvQ', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(467, 'douiri', 'arwa', '2016-01-01', 'arwjhja.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$SnpIRGFsQ3FqTVoxbEtSOQ$jamCokZcGpxbf5AqGYLi04D2dcMxrC+RIfnEZKahXO8', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(468, 'douiri', 'arwa', '2016-01-01', 'KOKOKO.douiri@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$eXNaT1ZXeGN6U2tpVXlHWA$ERYrOvCUOzNmqHiaXqvhRT5oCcH4E9SMF5aokVlJUj8', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(469, 'douiri', 'arwa', '2016-01-01', 'bnjjh@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$dUNpNE1lbHRUOC9GOE9rMA$GmsMBSIaMkXCmNwPnIR/3Fla3gOMPYNNY9iBSNtxWZE', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(470, 'douiri', 'arwa', '2016-01-01', 'bnHGHjjh@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$SEF5TmV1ZFdXZXl4WEZBMA$2doNP4fPYfvTZ1w0G19WUrROZf3rhDuC+/35egVt1Ro', '44556633', 'tunissss', 'Null', 'patient', '', '0000-00-00 00:00:00', 'null'),
(471, '', NULL, '2016-01-01', 'bnHGHJHJHjjh@gmail.tn', '$argon2id$v=19$m=65536,t=4,p=1$N0xmY1RaTTUudDIuaXg4Rg$+PPR428dgVn8ISKTDR5vUP1K8TIiJpBPCCphhsY2Ttw', NULL, '', '', NULL, '', '0000-00-00 00:00:00', 'null'),
(480, 'benmouath', 'mouath', '2016-03-01', 'mouadh@gmail.tn', 'mmmmmm', '45678904', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(481, 'molkko', 'molka', '2016-01-01', 'molka@gmail.tn', 'mmmmmm', '34567890', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(485, 'douiri', 'arwa', '2016-01-01', 'bobi@gmail.tn', 'bbbbbb', '99999999', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(486, 'douiri', 'arwa', '2016-01-01', 'kadiiii@gmail.tn', 'kkkkkk', '45678904', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(487, 'douiri', 'arwa', '2016-01-01', 'kopipoiii@gmail.tn', 'nnnnnn', '45678904', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(488, 'douiri', 'arwa', '2016-01-01', 'sbou3i@gmail.tn', 'nnnnnn', '34567896', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', 'null'),
(489, 'aaaadd', 'dddd', '2016-01-01', 'soukii@gmail.tn', 'nnnnnn', '34455634', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(490, 'douiri', 'arwa', '2016-01-01', 'popppi@gmail.tn', 'nnnnnn', '34455664', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', 'null'),
(491, 'douiri', 'arwa', '2016-01-01', 'orourou.douiri@gmail.tn', 'bbbbbb', '34455634', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', '[]'),
(492, 'douiri', 'arwa', '2016-01-01', 'mouniraaa@gmail.tn', 'bbbbbb', '34455433', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', '[]'),
(493, 'douiri', 'arwa', '2016-01-01', 'mouniii@gmail.tn', 'nnnnnn', '34567890', 'tunissss', '', 'patient', '', '0000-00-00 00:00:00', '[]'),
(494, 'douiri', 'arwa', '2021-12-22', 'arwHGHGa.douiri@gmail.tn', 'NNNNNN', '23456789', 'tunissss', 'biologiste', 'medecin', '', '0000-00-00 00:00:00', '[]'),
(495, 'douiri', 'arwa', NULL, 'mounirri@gmail.tn', 'nnnnnn', '12345678', 'tunissss', 'biologiste', 'medecin', 'sf2-banner.jpg', '2021-12-06 20:28:23', '[]'),
(496, 'kafff', 'kjkhg', '2021-12-15', 'kaaajouu@gmail.tn', 'AAAAAA', '34567890', 'TUNISSS', 'gynecologue', 'medecin', 'sf2-banner.jpg', '2021-12-06 20:30:56', '[]'),
(497, 'douiri', 'arwa', NULL, 'mojoo@gmail.tn', 'NNNNNN', '23456789', 'tunissss', '', 'patient', 'gettyimages-992018186-612x612.jpg', '2021-12-06 21:25:10', '[]');

-- --------------------------------------------------------

--
-- Structure de la table `userrec`
--

CREATE TABLE `userrec` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `userrec`
--

INSERT INTO `userrec` (`id`, `username`) VALUES
(1, 'diyamitra');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `nom`, `telephone`, `email`, `role`) VALUES
(1, 'Moncef ', '72398376', 'moncef@gmail.com', 'medecin generaliste'),
(2, 'slimen', '72376365', 'slimen@yahoo.fr', 'admin'),
(3, 'majd', '50987654', 'majd@gmail.com', 'patient'),
(4, 'imen', '72321654', 'imen@yahoo.fr', 'medecin orl');

-- --------------------------------------------------------

--
-- Structure de la table `user_event`
--

CREATE TABLE `user_event` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_naissance` date NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero_telephone` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresse` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `specialite` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `user_event`
--

INSERT INTO `user_event` (`id`, `nom`, `prenom`, `date_naissance`, `email`, `password`, `numero_telephone`, `adresse`, `specialite`, `role`) VALUES
(1, 'lotfi', 'hammoudi', '2015-12-15', 'lotfi.hammoudi@esprit.tn', '000000', '28394516', 'makthar ', 'docteur', 'doctor');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `calendar`
--
ALTER TABLE `calendar`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `categorie_evenement`
--
ALTER TABLE `categorie_evenement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_67F068BCD7428D7A` (`commentateur_id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `doctrine_migration_versions`
--
ALTER TABLE `doctrine_migration_versions`
  ADD PRIMARY KEY (`version`);

--
-- Index pour la table `enligne`
--
ALTER TABLE `enligne`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `evenement_user`
--
ALTER TABLE `evenement_user`
  ADD PRIMARY KEY (`evenement_id`,`user_id`),
  ADD KEY `IDX_2EC0B3C4FD02F13` (`evenement_id`),
  ADD KEY `IDX_2EC0B3C4A76ED395` (`user_id`);

--
-- Index pour la table `evenement_user_event`
--
ALTER TABLE `evenement_user_event`
  ADD PRIMARY KEY (`evenement_id`,`user_event_id`),
  ADD KEY `IDX_28164DB1FD02F13` (`evenement_id`),
  ADD KEY `IDX_28164DB1917A0C8B` (`user_event_id`);

--
-- Index pour la table `formulaire`
--
ALTER TABLE `formulaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`id_medecin`);

--
-- Index pour la table `profanities`
--
ALTER TABLE `profanities`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_B8715B4C3F17511` (`word`);

--
-- Index pour la table `property_search`
--
ALTER TABLE `property_search`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `questionss`
--
ALTER TABLE `questionss`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_event`
--
ALTER TABLE `user_event`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `calendar`
--
ALTER TABLE `calendar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `categorie_evenement`
--
ALTER TABLE `categorie_evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT pour la table `enligne`
--
ALTER TABLE `enligne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `formulaire`
--
ALTER TABLE `formulaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `id_medecin` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `profanities`
--
ALTER TABLE `profanities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `property_search`
--
ALTER TABLE `property_search`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `questionss`
--
ALTER TABLE `questionss`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=498;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `user_event`
--
ALTER TABLE `user_event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `FK_67F068BCD7428D7A` FOREIGN KEY (`commentateur_id`) REFERENCES `user_event` (`id`);

--
-- Contraintes pour la table `evenement_user`
--
ALTER TABLE `evenement_user`
  ADD CONSTRAINT `FK_2EC0B3C4A76ED395` FOREIGN KEY (`user_id`) REFERENCES `user_event` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_2EC0B3C4FD02F13` FOREIGN KEY (`evenement_id`) REFERENCES `evenement` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
