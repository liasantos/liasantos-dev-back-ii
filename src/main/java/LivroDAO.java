import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private Connection conexao;

    public LivroDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void adicionar(Livro livro) {
        try {
            String sql = "insert into livros (isbn, nome, autor) values (?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getNome());
            stmt.setString(3, livro.getAutor());
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível inserir");
        } catch (Exception e) {
            System.out.println("Erro desconhecido");
        }
    }

    public List<Livro> listar() {
        List<Livro> lista = new ArrayList<>();
        try {
            ResultSet rs = conexao.createStatement().executeQuery("select * from livros");
            Livro l;
            while (rs.next()) {
                l = new Livro();
                l.setId(rs.getLong("id"));
                l.setIsbn(rs.getString("isbn"));
                l.setNome(rs.getString("nome"));
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

    public void alterar(Livro livro) {
        try {
            String sql = "update livros set isbn = ?, nome = ?, autor = ? where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getNome());
            stmt.setString(3, livro.getAutor());
            stmt.setLong(4, livro.getId());
            System.out.println(stmt.toString());
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível alterar");
            sqle.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro desconhecido");
        }
    }

    public void remover(Livro livro) {
        try {
            String sql = "delete from livros where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, livro.getId());
            stmt.execute();
            stmt.close();
        } catch(SQLException sqle) {
            System.out.println("Não foi possível remover");
        } catch(Exception e) {
            System.out.println("Erro desconhecido");
        }
    }
}
