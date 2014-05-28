package cliente;

import java.io.IOException;
import java.util.Scanner;

public class Enviador {
	private static Cliente cliente;

	public Enviador(Cliente cliente) {
		cliente = cliente;
	}

	public static void enviaMensagem(String mensagem) throws IOException {
		System.out
				.println("to no run do cliente - mais precisamente em enviar mensagem");
		cliente.enviaMensagem(mensagem);

	}

}
