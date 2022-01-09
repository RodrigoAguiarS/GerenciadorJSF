package br.com.rodrigo.web.model;

import java.util.Date;


import javax.persistence.*;


@Entity
public class Lembrete {
    @Id
    private long id;
    private String titulo;
    private String descricao;
    private String responsavel;
    private String prioridade;
    private Date data;


    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Lembrete() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }



    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}