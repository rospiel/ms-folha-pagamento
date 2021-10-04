package br.com.application.entrypoints.mapper;

import br.com.application.dataproviders.entities.FolhaPagamento;
import br.com.application.entrypoints.dtos.FolhaPagamentoResponse;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class FolhaPagamentoMapper {

    public FolhaPagamentoResponse mapPessoaResponse(FolhaPagamento entidade) {
        FolhaPagamentoResponse response = new FolhaPagamentoResponse();

        if (isNull(entidade)) {
            return response;
        }

        response.setNome(entidade.getNome());
        response.setSalarioDia(entidade.getSalarioDia());
        response.setDias(entidade.getDias());
        response.setTotal(entidade.getTotal());
        return response;
    }
}
