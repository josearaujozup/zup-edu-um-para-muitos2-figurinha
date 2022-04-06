package br.com.zup.edu.umparamuitos2figurinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.edu.umparamuitos2figurinha.model.Figura;

@Repository
public interface FiguraRepository extends JpaRepository<Figura, Long>{

}
