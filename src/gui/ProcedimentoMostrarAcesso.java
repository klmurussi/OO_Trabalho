package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import dados.Acesso;
import janelaFramework.JanelaFramework;

class ProcedimentoMostrarAcesso extends ProcedimentoProcurar<Acesso> implements Procedimento
{
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoMostrarAcesso(Vector<Acesso> acessos, Procedimento procedimento_anterior)
	{
		super(acessos, procedimento_anterior);
		this.procedimento_anterior=procedimento_anterior;
	}
	
	protected ActionListener procedimento_selecionar(JanelaFramework janela, Acesso acesso)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoAcesso procedimento=new ProcedimentoAcesso(acesso, procedimento_anterior);
				procedimento.atualizar(janela);
			}
		};
	}
}