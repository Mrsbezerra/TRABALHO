package controller;

import dao.MarcaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Marca;

@WebServlet(name = "ConsultarMarca", urlPatterns = {"/ConsultarMarca"})
public class ConsultarMarca extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try{
            int codigoMarca = Integer.parseInt(request.getParameter("codigoMarca"));
            MarcaDAO marcaDAO = new MarcaDAO();
            Marca marca = (Marca) marcaDAO.consultar(codigoMarca);
            request.setAttribute("marca", marca);
        }
        catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
    }
        request.getRequestDispatcher("gravarMarca.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
