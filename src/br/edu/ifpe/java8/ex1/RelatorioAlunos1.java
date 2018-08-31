package br.edu.ifpe.java8.ex1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;



import br.edu.ifpe.java8.entidades.Aluno;

/**
 * 
 * @author Michael Lucas
 *
 */
public class RelatorioAlunos1 {
	
	private static final String SEPARADOR = "#";

	private static final double MEDIA_APROVACAO = 6;
	private static final double MEDIA_MINIMA_FINAL = 2;
	
	private static final Map<TipoRelatorio1, Predicate<Aluno>> PREDICADOS;
	
	static {
		PREDICADOS = new HashMap<>();
		
		PREDICADOS.put(TipoRelatorio1.TODOS, aluno -> true);
		PREDICADOS.put(TipoRelatorio1.APENAS_APROVADOS, aluno -> aluno.getMedia() >= MEDIA_APROVACAO);
		PREDICADOS.put(TipoRelatorio1.APENAS_REPROVADOS_DIRETO, aluno -> aluno.getMedia() < MEDIA_MINIMA_FINAL);
		PREDICADOS.put(TipoRelatorio1.APENAS_FINAL, aluno -> aluno.getMedia() < MEDIA_APROVACAO && aluno.getMedia() >= MEDIA_MINIMA_FINAL);
	}

	public static void gerar(TipoRelatorio1 opcao) {
		File arquivoEntrada = new File("alunos.txt");
		File arquivoSaida = new File("relatorio.txt");

		Scanner leitor = null;
		PrintWriter escritor = null;

		try {
			leitor = new Scanner(arquivoEntrada);
			escritor = new PrintWriter(arquivoSaida);

			while (leitor.hasNextLine()) {
				String linha = leitor.nextLine();

				String[] valores = linha.split(SEPARADOR);

				Aluno aluno = new Aluno();
				aluno.setNome(valores[0]);
				aluno.setMatricula(valores[1]);
				aluno.setMedia(Double.parseDouble(valores[2]));

				if (PREDICADOS.get(opcao).test(aluno)) {
					escritor.println(aluno.getNome());	
				}
			}
		} catch (IOException e) {
			/* DO NOTHING */
		} finally {
			if (leitor != null) {
				leitor.close();
			}
			if (escritor != null) {
				escritor.close();
			}
		}
	}
}
