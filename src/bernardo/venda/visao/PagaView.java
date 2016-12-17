/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.visao;

import bernardo.venda.controle.CaixaControle;
import bernardo.venda.controle.ProdutoControle;
import bernardo.venda.controle.ProdutoVendaControle;
import bernardo.venda.controle.TransacaoControle;
import bernardo.venda.pojo.Parcela;
import bernardo.venda.pojo.Produto;
import bernardo.venda.pojo.ProdutoVenda;
import bernardo.venda.pojo.ProdutoVendaId;
import bernardo.venda.pojo.Transacao;
import bernardo.venda.util.Icone;
import bernardo.venda.util.Util;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.jdesktop.swingx.JXBusyLabel;

/**
 *
 * @author dalves
 */
public class PagaView extends javax.swing.JDialog {

    CaixaControle caixaControle = new CaixaControle();
    private Transacao transacao;
    private String formaPagamento;
    private double valorPago;
    private double troco;
    private TransacaoControle transControle = new TransacaoControle();
    private ProdutoVendaControle pvControle = new ProdutoVendaControle();
    private ProdutoControle prodControle = new ProdutoControle();
    private List<Parcela> parcelas;
    private double desconto;
    private double valorNumerario;
    private double valorCartao;
    private boolean isPagando = false;
    /**
     * Creates new form PagaView
     */
    public PagaView(java.awt.Window parent, String tit) {
        super(parent, tit);
        initComponents();
        txtNumerario.requestFocus();
        //txtNumerario.selectAll();
        parcelas = new ArrayList<>(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        lbTotalPagar = new javax.swing.JLabel();
        lbTroco = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbCartao = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNumerario = new org.jdesktop.swingx.JXTextField();
        txtCartao = new org.jdesktop.swingx.JXTextField();
        lbNumerario = new javax.swing.JLabel();
        jbusy = new org.jdesktop.swingx.JXBusyLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbTotalPagar.setFont(new java.awt.Font("Cantarell", 1, 25)); // NOI18N
        lbTotalPagar.setForeground(new java.awt.Color(51, 51, 51));
        lbTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotalPagar.setText("MZN 0,00");

        lbTroco.setFont(new java.awt.Font("Cantarell", 1, 25)); // NOI18N
        lbTroco.setForeground(new java.awt.Color(228, 9, 14));
        lbTroco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTroco.setText("MZN 0,00");

        jLabel16.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel16.setText("Troco:");

        lbCartao.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lbCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/POS Terminal_1.png"))); // NOI18N
        lbCartao.setText("Cartão ");

        jLabel14.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel14.setText("Total à Pagar");

        txtNumerario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNumerario.setText("0,00");
        txtNumerario.setFont(new java.awt.Font("Cantarell", 1, 25)); // NOI18N
        txtNumerario.setPrompt("0,00");
        txtNumerario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumerarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumerarioFocusLost(evt);
            }
        });
        txtNumerario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumerarioKeyReleased(evt);
            }
        });

        txtCartao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCartao.setText("0,00");
        txtCartao.setFont(new java.awt.Font("Cantarell", 1, 25)); // NOI18N
        txtCartao.setPrompt("0,00");
        txtCartao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCartaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCartaoFocusLost(evt);
            }
        });
        txtCartao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCartaoKeyReleased(evt);
            }
        });

        lbNumerario.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lbNumerario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Banknotes.png"))); // NOI18N
        lbNumerario.setText("Numerário");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbusy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumerario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCartao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCartao, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(txtNumerario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbTotalPagar))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumerario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNumerario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(lbCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(lbTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbusy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Operações"));

        jButton2.setBackground(new java.awt.Color(246, 168, 168));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Cancel 2.png"))); // NOI18N
        jButton2.setText("Cancelar ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnPagar.setBackground(new java.awt.Color(165, 254, 160));
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Refund.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        btnPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnPagarKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel1.setText("Esc - Cancelar");

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel2.setText("Enter - Pagar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumerarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumerarioFocusGained
        txtNumerario.selectAll();
    }//GEN-LAST:event_txtNumerarioFocusGained

    private void txtNumerarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumerarioFocusLost
        if (txtNumerario.getText().trim().isEmpty() || txtNumerario.getText().trim().equals("0") || txtNumerario.getText().trim().equals("0,00")) {
            txtNumerario.setText("0,00");
        }
    }//GEN-LAST:event_txtNumerarioFocusLost

    private void txtNumerarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumerarioKeyReleased
        try {
            this.valorPago = Util.convertStringEmDouble(txtNumerario.getText());
            lbTroco.setText(Util.formatarMoeda(calculaTroco()));
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                efectuaPagamento();
            }
        } catch (ParseException ex) {
            if (!txtNumerario.getText().trim().isEmpty())
            JOptionPane.showMessageDialog(rootPane, "Valor Inválido!", "Erro de valor", JOptionPane.ERROR_MESSAGE, Icone.ERRO);
            txtNumerario.requestFocus();
            txtNumerario.selectAll();
        }
    }//GEN-LAST:event_txtNumerarioKeyReleased

    private void txtCartaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCartaoFocusGained
        txtCartao.selectAll();
    }//GEN-LAST:event_txtCartaoFocusGained

    private void txtCartaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCartaoFocusLost
        if (txtCartao.getText().trim().isEmpty() || txtCartao.getText().trim().equals("0") || txtCartao.getText().trim().equals("0,00")) {
            txtCartao.setText("0,00");
        }
    }//GEN-LAST:event_txtCartaoFocusLost

    private void txtCartaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCartaoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCartaoKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        Tarefa t = new Tarefa(jbusy, btnPagar);
        t.execute();
        efectuaPagamento();

        jbusy.setText(null);
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnPagarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPagarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            efectuaPagamento();
        }
    }//GEN-LAST:event_btnPagarKeyReleased

     public void dadosVenda(Transacao transacao) {
        this.transacao = transacao;
        lbTotalPagar.setText(Util.formatarMoeda(transacao.getValor()));
    }

    private void guardarProdutosDaVenda(Transacao transacao) {
        List<ProdutoVenda> lista = transacao.getProdutoVendas();
        for (int i = 0; i < lista.size(); i++) {
            ProdutoVenda pd = lista.get(i);
            ProdutoVendaId id = new ProdutoVendaId(transacao.getIdTransacao(), pd.getProduto().getIdProduto());
            pd.setId(id);
            pvControle.guardar(pd);
            actualizarStock(pd);
        }
    }

    private void efectuaPagamento() {

        try {
            this.troco = 0.0;
            Parcela p1;
            Parcela p2;

            this.valorNumerario = Util.convertStringEmDouble(txtNumerario.getText());
            this.valorCartao = Util.convertStringEmDouble(txtCartao.getText());

            this.valorPago = this.valorCartao + this.valorNumerario;
            if (valorPago < transacao.getValor()) {
                JOptionPane.showMessageDialog(rootPane, "Valor Insuficiente", "Pagamento", JOptionPane.INFORMATION_MESSAGE, Icone.INFORMACAO);
                txtNumerario.requestFocus();
                txtNumerario.selectAll();
                return;
            }
            transacao.setData(new Date());
            transacao.setHora(new Date());
            if (this.valorNumerario > 0) {
                p1 = new Parcela(this.transacao, this.transacao.getData(), valorNumerario, lbNumerario.getText());
                transacao.getParcelas().add(p1);
            }
            if (this.valorCartao > 0) {
                p2 = new Parcela(this.transacao, this.transacao.getData(), valorCartao, lbCartao.getText());
                transacao.getParcelas().add(p2);
            }

            transacao.setValorFinal(transacao.getValor() - desconto);


            if (transControle.guardar(transacao) != null) {
                guardarProdutosDaVenda(transacao);
                // actualizaCaixa(transacao);
                lbTroco.setText(Util.formatarMoeda(calculaTroco()));
                JOptionPane.showMessageDialog(rootPane, "Venda Efectuada!", "Confirmação", JOptionPane.INFORMATION_MESSAGE, Icone.INFORMACAO);
                this.dispose();
                PDVView.reiniciarVenda();

            } else {
                JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao efectuar a venda", "Erro", JOptionPane.ERROR_MESSAGE, Icone.ERRO);
            }
        } catch (ParseException ex) {
            if (!txtNumerario.getText().trim().isEmpty())
                JOptionPane.showMessageDialog(rootPane, "Valor Inválido!", "Erro de valor", JOptionPane.ERROR_MESSAGE, Icone.ERRO);
            else
                JOptionPane.showMessageDialog(rootPane, "Informe o valor a pagar", "Erro de valor", JOptionPane.ERROR_MESSAGE, Icone.ERRO);
            txtNumerario.requestFocus();
            txtNumerario.selectAll();
        }
    }

    private double calculaTroco() {
        if (!(valorNumerario == 0 && valorCartao > transacao.getValor())) {
            if (valorPago > transacao.getValor())
                return valorPago - transacao.getValor();
            return 0;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe um valor igual ao valor da venda\n"
                    + "O Pagamento a Cartão não possui troco", "Atenção", JOptionPane.INFORMATION_MESSAGE, Icone.INFORMACAO);
            txtCartao.requestFocus();
            txtCartao.selectAll();
        }
        return 0;
    }

    private void actualizarStock(ProdutoVenda pd) {
        Produto p = pd.getProduto();
        p.setQuantidadeActual(p.getQuantidadeActual() - pd.getQuantidade());
        prodControle.atualizar(p);
    }

//    private void actualizaCaixa(Transacao t) {
//        double valorActual = t.getCaixa().getValorFinal();
//        double valorTransa = t.getValorFinal();
//        Caixa c = t.getCaixa();
//        c.setValorFinal(valorActual + valorTransa);
//        caixaControle.atualizar(c);
//    }


    class Tarefa extends SwingWorker<Boolean, Void> {
        private JXBusyLabel etiqueta;
        private JButton boton;


        public Tarefa(JXBusyLabel etiqueta, JButton boton) {
            this.etiqueta = etiqueta;
            this.boton = boton;
        }


        @Override
        protected Boolean doInBackground() throws Exception {
            //int i = 0;

            while (!isCancelled() && !isPagando) {
                etiqueta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                etiqueta.setText("Processando o Pagamento...");
                Thread.sleep(5000);
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
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Tarefa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private org.jdesktop.swingx.JXBusyLabel jbusy;
    private javax.swing.JLabel lbCartao;
    private javax.swing.JLabel lbNumerario;
    private javax.swing.JLabel lbTotalPagar;
    private javax.swing.JLabel lbTroco;
    private org.jdesktop.swingx.JXTextField txtCartao;
    private org.jdesktop.swingx.JXTextField txtNumerario;
    // End of variables declaration//GEN-END:variables
}
