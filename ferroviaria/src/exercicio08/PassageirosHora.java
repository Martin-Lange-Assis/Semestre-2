/*Você está trabalhando em um projeto de automação de uma estação ferroviária. Uma das classes 
identificadas é PassageirosHora, que foi definida como sendo uma matriz tridimensional de 
inteiros que em cada posição guarda a quantidade de passageiros transportados por hora, de 
determinado dia, de determinado mês. Assim a matriz é de ordem 12 meses x 30 dias x 24 horas. 
Crie esta classe, que deve ter as seguintes funcionalidades:

Funcionalidade 								Código de teste
											PassageirosHora ph = new PassageirosHora();
a) adicione mais um passageiro em 
determinada hora; 							ph.adiciona(1,1,13); // 13 h de 1o de Janeiro
b) retorne a quantidade de passageiros 
transportados em determinado dia; 			int qtde = ph.quantosPassageiros(25,12); //Natal
c) retorne o mês em que houve o menor fluxo 
de passageiros. 							int mês = ph.mesMenorFluxo();
d) retorne o dia, mês e hora em que houve a 
maior quantidade transportada de 
passageiros;
											int[ ] momento = ph.picoTransporte();*/

package exercicio08;

public class PassageirosHora {

	private int[][][] matriz = new int[12][30][24];

	// item a
	public void adiciona(int dia, int mes, int hora) {
		this.matriz[mes - 1][dia - 1][hora]++;
	}

	// item b
	public int quantosPassageiros(int dia, int mes) {
		int total = 0;
		for (int h = 0; h < this.matriz[mes][dia].length - 1; h++) {
			total += matriz[mes][dia][h];
		}
		return total;
	}

	// item c
	public int mesMenorFluxo() {
		int mesMenor = 1;
		int qtdeMenor = this.quantosPassageiros(1);
		for (int mes = 2; mes < matriz[mes].length; mes++) {
			int qtde = this.quantosPassageiros(mes);
			if (qtde < qtdeMenor) {
				qtdeMenor = qtde;
				mesMenor = mes;
			}
		}
		return mesMenor;
	}

	public int quantosPassageiros(int mes) {
		int total = 0;
		for (int dia = 1; dia < this.matriz[mes].length; dia++) {
			total += this.quantosPassageiros(dia, mes);
		}
		return total;
	}

	// item d
	public int[] picoTransporte() {
		int diaM, mesM, horaM, qtdeM;
		diaM = mesM = horaM = qtdeM = 0;
		for (int m = 0; m < matriz.length; m++) {
			for (int d = 0; d < matriz.length; d++) {
				for (int h = 0; h < matriz.length; h++) {
					if (matriz[m][d][h] > qtdeM) {
						qtdeM = matriz[m][d][h];
						mesM = m + 1;
						diaM = d + 1;
						horaM = h + 1;

					}
				}
			}
		}
		int[] retorno = { diaM, mesM, horaM, qtdeM };
		return retorno;
	}
}