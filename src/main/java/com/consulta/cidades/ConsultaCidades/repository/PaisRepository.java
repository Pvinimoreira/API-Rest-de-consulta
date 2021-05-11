package com.consulta.cidades.ConsultaCidades.repository;

import com.consulta.cidades.ConsultaCidades.pais.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository  extends JpaRepository<Pais, Long> {

}
