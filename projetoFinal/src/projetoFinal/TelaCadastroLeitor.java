package projetoFinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class TelaCadastroLeitor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

//	
	
	public TelaCadastroLeitor(JFrame parent) {
		super(parent, "Tela cadastro leitor", true);
		setLocationRelativeTo(parent);
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 371);
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
			JLabel lblEndereo = new JLabel("Endereço:\r\n");
			lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEndereo.setBounds(10, 149, 75, 21);
			contentPanel.add(lblEndereo);
		}
		{
			JLabel lblRua = new JLabel("Rua");
			lblRua.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRua.setBounds(10, 213, 30, 21);
			contentPanel.add(lblRua);
		}
		{
			JLabel lblNmero = new JLabel("Número");
			lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNmero.setBounds(10, 277, 49, 21);
			contentPanel.add(lblNmero);
		}
		{
			JLabel lblBairro = new JLabel("Bairro");
			lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBairro.setBounds(10, 181, 60, 21);
			contentPanel.add(lblBairro);
			
		}
		
	try {
		MaskFormatter maskcpf,maskphone;
		maskcpf = new MaskFormatter("###.###.###-##");
		maskcpf.setPlaceholderCharacter('_');
		maskphone = new MaskFormatter("(##) #####-####");
		maskphone.setPlaceholderCharacter('_');
		
		{
			JFormattedTextField formattedTextFieldNome = new JFormattedTextField();
			formattedTextFieldNome.setBounds(102, 27, 273, 20);
			contentPanel.add(formattedTextFieldNome);
		}
		{
			JFormattedTextField formattedTextFieldCpf = new JFormattedTextField(maskcpf);
			formattedTextFieldCpf.setBounds(102, 58, 273, 20);
			contentPanel.add(formattedTextFieldCpf);
		}
		{
			JFormattedTextField formattedTextFieldPhone = new JFormattedTextField(maskphone);
			formattedTextFieldPhone.setBounds(102, 89, 273, 20);
			contentPanel.add(formattedTextFieldPhone);
		}
		{
			JFormattedTextField formattedTextFieldEmail = new JFormattedTextField();
			formattedTextFieldEmail.setBounds(102, 120, 273, 20);
			contentPanel.add(formattedTextFieldEmail);
		}
		{
			JFormattedTextField formattedTextFieldBairro = new JFormattedTextField();
			formattedTextFieldBairro.setBounds(102, 183, 273, 20);
			contentPanel.add(formattedTextFieldBairro);
		}
		{
			JFormattedTextField formattedTextFieldRua = new JFormattedTextField();
			formattedTextFieldRua.setBounds(102, 215, 273, 20);
			contentPanel.add(formattedTextFieldRua);
		}
		{
			JFormattedTextField formattedTextFieldNum = new JFormattedTextField();
			formattedTextFieldNum.setBounds(102, 279, 273, 20);
			contentPanel.add(formattedTextFieldNum);
		}
		{
			JFormattedTextField formattedTextFieldRua = new JFormattedTextField();
			formattedTextFieldRua.setBounds(102, 246, 273, 20);
			contentPanel.add(formattedTextFieldRua);
		}
	} catch (ParseException e) {
		e.printStackTrace();
	}	
		{
			JLabel lblCep = new JLabel("CEP");
			lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCep.setBounds(10, 245, 30, 21);
			contentPanel.add(lblCep);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 370, 436, 41);
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

