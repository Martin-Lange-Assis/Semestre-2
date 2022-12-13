/*Há um rumor que circula na internet informando que George Lucas (o criador da série Star Wars) 
utiliza uma fórmula para criar os nomes para os personagens em suas histórias (Jar Jar Binks, 
ObiWan Kenobi etc). A fórmula, supostamente, é:

Seu primeiro nome na série Star Wars:
i. Pegue as três primeiras letras de seu sobrenome
ii. Adicione a ele as duas primeiras letras de seu nome
Seu sobrenome na série Star Wars:
i. Pegue as duas primeiras letras do sobrenome de solteira de sua mãe
ii. Adicione a ele as três primeiras letras do nome da cidade onde você nasceu
E agora sua missão: crie uma classe chamada NameGenerator. Esta classe deve ter um método 
chamado generateStarWarsName que gera um nome completo Star Wars conforme explicado e cuja 
assinatura é public static String generateStarWarsName(String[] entrada). 
O retorno é a String gerada e o parâmetro de entrada é um vetor de String contendo na primeira 
posição seu nome completo, na segunda posição o nome de solteira de sua mãe e na terceira posição o 
nome da cidade onde você nasceu. Investigue a classe String para auxiliá-lo.

Exemplo:
entrada[0] = “João Aparecido da Silva” saída gerada → Siljo Doblu
entrada[1] = “Dores”
entrada[2] = “Blumenau”
*/
package exercicio03Lista2;

public class NameGenerator {
	public static String generateStarWarsName(String[] entrada) {
		String nome = "";
		String primeiraletranome = "";
		String restonome = "";
		String sobrenome = "";
		String sobrenomecidade = "";
		String[] nomes = entrada[0].split(" ");
		String nomeultimo = nomes[nomes.length - 1];

		primeiraletranome += nomeultimo.charAt(0);
		primeiraletranome = primeiraletranome.toUpperCase();

		restonome += "" + nomeultimo.charAt(1) + nomeultimo.charAt(2) + entrada[0].charAt(0) + entrada[0].charAt(1);
		restonome = restonome.toLowerCase();

		nome = primeiraletranome + restonome;

		sobrenome += "" + entrada[1].charAt(0) + entrada[1].charAt(1);
		sobrenomecidade += "" + entrada[2].charAt(0) + entrada[2].charAt(1) + entrada[2].charAt(2);
		sobrenomecidade = sobrenomecidade.toLowerCase();
		sobrenome += sobrenomecidade;

		return nome + " " + sobrenome;
	}

}