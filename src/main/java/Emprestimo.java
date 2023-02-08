public class Emprestimo {
    private Long id;
    private Long id_usuario = new Usuario().getId();
    private Long id_livro = new Livro().getId();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Long getId_livro() {
        return id_livro;
    }
    public void setId_livro(String livro) {
        this.id_livro = id_livro;
    }
}
