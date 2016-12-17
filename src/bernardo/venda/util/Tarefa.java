/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bernardo.venda.util;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.JXBusyLabel;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jorgaf
 */
public class Tarefa extends SwingWorker<Boolean, Void> {
    JasperReport jasper;
    List<Map<?, ?>> list;
    JasperViewer jv;
    private JXBusyLabel etiqueta;
    private JButton boton;
    private boolean isVisible;

    public Tarefa(JXBusyLabel etiqueta, JButton boton, JasperReport jasper, List<Map<?, ?>> list) {
        this.etiqueta = etiqueta;
        this.boton = boton;
        this.jasper = jasper;
        this.list = list;
    }


    @Override
    protected Boolean doInBackground() throws Exception {
        //int i = 0;

        while (!isCancelled() && !isVisible) {
            etiqueta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            etiqueta.setText("Gerando o relatório aguarde...");
            Thread.sleep(1000);
            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(list, false);
            JasperPrint print = JasperFillManager.fillReport(jasper, null, data);
            jv = new JasperViewer(print, false);
            jv.setFitWidthZoomRatio();
            jv.setVisible(true);
            isVisible = true;
        }
        return true;
    }

    @Override
    public void done() {
        try {
            etiqueta.setBusy(!get());
            etiqueta.setText(null);
            boton.setEnabled(get());
            isVisible = false;
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Tarefa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public JasperViewer getJv() {
        return jv;
    }

    public void setJv(JasperViewer jv) {
        this.jv = jv;
    }


}
