package com.filipe.meufinanceiro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "movimento_parcela")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimentoParcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_parcela;
    private int parcela;
    private Date vencimento;
    private double valor;
    private String pago;
    @JoinColumn(name = "cod_movimento")
    private Movimento movimento;
}
