/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.controllers;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Optional;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sdbank.db.ClienteDAO;
import sdbank.db.ContaDAO;
import sdbank.db.Postgresql;
import sdbank.models.Cliente;
import sdbank.models.Conta;
import sdbank.models.Contas;
import sdbank.views.CadastrarClienteFrame;
import sdbank.views.CadastrarContaNovoClienteFrame;
import sdbank.views.CriarContasFrame;
import sdbank.views.ExcluirClienteFrame;
import sdbank.views.ExibirContasFrame;
import sdbank.views.ExibirSaldoClienteFrame;
import sdbank.views.GerenteFrame;

/**
 *
 * @author sergi
 */
public class GerenteController {

    private GerenteFrame view;
    private Connection conn;
    private ClienteDAO clienteDAO;
    private ContaDAO contaDAO;
    private int clienteId;

    public GerenteController(GerenteFrame view) {
        this.view = view;
        try {
            conn = new Postgresql().connect();
            clienteDAO = new ClienteDAO(conn);
            contaDAO = new ContaDAO(conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletar() {
        ExcluirClienteFrame frame = view.getExcluirClienteFrame();
        JTextField txtCpf = frame.getTxtCPF();

        int cpf = Integer.parseInt(txtCpf.getText());
        int isDeleted = clienteDAO.deletar(cpf);

        if (isDeleted != 0) {
            JOptionPane.showMessageDialog(frame, "Cliente deletedo com sucesso");
            txtCpf.setText("");
        } else {
            JOptionPane.showMessageDialog(view, "Cliente não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cadastrarNovaConta() {
        CriarContasFrame frame = view.getCadastrarContaFrame();

        JComboBox<String> comboTipo = frame.getComboTipo();
        JTextField txtSaldo = frame.getTxtSaldo();
        JTextField txtCPF = frame.getTxtCPF();
        int cpf = Integer.parseInt(txtCPF.getText());

        Optional<Cliente> cliente = clienteDAO.consultarPorCpf(cpf);

        if (cliente.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Cliente não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            clienteId = cliente.get().getClienteId();

            Conta conta = new Conta(clienteId, Double.parseDouble(txtSaldo.getText()), comboTipo.getSelectedItem().toString());

            contaDAO.salvar(conta);

            if (conta.getContaId() != 0) {
                JOptionPane.showMessageDialog(frame, "Conta cadastrada com sucesso");
                txtSaldo.setText("");
            }
        }
    }

    public void cadastrarContaNovoCliente() {
        CadastrarContaNovoClienteFrame frame = view.getCadastrarContaNovoClienteFrame();
        JComboBox<String> comboTipo = frame.getComboTipo();
        JTextField txtSaldo = frame.getTxtSaldo();

        Conta conta = new Conta(clienteId, Double.parseDouble(txtSaldo.getText()), comboTipo.getSelectedItem().toString());

        contaDAO.salvar(conta);

        if (conta.getContaId() != 0) {
            JOptionPane.showMessageDialog(frame, "Conta cadastrada com sucesso");
            txtSaldo.setText("");
        }
    }

    public void cadastrarCliente() {
        CadastrarClienteFrame clienteFrame = view.getCadastrarClienteFrame();
        JTextField txtNome = clienteFrame.getTxtNome();
        JTextField txtSenha = clienteFrame.getTxtSenha();
        JTextField txtCPF = clienteFrame.getTxtCPF();

        boolean clienteExiste = !clienteDAO.consultarPorCpf(Integer.parseInt(txtCPF.getText())).isEmpty();

        if (clienteExiste) {
            JOptionPane.showMessageDialog(clienteFrame, "Cliente já cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Cliente cliente = new Cliente(
                    txtNome.getText(),
                    txtSenha.getText(),
                    Integer.parseInt(txtCPF.getText()));

            clienteDAO.salvar(cliente);

            if (cliente.getClienteId() != 0) {
                JOptionPane.showMessageDialog(clienteFrame, "Cliente cadastrado com sucesso");
                txtNome.setText("");
                txtSenha.setText("");
                txtCPF.setText("");
                view.getCadastrarContaNovoClienteFrame().setVisible(true);
                clienteId = cliente.getClienteId();
            }
        }

    }

    public void exibirContas() {
        ExibirContasFrame frame = view.getExibirContasFrame();
        frame.setVisible(true);

        JTable table = frame.getTableContas();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setNumRows(0);
        table.setModel(model);

        ArrayList<Contas> contas = contaDAO.exibirContas();

        for (Contas conta : contas) {
            Object[] row = {conta.getNome(), conta.getCpf(), conta.getTipo(), conta.getSaldo()};

            model.addRow(row);
        }

        table.setModel(model);

    }

    public void exibirSaldosCliente() {
        ExibirSaldoClienteFrame frame = view.getExibirSaldoClienteFrame();
        JTextField txtCPF = frame.getTxtCPF();
        
        JTable table = frame.getTableContas();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setNumRows(0);
        table.setModel(model);

        Optional<Cliente> cliente = clienteDAO.consultarPorCpf(Integer.parseInt(txtCPF.getText()));
        
        for(Conta conta : cliente.get().getContas()){
            Object[] row = {conta.getTipo(), conta.getSaldo()};
             model.addRow(row);
        }
        
         table.setModel(model);

    }
}
