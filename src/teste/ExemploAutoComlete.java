/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import bernardo.venda.controle.ProdutoControle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * @author jaymo
 */
public class ExemploAutoComlete extends javax.swing.JFrame {

    /**
     * Creates new form ExemploAutoComlete
     */
    Vector<String> v = new Stack<String>();
    JTextField txt;
    private boolean hide_flag = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbxAuto;

    public ExemploAutoComlete() {
        initComponents();
        autoSuggest();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExemploAutoComlete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExemploAutoComlete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExemploAutoComlete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExemploAutoComlete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExemploAutoComlete().setVisible(true);
            }
        });
    }

    private void autoSuggest() {
        try {
            List<String> lista = new ProdutoControle().produtosNome();
            cmbxAuto.removeAllItems();
            if (cmbxAuto.getItemCount() == 0) {
                for (String cidade : lista) {
                    cmbxAuto.addItem(cidade);
                    v.addElement(cidade);
                    cmbxAuto.addItemListener((ItemEvent e) -> {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            cmbxAuto.getSelectedIndex();
                        }
                    });

                }
            } else {
                cmbxAuto.addItem("Sem dados");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        txt = (JTextField) cmbxAuto.getEditor().getEditorComponent();
        txt.addKeyListener(new KeyAdapter() {
                               @Override
                               public void keyTyped(KeyEvent evt) {
                                   EventQueue.invokeLater(() -> {
                                       String text = txt.getText().toUpperCase();
                                       if (text.length() == 0) {
                                           cmbxAuto.hidePopup();
                                           setModel(new DefaultComboBoxModel(v), "");
                                       } else {
                                           DefaultComboBoxModel cm = getSuggestModel(v, text);
                                           if (cm.getSize() == 0) {
                                               cmbxAuto.hidePopup();
                                           } else {
                                               setModel(cm, text);
                                               cmbxAuto.showPopup();
                                           }
                                       }
                                   });
                               }

                               @Override
                               public void keyPressed(KeyEvent e) {
                                   String texto = txt.getText();
                                   int code = e.getKeyCode();
                                   if (code == KeyEvent.VK_ENTER) {
                                       if (!v.contains(texto)) {
                                           v.addElement(texto);
                                       }
                                       hide_flag = true;
                                   } else if (code == KeyEvent.VK_ESCAPE) {
                                       hide_flag = true;
                                   } else if (code == KeyEvent.VK_RIGHT) {
                                       for (int i = 0; i < v.size(); i++) {
                                           String str = (String) v.elementAt(i);
                                           if (str.startsWith(texto)) {
                                               txt.setText(str);
                                               return;
                                           }
                                       }
                                   }
                               }
                           }
        );
    }

    private void setModel(DefaultComboBoxModel model, String txtt) {
        cmbxAuto.setModel(model);
        txt.setText(txtt);
    }

    private DefaultComboBoxModel getSuggestModel(List<String> v, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for (String s : v) {
            if (s.startsWith(text)) {
                m.addElement(s);
            }
        }
        return m;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbxAuto = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbxAuto.setEditable(true);
        cmbxAuto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cmbxAuto, 0, 380, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cmbxAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(261, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // End of variables declaration//GEN-END:variables
}
