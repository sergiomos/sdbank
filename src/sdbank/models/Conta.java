package sdbank.models;


public class Conta {
    protected int contaId, clienteId;
    protected double saldo;
    protected String tipo;

    public Conta() {
    }
    
    public Conta(int clienteId, double saldo, String tipo) {
        this.clienteId = clienteId;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public Conta(int contaId, int clienteId, double saldo, String tipo) {
        this.contaId = contaId;
        this.clienteId = clienteId;
        this.saldo = saldo;
        this.tipo = tipo;
    }

  

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Operacao depositar(double valor){
        return null;
    }
    
     public Operacao debitar(double valor){
        return null;
    }

    @Override
    public String toString() {
        return "Conta{" + "contaId=" + contaId + ", clienteId=" + clienteId + ", saldo=" + saldo + ", tipo=" + tipo + '}';
    }
    
   
  
    
    
}
