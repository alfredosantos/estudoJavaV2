package br.com.yaman.bo;
public abstract class Conta {
	int numero;
	int agencia;
	double saldo;
	double limite;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public void depositarValor(double valor) {
		double valorNovo;
		valorNovo = this.getSaldo() + valor;
		this.setSaldo(valorNovo);
		
	}
	
	public Double saque(double valor) throws Exception{
		double saque;
		if (getSaldo() + getLimite() >= valor){
			saque = getSaldo() - valor;
			setSaldo(saque);
			return getSaldo() + getLimite();
		}
		throw new Exception("Saldo insuficiente");
	}
	
	public String toString(){
		return "\n Numero: " + this.numero + " Agencia: " + this.agencia + " Saldo: " + this.saldo;
	}

}
