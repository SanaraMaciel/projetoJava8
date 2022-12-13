package projetoJava8;

public class ThreadComLambda {

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Executando um Runnable");
			}

		}).start();

		// thread com lambda
		new Thread(() -> System.out.println("Executando um Runnable lambda")).start();
	}

}
