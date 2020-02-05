package tebela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.MovimentoCaixa;

public class MovimentoCaixaTM extends AbstractTableModel {

	private List<MovimentoCaixa> dados;
	private String[] colunas = { "id", "data", "conta", "operacao", "historico", "valor", "usuario", "doc" };

	public MovimentoCaixaTM() {
		dados = new ArrayList();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// TODO Auto-generated method stub

		// "id", "data", "conta", "operacao", "historico", "valor", "usuario",
		// "doc"

		switch (coluna) {
		
		case 0:
			return dados.get(linha).getId();
		case 1:
			return dados.get(linha).getData();
		case 2:
			return dados.get(linha).getConta();
		case 3:
			return dados.get(linha).getOperacao();
		case 4:
			return dados.get(linha).getHistorico();
		case 5:
			return dados.get(linha).getValor();
		case 6:
			return dados.get(linha).getUsuario();
		case 7:
			return dados.get(linha).getDoc();
		default:
			throw new IndexOutOfBoundsException("Coluna inválida.");
		}
	}
	
	
	public void addMovimento(MovimentoCaixa movimentoCaixa ) {
        this.dados.add( movimentoCaixa );
        fireTableDataChanged();
    }

    public void removerMovimento(int rowIndex) {
        this.dados.remove(rowIndex);
        fireTableDataChanged();
    }

    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public MovimentoCaixa getObjeto(int ind) {
        return dados.get(ind);
    }

}
