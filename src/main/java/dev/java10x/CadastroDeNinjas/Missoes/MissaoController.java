package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    //Adicionar missões
    @PostMapping("/criar")
    public String adicionarMissoes(){
        return "Adicionar Missões";
    }

    //Listar Missões
    @GetMapping("/todos")
    public List<MissaoModel> missoes(){
        return missaoService.missoes();
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
