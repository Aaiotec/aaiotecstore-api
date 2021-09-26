package com.antoniopakas.aaiotecstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.antoniopakas.aaiotecstore.domain.Categoria;
import com.antoniopakas.aaiotecstore.repositories.CategoriaRepository;


@Service
public class CategoriaService {
	

@Autowired
private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		
		Optional<Categoria>obj = repository.findById(id);
		return obj.orElse(null);
		
}
}