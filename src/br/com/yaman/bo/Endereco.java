package br.com.yaman.bo;

public class Endereco {
	String logradouro;
	int numero;
	String complemento;
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String toString(){
		return "\n logradouro: " + this.logradouro + "\n numero: " + this.numero + " complemento: " + this.complemento;
		
	}
}
