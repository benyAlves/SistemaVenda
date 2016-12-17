/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;

import bernardo.venda.pojo.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ryuuzaki
 */
public class ClienteControle extends AbstractControle<Cliente> {

    public Cliente guardar(Cliente e) {
        return super.save(e);
    }

    public Cliente atualizar(Cliente e) {
        return super.update(e);
    }

    public boolean remover(Cliente e) {
        return super.delete(e);
    }

    public List<String> produtosNome() {
        List<String> nomes = new ArrayList<>();
        List<Cliente> prod = super.findAll();
        for (int i = 0; i < prod.size(); i++) {
            nomes.add(prod.get(i).getNome());
        }
        return nomes;
    }
}
