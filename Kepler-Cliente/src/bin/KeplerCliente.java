package bin;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import cliente.Cliente;
import cliente.Recebedor;
import db.IndustriaTxt;
import objetos.Equipe;
import objetos.Equipes;
import telas.ControladoraDeTelas;
import telas.TelaInicial;

public class KeplerCliente {
	private static Equipe a = new Equipe("A");
	private static Equipe b = new Equipe("B");
	private static Equipe c = new Equipe("C");
	private static Equipe d = new Equipe("D");

	public static void main(String[] args) {

		Equipes.adicionarEquipe(a);
		Equipes.adicionarEquipe(b);
		Equipes.adicionarEquipe(c);
		Equipes.adicionarEquipe(d);
		System.out.println(Equipes.getEquipes());
		ControladoraDeTelas.mostraTelaInicial();
	}

}
