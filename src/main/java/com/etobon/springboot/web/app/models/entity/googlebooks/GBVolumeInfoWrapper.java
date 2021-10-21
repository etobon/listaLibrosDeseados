package com.etobon.springboot.web.app.models.entity.googlebooks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GBVolumeInfoWrapper {

	private String id;
	private String title;
	private String publisher;
	private String publishedDate;
	private String[] authors;
	private String description;
	private String[] categories;
	private Map<String, String> imageLinks = new HashMap<String, String>();
	private String language;
	private String isbn;
	private String previewLink;

	public GBVolumeInfoWrapper() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public Map<String, String> getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(Map<String, String> imageLinks) {
		this.imageLinks = imageLinks;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPreviewLink() {
		return previewLink;
	}

	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	@Override
	public String toString() {
		return "GBVolumeInfoWrapper [id=" + id + ", title=" + title + ", publisher=" + publisher + ", publishedDate="
				+ publishedDate + ", authors=" + Arrays.toString(authors) + ", description=" + description
				+ ", categories=" + Arrays.toString(categories) + ", imageLinks=" + imageLinks + ", language="
				+ language + ", isbn=" + isbn + ", previewLink=" + previewLink + "]";
	}

}
