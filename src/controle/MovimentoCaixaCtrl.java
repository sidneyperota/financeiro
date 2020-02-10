package controle;

import javax.swing.table.TableModel;

import dao.MovimentoCaixaDAO;

public class MovimentoCaixaCtrl {

	public TableModel listarLancamentos() {
		MovimentoCaixaDAO movimentoCaixaDAO = new MovimentoCaixaDAO();
		TableModel tm = movimentoCaixaDAO.listarCaixa();
		return tm;
	}
	
	
	public void inserirLancamento( String valores ) { 
		
		MovimentoCaixaDAO movimentoCaixaDAO = new MovimentoCaixaDAO(); 
		movimentoCaixaDAO.inserir(null);
		//movimentoCaixaDAO.listarCaixa();
	
	}

}
