package br.uff.sistema_energia.resource.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.uff.sistema_energia.entities.Terceirizada;
import io.swagger.v3.oas.annotations.Operation;

public interface TerceirizadaResourceApi {

	@Operation(summary = "Cadastrar uma nova terceirizada")
    public ResponseEntity<Terceirizada> cadastrar(Terceirizada terceirizada);

    @Operation(summary = "Listar terceirizadas por cidade")
    public ResponseEntity<List<Terceirizada>> listarPorCidade(String cidade);

    @Operation(summary = "Listar terceirizadas com mínimo de atendimentos")
    public ResponseEntity<List<Terceirizada>> listarPorMinAtendimentos(int minAtendimentos);

    @Operation(summary = "Buscar terceirizada por código")
    public ResponseEntity<Terceirizada> buscarPorCodigo(Long codigo);

    @Operation(summary = "Deletar uma terceirizada")
    public ResponseEntity<Void> deletar(Long codigo);
}
