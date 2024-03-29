package camara;

import java.util.ArrayList;

public class Vereador {
	private String nome;
	private Partido partido;
	private ArrayList<ProjetoDeLei> projetosLei;
	private int qntProjAprovado;
	private int qntProjApresentados;

	public Vereador(String nome) {
		setNome(nome);	
	}

	public ArrayList<ProjetoDeLei> getProjetosLei() {
		return projetosLei;
	}

	public void setProjetosLei(ArrayList<ProjetoDeLei> projetosLei) {
		this.projetosLei = projetosLei;
	}

	public void addProjetodeLei9(ProjetoDeLei p) {
		projetosLei.add(p);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		} else {
			throw new IllegalArgumentException("Digite um nome.");
		}
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		if (partido != null) {
			this.partido = partido;
			partido.addVereador(this);
		} else {
			throw new IllegalArgumentException("Digite um nome ao partido.");
		}
	}

	public int getQntProjAprovado() {
		return qntProjAprovado;
	}

	public void setQntProjAprovado(int qntProjAprovado) {
		this.qntProjAprovado++;
	}

	public int getQntProjApresentados() {
		return qntProjApresentados;
	}

	public void setQntProjApresentados(int qntProjApresentados) {
		this.qntProjApresentados++;
	}

	public double getIndiceTrabalho() {
		if (qntProjApresentados < 1) {
			return 0;
		} else if (qntProjApresentados > 0 && qntProjApresentados <= 5) {
			return 0.80;
		} else if (qntProjApresentados >= 6 && qntProjApresentados <= 10) {
			return 1;
		} else if (qntProjApresentados >= 11 && qntProjApresentados <= 17) {
			return 1.08;
		} else {
			return 1.22;
		}
	}

	public double getDesempenho() {
		if (getQntProjApresentados() == 0) {
			return 0;
		} else {
			return (qntProjAprovado / qntProjApresentados) * getIndiceTrabalho();
		}
	}
}
