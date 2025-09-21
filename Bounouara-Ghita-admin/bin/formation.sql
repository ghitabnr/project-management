CREATE DATABASE formations;

USE formations;

CREATE TABLE Module (
    id INT PRIMARY KEY,
    titre VARCHAR(100) NOT NULL
);

CREATE TABLE Formateur (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    tel INT,
    email VARCHAR(100)
);

CREATE TABLE Formation (
    id VARCHAR(50) PRIMARY KEY,
    module_id INT NOT NULL,
    date VARCHAR(50) NOT NULL,  
    duree INT NOT NULL,
    formateur_id INT NOT NULL,
    CONSTRAINT fk_module FOREIGN KEY (module_id) REFERENCES Module(id),
    CONSTRAINT fk_formateur FOREIGN KEY (formateur_id) REFERENCES Formateur(id)
);