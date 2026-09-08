package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ninjas")
public class NinjaController {


    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Adicionar ninja
    @PostMapping("/criar")
    @Operation(summary = "Criar Ninja", description = "Cria um novo ninja no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado!"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " (ID): " + ninjaDTO.getId());
    }

    //Listar ninjas por id
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista ninja por ID", description = "Busca um ninja no banco de dados através do ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> ninjasPorID(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarPorId(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não encontrado.");
        }
    }



    @PatchMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por ID", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, alteração não realizada.")
    })
    public ResponseEntity<?> atualizarNinja(
            @Parameter(description = "Usuário manda o ID na URL da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda o ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninja){
        NinjaDTO ninjas = ninjaService.atualizarNinja(id, ninja);
        if (ninjas != null){
            return ResponseEntity.ok(ninjas);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id " + id + " não encontrado.");
        }
    }

    //Listar ninjas
    @Operation(summary = "Listar Ninjas", description = "Essa rota lista todos os ninjas cadastrados no banco de dados")
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Deletar ninjas
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta o ninja por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, exclusão não realizada")
    })
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if (ninjaService.listarPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com id " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não foi encontrado.");
        }
    }

    //Buscar por e-mail
    @GetMapping("/buscar")
    @Operation(summary = "Busca ninja por e-mail", description = "Busca um ninja no banco de dados pelo e-mail enviado na URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado!"),
            @ApiResponse(responseCode = "400", description = "Ninja não encontrado.")
    })
    public ResponseEntity<?> ninjaEmail(@RequestParam String email){
        NinjaDTO ninja = ninjaService.buscarPorEmail(email);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o e-mail " + email + " não encontrado.");
        }
    }
}
