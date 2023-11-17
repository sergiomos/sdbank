package sdbank.db;

import java.sql.Connection;
import java.sql.SQLException;
import sdbank.models.Conta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;
import sdbank.models.Contas;

public class ContaDAO {

    private Connection conn;

    public ContaDAO() {
    }

    public ContaDAO(Connection conn) {
        this.conn = conn;
    }

    public void salvar(Conta conta) {
        String sql = "INSERT INTO contas(cliente_id, saldo, tipo) VALUES(?, ?, ?)";
        try {
            String colunas[] = {"conta_id"};
            PreparedStatement statement = conn.prepareStatement(sql, colunas);
            statement.setInt(1, conta.getClienteId());
            statement.setDouble(2, conta.getSaldo());
            statement.setString(3, conta.getTipo());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                conta.setContaId(generatedKeys.getInt("conta_id"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Optional<Conta> consultarContaCliente(int clienteId) {
        Optional<Conta> conta = Optional.empty();
        String sql = "SELECT * from conta WHERE cliente_id = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, clienteId);
            statement.execute();

            ResultSet resultado = statement.getResultSet();

            if (resultado.next()) {
                conta = Optional.ofNullable(new Conta(
                        resultado.getInt("conta_id"),
                        resultado.getInt("cliente_id"),
                        resultado.getDouble("saldo"),
                        resultado.getString("tipo")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conta;
    }

    public ArrayList<Contas> exibirContas() {
        ArrayList<Contas> contas = new ArrayList<>();
        String sql = "SELECT cli.nome, cli.cpf, tipo,saldo "
                + "FROM contas "
                + "JOIN clientes AS cli USING (cliente_id)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.execute();

            ResultSet resultado = statement.getResultSet();

            while(resultado.next()) {
                contas.add(new Contas(resultado.getString("nome"),
                        resultado.getString("tipo"),
                        resultado.getInt("cpf"),
                        resultado.getDouble("saldo")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return contas;
    }
    
    public ArrayList<Conta> exibirContasCliente(int cliente_id) {
        ArrayList<Conta> contas = new ArrayList<>();
        String sql = "SELECT conta_id,tipo,saldo FROM contas WHERE cliente_id = ?" ;
        
         try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cliente_id);
            statement.execute();

            ResultSet resultado = statement.getResultSet();

            while(resultado.next()) {
                contas.add(new Conta(resultado.getInt("conta_id"),
                        cliente_id,
                        resultado.getDouble("saldo"),
                        resultado.getString("tipo")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return contas;
    }

}
