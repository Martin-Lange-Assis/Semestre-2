/*Uma transportadora controla a sua frota de veículos e as manutenções efetuadas neles. De cada veículo 
sabe-se a placa, o modelo e a data de aquisição. Cada manutenção efetuada em um veículo é identificada 
por um número e são anotados o custo (R$), descrição do serviço efetuado e tempo parado do veículo (em 
dias). De acordo com o tempo acumulado de parada, um veículo tem calculado um índice de sucateamento, 
seguindo a tabela abaixo:

Tempo acumulado (dias) 			Índice
0 a 20 							0
21 a 50 						0,5
51 a 80 						1,0
81 a 120 						1,5
Acima de 120 					2,0

Implemente um programa Java OO que permita ao usuário cadastrar os veículos e realizar as operações:
a) avisar quando da inconsistência de qualquer dado através de exceções;
b) a quantidade de vezes que um mesmo serviço – descrição informada por parâmetro - foi efetuado em um 
veículo (retorno int);
c) o índice de sucateamento de um veículo (retorno float);
d) o custo médio diário de uma manutenção (custo / tempo parado; retorno float);
e) o custo médio das manutenções de um veículo (retorno float);
f) comparado com outro veículo, qual dos dois tem o maior índice de sucateamento (retorno int: positivo caso 
o objeto receptor tenha índice maior; zero caso sejam iguais; negativo caso o objeto parâmetro tenha índice 
maior)*/

package exercicio6;

import java.time.LocalDate;
import java.util.ArrayList;

public class Veiculo {
	private String placa;
	private String modelo;
	private LocalDate dataAquisicao;
	private ArrayList<Manutencao> manutencoes = new ArrayList<>();

	public Veiculo(String placa, String modelo, LocalDate dataAquisicao) {
		super();
		this.setPlaca(placa);
		this.setModelo(modelo);
		this.setDataAquisicao(dataAquisicao);
	}

	public void addManutencao(Manutencao m) {
		this.manutencoes.add(m);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		if (placa != null && (placa.length() == 7 || placa.length() == 8)) {
			this.placa = placa;
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public int comparaCom(Veiculo outro) {
		float meuIndice = this.getIndiceSucateamento();
		float outroIndice = outro.getIndiceSucateamento();

		if (meuIndice > outroIndice) {
			return 10;
		} else if (meuIndice == outroIndice) {
			return 0;
		} else {
			return -10;
		}
	}

	public float getIndiceSucateamento() {
		float tempoParado = 0;
		for (Manutencao m : manutencoes) {
			tempoParado += m.getTempoParado();
		}
		if (tempoParado >= 0 && tempoParado <= 20) {
			return 0;
		}
		if (tempoParado >= 21 && tempoParado <= 50) {
			return 0.5f;
		}
		if (tempoParado >= 51 && tempoParado <= 80) {
			return 1.0f;
		}
		if (tempoParado >= 81 && tempoParado <= 120) {
			return 1.5f;
		}
		return 2;
	}

	public float getCustoMedioManutencoes() {
		float soma = 0;
		for (Manutencao m : this.manutencoes) {
			soma += m.getCusto();
		}
		return soma / this.manutencoes.size();
	}

	public int getQuantosServicos(String descricao) {
		int contador = 0;
		for (Manutencao m : this.manutencoes) {
			if (m.getDescricao().equals(descricao)) {
				contador++;
			}
		}
		return contador;
	}
}
