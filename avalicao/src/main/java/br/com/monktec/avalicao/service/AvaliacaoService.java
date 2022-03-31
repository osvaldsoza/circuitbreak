package br.com.monktec.avalicao.service;

import br.com.monktec.avalicao.model.Avaliacao;
import br.com.monktec.avalicao.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository){
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> buscaAvaliacoes(){
        return avaliacaoRepository.findAll();
    }

    public List<Avaliacao> buscaAvaliacoesPorProduto(Long produtoId){
        return avaliacaoRepository.findAvaliacaosByProdutoId(produtoId);
    }
}
