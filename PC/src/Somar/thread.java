package Somar;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import Compartilhado.comando;

public class thread extends Thread {
	private Socket cliente;
	
	public thread(Socket cliente) {
		this.cliente = cliente;
	}
	
	public void run(){
		String ipCliente = cliente.getInetAddress().getHostAddress();
		System.out.println("[Soma Thread] IP: " + ipCliente + " | Conectado");
		try {
			InputStream is = this.cliente.getInputStream();
			OutputStream os = this.cliente.getOutputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			comando coman = (comando)ois.readObject();
			int result = coman.A + coman.B;
			oos.writeObject(result);
			oos.close();
			ois.close();
			os.close();
			is.close();
			this.cliente.close();
			
		} catch (IOException e) {
			//System.out.println("[Soma Thread] IP: " + ipCliente + " | Desconectado");
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} catch (ClassNotFoundException e) {
			//System.out.println("[Soma Thread] IP: " + ipCliente + " | Desconectado");
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		Thread.currentThread().interrupt();
	}
	
}
