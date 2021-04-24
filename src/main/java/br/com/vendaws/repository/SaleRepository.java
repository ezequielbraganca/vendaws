package br.com.vendaws.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vendaws.entity.Sale;

public interface SaleRepository extends CrudRepository<Sale, Integer> {

}
