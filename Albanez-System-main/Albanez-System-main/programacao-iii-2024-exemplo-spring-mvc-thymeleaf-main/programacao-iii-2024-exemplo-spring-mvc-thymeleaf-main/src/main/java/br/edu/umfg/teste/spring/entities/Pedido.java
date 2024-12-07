package br.edu.umfg.teste.spring.entities;
import br.edu.umfg.teste.spring.entities.Fornecedor;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table (name = "pedido'")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUTO_ID", referencedColumnName = "ID")
    private Produto produto = new Produto();

    @ManyToOne(optional = false)
    @JoinColumn(name = "FORNECEDOR_ID", referencedColumnName = "ID")
    private Fornecedor fornecedor = new Fornecedor();

    @Column(name = "PREVISAO_DE_ENTREGA")
    @Temporal(TemporalType.DATE)
    private Date previsaoDeEntrega;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getPrevisaoDeEntrega() {
        return previsaoDeEntrega;
    }

    public void setPrevisaoDeEntrega(Date previsaoDeEntrega) {
        this.previsaoDeEntrega = previsaoDeEntrega;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }
}
