/*Crie uma classe chamada VetorDeReais, que internamente possui um vetor de n reais (double). n é 
passado como parâmetro na criação do objeto. Implemente métodos para:

a) Receber os n valores;
b) Retornar a quantidade de números pares (considerando a parte inteira dos números);
c) Retornar um novo objeto de VetorDeReais, criado a partir da divisão deste objeto (A) por outro 
objeto recebido como parâmetro (B), sendo novo[i] = A[i] / B[i];
d) Retornar o valor da multiplicação (M) entre este objeto de VetorDeReais (A) e outro objeto 
recebido como parâmetro (B), de tal modo que M = (A[1] * B[n]) + (A[2] * B[n-1]) + ...
e) Inverter a posição dos elementos do vetor, ou seja, o primeiro elemento vai para a posição do 
último elemento e o último elemento vai para a posição do primeiro elemento, o segundo 
elemento vai para a posição do penúltimo elemento e o penúltimo elemento vai para a posição 
do segundo elemento, e assim por diante; 
f) Retornar a maior diferença entre dois elementos consecutivos do vetor.

A interface ao usuário deverá permitir a entrada dos valores e possuir botões para acionar os métodos 
implementados. Para os itens c) e d), que necessitam de outro objeto de VetorDeReais, crie um botão 
que armazena o objeto manipulado naquele momento, para ser usado quando o usuário desejar fazer 
uma multiplicação ou divisão*/

package exercicio06;

public class VetorDeReais {
	private double[] vetor;

	public VetorDeReais(int tamanho) {
		this.vetor = new double[tamanho];
	}

	// item a
	public void setValor(double valor, int posicao) {
		this.vetor[posicao] = valor;
	}

	// item b
	public int quantosPares() {
		int qtd = 0;
		for (int i = 0; i < vetor.length; i++) {
			if ((int) vetor[i] % 2 == 0) {
				qtd++;
			}
		}
		return qtd;
	}

	// item c
	public VetorDeReais divisao(VetorDeReais outro) {
		if (this.getTamanho() != outro.getTamanho()) {
			return null;
		}
		VetorDeReais novo = new VetorDeReais(vetor.length);
		double novoValor;

		for (int i = 0; i < vetor.length; i++) {
			novoValor = vetor[i] / outro.getValor(i);
			novo.setValor(novoValor, i);
		}

		return novo;
	}

	public int getTamanho() {
		return this.vetor.length;
	}

	public double getValor(int posicao) {
		return this.vetor[posicao];
	}

	// item d
	public double multiplicacao(VetorDeReais outro) {
		if (this.getTamanho() != outro.getTamanho()) {
			return Double.NaN;
		}
		double m = 0;
		for (int i = 0, j = vetor.length - 1; i < vetor.length; i++, j--) {
			m = m + this.getValor(i) * outro.getValor(j);
		}

		return m;
	}

	// item e
	public void inverter() {
		double aux;
		for (int i = 0; i < this.getTamanho() / 2; i++) {
			aux = this.vetor[i];
			this.vetor[i] = this.vetor[vetor.length - 1 - i];
			this.vetor[vetor.length - 1 - i] = aux;
		}
	}

	public double maiorDiferenca() {
		double maiorDiferenca = 0;
		double diferenca;

		for (int i = 1; i < this.vetor.length; i++) {
			diferenca = Math.abs(this.vetor[i] - this.vetor[i - 1]);
			if (maiorDiferenca < diferenca) {
				maiorDiferenca = diferenca;
			}
		}

		return maiorDiferenca;
	}

	public String exibir() {
		String str = "[";
		for (int i = 0; i < this.getTamanho(); i++) {
			str += this.vetor[i] + ", ";
		}
		return str + "]";
	}

}
