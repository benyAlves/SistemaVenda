/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;

import bernardo.venda.pojo.Caixa;
import bernardo.venda.pojo.Transacao;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;


/**
 * @author ryuuzaki
 */
public class TransacaoControle extends AbstractControle<Transacao> {

    public Transacao guardar(Transacao e) {
        return super.save(e);
    }

    public Transacao atualizar(Transacao e) {
        return super.update(e);
    }

    public boolean remover(Transacao e) {
        return super.delete(e);
    }

    @Override
    public List<Transacao> findAll() {
        List<Transacao> l = getSession().createCriteria(Transacao.class).addOrder(Order.asc("data")).list();
        return l;
    }


    public List<Transacao> findAllByCaixa(Caixa c) {
        List<Transacao> l = getSession().createCriteria(Transacao.class).add(Restrictions.eq("caixa", c)).addOrder(Order.desc("data")).addOrder(Order.desc("hora")).list();
        return l;
    }

    public List<Transacao> findAllByDate(Date d) {
        List<Transacao> l = getSession().createCriteria(Transacao.class).add(
                Restrictions.and(
                        Restrictions.eq("hora", d), 
                        Restrictions.eq("tipo", "Venda"), 
                        Restrictions.eq("cancelado", "Não"))).addOrder(Order.desc("data")).list();
        return l;
    }

}
