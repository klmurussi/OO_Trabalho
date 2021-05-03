package dados;

import java.util.Vector;

public class Cliente
{
	private String nome;
	private String endereco;
	private String celular;
	private String telefone;
	private String CNH;
	private Vector<Veiculo> veiculos;
	
	public Cliente(String nome, String endereco, String celular, String telefone, String CNH)
	{
		this.nome=nome;
		this.endereco=endereco;
		this.celular=celular;
		this.telefone=telefone;
		this.CNH=CNH;
		veiculos=new Vector<Veiculo>();
	}
	
	public String get_nome()
	{
		return nome;
	}
	
	public String get_endereco()
	{
		return endereco;
	}
	
	public String get_celular()
	{
		return celular;
	}
	
	public String get_telefone()
	{
		return telefone;
	}
	
	public String get_CNH()
	{
		return CNH;
	}
	
	public Vector<Veiculo> get_veiculos()
	{
		return veiculos;
	}
}
