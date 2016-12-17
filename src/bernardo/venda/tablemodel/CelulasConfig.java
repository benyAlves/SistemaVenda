package bernardo.venda.tablemodel;



import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import sun.swing.table.DefaultTableCellHeaderRenderer;


public class CelulasConfig extends DefaultTableCellHeaderRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object valor,
                                                   boolean isSelected, boolean hasFocus, int linha, int coluna) {
        super.getTableCellRendererComponent(table, valor, isSelected, hasFocus, linha, coluna);


        JTableHeader cabecalhoTabela = table.getTableHeader();
        cabecalhoTabela.setFont(new Font("SansSerif", Font.BOLD, 20));
        cabecalhoTabela.setForeground(Color.BLACK);
        table.setTableHeader(cabecalhoTabela);
//		
//		setFont(new Font("SansSerif", Font.PLAIN, 14));
//		Object taxa = table.getValueAt(linha, 5);
//		Object valorPago = table.getValueAt(linha, 7);
//		
//		if(Double.parseDouble(taxa.toString())>0 && Boolean.valueOf(valorPago.toString())==true){
//			setForeground(Color.RED);
//		}else if(Double.parseDouble(taxa.toString())==0 && Boolean.valueOf(valorPago.toString())==true){
//			setForeground(new Color(0, 139, 0));
//			
//		}

        //table.getColumnModel().getColumn(0).setMaxWidth(60);


        return this;
    }


}
