package br.com.yaman.bo;

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
	
	public List<Conta> getConta(Pessoa pessoa, int numeroConta){
		Optional<Conta> contaOp =  mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent())
			return mapaPessoaConta.get(contaOp);
		return null;
	}
	
	public Boolean incluirConta(Pessoa pessoa, Conta conta){
		Optional<Conta> contaOp =  mapaPessoaConta.get(pessoa).stream().filter(contaUsu -> contaUsu.getNumero() == conta.getNumero()).findFirst();
		if (contaOp.isPresent()){
			return false;			
		}else{
			List<Conta> contas = mapaPessoaConta.get(pessoa);
			contas.add(conta);
			mapaPessoaConta.put(pessoa, contas);
			return true;
			}
	}
	
	public Boolean depositoConta(Pessoa pessoa, int numeroConta, double valor){
		Optional<Conta> contaOp =  mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent()){
			contaOp.get().depositarValor(valor);
			return true;
			}else{
				return false;
			}
	}
	
	public Boolean removerConta(Pessoa pessoa, int numeroConta){
		List<Conta> contas = mapaPessoaConta.get(pessoa);
		return contas.removeIf(conta -> conta.getNumero() == numeroConta);
	}
	
	public Boolean saqueConta(Pessoa pessoa, int numeroConta, double valor) throws Exception{
		Optional<Conta> contaOp =  mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
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