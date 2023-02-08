import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoverUsuario extends HttpServlet {
    public RemoverUsuario() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO cdao = new UsuarioDAO();
        long id = Long.parseLong(req.getParameter("id"));
        Usuario u = cdao.getUsuario(id);
        cdao.remover(u);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("\t<head>");
        out.println("\t\t<title> Este usuario foi excluído</title>");
        out.println("\t</head>");
        out.println("\t<body>");
        out.printf("\t\t<b>Nome</ b>: \t\t%s\t<br />", u.getNome());
        out.printf("\t\t<b>CPF</ b>:\t\t%s\t<br />", u.getCpf());
        out.printf("\t\t<b>Telefone</ b>:\t\t%s\t<br />", u.getTelefone());
        out.printf("\t\t<b>Email</ b>:\t\t%s\t<br />", u.getEmail());
        out.printf("\t\t<b>Senha</ b>: \t%s\t<br />", u.getSenha());
        out.println("\t<a href='listarUsuarios'>Listar Usuarios</a>");
        out.println("\t</body>");
        out.println("</html>");
    }
}
