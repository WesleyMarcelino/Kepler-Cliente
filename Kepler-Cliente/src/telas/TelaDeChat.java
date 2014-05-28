package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cliente.Cliente;
import objetos.Equipe;

public class TelaDeChat extends JFrame implements Runnable {
	private static long idTelaDechat;
	private static JPanel campoDeMensagem;
	private static JButton botaoEnviarMensagem;
	private static JTextField escritaDeMensagem;
	private static JPanel campoDeConversa;
	private JPanel atualizaCampoDeConversa;
	private static JTextArea conversas = new JTextArea();
	// private JTextField envioPeloServidor;
	// private JTextField recebidoPeloServidor;
	private String origem;
	private String mensagem;
	private static Equipe equipe;
	private static String mensagemDoServidor = null;
	private static Cliente cliente;

	public TelaDeChat(Equipe equipe, Cliente cliente) {
		TelaDeChat.equipe = equipe;
		this.setTitle("CHAT COM A SECRETARIA ");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.add(campoDeConversa(), BorderLayout.CENTER);
		this.add(CampoDeMensagem(), BorderLayout.SOUTH);
		this.setSize(800, 600);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
	}

	public static JPanel CampoDeMensagem() {
		FlowLayout layoutCampoDeMensagem = new FlowLayout();
		campoDeMensagem = new JPanel();
		campoDeMensagem.setLayout(layoutCampoDeMensagem);
		escritaDeMensagem = new JTextField(60);
		escritaDeMensagem.setText("Digite aqui sua mensagem");
		botaoEnviarMensagem = new JButton();
		botaoEnviarMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					enviaMensagemGrafica(escritaDeMensagem.getText().toString());
				} catch (IOException e1) {
					System.out.println("erro ainda no botão enviar");
					e1.printStackTrace();
				}
				atualizaCampoDeConversa("cliente", escritaDeMensagem.getText());
				campoDeConversa.repaint();
				escritaDeMensagem.setText("");
			}
		});
		botaoEnviarMensagem.setText("Enviar");
		campoDeMensagem.add(escritaDeMensagem);
		campoDeMensagem.add(botaoEnviarMensagem);
		return campoDeMensagem;
	}

	public JPanel campoDeConversa() {
		campoDeConversa = new JPanel();
		conversas.setEditable(false);
		campoDeConversa.add(conversas);
		return campoDeConversa;
	}

	public static JPanel atualizaCampoDeConversa(String origem, String mensagem) {
		String conversasAnteriores = conversas.getText();
		if (origem.equals("servidor")) {
			conversas.setText(conversasAnteriores + "Secretaria : " + mensagem
					+ "\n");
			return null;
		} else if (origem.equals("cliente")) {
			conversas.setText(conversasAnteriores + equipe.getNome() + " : "
					+ mensagem + "\n");
			return null;
		}
		return null;
	}

	public static void enviaMensagemGrafica(String mensagem) throws IOException {
		System.out.println("mensagem " + mensagem);
		Cliente.enviaMensagem(mensagem);
	}

	public void run() {
		// KeplerSrv.getS().esperaMensagem();
	}

	public static String getMensagemDoServidor() {
		System.out.println("dentro do get " + TelaDeChat.mensagemDoServidor);
		return TelaDeChat.mensagemDoServidor;
	}

	public static void setMensagemDoServidor(String mensagemDoCliente) {
		TelaDeChat.mensagemDoServidor = mensagemDoCliente;
		System.out.println("dentro do set " + TelaDeChat.mensagemDoServidor);
		atualizaCampoDeConversa("servidor", TelaDeChat.mensagemDoServidor);
		campoDeConversa.repaint();

	}
}
