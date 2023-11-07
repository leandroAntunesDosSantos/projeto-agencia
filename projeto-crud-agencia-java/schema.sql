

create database legacy;


create table clientes (
  id int auto_increment primary key,
  nome VARCHAR(255),
  email VARCHAR(255),
  telefone VARCHAR(255),
  endereco VARCHAR(255),
  senha VARCHAR(255)
);

create table passagens (
  id int auto_increment primary key,
  cidade VARCHAR(255),
  preco int
);


