/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sdbank.db.ContaDAO;
import sdbank.db.OperacaoDAO;
import sdbank.db.Postgresql;
import sdbank.models.Cliente;
import sdbank.models.Conta;
import sdbank.models.Operacao;
import sdbank.views.ClienteFrame;
import sdbank.views.DebitoFrame;
import sdbank.views.DepositoFrame;
import sdbank.views.ExibirSaldoClienteFrame;
import sdbank.views.ExtratoFrame;

/**
 *
 * @author sergi
 */
public class ClienteController {

    private ClienteFrame view;
    private Connection conn;
    private ContaDAO contaDAO;
    private Cliente cliente;
    private OperacaoDAO operacaoDAO;

    public ClienteController(ClienteFrame view, Cliente cliente) {
        this.view = view;
        this.cliente = cliente;

        try {
            conn = new Postgresql().connect();
            contaDAO = new ContaDAO(conn);
            operacaoDAO = new OperacaoDAO(conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void exibirSaldos() {
        ExibirSaldoClienteFrame frame = view.getExibirSaldoClienteFrame();
        frame.setVisible(true);

        JTable table = frame.getTableContas();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setNumRows(0);
        table.setModel(model);

        ArrayList<Conta> contas = new ArrayList<>();

        contas.add(cliente.getContaCorrente());
        contas.add(cliente.getContaSalario());
        contas.add(cliente.getContaPoupanca());

        for (Conta conta : contas) {
            System.out.println(conta);
            if (conta != null) {
                Object[] row = {conta.getTipo(), conta.getSaldo()};
                model.addRow(row);
            }
        }

        table.setModel(model);
    }

    public void depositar() {
        DepositoFrame frame = view.getDepositoFrame();
        String tipoConta = frame.getComboTipo().getSelectedItem().toString();
        double valor = Double.parseDouble(frame.getTxtValor().getText());
        Conta conta = null;

        switch (tipoConta) {
            case "Conta Salário" ->
                conta = cliente.getContaSalario();
            case "Conta Poupança" ->
                conta = cliente.getContaPoupanca();
            case "Conta Corrente" ->
                conta = cliente.getContaCorrente();
        }

        if (conta != null) {
            Operacao operacao = conta.depositar(valor);
            contaDAO.atualizar(conta);
            operacaoDAO.salvar(operacao);

            JOptionPane.showMessageDialog(view, "Depósito efetuado com sucesso");
        } else {
            JOptionPane.showMessageDialog(view, "Conta não cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void debitar() {
        DebitoFrame frame = view.getDebitoFrame();
        String tipoConta = frame.getComboTipo().getSelectedItem().toString();
        double valor = Double.parseDouble(frame.getTxtValor().getText());
        Conta conta = null;

        switch (tipoConta) {
            case "Conta Salário" ->
                conta = cliente.getContaSalario();
            case "Conta Poupança" ->
                conta = cliente.getContaPoupanca();
            case "Conta Corrente" ->
                conta = cliente.getContaCorrente();
        }

        if (conta != null) {
            Operacao operacao = conta.debitar(valor);
            contaDAO.atualizar(conta);
            operacaoDAO.salvar(operacao);

            JOptionPane.showMessageDialog(view, "Débito efetuado com sucesso");
        } else {
            JOptionPane.showMessageDialog(view, "Conta não cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void extrato() {
        ExtratoFrame frame = view.getExtratoFrame();
        String tipoConta = frame.getComboTipo().getSelectedItem().toString();
        Conta conta = null;

        switch (tipoConta) {
            case "Conta Salário" ->
                conta = cliente.getContaSalario();
            case "Conta Poupança" ->
                conta = cliente.getContaPoupanca();
            case "Conta Corrente" ->
                conta = cliente.getContaCorrente();
        }

        if (conta != null) {
            ArrayList<Operacao> operacoes = operacaoDAO.consultarTodas(conta.getContaId());

            JTable table = frame.getTableExtrato();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            model.setNumRows(0);
            table.setModel(model);

            for (Operacao operacao : operacoes) {
                Object[] row = {operacao.getData(), operacao.getTipo(), operacao.getValor(), operacao.getTarifa(), operacao.getSaldo()};
                model.addRow(row);
            }

            table.setModel(model);

        } else {
            JOptionPane.showMessageDialog(view, "Conta não cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
