package web;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        // Indicamos el tipo de respuesta al navegador
        res.setContentType("application/vnd.mx-excel");

        // Indicar al navegador que cuando hagamos click descargara el archivo excel
        res.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");

        // para un uso mas profesional de excel se puede usar poi.apache.org
        // Evitar guardar cache en el navegador
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-store");

        // Para que la informacion expire inmediatamente
        res.setDateHeader("Expires", -1);

        // Desplegar la informacion al cliente (navegador)
        try ( PrintWriter out = res.getWriter()) {
            out.println("\nValores");
            out.println("\t1");
            out.println("\t2");
            out.println("Total\t=SUMA(B3:B4)");
            
            out.close();
        }

    }
}
