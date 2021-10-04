package br.com.application.usecase;

import br.com.application.dataproviders.entities.FolhaPagamento;
import br.com.application.entrypoints.dtos.FolhaPagamentoResponse;
import br.com.application.entrypoints.mapper.FolhaPagamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BuscarFolhaPagamentoUseCase {

    private final FolhaPagamentoMapper folhaPagamentoMapper;

    public FolhaPagamentoResponse buscarFolhaPagamento(String pessoaUuid, Long dias) {
        return folhaPagamentoMapper.mapPessoaResponse(new FolhaPagamento("Rodrigo", BigDecimal.TEN, dias));
    }
}
