package com.farmacia.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_produtos")
public class Produto {
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo Nome é obrigaório")
    @Size(min = 5, max = 1000, message = "O atributo nome deve ter no mínimo 5 caracteres e no máximo 1000 caracteres.")
    private String nome;

    @PositiveOrZero
    private Float preco;

    @NotBlank(message = "O Atributo descrição é obrigatório")
    @Size(min = 5, max = 1000, message = "O campo descrição precisa ter entre 5 à 1000 caracteres")
    private String descricao;

    @NotBlank(message = "O Atributo foto é obrigatório")
    @Size(max = 5000)
    private String foto;

    @NotBlank(message = "O Atributo marca é obrigatório")
    @Size(min = 3, max = 1000, message = "O campo marca precisa ter entre 3 à 1000 caracteres")
    private String marca;
    
    
    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;
    
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
    
    
}
