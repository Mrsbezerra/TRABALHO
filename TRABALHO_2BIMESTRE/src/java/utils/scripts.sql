create table marca(
    codigomarca serial not null primary key,
    nomemarca varchar not null
);

create table pessoa(
    codigopessoa serial not null primary key,
    nomepessoa varchar not null,
    cpfpessoa varchar not null unique,
    senhapessoa varchar not null
);

create table produto(
    codigoproduto serial not null primary key,
    nomeproduto varchar not null,
    codigomarcafk int references marca(codigomarca)
);

create or replace view usuario as
select pe.codigopessoa as codigousuario, pe.nomepessoa as nomeusuario, pe.cpfpessoa as cpfusuario, pe.senhapessoa as senhausuario
from pessoa pe
union
select pe.codigopessoa as codigousuario, pe.nomepessoa as nomeusuario, pe.cpfpessoa as cpfusuario, pe.senhapessoa as senhausuario
from pessoa pe