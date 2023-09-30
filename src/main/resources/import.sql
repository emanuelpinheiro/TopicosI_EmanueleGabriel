-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into gamegenre (nome) values('Ação e aventura');
insert into gamegenre (nome) values('Mundo aberto');
insert into gamegenre (nome) values('Terror');


insert into game (nome, id_genero, preco) values('The Last of Us Part I', 1, 249.90);
insert into game (nome, id_genero, preco) values('Minecraft', 2, 129.00);
insert into game (nome, id_genero, preco) values('Red Dead Redemption 2', 1, 299.90);
insert into game (nome, id_genero, preco) values('Deceit', 3, 0.00);