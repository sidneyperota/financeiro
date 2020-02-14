import java.util.ArrayList;

import controle.MovimentoCaixaCtrl;
import dao.MovimentoCaixaDAO;
import visao.FrmPrincipal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/*
		FrmPrincipal frmPrincipal = new FrmPrincipal(); 
		frmPrincipal.setVisible(true);
		*/
		
		MovimentoCaixaCtrl movimentoCaixaCtrl = new MovimentoCaixaCtrl(); 
		
		ArrayList<String>  aValores = new ArrayList();
		aValores.add( "2020-02-14" );
		aValores.add( "E" );
		aValores.add( "121212" );
		aValores.add( "12525" ); 
		aValores.add( "RECEBIDO VALOR TESTE" ); 
		aValores.add( "10.00" ); 
		movimentoCaixaCtrl.inserirLancamento( aValores );
		
		
	}

}
