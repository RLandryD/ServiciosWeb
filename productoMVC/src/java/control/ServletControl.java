package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ProductoDB;
import modelo.Producto;

@WebServlet(name = "ServletControl", urlPatterns = {"/ServletControl"})
public class ServletControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mostrarProductos(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoDB productoDB = new ProductoDB();
        productoDB.deleteProducto(Integer.parseInt(
                request.getParameter("id")));
        mostrarProductos(request, response);
    }

    public void mostrarProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoDB productoDB = new ProductoDB();
        HttpSession sesion = request.getSession();
        List<Producto> lista = productoDB.getAll();
        sesion.setAttribute("lista", lista);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/listaProducto.jsp");
        rd.forward(request, response);
    }
}
