package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dados.Acesso;
import dados.Cliente;
import janelaFramework.JanelaFramework;

class ProcedimentoAcesso implements Procedimento
{
	private String saved_date;
	private String saved_time;
	private Cliente cliente_salvo;
	
	private Procedimento procedimento_atual;
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoAcesso(Acesso acesso, Procedimento procedimento_anterior)
	{
		procedimento_atual=this;
		this.procedimento_anterior=procedimento_anterior;
		
		saved_date=acesso.get_data();
		saved_time=acesso.get_tempo();
		cliente_salvo=acesso.get_cliente();
	}
	
	public void atualizar(JanelaFramework janela)
	{
		janela.set_titulo("Acesso");
		janela.limpar_vetores();
		
		janela.criar_label("Data: ");
		janela.criar_label(saved_date);
		janela.pular_linha_grafica();
		janela.criar_label("Horário: ");
		janela.criar_label(saved_time);
		janela.pular_linha_grafica();
		janela.criar_botao("Mostrar Cliente", procedimento_mostrar_cliente(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("Voltar", procedimento_voltar(janela));
		
		janela.mostrar();
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
}
