package br.com.application.dataproviders.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FolhaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private BigDecimal salarioDia;
    private Long dias;

    public BigDecimal getTotal() {
        return salarioDia.multiply(BigDecimal.valueOf(dias));
    }
}
