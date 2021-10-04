package br.com.application.dataproviders.restclient.pessoa;

import java.util.Optional;

public interface PessoaRestClient {

    Optional<PessoaResponse> buscarPessoa(String pessoaUuid);
}
