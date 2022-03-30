package br.com.monktec.produto.service.cliente;

import br.com.monktec.produto.model.client.Avaliacao;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AvaliacaoService {

    private final RestTemplate restTemplate;


    public AvaliacaoService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Avaliacao> buscarTodosPorProduto(Long produtoId) {
        final Map<String, Object> parametros = new HashMap<>();
        parametros.put("produtoId", produtoId);

        final Avaliacao[] avaliacoes;

        String url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/avaliacoes")
                .queryParam("produtoId","{produtoId}")
                .encode()
                .toUriString();

        avaliacoes = restTemplate.getForObject(url,Avaliacao[].class,parametros);

        return Arrays.asList(avaliacoes);
    }
}
