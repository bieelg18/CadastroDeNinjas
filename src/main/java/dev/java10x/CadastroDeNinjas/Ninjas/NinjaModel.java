package dev.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.*;

import java.util.List;
import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import lombok.*;

@Entity
@Table(name = "tb_ninjas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int idade;

    @Column(unique = true)
    private String email;

    //Vários ninjas podem ter apenas uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissaoModel missao;

}
