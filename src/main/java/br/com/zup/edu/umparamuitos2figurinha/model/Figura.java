package br.com.zup.edu.umparamuitos2figurinha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Figura {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private Integer pagina;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne(optional = false)
	private Album album;
	
	public Figura(Integer pagina, String descricao) {
		super();
		this.pagina = pagina;
		this.descricao = descricao;
	}
	
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Figura() {
    	
    }

	public Long getId() {
		return id;
	}

	public Integer getPagina() {
		return pagina;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
}
