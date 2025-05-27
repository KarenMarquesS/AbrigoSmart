package org.example.abrigosmart.dto;

import org.example.abrigosmart.model.FuncaoEnum;
import org.example.abrigosmart.model.Relatorio;

import java.util.List;

public class UsuarioDTO {

    private int id_user;
    private String nome_completo;
    private FuncaoEnum funcao;
    private String email;
    private String senha;
    private List<Relatorio> gera_report;


    public UsuarioDTO() {
    }


    public UsuarioDTO(int id_user, String nome_completo, FuncaoEnum funcao, String email, String senha, List<Relatorio> gera_report) {
        this.id_user = id_user;
        this.nome_completo = nome_completo;
        this.funcao = funcao;
        this.email = email;
        this.senha = senha;
        this.gera_report = gera_report;
    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public FuncaoEnum getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoEnum funcao) {
        this.funcao = funcao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Relatorio> getGera_report() {
        return gera_report;
    }

    public void setGera_report(List<Relatorio> gera_report) {
        this.gera_report = gera_report;
    }
}
