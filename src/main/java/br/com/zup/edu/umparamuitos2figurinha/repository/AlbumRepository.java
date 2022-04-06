package br.com.zup.edu.umparamuitos2figurinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.edu.umparamuitos2figurinha.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

}
