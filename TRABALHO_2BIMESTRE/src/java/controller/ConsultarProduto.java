package controller;

import dao.MarcaDAO;
import dao.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet(name = "ConsultarProduto", urlPatterns = {"/ConsultarProduto"})
public class ConsultarProduto extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try{
            int codigoProduto = Integer.parseInt(request.getParameter("codigoProduto"));
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = (Produto) produtoDAO.consultar(codigoProduto);
            request.setAttribute("produto", produto);
            request.setAttribute("marcas", new MarcaDAO().listar());
        }
        catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
    }
        request.getRequestDispatcher("gravarProduto.jsp").forward(request, response);
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
