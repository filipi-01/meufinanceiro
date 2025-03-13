package com.filipe.meufinanceiro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "movimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_movimento;
    private String descricao;
    private String tipo;
    private String fixo;
    private String periodicidade;
    private Date data_pagamento;
    private int parcelas;
    private double valor_total;
    private String ativo;
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;
    @JoinColumn(name = "cod_cartao")
    private CartaoCredito cartao;
    @JoinColumn(name = "cod_banco")
    private Banco banco;
}
