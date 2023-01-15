package web;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html;charset=UTF-8");

        // generar respuesta
        PrintWriter out = res.getWriter();

        // procesar elementos del formulario
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        String tecnologias[] = req.getParameterValues("tecnologia");
        String genero = req.getParameter("genero");
        String ocupacion = req.getParameter("ocupacion");
        String musica[] = req.getParameterValues("musica");
        String comentario = req.getParameter("comentarios");

        // responder al cliente (cont HTML)
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Resultado Servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametros procesados por el servlet:</h1>");
        out.print(String.format("<p>Usuario: %s</p>", usuario));
        out.print(String.format("<p>Contraseña: %s</p>", password));

        out.print("<p>Tecnologias: ");

        for (String tecnologia : tecnologias) {
            out.print(String.format("%s, ", tecnologia));
        }

        out.print("</p>");

        out.print(String.format("<p>Género: %s</p>", genero == "H" ? "Hombre" : "Mujer"));

        out.print(String.format("<p>Ocupación: %s</p>", imprimirOcupacion(ocupacion)));

        if (musica != null) {
            out.print("<p>Música: ");
            for (String item : musica) {
                out.print(String.format("%s, ", item));
            }

            out.print("</p>");
        }
        
        System.out.println("vacioo = " + comentario.isEmpty());

        if (!comentario.isEmpty()) {
            out.print(String.format("<p>Comentarios: %s</p>", comentario));
        }

        out.print(String.format("<a href=\"/ManejoFormulariosHTML\">Inicio</a>"));

        out.print("</body>");
        out.print("</html>");

        // cerrar objeto printWriter
        out.close();
    }

    // Imprimir Ocupacion
    protected String imprimirOcupacion(String ocupacion) {
        switch (ocupacion) {
            case "1":
                return "Profesor";
            case "2":
                return "Ingeniero";
            case "3":
                return "Jubilado";
            default:
                return "Otro";
        }
    }

}
