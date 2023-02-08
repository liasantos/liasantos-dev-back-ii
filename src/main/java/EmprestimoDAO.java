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
            stmt.setString(1, locacao.getId_livro().toString());
            stmt.setString(2, locacao.getId_usuario().toString());
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
            Emprestimo emp;
            while (rs.next()) {
                emp = new Emprestimo();
                emp.setId(rs.getLong("id"));
                emp.setId_livro(rs.getString("id_livros"));
                emp.setId_usuario(rs.getLong("id_usuario"));
                lista.add(emp);
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

    public void alterar(Emprestimo emprestimo) {
        try {
            String sql = "update emprestimo set id_livros = ?, id_usuario = ? where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, emprestimo.getId_livro());
            stmt.setLong(2, emprestimo.getId_usuario());
            stmt.setLong(4, emprestimo.getId());
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

    public void remover(Emprestimo emprestimo) {
        try {
            String sql = "delete from emprestimo where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, emprestimo.getId());
            stmt.execute();
            stmt.close();
        } catch(SQLException sqle) {
            System.out.println("Não foi possível remover");
        } catch(Exception e) {
            System.out.println("Erro desconhecido");
        }
    }

}
