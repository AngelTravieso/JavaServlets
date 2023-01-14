package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    // procesar peticion POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // procesar los valores del formulario (parametros)

        // lee el nombre del name del campo del formulario
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        // Imprimir valores en la consola (servidor glassfish)
        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);

        // agregar codigo HTML a la respuesta (no recomendado con servlets)
        try (PrintWriter out = res.getWriter()) {
            // agregar codigo HTML a la respuesta (no recomendado con servlets)
            out.print("<html>");
            out.print("<body>");
            out.print("El parametro usuario es: " + usuario);
            out.print("<br/>");
            out.print("El parametro password es: " + password);
            out.print("<br/>");
            out.print("</body>");
            out.print("</html>");
            // cierra el objeto printWriter y libera recursos
        }

    }

}
