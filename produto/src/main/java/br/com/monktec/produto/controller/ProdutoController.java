package br.com.monktec.produto.controller;

import br.com.monktec.produto.model.Produto;
import br.com.monktec.produto.model.ProdutoResponse;
import br.com.monktec.produto.model.client.Avaliacao;
import br.com.monktec.produto.repository.ProdutoRepository;
import br.com.monktec.produto.service.cliente.AvaliacaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ProdutoResponse buscarProdutoPeloId(@RequestParam Long produtoId) {
        var produtoOp = produtoRepository.findById(produtoId);

        if (produtoOp.isPresent()) {
            Produto produto = produtoOp.get();

            var avaliacoes = buscarAvaliacaoDoProduto(produtoId);
            ProdutoResponse produtoResponse = new ProdutoResponse();
            produtoResponse.setId(produto.getId());
            produtoResponse.setNome(produto.getNome());
            produtoResponse.setAvaliacoes(avaliacoes);

            return produtoResponse;
        }
        return null;
    }

    private List<Avaliacao> buscarAvaliacaoDoProduto(Long productId) {
        return avaliacaoService.buscarTodosPorProduto(productId);
    }

}
