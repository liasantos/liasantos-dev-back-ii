import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarUsuarios extends HttpServlet {
    public ListarUsuarios() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO cdao = new UsuarioDAO();
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("\t<head>");
        out.println("\t\t<title> Exibir usuários</title>");
        out.println("\t</head>");
        out.println("\t<body>");
        out.println("\t\t<table border='1'>");
        out.println("\t\t\t<thead>");
        out.println("\t\t\t\t<tr>");
        out.println("\t\t\t\t\t<td>Nome</td>");
        out.println("\t\t\t\t\t<td>CPF</td>");
        out.println("\t\t\t\t\t<td>Telefone</td>");
        out.println("\t\t\t\t\t<td>Email</td>");
        out.println("\t\t\t\t\t<td>Editar</td>");
        out.println("\t\t\t\t\t<td>Excluir</td>");
        out.println("\t\t\t\t</tr>");
        out.println("\t \t\t</thead>");
        out.println("\t\t\t<tbody>");
        Iterator var7 = cdao.listar().iterator();

        while(var7.hasNext()) {
            Usuario aux = (Usuario)var7.next();
            out.println("\t\t\t\t<tr>");
            out.printf("\t\t\t\t\t<td>%s</td>", aux.getNome());
            out.printf("\t\t\t\t\t<td>%s</td>", aux.getCpf());
            out.printf("\t\t\t\t\t<td>%s</td>", aux.getTelefone());
            out.printf("\t\t\t\t\t<td>%s</td>", aux.getEmail());
            out.printf("\t\t\t\t\t<td>%s</td>", aux.getSenha());
            out.printf("\t\t\t\t\t<td><a href='exibirContato?id=%s'>Editar</a></td>", aux.getId());
            out.printf("\t\t\t\t\t<td><a href='removerContato?id=%s'>Detetar</a></td>", aux.getId());
            out.println("\t\t\t\t</tr>");
        }

        out.println("\t\t\t</tbody>");
        out.println("\t\t</table>");
        out.println("\t</body>");
        out.println("</html>");
    }
}
