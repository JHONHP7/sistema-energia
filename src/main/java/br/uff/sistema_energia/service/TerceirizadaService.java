package br.uff.sistema_energia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.sistema_energia.entities.Terceirizada;
import br.uff.sistema_energia.repository.TerceirizadaRepository;

@Service
public class TerceirizadaService {

    @Autowired
    private TerceirizadaRepository terceirizadaRepository;

    public Terceirizada cadastrarTerceirizada(Terceirizada terceirizada) {
        return terceirizadaRepository.save(terceirizada);
    }

    public List<Terceirizada> listarPorCidade(String cidade) {
        return terceirizadaRepository.findByCidade(cidade);
    }

    public List<Terceirizada> listarPorMinAtendimentos(int minAtendimentos) {
        return terceirizadaRepository.findByMinAtendimentos(minAtendimentos);
    }
    
    public Optional<Terceirizada> buscarPorCodigo(Long codigo) {
        return terceirizadaRepository.findById(codigo);
    }

    public void deletarTerceirizada(Long codigo) {
        terceirizadaRepository.deleteById(codigo);
    }
}
