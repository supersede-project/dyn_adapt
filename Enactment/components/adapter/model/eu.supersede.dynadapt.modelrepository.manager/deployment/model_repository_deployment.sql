CREATE DATABASE  IF NOT EXISTS `model_repository_manager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `model_repository_manager`;

DROP TABLE IF EXISTS `AdaptabilityModel`;
DROP TABLE IF EXISTS `BaseModel`;
DROP TABLE IF EXISTS `VariantModel`;
DROP TABLE IF EXISTS `ProfileModel`;
DROP TABLE IF EXISTS `FeatureModel`;
DROP TABLE IF EXISTS `FeatureConfiguration`;
DROP TABLE IF EXISTS `PatternModel`;

CREATE TABLE `AdaptabilityModel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `authorId` varchar(255) NOT NULL,
  `creationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `lastModificationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `fileExtension` varchar(255) NOT NULL,
  `systemId` varchar(255) NOT NULL,
  `featureId` varchar(255) NOT NULL,
  `relativePath` varchar(255) NOT NULL,
  `dependencies` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `BaseModel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `authorId` varchar(255) NOT NULL,
  `creationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `lastModificationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `fileExtension` varchar(255) NOT NULL,
  `systemId` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `relativePath` varchar(255) NOT NULL,
  `dependencies` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `VariantModel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `authorId` varchar(255) NOT NULL,
  `creationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `lastModificationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `fileExtension` varchar(255) NOT NULL,
  `systemId` varchar(255) NOT NULL,
  `relativePath` varchar(255) NOT NULL,
  `dependencies` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `ProfileModel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `authorId` varchar(255) NOT NULL,
  `creationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `lastModificationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `fileExtension` varchar(255) NOT NULL,
  `systemId` varchar(255) NOT NULL,
  `relativePath` varchar(255) NOT NULL,
  `dependencies` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `FeatureModel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `authorId` varchar(255) NOT NULL,
  `creationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `lastModificationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `fileExtension` varchar(255) NOT NULL,
  `systemId` varchar(255) NOT NULL,
  `relativePath` varchar(255) NOT NULL,
  `dependencies` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `FeatureConfiguration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `authorId` varchar(255) NOT NULL,
  `creationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `lastModificationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `fileExtension` varchar(255) NOT NULL,
  `systemId` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `relativePath` varchar(255) NOT NULL,
  `dependencies` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `PatternModel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `authorId` varchar(255) NOT NULL,
  `creationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `lastModificationDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `fileExtension` varchar(255) NOT NULL,
  `systemId` varchar(255) NOT NULL,
  `relativePath` varchar(255) NOT NULL,
  `dependencies` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
