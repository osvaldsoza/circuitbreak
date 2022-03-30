package br.com.monktec.avalicao.controller;

import br.com.monktec.avalicao.model.Avaliacao;
import br.com.monktec.avalicao.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;


//    @GetMapping
//    public List<Avaliacao> findAll(){
//        return avaliacaoRepository.findAll();
//    }

    @GetMapping
    public List<Avaliacao> buscaAvaliacoesPorProduto(@RequestParam("produtoId") Long produtoId){
        return avaliacaoRepository.findAvaliacaosByProdutoId(produtoId);
    }
}
