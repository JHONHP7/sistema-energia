package br.uff.sistema_energia.resource.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.uff.sistema_energia.entities.OrdemServico;
import io.swagger.v3.oas.annotations.Operation;

public interface OrdemServicoResourceApi {

	@Operation(summary = "Cadastrar uma nova ordem de serviço")
    public ResponseEntity<OrdemServico> cadastrar(OrdemServico ordemServico);

    @Operation(summary = "Listar ordens de serviço abertas")
    public ResponseEntity<List<OrdemServico>> listarOrdensAbertas();

    @Operation(summary = "Listar ordens de serviço encerradas")
    public ResponseEntity<List<OrdemServico>> listarOrdensEncerradas();

    @Operation(summary = "Listar ordens de serviço com alta prioridade")
    public ResponseEntity<List<OrdemServico>> listarOrdensPrioridadeAlta();

    @Operation(summary = "Buscar ordem de serviço por código")
    public ResponseEntity<OrdemServico> buscarPorCodigo(Long codigo);

    @Operation(summary = "Deletar ordem de serviço")
    public ResponseEntity<Void> deletar(Long codigo);
}
