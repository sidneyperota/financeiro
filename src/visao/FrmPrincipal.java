package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setTitle("Controle de Caixa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(MAXIMIZED_BOTH);
		
		//setBounds(450, 200, 754, 477);
		
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCaixa = new JMenu("Caixa");
		menuBar.add(mnCaixa);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Consulta");
		mnCaixa.add(mntmNewMenuItem);
		
		
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Altera\u00E7\u00E3o");
		mnCaixa.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		
		
		// Evento OnClick do Lancamento de Caixa
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JIFrmListaMovimento jifFrmListaMovimento = new JIFrmListaMovimento(); 

				
				jifFrmListaMovimento.setVisible( true );
				desktopPane.add(jifFrmListaMovimento);
				
				
				
				
			}
		});
		
		
		
		JMenuItem mntmLanamento = new JMenuItem("Lan\u00E7amento");
		mntmLanamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmLancCaixa frmLancCaixa = new FrmLancCaixa();
				frmLancCaixa.setVisible( true );
				desktopPane.add( frmLancCaixa );
			}
		});
		mnCaixa.add(mntmLanamento);
		
		

		
		panel_1.add(desktopPane, BorderLayout.CENTER);
		
		
		
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(20);
		contentPane.add(panel_2, BorderLayout.SOUTH);
	}
	
	
	
	
	
	
}
