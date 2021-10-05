package br.com.application.dataproviders.restclient.pessoa;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@Qualifier("ms-pessoa")
@RequiredArgsConstructor
public class PessoaRestClientImpl implements PessoaRestClient {

    // @Value("${ms-pessoa.host}")
    private String pessoaHost;

    private final RestTemplate restTemplate;

    public Optional<PessoaResponse> buscarPessoa(String pessoaUuid) {
        if (isBlank(pessoaUuid)) {
            return Optional.empty();
        }

        Map<String, String> uriPathVariable = new HashMap<>();
        uriPathVariable.put("uuid", pessoaUuid);
        PessoaResponse response = restTemplate.getForObject(pessoaHost + "/pessoas/{uuid}",
                PessoaResponse.class, uriPathVariable);

        return isNull(response.getUuid()) ? Optional.empty() : Optional.of(response);
    }
}
