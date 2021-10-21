package com.etobon.springboot.web.app.models.service;

import java.util.List;

import com.etobon.springboot.web.app.models.entity.Libro;


public interface IGoogleBooksService {
	
	public List<Libro> getByAuthor(String author, Integer startIndex);
	
	public List<Libro> getByTitle(String title, Integer startIndex);
	
	public List<Libro> getByPublisher(String publisher, Integer startIndex);
	
	public Libro getByIdAndTitle(String id, String title);
	
}
