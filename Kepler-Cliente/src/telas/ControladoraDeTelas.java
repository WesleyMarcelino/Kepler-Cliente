package telas;

import cliente.Cliente;
import objetos.Equipe;

public class ControladoraDeTelas {
	private static TelaInicial telaInicial = new TelaInicial();
	private static TelaDeChat telaDeChat;
	private static TelaPrincipal telaPrincipal;

	public static void mostraTelaInicial() {
		telaInicial.setVisible(true);
	}

	public static void escondeTelaInicial() {
		telaInicial.setVisible(false);
	}

	public static void mostraTelaDeChat(Equipe equipe, Cliente cliente) {
		telaDeChat = new TelaDeChat(equipe, cliente);
		telaDeChat.setVisible(true);
	}

	public static void escondeTelaDeChat() {
		telaDeChat.dispose();
	}

	public static TelaDeChat getTelaDeChat() {
		return telaDeChat;
	}

	public static void mostraTelaPrincipal() {
		telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
	}

	public static void escondeTelaPrincipal() {
		telaPrincipal.setVisible(false);
	}

}
