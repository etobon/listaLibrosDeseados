package com.etobon.springboot.web.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.etobon.springboot.web.app.models.entity.Libro;
import com.example.springboot.app.models.entity.googlebooks.GBItemsWrapper;
import com.example.springboot.app.models.entity.googlebooks.GBWrapper;

@Service
public class GoogleBooksServiceImpl implements IGoogleBooksService {

	public List<Libro> getByAuthor(String author, Integer startIndex) {

		List<Libro> libros = new ArrayList<>();

		String[] authores = { author };

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<GBWrapper> entity = restTemplate.getForEntity(
				"https://www.googleapis.com/books/v1/volumes?q=auhtor:" + author
						+ "&key=AIzaSyBITHy331YPVDsMldlaI6PketpDKZg8Jo4&maxResults=40&startIndex=" + startIndex,
				GBWrapper.class);

		Integer cantLibros = entity.getBody().getTotalItems();
		Integer maxResults = 20;

		if (cantLibros > 0) {

			for (GBItemsWrapper item : entity.getBody().getItems()) {

				Libro libro = new Libro();

				libro.setAuthors(authores[0]);
				libro.setIsbn(item.getVolumeInfo().getIsbn());
				libro.setTitle(item.getVolumeInfo().getTitle());
				libro.setPublisher(item.getVolumeInfo().getPublisher());
				libro.setDescription(item.getVolumeInfo().getDescription());
				libro.setPreviewLink(item.getVolumeInfo().getPreviewLink());

				String imageUrl = "";

				if (item.getVolumeInfo().getImageLinks().get("thumbnail") != null) {
					imageUrl = item.getVolumeInfo().getImageLinks().get("thumbnail");
				}

				libro.setThumbnail(imageUrl);

				libros.add(libro);

			}

		}

		return libros;
	}

	@Override
	public Libro getByIdAndTitle(String id, String title) {

		List<Libro> libros = new ArrayList<>();

		Libro libro = new Libro();

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<GBWrapper> entity = restTemplate
				.getForEntity("https://www.googleapis.com/books/v1/volumes?q=title:" + title
						+ "&key=AIzaSyBITHy331YPVDsMldlaI6PketpDKZg8Jo4&maxResults=40", GBWrapper.class);

		Integer cantLibros = entity.getBody().getTotalItems();
		Integer maxResults = 20;

		if (cantLibros > 0) {

			for (GBItemsWrapper item : entity.getBody().getItems()) {

				if (item.getVolumeInfo().getTitle().equalsIgnoreCase(title)) {

					if (item.getId().equals(id)) {

						libro.setTitle(title);
						libro.setIsbn(item.getVolumeInfo().getIsbn());

						if (item.getVolumeInfo().getAuthors() != null) {
							libro.setAuthors(item.getVolumeInfo().getAuthors()[0]); // Primer autor (No hace falta
																					// mostrar
																					// el
							// resto de autores)
						} else {
							libro.setAuthors(null);
						}

						libro.setPublisher(item.getVolumeInfo().getPublisher());
						
						String imageUrl = "";

						if (item.getVolumeInfo().getImageLinks().get("thumbnail") != null) {
							imageUrl = item.getVolumeInfo().getImageLinks().get("thumbnail");
						}

						libro.setThumbnail(imageUrl);

						

					}

				}

			}

		}

		return libro;
	}

	@Override
	public List<Libro> getByTitle(String title, Integer startIndex) {

		List<Libro> libros = new ArrayList<>();

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<GBWrapper> entity = restTemplate.getForEntity(
				"https://www.googleapis.com/books/v1/volumes?q=title:" + title
						+ "&key=AIzaSyBITHy331YPVDsMldlaI6PketpDKZg8Jo4&maxResults=40&startIndex=" + startIndex,
				GBWrapper.class);

		Integer cantLibros = entity.getBody().getTotalItems();
		Integer maxResults = 20;

		if (cantLibros > 0) {

			for (GBItemsWrapper item : entity.getBody().getItems()) {

				Libro libro = new Libro();

				if (item.getVolumeInfo().getAuthors() != null) {
					libro.setAuthors(item.getVolumeInfo().getAuthors()[0]);
				} else {
					libro.setAuthors("");
				}
				
				libro.setTitle(item.getVolumeInfo().getTitle());
				libro.setIsbn(item.getVolumeInfo().getIsbn());
				libro.setPublisher(item.getVolumeInfo().getPublisher());
				libro.setDescription(item.getVolumeInfo().getDescription());
				libro.setPreviewLink(item.getVolumeInfo().getPreviewLink());
				
				String imageUrl = "";

				if (item.getVolumeInfo().getImageLinks().get("thumbnail") != null) {
					imageUrl = item.getVolumeInfo().getImageLinks().get("thumbnail");
				}

				libro.setThumbnail(imageUrl);

				

				libros.add(libro);

			}

		}

		return libros;

	}

	@Override
	public List<Libro> getByPublisher(String publisher, Integer startIndex) {

		List<Libro> libros = new ArrayList<>();

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<GBWrapper> entity = restTemplate.getForEntity(
				"https://www.googleapis.com/books/v1/volumes?q=publisher:" + publisher
						+ "&key=AIzaSyBITHy331YPVDsMldlaI6PketpDKZg8Jo4&maxResults=40&startIndex=" + startIndex,
				GBWrapper.class);

		Integer cantLibros = entity.getBody().getTotalItems();
		Integer maxResults = 20;

		if (cantLibros > 0) {

			for (GBItemsWrapper item : entity.getBody().getItems()) {

				Libro libro = new Libro();

				if (item.getVolumeInfo().getAuthors() != null) {
					libro.setAuthors(item.getVolumeInfo().getAuthors()[0]);
				} else {
					libro.setAuthors("");
				}
				
				libro.setIsbn(item.getVolumeInfo().getIsbn());
				libro.setTitle(item.getVolumeInfo().getTitle());
				libro.setDescription(item.getVolumeInfo().getDescription());
				libro.setPreviewLink(item.getVolumeInfo().getPreviewLink());

				libros.add(libro);

			}

		}

		return libros;

	}

}
