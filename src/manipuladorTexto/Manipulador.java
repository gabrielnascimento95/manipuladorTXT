package manipuladorTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Manipulador {
	
	public Manipulador() {
		// TODO Auto-generated constructor stub
	}

	public List<String> ler(String caminhoArq) { //caminho do arquivo no disco
		List<String> listStrings = new ArrayList<>(); // instancia um vetor de string
		try {
			FileReader arq = new FileReader(caminhoArq);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				listStrings.add(linha); //cada linha do arquivo um obj string da lista
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		return listStrings;
	}
	
	public void gravarTexto(String mensagem) {
		String caminhoArq = "/home/gabriel/saida.txt"; //caminho do arquvo de saida
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(caminhoArq, true));
			printWriter.println(mensagem);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			System.err.printf("Erro na gravação do arquivo: %s.\n", e.getMessage());
		}
	}
}
