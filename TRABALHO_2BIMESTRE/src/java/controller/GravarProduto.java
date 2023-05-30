package controller;

import dao.MarcaDAO;
import dao.ProdutoDAO;
import model.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Marca;

@WebServlet(name = "GravarProduto", urlPatterns = {"/GravarProduto"})
public class GravarProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try{
            int codigoProduto = request.getParameter(
                    "codigoProduto").isEmpty() ? 0 : Integer.parseInt(
                            request.getParameter("codigoProduto"));
            
            String nomeProduto = request.getParameter("nomeProduto");
            
            Marca marca = new Marca();
            int codigoMarcafk = Integer.parseInt(request.getParameter("codigoMarca"));
            marca.setCodigoMarca(codigoMarcafk);
            
            Produto produto = new Produto(codigoProduto, nomeProduto, marca);
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.gravar(produto);
            request.setAttribute("mensagem","Produto gravado com sucesso");
        }
        catch (SQLException | ClassNotFoundException ex){
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("ListarProduto").forward(request, response);    }

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
