package br.com.vendaws.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vendaws.entity.SaleProduct;

public interface SaleProductRepository extends CrudRepository<SaleProduct, Integer> {

	
}
