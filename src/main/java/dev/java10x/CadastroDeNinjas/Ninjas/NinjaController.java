package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ninjas")
public class NinjaController {


    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Adicionar ninja
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Listar ninjas por id
    @GetMapping("/listar/{id}")
    public NinjaDTO ninjasPorID(@PathVariable Long id){
        return ninjaService.listarPorId(id);
    }

    //Alterar todos os dados dos ninjas
    @PutMapping("/alterarTudo/{id}")
    public NinjaDTO atualizarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return ninjaService.atualizarNinjaCompleto(id, ninja);
    }

    @PatchMapping("/alterar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return ninjaService.atualizarNinja(id, ninja);
    }

    //Listar ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Deletar ninjas
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

    //Buscar por e-mail
    @GetMapping("/buscar")
    public NinjaDTO ninjaEmail(@RequestParam String email){
        return ninjaService.buscarPorEmail(email);
    }
}
