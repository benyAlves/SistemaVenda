/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.tablemodel;


import bernardo.venda.pojo.Movimento;
import bernardo.venda.util.Util;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Bernardo Alves
 */
public class TabelaMovimento extends AbstractTableModel {

    private static final int NR_COLUNAS = 7;
    private static final String[] colunasNomes = {"Produto", "Entrada", "Saida", "Vendas", "Total Vendas", "Lucro", "Estoque"};
    private static List<Movimento> list;
    private final Class<?>[] colunaTipos = {String.class, Integer.class, Integer.class, Integer.class, Double.class, Double.class, Integer.class};

    public TabelaMovimento(List<Movimento> list) {
        TabelaMovimento.list = list;
    }

    public TabelaMovimento() {
    }

    public static Movimento getMovimentoAt(int index) {
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
        Movimento e = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getProduto();
            case 1:
                return e.getEntrada();
            case 2:
                return e.getSaida();
            case 3:
                return e.getqVendida();
            case 4:
                return Util.formatarMoeda(e.getVendas());
            case 5:
                return Util.formatarMoeda(e.getLucro());
            case 6:
                return e.getEstoque();
        }
        return null;
    }

}
