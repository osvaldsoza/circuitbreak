package br.com.monktec.avalicao.repository;

import br.com.monktec.avalicao.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    List<Avaliacao> findAvaliacaosByProdutoId(Long produtoId);
}
