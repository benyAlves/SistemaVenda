/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;

import bernardo.venda.pojo.Caixa;
import bernardo.venda.pojo.Utilizador;
import org.hibernate.criterion.Restrictions;


/**
 * @author ryuuzaki
 */
public class CaixaControle extends AbstractControle<Caixa> {

    public Caixa guardar(Caixa e) {
        return super.save(e);
    }

    public Caixa atualizar(Caixa e) {
        return super.update(e);
    }

    public boolean remover(Caixa e) {
        return super.delete(e);
    }

    public Caixa findStateUser(boolean aberto, Utilizador u) {
        return (Caixa) getSession().createCriteria(Caixa.class)
                .add(Restrictions.and(Restrictions.eq("aberto", aberto), Restrictions.eq("utilizador", u))).uniqueResult();
    }


}
