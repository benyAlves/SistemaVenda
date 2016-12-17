/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.visao;

import bernardo.venda.controle.CaixaControle;
import bernardo.venda.controle.TransacaoControle;
import bernardo.venda.pojo.Caixa;
import bernardo.venda.pojo.Transacao;
import bernardo.venda.tablemodel.TabelaCaixa;
import bernardo.venda.tablemodel.TabelaTransacao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Window;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author dalves
 */
public class CaixaPane extends javax.swing.JPanel {

    /**
     * Creates new form CaixaPane
     */
     public static Caixa caixa;
    private static List<Transacao> lista;
    private static TabelaTransacao modeloTabela;
    private static TransacaoControle transControle = new TransacaoControle();
    private static CaixaControle caixaControle = new CaixaControle();
    private static List<Caixa> listaCaixa;
    private static TabelaCaixa modeloTabelaCaixa;
    
    private Caixa caixaSelecionado;
    
    public CaixaPane() {
        initComponents();
        tabelaTransacao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabelaCaixas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        actualizarCaixa();
        actualizarTabela();
    }
    public static void actualizarTabela() {
        lista = transControle.findAllByCaixa(caixa);
        modeloTabela = new TabelaTransacao(lista);
        tabelaTransacao.setModel(modeloTabela);
        tabelaTransacao.getColumnModel().getColumn(0).setMinWidth(100);
        tabelaTransacao.getColumnModel().getColumn(1).setMinWidth(100);
        tabelaTransacao.getColumnModel().getColumn(2).setMinWidth(200);
        tabelaTransacao.getColumnModel().getColumn(3).setMinWidth(160);
        tabelaTransacao.getColumnModel().getColumn(4).setMinWidth(160);
        tabelaTransacao.getColumnModel().getColumn(5).setMinWidth(160);
    }

    public static void actualizarTabelaCaixa() {
        listaCaixa = caixaControle.findAll();
        modeloTabelaCaixa = new TabelaCaixa(listaCaixa);
        tabelaCaixas.setModel(modeloTabelaCaixa);
        tabelaCaixas.getColumnModel().getColumn(0).setMaxWidth(80);
        tabelaCaixas.getColumnModel().getColumn(1).setMinWidth(140);
        tabelaCaixas.getColumnModel().getColumn(2).setMinWidth(140);
        tabelaCaixas.getColumnModel().getColumn(3).setMinWidth(160);
        tabelaCaixas.getColumnModel().getColumn(4).setMinWidth(120);
        tabelaCaixas.getColumnModel().getColumn(5).setMinWidth(120);
        tabelaCaixas.getColumnModel().getColumn(6).setMinWidth(120);
        tabelaCaixas.getColumnModel().getColumn(7).setMinWidth(120);
        tabelaCaixas.getColumnModel().getColumn(8).setMinWidth(120);
        tabelaCaixas.getColumnModel().getColumn(9).setMinWidth(120);
        tabelaCaixas.getColumnModel().getColumn(10).setMinWidth(250);
    }

    static void actualizarCaixa() {

        if (caixa == null) {
            btnFechaAbrirCaixa.setText("Abrir Caixa");
            btnAcrescentarDinheiro.setEnabled(false);
            btnRetirarDinheiro.setEnabled(false);
            btnCancelarTransacao.setEnabled(false);
            btnCorrigir.setEnabled(false);
            btnTotal.setEnabled(false);
        } else {
            btnFechaAbrirCaixa.setText("Fechar Caixa");
            btnAcrescentarDinheiro.setEnabled(true);
            btnRetirarDinheiro.setEnabled(true);
            btnCancelarTransacao.setEnabled(true);
            btnCorrigir.setEnabled(true);
            btnTotal.setEnabled(true);
        }
    }
    
    private void cancelarTrancacao(Transacao t) {
        Object[] botoes = {"Sim", "Não"};
        int opcao;
        opcao = JOptionPane.showOptionDialog(this, "Deseja mesmo efectuar essa operação?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, botoes[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            Window pai = SwingUtilities.getWindowAncestor(this);
            ObservacaoView rg = new ObservacaoView(pai, "Cancelamento no Caixa");
            rg.setModal(true);
            rg.setTransacao(t);
            rg.setLocationRelativeTo(null);
            rg.setVisible(true);
        }
    }

    private void fecharOuAbrirCaixa(String text, Caixa c) {
        if (text.equals("Abrir Caixa"))
            abrirCaixa(c);
        else
            fecharCaixa(c);
    }

    private void abrirCaixa(Caixa c) {
        Window pai = SwingUtilities.getWindowAncestor(this);
        AberturaCaixaDialog rg = new AberturaCaixaDialog(pai, "Abertura de Caixa");
        rg.setModal(true);
        rg.setLocationRelativeTo(null);
        rg.setVisible(true);
    }

    private void fecharCaixa(Caixa c) {
        Object[] botoes = {"Sim", "Não"};
        int opcao;
        opcao = JOptionPane.showOptionDialog(this, "Deseja mesmo efectuar fechar o caixa?", "Fechamento do Caixa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, botoes[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            System.out.println(c == null);
            Window pai = SwingUtilities.getWindowAncestor(this);
            FechamentoCaixaView rg = new FechamentoCaixaView(pai, "Fechamento do Caixa");
            rg.setModal(true);
            rg.setCaixa(lista, c);
            rg.setLocationRelativeTo(null);
            rg.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnFechaAbrirCaixa = new javax.swing.JButton();
        btnTotal = new javax.swing.JButton();
        btnCancelarTransacao = new javax.swing.JButton();
        btnCorrigir = new javax.swing.JButton();
        btnRetirarDinheiro = new javax.swing.JButton();
        btnAcrescentarDinheiro = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTransacao = new org.jdesktop.swingx.JXTable(){

            public Component prepareRenderer(TableCellRenderer renderer,
                int rowIndex, int vColIndex) {

                AbstractTableModel m = modeloTabela;
                Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);

                // altera a cor de background da linha para vermelho e foreground para branco
                // quando o valor da coluna 3 for igual a fechado
                if (tabelaTransacao.getValueAt(rowIndex, 7).toString().equals("Sim")) {
                    c.setBackground(Color.white);
                    c.setForeground(new Color(192, 0, 0));
                }else {
                    // mantem a cor padrão de foreground
                    c.setForeground(getForeground());

                    // determina a cor de background da linha selecionada
                    if(isCellSelected(rowIndex, vColIndex)) {
                        c.setBackground(new Color(184, 207, 229));
                    } else {
                        // linhas não selecionadas, manter cor de background padrão
                        c.setBackground(getBackground());
                    }

                }
                return c;
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnDetalhes = new javax.swing.JButton();
        btnActualizarCaixa = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCaixas = new org.jdesktop.swingx.JXTable();

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jToolBar1.setRollover(true);

        btnFechaAbrirCaixa.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnFechaAbrirCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/lock-24.png"))); // NOI18N
        btnFechaAbrirCaixa.setText("Fechar Caixa");
        btnFechaAbrirCaixa.setFocusable(false);
        btnFechaAbrirCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFechaAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaAbrirCaixaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFechaAbrirCaixa);

        btnTotal.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Sales Performance_1.png"))); // NOI18N
        btnTotal.setText("Ver Total");
        btnTotal.setFocusable(false);
        btnTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTotal);

        btnCancelarTransacao.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelarTransacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Cancel_1.png"))); // NOI18N
        btnCancelarTransacao.setText("Cancelar Transação");
        btnCancelarTransacao.setFocusable(false);
        btnCancelarTransacao.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelarTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTransacaoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelarTransacao);

        btnCorrigir.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCorrigir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Edit.png"))); // NOI18N
        btnCorrigir.setText("Corrigir Transação");
        btnCorrigir.setFocusable(false);
        btnCorrigir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCorrigir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorrigirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCorrigir);

        btnRetirarDinheiro.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnRetirarDinheiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Money-Delete.png"))); // NOI18N
        btnRetirarDinheiro.setText("Retirar Dinheiro");
        btnRetirarDinheiro.setFocusable(false);
        btnRetirarDinheiro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRetirarDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarDinheiroActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRetirarDinheiro);

        btnAcrescentarDinheiro.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnAcrescentarDinheiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Money-Add.png"))); // NOI18N
        btnAcrescentarDinheiro.setText("Acrescentar Dinheiro");
        btnAcrescentarDinheiro.setFocusable(false);
        btnAcrescentarDinheiro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAcrescentarDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcrescentarDinheiroActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAcrescentarDinheiro);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Transações"));

        tabelaTransacao.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jScrollPane1.setViewportView(tabelaTransacao);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Transações do Caixa", jPanel2);

        jToolBar2.setRollover(true);

        btnDetalhes.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnDetalhes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Cash Register.png"))); // NOI18N
        btnDetalhes.setText("Detalhes");
        btnDetalhes.setEnabled(false);
        btnDetalhes.setFocusable(false);
        btnDetalhes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDetalhes);

        btnActualizarCaixa.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnActualizarCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Edit.png"))); // NOI18N
        btnActualizarCaixa.setText("Corrigir");
        btnActualizarCaixa.setEnabled(false);
        btnActualizarCaixa.setFocusable(false);
        btnActualizarCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToolBar2.add(btnActualizarCaixa);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista dos Caixas Antecedentes"));

        tabelaCaixas.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tabelaCaixas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCaixasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaCaixas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Caixas Antecedentes", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFechaAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaAbrirCaixaActionPerformed
        fecharOuAbrirCaixa(btnFechaAbrirCaixa.getText(), caixa);
    }//GEN-LAST:event_btnFechaAbrirCaixaActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        Window pai = SwingUtilities.getWindowAncestor(this);
        CaixaTotal rg = new CaixaTotal(pai, "Total Caixa");
        rg.setModal(true);
        rg.inicializaTotais(lista, CaixaPane.caixa);
        rg.setLocationRelativeTo(null);
        rg.setVisible(true);
    }//GEN-LAST:event_btnTotalActionPerformed

    private void btnCancelarTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTransacaoActionPerformed
        int linha = tabelaTransacao.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione a transação que deseja cancelar");
            return;
        }
        Transacao t = TabelaTransacao.getTransacaoAt(linha);
        cancelarTrancacao(t);
    }//GEN-LAST:event_btnCancelarTransacaoActionPerformed

    private void btnCorrigirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrigirActionPerformed

    }//GEN-LAST:event_btnCorrigirActionPerformed

    private void btnRetirarDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarDinheiroActionPerformed
        Window pai = SwingUtilities.getWindowAncestor(this);
        SangriaSuprimento rg = new SangriaSuprimento(pai, "Retirar Dinheiro(Sangria)");
        rg.setModal(true);
        rg.setIsSuprimento(false);
        rg.setLocationRelativeTo(null);
        rg.setVisible(true);
    }//GEN-LAST:event_btnRetirarDinheiroActionPerformed

    private void btnAcrescentarDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcrescentarDinheiroActionPerformed
        Window pai = SwingUtilities.getWindowAncestor(this);
        SangriaSuprimento rg = new SangriaSuprimento(pai, "Acrescentar Dinheiro(Suprimento)");
        rg.setModal(true);
        rg.setIsSuprimento(true);
        rg.setLocationRelativeTo(null);
        rg.setVisible(true);
    }//GEN-LAST:event_btnAcrescentarDinheiroActionPerformed

    private void btnDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesActionPerformed
        Window pai = SwingUtilities.getWindowAncestor(this);
        CaixaTotal rg = new CaixaTotal(pai, "Total Caixa");
        rg.setModal(true);
        rg.inicializaTotais(caixaSelecionado.getTransacaos(), caixaSelecionado);
        rg.setLocationRelativeTo(null);
        rg.setVisible(true);
    }//GEN-LAST:event_btnDetalhesActionPerformed

    private void tabelaCaixasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCaixasMouseClicked
        int linha = tabelaCaixas.getSelectedRow();
        if (linha == -1) {
            return;
        }
        btnDetalhes.setEnabled(true);
        btnActualizarCaixa.setEnabled(true);
        caixaSelecionado = TabelaCaixa.getCaixaAt(linha);
    }//GEN-LAST:event_tabelaCaixasMouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (jTabbedPane1.getSelectedIndex() == 1)
        actualizarTabelaCaixa();
    }//GEN-LAST:event_jTabbedPane1StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnAcrescentarDinheiro;
    private javax.swing.JButton btnActualizarCaixa;
    private static javax.swing.JButton btnCancelarTransacao;
    private static javax.swing.JButton btnCorrigir;
    private javax.swing.JButton btnDetalhes;
    private static javax.swing.JButton btnFechaAbrirCaixa;
    private static javax.swing.JButton btnRetirarDinheiro;
    private static javax.swing.JButton btnTotal;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private static org.jdesktop.swingx.JXTable tabelaCaixas;
    private static org.jdesktop.swingx.JXTable tabelaTransacao;
    // End of variables declaration//GEN-END:variables
}
