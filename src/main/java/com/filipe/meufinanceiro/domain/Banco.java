package com.filipe.meufinanceiro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "banco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_banco;
    private String nome;
    private double saldo;
    private String ativo;
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;
}
