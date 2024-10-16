package br.com.biblioteca.biblioteca.impl;

import java.time.LocalDate;

public class DVD extends Biblioteca{

	//Atributos: características da classe DVD
	
	private String diretoria;
	private String produtora;
	
	//Construtor: serve para inicializar as variáveis com os valores de variáveis inseridos na main
	
	public DVD(String titulo, String genero, int classificacaoEtaria, boolean temMultaEmAtraso, LocalDate dataEmprestimo, String diretoria, String produtora) {
		super(titulo, genero, classificacaoEtaria, temMultaEmAtraso, dataEmprestimo);
		this.diretoria = diretoria;
		this.produtora = produtora;
	}
	
	//Getters and Setters: quando as variáveis estão privadas em uma classe e quer acessá-la por outra classe, deve-se criar os getters and setters para conseguir acessá-los. 
	
	public String getdiretoria() {
		return diretoria;
	}


	public void setdiretora(String diretoria) {
		this.diretoria = diretoria;
	}

	public String getprodutora() {
		return produtora;
	}

	public void setprodutora(String produtora) {
		this.produtora = produtora;
	}

	//Métodos: são as ações que o objeto realiza 
	
	@Override
	public void exibir_informacoes() {
		super.exibir_informacoes();
		System.out.println("Diretoria: " + diretoria);
		System.out.println("Produtora: " + produtora); // adicionei dois prints para printar a diretoria do DVD e sua produtora
	}

	@Override
	public double calcularMulta(int diasAtrasados) {
		
		double multaCalculada = super.calcularMulta(diasAtrasados); //criei o "multaCalculada" para obter o valor calculado da multa, sem essa variavel, o valor do resultado sempre será 0
		
		if (getTemMultaEmAtraso()){ // vai verificar se tem multa em atraso atraves do valor inserido na main, se for "true" vai printar o valor da multa, se for "false" não ira printar valor nenhum
			
			System.out.println("O valor da multa do DVD " + getTitulo() + " é de R$: " + multaCalculada);
		 
		} // caso tenha multa em atraso, vai printar o seu valor
		else {
            System.out.println("Não há multa em atraso para o DVD " + getTitulo());
         
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
