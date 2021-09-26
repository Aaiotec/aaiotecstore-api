package com.antoniopakas.aaiotecstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antoniopakas.aaiotecstore.domain.Livro;
import com.antoniopakas.aaiotecstore.repositories.LivroRepository;
import com.antoniopakas.aaiotecstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {


	@Autowired
	private LivroRepository repository;
	
	
	public Livro findById(Integer id) {
		
		Optional<Livro> obj  = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objecto não encontrado! Id: " + id+ ", Tipo: " + Livro.class.getName()));
}
}
