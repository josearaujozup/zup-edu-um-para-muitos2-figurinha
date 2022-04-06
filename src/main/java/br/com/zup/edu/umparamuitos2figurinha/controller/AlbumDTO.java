package br.com.zup.edu.umparamuitos2figurinha.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zup.edu.umparamuitos2figurinha.model.Album;

public class AlbumDTO {
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String descricao;
	
	@NotNull
//    @Size(min = 10, max = 10)
    @Min(10)
    @Max(100)
	private Integer numeroPaginas;
	
	@Valid
	@NotEmpty
	private List<FiguraDTO> figuras;

	public AlbumDTO(@NotBlank String titulo, String descricao, Integer numeroPaginas,
			@Valid @NotEmpty List<FiguraDTO> figuras) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.numeroPaginas = numeroPaginas;
		this.figuras = figuras;
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

	public List<FiguraDTO> getFiguras() {
		return figuras;
	}

	public Album toModel() {
		Album album = new Album(titulo, descricao, numeroPaginas);
		figuras.forEach(f -> {
			album.colar(f.toModel());
		});
		
		return album;
	}
	
}
