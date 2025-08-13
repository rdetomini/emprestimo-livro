
CREATE TABLE livros (
	id bigint not null auto_increment primary key,
    titulo varchar(250) not null, 
    autor varchar(250) not null,
    ano_publicacao int not null
);