package dao;

import model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Conexao;

public class PessoaDAO {

    private Connection conexao;

    public PessoaDAO() throws ClassNotFoundException, SQLException {
        conexao = Conexao.abrirConexao();
    }

    public int gravar(Object objeto) throws SQLException {
        Pessoa pessoa = (Pessoa) objeto;
        if (pessoa.getCodigoPessoa() == 0) {
            return this.inserir(pessoa);
        } else {
            return this.alterar(pessoa);
        }
    }

    public int inserir(Object objeto) throws SQLException {
        String sql = "insert into pessoa values(default, ?, ?, ?) returning codigopessoa";
        Pessoa pessoa = (Pessoa) objeto;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int codigoPessoa = 0;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getCpfPessoa());
            stmt.setString(3, pessoa.getSenhaPessoa());
            rs = stmt.executeQuery();
            while (rs.next()) {
                codigoPessoa = rs.getInt("codigopessoa");
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao inserir pessoa");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
        return codigoPessoa;
    }

    public int alterar(Object objeto) throws SQLException {
        String sql = "update pessoa set nomepessoa = ?, cpfpessoa = ?, senhapessoa = ? where codigopessoa = ? returning codigopessoa";
        Pessoa pessoa = (Pessoa) objeto;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int codigoPessoa = 0;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getCpfPessoa());
            stmt.setString(3, pessoa.getSenhaPessoa());
            stmt.setInt(4, pessoa.getCodigoPessoa());
            rs = stmt.executeQuery();
            while (rs.next()) {
                codigoPessoa = rs.getInt("codigopessoa");
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao alterar pessoa");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
        return codigoPessoa;
    }

    public Object consultar(String cpfPessoa) throws SQLException {
        String sql = "select * from pessoa where cpfpessoa = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpfPessoa);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pessoa = new Pessoa(
                        rs.getInt("codigopessoa"),
                        rs.getString("nomepessoa"),
                        rs.getString("cpfpessoa"),
                        null
                );
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar pessoa");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return pessoa;
    }
}