package br.edu.ifpe.java8.ex2;

import java.util.Scanner;

public class MainEx2 {

	public static void main(String[] args) {

		System.out.println(" ______________________________________________________________________");
		System.out.println("|_________________Bem vindo ao gerador de relatórios___________________|");
		System.out.println("|                                                                      |");
		System.out.println("|Digite 1 - Para ver o nome de todos os alunos:                        |");
		System.out.println("|Digite 2 - Para ver o nome e a matrícula de todos os alunos:          |");
		System.out.println("|Digite 3 - Para ver o nome, a matrícula e a média de todos os alunos: |");
		System.out.println("|Digite 4 - Para ver o nome e a média de todos os alunos:              |");
		System.out.println("|Digite 5 - Para ver a matrícula e a média de todos os alunos:         |");
		System.out.println(" ----------------------------------------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		int numeral = sc.nextInt();

		if (numeral == 1) {
			RelatorioAlunos2.gerar(TipoRelatorio2.NOME);
			System.out.println("Veja o relatório no arquivo 'relatorio.txt'");
		} else if (numeral == 2) {
			RelatorioAlunos2.gerar(TipoRelatorio2.NOME_MATRICULA);
			System.out.println("Veja o relatório no arquivo 'relatorio.txt'");
		} else if (numeral == 3) {
			RelatorioAlunos2.gerar(TipoRelatorio2.NOME_MATRICULA_MEDIA);
			System.out.println("Veja o relatório no arquivo 'relatorio.txt'");
		} else if (numeral == 4) {
			RelatorioAlunos2.gerar(TipoRelatorio2.NOME_MEDIA);
			System.out.println("Veja o relatório no arquivo 'relatorio.txt'");
		} else if (numeral == 5) {
			RelatorioAlunos2.gerar(TipoRelatorio2.MATRICULA_MEDIA);
			System.out.println("Veja o relatório no arquivo 'relatorio.txt'");
		}
	}
}
