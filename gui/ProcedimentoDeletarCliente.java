package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import dados.Cliente;
import dados.Registro;
import janelaFramework.JanelaFramework;

class ProcedimentoDeletarCliente extends ProcedimentoProcurar<Cliente> implements Procedimento
{
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoDeletarCliente(Vector<Cliente> clientes, Procedimento procedimento_anterior)
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
				Registro.remover_cliente(cliente);
				procedimento_anterior.atualizar(janela);
			}
		};
	}
}