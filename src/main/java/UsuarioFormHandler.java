import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioFormHandler extends HttpServlet {
    public UsuarioFormHandler() {
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO cdao = new UsuarioDAO();
        Usuario u = new Usuario();
        u.setNome(req.getParameter("nome"));
        u.setCpf(req.getParameter("cpf"));
        u.setTelefone(req.getParameter("telefone"));
        u.setEmail(req.getParameter("email"));
        u.setSenha(req.getParameter("senha"));

        cdao.adicionar(u);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("\t<head>");
        out.println("\t\t<title> Exibir usuários</title>");
        out.println("\t</head>");
        out.println("\t<body>");
        out.printf("\t\t<b>Nome</ b>: \t\t%s\t<br />", req.getParameter("nome"));
        out.printf("\t\t<b>CPF</ b>:\t\t%s\t<br />", req.getParameter("cpf"));
        out.printf("\t\t<b>Telefone</ b>: \t%s\t<br />", req.getParameter("telefone"));
        out.printf("\t\t<b>Email</ b>: \t%s\t<br />", req.getParameter("email"));
        out.printf("\t\t<b>Senha</ b>: \t%s\t<br />", req.getParameter("senha"));
        out.println("\t</body>");
        out.println("</html>");
    }
}

