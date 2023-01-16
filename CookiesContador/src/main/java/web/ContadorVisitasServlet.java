package web;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Declarar variable contador
        int contador = 0;

        // revisar si existe la cookie 'contadorVisitas'
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("contadorVisitas")) {
                    contador = Integer.parseInt(cookie.getValue());
                }
            }
        }

        // Incrementar el contador en uno
        contador++;

        // Crear cookie
        // Se debe guardar como string
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));

        // Setear tiempo de expiracion de la cookie
        c.setMaxAge(3600);

        // Agregar cookie con tiempo limitado (1hr = 3600seg)
        res.addCookie(c);

        // Setear tipo contenido
        res.setContentType("text/html;charset=UTF-8");

        // Respuesta al navegador
        try ( PrintWriter out = res.getWriter()) {

            // imprimir mensaje
            out.print(String.format("Contador de visitas de cada cliente: %s", contador));

            // cerrar objeto
            out.close();
        }

    }
}
