/*A Câmara Municipal de Vereadores de Blumenau pretende realizar uma estatística sobre o desempenho dos 
seus parlamentares durante a última legislatura. Para cada um dos 15 vereadores, ela possui o nome, partido 
(número e nome), quantidade de projetos apresentados, quantidade de projetos aprovados. 
O desempenho é calculado da seguinte forma: 
(projetos aprovados / projetos apresentados) * índice de trabalho. 
Se não apresentou nenhum projeto, o desempenho é 0 (zero). O índice de trabalho é definido pela seguinte 
tabela:

Projetos apresentados 	Índice de trabalho
01 – 05 						0,80
06 – 10 						1,00
11 – 17 						1,08
acima de 17 					1,22

Escreva um programa Java orientado a objetos que leia os dados disponíveis pela Câmara e imprima o nome, 
partido e desempenho do vereador. Faça o tratamento de exceções.

A qualquer momento pode-se consultar:
a) o total de projetos apresentados e de aprovados na câmara;
b) o nome, partido e desempenho do vereador com mais projetos aprovados;
c) o nome, partido e desempenho do vereador com menor desempenho;
d) o nome, partido e desempenho dos vereadores cujo desempenho seja maior que o desempenho médio de 
toda a câmara;
e) a média de desempenho por partido político;
f) o total de projetos apresentados e de aprovados por partido político*/

package camara;

import java.util.ArrayList;
import java.util.HashMap;

public class Camara {
	private ArrayList<Partido> partidos;
	private HashMap<Integer, Partido> partidos1;

	public int totalProjAprovadoCamara() {
		int contador = 0;
		for (Partido partido : partidos) {
			contador += partido.totalProjAprova();
		}
		return contador;
	}

	public int getTotalProjAprovCamara() {
		int contador = 0;
		for (Partido partido : partidos) {
			contador += partido.totalProjAprova();
		}
		return contador;
	}

	public Vereador maisProjAptovad() {
		Vereador retornar = null;
		for (Partido partido : partidos) {
			Vereador comparar = partido.maisProjAprov();
			if (retornar == null || comparar.getQntProjAprovado() > retornar.getQntProjAprovado()) {
				retornar = comparar;
			}
		}
		return retornar;
	}

	public Vereador menorDesempenho() {
		Vereador retornar = null;
		for (Partido partido : partidos) {
			Vereador comparar = partido.menorDesempenho();
			if (retornar == null || comparar.getDesempenho() < retornar.getDesempenho()) {
				retornar = comparar;
			}
		}
		return retornar;
	}

	public int getTotalPartidos() {
		return partidos.size();
	}

	public void addPartido(Partido p) {
		partidos.add(p);
		if (partidos1.containsKey(p.getNumero())) {
			partidos1.put(p.getNumero(), p);
		}
	}

	public Partido getPartido(int numero) {
		return partidos1.get(numero);
	}

	public double mediaDesempenho() {
		double soma = 0;
		int conta = 0;
		for (Partido partido : partidos) {
			soma += partido.mediaDesempenho() * partido.qntVereadores();
			conta += partido.qntVereadores();
		}
		return soma / conta;
	}

	public ArrayList<Vereador> getVereadorAcimaMedia() {
		ArrayList<Vereador> osBao = new ArrayList<>();
		double media = this.mediaDesempenho();

		for (Partido p : partidos) {
			ArrayList<Vereador> lista = p.getVereadors();
			for (Vereador vereador : lista) {
				if (vereador.getDesempenho() > media) {
					osBao.add(vereador);
				}
			}
		}
		return osBao;
	}

}
