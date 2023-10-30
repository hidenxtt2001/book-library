CREATE TABLE IF NOT EXISTS `books` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) not null,
    `author_name` varchar(100) not null,
    `is_ready` BOOLEAN default true not null
);