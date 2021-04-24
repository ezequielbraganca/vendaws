package br.com.vendaws.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vendaws.entity.User;

public interface UserRepository  extends CrudRepository<User, Integer>{

}
