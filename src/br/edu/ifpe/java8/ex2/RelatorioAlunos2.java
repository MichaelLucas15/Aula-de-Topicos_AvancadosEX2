package br.edu.ifpe.java8.ex2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import br.edu.ifpe.java8.entidades.Aluno;

/**
 * 
 * @author Michael Lucas
 *
 */
public class RelatorioAlunos2 {

	private static final String SEPARADOR = "#";
	
	private static final Map<TipoRelatorio2, Function<Aluno, String>> FUNCOES;

	static {
		FUNCOES = new HashMap<>();

		FUNCOES.put(TipoRelatorio2.NOME, aluno -> aluno.getNome());
		FUNCOES.put(TipoRelatorio2.NOME_MATRICULA, aluno -> aluno.getNome() + SEPARADOR + aluno.getMatricula());
		FUNCOES.put(TipoRelatorio2.NOME_MATRICULA_MEDIA, aluno -> aluno.getNome() + SEPARADOR + aluno.getMatricula() + SEPARADOR + aluno.getMedia());
		FUNCOES.put(TipoRelatorio2.NOME_MEDIA, aluno -> aluno.getNome() + SEPARADOR + aluno.getMedia());
		FUNCOES.put(TipoRelatorio2.MATRICULA_MEDIA, aluno -> aluno.getMatricula() + SEPARADOR + aluno.getMedia());

	}

	public static void gerar(TipoRelatorio2 opcao) {
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
				escritor.println(FUNCOES.get(opcao).apply(aluno));

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
