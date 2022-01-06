package br.com.rodrigo.web.bean;

import br.com.rodrigo.web.mapper.LembreteMapper;
import br.com.rodrigo.web.model.Lembrete;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class LembreteBean {
    private Lembrete lembrete;
    private LembreteMapper mapper = new LembreteMapper();

    @PostConstruct
    public void init() {
        lembrete = new Lembrete();
    }

    public Lembrete getLembrete() {
        return lembrete;
    }
    public List<Lembrete> getLembretes() {
        return mapper.getLembretes();

    }
    public String adicionar(){
        mapper.adicionar(lembrete);

        lembrete = new Lembrete();

        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage("Lembrete adicionado com sucesso!"));
        context.getExternalContext().getFlash().setKeepMessages(true);

        return "home";
    }
    public String remover(){
        mapper.remover(lembrete);

        lembrete = new Lembrete();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Tarefa removida com sucesso"));
        context.getExternalContext().getFlash().setKeepMessages(true);

        return "home";
    }
    public String editar(){
        mapper.editar(lembrete);

        lembrete = new Lembrete();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Tarefa editado com sucesso"));
        context.getExternalContext().getFlash().setKeepMessages(true);

        return "home";

    }
    public void lembretePorId() {
        lembrete = mapper.buscar(lembrete.getId());

        if (lembrete == null || lembrete.getId() == 0){
            lembrete = new Lembrete();

            FacesMessage message = new FacesMessage("Tarefa não encontrada.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
