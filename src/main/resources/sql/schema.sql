CREATE TABLE IF NOT EXISTS `Country` (
    `id`                INTEGER  PRIMARY KEY AUTO_INCREMENT,
    `name`              VARCHAR  NOT NULL,
    `code`              VARCHAR  NOT NULL,
    `continent`         VARCHAR  NOT NULL
);

CREATE TABLE IF NOT EXISTS `City` (
    `id`                INTEGER  PRIMARY KEY AUTO_INCREMENT,
    `name`              VARCHAR  NOT NULL,
    `country_id`        INTEGER  NOT NULL
);