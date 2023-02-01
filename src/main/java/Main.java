import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection conexao = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        conexao.close();

        String sql = "insert into usuarios (nome, cpf, telefone, endereco, email, senha) values (?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "Gertrudes");
        stmt.setString(2, "00000000000");
        stmt.setString(3, "5190000000");
        stmt.setString(4, "Rua dos Bobos, 0");
        stmt.setString(5, "gertrudes.maria@meuemail.com");
        stmt.setString(6, "minhasenha");
        stmt.execute();
        stmt.close();
        ResultSet rs = conexao.createStatement().executeQuery("select * from usuarios");
        while(rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String telefone = rs.getString("telefone");
            String endereco = rs.getString("endereco");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            System.out.format("\n%s %s %s %s %s %s %s %s\n", id, nome, cpf, telefone, endereco, email, senha);
        }
    }

}
