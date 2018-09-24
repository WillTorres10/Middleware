package Compartilhado;

import java.io.Serializable;

public class comando implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int A, B, Operacao, result;
	
	public comando(int A, int B, int Operacao) {
		this.A = A;
		this.B = B;
		this.Operacao = Operacao;
	}
}
