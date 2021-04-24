package br.com.vendaws.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

	@Id
	@Column(name = "add_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotBlank(message = "Campo rua é obrigatório")
	private String street;
	
	@NotNull
	@NotBlank(message = "Campo número é obrigatório")
	private String number;
	
	@NotNull
	@NotBlank(message = "Campo bairro é obrigatório")
	private String district;
	
	@NotNull
	@NotBlank(message = "Campo cidade é obrigatório")
	private String city;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference(value = "user-adderss")
	private User user;
	
	@OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Sale> saleLst;
}
