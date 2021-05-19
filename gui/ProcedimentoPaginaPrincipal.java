package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dados.Registro;
import janelaFramework.JanelaFramework;

public class ProcedimentoPaginaPrincipal implements Procedimento
{
	private Procedimento procedimento_atual;
	
	public ProcedimentoPaginaPrincipal()
	{
		procedimento_atual=this;
	}

	public void atualizar(JanelaFramework janela)
	{
		janela.set_titulo("Main Pagina");
		janela.limpar_vetores();
		
		janela.criar_botao("Registrar Veiculo", procedimento_registrar_veiculo(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("Procurar Veiculo", procedimento_procurar_veiculo(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("Delete Veiculo", procedimento_deletar_veiculo(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("Registrar Cliente", procedimento_registrar_cliente(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("Procurar Cliente", procedimento_procurar_cliente(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("Delete Cliente", procedimento_deletar_cliente(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("Registrar Acesso", procedimento_resgitrar_acesso(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("Procurar Acesso", procedimento_procurar_acesso(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("End Acesso", procedimento_finalizar_acesso(janela));
		
		janela.mostrar();
	}
	
	private ActionListener procedimento_registrar_veiculo(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoRegistrarVeiculo procedimento=new ProcedimentoRegistrarVeiculo(procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_procurar_veiculo(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoMostrarVeiculo procedimento=new ProcedimentoMostrarVeiculo(Registro.get_veiculos(), procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_deletar_veiculo(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoDeletarVeiculo procedimento=new ProcedimentoDeletarVeiculo(Registro.get_veiculos(), procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_registrar_cliente(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
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
	
	private ActionListener procedimento_deletar_cliente(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoDeletarCliente procedimento=new ProcedimentoDeletarCliente(Registro.get_clientes(), procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_resgitrar_acesso(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoRegistrarAcesso procedimento=new ProcedimentoRegistrarAcesso(procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_procurar_acesso(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoMostrarAcesso procedimento=new ProcedimentoMostrarAcesso(Registro.get_acessos(), procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_finalizar_acesso(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoDeletarAcesso procedimento=new ProcedimentoDeletarAcesso(Registro.get_acessos(), procedimento_atual);
				procedimento.atualizar(janela);
			}
		};
	}
}