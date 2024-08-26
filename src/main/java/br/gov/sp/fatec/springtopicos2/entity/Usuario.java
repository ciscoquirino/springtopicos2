package br.gov.sp.fatec.springtopicos2.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    @JsonView({View.UsuarioView.class})
    private Long id;

    @Column(name = "usr_nome")
    @JsonView({View.UsuarioView.class})
    private String nome;

    @Column(name = "usr_senha")
    private String senha;

    public Usuario(){
        setAnotacoes(new HashSet<Anotacao>());
    }

    public Usuario(String nome, String senha){
        this();
        setNome(nome);
        setSenha(senha);
    }

    public Set<Anotacao> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(Set<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
    }

    @OneToMany(mappedBy = "usuario")
    @JsonView({View.UsuarioView.class})
    private Set<Anotacao> anotacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
