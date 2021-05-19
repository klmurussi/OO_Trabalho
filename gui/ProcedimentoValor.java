package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import dados.Acesso;
import janelaFramework.JanelaFramework;

class ProcedimentoValor implements Procedimento
{
	private Acesso acesso_inicial;
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoValor(Acesso acesso, Procedimento procedimento_anterior)
	{
		acesso_inicial=acesso;
		this.procedimento_anterior=procedimento_anterior;
	}
	
	public void atualizar(JanelaFramework janela)
	{
		janela.set_titulo("Valor");
		janela.limpar_vetores();
		
		LocalDate data_final=LocalDate.now();
		LocalTime tempo_final=LocalTime.now();
		
		janela.criar_label("Valor: ");
		janela.criar_label(String.valueOf(acesso_inicial.get_access_value(data_final, tempo_final)));
		janela.pular_linha_grafica();
		janela.criar_botao("Voltar", procedimento_voltar(janela));
		
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
}