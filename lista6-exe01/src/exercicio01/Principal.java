package exercicio01;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class Principal {
	public static void main(String[] args) {
		LinkedList<Veiculo> veiculos = new LinkedList<>();
		Veiculo v1 = new Veiculo("123", "Celta Azul", 2022, "Dorivaldo");
		veiculos.add(v1);
		Veiculo v2 = new Veiculo("1234", "Uno", 2021, "Daniel");
		veiculos.add(v2);
		Veiculo v3 = new Veiculo("1235", "Uno", 2021, "Gustavo");
		veiculos.add(v3);
		Veiculo v4 = new Veiculo("1236", "Monza", 2022, "Gabriel");
		veiculos.add(v4);
		Veiculo v5 = new Veiculo("1237", "Marea", 2022, "Luiz");
		veiculos.add(v5);
		Veiculo v6 = new Veiculo("1238", "Chevette", 2022, "Marcel");
		veiculos.add(v6);
		Veiculo v7 = new Veiculo("1239", "Fusca", 2022, "Julio");
		veiculos.add(v7);
		Veiculo v8 = new Veiculo("1230", "Gol Bola", 2022, "Michael Jackson");
		veiculos.add(v8);
		Veiculo v9 = new Veiculo("12311", "Palio", 2022, "Camaleao");
		veiculos.add(v9);
		Veiculo v10 = new Veiculo("12312", "Corsa", 2022, "Luva de Pedreiro");
		veiculos.add(v10);

		System.out.println("Após as inclusões");
		System.out.println(veiculos);

		veiculos.remove(v8); // deleta pelo objeto
		veiculos.remove(6); // deleta a posição do elemento, no caso, a sétima posição
		System.out.println(veiculos);

		ListIterator<Veiculo> lista = veiculos.listIterator(veiculos.size() - 2);
		Veiculo v = lista.previous();
		lista.remove(); // deleta pelo iterador
		System.out.println(veiculos);

		System.out.println("\nApós as exclusões");
		System.out.println(veiculos);
		System.out.println("\nBagunçando a lista...");
		Collections.shuffle(veiculos);
		System.out.println(veiculos);

		System.out.println("\nOrdenando por ano e placa");
		Collections.shuffle(veiculos);
		ComparaAnoPlaca comparador = new ComparaAnoPlaca();
		Collections.sort(veiculos, comparador);
		System.out.println(veiculos);
		
		System.out.println("\nOrdenando por modelo, ano e placa");
		Collections.shuffle(veiculos);
		ComparaModeloAnoPlaca comparadorModelo = new ComparaModeloAnoPlaca();
		Collections.sort(veiculos, comparadorModelo);
		System.out.println(veiculos);
	}
}
