package web;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Simular valores correctos
        String usuarioOk = "Angel";
        String passwordOk = "1234";

        // Obtener parametros de la peticion
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        try ( PrintWriter out = res.getWriter()) {
            if (usuarioOk.equals(usuario) && password.equals(passwordOk)) {
                out.print("<h1>Datos correctos:</h1>");
                out.print(String.format("<p>Usuario: %s</p>", usuario));
                out.print(String.format("<p>Contraseña: %s</p>", password));
            } else {
                // responder con codigo de estado 401 (no autorizado)
                // HTTPServletResponse.SC_UNAUTHORIZED (SC = Status Code)
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
            }
        }

    }
}
