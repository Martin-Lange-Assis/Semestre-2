/*Para efetuar o recolhimento do Imposto de Renda a Receita Federal tem o NOME, CPF, UF (RS, 
PR e SC) e RENDA ANUAL de cada contribuinte, durante o ano. 
EX.: Nome: João da Silva CPF: 123.456.789-00 UF: PR RendaAnual: R$40.000
Para o cálculo do imposto a pagar de cada contribuinte, considere o seguinte:
Nível de Renda Anual Alíquota

0 a 4.000 - 0%
4.001 a 9.000 - 5,8%
9.001 a 25.000 - 15%
25.001 a 35.000 - 27,5%
acima de 35.000 - 30%

Sendo assim, deve-se calcular o imposto a pagar do seguinte modo:
Imposto a pagar = Renda Anual * Alíquota
Faça um programa Java orientado a objetos que leia as informações a serem digitadas pela Receita e 
indique o imposto a pagar de cada contribuinte digitado. A qualquer instante o usuário pode consultar 
quais contribuintes têm imposto a pagar acima de um determinado valor (informado pelo usuário a 
cada consulta).*/

package exercicio1Lista1;

public class Contribuinte {
	private String nome;
	private String cpf;
	private String uf;
	private double rendaAnual;

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		if (uf.equals("RS") || uf.equals("SC") || uf.equals("PR")) {
			this.uf = uf;
		}
	}

	public double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(double rendaAnual) {
		if (rendaAnual >= 0) {
			this.rendaAnual = rendaAnual;
		}
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getAliquota() {
		if (this.rendaAnual > 35000) {
			return 0.30; // 30%
		} else if (this.rendaAnual >= 25001) {
			return 0.275; // 27,5%
		} else if (this.rendaAnual >= 9001) {
			return 0.15; // 15%
		} else if (this.rendaAnual >= 4001) {
			return 0.058; // 5,8%
		} else {
			return 0;
		}
	}

	public double calcularImposto() {
		return this.rendaAnual * this.getAliquota();
	}
}
