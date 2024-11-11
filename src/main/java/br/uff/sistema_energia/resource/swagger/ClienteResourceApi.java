package br.uff.sistema_energia.resource.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import br.uff.sistema_energia.entities.ClienteRegular;
import br.uff.sistema_energia.entities.ClienteVital;
import br.uff.sistema_energia.entities.abstratas.Cliente;
import br.uff.sistema_energia.resource.dto.request.ClienteDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface ClienteResourceApi {

    @Operation(summary = "Cadastrar um novo cliente regular")
    public ResponseEntity<ClienteRegular> cadastrarClienteRegular(@RequestBody @Parameter(description = "Cliente regular a ser cadastrado") ClienteDTO clienteRegular);

    @Operation(summary = "Cadastrar um novo cliente vital")
    public ResponseEntity<ClienteVital> cadastrarClienteVital(@RequestBody @Parameter(description = "Cliente vital a ser cadastrado") ClienteVital clienteVital);

    @Operation(summary = "Buscar cliente por CPF")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable @Parameter(description = "CPF do cliente a ser buscado") String cpf);

    @Operation(summary = "Listar todos os clientes com ordens de serviço abertas")
    public ResponseEntity<List<Cliente>> listarClientesComOrdens();

    @Operation(summary = "Listar clientes vitais por tempo máximo de espera sem energia")
    public ResponseEntity<List<ClienteVital>> listarClientesVitaisPorTempoMaximo(@PathVariable @Parameter(description = "Tempo máximo de espera sem energia") int tempoMaximo);

    @Operation(summary = "Deletar um cliente")
    public ResponseEntity<Void> deletarCliente(@PathVariable @Parameter(description = "ID do cliente a ser deletado") Long id);
}
