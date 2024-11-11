package br.uff.sistema_energia.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.sistema_energia.entities.Equipe;
import br.uff.sistema_energia.service.EquipeService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/equipes")
@Tag(name = "Equipes", description = "Endpoints relacionados ao gerenciamento de equipes.")
public class EquipeResource {

    @Autowired
    private EquipeService equipeService;

    @PostMapping
    public ResponseEntity<Equipe> cadastrar(@RequestBody Equipe equipe) {
        return ResponseEntity.ok(equipeService.cadastrarEquipe(equipe));
    }

    @GetMapping("/terceirizada/{codigo}")
    public ResponseEntity<List<Equipe>> listarPorTerceirizada(@PathVariable Long codigo) {
        return ResponseEntity.ok(equipeService.listarEquipesPorTerceirizada(codigo));
    }

    @GetMapping("/funcionarios/{minFuncionarios}")
    public ResponseEntity<List<Equipe>> listarPorMinFuncionarios(@PathVariable int minFuncionarios) {
        return ResponseEntity.ok(equipeService.listarEquipesComMinFuncionarios(minFuncionarios));
    }
}
