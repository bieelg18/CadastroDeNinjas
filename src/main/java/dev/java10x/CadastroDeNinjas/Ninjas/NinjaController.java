package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    //Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Listar ninjas por id
    @GetMapping("/id")
    public String ninjasPorID(){
        return "Retornando ninjas por id";
    }

    //Alterar dados dos ninjas
    @PutMapping("/atualizar")
    public String atualizarNinjaPorEmail(){
        return "Atualizando ninja por email";
    }

    //Listar ninjas
    @GetMapping("/todos")
    public String listarNinjas(){
        return "Esses são todos os ninjas";
    }

    //Deletar ninjas
    @DeleteMapping("/deletar")
    public String deletarNinja(){
        return "Deletando Ninja";
    }
}
