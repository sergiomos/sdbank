/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import sdbank.models.Cliente;
import sdbank.models.Conta;
import sdbank.models.ContaCorrente;
import sdbank.models.ContaPoupanca;
import sdbank.models.ContaSalario;
import sdbank.models.Contas;
import sdbank.models.Operacao;

/**
 *
 * @author sergi
 */
public class OperacaoDAO {

    private Connection conn;

    public OperacaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void salvar(Operacao operacao) {
        String sql = "INSERT INTO operacoes(conta_id, tipo, data, valor, tarifa, saldo) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            String colunas[] = {"operacao_id"};
            PreparedStatement statement = conn.prepareStatement(sql, colunas);
            statement.setInt(1, operacao.getContaId());
            statement.setString(2, operacao.getTipo());
            statement.setString(3, operacao.getData());
            statement.setDouble(4, operacao.getValor());
            statement.setDouble(5, operacao.getTarifa());
            statement.setDouble(6, operacao.getSaldo());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                operacao.setOperacaoId(generatedKeys.getInt("operacao_id"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Operacao> consultarTodas(int contaId) {
        ArrayList<Operacao> operacoes = new ArrayList<>();
        String sql = "SELECT * "
                + "FROM operacoes "
                + "WHERE conta_id = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, contaId);
            statement.execute();

            ResultSet resultado = statement.getResultSet();

            while (resultado.next()) {
                operacoes.add(new Operacao(resultado.getInt("operacao_id"),
                        resultado.getInt("conta_id"),
                        resultado.getString("tipo"),
                        resultado.getString("data"),
                        resultado.getDouble("valor"),
                        resultado.getDouble("tarifa"),
                        resultado.getDouble("saldo")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return operacoes;
    }

}
