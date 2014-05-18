package bin;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import cliente.Cliente;
import cliente.Recebedor;
import objetos.Equipe;
import objetos.Equipes;
import telas.TelaInicial;

public class KeplerCliente {
	private static Equipe a = new Equipe("A");
	private static Equipe b = new Equipe("B");
	private static Equipe c = new Equipe("C");
	private static Equipe d = new Equipe("D");
	private static Cliente cliente ;	
	public static void main(String[] args)  {
		cliente = new Cliente("192.168.0.105",12345);
		try {
			cliente.executa();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Equipes.adicionarEquipe(a);
		Equipes.adicionarEquipe(b);
		Equipes.adicionarEquipe(c);
		Equipes.adicionarEquipe(d);
		System.out.println(Equipes.getEquipes());
		TelaInicial t = new TelaInicial();
	   }

	 
		
		}
	


