package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Marca;
import model.Produto;
import utils.Conexao;

public class ProdutoDAO implements DAOGenerica {

    private Connection conexao;

    public ProdutoDAO() throws ClassNotFoundException, SQLException {
        this.conexao = new Conexao().abrirConexao();
    }
    
    @Override
    public void gravar(Object objeto) throws SQLException {
        Produto produto = (Produto) objeto;
        if (produto.getCodigoProduto() == 0) {
            inserir(produto);
        } else {
            alterar(produto);
        }
    }

    @Override
    public void inserir(Object objeto) throws SQLException {
        String sql = "insert into produto values(default, ?,?)";
        Produto produto = (Produto) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getMarca().getCodigoMarca());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao gravar Produto");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public void alterar(Object objeto) throws SQLException {
        String sql = "update produto set nomeproduto = ?, codigomarcafk = ? where codigoproduto = ?";
        Produto produto = (Produto) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getMarca().getCodigoMarca());
            stmt.setInt(3, produto.getCodigoProduto());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao alterar o produto");
        } finally {
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        String sql = "select * from produto where codigoproduto = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                produto = new Produto(
                        rs.getInt("codigoproduto"),
                        rs.getString("nomeproduto"),
                        (Marca) new MarcaDAO().consultar(rs.getInt("codigomarcafk"))
                );
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new SQLException("Erro ao consultar produto");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return produto;
    }

    @Override
    public List<Object> listar() throws SQLException {
        String sql = "select * from produto";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("codigoproduto"),
                        rs.getString("nomeproduto"),
                        (Marca) new MarcaDAO().consultar(rs.getInt("codigomarcafk"))
                );
                lista.add(produto);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new SQLException("Erro ao listar produto");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return lista;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        String sql = "delete from produto where codigoproduto = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir produto");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }
}