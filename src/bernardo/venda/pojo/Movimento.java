/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.pojo;


/**
 * @author Bernardo Alves
 */
public class Movimento {

    private String produto;
    private long entrada;
    private long saida;
    private long qVendida;
    private double vendas;
    private double lucro;
    private Integer estoque;

    public Movimento(String produto, long entrada, long saida, long qVendida, double vendas, double lucro, Integer estoque) {
        this.produto = produto;
        this.entrada = entrada;
        this.saida = saida;
        this.qVendida = qVendida;
        this.vendas = vendas;
        this.lucro = lucro;
        this.estoque = estoque;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public long getEntrada() {
        return entrada;
    }

    public void setEntrada(long entrada) {
        this.entrada = entrada;
    }

    public long getSaida() {
        return saida;
    }

    public void setSaida(long saida) {
        this.saida = saida;
    }

    public long getqVendida() {
        return qVendida;
    }

    public void setqVendida(long qVendida) {
        this.qVendida = qVendida;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double valorVendas) {
        this.lucro = valorVendas;
    }

    @Override
    public String toString() {
        return "Movimento{" + "produto=" + produto + ", entrada=" + entrada + ", saida=" + saida + ", qVendida=" + qVendida + ", vendas=" + vendas + ", lucro=" + lucro + ", estoque=" + estoque + '}';
    }


}
