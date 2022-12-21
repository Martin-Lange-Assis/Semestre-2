package exercicio01;

public class Veiculo {
	private String placa;
	private String modelo;
	private int ano;
	private String proprietario;

	public Veiculo(String placa, String modelo, int ano, String proprietario) {
		super();
		this.setPlaca(placa);
		this.setModelo(modelo);
		this.setAno(ano);
		this.setProprietario(proprietario);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		if (placa != null && !placa.isBlank()) {
			this.placa = placa;
		} else {
			throw new IllegalArgumentException("Digite uma placa");
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo != null && !placa.isBlank()) {
			this.modelo = modelo;
		} else {
			throw new IllegalArgumentException("Digite um modelo");
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		if (ano >= 1885) {
			this.ano = ano;
		} else {
			throw new IllegalArgumentException("Digiteum ano válido");
		}
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		if (proprietario != null && !proprietario.isBlank()) {
			this.proprietario = proprietario;
		} else {
			throw new IllegalArgumentException("Digite o nome do proprietário");
		}
	}

	@Override
	public String toString() {
		return "Veiculo<" + this.getModelo() + ">, placa<" + this.getPlaca() + ">, ano<" + this.getAno()
				+ ">, de <" + this.getProprietario() + ">";
	}

}
