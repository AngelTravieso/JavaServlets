package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Para crear un servlet se debe extender de la clase HttpServlet
// Para reconocerlo desde el navegador y se pueda acceder
@WebServlet("/hola_mundo")
public class HolaMundo extends HttpServlet {

    // indicar metodo que procesara el servlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // setear el tipo de contenido a responder para el navegador
        res.setContentType("text/html;charset=UTF-8");

        // Imprimir en el navegador web
        PrintWriter out = res.getWriter();
        
        out.println("Hola Mundo desde Servlets");
    }

}
