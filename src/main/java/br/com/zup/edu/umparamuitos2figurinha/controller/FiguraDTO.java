package br.com.zup.edu.umparamuitos2figurinha.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.edu.umparamuitos2figurinha.model.Figura;

public class FiguraDTO {
	
	@NotNull
    @Positive
	private Integer pagina;
	
	@NotBlank
	private String descricao;

	public FiguraDTO(@NotNull @Positive Integer pagina, @NotBlank String descricao) {
		this.pagina = pagina;
		this.descricao = descricao;
	}

	public Integer getPagina() {
		return pagina;
	}

	public String getDescricao() {
		return descricao;
	}

	public Figura toModel() {
		return new Figura(pagina, descricao);
	}
	
}
