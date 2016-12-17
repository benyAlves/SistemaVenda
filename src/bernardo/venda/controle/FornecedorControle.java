/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;

import bernardo.venda.pojo.Fornecedor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ryuuzaki
 */
public class FornecedorControle extends AbstractControle<Fornecedor> {

    public Fornecedor guardar(Fornecedor c) {
        return super.save(c);
    }

    public Fornecedor atualizar(Fornecedor c) {
        return super.update(c);
    }

    public boolean remover(Fornecedor c) {
        return super.delete(c);
    }

    public Fornecedor buscaPorNome(String nome) {
        return super.findByName("nome", nome);
    }

    public List<String> fornecedoresNomes() {
        List<String> nomes = new ArrayList<>();
        nomes.add("Nenhum");
        List<Fornecedor> cat = super.findAll();
        for (int i = 0; i < cat.size(); i++) {
            nomes.add(cat.get(i).getNome());
        }
        return nomes;
    }

}
