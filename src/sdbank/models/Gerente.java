/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdbank.models;

/**
 *
 * @author sergi
 */
public class Gerente extends Pessoa{
    private int gerenteId;
    
    public Gerente(int gerenteId, String nome, String senha, int cpf) {
        super(nome, senha, cpf);
        this.gerenteId = gerenteId;
    }

    public Gerente(String nome, String senha, int cpf) {
        super(nome, senha, cpf);
    }

    public int getGerenteId() {
        return gerenteId;
    }

    public void setGerenteId(int gerenteId) {
        this.gerenteId = gerenteId;
    }

    @Override
    public String toString() {
        return "Gerente{" + "gerenteId=" + gerenteId + '}';
    }
    
}
