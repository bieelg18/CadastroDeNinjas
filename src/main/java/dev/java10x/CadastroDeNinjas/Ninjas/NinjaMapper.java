package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setRankNinja(ninjaDTO.getRankNinja());
        ninjaModel.setMissao(ninjaDTO.getMissao());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setRankNinja(ninjaModel.getRankNinja());
        ninjaDTO.setMissao(ninjaModel.getMissao());

        return ninjaDTO;
    }

}
