/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.visao;

import bernardo.venda.controle.ProdutoControle;
import bernardo.venda.controle.TransacaoControle;
import bernardo.venda.pojo.Produto;
import bernardo.venda.pojo.Transacao;
import bernardo.venda.tablemodel.TabelaProduto;
import bernardo.venda.util.Tarefa;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import org.jdesktop.swingx.icon.EmptyIcon;
import org.jdesktop.swingx.painter.BusyPainter;

/**
 *
 * @author dalves
 */
public class RelatorioView extends javax.swing.JPanel {

    private static Produto produto;
    private static Produto produtoProcurado;
    private static TabelaProduto modeloTabela;
    private ProdutoControle pc = new ProdutoControle();
    private TransacaoControle tc = new TransacaoControle();
    private List<Produto> listaProdutos;
    private List<Transacao> listaVendas;
    private int OPCAO;
    /**
     * Creates new form RelatorioView
     */
    public RelatorioView() {
        initComponents();
         s_caixa.setTitle("Relatórios do Caixa");
        s_pagam.setTitle("Relatórios de Pagamentos");
        s_produto.setTitle("Relatórios de Produtos");
        s_venda.setTitle("Relatórios de Vendas");
        dataInicial.setDate(new Date());
        dataFinal.setDate(new Date());

        BusyPainter painter = new BusyPainter(
                new RoundRectangle2D.Float(0, 0, 15.000001f, 5.0f, 10.0f, 10.0f),
                new Ellipse2D.Float(7.5f, 7.5f, 35.0f, 35.0f));
        painter.setTrailLength(4);
        painter.setPoints(8);
        painter.setFrame(-1);

        processamento.setPreferredSize(new Dimension(50, 50));
        processamento.setIcon(new EmptyIcon(50, 50));
        processamento.setBusyPainter(painter);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        s_produto = new org.jdesktop.swingx.JXTitledSeparator();
        s_venda = new org.jdesktop.swingx.JXTitledSeparator();
        s_caixa = new org.jdesktop.swingx.JXTitledSeparator();
        s_pagam = new org.jdesktop.swingx.JXTitledSeparator();
        rbTodos = new javax.swing.JRadioButton();
        rbAbaixoEstoque = new javax.swing.JRadioButton();
        rbProdEstoqueEsgotado = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        rbVendDia = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        rbProdCategoria = new javax.swing.JRadioButton();
        btnImprimir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dataInicial = new com.toedter.calendar.JDateChooser();
        dataFinal = new com.toedter.calendar.JDateChooser();
        processamento = new org.jdesktop.swingx.JXBusyLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel5.setText("Relatórios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(981, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rbTodos.setText("Todos os Produtos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        rbAbaixoEstoque.setText("Produtos abaixo do estoque mínimo");
        rbAbaixoEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAbaixoEstoqueActionPerformed(evt);
            }
        });

        rbProdEstoqueEsgotado.setText("Produtos com estoque esgotado");
        rbProdEstoqueEsgotado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProdEstoqueEsgotadoActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Top Vendas");

        rbVendDia.setText("Vendas do dia");
        rbVendDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVendDiaActionPerformed(evt);
            }
        });

        jRadioButton6.setText("Vendas por periodo(Intervalo de datas)");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jRadioButton7.setText("Vendas Canceladas");

        jRadioButton8.setText("Movimentos do caixa");

        jRadioButton9.setText("Pagamentos ");

        rbProdCategoria.setText("Produtos por Categoria");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s_venda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s_caixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s_pagam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbProdCategoria)
                            .addComponent(rbTodos)
                            .addComponent(rbAbaixoEstoque)
                            .addComponent(rbProdEstoqueEsgotado)
                            .addComponent(jRadioButton9)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton4)
                            .addComponent(rbVendDia)
                            .addComponent(jRadioButton6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(s_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAbaixoEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbProdEstoqueEsgotado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbProdCategoria)
                .addGap(18, 18, 18)
                .addComponent(s_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbVendDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
                .addGap(15, 15, 15)
                .addComponent(s_caixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(s_pagam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton9)
                .addContainerGap())
        );

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bernardo/venda/imagens/Print.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel2.setText("Data final:");

        jLabel1.setText("Data Inicial:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        processamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnImprimir)
                        .addGap(18, 18, 18)
                        .addComponent(processamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(processamento, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImprimir))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1103, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        this.OPCAO = 1;
    }//GEN-LAST:event_rbTodosActionPerformed

    private void rbAbaixoEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAbaixoEstoqueActionPerformed
        this.OPCAO = 2;
    }//GEN-LAST:event_rbAbaixoEstoqueActionPerformed

    private void rbProdEstoqueEsgotadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProdEstoqueEsgotadoActionPerformed
        this.OPCAO = 3;
    }//GEN-LAST:event_rbProdEstoqueEsgotadoActionPerformed

    private void rbVendDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVendDiaActionPerformed
        this.OPCAO = 5;
        dataInicial.setEnabled(true);
    }//GEN-LAST:event_rbVendDiaActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void imprimir() {
        switch (this.OPCAO) {
            case 1:
                produtosRelatorio("Todos");
                break;
            case 2:
                produtosRelatorio("Abaixo do Estoque");
                break;
            case 3:
                produtosRelatorio("Estoque esgotado");
                break;
            case 4:
                break;
            case 5:
                vendasRelatorioDia();
                break;
        }
    }

    private void produtosRelatorio(String string) {
        String titulo = null;
        switch (string) {
            case "Todos": {
                listaProdutos = pc.findAll();
                titulo = "Relatório de todos os produtos";
                break;
            }
            case "Abaixo do Estoque": {
                listaProdutos = pc.findAllAbaixoStock();
                titulo = "Relatório de produtos com nível de estoque abaixo do mínimo";
                break;
            }
            case "Estoque esgotado": {
                listaProdutos = pc.findAllUnvalaible();
                titulo = "Relatório de produtos com o estoque esgotado";
                break;
            }

            default:
                break;
        }
        relatorioProdutos(titulo);
    }


    private void relatorioProdutos(String titulo) {
        try {
            btnImprimir.setEnabled(false);
            processamento.setBusy(true);
            String caminho = "relatorios/report_product.jrxml";
            JasperReport jasper = JasperCompileManager.compileReport(caminho);
            Map<String, Object> parametros;
            List<Map<?, ?>> list = new ArrayList<>(0);
            for (int i = 0; i < listaProdutos.size(); i++) {
                parametros = new HashMap<>();
                parametros.put("codigoBarras", listaProdutos.get(i).getCodigoBarras());
                parametros.put("descricao", listaProdutos.get(i).getDescricao());
                parametros.put("quantidadeActual", listaProdutos.get(i).getQuantidadeActual());
                parametros.put("precoVenda", listaProdutos.get(i).getPrecoVenda());
                parametros.put("loja", "Loja Teste 1");
                parametros.put("titulo", "" + titulo + "");
                parametros.put("endereco", "Avenida Bernardo Alves Maluleque nº2016");
                list.add(parametros);
            }
            Tarefa t = new Tarefa(processamento, btnImprimir, jasper, list);
            t.execute();
            processamento.setText(null);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void vendasRelatorioDia() {
        Date d = dataInicial.getDate();
        if (d == null) {
            JOptionPane.showMessageDialog(this, "Informe a data");
            dataInicial.requestFocus();
            return;
        }
        listaVendas = tc.findAllByDate(d);
        String titulo = "Relatório de Vendas efectuadas em " + new SimpleDateFormat("dd/MMM/yyyy").format(d) + "";
        relatorioVenda(titulo);
    }

    private void relatorioVenda(String titulo) {
        try {
            String caminho = "relatorios/report_vendasDia.jrxml";
            JasperReport jasper = JasperCompileManager.compileReport(caminho);
            Map<String, Object> parametros;
            List<Map<?, ?>> list = new ArrayList<>(0);
            for (int i = 0; i < listaVendas.size(); i++) {
                parametros = new HashMap<>();
                parametros.put("hora", listaVendas.get(i).getHora());
                parametros.put("valor", listaVendas.get(i).getValor());
                parametros.put("troco", listaVendas.get(i).getDesconto());
                parametros.put("valorFinal", listaVendas.get(i).getValorFinal());
                parametros.put("loja", "Loja Teste 1");
                parametros.put("titulo", "" + titulo + "");
                parametros.put("endereco", "Avenida Bernardo Alves Maluleque nº2016");
                list.add(parametros);
            }
            //  new Config().mostraRelatorio(jasper, list);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private com.toedter.calendar.JDateChooser dataFinal;
    private com.toedter.calendar.JDateChooser dataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private org.jdesktop.swingx.JXBusyLabel processamento;
    private javax.swing.JRadioButton rbAbaixoEstoque;
    private javax.swing.JRadioButton rbProdCategoria;
    private javax.swing.JRadioButton rbProdEstoqueEsgotado;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JRadioButton rbVendDia;
    private org.jdesktop.swingx.JXTitledSeparator s_caixa;
    private org.jdesktop.swingx.JXTitledSeparator s_pagam;
    private org.jdesktop.swingx.JXTitledSeparator s_produto;
    private org.jdesktop.swingx.JXTitledSeparator s_venda;
    // End of variables declaration//GEN-END:variables
}