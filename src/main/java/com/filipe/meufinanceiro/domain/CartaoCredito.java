package com.filipe.meufinanceiro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "cartao_credito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_cartao;
    private String nome;
    private Date data_pagamento;
    private Date vencimento;
    private Date fechamento;
    private double limite;
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;
    @JoinColumn(name = "cod_banco")
    private Banco banco;
}
