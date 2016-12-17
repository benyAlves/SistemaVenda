/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.tablemodel;


import bernardo.venda.pojo.Caixa;
import bernardo.venda.util.Util;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Bernardo Alves
 */
public class TabelaCaixa extends AbstractTableModel {

    private static final int NR_COLUNAS = 11;
    private static final String[] colunasNomes = {"Código", "Data e Hora Abertura", "Data e Hora Fechamento", "Funcionário", "Valor Inicial", "Valor Adicionado", "Valor Retirado", "Valor Final", "Valor Informado", "Quebra de Caixa", "Observações"};
    private static List<Caixa> list;
    private final Class<?>[] colunaTipos = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};

    public TabelaCaixa(List<Caixa> list) {
        TabelaCaixa.list = list;
    }

    public TabelaCaixa() {
    }

    public static Caixa getCaixaAt(int index) {
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
        Caixa c = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getIdCaixa();
            case 1:
                return c.getDataAbertura();
            case 2:
                return c.getDataFechamento();
            case 3:
                return c.getUtilizador().getNomeCompleto();
            case 4:
                return Util.formatarMoeda(c.getValorInicial());

            case 5: {
                if (c.getValorAdicionado() != null)
                    return Util.formatarMoeda(c.getValorAdicionado());
                else
                    return Util.formatarMoeda(0);
            }
            case 6: {
                if (c.getValorRetirado() != null)
                    return Util.formatarMoeda(c.getValorRetirado());
                else
                    return Util.formatarMoeda(0);
            }
            case 7:
                return Util.formatarMoeda(c.getValorFinal());
            case 8: {
                if (c.getValorInformado() != null)
                    return Util.formatarMoeda(c.getValorInformado());
                else
                    return Util.formatarMoeda(0);
            }
            case 9: {
                if (c.getValorInformado() != null)
                    return Util.formatarMoeda(c.getValorInformado() - c.getValorFinal());
                else
                    return Util.formatarMoeda(0);
            }
            case 10:
                return c.getObservacao();
        }
        return null;
    }

}
