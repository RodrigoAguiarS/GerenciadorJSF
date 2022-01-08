package br.com.rodrigo.web.teste;

import br.com.rodrigo.web.model.Lembrete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteTarefa {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Lembrete tarefa = new Lembrete();

    }
}
