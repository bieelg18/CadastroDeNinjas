package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoDTO> missoes(){
        List<MissaoModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    public MissaoDTO missoesId(Long id){
        Optional<MissaoModel> missoes = missaoRepository.findById(id);
        return missoes.map(missaoMapper::map).orElse(null);
    }

    public MissaoDTO criarMissao(MissaoDTO missaoDTO){
        MissaoModel missao = new MissaoMapper().map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    public void deletarMissao(Long id){
        missaoRepository.deleteById(id);
    }

    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoDTO){
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);
        if (missaoExistente.isPresent()){
            MissaoModel missao = missaoExistente.get();

            if (missaoDTO.getMissao() != null){
                missao.setMissao(missaoDTO.getMissao());
            }
            if (missaoDTO.getDificuldade() != null){
                missao.setDificuldade(missaoDTO.getDificuldade());
            }
            MissaoModel missaoSalva = missaoRepository.save(missao);
            return missaoMapper.map(missaoSalva);
        }
        return null;
    }

}
