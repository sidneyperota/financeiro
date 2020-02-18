package visao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

import controle.MovimentoCaixaCtrl;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.awt.event.ActionEvent;

public class FrmLancCaixa extends JInternalFrame {
	private JTextField txt_doc;
	private JTextField txt_valor;
	
	
	MovimentoCaixaCtrl movimentoCaixaCtrl; 
	private JTextField txtConta;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLancCaixa frame = new FrmLancCaixa();
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
	public FrmLancCaixa() {
		setClosable(true);
		movimentoCaixaCtrl = new MovimentoCaixaCtrl(); 
		
		setTitle("Lan\u00E7amento do Caixa");
		setBounds(500, 100, 551, 438);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setVgap(30);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Salvar");
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setHgap(20);
		getContentPane().add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		txt_doc = new JTextField();
		txt_doc.setBounds(128, 115, 181, 20);
		panel_3.add(txt_doc);
		txt_doc.setColumns(10);
		
		txt_valor = new JTextField();
		txt_valor.setBounds(128, 214, 181, 20);
		panel_3.add(txt_valor);
		txt_valor.setColumns(10);
		
		JComboBox cb_operacao = new JComboBox();
		cb_operacao.setModel(new DefaultComboBoxModel(new String[] {"Entrada", "Sa\u00EDda"}));
		cb_operacao.setBounds(128, 42, 105, 20);
		panel_3.add(cb_operacao);
		
		JLabel lblNewLabel = new JLabel("Opera\u00E7\u00E3o:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(51, 45, 70, 14);
		panel_3.add(lblNewLabel);
		
		JFormattedTextField fmt_data = new JFormattedTextField();
		
		DefaultFormatterFactory dfmt;
		
		MaskFormatter msk;
		try {
			msk = new MaskFormatter("##/##/####");
			dfmt = new DefaultFormatterFactory( msk );
			fmt_data.setFormatterFactory( dfmt );  
	
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		fmt_data.setBounds(128, 11, 105, 20);
		panel_3.add(fmt_data);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setBounds(72, 14, 46, 14);
		panel_3.add(lblData);
		
		JLabel lblNewLabel_1 = new JLabel("Doc:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(72, 118, 46, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setBounds(61, 217, 57, 14);
		panel_3.add(lblValor);
		
		JTextArea txt_historico = new JTextArea();
		txt_historico.setBounds(128, 146, 344, 57);
		panel_3.add(txt_historico);
		
		JLabel lblNewLabel_2 = new JLabel("Hist\u00F3rico:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(40, 143, 78, 14);
		panel_3.add(lblNewLabel_2);
		
		txtConta = new JTextField();
		txtConta.setBounds(128, 83, 181, 20);
		panel_3.add(txtConta);
		txtConta.setColumns(10);
		
		JLabel lblConta = new JLabel("Conta:");
		lblConta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConta.setBounds(75, 86, 46, 14);
		panel_3.add(lblConta);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String>  aValores = new ArrayList();
				
				
				Date data = null;
				String sData = ""; 
				
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
					data = formato.parse(fmt_data.getText() );
					formato.applyPattern("yyyy-MM-dd");
					sData = formato.format(data); 
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				aValores.add( sData );
				aValores.add( (String) cb_operacao.getItemAt( cb_operacao.getSelectedIndex() ) );
				aValores.add(txtConta.getText());
				aValores.add( txt_doc.getText() ); 
				aValores.add( txt_historico.getText() ); 
				aValores.add( txt_valor.getText() ); 
				aValores.add("999");
				movimentoCaixaCtrl.inserirLancamento( aValores );
				fmt_data.setText("");
				txtConta.setText("");
				txt_doc.setText("");
				txt_historico.setText("");
				txt_valor.setText("");
			}
		});


	}
}
