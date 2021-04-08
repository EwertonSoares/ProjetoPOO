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
public abstract class Usuario {

    final private String nome;
    final private String sobrenome;
    final private String telefone;
    final private Endereco endereco;
    final private String email;
    final private String senha;
    final private Long id;

    public Usuario(Long id, String nome, String sobrenome, String telefone, Endereco endereco, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
   
}
