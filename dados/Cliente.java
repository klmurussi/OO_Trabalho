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
	
	public String get_name()
	{
		return nome;
	}
	
	public String get_address()
	{
		return endereco;
	}
	
	public String get_phone()
	{
		return celular;
	}
	
	public String get_telephone()
	{
		return telefone;
	}
	
	public String get_CNH()
	{
		return CNH;
	}
	
	public void add_vehicle(Veiculo veiculo)
	{
		veiculos.add(veiculo);
	}
	
	public Vector<Veiculo> get_veiculos()
	{
		return veiculos;
	}
}