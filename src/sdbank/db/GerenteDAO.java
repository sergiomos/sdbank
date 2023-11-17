package sdbank.db;

import java.sql.Connection;
import java.util.Optional;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sdbank.models.Gerente;

public class GerenteDAO implements IDAO<Gerente> {
    private Connection conn;
    private String gerenteIdColumn = "gerente_id";

    public GerenteDAO() {
    }

    public GerenteDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void salvar(Gerente gerente) {
        String sql = "INSERT INTO gerentes(nome, cpf, senha) VALUES(?, ?, ?)";
        try {
            String colunas[] = {gerenteIdColumn};
            PreparedStatement statement = conn.prepareStatement(sql, colunas);
            statement.setString(1, gerente.getNome());
            statement.setInt(2, gerente.getCpf());
            statement.setString(3, gerente.getSenha());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                gerente.setGerenteId(generatedKeys.getInt(gerenteIdColumn));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Optional<Gerente> consultarPorCpfSenha(int cpf, String senha) {
        Optional<Gerente> gerente = Optional.empty();
        String sql = "SELECT * from gerentes WHERE cpf = ? AND senha = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cpf);
            statement.setString(2, senha);
            statement.execute();

            ResultSet resultado = statement.getResultSet();

            if (resultado.next()) {
                gerente = Optional.ofNullable(new Gerente(
                        resultado.getInt(gerenteIdColumn),
                        resultado.getString("nome"),
                        resultado.getString("senha"),
                        resultado.getInt("cpf")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return gerente;
    }

}
