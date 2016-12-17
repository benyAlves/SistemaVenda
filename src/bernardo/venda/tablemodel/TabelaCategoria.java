/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.tablemodel;


import bernardo.venda.pojo.Categoria;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Bernardo Alves
 */
public class TabelaCategoria extends AbstractTableModel {

    private static final int NR_COLUNAS = 2;
    private static final String[] colunasNomes = {"Código", "Nome da Categoria"};
    private static List<Categoria> list;
    private final Class<?>[] colunaTipos = {Long.class, String.class};

    public TabelaCategoria(List<Categoria> list) {
        TabelaCategoria.list = list;
    }

    public TabelaCategoria() {
    }

    public static Categoria getCategoriaAt(int index) {
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
        Categoria c = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getIdCategoria();
            case 1:
                return c.getDescricao();
        }
        return null;
    }

}
