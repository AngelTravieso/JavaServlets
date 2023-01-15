package web;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        // indicar tipo de respuesta
        res.setContentType("text/html;charset=UTF-8");

        // refrescar informacion enviada al navegador cada segundo
        res.setHeader("refresh", "1");

        // obtener fecha actual
        Date fecha = new Date();

        // Definir formato
        SimpleDateFormat fechaFormateada = new SimpleDateFormat("'Hora Actualizada' HH:mm:ss");

        // Dar formato a la fecha
        String horaConFormato = fechaFormateada.format(fecha);

        try ( PrintWriter out = res.getWriter()) {

            out.print(String.format("<p>%s</p>", horaConFormato));

            out.close();

        }

    }
}
