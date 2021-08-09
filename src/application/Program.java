package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		String path = "C:\\Users\\Alexandre\\Desktop\\JAVA_UDEMY\\exercicioArquivo\\produtos.txt";
		List<Product> list= new ArrayList<>(); 
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] vect = line.split(",");
				// System.out.println(line);
				String name = vect[0];
				Double preco = Double.parseDouble(vect[1]);
				Integer qtd = Integer.parseInt(vect[2]);
				list.add( new Product(name, preco, qtd));
				line = br.readLine();
				for (String l : vect) {
					System.out.println(l);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
