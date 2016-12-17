/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;

import bernardo.venda.pojo.Empresa;

/**
 * @author ryuuzaki
 */
public class EmpresaControle extends AbstractControle<Empresa> {

    public Empresa guardar(Empresa c) {
        return super.save(c);
    }

    public Empresa atualizar(Empresa c) {
        return super.update(c);
    }

    public boolean remover(Empresa c) {
        return super.delete(c);
    }

    public Empresa buscaPorNome(String c) {
        return super.findByName("descricao", c);
    }


}
