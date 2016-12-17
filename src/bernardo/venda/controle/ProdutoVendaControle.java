/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;


import bernardo.venda.pojo.Caixa;
import bernardo.venda.pojo.ProdutoVenda;
import bernardo.venda.pojo.Transacao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;


/**
 * @author ryuuzaki
 */
public class ProdutoVendaControle extends AbstractControle<ProdutoVenda> {

    public ProdutoVenda guardar(ProdutoVenda e) {
        return super.save(e);
    }

    public ProdutoVenda atualizar(ProdutoVenda e) {
        return super.update(e);
    }

    public boolean remover(ProdutoVenda e) {
        return super.delete(e);
    }

    public List<ProdutoVenda> findAll(Transacao t) {
        List<ProdutoVenda> l = getSession().createCriteria(ProdutoVenda.class).add(Restrictions.eq("transacao", t)).list();
        return l;
    }

    public List findAllM(Caixa caixa) {
        Criteria crit = getSession().createCriteria(ProdutoVenda.class, "pv").setProjection(
                Projections.projectionList()
                        .add(Projections.property("produto"))
                        .add(Projections.sum("quantidade"))
                        .add(Projections.sum("quantEntrada"))
                        .add(Projections.sum("quantSaida"))
                        .add(Projections.groupProperty("produto"))).createCriteria("transacao").add(Restrictions.eq("caixa", caixa));

        List results = crit.list();
        return results;
    }

}
