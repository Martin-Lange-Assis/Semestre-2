package exercicio01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio01 {
	public static void main(String[] args) throws IOException {
		try {
			FileWriter fw = new FileWriter("exercicio01Text.txt");
			fw.write("12345");
			fw.close();
			FileOutputStream fos = new FileOutputStream("exercicio01Binario.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(12345);
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileReader fr = new FileReader("exercicio01Text.txt")) {
			BufferedReader bf = new BufferedReader(fr);
			String s = bf.readLine();
			System.out.println("Lendo texto com texto = " + s);
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fis = new FileInputStream("exercicio01Binario.txt")) {
			DataInputStream dis = new DataInputStream(fis);
			int valor = dis.readInt();
			System.out.println("Lendo binario com binario = " + valor);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
