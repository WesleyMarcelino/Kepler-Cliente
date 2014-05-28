package cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import db.IndustriaTxt;
import telas.ControladoraDeTelas;
import telas.TelaDeChat;
import telas.TelaInicial;

public class RecebedorDeArquivos {
	FileOutputStream fos = null;
	private InputStream cliente;

	public void run() {

	}

	public RecebedorDeArquivos(InputStream cliente) throws IOException {
		this.cliente = cliente;
		try {
			fos = new FileOutputStream(new File("industrias.txt"));
			// Prepara variaveis para transferencia
			byte[] cbuffer = new byte[4096];
			int bytesRead = -1;

			// Copia conteudo do canal

			long startTime = System.currentTimeMillis();
			while ((bytesRead = cliente.read(cbuffer)) != -1) {

				fos.write(cbuffer, 0, bytesRead);
				fos.flush();
				if ((false || (System.currentTimeMillis() - startTime) < 4000))
				// teve que ser feito para não precisar fechar o socket.
				{
					
					System.out.println("tempo limite");
					break;

				}
			}
			IndustriaTxt.lerIndustriaTxt(0);// lendo a lista toda
			System.out.println("Arquivo recebido!");
			ControladoraDeTelas.escondeTelaInicial();
			ControladoraDeTelas.mostraTelaPrincipal();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
