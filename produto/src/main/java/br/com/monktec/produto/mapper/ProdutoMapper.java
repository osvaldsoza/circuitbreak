package br.com.monktec.produto.mapper;

import br.com.monktec.produto.model.Produto;
import br.com.monktec.produto.model.ProdutoResponse;
import br.com.monktec.produto.model.client.Avaliacao;

import java.util.List;

public class ProdutoMapper {

    public static ProdutoResponse converterProdutoToResponse(Produto produto, List<Avaliacao> avaliacoes){
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setId(produto.getId());
        produtoResponse.setNome(produto.getNome());
        produtoResponse.setAvaliacoes(avaliacoes);

        return produtoResponse;
    }
}
