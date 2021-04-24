package br.com.vendaws.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendaws.entity.Address;
import br.com.vendaws.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public Address save(Address usuario) {
		return addressRepository.save(usuario);
	}
	
	public Optional<Address> findById(Integer id) {
		return addressRepository.findById(id);
	}
	
	public void delete(Address usuario) {
		addressRepository.delete(usuario);
	}
	
	public Iterable<Address> findAll(){
		return addressRepository.findAll();
	}
}
