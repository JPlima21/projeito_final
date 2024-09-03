package projetoFinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

public class TelaCadastroLeitor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
//	private static List<String> camposVazios = new ArrayList<>() ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroLeitor dialog = new TelaCadastroLeitor(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static StringBuilder camposVazios = new StringBuilder();
	
	
	private static boolean verificarCamposVazios(JFormattedTextField... campos) {
		//camposVazios.setLength(0);
        for (JFormattedTextField campo : campos) {
        	String clearText = campo.getText().replaceAll("[^\\p{L}\\p{N}]", "");
            if (clearText.trim().isEmpty()) {
            	if (camposVazios.length() > 0) {
                    camposVazios.append(", ");
                }
            	 camposVazios.append(campo.getName());
            }
        }
        if(camposVazios.isEmpty()) {
        	return true;
        }
        return false;
	}
	
	public TelaCadastroLeitor(JFrame parent) {
		super(parent, "Tela cadastro leitor", true);
		setResizable(false);
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
			lblNmero.setBounds(10, 277, 60, 21);
			contentPanel.add(lblNmero);
		}
		{
			JLabel lblBairro = new JLabel("Bairro");
			lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBairro.setBounds(10, 181, 60, 21);
			contentPanel.add(lblBairro);
			
		}
		{
			JLabel lblCep = new JLabel("CEP");
			lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCep.setBounds(10, 245, 30, 21);
			contentPanel.add(lblCep);
		}
		
	try {
		MaskFormatter maskcpf,maskphone,maskcep;
		maskcpf = new MaskFormatter("###.###.###-##");
		maskcpf.setPlaceholderCharacter('_');
		maskphone = new MaskFormatter("(##) #####-####");
		maskphone.setPlaceholderCharacter('_');
		maskcep = new MaskFormatter("#####-###");
		maskcep.setPlaceholderCharacter('_');
		
		
		
		{
			
			
			
			JFormattedTextField formattedTextFieldNome = new JFormattedTextField();
			formattedTextFieldNome.setName("Nome");
			formattedTextFieldNome.setBounds(102, 27, 273, 20);
			contentPanel.add(formattedTextFieldNome);
		
		
			JFormattedTextField formattedTextFieldCpf = new JFormattedTextField(maskcpf);
			formattedTextFieldCpf.setName("CPF");
			formattedTextFieldCpf.setBounds(102, 58, 273, 20);
			contentPanel.add(formattedTextFieldCpf);
		
		
		
			JFormattedTextField formattedTextFieldPhone = new JFormattedTextField(maskphone);
			formattedTextFieldPhone.setName("Telefone");
			formattedTextFieldPhone.setBounds(102, 89, 273, 20);
			contentPanel.add(formattedTextFieldPhone);
			
		
			JFormattedTextField formattedTextFieldEmail = new JFormattedTextField();
			formattedTextFieldEmail.setName("Email");
			formattedTextFieldEmail.setBounds(102, 120, 273, 20);
			contentPanel.add(formattedTextFieldEmail);
		
		
			JFormattedTextField formattedTextFieldBairro = new JFormattedTextField();
			formattedTextFieldBairro.setName("Bairro");
			formattedTextFieldBairro.setBounds(102, 183, 273, 20);
			contentPanel.add(formattedTextFieldBairro);
		
		
			JFormattedTextField formattedTextFieldRua = new JFormattedTextField();
			formattedTextFieldRua.setName("Rua");
			formattedTextFieldRua.setBounds(102, 215, 273, 20);
			contentPanel.add(formattedTextFieldRua);
		
		
			JFormattedTextField formattedTextFieldNum = new JFormattedTextField();
			formattedTextFieldNum.setName("Número");
			formattedTextFieldNum.setBounds(102, 279, 273, 20);
			contentPanel.add(formattedTextFieldNum);
		
		
			JFormattedTextField formattedTextFieldCep = new JFormattedTextField(maskcep);
			formattedTextFieldCep.setName("CEP");
			formattedTextFieldCep.setBounds(102, 246, 273, 20);
			contentPanel.add(formattedTextFieldCep);
			
			
			
		
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
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						camposVazios.setLength(0);
						
						boolean verificacao = verificarCamposVazios(formattedTextFieldNome, formattedTextFieldCpf, formattedTextFieldPhone, 
								formattedTextFieldEmail, formattedTextFieldCep, formattedTextFieldBairro, 
								formattedTextFieldRua, formattedTextFieldNum);
						
						if(verificacao == true) {
							JOptionPane.showMessageDialog(contentPanel, "Informações validas!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
							TelaPrincipal tel = new TelaPrincipal();
							tel.tabelaLivro(buttonPane);
							
						}else {
							System.out.println(formattedTextFieldCpf);
							JOptionPane.showMessageDialog(contentPanel, "Por favor verifique o campo(s):" + camposVazios, "Aviso!", JOptionPane.INFORMATION_MESSAGE);
							
						}
					}
				});
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
		
	} catch (ParseException e) {
		e.printStackTrace();
	}	
		
	}
}

