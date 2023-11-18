/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import javax.swing.JOptionPane;
import sdbank.db.ClienteDAO;
import sdbank.db.GerenteDAO;
import sdbank.db.Postgresql;
import sdbank.models.Cliente;
import sdbank.models.Gerente;
import sdbank.views.ClienteFrame;
import sdbank.views.GerenteFrame;

import sdbank.views.LoginFrame;

/**
 *
 * @author sergi
 */
public class LoginController {

    private LoginFrame view;
    private Connection conn;
    private ClienteDAO clienteDAO;    
    private GerenteDAO gerenteDAO;


    public LoginController(LoginFrame view) {
        this.view = view;

        try {
            conn = new Postgresql().connect();
            clienteDAO = new ClienteDAO(conn);            
            gerenteDAO = new GerenteDAO(conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void login() {
        int cpf = Integer.parseInt(view.getTxtCPF().getText());
        String senha = String.valueOf(view.getTxtSenha().getPassword());

        Optional<Cliente> cliente = clienteDAO.consultarPorCpfSenha(cpf, senha);
        Optional<Gerente> gerente = gerenteDAO.consultarPorCpfSenha(cpf, senha);
        
        System.out.println(gerente);


        if (!cliente.isEmpty()) {
            view.setVisible(false);
            new ClienteFrame(cliente.get()).setVisible(true);
        } else if(!gerente.isEmpty()){
            view.setVisible(false);
            new GerenteFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Login não efetuado", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

}
