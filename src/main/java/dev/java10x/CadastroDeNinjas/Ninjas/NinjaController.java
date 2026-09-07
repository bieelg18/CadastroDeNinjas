package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public NinjaModel ninjasPorID(@PathVariable Long id){
        return ninjaService.listarPorId(id);
    }

    //Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public NinjaModel atualizarNinjaPorEmail(@PathVariable Long id, @RequestBody NinjaModel ninja){
        return ninjaService.atualizarNinja(id, ninja);
    }

    //Listar ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Deletar ninjas
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

    //Buscar por e-mail
    @GetMapping("/buscar")
    public NinjaModel ninjaEmail(@RequestParam String email){
        return ninjaService.buscarPorEmail(email);
    }
}
