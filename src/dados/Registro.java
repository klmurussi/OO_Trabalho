package dados;

import java.util.Vector;

public class Registro
{
	private static Vector<Cliente> clientes;
	private static Vector<Veiculo> veiculos;
	private static Vector<Acesso> acessos;
	
	public Registro()
	{
		clientes=new Vector<Cliente>();
		veiculos=new Vector<Veiculo>();
		acessos=new Vector<Acesso>();
	}
	
	public static void adicionar_cliente(Cliente cliente)
	{
		clientes.add(cliente);
	}
	
	public static Vector<Cliente> get_clientes()
	{
		return clientes;
	}
	
	public static void adicionar_veiculo(Veiculo veiculo)
	{
		veiculos.add(veiculo);
	}
	
	public static Vector<Veiculo> get_veiculos()
	{
		return veiculos;
	}
	
	public static void adicionar_acesso(Acesso acesso)
	{
		acessos.add(acesso);
	}
	
	public static Vector<Acesso> get_acessos()
	{
		return acessos;
	}
	
	public static void remover_veiculo(Veiculo veiculo)
	{
		veiculos.remove(veiculo);
	}
	
	public static void remover_cliente(Cliente cliente)
	{
		clientes.remove(cliente);
	}
	
	public static void remover_acesso(Acesso acesso)
	{
		acessos.remove(acesso);
	}
}