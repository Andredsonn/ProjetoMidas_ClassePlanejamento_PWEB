package br.com.etec.MIDAS.entity;

//Andre Edson da Silva
//Brunno Domingues Santos

import br.com.etec.MIDAS.entity.ProjecaoOrcamentaria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "regra_alerta")
public class RegraAlerta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="tipo")
    private String tipo;

    @Column (name ="limite_desvio")
    private BigDecimal limiteDesvio;

    @ManyToOne
    @JoinColumn(name = "projecao_id")
    private ProjecaoOrcamentaria projecao;

    // getters e setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getLimiteDesvio() {
        return limiteDesvio;
    }

    public void setLimiteDesvio(BigDecimal limiteDesvio) {
        this.limiteDesvio = limiteDesvio;
    }

    public ProjecaoOrcamentaria getProjecao() {
        return projecao;
    }

    public void setProjecao(ProjecaoOrcamentaria projecao) {
        this.projecao = projecao;
    }
}
