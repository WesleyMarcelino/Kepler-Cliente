package cliente;

import informacoes.Erros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Cliente implements Runnable {
	private String host;
	private int porta;
	private String equipe;
	private Enviador enviador;
	private Recebedor recebedor;
	private static Socket cliente;

	public Cliente(String host, int porta, String equipe) {
		this.host = host;
		this.porta = porta;
		this.equipe = equipe;
	}

	public void iniciaCliente() throws UnknownHostException, IOException {

		try {
			cliente = new Socket(this.host, this.porta);
		} catch (java.net.ConnectException servidorDown) {
			JOptionPane.showMessageDialog(null, Erros.getErro01rede(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		enviaMensagem(equipe);
		System.out.println("O cliente se conectou ao servidor!");
		// thread para receber mensagens do servidor
		RecebedorDeArquivos ra = new RecebedorDeArquivos(
				cliente.getInputStream());
		Recebedor r = new Recebedor(cliente.getInputStream());
		new Thread(r).start();

	}

	public static void enviaMensagem(String mensagem) throws IOException {
		System.out.println("mensagem a ser enviada :>" + mensagem);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		saida.println(mensagem);
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	public void run() {
		try {
			iniciaCliente();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
