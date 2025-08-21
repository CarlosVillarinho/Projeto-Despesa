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