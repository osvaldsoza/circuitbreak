package br.com.monktec.produto.service.cliente;

import br.com.monktec.produto.model.client.Avaliacao;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AvaliacaoService {

    private final RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(AvaliacaoService.class);

    private final Map<Long, List<Avaliacao>> CACHE_AVALIACAO = new HashMap<>();

    public AvaliacaoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "avaliacaoCB", fallbackMethod = "buscarTodosPorProdutoCache")
    public List<Avaliacao> buscarTodosPorProduto(Long produtoId) {

        final String URL = "http://localhost:8080/avaliacoes/produtoId/" + produtoId;

        logger.info("Buscando avaliações");
        final Avaliacao[] avaliacoes;

        try {
            avaliacoes = restTemplate.getForObject(URL, Avaliacao[].class);
        } catch (Exception e) {
            logger.error("Erro ao buscar avaliações");
            throw e;
        }
        logger.info("Alimentando cache");
        CACHE_AVALIACAO.put(produtoId, Arrays.asList(avaliacoes));

        return Arrays.asList(avaliacoes);
    }

    private List<Avaliacao> buscarTodosPorProdutoCache(Long produtoId, Throwable e) {
        logger.info("Buscando no cache");
        return CACHE_AVALIACAO.getOrDefault(produtoId, new ArrayList<>());
    }

}
