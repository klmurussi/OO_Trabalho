package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import dados.Cliente;
import dados.Veiculo;
import janelaFramework.JanelaFramework;

class ProcedimentoCliente implements Procedimento
{
	private String nome;
	private String endereco;
	private String celular;
	private String telefone;
	private String CNH;
	private Vector<Veiculo> veiculos;
	
	private Procedimento procedimento_atual;
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoCliente(Cliente cliente, Procedimento procedimento_anterior)
	{
		procedimento_atual=this;
		this.procedimento_anterior=procedimento_anterior;
		nome=cliente.get_name();
		endereco=cliente.get_address();
		celular=cliente.get_phone();
		telefone=cliente.get_telephone();
		CNH=cliente.get_CNH();
		veiculos=cliente.get_veiculos();
	}
	
	public void atualizar(JanelaFramework janela)
	{
		janela.set_titulo("Cliente");
		janela.limpar_vetores();
		
		janela.criar_label("Name:");
		janela.criar_label(nome);
		janela.pular_linha_grafica();
		janela.criar_label("Endereco:");
		janela.criar_label(endereco);
		janela.pular_linha_grafica();
		janela.criar_label("Celular: ");
		janela.criar_label(celular);
		janela.pular_linha_grafica();
		janela.criar_label("Telephone: ");
		janela.criar_label(telefone);
		janela.pular_linha_grafica();
		janela.criar_label("CNH: ");
		janela.criar_label(CNH);
		janela.pular_linha_grafica();
		if(veiculos.size()!=0)
		{
			janela.criar_botao("Mostrar Veiculos", show_vehicles_procedure(janela));
		}
		else
		{
			janela.criar_label("Não há veículos registrados neste cliente!");
		}
		janela.pular_linha_grafica();
		janela.criar_botao("Voltar", procedimento_voltar(janela));
		
		janela.mostrar();
	}
	
	private ActionListener show_vehicles_procedure(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoMostrarVeiculo procedimento=new ProcedimentoMostrarVeiculo(veiculos, procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_voltar(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				procedimento_anterior.atualizar(janela);
			}
		};
	}
}