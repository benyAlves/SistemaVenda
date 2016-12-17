/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.tablemodel;

import bernardo.venda.pojo.Fornecedor;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Bernardo Alves
 */
public class TabelaFornecedor extends AbstractTableModel {

    private static final int NR_COLUNAS = 7;
    private static final String[] colunasNomes = {"Código", "Nome", "Telefone 1", "Telefone 2", "Email", "Descrição do Endereço", "Observação"};
    private static List<Fornecedor> list;
    private final Class<?>[] colunaTipos = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class};

    public TabelaFornecedor(List<Fornecedor> list) {
        TabelaFornecedor.list = list;
    }

    public TabelaFornecedor() {
    }

    public static Fornecedor getFornecedorAt(int index) {
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
        Fornecedor c = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getIdFornecedor();
            case 1:
                return c.getNome();
            case 2:
                return c.getTelelfone();
            case 3:
                return c.getCelular();
            case 4:
                return c.getEmail();
            case 5:
                return c.getEndereco().getBairro() + " " + c.getEndereco().getRuaAvenida() + " Nº" + c.getEndereco().getCasa();
            case 6:
                return c.getObservacao();
        }
        return null;
    }

}
