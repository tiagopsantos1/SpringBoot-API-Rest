package br.com.api.rest.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.api.rest.model.Produto;
import br.com.api.rest.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
@Api(value = "API REST")
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna todos os produtos cadastrados")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna produtos por determinado id")
	public Produto produtoPorId(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "Cadastro de novos produtos")
	public Produto cadastrar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	@DeleteMapping("/produto/{id}")
	@ApiOperation(value = "Deletar determinado produto")
	public void deletarPorId (@PathVariable(value = "id") long id){
		 produtoRepository.deleteById(id);
	}
	@PutMapping("/produto")
	@ApiOperation(value = "Atualiza qualquer campo do produto")
	public Produto atualizaProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
}
