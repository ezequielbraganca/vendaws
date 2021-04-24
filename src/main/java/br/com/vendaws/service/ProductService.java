package br.com.vendaws.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendaws.entity.Product;
import br.com.vendaws.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}
	
	public void delete(Product usuario) {
		productRepository.delete(usuario);
	}
	
	public Iterable<Product> findAll(){
		return productRepository.findAll();
	}
}
