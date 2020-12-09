/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.domain.impl;

import javafx.scene.control.CheckBox;

/**
 *
 * @author CIANDT\ewerton
 */
public class Veiculo {

    private Long id;
    private String placa;
    private Long ano;
    private String nome;
    private String cor;
    private int qtd;
    private float valorLocacao;

    public Veiculo(String placa, Long ano, String nome, String cor, Long id, int qtd, float valorLocacao) {
        this.placa = placa;
        this.ano = ano;
        this.nome = nome;
        this.cor = cor;
        this.id = id;
        this.valorLocacao = valorLocacao;
        this.qtd = qtd;
    }

    public Veiculo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }


    @Override
    public String toString() {

        if (qtd == 0) {
            return this.getNome() + "  " + this.getCor() + "\n"
                    + "Ano: " + this.getAno()
                    + "\nValor p/ dia: " + "" + this.getValorLocacao();
        }

        return "Carro: " + nome + "\n"
                + "Cor: " + cor + "\n\n"
                + "Placa: " + placa + "\n"
                + "Ano: " + ano + "\n\n"
                + "Qtd dias: " + qtd + "\n"
                + "Diaria: " + valorLocacao + "\n\n";

    }

}
