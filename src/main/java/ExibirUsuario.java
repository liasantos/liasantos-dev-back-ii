import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExibirUsuario extends HttpServlet {
    public ExibirUsuario() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO cdao = new UsuarioDAO();
        Usuario u = cdao.getUsuario(Long.parseLong(req.getParameter("id")));
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("\t<head>");
        out.println("\t\t<title> Usuario</title>");
        out.println("\t</head>");
        out.println("\t<body>");
        out.println("\t\t<h1>Editar usuario</h1>");
        out.println("\t\t<form action='editarUsuario'>");
        out.printf("\t\t\t<input type='hidden' \tname = 'id' value='%s'/><br />", u.getId());
        out.printf("\t\t\tNome: \t\t<input type='text' \tname = 'Nome' value='%s'/><br />", u.getNome());
        out.printf("\t\t\tCPF: \t\t<input type='text' \tname = 'CPF' value='%s'/><br />", u.getCpf());
        out.printf("\t\t\tTelefone: \t\t<input type='text' \tname = 'Telefone' value='%s'/><br />", u.getTelefone());
        out.printf("\t\t\tEmail: \t<input type='text' \tname = 'Email' value='%s'/><br />", u.getEmail());
        out.printf("\t\t\tSenha: \t\t<input type='text' \tname = 'Senha' value='%s'/><br />", u.getSenha());
        out.println("\t\t\t<input type='submit' value = 'Salvar'/>");
        out.println("\t\t</form>");
        out.println("\t<a href='listarUsuarios'>cancelar</a>");
        out.println("\t</body>");
        out.println("</html>");
    }
}
