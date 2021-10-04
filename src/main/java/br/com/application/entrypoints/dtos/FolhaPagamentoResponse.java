package br.com.application.entrypoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FolhaPagamentoResponse {

    private String nome;
    private BigDecimal salarioDia;
    private Long dias;
    private BigDecimal total;
}
