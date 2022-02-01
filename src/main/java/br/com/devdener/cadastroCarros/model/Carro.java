package br.com.devdener.cadastroCarros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CARRO")
@Getter
@Setter
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	@NotEmpty @NotNull @Length(max = 255, min = 3)
	private String descricao;
	@Column
	@NotEmpty @NotNull @Length(max = 10, min = 4)
	private String ano;
}
