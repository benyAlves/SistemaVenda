/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.util;

import org.jdesktop.swingx.JXErrorPane;
import org.jdesktop.swingx.error.ErrorInfo;

import javax.swing.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

/**
 * @author ryuuzaki
 */
public class Util {

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
    private static NumberFormat nfVal = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public static void preencheComboBox(JComboBox combobox, List<String> dados) {
        if (dados.size() < 1) return;
        combobox.removeAllItems();
        dados.stream().forEach((alvo) -> {
            combobox.addItem(alvo);
        });
    }

    public static long convertStringEmLong(String text) throws ParseException {
        return numberFormat.parse(text).longValue();
    }

    public static double convertStringEmDouble(String text) throws ParseException {
        return numberFormat.parse(text).doubleValue();
    }

    public static int convertStringEmInteiro(String text) throws ParseException {
        return numberFormat.parse(text).intValue();
    }


    public static String formatarMoeda(double valor) {
        return nfVal.format(valor);
    }


    public static double formatarMoeda(String valor) {
        if (valor.trim().length() > 0) {
            valor = valor.replace("MZN", "");
            valor = valor.replace(".", "");
            valor = valor.replace(",", ".");
        }
        return Double.valueOf(valor);
    }

    public static int optionDialog(String string, String estoque_Esgotado) {
        Object op[] = new Object[]{"Sim", "Não"};
        return JOptionPane.showOptionDialog(null, string, estoque_Esgotado, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);
    }

    public static void errorDialog(String string, String estoque_Esgotado) {
        JXErrorPane ep = new JXErrorPane();
        ep.setErrorInfo(new ErrorInfo("Erro", string, "detalhe", "Erro", null, Level.ALL, null));
        ep.setVisible(true);
    }
}
