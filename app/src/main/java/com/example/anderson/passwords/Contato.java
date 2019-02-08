package com.example.anderson.passwords;

public class Contato {


    private String login;
    private  String senha;
    private  String descricao;


    Contato(String login, String senha, String descricao){

        this.login = login;
        this.senha = senha;
        this.descricao = descricao;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
