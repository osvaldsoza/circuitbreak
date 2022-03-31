package br.com.monktec.produto.controller;

import br.com.monktec.produto.exception.RecursoNaoEncontradoException;
import br.com.monktec.produto.mapper.ProdutoMapper;
import br.com.monktec.produto.model.Produto;
import br.com.monktec.produto.model.ProdutoResponse;
import br.com.monktec.produto.repository.ProdutoRepository;
import br.com.monktec.produto.service.ProdutoService;
import br.com.monktec.produto.service.cliente.AvaliacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> todosProdutos(){
        return produtoService.todosProdutos();
    }

    @GetMapping("/{produtoId}")
    public ProdutoResponse buscarProdutoPeloId(@PathVariable("produtoId") Long produtoId) {
      return produtoService.buscarProdutoPeloId(produtoId);
    }
}
