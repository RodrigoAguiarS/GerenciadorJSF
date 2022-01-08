package br.com.rodrigo.web.mapper;

import br.com.rodrigo.web.model.Lembrete;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LembreteMapper {

    private List<Lembrete> lembretes = new ArrayList<Lembrete>();

    public LembreteMapper() {
        Instant agora = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        //lembrete de comprar leite de forma inlustrativa, aqui seria o banco de dados.
        Lembrete lembrete = new Lembrete();
        lembrete.setId(1L);
        lembrete.setTitulo("Comprar leite");
        lembrete.setDescricao("Hoje, 11h");
        lembrete.setResponsavel("João");
        lembrete.setPrioridade("Alta");
        lembrete.setData(Date.from(agora));

        adicionar(lembrete);
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void adicionar(Lembrete lembrete) {
        lembrete.setId(lembretes.size() + 1);

        Instant agora = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date hoje = Date.from(agora);
        lembrete.setData(hoje);

        lembretes.add(lembrete);
    }

    public void remover(Lembrete lembrete) {
        try {
            lembrete = buscar(lembrete.getId());

            lembretes.remove(lembrete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editar(Lembrete lembrete) {
        try {
            for (Lembrete it : lembretes) {
                if (it.getId() == lembrete.getId()) {
                    it = lembrete;

                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Lembrete buscar(long id) {
        Lembrete lembrete = null;

        try {
            for (Lembrete it : lembretes) {
                if (it.getId() == id) {
                    lembrete = it;

                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lembrete;
    }
}
