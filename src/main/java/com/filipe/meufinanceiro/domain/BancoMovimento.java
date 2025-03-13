package com.filipe.meufinanceiro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name="banco_movimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BancoMovimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_movimento;
    private String descricao;
    private Date data_movimento;
    private String tipo;
    private double valor;
    @JoinColumn(name = "cod_banco")
    private Banco banco;
}
