package br.com.application.dataproviders.restclient.pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PessoaResponse {

    private String uuid;
    private String nome;
    private BigDecimal salarioDia;
}
