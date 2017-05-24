import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.yaman.bo.Agencia;
import br.com.yaman.bo.Conta;
import br.com.yaman.bo.ContaCorrente;
import br.com.yaman.bo.ContaPoupanca;
import br.com.yaman.bo.Endereco;
import br.com.yaman.bo.Pessoa;
import br.com.yaman.common.Cpf;
import br.com.yaman.common.Email;

public class Main {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("João");
		pessoa.setIdade(18);
		inclusaoCpf(pessoa);
		inclusaoEndereco(pessoa);
		//inclusaoDeContas(pessoa);
		//trabalharComConta(pessoa);
		inclusaoEmail(pessoa);
		inclusaoDeAgencia(pessoa);
		
		//System.out.println(pessoa);
		
	}
	public static void inclusaoDeContas(Pessoa pessoa){
		Conta conta = new ContaCorrente();
		conta.setAgencia(193);
		conta.setLimite(500);
		conta.depositarValor(500);
		conta.setNumero(1);
		/*pessoa.incluirConta(conta);
		try {
			pessoa.saqueConta(1, 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	public static void trabalharComConta(Pessoa pessoa){
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setAgencia(123);
		contaCorrente.setNumero(1);
		
		ContaCorrente contaCorrente2 = new ContaCorrente();
		contaCorrente2.setAgencia(123);
		contaCorrente2.setNumero(2);
		
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setAgencia(123);
		contaPoupanca.setNumero(3);
		
		ContaPoupanca contaPoupanca2 = new ContaPoupanca();
		contaPoupanca2.setAgencia(123);
		contaPoupanca2.setNumero(4);
		
		ContaPoupanca contaPoupanca3 = new ContaPoupanca();
		contaPoupanca3.setAgencia(123);
		contaPoupanca3.setNumero(5);
		
		List<Conta> listContas = new ArrayList<Conta>();
		
		listContas.add(contaCorrente);
		listContas.add(contaCorrente2);
		listContas.add(contaPoupanca);
		listContas.add(contaPoupanca2);
		listContas.add(contaPoupanca3);
		
/*		pessoa.setListContaPessoa(listContas);
		
		for (Conta conta : pessoa.getListContaPessoa()) {
			conta.depositarValor(13.09);
		}*/
	}

    public static void inclusaoEndereco(Pessoa pessoa){
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua 1");
		endereco.setNumero(10);
		endereco.setComplemento("AB");
		pessoa.setEndereco(endereco);
    }
    
    public static void inclusaoCpf(Pessoa pessoa){
    	try {
			pessoa.setCpf(Cpf.of("13803623855"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public static void inclusaoEmail(Pessoa pessoa){
		try {
			pessoa.setEmail(Email.of("teste@gmail.com.br"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void inclusaoDeAgencia(Pessoa pessoa){
    	Agencia agencia = new Agencia();
    	ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setAgencia(123);
		contaCorrente.setNumero(1);
		
		ContaCorrente contaCorrente2 = new ContaCorrente();
		contaCorrente2.setAgencia(123);
		contaCorrente2.setNumero(2);
		
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setAgencia(123);
		contaPoupanca.setNumero(3);
		
		ContaPoupanca contaPoupanca2 = new ContaPoupanca();
		contaPoupanca2.setAgencia(123);
		contaPoupanca2.setNumero(4);
		
		ContaPoupanca contaPoupanca3 = new ContaPoupanca();
		contaPoupanca3.setAgencia(123);
		contaPoupanca3.setNumero(5);
		contaPoupanca3.setLimite(500);
		
		ContaCorrente contaCorrente4 = new ContaCorrente();
		contaCorrente4.setAgencia(123);
		contaCorrente4.setNumero(6);

		HashMap<Pessoa, List<Conta>> mapaAgenciaPessoaConta = new HashMap<>();
		List<Conta> listContas = new ArrayList<Conta>();
		listContas.add(contaCorrente);
		listContas.add(contaCorrente2);
		listContas.add(contaPoupanca);
		listContas.add(contaPoupanca2);
		listContas.add(contaPoupanca3);
		mapaAgenciaPessoaConta.put(pessoa, listContas);
		
		//mapaAgenciaPessoaConta.forEach((k,v)->System.out.println("Key : Manoooooo consegui " + k + " Value : " + v));
		
		agencia.setMapaPessoaConta(mapaAgenciaPessoaConta);
		
		agencia.depositoConta(pessoa, 5, 1000);
		
		agencia.incluirConta(pessoa, contaCorrente4);
		
		agencia.removerConta(pessoa, 3);
		
		try {
			agencia.saqueConta(pessoa, 5, 100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		agencia.getMapaPessoaConta();
		
		System.out.println(agencia);
		}
}
