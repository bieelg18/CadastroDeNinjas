package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas que estão no banco de dados
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //Listar ninjas por id
    public NinjaModel listarPorId(Long id){
        return ninjaRepository.findById(id).orElse(null);
    }

    //Listar ninjas por e-mail
    public NinjaModel buscarPorEmail(String email){
        return ninjaRepository.findByEmail(email)
                .orElse(null);
    }

    //Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar um ninja
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

}
