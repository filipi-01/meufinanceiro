package com.filipe.meufinanceiro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "simulacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_simulacao;
    private Date data_simulacao;
    private int parcelas;
    private double valor;
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;
}
