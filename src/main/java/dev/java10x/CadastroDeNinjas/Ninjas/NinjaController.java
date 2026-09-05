package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {


    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Listar ninjas por id
    @GetMapping("/listar/{id}")
    public NinjaModel ninjasPorID(@PathVariable Long id){
        return ninjaService.listarPorId(id);
    }

    //Alterar dados dos ninjas
    @PutMapping("/atualizar")
    public String atualizarNinjaPorEmail(){
        return "Atualizando ninja por email";
    }

    //Listar ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Deletar ninjas
    @DeleteMapping("/deletar")
    public String deletarNinja(){
        return "Deletando Ninja";
    }
}
