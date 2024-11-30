package br.edu.umfg.teste.spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "UF", nullable = false)
    private String uf;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "NUMERO_END", nullable = false)
    private String numero;

    @Column(name = "BAIRRO", nullable = false)
    private String bairro;

    public int getId() {
        return id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
