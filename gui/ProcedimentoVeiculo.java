package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dados.Cliente;
import dados.Veiculo;
import janelaFramework.JanelaFramework;

class ProcedimentoVeiculo implements Procedimento
{
	private String marca;
	private String modelo;
	private String numero;
	private Cliente dono;
	
	private Procedimento procedimento_atual;
	private Procedimento procedimento_anterior;
	
	protected ProcedimentoVeiculo(Veiculo veiculo, Procedimento procedimento_anterior)
	{
		procedimento_atual=this;
		this.procedimento_anterior=procedimento_anterior;
		marca=veiculo.get_marca();
		modelo=veiculo.get_modelo();
		numero=veiculo.get_numero();
		dono=veiculo.get_dono();
	}

	public void atualizar(JanelaFramework janela)
	{
		janela.set_titulo("Veiculo");
		janela.limpar_vetores();
		
		janela.criar_label("Marca: ");
		janela.criar_label(marca);
		janela.pular_linha_grafica();
		janela.criar_label("Modelo: ");
		janela.criar_label(modelo);
		janela.pular_linha_grafica();
		janela.criar_label("Número: ");
		janela.criar_label(numero);
		janela.pular_linha_grafica();
		janela.criar_botao("Mostrar Dono", procedimento_mostrar_dono(janela));
		janela.pular_linha_grafica();
		janela.criar_botao("Voltar", procedimento_voltar(janela));
		
		janela.mostrar();
	}
	
	private ActionListener procedimento_mostrar_dono(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProcedimentoCliente procedimento=new ProcedimentoCliente(dono, procedimento_atual);
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