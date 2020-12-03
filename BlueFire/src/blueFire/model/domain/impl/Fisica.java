/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.domain.impl;

/**
 *
 * @author CIANDT\ewerton
 */
public class Fisica extends Cliente{
    private String cpf;

    public Fisica(String email, String senha) {
        super(email, senha);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }   

    public boolean logar(String email, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
