package br.com.rodrigo.web.bean;

import br.com.rodrigo.web.mapper.LembreteMapper;
import br.com.rodrigo.web.model.Lembrete;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class LembreteBean {
    private Lembrete lembrete;
    private LembreteMapper mapper = new LembreteMapper();

    public Lembrete getLembrete() {
        return lembrete;
    }
    public List<Lembrete> getLembretes() {
        return mapper.getLembretes();
    }
}
