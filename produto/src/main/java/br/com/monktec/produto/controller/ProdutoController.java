package br.com.monktec.produto.controller;

import br.com.monktec.produto.exception.RecursoNaoEncontradoException;
import br.com.monktec.produto.mapper.ProdutoMapper;
import br.com.monktec.produto.model.Produto;
import br.com.monktec.produto.model.ProdutoResponse;
import br.com.monktec.produto.repository.ProdutoRepository;
import br.com.monktec.produto.service.cliente.AvaliacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final AvaliacaoService avaliacaoService;

    public ProdutoController(ProdutoRepository produtoRepository, AvaliacaoService avaliacaoService) {
        this.produtoRepository = produtoRepository;
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public List<Produto> todosProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{produtoId}")
    public ProdutoResponse buscarProdutoPeloId(@PathVariable("produtoId") Long produtoId) {
        var produtoOp = produtoRepository.findById(produtoId);

        if (produtoOp.isPresent()) {
            Produto produto = produtoOp.get();

            var avaliacoes = avaliacaoService.buscarTodosPorProduto(produtoId);;

            return ProdutoMapper.converterProdutoToresponse(produto,avaliacoes);
        }else{
            throw new RecursoNaoEncontradoException();
        }
    }
}
