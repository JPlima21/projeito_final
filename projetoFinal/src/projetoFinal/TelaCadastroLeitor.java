package projetoFinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroLeitor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			TelaCadastroLeitor dialog = new TelaCadastroLeitor(null);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			dialog.setLocationRelativeTo();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastroLeitor(JFrame parent) {
		super(parent, "Tela cadastro leitor", true);
		setLocationRelativeTo(parent);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 224);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nome:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 25, 60, 21);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCpf = new JLabel("CPF\r\n");
			lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCpf.setBounds(10, 56, 60, 21);
			contentPanel.add(lblCpf);
		}
		{
			JLabel lblTelefone = new JLabel("Telefone\r\n");
			lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTelefone.setBounds(10, 87, 60, 21);
			contentPanel.add(lblTelefone);
		}
		{
			JLabel lblEmail = new JLabel("Email:\r\n");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmail.setBounds(10, 118, 60, 21);
			contentPanel.add(lblEmail);
		}
		{
			JLabel lblEndereo = new JLabel("Endereço\r\n");
			lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEndereo.setBounds(10, 149, 60, 21);
			contentPanel.add(lblEndereo);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField.setBounds(103, 25, 240, 19);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_1.setColumns(10);
			textField_1.setBounds(103, 56, 240, 19);
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_2.setColumns(10);
			textField_2.setBounds(103, 87, 240, 19);
			contentPanel.add(textField_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_3.setColumns(10);
			textField_3.setBounds(103, 118, 240, 19);
			contentPanel.add(textField_3);
		}
		{
			textField_4 = new JTextField();
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_4.setColumns(10);
			textField_4.setBounds(103, 149, 240, 19);
			contentPanel.add(textField_4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 222, 436, 41);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Salvar");
				okButton.setBounds(96, 6, 73, 25);
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setBorder(new LineBorder(new Color(0, 255, 0)));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBorder(new LineBorder(new Color(255, 0, 0)));
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setBounds(265, 5, 73, 26);
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

}
