package br.com.application.usecase;

import br.com.application.dataproviders.entities.FolhaPagamento;
import br.com.application.dataproviders.restclient.pessoa.PessoaRestClient;
import br.com.application.dataproviders.restclient.pessoa.PessoaResponse;
import br.com.application.entrypoints.dtos.FolhaPagamentoResponse;
import br.com.application.entrypoints.mapper.FolhaPagamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarFolhaPagamentoUseCase {

    private final FolhaPagamentoMapper folhaPagamentoMapper;
    private final PessoaRestClient pessoaRestClient;

    public FolhaPagamentoResponse buscarFolhaPagamento(String pessoaUuid, Long dias) {
        Optional<PessoaResponse> pessoa = pessoaRestClient.buscarPessoa(pessoaUuid);
        if (pessoa.isEmpty()) {
            return new FolhaPagamentoResponse();
        }

        FolhaPagamento folhaPagamento = FolhaPagamento.builder()
                .nome(pessoa.get().getNome())
                .salarioDia(pessoa.get().getSalarioDia())
                .dias(dias)
                .build();

        return folhaPagamentoMapper.mapPessoaResponse(folhaPagamento);
    }
}
