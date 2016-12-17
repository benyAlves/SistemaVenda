/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.tablemodel;


import bernardo.venda.pojo.Produto;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Bernardo Alves
 */
public class TabelaProdutoEstoque extends AbstractTableModel {

    private static final int NR_COLUNAS = 3;
    private static final String[] colunasNomes = {"Código", "Descrição", "Quantidade"};
    private static List<Produto> list;
    private final Class<?>[] colunaTipos = {String.class, String.class, Double.class, Integer.class};

    public TabelaProdutoEstoque(List<Produto> list) {
        TabelaProdutoEstoque.list = list;
    }

    public TabelaProdutoEstoque() {
    }

    public static Produto getProdutoAt(int index) {
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
        Produto e = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getCodigoBarras();
            case 1:
                return e.getDescricao();
            case 2:
                return e.getQuantidadeActual();
        }
        return null;
    }

}
