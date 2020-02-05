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
		setTitle("Lista de Lan\u00E7amentos do Caixa");
		setBounds(380, 70, 900, 600);
		
		JPanel pnlTopo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlTopo.getLayout();
		flowLayout.setVgap(25);
		getContentPane().add(pnlTopo, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				
				
			}
		});
		pnlTopo.add(btnNewButton);
		
		JPanel pnlRodape = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlRodape.getLayout();
		flowLayout_1.setVgap(25);
		getContentPane().add(pnlRodape, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tblMovimento = new JTable();
		scrollPane.setViewportView(tblMovimento);
		
		atualizarLancamentos(); 
		
		


	}
	
	
	public void atualizarLancamentos() { 
		
		MovimentoCaixaCtrl movCtrl = new MovimentoCaixaCtrl();
		
		tblMovimento.setModel(movCtrl.listarLancamentos());
		
	}

}
