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
    public MissaoModel adicionarMissoes(@RequestBody MissaoModel missao){
        return missaoService.criarMissao(missao);
    }

    //Listar Missões
    @GetMapping("/listar")
    public List<MissaoModel> missoes(){
        return missaoService.missoes();
    }

    //Listar Missões por id
    @GetMapping("/listar/{id}")
    public MissaoModel listarMissoesID(@PathVariable Long id){
        return missaoService.missoesId(id);
    }

    //Atualizar Missões
    @PutMapping("/atualizar")
    public String atualizarMissao(){
        return "Atualizar missão";
    }

    //Deletar Missões
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarMissao(id);
    }
}
