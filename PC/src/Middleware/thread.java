package Middleware;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import Compartilhado.comando;

public class thread extends Thread{
	private Socket cliente;
	private String ipSoma, ipMultiplicacao;
	
	public thread(Socket cliente, String ipSoma, String ipMulti) {
		this.cliente = cliente;
		this.ipSoma = ipSoma;
		this.ipMultiplicacao = ipMulti;
	}
	

	/*
	 * Ao ser iniciada, a Thread receberá o objeto contendo os comandos para serem
	 * realizados.
	 * 
	 * Operação == 1, a operação é de soma
	 * Operação == 2, a operação é de multiplicação
	 * 
	 * */
	
	@SuppressWarnings("resource")
	public void run() {
		String ipCliente = cliente.getInetAddress().getHostAddress();
		System.out.println("[Middleware Thread] IP: " + ipCliente + " | Conectado");
		try {
			InputStream is = this.cliente.getInputStream();
			OutputStream os = this.cliente.getOutputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			comando coman = (comando)ois.readObject();
			Socket socketOperacao = null;
			if(coman.Operacao == 1) {
				socketOperacao = new Socket(this.ipSoma, 8000);
			}
			else {
				socketOperacao = new Socket(this.ipMultiplicacao, 8000);
			}
			
			try {
				InputStream isOperacao = socketOperacao.getInputStream();
				OutputStream osOperacao = socketOperacao.getOutputStream();
				ObjectInputStream oisOperacao = new ObjectInputStream(isOperacao);
				ObjectOutputStream oosOperacao = new ObjectOutputStream(osOperacao);
				oosOperacao.writeObject(coman);
				int result = (int)oisOperacao.readObject();
				oos.writeObject(result);
				oosOperacao.close();
				oisOperacao.close();
				osOperacao.close();
				isOperacao.close();
				oos.close();
				ois.close();
				os.close();
				is.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			//System.out.println("[Middleware Thread] IP: " + ipCliente + " | Desconectado");
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} catch (ClassNotFoundException e) {
			//System.out.println("[Middleware Thread] IP: " + ipCliente + " | Desconectado");
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		Thread.currentThread().interrupt();
	}
}
