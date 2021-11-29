-- DDL (Desenvolvimento)
drop database if exists Prova;
create database Prova charset=UTF8 collate utf8_general_ci;
use Prova;

create table funcionarios(
    Matricula integer not null primary key auto_increment,
    Nome_Completo varchar(50) not null,
    Data_Desligamento DATE,
    Ultimo_Salário decimal(12,2)
);

alter table funcionarios ADD
constraint fk_funcionario foreign key (Matricula)
references funcionarios(Matricula);

alter table funcionarios ADD
constraint fk_nomes foreign key (Nome_Completo)
references funcionarios(Matricula);

alter table funcionarios ADD
constraint fk_desligamento foreign key (Data_Desligamento)
references funcionarios(Matricula);

alter table funcionarios ADD
constraint fk_salario foreign key (Ultimo_Salário)
references funcionarios(Matricula);

describe funcionarios;

LOAD DATA INFILE 'C:/Users/Desenvolvimento/Desktop/Prova/bcd/funcionarios.csv'
INTO TABLE funcionarios
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from funcionarios;

C:/Users/Desenvolvimento/Desktop/Prova/bcd/script.sql