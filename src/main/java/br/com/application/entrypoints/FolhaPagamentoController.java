package br.com.application.entrypoints;

import br.com.application.entrypoints.dtos.FolhaPagamentoResponse;
import br.com.application.usecase.BuscarFolhaPagamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/folhaPagamentos", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FolhaPagamentoController {

    private final BuscarFolhaPagamentoUseCase buscarFolhaPagamentoUseCase;

    @GetMapping("/{pessoaUuid}/{dias}")
    @ResponseStatus(OK)
    public FolhaPagamentoResponse buscar(@PathVariable String pessoaUuid, @PathVariable Long dias) {
        return buscarFolhaPagamentoUseCase.buscarFolhaPagamento(pessoaUuid, dias);
    }
}
