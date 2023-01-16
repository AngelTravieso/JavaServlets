package web;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        // setear tipo de contenido
        res.setContentType("text/html;charset=UTF-8");

        // Solicitar objeto Session
        HttpSession sesion = req.getSession();

        String titulo;

        // Pedir el atributo 'contadorVisitas' a la sesion
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");

        // si es nulo es la primera vez que accedemos a la aplicacion
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }

        // Agregar el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);

        /*
        por default la sesion dura 30min de inactividad, para cambiarlo se debe
        cambiar el valor en el WEB-INF/web.xml
          <session-timeout>
            30 (valor en minutos)
        </session-timeout>
         */
        try ( PrintWriter out = res.getWriter()) {

            // Imprimir en el navegador
            out.print(String.format("<h1>%s</h1>", titulo));
            out.print(String.format("<p>Nro. Accesos al recurso: %s</p>", contadorVisitas));
            out.print(String.format("<p>ID de la sesion: %s</p>", sesion.getId()));

            // cerrar objeto printWriter
            out.close();
        }

    }
}
