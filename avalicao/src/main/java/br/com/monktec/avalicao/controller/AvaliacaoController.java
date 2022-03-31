package br.com.monktec.avalicao.controller;

import br.com.monktec.avalicao.model.Avaliacao;
import br.com.monktec.avalicao.repository.AvaliacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoController(AvaliacaoRepository avaliacaoRepository){
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @GetMapping("produtoId/{produtoId}")
    public List<Avaliacao> buscaAvaliacoesPorProduto(@PathVariable("produtoId") Long produtoId){
        return avaliacaoRepository.findAvaliacaosByProdutoId(produtoId);
    }
}
