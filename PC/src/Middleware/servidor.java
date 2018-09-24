package Middleware;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
	public static void main(String [] args) {
		//ipSoma = "10.180.15.91";
		//ipMultiplicacao = "10.180.84.145";
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.print("Ip do Servidor de Soma: ");
		ipSoma = reader.nextLine();
		System.out.print("Ip do Servidor de Multiplicação: ");
		ipMultiplicacao = reader.nextLine();
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
