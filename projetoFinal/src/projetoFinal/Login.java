package projetoFinal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	// Olá

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/icones/logobiblioteca500x500.png")));
		setBackground(new Color(62, 62, 62));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(43, 167, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		panel.setBackground(new Color(216, 216, 216));
		panel.setBounds(10, 11, 564, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBorder(null);
		textFieldUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		textFieldUsuario.setBackground(new Color(126, 121, 134));
		textFieldUsuario.setBounds(157, 242, 245, 29);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblNewLabel.setBounds(237, 193, 84, 38);
		panel.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(0, 0, 0));
		lblSenha.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblSenha.setBounds(242, 282, 75, 38);
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(126, 121, 134));
		passwordField.setBounds(157, 331, 245, 29);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldUsuario.getText() != null && !textFieldUsuario.getText().isEmpty() &&
					passwordField.getText() != null && !passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Informações validas!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(panel, "Verifique as informações!", "Aviso!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(43, 167, 208));
		btnNewButton.setBounds(217, 447, 124, 38);
		panel.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Salvar login");
		chckbxNewCheckBox.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox.setBackground(new Color(216, 216, 216));
		chckbxNewCheckBox.setBounds(241, 387, 100, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("imagem");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/icones/iconeLogin.png")));
		lblNewLabel_1.setBounds(203, 24, 152, 156);
		panel.add(lblNewLabel_1);
	}
}
