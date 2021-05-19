import dados.Registro;
import gui.ProcedimentoPaginaPrincipal;
import janelaFramework.JanelaFramework;

public class Main
{
	public static void main(String []args)
	{
		new Registro();
		ProcedimentoPaginaPrincipal procedimento=new ProcedimentoPaginaPrincipal();
		JanelaFramework janela=new JanelaFramework("");
		procedimento.atualizar(janela);
	}
}
