package br.uff.sistema_energia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.sistema_energia.entities.OrdemServico;
import br.uff.sistema_energia.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico cadastrarOrdemServico(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    public List<OrdemServico> listarOrdensAbertas() {
        return ordemServicoRepository.findByStatusAberta();
    }

    public List<OrdemServico> listarOrdensEncerradas() {
        return ordemServicoRepository.findEncerradas();
    }

    public List<OrdemServico> listarOrdensPrioridadeAlta() {
        return ordemServicoRepository.findByPrioridadeAlta();
    }
    
    public Optional<OrdemServico> buscarPorCodigo(Long codigo) {
        return ordemServicoRepository.findById(codigo);
    }

    public void deletarOrdemServico(Long codigo) {
        ordemServicoRepository.deleteById(codigo);
    }
    

}
