package br.com.zup.edu.umparamuitos2figurinha.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String titulo;
	private String descricao;
	private Integer numeroPaginas;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "album")
	private List<Figura> figuras = new ArrayList<>();
	
	public Album(String titulo, String descricao, Integer numeroPaginas) {
		
		this.titulo = titulo;
		this.descricao = descricao;
		this.numeroPaginas = numeroPaginas;
	}
	
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Album() {
    	
    }

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void colar(Figura figura) {
		figura.setAlbum(this);
		this.figuras.add(figura);
	}
    	
}
