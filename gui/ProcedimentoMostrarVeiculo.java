package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import dados.Veiculo;
import janelaFramework.JanelaFramework;

class ProcedimentoMostrarVeiculo extends ProcedimentoProcurar<Veiculo> implements Procedimento
{
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoMostrarVeiculo(Vector<Veiculo> veiculos, Procedimento procedimento_anterior)
	{
		super(veiculos, procedimento_anterior);
		this.procedimento_anterior=procedimento_anterior;
	}
	
	protected ActionListener procedimento_selecionar(JanelaFramework janela, Veiculo veiculo)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoVeiculo procedimento=new ProcedimentoVeiculo(veiculo, procedimento_anterior);
				procedimento.atualizar(janela);
			}
		};
	}
}