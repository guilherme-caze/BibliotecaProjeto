package br.com.biblioteca.interfaces;

public interface Gerenciavel {
	
	boolean emprestar();
	boolean devolver();
	double calcularMulta(int diasAtrasados);
}
