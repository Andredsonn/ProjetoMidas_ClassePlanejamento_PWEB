package br.com.etec.MIDAS.entity;

//Andre Edson da Silva
//Brunno Domingues Santos

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "projecao_orcamentaria")
public class ProjecaoOrcamentaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="descricao")
    private String descricao;

    @Column (name ="valor_previsto")
    private BigDecimal valorPrevisto;

    @Column (name ="periodo")
    private LocalDate periodo;

    @ManyToOne
    @JoinColumn(name = "planejamento_id")
    private Planejamento planejamento;

    @OneToMany(mappedBy = "projecao", cascade = CascadeType.ALL)
    private List<RegraAlerta> regras;

      // getters e setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorPrevisto() {
        return valorPrevisto;
    }

    public void setValorPrevisto(BigDecimal valorPrevisto) {
        this.valorPrevisto = valorPrevisto;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public Planejamento getPlanejamento() {
        return planejamento;
    }

    public void setPlanejamento(Planejamento planejamento) {
        this.planejamento = planejamento;
    }

    public List<RegraAlerta> getRegras() {
        return regras;
    }

    public void setRegras(List<RegraAlerta> regras) {
        this.regras = regras;
    }
}
