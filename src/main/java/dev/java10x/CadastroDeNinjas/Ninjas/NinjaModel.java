package dev.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.*;

import java.util.List;
import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;

@Entity
@Table(name = "tb_ninjas")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int idade;
    private String email;

    //Vários ninjas podem ter apenas uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissaoModel missao;

    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public Long getId(){
        return id;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
