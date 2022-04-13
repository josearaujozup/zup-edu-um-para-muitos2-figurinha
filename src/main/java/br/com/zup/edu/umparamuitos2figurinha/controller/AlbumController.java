package br.com.zup.edu.umparamuitos2figurinha.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.umparamuitos2figurinha.model.Album;
import br.com.zup.edu.umparamuitos2figurinha.repository.AlbumRepository;

@RestController
public class AlbumController {
	
	@Autowired
	private AlbumRepository repository;
	
	@PostMapping("/api/albuns")
	ResponseEntity<?> cadastrar(@RequestBody @Valid AlbumDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Album album = request.toModel();
		repository.save(album);
		
		URI location = uriComponentsBuilder.path("/api/albuns/{id}").buildAndExpand(album.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/api/albuns/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Long idAlbum){
		
		Album album = repository.findById(idAlbum).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro de album para o id informado"));
		
		repository.delete(album);
		
		return ResponseEntity.noContent().build();
	}
}
