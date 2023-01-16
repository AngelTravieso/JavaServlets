package web;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        // suponemos que el usuario visita por primera vez el sitio
        boolean nuevoUsuario = true;
        String mensaje;

        // obtenemos arreglo de cookies
        Cookie[] cookies = req.getCookies();

        // buscamos si ya existe una cookie creada con anterioridad
        // llamada 'visitanteRecurrente'
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitanteRecurrente") && cookie.getValue().equals("si")) {
                    // si ya existe la cookie significa que es un usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }

        // crear nueva cookie
        if (nuevoUsuario) {
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            // guardar cookie
            res.addCookie(visitanteCookie);

            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        } else {
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio";
        }

        // setear tipo de contenido
        res.setContentType("text/html;charset=UTF-8");

        try ( PrintWriter out = res.getWriter()) {

            // Mostrar mensaje en el navegador
            out.print(String.format("Mensaje: %s", mensaje));

            // cerrar objeto printWriter
            out.close();
        }

    }

}
