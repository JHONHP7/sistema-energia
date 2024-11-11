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

import br.uff.sistema_energia.entities.ClienteRegular;
import br.uff.sistema_energia.entities.ClienteVital;
import br.uff.sistema_energia.entities.abstratas.Cliente;
import br.uff.sistema_energia.resource.swagger.ClienteResourceApi;
import br.uff.sistema_energia.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource implements ClienteResourceApi {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteRegular> cadastrarClienteRegular(@RequestBody ClienteRegular cliente) {
		return ResponseEntity.ok(clienteService.cadastrarClienteRegular(cliente));
	}

	@PostMapping("/vital")
	public ResponseEntity<ClienteVital> cadastrarClienteVital(@RequestBody ClienteVital clienteVital) {
		return ResponseEntity.ok(clienteService.cadastrarClienteVital(clienteVital));
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf) {
		return clienteService.buscarPorCpf(cpf).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/com-ordens")
	public ResponseEntity<List<Cliente>> listarClientesComOrdens() {
		return ResponseEntity.ok(clienteService.listarClientesComOrdens());
	}

	@GetMapping("/vital/tempo-maximo/{tempoMaximo}")
	public ResponseEntity<List<ClienteVital>> listarClientesVitaisPorTempoMaximo(@PathVariable int tempoMaximo) {
		return ResponseEntity.ok(clienteService.listarClientesVitaisPorTempoMaximo(tempoMaximo));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}

}
