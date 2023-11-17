/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.models;

import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class Cliente extends Pessoa {

    private int clienteId;
    private ArrayList<Conta> contas;

    public Cliente(int clienteId, String nome, String senha, int cpf) {
        super(nome, senha, cpf);

        this.clienteId = clienteId;
    }

    public Cliente(int clienteId, ArrayList<Conta> contas, String nome, String senha, int cpf) {
        super(nome, senha, cpf);
        this.clienteId = clienteId;
        this.contas = contas;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
    
    

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    

    public Cliente(String nome, String senha, int cpf) {
        super(nome, senha, cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteId=" + clienteId + '}';
    }
    
    

}
