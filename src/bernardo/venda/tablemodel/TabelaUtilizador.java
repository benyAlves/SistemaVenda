/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.tablemodel;

import bernardo.venda.pojo.Utilizador;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author ryuuzaki
 */
public class TabelaUtilizador extends AbstractTableModel {

    private static final int NR_COLUNAS = 3;
    private static final String[] colunasNomes = {"Nome Completo", "Utilizador", "Perfil"};
    private static List<Utilizador> list;
    private final Class<?>[] colunaTipos = {String.class, String.class, String.class};

    public TabelaUtilizador(List<Utilizador> list) {
        TabelaUtilizador.list = list;
    }

    public static Utilizador getUtilizadorAt(int index) {
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
        Utilizador c = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getNomeCompleto();
            case 1:
                return c.getNomeUtilizador();
            case 2:
                return c.getPerfil();
        }
        return null;
    }
}
