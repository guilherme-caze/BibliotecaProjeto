package br.com.biblioteca.main;

import java.time.LocalDate;

import br.com.biblioteca.biblioteca.impl.DVD;
import br.com.biblioteca.biblioteca.impl.Livros;

public class Main {

	public static void main(String[] args) {
		
		LocalDate releaseDate = LocalDate.of(2024, 6, 19);
		
		DVD objDvd = new DVD("Speed Racer","Desenho",15,true,releaseDate,"Lana Wachowski","HBO MAX"); 
		
		objDvd.exibir_informacoes();
		objDvd.emprestar();
		objDvd.devolver();
		objDvd.calcularMulta(2);
		
		System.out.println("========================================================");
		
		
		LocalDate realeaseData = LocalDate.of(2023, 12, 10);
		
		Livros objLivro = new Livros("Harry Potter", "Aventura", 10, true, realeaseData, "J. K. Rowlng", "Rocco");
        
		objLivro.exibir_informacoes();
		objLivro.emprestar();
		objLivro.devolver();
		objLivro.calcularMulta(179);
		
		
		
	}

}
