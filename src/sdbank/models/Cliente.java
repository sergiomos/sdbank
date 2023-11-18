/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.models;

public class Cliente extends Pessoa {

    private int clienteId;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    private ContaSalario contaSalario;

    public Cliente(int clienteId, String nome, String senha, int cpf) {
        super(nome, senha, cpf);

        this.clienteId = clienteId;
    }

    public Cliente(int clienteId, ContaCorrente contaCorrente, ContaPoupanca contaPoupanca, ContaSalario contaSalario, String nome, String senha, int cpf) {
        super(nome, senha, cpf);
        this.clienteId = clienteId;
        this.contaCorrente = contaCorrente;
        this.contaPoupanca = contaPoupanca;
        this.contaSalario = contaSalario;
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

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    public ContaSalario getContaSalario() {
        return contaSalario;
    }

    public void setContaSalario(ContaSalario contaSalario) {
        this.contaSalario = contaSalario;
    }
    
    

    @Override
    public String toString() {
        return "Cliente{" + "clienteId=" + clienteId + '}';
    }
    
    

}
