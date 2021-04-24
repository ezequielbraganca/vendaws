package br.com.vendaws.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vendaws.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{

}
