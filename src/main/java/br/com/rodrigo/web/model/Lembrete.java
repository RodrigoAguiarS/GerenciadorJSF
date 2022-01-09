package br.com.rodrigo.web.model;

import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String titulo;

    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date inicio;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date criacao = new Date();

    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String prioridade;

    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String responsavel;

    public Lembrete() {
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

}