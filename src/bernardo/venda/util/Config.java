/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.util;

import net.sf.jasperreports.view.JasperViewer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ryuuzaki
 */
public class Config {

    private static int dia, mes, ano;
    private static Calendar calendar;
    private static SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");

    public static Date formatarData(String data) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
            return new Date(formatter.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String dataActual() {
        calendar = Calendar.getInstance();
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        mes = calendar.get(Calendar.MONTH) + 1;
        ano = calendar.get(Calendar.YEAR);
        return format.format(new Date());

    }

    public void mostraRelatorio(JasperViewer jv) {
        jv.setVisible(true);
    }


}
