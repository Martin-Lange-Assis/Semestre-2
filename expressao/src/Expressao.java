// Jonathan Ilchemin Ribeiro
// Martin Lange de Assis

/*Faça uma classe Java que tenha como atributo uma String para conter uma expressão aritmética. 
Esta classe deve chamar-se Expressao e possuir métodos para:
• instanciar o objeto, recebendo a expressão como parâmetro de inicialização: Expressao(String 
exp)
• verificar se a expressão aritmética está correta sintaticamente em relação ao número de 
parênteses utilizados – todos que estão abrindo estão fechando e vice-versa, sem fechar antes 
de abrir: public boolean estaCorretaSintaticamente()
• retornar a quantidade de operadores de divisão utilizados: public int getQtdeDivisores()
• retornar a posição do primeiro operador aritmético da expressão (+, -, *, /). Caso não exista, 
retornar -1 : public int getPosicaoOperador()

Exemplo: (a+10)/(23*(10.5-b)-2.59/(b*a))
Expressao exp = new Expressao(“(a+10)/(23*(10.5-b)-2.59/(b*a))”);
exp.estaCorretaSintaticamente(); → retorna true
exp.getQtdeDivisores(); → retorna 2
exp.getPosicaoOperador() → retorna 2
*/
public class Expressao {
	private String expressao;

	public static void main(String[] args) {
		Expressao exp = new Expressao("(a+10)/(23*(10.5-b)-2.59/(b*a))");
		System.out.println(exp.estaCorretaSintaticamente());
		System.out.println(exp.getQtdeDivisores());
		System.out.println(exp.getPosicaoOperador());
	}

	public Expressao(String expressao) {
		setExpressao(expressao);
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	public boolean estaCorretaSintaticamente() {
		int parenteses1 = 0; // (
		int parenteses2 = 0; // )
		for (int i = 0; i < this.expressao.length(); i++) {
			if (expressao.charAt(i) == '(') {
				parenteses1++;
			} else if (expressao.charAt(i) == ')') {
				parenteses2++;
			}
			if (parenteses2 > parenteses1) {
				return false;
			}
		}
		if (parenteses1 == parenteses2) {
			return true;
		} else {
			return false;
		}
	}

	public int getQtdeDivisores() {
		int qtd = 0;
		for (int i = 0; i < this.expressao.length(); i++) {
			if (expressao.charAt(i) == '/') {
				qtd++;
			}
		}
		return qtd;
	}

	public int getPosicaoOperador() {
		int posicao = -1;
		for (int j = this.expressao.length() - 1; j >= 0; j--) {
			if (expressao.charAt(j) == '+' || expressao.charAt(j) == '-' || expressao.charAt(j) == '*'
					|| expressao.charAt(j) == '/') {
				posicao = j;
			}
		}
		if (posicao == -1) {
			return -1;
		} else {
			return posicao;
		}
	}
}