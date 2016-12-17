/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.tablemodel;


import bernardo.venda.pojo.ProdutoVenda;
import bernardo.venda.util.Util;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Bernardo Alves
 */
public class TabelaProdutoVenda extends AbstractTableModel {

    private static final int NR_COLUNAS = 4;
    private static final String[] colunasNomes = {"Nome/Descrição", "Valor Unitário", "Quantidade", "Valor Total"};
    private static List<ProdutoVenda> list;
    private final Class<?>[] colunaTipos = {String.class, String.class, Integer.class, String.class};

    public TabelaProdutoVenda(List<ProdutoVenda> list) {
        TabelaProdutoVenda.list = list;
    }

    public TabelaProdutoVenda() {
    }

    public static ProdutoVenda getProdutoVendaAt(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return NR_COLUNAS;
    }

    @Override
    public String getColumnName(int column) {
        return colunasNomes[column];
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        return colunaTipos[coluna];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProdutoVenda e = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getProduto().getDescricao();
            case 1:
                return Util.formatarMoeda(e.getProduto().getPrecoVenda());
            case 2:
                return e.getQuantidade();
            case 3:
                return Util.formatarMoeda(e.getQuantidade() * e.getProduto().getPrecoVenda());
        }
        return null;
    }

}
