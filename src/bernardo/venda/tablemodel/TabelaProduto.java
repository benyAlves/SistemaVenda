/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.tablemodel;

import bernardo.venda.pojo.Produto;
import bernardo.venda.util.Util;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Bernardo Alves
 */
public class TabelaProduto extends AbstractTableModel {

    private static final int NR_COLUNAS = 12;
    private static final String[] colunasNomes = {"Código", "Descrição", "Estoque", "Preço", "Categoria", "Custo", "Lucro", "Estoque Mínimo", "Estoque Máximo", "Fornecedor", "Estado", "Observação"};
    private static List<Produto> list;
    private final Class<?>[] colunaTipos = {String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, String.class};

    public TabelaProduto(List<Produto> list) {
        TabelaProduto.list = list;
    }

    public TabelaProduto() {
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
            case 3:
                return Util.formatarMoeda(e.getPrecoVenda());
            case 4:
                return e.getCategoria().getDescricao();
            case 5:
                return Util.formatarMoeda(e.getPrecoCompra());
            case 6:
                return Util.formatarMoeda(e.getPrecoVenda() - e.getPrecoCompra());
            case 7:
                return e.getQuantidadeMin();
            case 8:
                return e.getQuantidadeMax();
            case 9: {
                if (e.getFornecedor() != null) {
                    return e.getFornecedor().getNome();
                } else {
                    return "";
                }
            }
            case 10: {
                if (e.getQuantidadeActual() >= e.getQuantidadeMin()) {
                    return "Disponível";
                } else if ((e.getQuantidadeActual() == 0)) {
                    return "Indisponível";
                } else {
                    return "Abaixo do Estoque Mínimo";
                }
            }
            case 11:
                return e.getObservacao();
        }
        return null;
    }

}
