package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import informacoes.Informacoes;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cliente.Cliente;
import objetos.Equipe;
import objetos.Equipes;

public class TelaInicial extends JFrame {
	private JPanel titulo;
	private JLabel textoDoTitulo;
	private Font fonteTextoDoTitulo;
	private JPanel rodape;
	private JTextField textoRodape;
	private Font fonteTextoRodape;
	private JPanel centro;
	private JLabel textoEscolherEquipe;
	private JButton conectar;
	private static Cliente cliente ;	
	private static Equipe equipe;
	


	private JComboBox<Object> selecaoDeEquipes;
	public TelaInicial(){
		BorderLayout layoutTelaInicial = new BorderLayout();
		this.setTitle(Informacoes.getNomedoprograma()+" "+Informacoes.getVersao());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,200);
		this.setResizable(false);
		this.add(Titulo(), layoutTelaInicial.NORTH);
		this.add(Centro(), layoutTelaInicial.CENTER);
		this.add(Rodape(), layoutTelaInicial.SOUTH);
		this.setLocationRelativeTo(null);
		
	}
	 
	private JPanel Titulo(){ 
		fonteTextoDoTitulo = new Font("Calibri", Font.PLAIN, 24);
		titulo = new JPanel();
		textoDoTitulo = new JLabel();
		textoDoTitulo.setFont(fonteTextoDoTitulo);
		textoDoTitulo.setText(Informacoes.getNomedoprograma());
	    titulo.add(textoDoTitulo);
	    return titulo;
	}
	
	
	private JPanel Centro() {
			FlowLayout layoutCentro = new FlowLayout();
			centro = new JPanel();
			textoEscolherEquipe = new JLabel();
			selecaoDeEquipes = new JComboBox<Object>();
			for (int i = 0; i < Equipes.getEquipes().size(); i++){
			selecaoDeEquipes.addItem(Equipes.getEquipes().get(i));
			}		
		
		    textoEscolherEquipe.setText("Entre com sua equipe : ");
			conectar = new JButton();
			conectar.setText("Conectar");
			conectar.addActionListener( new ActionListener() {  
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println("clicou em conectar");
	            	cliente = new Cliente("192.168.0.105",12345, selecaoDeEquipes.getSelectedItem().toString());
	        		equipe = new Equipe("Equipe :"+selecaoDeEquipes.getSelectedItem().toString());
	            	Thread threadDeEnvio = new Thread(cliente);
	        		threadDeEnvio.start();
	        		ControladoraDeTelas.escondeTelaInicial();
	        		ControladoraDeTelas.mostraTelaPrincipal();
	            }
	   }); 
			
			centro.add(textoEscolherEquipe,layoutCentro);
			centro.add(selecaoDeEquipes,layoutCentro);
			centro.add(conectar, layoutCentro);
			return centro;
		}
	
	private JPanel Rodape(){
		rodape = new JPanel();
		textoRodape = new JTextField();
		textoRodape.setText("Desenvolvido por : "+Informacoes.getDesenvolvedores());
		fonteTextoRodape = new Font("Calibri", Font.PLAIN, 12);
		textoRodape.setFont(fonteTextoRodape);
		textoRodape.setEditable(false);
		rodape.add(textoRodape);
		return rodape;
	}
	
	public static void mostrarTelaDeChat(){
		ControladoraDeTelas.mostraTelaDeChat(equipe, cliente);
	}
	
	
	public static Cliente getCliente() {
		return cliente;
	}

	public static void setCliente(Cliente cliente) {
		TelaInicial.cliente = cliente;
	}
	
}
