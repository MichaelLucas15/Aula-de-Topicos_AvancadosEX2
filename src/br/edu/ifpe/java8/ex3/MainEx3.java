package br.edu.ifpe.java8.ex3;

import java.util.Scanner;

public class MainEx3 {

	public static void main(String[] args) {

		System.out.println(" ___________________________________________________________");
		System.out.println("|____________Bem vindo ao gerador de relatórios_____________|");
		System.out.println("|                                                           |");
		System.out.println("|Digite 1 - Para ver a média geral da turma:                |");
		System.out.println("|Digite 2 - Para ver a quantidade de alunos acima da média: |");
		System.out.println("|Digite 3 - Para ver a quantidade de alunos abaixo da média:|");
		System.out.println(" -----------------------------------------------------------");

		Scanner sc = new Scanner(System.in);
		int numeral = sc.nextInt();
		if (numeral == 1) {
			RelatorioAlunos3.gerar(TipoRelatorio3.MEDIA_GERAL);
			System.out.println("Veja o relatório no arquivo 'relatorio.txt'");
		} else if (numeral == 2) {
			RelatorioAlunos3.gerar(TipoRelatorio3.ALUNOS_ACIMA_DA_MEDIA);
			System.out.println("Veja o relatório no arquivo 'relatorio.txt'");
		} else if (numeral == 3) {
			RelatorioAlunos3.gerar(TipoRelatorio3.ALUNOS_ABAIXO_DA_MEDIA);
			System.out.println("Veja o relatório no arquivo 'relatorio.txt'");
		}
	}
}
