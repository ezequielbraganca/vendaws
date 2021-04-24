package br.com.vendaws.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vendaws.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
