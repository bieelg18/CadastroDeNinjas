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
    public MissaoDTO adicionarMissoes(@RequestBody MissaoDTO missao){
        return missaoService.criarMissao(missao);
    }

    //Listar Missões
    @GetMapping("/listar")
    public List<MissaoDTO> missoes(){
        return missaoService.missoes();
    }

    //Listar Missões por id
    @GetMapping("/listar/{id}")
    public MissaoDTO listarMissoesID(@PathVariable Long id){
        return missaoService.missoesId(id);
    }

    //Atualizar Missões
    @PatchMapping("/atualizar/{id}")
    public MissaoDTO atualizarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        return missaoService.atualizarMissao(id, missaoDTO);
    }

    //Deletar Missões
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarMissao(id);
    }
}
