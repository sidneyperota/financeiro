import dao.MovimentoCaixaDAO;
import visao.FrmPrincipal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		FrmPrincipal frmPrincipal = new FrmPrincipal(); 
		frmPrincipal.setVisible(true);
		*/
		MovimentoCaixaDAO movimentoCaixaDAO = new MovimentoCaixaDAO(); 
		movimentoCaixaDAO.inserir(null); 

	}

}
