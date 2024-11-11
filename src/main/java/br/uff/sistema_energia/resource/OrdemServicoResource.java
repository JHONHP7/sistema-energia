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

import br.uff.sistema_energia.entities.OrdemServico;
import br.uff.sistema_energia.service.OrdemServicoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ordens-servico")
@Tag(name = "Ordens de Serviço", description = "Endpoints relacionados ao gerenciamento das ordens de serviço.")
public class OrdemServicoResource {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public ResponseEntity<OrdemServico> cadastrar(@RequestBody OrdemServico ordemServico) {
        return ResponseEntity.ok(ordemServicoService.cadastrarOrdemServico(ordemServico));
    }

    @GetMapping("/abertas")
    public ResponseEntity<List<OrdemServico>> listarOrdensAbertas() {
        return ResponseEntity.ok(ordemServicoService.listarOrdensAbertas());
    }

    @GetMapping("/encerradas")
    public ResponseEntity<List<OrdemServico>> listarOrdensEncerradas() {
        return ResponseEntity.ok(ordemServicoService.listarOrdensEncerradas());
    }

    @GetMapping("/prioridade-alta")
    public ResponseEntity<List<OrdemServico>> listarOrdensPrioridadeAlta() {
        return ResponseEntity.ok(ordemServicoService.listarOrdensPrioridadeAlta());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<OrdemServico> buscarPorCodigo(@PathVariable Long codigo) {
        return ordemServicoService.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletar(@PathVariable Long codigo) {
        ordemServicoService.deletarOrdemServico(codigo);
        return ResponseEntity.noContent().build();
    }
}

