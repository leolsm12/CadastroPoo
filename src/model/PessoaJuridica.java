/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author leosc
 */
public class PessoaJuridica extends Pessoa implements Serializable{

    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append("\n");
        sb.append("Nome: ").append(getNome()).append("\n");
        sb.append("CNPJ: ").append(cnpj);
    return sb.toString();
    }

    
}
