create table usuarios (
	id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    cpf VARCHAR(20),
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(60),
    primary key (id)
);

create table livros (
	isbn VARCHAR(255),
    nome VARCHAR(255),
    autor VARCHAR(255),
    primary key (isbn)
);

create table emprestimo (
	id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    isbn VARCHAR(255) NOT NULL,
    primary key (id),
    foreign key(id_usuario) references usuarios(id),
    foreign key(isbn) references livros(isbn)
);