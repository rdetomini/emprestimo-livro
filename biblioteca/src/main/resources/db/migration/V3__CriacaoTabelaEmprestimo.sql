CREATE TABLE emprestimos (
	id bigint not null auto_increment primary key,
    pessoa_id bigint not null,
    livro_id bigint not null,
    data_emprestimo datetime not null,
    data_devolucao datetime null,
    CONSTRAINT fk_emprestimos_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoas(id),
    CONSTRAINT fk_emprestimos_livro FOREIGN KEY (livro_id) REFERENCES livros(id)
);