package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> adicionarMissoes(@RequestBody MissaoDTO missao){
        MissaoDTO missaoDTO = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão com o id " + missaoDTO.getId() + " criada com sucesso!");
    }

    //Listar Missões
    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> missoes(){
        List<MissaoDTO> missao = missaoService.missoes();
        return ResponseEntity.ok(missao);
    }

    //Listar Missões por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesID(@PathVariable Long id){
        MissaoDTO missao = missaoService.missoesId(id);
        if (missao != null){
            return ResponseEntity.ok(missao);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não encontrada.");
        }
    }

    //Atualizar Missões
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        MissaoDTO missao = missaoService.atualizarMissao(id, missaoDTO);
        if (missao != null){
            return ResponseEntity.ok(missao);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não encontrada.");
        }
    }

    //Deletar Missões
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missaoService.missoesId(id) != null){
            missaoService.deletarMissao(id);
            return ResponseEntity.ok("Missão com o id " + id + " deletada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com id " + id + " não encontrada");
        }
    }
}
