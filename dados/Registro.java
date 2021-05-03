package dados;

import java.util.Vector;

public class Registro
{
	private static Vector<Veiculo> veiculos;
	private static Vector<Cliente> clientes;
	
	public Registro()
	{
		veiculos=new Vector<Veiculo>();
		clientes=new Vector<Cliente>();
	}
	
	public static void adicionar_veiculo(Veiculo veiculo)
	{
		veiculos.add(veiculo);
	}
	
	public static void adicionar_cliente(Cliente cliente)
	{
		clientes.add(cliente);
	}
	
	public static void deletar_veiculo(Veiculo veiculo)
	{
		veiculos.remove(veiculo);
	}
	
	public static void deletar_cliente(Cliente cliente)
	{
		clientes.remove(cliente);
	}

	public static Vector<Cliente> get_clientes()
	{
		return clientes;
	}
	
	public static Vector<Veiculo> get_veiculos()
	{
		return veiculos;
	}
}
