package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import janelaFramework.JanelaFramework;

abstract class ProcedimentoProcurar<Dado> implements Procedimento
{
	private Procedimento procedimento_anterior;
	private Procedimento procedimento_atual;
	
	private int pagina_numero;
	private Vector<Vector<Dado>> paginas;
	
	protected ProcedimentoProcurar(Vector<Dado> data_list, Procedimento procedimento_anterior)
	{
		this.procedimento_anterior=procedimento_anterior;
		procedimento_atual=this;
		
		pagina_numero=0;
		paginas=new Vector<Vector<Dado>>();
		
		Vector<Dado> pagina=new Vector<Dado>();
		int contador_while=0;
		Iterator<Dado> iterador_lista=data_list.iterator();
		while(iterador_lista.hasNext())
		{
			Dado dados=iterador_lista.next();
			pagina.add(dados);
			if(contador_while>=15)
			{
				paginas.add(pagina);
				pagina=new Vector<Dado>();
				contador_while=0;
			}
			contador_while++;
		}
		
		if(!pagina.isEmpty())
		{
			paginas.add(pagina);
		}
	}
	
	public void atualizar(JanelaFramework janela)
	{
		janela.set_titulo("Procurar");
		janela.limpar_vetores();
		
		if(paginas.size()!=0)
		{
			Vector<Dado> pagina=paginas.get(pagina_numero);
			
			int contador_while=0;
			Iterator<Dado> iterador_pagina=pagina.iterator();
			while(iterador_pagina.hasNext())
			{
				Dado dados=iterador_pagina.next();
				janela.criar_botao(dados.toString(), procedimento_selecionar(janela, dados));
				if(contador_while>=3)
				{
					janela.pular_linha_grafica();
					contador_while=0;
				}
				contador_while++;
			}
			janela.pular_linha_grafica();
			if(paginas.size()!=1)
			{
				if(pagina_numero<=0)
				{
					janela.criar_botao("Proxima Pagina", next_page_procedure(janela));
				}
				else if(pagina_numero>=paginas.size()-1)
				{
					janela.criar_botao("Anterior Pagina", procedimento_pagina_anterior(janela));
				}
				else
				{
					janela.criar_botao("Anterior Pagina", procedimento_pagina_anterior(janela));
					janela.criar_botao("Proxima Pagina", next_page_procedure(janela));
				}
			}
		}
		else
		{
			janela.criar_label("There is nothing registered!");
		}
		janela.pular_linha_grafica();
		janela.criar_botao("Voltar", procedimento_voltar(janela));
		
		janela.mostrar();
	}
	
	private ActionListener next_page_procedure(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				pagina_numero++;
				procedimento_atual.atualizar(janela);
			}
		};
	}
	
	private ActionListener procedimento_pagina_anterior(JanelaFramework janela)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				pagina_numero--;
				procedimento_atual.atualizar(janela);
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
	
	protected abstract ActionListener procedimento_selecionar(JanelaFramework janela, Dado dados);
}