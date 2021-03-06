/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.visao;

import bernardo.venda.controle.ClienteControle;
import bernardo.venda.controle.ProdutoControle;
import bernardo.venda.controle.UtilizadorControle;
import bernardo.venda.pojo.Produto;
import bernardo.venda.pojo.ProdutoVenda;
import bernardo.venda.pojo.Transacao;
import bernardo.venda.pojo.Utilizador;
import bernardo.venda.tablemodel.TabelaProdutoVenda;
import bernardo.venda.util.Util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author dalves
 */
public class PDVView extends javax.swing.JFrame implements KeyListener {

    
    private static List<ProdutoVenda> lista = new ArrayList<>(0);
    private static Transacao transacao;
    ProdutoControle pc = new ProdutoControle();
    ClienteControle clienteControle = new ClienteControle();
    UtilizadorControle utilizadorControle = new UtilizadorControle();
    private Produto produto;
    /**
     * Creates new form PDVView
     */
    public PDVView() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTableHeader cabecalhoTabela = tabelaProdVenda.getTableHeader();
        cabecalhoTabela.setFont(new Font("SansSerif", Font.BOLD, 16));
        cabecalhoTabela.setForeground(Color.BLACK);
        tabelaProdVenda.setTableHeader(cabecalhoTabela);
        iniciarTabelaProdutosVenda();
        AutoCompleteDecorator.decorate(txtNome, pc.produtosNome(), true);
        reiniciarVenda();
        criaVenda();
        txtNome.requestFocusInWindow();
        if (CaixaPane.caixa == null) {
            JOptionPane.showMessageDialog(this, "Por favor abra o caixa para iniciar as vendas");
            txtNome.setEnabled(false);
        }
    }
    
      private static void iniciarTabelaProdutosVenda() {
        tabelaProdVenda.setModel(new TabelaProdutoVenda(null));
        tabelaProdVenda.getColumnModel().getColumn(0).setMinWidth(650);
        tabelaProdVenda.getColumnModel().getColumn(2).setMinWidth(50);
        tabelaProdVenda.getColumnModel().getColumn(3).setMinWidth(200);
    }

    private static void criaVenda() {
        Utilizador u = MainView.utilizadorLogado;
        transacao = new Transacao(CaixaPane.caixa, u, null, 0.0, 0.0, "Venda", "não", 0.0);
    }

    public static void reiniciarVenda() {
        iniciarTabelaProdutosVenda();
        criaVenda();
        lista = new ArrayList<>();
        limparCampos();
        txtNome.requestFocus();
    }

    private static void limparCampos() {
        txtValorUnitario.setText("");
        txtTotal.setText("");
        txtQuant.setText("1");
        txtNome.setText("");
        lbTotalPagar.setText(Util.formatarMoeda(0));
        lbSubTotal.setText(Util.formatarMoeda(0));
        lbDesconto.setText(Util.formatarMoeda(0));
        lbTotalItens.setText(lista.size() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtNome = new org.jdesktop.swingx.JXTextField();
        jLabel4 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtQuant = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdVenda = new org.jdesktop.swingx.JXTable();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbTotalPagar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTotalItens = new javax.swing.JLabel();
        lbSubTotal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbDesconto = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1formKeyReleased(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição do Produto"));

        txtNome.setBackground(new java.awt.Color(166, 250, 175));
        txtNome.setToolTipText("Digite o nome do produto e pressione ENTER ou Passe o  leitor de Codigo de Barras no produto");
        txtNome.setFont(new java.awt.Font("Cantarell", 0, 25)); // NOI18N
        txtNome.setPrompt("Digite o Código de Barras ou a Descrição do produto ");
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel4.setText("Preço");

        txtValorUnitario.setFont(new java.awt.Font("Cantarell", 0, 25)); // NOI18N
        txtValorUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel6.setText("Quantidade");

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setText("Total");

        txtTotal.setFont(new java.awt.Font("Cantarell", 0, 25)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtQuant.setFont(new java.awt.Font("Cantarell", 0, 25)); // NOI18N
        txtQuant.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtQuant.setText("1");
        txtQuant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Enter Key.png"))); // NOI18N
        jButton1.setText("Lançar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel2.setText("Produto");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabelaProdVenda.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        tabelaProdVenda.setRowHeight(21);
        tabelaProdVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdVendaMouseClicked(evt);
            }
        });
        tabelaProdVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaProdVendaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdVenda);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Operações"));

        jButton2.setBackground(new java.awt.Color(246, 168, 168));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Cancel 2.png"))); // NOI18N
        jButton2.setText("Cancelar ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(165, 254, 160));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Sell_1.png"))); // NOI18N
        jButton3.setText("Finalizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton3KeyReleased(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(246, 168, 168));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Delete.png"))); // NOI18N
        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton4KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel7.setText("ESC - Cancelar");

        jLabel8.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel8.setText("F12 - Pagar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 215, 200)));

        lbTotalPagar.setFont(new java.awt.Font("Cantarell", 1, 48)); // NOI18N
        lbTotalPagar.setForeground(new java.awt.Color(1, 4, 5));
        lbTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotalPagar.setText("MZN 0,00");

        jLabel14.setFont(new java.awt.Font("Cantarell", 1, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 4, 5));
        jLabel14.setText("Total:");

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Itens:");

        lbTotalItens.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        lbTotalItens.setForeground(new java.awt.Color(1, 1, 1));
        lbTotalItens.setText("10");

        lbSubTotal.setFont(new java.awt.Font("Cantarell", 1, 20)); // NOI18N
        lbSubTotal.setForeground(new java.awt.Color(125, 125, 125));
        lbSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSubTotal.setText("MZN 0,00");

        jLabel15.setFont(new java.awt.Font("Cantarell", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(125, 125, 125));
        jLabel15.setText("SubTotal:");

        lbDesconto.setFont(new java.awt.Font("Cantarell", 1, 20)); // NOI18N
        lbDesconto.setForeground(new java.awt.Color(228, 9, 14));
        lbDesconto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDesconto.setText("MZN 0,00");

        jLabel16.setFont(new java.awt.Font("Cantarell", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(228, 9, 14));
        jLabel16.setText("Desconto(0,00%):");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lbTotalItens))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSubTotal)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDesconto)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalPagar)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1176, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.produto = pc.findByName("descricao", txtNome.getText());
            if (this.produto != null) {
                try {
                    txtValorUnitario.setText(this.produto.getPrecoVenda() + "");
                    txtTotal.setText((this.produto.getPrecoVenda() * Util.convertStringEmInteiro(txtQuant.getText())) + "");
                    if (this.produto.getCodigoBarras() != null)
                    //txtCodigoBarras.setText(this.produto.getCodigoBarras());
                    preencheTabela(this.produto);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Digite uma quantidade válida");
                }
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            if (!lista.isEmpty())
            abrirTelaPagamento();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            reiniciarVenda();
        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtQuantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.produto = pc.findByName("descricao", txtNome.getText());
            if (this.produto != null) {
                try {
                    txtValorUnitario.setText(this.produto.getPrecoVenda() + "");
                    txtTotal.setText((this.produto.getPrecoVenda() * Util.convertStringEmInteiro(txtQuant.getText())) + "");
                    if (this.produto.getCodigoBarras() != null)
                    preencheTabela(this.produto);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Digite uma quantidade válida");
                }
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            abrirTelaPagamento();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            reiniciarVenda();
        }
    }//GEN-LAST:event_txtQuantKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        preencheTabela(this.produto);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.produto = pc.findByName("descricao", txtNome.getText());
            if (this.produto != null) {
                try {
                    txtValorUnitario.setText(this.produto.getPrecoVenda() + "");
                    txtTotal.setText((this.produto.getPrecoVenda() * Util.convertStringEmInteiro(txtQuant.getText())) + "");
                    if (this.produto.getCodigoBarras() != null)
                    //txtCodigoBarras.setText(this.produto.getCodigoBarras());
                    preencheTabela(this.produto);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Digite uma quantidade válida");
                }
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            if (!lista.isEmpty())
            abrirTelaPagamento();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            reiniciarVenda();
        }
    }//GEN-LAST:event_jButton1KeyReleased

    private void tabelaProdVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdVendaMouseClicked
        int linha = tabelaProdVenda.getSelectedRow();
        if (linha != -1) {
            try {
                if (evt.getClickCount() == 2) {
                    ProdutoVenda pv = TabelaProdutoVenda.getProdutoVendaAt(linha);
                    int novaQuant = alterarQuant(pv);
                    this.lista.remove(pv);
                    pv.setQuantidade(novaQuant);
                    actualizarTabelaProdutosVenda(pv, transacao);
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Digite uma quantidade válida");
            }
        }
    }//GEN-LAST:event_tabelaProdVendaMouseClicked

    private void tabelaProdVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaProdVendaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            abrirTelaPagamento();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            reiniciarVenda();
        }
    }//GEN-LAST:event_tabelaProdVendaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reiniciarVenda();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!lista.isEmpty())
        abrirTelaPagamento();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            abrirTelaPagamento();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            reiniciarVenda();
        }
    }//GEN-LAST:event_jButton3KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int linha = tabelaProdVenda.getSelectedRow();
        if (linha != -1) {
            ProdutoVenda pv = TabelaProdutoVenda.getProdutoVendaAt(linha);
            lista.remove(pv);
            actualizarTabelaProdutosVenda(lista);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o produto que deseja remover");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            abrirTelaPagamento();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            reiniciarVenda();
        }
    }//GEN-LAST:event_jButton4KeyReleased

    private void jPanel1formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            abrirTelaPagamento();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            tabelaProdVenda.setModel(new TabelaProdutoVenda(null));
            transacao = new Transacao();
            lista = new ArrayList<>();
        }
    }//GEN-LAST:event_jPanel1formKeyReleased

     private void preencheTabela(Produto p) {
        try {
            ProdutoVenda pv = new ProdutoVenda();
            pv.setProduto(p);
            int quant = Util.convertStringEmInteiro(txtQuant.getText());
            if (quant > p.getQuantidadeActual()) {
                JOptionPane.showMessageDialog(this, "A Quantidade informada excede o estoque \nInforme uma quantidade inferior ou igual");
                return;
            } else if (quant == p.getQuantidadeActual()) {
                int op = Util.optionDialog("O Estoque do " + p.getDescricao() + " será zerado\nDeseja Continuar?", "Estoque Esgotado");
                if (op != 0) {
                    return;
                }
            }
            pv.setQuantidade(quant);
            actualizarTabelaProdutosVenda(pv, transacao);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Informe dados válidos");
        }
    }

    private void actualizarTabelaProdutosVenda(ProdutoVenda pv, Transacao v) {
        if (!existe(pv))
            lista.add(pv);

        tabelaProdVenda.setModel(new TabelaProdutoVenda(lista));
        tabelaProdVenda.getColumnModel().getColumn(0).setMinWidth(650);
        tabelaProdVenda.getColumnModel().getColumn(2).setMinWidth(50);
        tabelaProdVenda.getColumnModel().getColumn(3).setMinWidth(200);
        lbTotalPagar.setText(Util.formatarMoeda(calculaSubTotal(lista)));
        lbSubTotal.setText(Util.formatarMoeda(calculaSubTotal(lista)));
        lbTotalItens.setText(lista.size() + "");
    }

    private boolean existe(ProdutoVenda pv) {
        for (int i = 0; i < lista.size(); i++) {
            if (pv.getProduto().getDescricao().equals(lista.get(i).getProduto().getDescricao())) {
                int quantidade = lista.get(i).getQuantidade() + pv.getQuantidade();
                pv.setQuantidade(quantidade);
                lista.remove(lista.get(i));
                lista.add(i, pv);
                return true;
            }
        }
        return false;
    }

    private double calculaSubTotal(List<ProdutoVenda> lista) {
        double valorAux = 0.0;
        for (int i = 0; i < lista.size(); i++) {
            valorAux += Util.formatarMoeda((String) tabelaProdVenda.getValueAt(i, 3));
        }
        return valorAux;
    }

    private int alterarQuant(ProdutoVenda produtoVendaAt) throws ParseException {
        String d = JOptionPane.showInputDialog(this, "Digite a nova Quantidade", "" + produtoVendaAt.getQuantidade() + "");
        if (d == null || d.trim().isEmpty()) {
            return produtoVendaAt.getQuantidade();
        } else if (Util.convertStringEmInteiro(d) <= 0)
            return produtoVendaAt.getQuantidade();
        return Util.convertStringEmInteiro(d);
    }

    private void actualizarTabelaProdutosVenda(List<ProdutoVenda> lista) {
        tabelaProdVenda.setModel(new TabelaProdutoVenda(lista));
        tabelaProdVenda.getColumnModel().getColumn(0).setMinWidth(650);
        tabelaProdVenda.getColumnModel().getColumn(2).setMinWidth(50);
        tabelaProdVenda.getColumnModel().getColumn(3).setMinWidth(200);
        lbTotalPagar.setText(Util.formatarMoeda(calculaSubTotal(lista)));
        lbSubTotal.setText(Util.formatarMoeda(calculaSubTotal(lista)));
    }

    private void abrirTelaPagamento() {
        if (lista.size() < 1) {
            JOptionPane.showMessageDialog(this, "Tabela não possui produtos pra vender");
            return;
        }
        Window pai = SwingUtilities.getWindowAncestor(this);
        PagaView rg = new PagaView(pai, "Pagamento");
        rg.setModal(true);
        rg.setLocationRelativeTo(null);
        transacao.setProdutoVendas(lista);
        transacao.setValor(calculaSubTotal(lista));
        rg.dadosVenda(transacao);
        rg.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F12) {
            abrirTelaPagamento();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            reiniciarVenda();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private static javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lbDesconto;
    private static javax.swing.JLabel lbSubTotal;
    private static javax.swing.JLabel lbTotalItens;
    private static javax.swing.JLabel lbTotalPagar;
    private static org.jdesktop.swingx.JXTable tabelaProdVenda;
    public static org.jdesktop.swingx.JXTextField txtNome;
    private static javax.swing.JTextField txtQuant;
    private static javax.swing.JTextField txtTotal;
    private static javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
