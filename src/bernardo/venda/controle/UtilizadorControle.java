/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;

import bernardo.venda.pojo.Utilizador;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ryuuzaki
 */
public class UtilizadorControle extends AbstractControle<Utilizador> {

    public Utilizador guardar(Utilizador e) {
        return super.save(e);
    }

    public Utilizador atualizar(Utilizador e) {
        return super.update(e);
    }

    public boolean remover(Utilizador e) {
        return super.delete(e);
    }

    public List<String> produtosNome() {
        List<String> nomes = new ArrayList<>();
        List<Utilizador> prod = super.findAll();
        for (int i = 0; i < prod.size(); i++) {
            nomes.add(prod.get(i).getNomeCompleto());
        }
        return nomes;
    }


    public Utilizador findById(Integer id) {
        return (Utilizador) getSession().createCriteria(Utilizador.class)
                .add(Restrictions.eq("idUtilizador", id)).uniqueResult();
    }

    public Utilizador login(String string, String text) {
        return (Utilizador) getSession().createCriteria(Utilizador.class)
                .add(Restrictions.and(Restrictions.eq("senha", string), Restrictions.eq("nomeUtilizador", text))).uniqueResult();
    }
}
