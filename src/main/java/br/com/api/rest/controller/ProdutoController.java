package br.com.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.api.rest.model.Produto;
import br.com.api.rest.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto produtoPorId(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	public Produto cadastrar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	@DeleteMapping("/produto/{id}")
	public void deletarPorId (@PathVariable(value = "id") long id){
		 produtoRepository.deleteById(id);
	}
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
}
