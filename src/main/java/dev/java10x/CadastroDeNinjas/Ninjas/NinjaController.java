package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    //Adicionar ninja
    @PostMapping("/adicionar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Listar ninjas por id
    @GetMapping("/ninjasID")
    public String ninjasPorID(){
        return "Retornando ninjas por id";
    }

    //Alterar dados dos ninjas
    @PutMapping("/atualizarNinjaEmail")
    public String atualizarNinjaPorEmail(){
        return "Atualizando ninja por email";
    }

    //Listar ninjas
    @GetMapping("/ninjas")
    public String listarNinjas(){
        return "Esses são todos os ninjas";
    }

    //Deletar ninjas
    @DeleteMapping("/deletarNinja")
    public String deletarNinja(){
        return "Deletando Ninja";
    }
}
