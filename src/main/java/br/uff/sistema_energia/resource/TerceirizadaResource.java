package br.uff.sistema_energia.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.sistema_energia.entities.Terceirizada;
import br.uff.sistema_energia.service.TerceirizadaService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/terceirizadas")
@Tag(name = "Terceirizadas", description = "Endpoints relacionados ao gerenciamento de terceirizadas.")
public class TerceirizadaResource {

    @Autowired
    private TerceirizadaService terceirizadaService;

    @PostMapping
    public ResponseEntity<Terceirizada> cadastrar(@RequestBody Terceirizada terceirizada) {
        return ResponseEntity.ok(terceirizadaService.cadastrarTerceirizada(terceirizada));
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Terceirizada>> listarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(terceirizadaService.listarPorCidade(cidade));
    }

    @GetMapping("/min-atendimentos/{minAtendimentos}")
    public ResponseEntity<List<Terceirizada>> listarPorMinAtendimentos(@PathVariable int minAtendimentos) {
        return ResponseEntity.ok(terceirizadaService.listarPorMinAtendimentos(minAtendimentos));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Terceirizada> buscarPorCodigo(@PathVariable Long codigo) {
        return terceirizadaService.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletar(@PathVariable Long codigo) {
        terceirizadaService.deletarTerceirizada(codigo);
        return ResponseEntity.noContent().build();
    }
}