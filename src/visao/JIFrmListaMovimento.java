package visao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controle.MovimentoCaixaCtrl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

public class JIFrmListaMovimento extends JInternalFrame {
	private JTable tblMovimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFrmListaMovimento frame = new JIFrmListaMovimento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JIFrmListaMovimento() {
		
		setClosable(true);
		setMaximizable(true);
		setTitle("Lista de Lançamentos do Caixa");
		setBounds(380, 70, 900, 600);
		
		JPanel pnlTopo = new JPanel();
		getContentPane().add(pnlTopo, BorderLayout.NORTH);
		pnlTopo.setLayout(new BorderLayout(10, 40));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tblMovimento = new JTable();
		scrollPane.setViewportView(tblMovimento);
		
		JPanel pnlRodape = new JPanel();
		scrollPane.setColumnHeaderView(pnlRodape);
		
		
		
		atualizarLancamentos(); 
		
		
		


	}
	
	
	public void atualizarLancamentos() { 
		
		MovimentoCaixaCtrl movCtrl = new MovimentoCaixaCtrl();
		
		tblMovimento.setModel(movCtrl.listarLancamentos());
		
	}

}
