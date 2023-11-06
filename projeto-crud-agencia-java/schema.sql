
create database legacy;

create table clientes (
  id serial primary key,
  nome text,
  email text,
  telefone text,
  endereco text,
  senha text
);

create table passagens (
  id serial primary key,
  cidade text,
  preco integer
);


