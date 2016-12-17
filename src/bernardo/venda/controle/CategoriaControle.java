/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;

import bernardo.venda.pojo.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ryuuzaki
 */
public class CategoriaControle extends AbstractControle<Categoria> {

    public Categoria guardar(Categoria c) {
        return super.save(c);
    }

    public Categoria atualizar(Categoria c) {
        return super.update(c);
    }

    public boolean remover(Categoria c) {
        return super.delete(c);
    }

    public Categoria buscaPorNome(String c) {
        return super.findByName("descricao", c);
    }

    public List<String> categorias() {
        List<String> nomes = new ArrayList<>();
        List<Categoria> cat = super.findAll();
        for (int i = 0; i < cat.size(); i++) {
            nomes.add(cat.get(i).getDescricao());
        }
        return nomes;
    }

}
