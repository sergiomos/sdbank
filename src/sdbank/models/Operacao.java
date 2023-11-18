package sdbank.models;

import java.time.LocalDateTime;

public class Operacao {
    private int operacaoId, contaId;
    private String tipo, data;
    private double valor, tarifa, saldo;

    public Operacao(int contaId, String tipo, String data, double valor, double tarifa, double saldo) {
        this.contaId = contaId;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.tarifa = tarifa;
        this.saldo = saldo;
    }

    public Operacao(int operacaoId, int contaId, String tipo, String data, double valor, double tarifa, double saldo) {
        this.operacaoId = operacaoId;
        this.contaId = contaId;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.tarifa = tarifa;
        this.saldo = saldo;
    }
    

    public int getOperacaoId() {
        return operacaoId;
    }

    public void setOperacaoId(int operacaoId) {
        this.operacaoId = operacaoId;
    }

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Operacao{" + "operacao_id=" + operacaoId + ", conta_id=" + contaId + ", tipo=" + tipo + ", data=" + data + ", valor=" + valor + ", tarifa=" + tarifa + ", saldo=" + saldo + '}';
    }
}
