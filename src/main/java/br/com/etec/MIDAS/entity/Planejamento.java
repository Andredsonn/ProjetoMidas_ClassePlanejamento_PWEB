package br.com.etec.MIDAS.entity;

//Andre Edson da Silva
//Brunno Domingues Santos

import br.com.etec.MIDAS.entity.ProjecaoOrcamentaria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "planejamento")
public class Planejamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="nome_responsavel")
    private String nomeResponsavel;

    @OneToMany(mappedBy = "planejamento", cascade = CascadeType.ALL)
    private List<ProjecaoOrcamentaria> projecoes;

    // getters e setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public List<ProjecaoOrcamentaria> getProjecoes() {
        return projecoes;
    }

    public void setProjecoes(List<ProjecaoOrcamentaria> projecoes) {
        this.projecoes = projecoes;
    }
}
