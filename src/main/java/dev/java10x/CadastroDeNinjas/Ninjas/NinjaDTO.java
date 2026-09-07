package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NinjaDTO {


    private Long id;
    private String nome;
    private int idade;
    private String email;
    private MissaoModel missao;
    private String rankNinja;

}
