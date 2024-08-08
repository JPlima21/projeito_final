package projetoFinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriaConta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriaConta frame = new CriaConta();
					frame.setLocationRelativeTo(null);
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
	public CriaConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 26, 26));
		contentPane.setForeground(new Color(26, 26, 26));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(26, 26, 26));
		panel.setForeground(new Color(26, 26, 26));
		panel.setBounds(10, 11, 564, 540);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Users\\Aluno\\Downloads\\user (2).png"));
		lblNewLabel.setBounds(202, 11, 150, 150);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(244, 274, 66, 38);
		panel.add(lblNewLabel_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBorder(null);
		textFieldEmail.setBackground(new Color(126, 121, 134));
		textFieldEmail.setBounds(155, 323, 245, 29);
		panel.add(textFieldEmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(240, 185, 75, 38);
		panel.add(lblNewLabel_1_1);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBorder(null);
		textFieldUsuario.setBackground(new Color(126, 121, 134));
		textFieldUsuario.setBounds(155, 234, 245, 29);
		panel.add(textFieldUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(126, 121, 134));
		passwordField.setBounds(155, 412, 245, 29);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Senha");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblNewLabel_1_1_1.setBounds(244, 363, 66, 38);
		panel.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setBounds(215, 473, 124, 38);
		panel.add(btnNewButton);
	}
}
