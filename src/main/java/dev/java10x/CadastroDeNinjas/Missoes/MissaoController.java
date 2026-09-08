package dev.java10x.CadastroDeNinjas.Missoes;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria a missão", description = "Cria a missão no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada!"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão")
    })
    public ResponseEntity<String> adicionarMissoes(@RequestBody MissaoDTO missao){
        MissaoDTO missaoDTO = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão com o id " + missaoDTO.getId() + " criada com sucesso!");
    }

    //Listar Missões
    @GetMapping("/listar")
    @Operation(summary = "Lista todas as missões", description = "Lista todas as missões do banco de dados")
    public ResponseEntity<List<MissaoDTO>> missoes(){
        List<MissaoDTO> missao = missaoService.missoes();
        return ResponseEntity.ok(missao);
    }

    //Listar Missões por id
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a missão por ID", description = "Lista a missão através do ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
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
    @Operation(summary = "Atualiza missão no banco de dados", description = "Atualiza a missão através do ID enviado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada"),
            @ApiResponse(responseCode = "400", description = "Missão não encontrada, atualização não realizada")
    })
    public ResponseEntity<?> atualizarMissao(
            @Parameter(description = "Usuário manda o ID na URL da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda a missão a ser atualizada no corpo da requisição")
            @RequestBody MissaoDTO missaoDTO){
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
    @Operation(summary = "Deleta missão", description = "Deleta a missão pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada"),
            @ApiResponse(responseCode = "400", description = "Missão não encontrada, exclusão não realizada")
    })
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
