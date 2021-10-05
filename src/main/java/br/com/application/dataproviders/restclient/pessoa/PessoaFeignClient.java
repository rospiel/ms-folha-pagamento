package br.com.application.dataproviders.restclient.pessoa;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.OK;

@Component
@FeignClient(name = "ms-pessoa", url = "localhost:7171", path = "/pessoas")
public interface PessoaFeignClient {

    @GetMapping("/{uuid}")
    PessoaResponse buscarPeloUuid(@PathVariable String uuid);
}
