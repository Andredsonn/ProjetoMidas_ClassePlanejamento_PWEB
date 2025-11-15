package br.com.etec.MIDAS.controller;

//Andre Edson da Silva
//Brunno Domingues Santos

import br.com.etec.MIDAS.entity.Planejamento;
import br.com.etec.MIDAS.entity.ProjecaoOrcamentaria;
import br.com.etec.MIDAS.repository.PlanejamentoRepository;
import br.com.etec.MIDAS.repository.ProjecaoOrcamentariaRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.BigDecimal;

@Service
public class PlanejamentoService {
    private final PlanejamentoRepository planejamentoRepository;
    private final ProjecaoOrcamentariaRepository projecaoRepository;

    public PlanejamentoService(PlanejamentoRepository planejamentoRepository,
                               ProjecaoOrcamentariaRepository projecaoRepository) {
        this.planejamentoRepository = planejamentoRepository;
        this.projecaoRepository = projecaoRepository;
    }

    public List<Planejamento> listarTodos() { return planejamentoRepository.findAll(); }
    public Planejamento criar(Planejamento p) { return planejamentoRepository.save(p); }
    public void excluir(Long id) { planejamentoRepository.deleteById(id); }

    public String compararProjecoes(Long id1, Long id2) {
        Optional<ProjecaoOrcamentaria> p1 = projecaoRepository.findById(id1);
        Optional<ProjecaoOrcamentaria> p2 = projecaoRepository.findById(id2);
        if (p1.isPresent() && p2.isPresent()) {
            BigDecimal v1 = p1.get().getValorPrevisto();
            BigDecimal v2 = p2.get().getValorPrevisto();
            return "Diferença: " + v1.subtract(v2).abs();
        }
        return "Projeções não encontradas.";
    }
}
