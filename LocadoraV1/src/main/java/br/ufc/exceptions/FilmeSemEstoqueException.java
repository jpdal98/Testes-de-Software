package br.ufc.exceptions;

public class FilmeSemEstoqueException extends Exception{
	private static final long serialVersionUID = 1L;

	public FilmeSemEstoqueException(String message) {
		super(message);
	}
}
