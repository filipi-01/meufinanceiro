package com.filipe.meufinanceiro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "cartao_movimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoMovimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_movimento;
    private int parcela;
    private Date data_parcela;
    private double valor;
    private String pago;
    @JoinColumn(name = "cod_cartao")
    private CartaoCredito cartaoCredito;
}
