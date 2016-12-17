/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;

import bernardo.venda.pojo.Produto;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ryuuzaki
 */
public class ProdutoControle extends AbstractControle<Produto> {

    public Produto guardar(Produto e) {
        return super.save(e);
    }

    public Produto atualizar(Produto e) {
        return super.update(e);
    }

    public boolean remover(Produto e) {
        return super.delete(e);
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> l = getSession().createCriteria(Produto.class).addOrder(Order.asc("descricao")).list();
        return l;
    }

    public List<Produto> findAllAvalaible() {
        List<Produto> l = getSession().createCriteria(Produto.class).add(Restrictions.not(Restrictions.eq("quantidadeActual", 0))).addOrder(Order.asc("descricao")).list();
        return l;
    }

    public List<Produto> findAllUnvalaible() {
        List<Produto> l = getSession().createCriteria(Produto.class).add(Restrictions.eq("quantidadeActual", 0)).addOrder(Order.asc("descricao")).list();
        return l;
    }

    public List<Produto> findAllAbaixoStock() {
        String sql = "from Produto where quantidade_actual < quantidade_min and quantidade_actual !=0 order by descricao";
        Query query = getSession().createQuery(sql);
        List<Produto> l = query.list();
        return l;
    }

    public List<String> produtosNome() {
        List<String> nomes = new ArrayList<>();
        List<Produto> prod = findAllAvalaible();
        for (int i = 0; i < prod.size(); i++) {
            nomes.add(prod.get(i).getDescricao());
        }
        return nomes;
    }
}
