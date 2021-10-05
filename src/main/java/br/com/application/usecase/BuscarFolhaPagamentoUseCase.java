package br.com.application.usecase;

import br.com.application.dataproviders.entities.FolhaPagamento;
import br.com.application.dataproviders.restclient.pessoa.PessoaFeignClient;
import br.com.application.dataproviders.restclient.pessoa.PessoaResponse;
import br.com.application.entrypoints.dtos.FolhaPagamentoResponse;
import br.com.application.entrypoints.mapper.FolhaPagamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@RequiredArgsConstructor
public class BuscarFolhaPagamentoUseCase {

    private final FolhaPagamentoMapper folhaPagamentoMapper;
    private final PessoaFeignClient pessoaFeignClient;

    public FolhaPagamentoResponse buscarFolhaPagamento(String pessoaUuid, Long dias) {
        PessoaResponse pessoa = pessoaFeignClient.buscarPeloUuid(pessoaUuid);
        if (isBlank(pessoa.getUuid())) {
            return new FolhaPagamentoResponse();
        }

        FolhaPagamento folhaPagamento = FolhaPagamento.builder()
                .nome(pessoa.getNome())
                .salarioDia(pessoa.getSalarioDia())
                .dias(dias)
                .build();

        return folhaPagamentoMapper.mapPessoaResponse(folhaPagamento);
    }
}
