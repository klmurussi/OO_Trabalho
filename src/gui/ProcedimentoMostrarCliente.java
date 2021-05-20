package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import dados.Cliente;
import janelaFramework.JanelaFramework;

class ProcedimentoMostrarCliente extends ProcedimentoProcurar<Cliente> implements Procedimento
{
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoMostrarCliente(Vector<Cliente> clientes, Procedimento procedimento_anterior)
	{
		super(clientes, procedimento_anterior);
		this.procedimento_anterior=procedimento_anterior;
	}
	
	protected ActionListener procedimento_selecionar(JanelaFramework janela, Cliente cliente)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					ProcedimentoRegistrarVeiculo procedimento=(ProcedimentoRegistrarVeiculo)procedimento_anterior;
					procedimento.set_cliente(cliente);
					procedimento_anterior.atualizar(janela);
				}
				catch(ClassCastException err){}
				
				try
				{
					ProcedimentoRegistrarAcesso procedimento=(ProcedimentoRegistrarAcesso)procedimento_anterior;
					procedimento.set_cliente(cliente);
					procedimento_anterior.atualizar(janela);
				}
				catch(ClassCastException err){}
				
				ProcedimentoCliente procedimento=new ProcedimentoCliente(cliente, procedimento_anterior);
				procedimento.atualizar(janela);
			}
		};
	}
}