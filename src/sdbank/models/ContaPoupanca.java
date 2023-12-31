/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.models;

import java.time.LocalDateTime;

/**
 *
 * @author sergi
 */
public class ContaPoupanca extends Conta {

    private final double tarifa = 0;

    public ContaPoupanca(int clienteId, double saldo) {
        super(clienteId, saldo, "Conta Poupança");
    }

    public ContaPoupanca(int contaId, int clienteId, double saldo) {
        super(contaId, clienteId, saldo, "Conta Poupança");
    }

    @Override
    public Operacao depositar(double valor) {
        this.saldo += valor;
        Operacao op = new Operacao(contaId, "+", LocalDateTime.now().toString(), valor, 0, saldo);

        return op;
    }

    @Override
    public Operacao debitar(double valor) {
        double valorTarifado = valor * tarifa;
        this.saldo -= valor + valorTarifado;
        Operacao op = new Operacao(contaId, "-", LocalDateTime.now().toString(), valor, valorTarifado, saldo);

        return op;
    }

}
