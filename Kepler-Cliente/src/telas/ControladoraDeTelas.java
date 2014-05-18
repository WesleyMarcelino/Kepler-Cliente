package telas;

import cliente.Cliente;
import objetos.Equipe;

public class ControladoraDeTelas {
	private static TelaInicial telaInicial = new TelaInicial();
	private static TelaDeChat telaDeChat ;
	
	

	public static void mostraTelaInicial(){
		telaInicial.setVisible(true);
	}
	public static void escondeTelaInicial(){
		telaInicial.setVisible(false);
	}
	public static void mostraTelaDeChat(Equipe equipe, Cliente cliente){
		 telaDeChat = new TelaDeChat(equipe, cliente);
		telaDeChat.setVisible(true);
	}
	public static void escondeTelaDeChat(){
		telaDeChat.dispose();
	}
	public static TelaDeChat getTelaDeChat() {
		return telaDeChat;
	}

}
