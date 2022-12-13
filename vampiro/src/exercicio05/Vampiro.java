/*A vampire number has an even number of digits and is formed by multiplying a pair of numbers 
containing half the number of digits of the result. The digits are taken from the original number in 
any order. Pairs of trailing zeroes are not allowed. Examples include:

1260 = 21 * 60
1827 = 21 * 87
2187 = 27 * 81

Write a program that finds all the 4-digit vampire numbers.
Vampire numbers first appeared in a 1994 post by Clifford A. Pickover to the Usenet group sci.math, 
and the article he later wrote was published in chapter 30 of his book Keys to Infinity.*/

package exercicio05;

public class Vampiro {
	private int numVampiro = 0;
	private int numero1 = 0;
	private int numero2 = 0;

	public int getNumVampiro() {
		return numVampiro;
	}

	public void setNumVampiro(int nv) {
		this.numVampiro = nv;
	}

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(int n1) {
		this.numero1 = n1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(int n2) {
		this.numero2 = n2;
	}

	public int Calcular(int e1, int e2, int e3, int e4) { // e = elemento que compõem o número
		int t1; // t = termo, no caso ao ser dividido em duas partes
		int t2;
		t1 = e1 * 10 + e2;
		t2 = e3 * 10 + e4;
		return t1 * t2;
	}

	public boolean numeroVampiro(int numeroVampiro) {
		int resultado = 0;
		int t1, t2, t3, t4;
		int e1, e2;
		e1 = numeroVampiro / 100;
		e2 = numeroVampiro % 100;
		t1 = e1 / 10;
		t2 = e1 % 10;
		t3 = e2 / 10;
		t4 = e2 % 10;

		resultado = Calcular(t1, t2, t3, t4);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t1, t2, t4, t3);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t2, t1, t3, t4);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t2, t1, t4, t3);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t1, t3, t2, t4);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t1, t3, t4, t2);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t3, t1, t2, t4);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t3, t1, t4, t2);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}

		resultado = Calcular(t1, t4, t2, t3);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t1, t4, t3, t2);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t4, t1, t2, t3);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		resultado = Calcular(t4, t1, t3, t2);
		if (resultado == numeroVampiro) {
			setNumVampiro(numeroVampiro);
			return true;
		}
		return false;
	}

}