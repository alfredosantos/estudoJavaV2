package br.com.yaman.bo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Agencia {
	
	HashMap<Pessoa, List<Conta>> mapaPessoaConta = new HashMap<>();

	public HashMap<Pessoa, List<Conta>> getMapaPessoaConta() {
		return mapaPessoaConta;
	}

	public void setMapaPessoaConta(HashMap<Pessoa, List<Conta>> mapaPessoaConta) {
		this.mapaPessoaConta = mapaPessoaConta;
	}
	
	public List<Conta> getConta(int numeroConta){
		Optional<Conta> contaOp = ((Collection<Conta>) mapaPessoaConta).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent())
			return mapaPessoaConta.get(contaOp);
		return null;
	}
	
//	public Boolean incluirConta(Pessoa pessoa, Conta conta){
//		Optional<Conta> contaOp = ((Collection<Conta>) mapaPessoaConta).stream().filter(conta -> conta.getNumero() == contaOp.get().getNumero()).findFirst();
//		if (contaOp.isPresent()){
//			return false;			
//		}else{
//			mapaPessoaConta.put(pessoa, (List<Conta>) conta);
//			return true;
//			}
//	}
	
	public Boolean depositoConta(int numeroConta, double valor){
		Optional<Conta> contaOp = ((Collection<Conta>) mapaPessoaConta).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent()){
			contaOp.get().depositarValor(valor);
			return true;
			}else{
				return false;
			}
	}
	
	public Boolean removerConta(int numeroConta){
		Optional<Conta> contaOp = ((Collection<Conta>) mapaPessoaConta).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent()){
			mapaPessoaConta.remove(contaOp);
			return true;
			}else{
				return false;
			}
	}
	
	public Boolean saqueConta(int numeroConta, double valor) throws Exception{
		Optional<Conta> contaOp = ((Collection<Conta>) mapaPessoaConta).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent()){
			contaOp.get().saque(valor);
			return true;
			}else{
				return false;
			}
	}
	
	public String toString(){
		return "\n MapaPessoaConta: " + this.mapaPessoaConta;
	}

}