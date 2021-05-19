package dados;

public class Veiculo
{
	private String marca;
	private String modelo;
	private String numero;
	private Cliente dono;
	
	public Veiculo(String marca, String modelo, String numero)
	{
		this.marca=marca;
		this.modelo=modelo;
		this.numero=numero;
		dono=null;
	}
	
	public String get_marca()
	{
		return marca;
	}
	
	public String get_modelo()
	{
		return modelo;
	}
	
	public String get_numero()
	{
		return numero;
	}
	
	public void set_dono(Cliente cliente)
	{
		dono=cliente;
	}
	
	public Cliente get_dono()
	{
		return dono;
	}
}