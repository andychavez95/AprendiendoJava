package com.hristochavez.app;

public class Libro{
	private String titulo;
	private String autor;
	private String isbn;

	public Libro(String titulo, String autor, String isbn){
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
	}

	public String getTitulo(){ return this.titulo; }

	public String getAutor(){ return this.autor; }

	public String getIsbn(){ return this.isbn; }

	public void setTitulo(String titulo){ this.titulo = titulo; }

	public void setAutor(String autor){ this.autor = autor; }

	public void setIsbn(String isbn){ this.isbn = isbn; }
}

