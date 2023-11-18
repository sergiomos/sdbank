/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.models;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sergi
 */
public class ContaCorrente extends Conta {

    private final double tarifa = 0.01;

    public ContaCorrente(int clienteId, double saldo) {
        super(clienteId, saldo, "Conta Corrente");
    }

    public ContaCorrente(int contaId, int clienteId, double saldo) {
        super(contaId, clienteId, saldo, "Conta Corrente");
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
