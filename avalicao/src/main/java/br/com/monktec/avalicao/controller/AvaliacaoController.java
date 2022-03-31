package br.com.monktec.avalicao.controller;

import br.com.monktec.avalicao.model.Avaliacao;
import br.com.monktec.avalicao.repository.AvaliacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoController(AvaliacaoRepository avaliacaoRepository){
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @GetMapping
    public List<Avaliacao> buscaAvaliacoesPorProduto(@RequestParam("produtoId") Long produtoId){
        return avaliacaoRepository.findAvaliacaosByProdutoId(produtoId);
    }
}
