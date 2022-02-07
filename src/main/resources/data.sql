DROP TABLE IF EXISTS `geographie`;
DROP TABLE IF EXISTS `reproduction`;
DROP TABLE IF EXISTS `vie`;
DROP TABLE IF EXISTS `sexe`;
DROP TABLE IF EXISTS `physique`;
DROP TABLE IF EXISTS `animaux`;

CREATE TABLE `animaux`
(
    `a_id`               INT NOT NULL AUTO_INCREMENT,
    `nom_commun`         VARCHAR(255) UNIQUE,
    `genre`              VARCHAR(255),
    `espece`             VARCHAR(255),
    `embranchement`      VARCHAR(255),
    `sous_embranchement` VARCHAR(255),
    `ordre`              VARCHAR(255),
    `uicn`               VARCHAR(255),
    PRIMARY KEY (`a_id`)
);


CREATE TABLE `physique`
(
    `p_id`        INT NOT NULL AUTO_INCREMENT,
    `id_animal`   INT NOT NULL,
    `description` VARCHAR(255),
    PRIMARY KEY (`p_id`),
    FOREIGN KEY (id_animal) REFERENCES animaux (a_id)
);


CREATE TABLE `sexe`
(
    `s_id`        INT NOT NULL AUTO_INCREMENT,
    `id_animal`   INT NOT NULL,
    `description` VARCHAR(255),
    PRIMARY KEY (`s_id`),
    FOREIGN KEY (id_animal) REFERENCES animaux (a_id)
);


CREATE TABLE `vie`
(
    `v_id`        INT NOT NULL AUTO_INCREMENT,
    `id_animal`   INT NOT NULL,
    `description` VARCHAR(255),
    PRIMARY KEY (`v_id`),
    FOREIGN KEY (id_animal) REFERENCES animaux (a_id)
);


CREATE TABLE `reproduction`
(
    `r_id`        INT NOT NULL AUTO_INCREMENT,
    `id_animal`   INT NOT NULL,
    `description` VARCHAR(255),
    PRIMARY KEY (`r_id`),
    FOREIGN KEY (id_animal) REFERENCES animaux (a_id)
);


CREATE TABLE `geographie`
(
    `g_id`        INT NOT NULL AUTO_INCREMENT,
    `id_animal`   INT NOT NULL,
    `description` VARCHAR(255),
    PRIMARY KEY (`g_id`),
    FOREIGN KEY (id_animal) REFERENCES animaux (a_id)
);

INSERT INTO `animaux` (`nom_commun`, `genre`, `espece`, `embranchement`, `sous_embranchement`, `ordre`, `uicn`)
VALUES ('Caelacanthe', 'Latimeria', 'Chalumnae', 'Chordes', 'Vertébré', 'Coelocanthiforme',
        'Danger critique d extinction');

INSERT INTO `physique` (`id_animal`, `description`)
VALUES (1, 'Peut dépasser les deux mètres');

INSERT INTO `physique` (`id_animal`, `description`)
VALUES (1, 'Vit 48 ans');

INSERT INTO `sexe` (`id_animal`, `description`)
VALUES (1, 'Les femelles sont plus grandes que les mâles');

INSERT INTO `vie` (`id_animal`, `description`)
VALUES (1, 'Se réfugie souvent dans des grottes');

INSERT INTO `vie` (`id_animal`, `description`)
VALUES (1, 'Chasseur nocturne');

INSERT INTO `reproduction` (`id_animal`, `description`)
VALUES (1, 'ovoviviparité');

INSERT INTO `geographie` (`id_animal`, `description`)
VALUES (1, 'Afrique Est');

INSERT INTO `geographie` (`id_animal`, `description`)
VALUES (1, 'Océan Indien');