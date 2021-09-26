package com.antoniopakas.aaiotecstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.antoniopakas.aaiotecstore.domain.Categoria;
import com.antoniopakas.aaiotecstore.dtos.CategoriaDTO;
import com.antoniopakas.aaiotecstore.service.CategoriaService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Categoria>findById(@PathVariable Integer id) {
		
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
}
	@GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
	
	 List<Categoria> list = service.findAll();
	 List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	 
	 return ResponseEntity.ok().body(listDTO);
}
	
	@PostMapping
	public ResponseEntity<Categoria> creat(@RequestBody Categoria obj){
	
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
		
		//return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO obj){
	
		Categoria newObj  = service.update(id, obj);
		
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
	}
}
