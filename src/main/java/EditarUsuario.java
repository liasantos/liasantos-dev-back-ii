import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarUsuario extends HttpServlet {
    public EditarUsuario() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO cdao = new UsuarioDAO();
        Usuario u = cdao.getUsuario(Long.parseLong(req.getParameter("id")));
        u.setNome(req.getParameter("nome"));
        u.setCpf(req.getParameter("cpf"));
        u.setTelefone(req.getParameter("telefone"));
        u.setEmail(req.getParameter("email"));
        u.setSenha(req.getParameter("senha"));
        Calendar cal = Calendar.getInstance();

        cdao.alterar(u);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("\t<head>");
        out.println("\t\t<title>Edição do Usuário</title>");
        out.println("\t</head>");
        out.println("\t<body>");
        out.println("\t\t<h1>Alterações:</h1>");
        out.printf("\t\t\tNome:\t\t%s\t<br />\n", u.getNome());
        out.printf("\t\t\tCPF: \t%s\t<br />\n", u.getCpf());
        out.printf("\t\t\tTelefone: \t%s  <br />\n", u.getTelefone());
        out.printf("\t\t\tEmail: \t%s  <br />\n", u.getEmail());
        out.printf("\t\t\tSenha: \t%s  <br />\n", u.getSenha());
        out.println("\t<a href='listarUsuarios'>Listar Usuarios</a>");
        out.println("\t</body>");
        out.println("</html>");
    }
}
