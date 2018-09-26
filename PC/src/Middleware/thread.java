package Middleware;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import Compartilhado.comando;
import Middleware.middleServer;
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
		//Systemout.println("[Middleware Thread] IP: " + ipCliente + " | Conectado");
		middleServer m = new middleServer();
		m.sta2 = ("[Middleware Thread] IP: " + ipCliente + " | Conectado");
		try {
			OutputStream os = cliente.getOutputStream();
			InputStream is = cliente.getInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			//
			comando com = (comando)ois.readObject();
			//-
			Socket operacao = null;
			if(com.Operacao == 1) {
				m.sta = ("[Middleware Thread] Somando");
				System.out.println("[Middleware Thread] Somando");
				operacao = new Socket(ipSoma,8001);
			}
			else if(com.Operacao == 2) {
				System.out.println("[Middleware Thread] Multiplicando");
				m.sta = ("[Middleware Thread] Multiplicando");
				operacao = new Socket(ipMultiplicacao,8001);
			}else {
				System.out.println("[Middleware Thread] Operação não reconhecida");
				m.sta = ("[Middleware Thread] Operação não reconhecida");
			}
			//+++
			OutputStream osOperacao = operacao.getOutputStream();
			InputStream isOperacao = operacao.getInputStream();
			ObjectOutputStream oosOperacao = new ObjectOutputStream(osOperacao);
			ObjectInputStream oisOperacao = new ObjectInputStream(isOperacao);
			//**
			oosOperacao.writeObject(com);
			com = (comando)oisOperacao.readObject();
			//**
			oisOperacao.close();
			oosOperacao.close();
			isOperacao.close();
			osOperacao.close();
			operacao.close();
			//+++
			//-
			oos.writeObject(com);
			//
			ois.close();
			oos.close();
			is.close();
			os.close();
			cliente.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.currentThread().interrupt();
	}
}
