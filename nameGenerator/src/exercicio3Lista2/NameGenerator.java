package exercicio3Lista2;

public class NameGenerator {
	// contribuição do Felipe
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