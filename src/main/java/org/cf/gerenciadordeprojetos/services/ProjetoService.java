package org.cf.gerenciadordeprojetos.services;

import org.cf.gerenciadordeprojetos.models.ProjetoModel;
import org.cf.gerenciadordeprojetos.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public ProjetoModel save(ProjetoModel projetoModel) {
        return projetoRepository.save(projetoModel);
    }

    public List<ProjetoModel> findAll(){
        return projetoRepository.findAll();
    }

    public void delete(Long id) {
        projetoRepository.deleteById(id);
    }

    public ProjetoModel update(Long id, ProjetoModel projetoModel) {
        Optional<ProjetoModel> projetoBuscado = projetoRepository.findById(id);

        if(projetoBuscado.isPresent()){
            ProjetoModel projetoExistente = projetoBuscado.get();

            projetoExistente.setDataFim(projetoModel.getDataFim());
            projetoExistente.setNome(projetoModel.getNome());
            projetoExistente.setDataInicio(projetoModel.getDataInicio());
            return projetoRepository.save(projetoExistente);
        }
        return null;
    }

    public ProjetoModel findById(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }
}
