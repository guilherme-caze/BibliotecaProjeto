package br.com.biblioteca.biblioteca.impl;

import java.time.LocalDate;
import br.com.biblioteca.interfaces.Gerenciavel;

public class Biblioteca implements Gerenciavel {

//Atributos da classe pai
	private String titulo;
	private String genero;
	private int classificacaoEtaria;
//Atributo abaixo: adicionado para rastrear se há uma multa pendente.
	private boolean temMultaEmAtraso;
//Atributos que registram na memoria o prazo que o produto ficou em emprestimo e faz a verificacao se a multa será aplicada
	private LocalDate dataEmprestimo;
	private static final int PRAZO_DEVOLUCAO = 15;
	private static final double VALOR_MULTA_POR_DIA = 2.0;
//private static final: Um membro declarado como private static final é uma constante de classe que é imutável, pertencente à classe e não visível fora dela.
	
	
	//Construtor: serve para inicializar as variáveis com os valores de variáveis inseridos na main
	public Biblioteca(String titulo, String genero, int classificacaoEtaria, boolean temMultaEmAtraso, LocalDate dataEmprestimo) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.classificacaoEtaria = classificacaoEtaria;
		this.temMultaEmAtraso = temMultaEmAtraso;
		this.dataEmprestimo = dataEmprestimo;
	}
	
	
//Métodos
	public void exibir_informacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Gênero: " + genero);
        System.out.println("Classificação Etária: " + classificacaoEtaria);
        System.out.println("Data de Empréstimo: " + dataEmprestimo);
}
	
	@Override
	public boolean emprestar() {
	if (temMultaEmAtraso) {
        System.out.println("Empréstimo não pode ser feito. Há multa em atraso.");
        return false;
    }
    dataEmprestimo = LocalDate.now();
    	System.out.println("Emprestimo realizado com sucesso");
    return true;
	}

	@Override
	public boolean devolver() {
        if (dataEmprestimo == null) {
            System.out.println("Nenhum empréstimo registrado.");
            return false;
        }
    //localDate.now: obtém a data atual --- toEpochDay: converte a data para o número de dias desde a época inserida --- (-) subtração dataEmprestimo.toEpochDay: calcula a diferença entre os valores e retorna o resultado em dias
        long diasEmprestado = LocalDate.now().toEpochDay() - dataEmprestimo.toEpochDay();
    //long diasEmprestado: armazena o resultado da operação acima, ou seja, quantos dias o objeto ficou emprestado
        if (diasEmprestado > PRAZO_DEVOLUCAO) {
            int diasAtrasados = (int) (diasEmprestado - PRAZO_DEVOLUCAO);
            temMultaEmAtraso = true;
            System.out.println("Devolução atrasada. Dias atrasados: " + diasAtrasados);
            return false;
        }
        
        System.out.println("Devolução feita no prazo.");
        temMultaEmAtraso = false;
        dataEmprestimo = null;
        return true;
	}

	@Override
	public double calcularMulta(int diasAtrasados) {
    //Implementação do cálculo de multa
		return diasAtrasados * VALOR_MULTA_POR_DIA;
	}


	public String getTitulo() {
		return titulo;
	}
	

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public boolean getTemMultaEmAtraso() {
		return temMultaEmAtraso;
	}
	
	
	public void setTemMultaEmAtraso(boolean temMultaEmAtraso) {
		this.temMultaEmAtraso = temMultaEmAtraso;
	}

	public int getClassificacaoEtaria() {
		return classificacaoEtaria;
	}


	public void setClassificacaoEtaria(int classificacaoEtaria) {
        if (classificacaoEtaria < 16) {
		System.out.println("Idade insuficiente. Você deve ser maior de 16 anos para acessar esse conteúdo.");
        } else {
        	this.classificacaoEtaria = classificacaoEtaria;
        }
        
        
	}
}