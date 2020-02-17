package controle;

import java.util.ArrayList;

import javax.swing.table.TableModel;

import dao.MovimentoCaixaDAO;
import modelo.MovimentoCaixa;

public class MovimentoCaixaCtrl {

	public TableModel listarLancamentos() {
		MovimentoCaixaDAO movimentoCaixaDAO = new MovimentoCaixaDAO();
		TableModel tm = movimentoCaixaDAO.listarCaixa();
		return tm;
	}
	
	
	public void inserirLancamento( ArrayList<String> valores ) { 
		
		MovimentoCaixaDAO movimentoCaixaDAO = new MovimentoCaixaDAO(); 
		MovimentoCaixa movimentoCaixa = new MovimentoCaixa(); 
		movimentoCaixa.getCaixa().setData( valores.get(0) );
		movimentoCaixa.setOperacao( valores.get(1) );
		movimentoCaixa.setConta( valores.get(2) );
		movimentoCaixa.setDoc( valores.get(3) );
		movimentoCaixa.setHistorico(valores.get(4));
		movimentoCaixa.setValor( valores.get(5));
		movimentoCaixa.setUsuario( Integer.valueOf( valores.get(6) ) );
		movimentoCaixaDAO.inserir( movimentoCaixa );
	
	}

}
