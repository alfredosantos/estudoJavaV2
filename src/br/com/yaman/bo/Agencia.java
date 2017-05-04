package br.com.yaman.bo;

import java.util.HashMap;
import java.util.List;

public class Agencia {
	
	HashMap<Pessoa, List<Conta>> mapaPessoaConta = new HashMap<>();

	public HashMap<Pessoa, List<Conta>> getMapaPessoaConta() {
		return mapaPessoaConta;
	}

	public void setMapaPessoaConta(HashMap<Pessoa, List<Conta>> mapaPessoaConta) {
		this.mapaPessoaConta = mapaPessoaConta;
	}
	
	public String toString(){
		return "\n Agencia - Pessoa Conta " + this.mapaPessoaConta;
	}

}