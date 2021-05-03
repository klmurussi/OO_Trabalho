package dados;


public class Veiculo
{
	private String versao;
	private String modelo;
	private String numero;
	private Cliente dono;
	
	public Veiculo(String versao, String modelo, String numero, Cliente cliente)
	{
		this.versao=versao;
		this.modelo=modelo;
		this.numero=numero;
		this.dono=cliente;
	}

	public String get_versao()
	{
		return versao;
	}

	public String get_numero()
	{
		return numero;
	}

	public String get_modelo()
	{
		return modelo;
	}
	
	public Cliente set_cliente(Cliente cliente)
	{
		return dono;
	}
}
