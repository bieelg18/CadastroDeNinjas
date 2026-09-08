package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas que estão no banco de dados
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar ninjas por id
    public NinjaDTO listarPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Listar ninjas por e-mail
    public NinjaDTO buscarPorEmail(String email) {
        Optional<NinjaModel> ninjaPorEmail = ninjaRepository.findByEmail(email);
        return ninjaPorEmail.map(ninjaMapper::map).orElse(null);
    }

    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar um ninja
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }


    //Alterar apenas os dados enviados na requisição
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninja = ninjaExistente.get();

            if (ninjaDTO.getNome() != null){
                ninja.setNome(ninjaDTO.getNome());
            }
            if (ninjaDTO.getEmail() != null){
                ninja.setEmail(ninjaDTO.getEmail());
            }
            if (ninjaDTO.getIdade() != null){
                ninja.setIdade(ninjaDTO.getIdade());
            }
            if (ninjaDTO.getRankNinja() != null){
                ninja.setRankNinja(ninjaDTO.getRankNinja());
            }
            if (ninjaDTO.getMissao() != null){
                ninja.setMissao(ninjaDTO.getMissao());
            }
            NinjaModel ninjaSalvo = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
