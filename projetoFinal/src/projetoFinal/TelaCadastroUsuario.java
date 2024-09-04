package projetoFinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JPasswordField passwordField;
	JPasswordField passwordFieldRepetir;
	JFormattedTextField formattedTextFieldUsuario;
	JFormattedTextField formattedTextFieldNome;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroUsuario dialog = new TelaCadastroUsuario(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastroUsuario(JFrame parent) {
		super(parent, "Tela_cadastro_usuario", true);
		setResizable(false);
		setLocationRelativeTo(parent);
		setBounds(100, 100, 369, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 353, 227);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nome:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 26, 64, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblUsario = new JLabel("Usúario:");
			lblUsario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUsario.setBounds(10, 66, 64, 14);
			contentPanel.add(lblUsario);
		}
		{
			JLabel lblSenha = new JLabel("Senha:");
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSenha.setBounds(10, 106, 64, 14);
			contentPanel.add(lblSenha);
		}
		{
			JLabel lblRepitaASenha = new JLabel("Repita a senha:");
			lblRepitaASenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRepitaASenha.setBounds(10, 146, 101, 14);
			contentPanel.add(lblRepitaASenha);
		}
		{
			JLabel lblNivelDePermio = new JLabel("Nivel de permição");
			lblNivelDePermio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNivelDePermio.setBounds(10, 186, 114, 14);
			contentPanel.add(lblNivelDePermio);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(135, 100, 187, 20);
			contentPanel.add(passwordField);
		}
		{
			passwordFieldRepetir = new JPasswordField();
			passwordFieldRepetir.setBounds(135, 145, 187, 20);
			contentPanel.add(passwordFieldRepetir);
		}
		{
			formattedTextFieldUsuario = new JFormattedTextField();
			formattedTextFieldUsuario.setBounds(135, 60, 187, 20);
			contentPanel.add(formattedTextFieldUsuario);
		}
		{
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma opção...", "Funcionario", "Administrador"}));
			comboBox.setBounds(134, 180, 188, 22);
			contentPanel.add(comboBox);
		}
		{
			formattedTextFieldNome = new JFormattedTextField();
			formattedTextFieldNome.setBounds(135, 20, 187, 20);
			contentPanel.add(formattedTextFieldNome);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String senha = passwordFieldRepetir.getText();
						String senha2 = passwordField.getText();
						
						if(senha.equals(senha2)) {
							if(verificarCamposVazios(formattedTextFieldNome, formattedTextFieldUsuario) == true && comboBox.getSelectedIndex() != 0) {
								salvarDados();
//								JOptionPane.showMessageDialog(contentPanel, "Informações validas!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
								System.out.println(comboBox.getSelectedItem());
								
							}else {
								JOptionPane.showMessageDialog(contentPanel, "Por favor verifique o campo(s):" + camposVazios, "Aviso!", JOptionPane.INFORMATION_MESSAGE);
								
							}
						}else {
							JOptionPane.showMessageDialog(contentPanel, "Verifique sua senha!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				okButton.setBorder(new LineBorder(new Color(0, 255, 0)));
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				okButton.setBounds(48, 0, 84, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBorder(new LineBorder(new Color(255, 0, 0)));
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cancelButton.setBounds(220, 0, 84, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	//conecção com o banco de dados
	private Connection conectar() throws SQLException {
        // Substitua os valores abaixo pelos detalhes do seu banco de dados
	 String url = "jdbc:postgresql://localhost:5432/Projeto_Biblioteca";
		String usuario = "postgres";
		String senha = "postgres";
        return DriverManager.getConnection(url, usuario, senha);
    }
	
	static StringBuilder camposVazios = new StringBuilder();
	
	private void salvarDados() {
        try (Connection conn = conectar()) {
            String sql = "INSERT INTO cadastrousuario (nome, usuario, senha, nivel_de_acesso) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Preencher o PreparedStatement com os valores dos campos
                pstmt.setString(1, formattedTextFieldNome.getText().trim());
                pstmt.setString(2, formattedTextFieldUsuario.getText().trim());
                pstmt.setString(3, passwordField.getText().trim());
                //pstmt.setDate(3, new java.sql.Date(((java.util.Date) formattedTextFieldAnoPublicacao.getValue()).getTime()));
                pstmt.setInt(4, comboBox.getSelectedIndex());
                

                // Executar o comando de inserção
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(contentPanel, "Informações salvas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(contentPanel, "Erro ao salvar informações: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public static boolean verificarCamposVazios(JFormattedTextField... campos) {
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
}
