package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissaoController {

    //Adicionar missões
    @PostMapping("/adicionarMissoes")
    public String adicionarMissoes(){
        return "Adicionar Missões";
    }

    //Listar Missões
    @GetMapping("/missoes")
    public String listarMissoes(){
        return "Lista de missões";
    }

    //Listar Missões por id
    @GetMapping("/missoesID")
    public String listarMissoesID(){
        return "Lista de missões por ID";
    }

    //Atualizar Missões
    @PutMapping("/atualizarMissao")
    public String atualizarMissao(){
        return "Atualizar missão";
    }

    //Deletar Missões
    @DeleteMapping("/deletarMissao")
    public String deletarMissao(){
        return "Deletar Missão";
    }
}
