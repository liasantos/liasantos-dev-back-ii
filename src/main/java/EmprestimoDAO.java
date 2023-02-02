import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {
    private Connection conexao;

    public EmprestimoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void adicionar(Emprestimo locacao) {
        try {
            String sql = "insert into emprestimo (id_usuario, id_livros) values (?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, locacao.getIsbn());
            stmt.setString(2, locacao.getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível inserir");
        } catch (Exception e) {
            System.out.println("Erro desconhecido");
        }
    }

    public List<Emprestimo> listar() {
        List<Emprestimo> lista = new ArrayList<>();
        try {
            ResultSet rs = conexao.createStatement().executeQuery("select * from emprestimo");
            Emprestimo loc;
            while (rs.next()) {
                loc = new Emprestimo();
                loc.setId(rs.getLong("id"));
                loc.setUsuario(rs.getLong("id_usuario"));
                loc.setNome(rs.getString("nome"));
                l.setAutor(rs.getString("autor"));
                lista.add(l);
            }
            return lista;
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a lista");
            return null;
        } catch (Exception e) {
            System.out.println("Erro desconhecido");
            return null;
        }
}
