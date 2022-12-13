/*Uma empresa de promoções culturais recebe diferentes tipos de obras para que sejam lançadas no mercado. 
Antes de realizar um lançamento, cada obra é avaliada por até três pessoas especializadas (pareceristas). 
Para controlar as obras submetidas à avaliação, está sendo desenvolvido um sistema com a seguinte 
estrutura de classes:

✓ A classe Parecer é parte da classe Obra (agregação).
✓ Deve ser possível cadastrar várias obras.

Exemplos de Obras:

Título: A escalada do terror
Autor:Fernandinho 
Beira-mar
Pareceres:
 
	Parecerista: João de Abreu
	 Data: 10/10/2018
	 Conteúdo:  Livro que não pode ser publicado, pois 
é um manual do crime.
 
	Paula Prantos 
	01/09/2018 
	A violência é mostrada de forma cruel. 
	Livro sujeito à censura prévia.
	
Confins do Sertão: Hector Babenco

	Parecerista: Lima Duarte
	Data: 15/08/2018
	Conteúdo:  Vídeo que demonstra a sensibilidade 
	da alma nordestina. Vale a pena 
	assistir.
	 
	
Escreva um programa Java orientado a objetos que leia os dados disponíveis pela empresa. A qualquer 
momento o usuário pode consultar uma obra, através do título, imprimindo seus dados em tela (inclusive dos 
pareceres)*/

package obra;

public class Obra {
	private String titulo;
	private String autor;
	private Parecer[] pareceres = new Parecer[3];
	private int indice;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Parecer getPareceres(int pos) {
		return pareceres[pos];
	}

	public void addParecer(Parecer p) {
		if (indice < pareceres.length) {
			pareceres[indice] = p;
			indice++;
		}
	}

	public void setPareceres(Parecer[] pareceres) {
		this.pareceres = pareceres;
	}

	public int getIndice() {
		return indice;
	}
}
