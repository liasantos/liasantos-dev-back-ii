create table usuarios (
	id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    cpf VARCHAR(20),
    telefone VARCHAR(20),
    email VARCHAR(255),
    senha VARCHAR(60),
    primary key (id)
);

create table livros (
    id BIGINT NOT NULL AUTO_INCREMENT,
	isbn VARCHAR(255),
    nome VARCHAR(255),
    autor VARCHAR(255),
    primary key (id)
);

create table emprestimo (
	id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    id_livros BIGINT NOT NULL,
    primary key (id),
    foreign key(id_usuario) references usuarios(id),
    foreign key(id_livros) references livros(id)
);