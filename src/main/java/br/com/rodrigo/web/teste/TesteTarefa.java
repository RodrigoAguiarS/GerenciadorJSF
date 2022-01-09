package br.com.rodrigo.web.teste;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteTarefa {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Lembrete");

    }
}
