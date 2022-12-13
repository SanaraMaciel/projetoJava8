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
		palavras.add("editora casa do c�digo");
		palavras.add("caelum");

		// m�todo de ordena��o antigo
		Collections.sort(palavras);

		// cria um novo par�metro para a ordena��o da lista antigo
//		Comparator<String> comparador = new ComparadorPorTamanho();
//		Collections.sort(palavras, comparador);
		System.out.println(palavras);

		// novo m�todo dentro da lista para ordena��o
//		palavras.sort(comparador);
		System.out.println(palavras);

		// iterando sobre umna lista com o for antigo
		for (String p : palavras) {
			System.out.println(p);
		}

		// nova forma de fazer uma itera��o com java8
//		Consumer<String> consumidor = new ImprimeNaLinha();
//		palavras.forEach(consumidor);

		// declarando consumer no pr�prio m�todo
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s + " no corpo");
			}
		});

		// m�todo com lambda
		palavras.forEach(s -> System.out.println(s + " no corpo"));

		// passando um Compaartor de String
		palavras.sort(new Comparator<String>() {
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
		});

		// lambda para o sort
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		//consumidor com lambda
		Consumer<String> impressor = s-> System.out.println(s);
		
		//outra forma de escrever com method reference
		Consumer<String> impressorL = System.out::println;
		
		palavras.forEach(impressor); //print normal
		palavras.forEach(impressorL); //print reference

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
}
