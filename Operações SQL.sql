--MOSTRA/APRESENTA A TABELA-----------------------------------------------------
select * from java_categoria;

--CRIANDO UMA NOVA TABELA: DESPESA----------------------------------------------
Create table java_despesa (
    id_despesa   number,
    descricao    VARCHAR2(100 byte),
    valor        number(10,2),
    data         date,
    id_categoria number,
    primary key (id_despesa), --estou dizendo quem é a primery key dessa tabela-
    foreign key (id_categoria) references java_categoria (id_categoria)
    on delete cascade); --referencio com a primary da tabela 'categoria'--------

select * from java_despesa; --apresenta a atabela-------------------------------

--INSERE DADOS NA TABELA CIADA, NA SEQUENCIA QUE FOI DEFINIDO ACIMA------------
insert into java_despesa values(101, 'Festa na FIAP', 500,
    to_date('16/08/2025', 'dd/MM/yyyy'), 4);
--| OPERAÇÃO TODA PARA        DATA    |------

--SALVA OPERAÇÕES FEITAS, COMO TABELAS E INSERÇÃO DE ELEMENTOS------------------
commit;

--DELETA UM ELEMENTO PERMANEMTEMENTE -------------------------------------------
delete from java_categoria where id_categoria = 2;

--DELETA TODA A TABELA PERMANENTEMENTE------------------------------------------
drop table java_categoria;
drop table java_despesa;

--VOLTA OPERAÇÃO----------------------------------------------------------------
rollback;

--ALTERA UM ELEMENTO INSERIDO, PARA NAO DELETAR E INSERIR DE NOVO---------------
update java_categoria set categoria = 'xyz' where id_categoria = 2;

--SELECT QUE APRESENTA APENAS O QUE EU QUERO -----------------------------------
select d.descricao, d.valor, d.data, c.categoria            
from java_despesa d                                      --nao tem probelma-----
inner join java_categoria c                              --em pular as linhas---
on d.id_categoria = c.id_categoria;                      --tudo é um só comando-

--DELETA TODA A SEQUENCIA PERMANENTEMENTE---------------------------------------
drop sequence seqc;
drop sequence seqd;

--CRIANDO UMA NOVA SEQUENCIA----------------------------------------------------
create SEQUENCE seqc start WITH 10 INCREMENT by 1;
create SEQUENCE seqd start WITH 1000 INCREMENT by 1;

--INSERINDO UM NOVO ELEMENTO EM SEQUENCIA---------------------------------------
insert into java_categoria values (seqc.nextval, 'educação');
