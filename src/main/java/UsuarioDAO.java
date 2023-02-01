import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }
    public void adicionar(Usuario usuario) {
        try {
            String sql = "insert into usuarios (nome, cpf, telefone, email, senha) values (?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível inserir");
        }catch (Exception e) {
            System.out.println("Erro desconhecido");
        }
    }
}
