package br.com.vendaws.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sale {


	@Id
	@Column(name = "sale_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference(value = "user-sale")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "add_id", nullable = false)
	@JsonBackReference(value="address-sale")
	private Address address;
	
	@OneToMany(mappedBy = "sale")
	@JsonManagedReference(value = "sale-sale-product")
	private List<SaleProduct> saleProductLst;
}
