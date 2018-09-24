package Cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import Compartilhado.comando;

public class main {
	
	
	@SuppressWarnings("resource")
	public static void main(String []args) {
		
		String ipMiddleware = null;
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.print("Ip do Middleware: ");
		ipMiddleware = reader.nextLine();
		
		comando com = new comando(8,2,2);
		
		try {
			Socket socket = new Socket(ipMiddleware,8000);
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			//
			oos.writeObject(com);
			System.out.println("Enviou");
			com = (comando)ois.readObject();
			System.out.println("Recebeu");
			//
			ois.close();
			oos.close();
			is.close();
			os.close();
			socket.close();
			System.out.println("O valor da Operação deu: "+com.result);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
