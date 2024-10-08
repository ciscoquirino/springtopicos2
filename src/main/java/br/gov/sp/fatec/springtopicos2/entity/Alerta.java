package br.gov.sp.fatec.springtopicos2.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alt_alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alt_id")
    private Long id;

    @Column(name = "alt_mensagem")
    private String mensagem;

    @Column(name = "alt_detalhe")
    private String detalhe;

    @Column(name = "alt_data_hora_geracao")
    private LocalDateTime data_hora_geracao;

    @Column(name = "alt_data_hora_verificacao")
    private LocalDateTime data_hora_verificacao;

    @Column(name = "alt_nivel")
    private Integer nivel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public LocalDateTime getData_hora_geracao() {
        return data_hora_geracao;
    }

    public void setData_hora_geracao(LocalDateTime data_hora_geracao) {
        this.data_hora_geracao = data_hora_geracao;
    }

    public LocalDateTime getData_hora_verificacao() {
        return data_hora_verificacao;
    }

    public void setData_hora_verificacao(LocalDateTime data_hora_verificacao) {
        this.data_hora_verificacao = data_hora_verificacao;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }


}
