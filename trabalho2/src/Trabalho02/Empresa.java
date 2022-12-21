package Trabalho02;

import java.util.HashMap;

public class Empresa {
	private HashMap<String, Telefone> telefones = new HashMap<>();

	public void addTelefone(Telefone t) {
		if (telefones.containsKey(t.getNumero())) {
			telefones.put(t.getNumero(), t);
		}
	}

	public float getFaturamento() {
		float cont = 0;
		for (Telefone telefone : telefones.values()) {
			cont += telefone.getValorMensal();
		}
		return cont;
	}
}
