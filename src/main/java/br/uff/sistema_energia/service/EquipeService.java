package br.uff.sistema_energia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.sistema_energia.entities.Equipe;
import br.uff.sistema_energia.repository.EquipeRepository;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public Equipe cadastrarEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public List<Equipe> listarEquipesPorTerceirizada(Long terceirizadaCodigo) {
        return equipeRepository.findByTerceirizada(terceirizadaCodigo);
    }

    public List<Equipe> listarEquipesComMinFuncionarios(int minFuncionarios) {
        return equipeRepository.findByMinFuncionarios(minFuncionarios);
    }
}
