package br.com.yaman.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.yaman.common.Cpf;
import br.com.yaman.common.Email;

public class Pessoa implements Serializable, Comparable<Pessoa>{
	String nome;
	int idade;
	Endereco endereco;
	Cpf cpf;
	Email email;

	List<Conta> listContaPessoa = new ArrayList<Conta>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
			this.cpf = cpf;
	}

	public List<Conta> getListContaPessoa() {
		return listContaPessoa;
	}

	public void setListContaPessoa(List<Conta> listContaPessoa) {
		this.listContaPessoa = listContaPessoa;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Boolean incluirConta(Conta conta){
		for (Conta contaInclusao : listContaPessoa){
			if (contaInclusao.getNumero() == conta.getNumero()){
				return false;
			}
		}
		listContaPessoa.add(conta);
		return true;
	}
	
	public Conta getConta(int numeroConta){
		Optional<Conta> contaOp = listContaPessoa.stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent())
			return contaOp.get();

		return null;
	}
	
	public Boolean depositoConta(int numeroConta, double valor){
		for (Conta conta : listContaPessoa){
			if (conta.getNumero() == numeroConta) {
				conta.depositarValor(valor);
				return true;
			} 
		}
		return false;
	}
	
	public Boolean removerConta(int numeroConta){
		Conta contaTemp = new ContaCorrente();
		for (Conta conta : listContaPessoa){
			if (conta.getNumero() == numeroConta) {
				contaTemp = conta;
			} 
		}
		return listContaPessoa.remove(contaTemp);
	}
	
	public Boolean saqueConta(int numeroConta, double valor) throws Exception{

		for (Conta conta : listContaPessoa){
			if (conta.getNumero() == numeroConta){
					conta.saque(valor);
					return true;
				}
		}
		return false;
	}
	
	public String toString() {
		String contas = "";
		for (Conta conta : listContaPessoa) {
			contas += conta;
		}
		return "Nome: " + this.nome + "\n Idade: " + this.idade + "\n Endereço: " + this.endereco + "\n CPF: " + this.cpf + "\n Contas " + contas + "\n Email "  + this.email;

	}

	@Override
	public int compareTo(Pessoa o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean equals(Object o){
		return this.nome == ((Pessoa)o).nome;
		
	}

}
