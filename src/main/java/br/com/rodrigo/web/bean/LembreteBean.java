package br.com.rodrigo.web.bean;


import br.com.rodrigo.web.dao.LembreteDao;
import br.com.rodrigo.web.model.Lembrete;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@ViewScoped
public class LembreteBean {

    private Lembrete lembrete;
    private LembreteDao lembreteDao;
    private List<Lembrete> lembretes;

    @PostConstruct
    public void init() {
        lembreteDao = new LembreteDao();
        lembrete = new Lembrete();

        try {
            lembretes = lembreteDao.listarTodos();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public Lembrete getLembrete() {
        return lembrete;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public String inserir() {
        try {
            lembreteDao.inserir(lembrete);

            lembretes = lembreteDao.listarTodos();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Tarefa adicionado com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

        return "home";
    }

    public String atualizar() {
        try {
            lembreteDao.atualizar(lembrete);

            lembretes = lembreteDao.listarTodos();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Tarefa editado com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

        return "home";
    }

    public String excluir() {
        try {
            lembreteDao.excluir(lembrete.getId());

            lembretes = lembreteDao.listarTodos();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Tarefa removido com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

        return "home";
    }

    public void selecionar() {
        try {
            lembrete = lembreteDao.selecionar(lembrete.getId());

            if (lembrete == null || lembrete.getId() == 0) {
                lembrete = new Lembrete();

                throw new Exception("Tarefa n??o encontrado.");
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }
}
