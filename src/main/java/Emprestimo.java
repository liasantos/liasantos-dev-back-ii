public class Emprestimo {
    private Long id;
    private Usuario id_usuario;
    private Livro id_livro;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return id_usuario;
    }
    public void setUsuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Livro getLivro() {
        return id_livro;
    }
    public void setLivro(Livro livro) {
        this.id_livro = id_livro;
    }
}
