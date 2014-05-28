package cliente;

import java.io.InputStream;
import java.util.Scanner;

import telas.ControladoraDeTelas;
import telas.TelaDeChat;
import telas.TelaInicial;

public class Recebedor implements Runnable {

	private InputStream cliente;
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void run() {
		// recebe msgs do servidor e imprime na tela
		Scanner s = new Scanner(this.cliente);
		System.out.println("RUN DE RECEBER MENSAGEM ");
		while (s.hasNextLine()) {
			mensagem = s.nextLine();
			System.out.println("Recebi >:" + mensagem);
			if (ControladoraDeTelas.getTelaDeChat() == null) {
				System.out.println("tela não iniciada");
				TelaInicial.mostrarTelaDeChat();
				TelaDeChat.setMensagemDoServidor(mensagem);

			} else if (ControladoraDeTelas.getTelaDeChat().isVisible() == false) {
				System.out.println("tela não visivel");
				TelaInicial.mostrarTelaDeChat();
				TelaDeChat.setMensagemDoServidor(mensagem);

			}
			TelaDeChat.setMensagemDoServidor(mensagem);
			System.out.println("mensagem da tela"
					+ TelaDeChat.getMensagemDoServidor());
		}
		s.close();
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Recebedor(InputStream cliente) {
		this.cliente = cliente;
	}
}