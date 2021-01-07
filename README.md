# Profissoes-REST
API REST para cadastro de Profissões

database name: compasso_professions

CREATE TABLE titles (
    idTitle INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE professions (
    idProfession INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    area VARCHAR(50) NOT NULL,
    title INT UNSIGNED NOT NULL,
    sector VARCHAR(50) NOT NULL,
    FOREIGN KEY (title) REFERENCES titles(idTitle)
);
