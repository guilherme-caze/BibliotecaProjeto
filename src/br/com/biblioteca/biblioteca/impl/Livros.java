package br.com.biblioteca.biblioteca.impl;

import java.time.LocalDate;

public class Livros extends Biblioteca{
//atributos da classe filha Livros
	
	private String autor;
	private String editora;

//Construtores	
	public Livros(String titulo, String genero, int classificacaoEtaria, boolean temMultaEmAtraso,
			LocalDate dataEmprestimo, String autor, String editora) {
		super(titulo, genero, classificacaoEtaria, temMultaEmAtraso, dataEmprestimo);
		this.autor = autor;
		this.editora = editora;
	}
// Setters e Getters

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
//Métodos
	@Override
	public void exibir_informacoes() {
		super.exibir_informacoes();
		System.out.println("Autor(a): " + autor);
		System.out.println("Editora: " + editora); // Método para print dos atributos da classe filha Livros
	}

	@Override
	public double calcularMulta(int diasAtrasados) {
		
		double multaCalculada = super.calcularMulta(diasAtrasados);
		
		if (getTemMultaEmAtraso()){ //Método que verifica se existe alguma multa,caso exista exibirá essa informação 
			
			System.out.println("O valor da multa do Livro " + getTitulo() + " é de R$: " + multaCalculada);
		}
		else {
            System.out.println("Não há multa em atraso para o Livro " + getTitulo());
        }
		return multaCalculada;
	
	}
	@Override
	public int getClassificacaoEtaria() {
		return super.getClassificacaoEtaria();
	}

	@Override
	public boolean emprestar() {
		return super.emprestar();
	}

	@Override
	public boolean devolver() {
		return super.devolver();
}

}
