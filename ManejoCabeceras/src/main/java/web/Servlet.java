package web;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // setear tipo de contenido
        res.setContentType("text/html;charset=UTF-8");

        try ( PrintWriter out = res.getWriter()) {
            String metodoHttp = req.getMethod();
            String uri = req.getRequestURI();
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Headers HTTP</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Headers HTTP</h1>");
            out.print(String.format("<p><b>Método HTTP:</b>%s</p>", metodoHttp));
            out.print(String.format("<p><b>URI:</b> %s</p>", uri));

            // Imprimir todos los headers disponibles
            Enumeration headers = req.getHeaderNames();
            while (headers.hasMoreElements()) {
                // (String) headers.nextElement()
                String nombreHeader = headers.nextElement().toString();
                out.print(String.format("<p><b>%s</b>: %s</p>", nombreHeader, req.getHeader(nombreHeader)));

            }

            out.print("</body");
            out.print("</html>");

        }

    }
}
