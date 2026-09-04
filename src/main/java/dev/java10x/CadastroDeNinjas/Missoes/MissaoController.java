package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    //Adicionar missões
    @PostMapping("/criar")
    public String adicionarMissoes(){
        return "Adicionar Missões";
    }

    //Listar Missões
    @GetMapping("/todos")
    public String listarMissoes(){
        return "Lista de missões";
    }

    //Listar Missões por id
    @GetMapping("/id")
    public String listarMissoesID(){
        return "Lista de missões por ID";
    }

    //Atualizar Missões
    @PutMapping("/atualizar")
    public String atualizarMissao(){
        return "Atualizar missão";
    }

    //Deletar Missões
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Deletar Missão";
    }
}
