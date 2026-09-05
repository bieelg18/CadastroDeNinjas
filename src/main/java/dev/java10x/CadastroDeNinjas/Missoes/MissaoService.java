package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoModel> missoes(){
        return missaoRepository.findAll();
    }

    public MissaoModel missoesId(Long id){
        Optional<MissaoModel> missaoModel = missaoRepository.findById(id);
        return missaoModel.orElse(null);
    }

}
