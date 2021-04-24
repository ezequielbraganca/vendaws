package br.com.vendaws.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendaws.entity.SaleProduct;
import br.com.vendaws.repository.SaleProductRepository;

@Service
public class SaleProductService {

	@Autowired
	private SaleProductRepository saleProductRepository;
	
	public SaleProduct save(SaleProduct saleProduct) {
		return saleProductRepository.save(saleProduct);
	}
	
	public Optional<SaleProduct> findById(Integer id) {
		return saleProductRepository.findById(id);
	}
	
	public void delete(SaleProduct usuario) {
		saleProductRepository.delete(usuario);
	}
	
	public Iterable<SaleProduct> findAll(){
		return saleProductRepository.findAll();
	}

}
