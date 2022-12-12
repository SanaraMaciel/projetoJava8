package projetoJava8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura online");
		palavras.add("editora casa do código");
		palavras.add("caelum");

		// método de ordenação antigo
		Collections.sort(palavras);

		// cria um novo parâmetro para a ordenação da lista antigo
		Comparator<String> comparador = new ComparadorPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);

		// novo método dentro da lista para ordenação
		palavras.sort(comparador);
		System.out.println(palavras);

		// iterando sobre umna lista com o for antigo
		for (String p : palavras) {
			System.out.println(p);
		}

		// nova forma de fazer uma iteração com java8
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);

	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}

}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return -1;
		}
		if (s1.length() > s2.length()) {
			return 1;
		}
		return 0;
	}

}
