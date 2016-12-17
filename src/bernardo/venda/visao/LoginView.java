/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.visao;

import bernardo.venda.controle.CaixaControle;
import bernardo.venda.controle.UtilizadorControle;
import bernardo.venda.pojo.Utilizador;
import bernardo.venda.util.Icone;
import static bernardo.venda.visao.MainView.utilizadorLogado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.jdesktop.swingx.JXBusyLabel;
import org.jdesktop.swingx.icon.EmptyIcon;
import org.jdesktop.swingx.painter.BusyPainter;

/**
 *
 * @author dalves
 */
public class LoginView extends javax.swing.JFrame {

     UtilizadorControle utilizadorControle = new UtilizadorControle();
    private boolean logado;
    private Utilizador utilizador;
    private CaixaControle caixaControle = new CaixaControle();
    public LoginView() {
        initComponents();
        BusyPainter painter = new BusyPainter(
                new RoundRectangle2D.Float(0, 0, 15.000001f, 5.0f, 10.0f, 10.0f),
                new Ellipse2D.Float(7.5f, 7.5f, 35.0f, 35.0f));
        painter.setHighlightColor(new Color(125, 208, 208));
        painter.setBaseColor(new Color(0, 102, 102));
        painter.setTrailLength(4);
        painter.setPoints(8);
        painter.setFrame(-1);

        processamento.setPreferredSize(new Dimension(50, 50));
        processamento.setIcon(new EmptyIcon(50, 50));
        processamento.setBusyPainter(painter);
        processamento.setVisible(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUtil = new org.jdesktop.swingx.JXTextField();
        txtSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        processamento = new org.jdesktop.swingx.JXBusyLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Utilizador:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Senha:");

        txtUtil.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtUtil.setPrompt("Informe o utilizador");
        txtUtil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUtilKeyReleased(evt);
            }
        });

        txtSenha.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Cancel 2_1.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEntrar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/ok-24.png"))); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnEntrarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtUtil, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(processamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSenha)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(processamento, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUtil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnEntrar))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(125, 208, 208));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel1.setText("PEPA");

        jLabel4.setText("versão 1.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUtilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUtilKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (isPreenchido()) {
                Tarefa t = new Tarefa(processamento, btnEntrar);
                btnEntrar.setEnabled(false);
                processamento.setBusy(true);
                t.execute();
                processamento.setText("");
            }
        }
    }//GEN-LAST:event_txtUtilKeyReleased

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed

    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (isPreenchido()) {
                Tarefa t = new Tarefa(processamento, btnEntrar);
                btnEntrar.setEnabled(false);
                processamento.setBusy(true);
                t.execute();
                processamento.setText("");
            }
        }
    }//GEN-LAST:event_txtSenhaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (isPreenchido()) {
            Tarefa t = new Tarefa(processamento, btnEntrar);
            btnEntrar.setEnabled(false);
            processamento.setBusy(true);
            t.execute();
            processamento.setText("");
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (isPreenchido()) {
                Tarefa t = new Tarefa(processamento, btnEntrar);
                btnEntrar.setEnabled(false);
                processamento.setBusy(true);
                t.execute();
                processamento.setText("");
            }
        }
    }//GEN-LAST:event_btnEntrarKeyReleased

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }
    
     private void conferrido(JXBusyLabel etiqueta) {
        if (logado) {
            etiqueta.setText("Carregando o sistema...");
            MainView main = new MainView();
            main.utilizadorLogado(utilizador);
            main.setVisible(logado);
            this.dispose();
        } else {
            etiqueta.setText("");
            JOptionPane.showMessageDialog(rootPane, "Utilizador ou Senha inválido", "Mensagem", JOptionPane.ERROR_MESSAGE, Icone.ERRO);
        }
    }

    private boolean isPreenchido() {
        if (txtUtil.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Informe o utilizador ", "Informação", JOptionPane.INFORMATION_MESSAGE, Icone.INFORMACAO);
            txtUtil.requestFocus();
            return false;
        }
        if (new String(txtSenha.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Informe a senha", "Informação", JOptionPane.INFORMATION_MESSAGE, Icone.INFORMACAO);
            txtSenha.requestFocus();
            return false;
        }
        return true;
    }

    class Tarefa extends SwingWorker<Boolean, Void> {
        private JXBusyLabel etiqueta;
        private JButton boton;
        private boolean isPagando;


        public Tarefa(JXBusyLabel etiqueta, JButton boton) {
            this.etiqueta = etiqueta;
            this.boton = boton;
        }


        @Override
        protected Boolean doInBackground() throws Exception {
            //int i = 0;

            while (!isCancelled() && !isPagando) {
                processamento.setVisible(true);
                etiqueta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                etiqueta.setText("Reunindo requisitos, aguarde...");
                Thread.sleep(3000);
                utilizador = utilizadorControle.login(new String(txtSenha.getPassword()), txtUtil.getText());
                if (utilizador != null) {
                    utilizadorControle = null;
                    CaixaPane.caixa = caixaControle.findStateUser(true, utilizadorLogado);
                    logado = true;
                }
                conferrido(etiqueta);
                isPagando = true;
            }
            return true;
        }

        @Override
        public void done() {
            try {
                etiqueta.setBusy(!get());
                etiqueta.setText(null);
                if (boton != null)
                    boton.setEnabled(get());
                isPagando = false;
                processamento.setVisible(false);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Tarefa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.jdesktop.swingx.JXBusyLabel processamento;
    private javax.swing.JPasswordField txtSenha;
    private org.jdesktop.swingx.JXTextField txtUtil;
    // End of variables declaration//GEN-END:variables
}