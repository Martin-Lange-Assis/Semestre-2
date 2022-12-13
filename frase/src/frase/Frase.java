/*Dada uma frase por meio da interface gráfica com o usuário, faça um programa Java que imprima a 
frase e cada palavra da frase juntamente com o número de caracteres da palavra. Cada palavra da 
frase é separada por no mínimo um espaço em branco. Para apresentar o resultado, utilize o
componente JTextArea.

Ex.: ISTO É UM TESTE
ISTO - 4
É - 1
UM - 2
TESTE - 5
*/
package frase;

public class Frase {
	private String texto;

	public Frase(String texto) {
		super();
		this.texto = texto;
	}

	public String[] decompor() {
		return this.texto.split(" ");
	}

}
