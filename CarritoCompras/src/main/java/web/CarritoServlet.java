package web;

import java.io.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        // setear tipo de respuesta
        res.setContentType("text/html;charset=UTF-8");

        // creamos o recuperamos el objeto HttpSession
        HttpSession sesion = req.getSession();

        // recuperar la lista de articulos agregados previamente (si existen)
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        // verificamos si la lista de articulos existe
        if (articulos == null) {
            // inicializar la lista de articulos
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        // procesar nuevo articulo
        String articuloNuevo = req.getParameter("articulo");

        // revisamos y agregamos el articulo nuevo
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            // agregar nuevo articulo a la lista de articulos
            articulos.add(articuloNuevo);
        }

        // imprimir la lista de articulos
        try ( PrintWriter out = res.getWriter()) {

            out.print(String.format("<h1>Lista de Artículos</h1>"));

            // iterar los articulos
            for (String articulo : articulos) {
                out.print(String.format("<li>artículo: %s</li>", articulo));
            }

            // link para regresar al inicio
            out.print("<p><a href='/CarritoCompras'>Inicio</a></p>");

            // cerrar objeto printWriter
            out.close();
        }

    }
}
