/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.models;

/**
 *
 * @author sergi
 */
public class Contas {
    private String nome, tipo;
    private int cpf;
    private double saldo;

    public Contas(String nome, String tipo, int cpf, double saldo) {
        this.nome = nome;
        this.tipo = tipo;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Contas{" + "nome=" + nome + ", tipo=" + tipo + ", cpf=" + cpf + ", saldo=" + saldo + '}';
    }
    
    
}
