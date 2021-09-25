package com.antoniopakas.aaiotecstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antoniopakas.aaiotecstore.domain.Categoria;
import com.antoniopakas.aaiotecstore.domain.Livro;
import com.antoniopakas.aaiotecstore.repositories.CategoriaRepository;
import com.antoniopakas.aaiotecstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1= new Categoria(null, "Informatica","Livros de Informatica");
		Categoria cat2= new Categoria(null, "Ficçao Cientifica","Livros de Ficçao Cientifica");
		Categoria cat3= new Categoria(null, "Biografias","Livros de Biografias");
		
		Livro l1= new Livro(null, "Clean Code","Robert Marlin","Livro de Lorem ipson",cat1);
		Livro l2= new Livro(null, "Engenharia de Software","Antonio Pakas","Livro de Lorem ipson",cat1);
		Livro l3= new Livro(null, "The Time Machine","Joao Marlin","Livro de Lorem ipson",cat2);
		Livro l4= new Livro(null, "The War of the Worlds","Robert Marlin","Livro de Lorem ipson",cat2);
		Livro l5= new Livro(null, "I. Robot","Robert Marlin","Livro de Lorem ipson",cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
		
	}
}
