package janelaFramework;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaFramework
{
	private JFrame frame;
	private JPanel painel_principal;
	private JPanel painel_modificado_atual;
	private Vector<JPanel> paineis_para_serem_mostrados;
	private Vector<JLabel> labels;
	private Vector<JTextField> text_fields;
	
	public JanelaFramework(String titulo_janela)
	{
		frame=new JFrame(titulo_janela);
		painel_principal=new JPanel();
		painel_principal.setLayout(new BoxLayout(painel_principal, BoxLayout.Y_AXIS));
		
		painel_modificado_atual=new JPanel();
		paineis_para_serem_mostrados=new Vector<JPanel>();
		
		labels=new Vector<JLabel>();
		text_fields=new Vector<JTextField>();
	}
	
	public void fechar()
	{
		frame.dispose();
	}
	
	public void set_titulo(String titulo)
	{
		frame.setTitle(titulo);
	}
	
	public void criar_botao(String texto, ActionListener procedimento)
	{
		JButton button=new JButton(texto);
		button.addActionListener(procedimento);
		painel_modificado_atual.add(button);
	}
	
	public void criar_label(String texto)
	{
		JLabel label=new JLabel(texto);
		labels.add(label);
		painel_modificado_atual.add(label);
	}
	
	public void set_label(int index, String texto)
	{
		labels.get(index).setText(texto);
	}
	
	public void criar_text_field(String texto)
	{
		JTextField field=new JTextField(texto, 30);
		text_fields.add(field);
		painel_modificado_atual.add(field);
	}
	
	public String get_string(int index)
	{
		return text_fields.get(index).getText();
	}
	
	public void pular_linha_grafica()
	{
		paineis_para_serem_mostrados.add(painel_modificado_atual);
		painel_modificado_atual=new JPanel();
	}
	
	public void mostrar()
	{
		painel_principal.removeAll();
		
		paineis_para_serem_mostrados.add(painel_modificado_atual);
		Iterator<JPanel> panels_iterator=paineis_para_serem_mostrados.iterator();
		while(panels_iterator.hasNext())
		{
			painel_principal.add(panels_iterator.next());
		}
		frame.add(painel_principal);
		
		frame.pack();
		frame.setBounds(500, 200, frame.getWidth()+50, frame.getHeight());
		frame.setVisible(true);
		
		painel_modificado_atual=new JPanel();
		paineis_para_serem_mostrados.removeAllElements();
	}
	
	public void limpar_vetores()
	{
		labels.removeAllElements();
		text_fields.removeAllElements();
	}
}