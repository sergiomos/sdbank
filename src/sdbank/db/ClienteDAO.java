package sdbank.db;

import java.sql.Connection;
import java.util.Optional;
import sdbank.models.Cliente;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO implements IDAO<Cliente> {

    private Connection conn;
    private ContaDAO contaDAO;

    public ClienteDAO() {
    }

    public ClienteDAO(Connection conn) {
        this.conn = conn;
        contaDAO = new ContaDAO(conn);
    }

    @Override
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO clientes(nome, cpf, senha) VALUES(?, ?, ?)";
        try {
            String colunas[] = {"cliente_id"};
            PreparedStatement statement = conn.prepareStatement(sql, colunas);
            statement.setString(1, cliente.getNome());
            statement.setInt(2, cliente.getCpf());
            statement.setString(3, cliente.getSenha());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                cliente.setClienteId(generatedKeys.getInt("cliente_id"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int deletar(int cpf) {
        String sql = "DELETE FROM clientes WHERE cpf = ?";
        int res = 0;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cpf);
            res = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return res;

    }

    public Optional<Cliente> consultarPorCpfSenha(int cpf, String senha) {
        Optional<Cliente> cliente = Optional.empty();
        String sql = "SELECT * from clientes WHERE cpf = ? AND senha = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cpf);
            statement.setString(2, senha);
            statement.execute();

            ResultSet resultado = statement.getResultSet();

            if (resultado.next()) {
                cliente = Optional.ofNullable(new Cliente(
                        resultado.getInt("cliente_id"),
                        resultado.getString("nome"),
                        resultado.getString("senha"),
                        resultado.getInt("cpf")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cliente;
    }
    
    public Optional<Cliente> consultarPorCpf(int cpf) {
        Optional<Cliente> cliente = Optional.empty();
        String sql = "SELECT * from clientes WHERE cpf = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cpf);
            statement.execute();

            ResultSet resultado = statement.getResultSet();
            

            if (resultado.next()) {
                int clienteId = resultado.getInt(1);

                cliente = Optional.ofNullable(new Cliente(
                        clienteId,
                        contaDAO.exibirContasCliente(clienteId),
                        resultado.getString("nome"),
                        resultado.getString("senha"),
                        resultado.getInt("cpf")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cliente;
    }
}
