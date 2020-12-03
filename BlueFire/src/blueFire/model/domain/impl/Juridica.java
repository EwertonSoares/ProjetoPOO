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
public class Juridica extends Cliente {
    private String cnpj;

    public Juridica(String email, String senha) {
        super(email, senha);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }   
}
