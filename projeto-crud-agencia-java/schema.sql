

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

create table viagens (
  id int auto_increment primary key,
  id_cliente int not null,
  foreign key (id_cliente) references clientes(id),
  id_passagem int not null,
  foreign key (id_passagem) references passagens(id)
 );
