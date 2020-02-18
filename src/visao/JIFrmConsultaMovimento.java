package visao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controle.MovimentoCaixaCtrl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.text.ParseException;

public class JIFrmConsultaMovimento extends JInternalFrame {
	private JTable tab_consulta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFrmConsultaMovimento frame = new JIFrmConsultaMovimento();
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
	public JIFrmConsultaMovimento() {
		setMaximizable(true);
		setClosable(true);
		setTitle("Consulta Lan\u00E7amentos");
		setBounds( 400, 100, 836, 542 );
		
		JPanel panel_top = new JPanel();
		FlowLayout fl_panel_top = (FlowLayout) panel_top.getLayout();
		fl_panel_top.setVgap(40);
		getContentPane().add(panel_top, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Informe a data a consultar:");
		panel_top.add(lblNewLabel);
		
		JFormattedTextField fmt_data = new JFormattedTextField();
		fmt_data.setColumns(10);
		
		DefaultFormatterFactory dfmt;
		MaskFormatter msk;
		
		
		try {
			msk = new MaskFormatter("##/##/####");
			dfmt = new DefaultFormatterFactory( msk );
			fmt_data.setFormatterFactory( dfmt );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		panel_top.add(fmt_data);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_top.add(btnNewButton);
		
		JPanel panel_rodape = new JPanel();
		getContentPane().add(panel_rodape, BorderLayout.SOUTH);
		panel_rodape.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 12));
		
		JLabel lblSaldoAnterior = new JLabel("Saldo Anterior:");
		panel_rodape.add(lblSaldoAnterior);
		
		textField_2 = new JTextField();
		textField_2.setText("0,00");
		panel_rodape.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Entrada:");
		panel_rodape.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("0,00");
		panel_rodape.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sa\u00EDda");
		panel_rodape.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setText("0,00");
		panel_rodape.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		panel_rodape.add(lblSaldo);
		
		textField_3 = new JTextField();
		textField_3.setText("0,00");
		panel_rodape.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		tab_consulta = new JTable();
		
		MovimentoCaixaCtrl movimentoCaixaCtrl = new MovimentoCaixaCtrl(); 
		
		TableModel tm = movimentoCaixaCtrl.listarLancamentos();
		
		if ( tm != null ) { 
		  tab_consulta.setModel( tm );
		} else
		{
			JOptionPane.showMessageDialog(null, "Não foi possível encontrar registros");
		}
		
		scrollPane.setViewportView(tab_consulta);

	}

}
