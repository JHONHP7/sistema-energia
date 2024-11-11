package br.uff.sistema_energia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.sistema_energia.entities.ClienteRegular;
import br.uff.sistema_energia.entities.ClienteVital;
import br.uff.sistema_energia.entities.abstratas.Cliente;
import br.uff.sistema_energia.repository.ClienteRepository;
import br.uff.sistema_energia.repository.ClienteVitalRepository;
import br.uff.sistema_energia.resource.dto.request.ClienteDTO;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteVitalRepository clienteVitalRepository;

	public ClienteRegular cadastrarClienteRegular(ClienteDTO clienteRegularDTO) {
	    ClienteRegular clienteRegular = new ClienteRegular();
	    
	    clienteRegular.setCpf(clienteRegularDTO.cpf());
	    clienteRegular.setNome(clienteRegularDTO.nome());
	    clienteRegular.setEndereco(clienteRegularDTO.endereco());

	    return clienteRepository.save(clienteRegular);
	}


	public ClienteVital cadastrarClienteVital(ClienteVital clienteVital) {
		return clienteVitalRepository.save(clienteVital);
	}

	public Optional<Cliente> buscarPorCpf(String cpf) {
		return Optional.ofNullable(clienteRepository.findByCpf(cpf));
	}

	public List<Cliente> listarClientesComOrdens() {
		return clienteRepository.findClientesWithOpenOrdens();
	}

	public List<ClienteVital> listarClientesVitaisPorTempoMaximo(int tempoMaximo) {
		return clienteVitalRepository.findClientesVitaisByTempoMaximoSemEnergia(tempoMaximo);
	}

	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}
