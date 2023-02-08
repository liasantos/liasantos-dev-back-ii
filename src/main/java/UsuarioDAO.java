import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try {
            ResultSet rs = conexao.createStatement().executeQuery("select * from usuarios");
            Usuario u;
            while (rs.next()) {
                u = new Usuario();
                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setTelefone(rs.getString("telefone"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                lista.add(u);
            } return lista;
        } catch(SQLException sqle) {
            System.out.println("Não foi possível processar a lista");
            return null;
        } catch(Exception e) {
            System.out.println("Erro desconhecido");
            return null;
        }

    }

    public void alterar(Usuario usuario) {
        try {
            String sql = "update usuarios set nome = ?, cpf = ?, telefone = ?, email = ?, email = ?, senha = ? where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.setLong(6, usuario.getId());
            System.out.println(stmt.toString());
            stmt.execute();
            stmt.close();

        } catch(SQLException sqle){
            System.out.println("Não foi possível alterar");
            sqle.printStackTrace();
        } catch(Exception e){
            System.out.println("Erro desconhecido");
        }
    }

    public void remover(Usuario usuario) {
        try {
            String sql = "delete from usuarios where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, usuario.getId());
            stmt.execute();
            stmt.close();
        } catch(SQLException sqle) {
            System.out.println("Não foi possível remover");
        } catch(Exception e) {
            System.out.println("Erro desconhecido");
        }
    }

    public Usuario getUsuario(long id) {
        Usuario u = new Usuario();;
        String sql = "select * from usuarios where `id` = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs= stmt.executeQuery();
            if (!rs.next() ) {
                System.out.println("dado nao encontrado");
                return u;
            }
            u.setId(rs.getLong("id"));
            u.setNome(rs.getString("nome"));
            u.setCpf(rs.getString("cpf"));
            u.setTelefone(rs.getString("telefone"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nao foi possivel carregar o dado solicitado");
        }
        return u;
    }
}

