package br.com.etec.MIDAS.controller;

//Andre Edson da Silva
//Brunno Domingues Santos

import br.com.etec.MIDAS.entity.Planejamento;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/planejamentos")
public class PlanejamentoController {
    private final PlanejamentoService service;

    public PlanejamentoController(PlanejamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Planejamento> listar() { return service.listarTodos(); }

    @PostMapping
    public Planejamento criar(@RequestBody Planejamento p) { return service.criar(p); }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) { service.excluir(id); }

    @GetMapping("/comparar")
    public String comparar(@RequestParam Long id1, @RequestParam Long id2) { return service.compararProjecoes(id1, id2); }
}
