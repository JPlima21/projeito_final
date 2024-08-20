package projetoFinal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void tabelaLeitor() {
		JButton btnNewButton_2 = new JButton("Novo leitor");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBackground(new Color(43, 167, 208));
		btnNewButton_2.setBounds(192, 110, 102, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 194, 854, 356);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Email", "Telefone", "Endere\u00E7o"
			}
		));
		
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setMinimumSize(new Dimension(1050, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 216, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 175, 561);
		panel.setBackground(new Color(43, 167, 208));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 153, 14);
		
		JButton btnNewButton = new JButton("Cadastro de usúario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaLeitor();
				
			}
		});
		btnNewButton.setBounds(new Rectangle(10, 78, 153, 19));
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 145, 145)));
		
		JButton btnNewButton_1 = new JButton("Cadastro de livro\r\n");
		btnNewButton_1.setBounds(new Rectangle(10, 115, 153, 19));
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 145, 145)));
		btnNewButton_1.setAlignmentX(0.5f);
		
		JButton btnNewButton_1_1 = new JButton("Cadastro de leitor\r\n\r\n");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1_1.setBounds(new Rectangle(10, 152, 153, 19));
		btnNewButton_1_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 145, 145)));
		btnNewButton_1_1.setAlignmentX(0.5f);
		
		JButton btnNewButton_1_2 = new JButton("Cadastro de emprestimo");
		btnNewButton_1_2.setBounds(new Rectangle(10, 189, 153, 19));
		btnNewButton_1_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 145, 145)));
		btnNewButton_1_2.setAlignmentX(0.5f);
		panel.setLayout(null);
		panel.add(separator);
		panel.add(btnNewButton);
		panel.add(btnNewButton_1);
		panel.add(btnNewButton_1_1);
		panel.add(btnNewButton_1_2);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Painel Principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 23, 101, 14);
		panel.add(lblNewLabel);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
