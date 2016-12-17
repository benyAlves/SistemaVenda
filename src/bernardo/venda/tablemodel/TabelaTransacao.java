/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.tablemodel;

import bernardo.venda.pojo.Transacao;
import bernardo.venda.util.Util;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author ryuuzaki
 */
public class TabelaTransacao extends AbstractTableModel {

    private static final int NR_COLUNAS = 10;
    private static final String[] colunasNomes = {"Data", "Hora", "Tipo", "Valor", "Desconto", "Valor Final", "Utilizador", "Cancelado", "Data de Cancelamento", "Cancelado Por"};
    private static List<Transacao> list;
    private final Class<?>[] colunaTipos = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};

    public TabelaTransacao(List<Transacao> list) {
        TabelaTransacao.list = list;
    }

    public static Transacao getTransacaoAt(int index) {
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
        Transacao c = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return new SimpleDateFormat("dd/MMM/yyyy").format(c.getData());
            case 1:
                return new SimpleDateFormat("HH:mm:ss").format(c.getHora());
            case 2:
                return c.getTipo();
            case 3:
                return Util.formatarMoeda(c.getValor());
            case 4:
                return Util.formatarMoeda(c.getDesconto());
            case 5:
                return Util.formatarMoeda(c.getValorFinal());
            case 6:
                return c.getUtilizador().getNomeUtilizador();
            case 7:
                return c.getCancelado();
            case 8:
                return c.getDataCancelada();
            case 9:
                return c.getCancelador();
        }
        return null;
    }
}
