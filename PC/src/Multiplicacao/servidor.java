package Multiplicacao;

import java.net.ServerSocket;
import java.net.Socket;

import Somar.thread;

public class servidor {
	@SuppressWarnings("resource")
	
	public static void main(String [] args) {
		try {
			ServerSocket servidor = new ServerSocket(8000);
			System.out.println("[Multiplicação Server] Ouvindo a porta 8000");
			while(true){
				Socket cliente = servidor.accept();
				thread th = new thread(cliente);
				Thread t = new Thread(th);
				t.start();
			}
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
