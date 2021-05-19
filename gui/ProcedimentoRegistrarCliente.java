package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dados.Cliente;
import dados.Registro;
import janelaFramework.JanelaFramework;

class ProcedimentoRegistrarCliente implements Procedimento
{	
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoRegistrarCliente(Procedimento procedimento_anterior)
	{
		this.procedimento_anterior=procedimento_anterior;
	}
	
	public void atualizar(JanelaFramework janela)
	{
		janela.set_titulo("Registrar Cliente");
		janela.limpar_vetores();
		
		janela.criar_label("Nome:");
		janela.criar_text_field("");
		janela.pular_linha_grafica();
		janela.criar_label("Endereco:");
		janela.criar_text_field("");
		janela.pular_linha_grafica();
		janela.criar_label("Celular:");
		janela.criar_text_field("");
		janela.pular_linha_grafica();
		janela.criar_label("Telephone");
		janela.criar_text_field("");
		janela.pular_linha_grafica();
		janela.criar_label("CNH:");
		janela.criar_text_field("");
		janela.pular_linha_grafica();
		janela.criar_botao("Voltar", procedimento_voltar(janela));
		janela.criar_botao("Registrar", procedimento_registrar(janela));
		
		janela.mostrar();
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
				String nome=janela.get_string(0);
				String endereco=janela.get_string(1);
				String celular=janela.get_string(2);
				String telefone=janela.get_string(3);
				String CNH=janela.get_string(4);
				
				Cliente cliente=new Cliente(nome, endereco, celular, telefone, CNH);
				Registro.adicionar_cliente(cliente);
				
				try
				{
					ProcedimentoRegistrarVeiculo procedimento=(ProcedimentoRegistrarVeiculo)procedimento_anterior;
					procedimento.set_cliente(cliente);
				}
				catch(ClassCastException err){}
				
				procedimento_anterior.atualizar(janela);
			}
		};
	}
}