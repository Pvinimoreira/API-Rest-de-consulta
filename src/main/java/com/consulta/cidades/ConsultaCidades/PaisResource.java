package com.consulta.cidades.ConsultaCidades;


import com.consulta.cidades.ConsultaCidades.repository.PaisRepository;
import com.consulta.cidades.ConsultaCidades.pais.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/paises")
public class PaisResource {

    @Autowired
    private PaisRepository repository;

    @GetMapping
    public Page<Pais> paises(Pageable page){

        return repository.findAll(page);
   }

   @GetMapping ("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
       Optional<Pais> optional = repository.findById(id);
       if(optional.isPresent()){
           return ResponseEntity.ok().body(optional.get());
       } else {
           return ResponseEntity.notFound().build();
       }

   }

}