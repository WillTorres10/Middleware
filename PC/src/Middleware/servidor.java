package Middleware;

import java.net.ServerSocket;
import java.net.Socket;
import Middleware.thread;

public class servidor {
	
	private static String ipSoma; 
	private static String ipMultiplicacao;
	
	/*
	 * Essa função será o servidor do middleware.
	 * A função main será apenas para esperar chamadas no socket, quando
	 * houver uma chamada ele criará uma thread que fará as operações
	 * */
	
	@SuppressWarnings("resource")
	public static void main() {
		try {
			ServerSocket servidor = new ServerSocket(8000);
			System.out.println("[Middleware Server] Ouvindo a porta 8000");
			while(true){
				Socket cliente = servidor.accept();
				thread th = new thread(cliente, ipSoma, ipMultiplicacao);
				Thread t = new Thread(th);
				t.start();
			}
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
