package Multiplicacao;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import Compartilhado.comando;

public class thread extends Thread{
	private Socket cliente;
	
	public thread(Socket cliente) {
		this.cliente = cliente;
	}
	
	public void run(){
		String ipCliente = cliente.getInetAddress().getHostAddress();
		System.out.println("[Multiplicação Thread] IP: " + ipCliente + " | Conectado");
		try {
			OutputStream os = cliente.getOutputStream();
			InputStream is = cliente.getInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			//-
			comando com = (comando)ois.readObject();
			com.result = com.A * com.B;
			oos.writeObject(com);
			//-
			ois.close();
			oos.close();
			is.close();
			os.close();
		} catch (Exception e) {
			//System.out.println("[Multiplicação Thread] IP: " + ipCliente + " | Desconectado");
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		Thread.currentThread().interrupt();
	}
}
