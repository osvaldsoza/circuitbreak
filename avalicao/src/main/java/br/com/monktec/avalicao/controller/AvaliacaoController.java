package br.com.monktec.avalicao.controller;

import br.com.monktec.avalicao.model.Avaliacao;
import br.com.monktec.avalicao.repository.AvaliacaoRepository;
import br.com.monktec.avalicao.service.AvaliacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public List<Avaliacao> buscaAvaliacoes(){
        return avaliacaoService.buscaAvaliacoes();
    }

    @GetMapping("produtoId/{produtoId}")
    public List<Avaliacao> buscaAvaliacoesPorProduto(@PathVariable("produtoId") Long produtoId){
        return avaliacaoService.buscaAvaliacoesPorProduto(produtoId);
    }
}
