package br.com.monktec.produto.service;

import br.com.monktec.produto.exception.RecursoNaoEncontradoException;
import br.com.monktec.produto.mapper.ProdutoMapper;
import br.com.monktec.produto.model.Produto;
import br.com.monktec.produto.model.ProdutoResponse;
import br.com.monktec.produto.repository.ProdutoRepository;
import br.com.monktec.produto.service.cliente.AvaliacaoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final AvaliacaoService avaliacaoService;

    public ProdutoService(ProdutoRepository produtoRepository,AvaliacaoService avaliacaoService) {
        this.produtoRepository = produtoRepository;
        this.avaliacaoService = avaliacaoService;
    }

    public List<Produto> todosProdutos(){
        return produtoRepository.findAll();
    }

    public ProdutoResponse buscarProdutoPeloId(Long produtoId) {
        var produtoOp = produtoRepository.findById(produtoId);

        if (produtoOp.isPresent()) {
            Produto produto = produtoOp.get();

            var avaliacoes = avaliacaoService.buscarTodosPorProduto(produtoId);;

            return ProdutoMapper.converterProdutoToResponse(produto,avaliacoes);
        }else{
            throw new RecursoNaoEncontradoException();
        }
    }
}
