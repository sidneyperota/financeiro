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
import javax.swing.SwingConstants;

import controle.MovimentoCaixaCtrl;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLancCaixa extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	
	
	MovimentoCaixaCtrl movimentoCaixaCtrl; 
	

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movimentoCaixaCtrl.inserirLancamento("");

			}
		});
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
		
		textField = new JTextField();
		textField.setBounds(128, 97, 181, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 196, 181, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entrada", "Sa\u00EDda"}));
		comboBox.setBounds(128, 66, 105, 20);
		panel_3.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Opera\u00E7\u00E3o:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(51, 69, 70, 14);
		panel_3.add(lblNewLabel);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("  /  /");
		formattedTextField.setBounds(128, 35, 105, 20);
		panel_3.add(formattedTextField);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setBounds(72, 38, 46, 14);
		panel_3.add(lblData);
		
		JLabel lblNewLabel_1 = new JLabel("Doc:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(72, 100, 46, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setBounds(72, 199, 46, 14);
		panel_3.add(lblValor);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(128, 128, 344, 57);
		panel_3.add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Hist\u00F3rico:");
		lblNewLabel_2.setBounds(72, 125, 46, 14);
		panel_3.add(lblNewLabel_2);

	}
}
