package exercicio03Lista2;

public class Principal {

	public static void main(String[] args) {
		String[] exemplo = new String[3];
		exemplo[0] = "Martin Lange de Assis";
		exemplo[1] = "Lange";
		exemplo[2] = "Blumenau";

		System.out.println(NameGenerator.generateStarWarsName(exemplo));
	}
}