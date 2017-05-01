package br.com.yaman.bo;

public class ContaPoupanca extends Conta {

	@Override
	public void depositarValor(double valor) {
		double valorPoup;
		valorPoup = (this.getSaldo() + valor) * 1.02 ;
		this.setSaldo(valorPoup);
		
	}


}
