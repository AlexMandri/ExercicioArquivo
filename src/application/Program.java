package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		String path = "C:\\Users\\Alexandre\\Desktop\\JAVA_UDEMY\\exercicioArquivo\\vendas.csv";
		List<Product> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] vect = line.split(",");
				// System.out.println(line);
				String name = vect[0];
				Double preco = Double.parseDouble(vect[1]);
				Integer qtd = Integer.parseInt(vect[2].trim());
				list.add(new Product(name, preco, qtd));
				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean success = new File("C:\\Users\\Alexandre\\Desktop\\JAVA_UDEMY\\exercicioArquivo" + "\\out").mkdir();
		String saida = "C:\\Users\\Alexandre\\Desktop\\JAVA_UDEMY\\exercicioArquivo\\out\\summary.csv";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(saida))) {
			for (Product p : list) {
				bw.write(p.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String output= "C:\\Users\\Alexandre\\Desktop\\JAVA_UDEMY\\exercicioArquivo\\out\\summary.csv";
		try (BufferedReader ot = new BufferedReader(new FileReader(output))) {
			String line = ot.readLine();
			while (line != null) {
				System.out.println(line);
				line = ot.readLine();
			}
		}
		catch(IOException e ) {
			e.printStackTrace();
		}
		
	}
}
