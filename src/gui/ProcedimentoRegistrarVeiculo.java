package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dados.Cliente;
import dados.Registro;
import dados.Veiculo;
import janelaFramework.JanelaFramework;

class ProcedimentoRegistrarVeiculo implements Procedimento
{
	private String versao_salva;
	private String modelo_salvo;
	private String numero_salvo;
	private Cliente cliente_salvo;
	
	private Procedimento procedimento_atual;
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoRegistrarVeiculo(Procedimento procedimento_anterior)
	{
		procedimento_atual=this;
		this.procedimento_anterior=procedimento_anterior;
		versao_salva=new String();
		modelo_salvo=new String();
		numero_salvo=new String();
		cliente_salvo=null;
	}
	
	public void atualizar(JanelaFramework janela)
	{
		janela.set_titulo("Registro Veiculo");
		janela.limpar_vetores();
		
		janela.criar_label("Versao:");
		janela.criar_text_field(versao_salva);
		janela.pular_linha_grafica();
		janela.criar_label("Modelo:");
		janela.criar_text_field(modelo_salvo);
		janela.pular_linha_grafica();
		janela.criar_label("Numero:");
		janela.criar_text_field(numero_salvo);
		janela.pular_linha_grafica();
		janela.criar_label("Cliente:");
		if(cliente_salvo==null)
		{
			janela.criar_botao("Registrar Cliente", procedimento_registrar_cliente(janela));
			janela.criar_botao("Procurar Cliente", procedimento_procurar_cliente(janela));
		}
		else
		{
			janela.criar_botao("Mostrar Cliente", procedimento_mostrar_cliente(janela));
		}
		janela.pular_linha_grafica();
		janela.criar_botao("Voltar", procedimento_voltar(janela));
		janela.criar_botao("Registrar", procedimento_registrar(janela));
		
		janela.mostrar();
	}
	
	private void salvar_strings(JanelaFramework janela)
	{
		versao_salva=janela.get_string(0);
		modelo_salvo=janela.get_string(1);
		numero_salvo=janela.get_string(2);
	}
	
	protected void set_cliente(Cliente cliente)
	{
		cliente_salvo=cliente;
	}
	
	private ActionListener procedimento_registrar_cliente(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				salvar_strings(janela);
				
				ProcedimentoRegistrarCliente procedimento=new ProcedimentoRegistrarCliente(procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_procurar_cliente(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				ProcedimentoMostrarCliente procedimento=new ProcedimentoMostrarCliente(Registro.get_clientes(), procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_mostrar_cliente(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoCliente procedimento=new ProcedimentoCliente(cliente_salvo, procedimento_atual);
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
	
	private ActionListener procedimento_registrar(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Veiculo veiculo=new Veiculo(versao_salva, modelo_salvo, numero_salvo);
				cliente_salvo.add_vehicle(veiculo);
				veiculo.set_dono(cliente_salvo);
				Registro.adicionar_veiculo(veiculo);
				procedimento_anterior.atualizar(janela);
			}
		};
	}
}