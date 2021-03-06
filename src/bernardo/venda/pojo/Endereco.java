package bernardo.venda.pojo;
// Generated Feb 3, 2016 4:08:05 PM by Hibernate Tools 4.3.1


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Endereco generated by hbm2java
 */
@Entity
@Table(name = "endereco"
        , catalog = "vendabd"
)
public class Endereco implements java.io.Serializable {


    private Long idEndereco;
    private String bairro;
    private String ruaAvenida;
    private String casa;
    private Set<Cliente> clientes = new HashSet<Cliente>(0);
    private Set<Fornecedor> fornecedors = new HashSet<Fornecedor>(0);

    public Endereco() {
    }


    public Endereco(String bairro, String ruaAvenida) {
        this.bairro = bairro;
        this.ruaAvenida = ruaAvenida;
    }

    public Endereco(String bairro, String ruaAvenida, String casa, Set<Cliente> clientes, Set<Fornecedor> fornecedors) {
        this.bairro = bairro;
        this.ruaAvenida = ruaAvenida;
        this.casa = casa;
        this.clientes = clientes;
        this.fornecedors = fornecedors;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)


    @Column(name = "idEndereco", unique = true, nullable = false)
    public Long getIdEndereco() {
        return this.idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }


    @Column(name = "bairro", nullable = false, length = 45)
    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    @Column(name = "rua_avenida", nullable = false, length = 45)
    public String getRuaAvenida() {
        return this.ruaAvenida;
    }

    public void setRuaAvenida(String ruaAvenida) {
        this.ruaAvenida = ruaAvenida;
    }


    @Column(name = "casa", length = 45)
    public String getCasa() {
        return this.casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
    public Set<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
    public Set<Fornecedor> getFornecedors() {
        return this.fornecedors;
    }

    public void setFornecedors(Set<Fornecedor> fornecedors) {
        this.fornecedors = fornecedors;
    }


}


