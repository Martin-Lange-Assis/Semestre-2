package exercicio03;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.junit.jupiter.api.Test;

class Exercicio03Teste {

	@Test
	void testHistograma() throws IOException {
		// criar o arquivo a ser usado no teste
		FileOutputStream fos = new FileOutputStream("ArquivoTesteHistograma.tst");
		Random r = new Random();
		int LINHAS = 400;
		int COLUNAS = 400;
		int valor;
		int[] esperado = new int[256];
		for (int i = 0; i < LINHAS; i++) {
			for (int j = 0; j < COLUNAS; j++) {
				valor = r.nextInt(256);
				esperado[valor]++;
				fos.write(valor);
			}
		}
		fos.close();

		Exercicio03Teste exe = new Exercicio03Teste();
		Path caminho = Paths.get("ArquivoTesteHistrograma.tst");
		int[] retorno = exe.histograma(caminho);
		assertArrayEquals(esperado, retorno);
	}

	private int[] histograma(Path caminho) {
		// TODO Auto-generated method stub
		return null;
	}

}
