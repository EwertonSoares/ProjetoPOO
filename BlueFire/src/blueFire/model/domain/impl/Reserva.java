/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.domain.impl;

import java.sql.Date;

/**
 *
 * @author CIANDT\ewerton
 */
public class Reserva {

    private Cliente cliente;
    private Veiculo veiculo;
    private Date DataLocacao;
    private Date DataDevolucao;
    private boolean retirado;

    public Reserva(Cliente cliente, Veiculo veiculo, Date DataLocacao, Date DataDevolucao, boolean retirado) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.DataLocacao = DataLocacao;
        this.DataDevolucao = DataDevolucao;
        this.retirado = retirado;
    }

    public Reserva() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataLocacao() {
        return DataLocacao;
    }

    public void setDataLocacao(Date DataLocacao) {
        this.DataLocacao = DataLocacao;
    }

    public Date getDataDevolucao() {
        return DataDevolucao;
    }

    public void setDataDevolucao(Date DataDevolucao) {
        this.DataDevolucao = DataDevolucao;
    }

    public boolean isRetirado() {
        return retirado;
    }

    public void setRetirado(boolean retirado) {
        this.retirado = retirado;
    }
   
    @Override
    public String toString() {
        String retirado = this.isRetirado() == true ? "SIM" : "NÃO";
        
        return "DADOS DO CLIENTE:\n" +"  Nome: "+ this.cliente.getNome().concat(" ").concat(this.cliente.getSobrenome())+"\n"
                +"  Email: "+ this.cliente.getEmail() + "\n" +"  Bairro: "+ this.cliente.getEndereco().getBairro() + "\n"
                +"  "+ this.cliente.getEndereco().getRua() +"\n" + "  Numero: " + this.cliente.getEndereco().getNumero() + "\n"
                +"  Telefone: "+ this.cliente.getTelefone() + "\n"
                +"\n\nDADOS DO VEICULO:\n" +"  Nome: "+ this.veiculo.getNome() + "\n" 
                +"  Cor: "+ this.veiculo.getCor() + "\n" +"  Ano:"+ this.veiculo.getAno() + "\n"
                +"  Placa: "+ this.veiculo.getPlaca() + "\n"+ "  Valor p/ dia: "+ this.veiculo.getValorLocacao() +"\n"
                +"  Qtd dias locação: "+ this.veiculo.getQtdDiasLocacao() +"\n"
                + "\n\nData da reserva: " + this.getDataLocacao() + "\n"
                +"Data prevista\np/ devolução: " + this.getDataDevolucao() + "\n"
               +"Retirado: " + retirado;
    }

}
