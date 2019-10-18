DROP TABLE IF EXISTS `criminal_case`;

CREATE TABLE `criminal_case` (
    `id` BINARY(16) NOT NULL DEFAULT random_uuid(),
    `name` VARCHAR(255) NOT NULL,
    `time` DATE NOT NULL,
    `criminal_elements_id` BINARY(16),
    `procuratorate_id` BINARY(16) NOT NULL
    PRIMARY KEY (`id`),
    FOREIGN KEY (`criminal_elements_id`),
    FOREIGN KEY (`procuratorate_id`)
);
