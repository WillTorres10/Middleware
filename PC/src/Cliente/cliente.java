package Cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import Compartilhado.comando;

public class cliente {
	
	public static void main() {
		
		String ipMiddleware = null;
		
		comando com = new comando(10,2,1);
		try {
			@SuppressWarnings("resource")
			Socket socket = new Socket(ipMiddleware,8000);
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			oos.writeObject(com);
			int result = (int) ois.readObject();
			oos.close();
			ois.close();
			os.close();
			is.close();
			socket.close();
			System.out.println("O valor da Operação deu: "+result);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
