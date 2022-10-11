package br.com.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.rest.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Produto findById(long id);

    Produto deleteById(long id);
}
