package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import dados.Acesso;
import dados.Cliente;
import dados.Registro;
import janelaFramework.JanelaFramework;

class ProcedimentoRegistrarAcesso implements Procedimento
{
	private LocalDate data_salva;
	private LocalTime tempo_salvo;
	private Cliente cliente_salvo;
	
	private Procedimento procedimento_atual;
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoRegistrarAcesso(Procedimento procedimento_anterior)
	{
		this.procedimento_anterior=procedimento_anterior;
		procedimento_atual=this;
		
		data_salva=null;
		tempo_salvo=null;
		cliente_salvo=null;
	}
	
	public void atualizar(JanelaFramework janela)
	{
		janela.set_titulo("Registro Acesso");
		janela.limpar_vetores();
		DateTimeFormatter formatador=DateTimeFormatter.ofPattern("hh:mm a");
		
		data_salva=LocalDate.now();
		tempo_salvo=LocalTime.now();
		
		
		
		janela.criar_label("Date: ");
		janela.criar_label(data_salva.toString());
		janela.pular_linha_grafica();
		janela.criar_label("Time: ");
		janela.criar_label(formatador.format(tempo_salvo));
		janela.pular_linha_grafica();
		if(cliente_salvo==null)
		{
			janela.criar_botao("Procurar Cliente", procedimento_procurar_cliente(janela));
		}
		else
		{
			janela.criar_botao("Mostrar Cliente", procedimento_mostrar_cliente(janela));
		}
		janela.pular_linha_grafica();
		janela.criar_botao("Voltar", procedimento_voltar(janela));
		janela.criar_botao("Registrar", procedimento_registrar(janela));
		if(cliente_salvo==null)
		{
			janela.pular_linha_grafica();
			janela.criar_label("Registre o Cliente ou procure antes de Registrar!");
		}
		
		
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
				Acesso acesso=new Acesso(data_salva, tempo_salvo, cliente_salvo);
				Registro.adicionar_acesso(acesso);
				procedimento_anterior.atualizar(janela);
			}
		};
	}

	protected void set_cliente(Cliente cliente)
	{
		cliente_salvo=cliente;
	}
}