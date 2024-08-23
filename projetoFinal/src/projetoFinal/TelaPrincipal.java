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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Configuração da conexão com o PostgreSQL
			String url = "jdbc:postgresql://localhost:5432/Projeto_Biblioteca";
			String user = "postgres";
			String password = "postgres";
			
	private void registerTable(String url, String user, String password) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
            connection = DriverManager.getConnection(url, user, password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM registrodeleitor");
            
            while(rs.next()) {
            	String id = rs.getString("id");
            	String nome = rs.getString("nome");
            	String cpf = rs.getString("cpf");
            	String telefone = rs.getString("telefone");
            	String email = rs.getString("email");
            	String endereco = rs.getString("endereco");
            	model.addRow(new Object[] {id, nome, cpf, telefone, email, endereco});
            }
            
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(connection != null) connection.close(); 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void editRow(String url, String user, String password) {
		int selectedRow = table.getSelectedRow();
		if(selectedRow >= 0) {
            String id = model.getValueAt(selectedRow, 0).toString();
            String nome = model.getValueAt(selectedRow, 1).toString();
            String cpf = model.getValueAt(selectedRow, 2).toString();
            String telefone = model.getValueAt(selectedRow, 3).toString();
            String email = model.getValueAt(selectedRow, 4).toString();
            String endereco = model.getValueAt(selectedRow, 5).toString();
            
            EditDialog dialog = new EditDialog(this, id, nome, cpf, telefone, email, endereco);
            dialog.setVisible(true);
            
            if (dialog.isConfirmed()) {
                // Atualize os dados no banco de dados
                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String query = "UPDATE registrodeleitor SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?";
                    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                        pstmt.setString(1, dialog.getNome());
                        pstmt.setString(2,dialog.getCpf());
                        pstmt.setString(3, dialog.getTelefone());
                        pstmt.setString(4, dialog.getEmail());
                        pstmt.setString(5, dialog.getEndereco());
                        pstmt.setString(6, id);
                        pstmt.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // Atualize a tabela
                model.setValueAt(dialog.getNome(), selectedRow, 1);
                model.setValueAt(dialog.getCpf(), selectedRow, 2);
                model.setValueAt(dialog.getTelefone(), selectedRow, 3);
                model.setValueAt(dialog.getEmail(), selectedRow, 4);
                model.setValueAt(dialog.getEndereco(), selectedRow, 5);
            }
		}else {
			JOptionPane.showMessageDialog(contentPane, "Nenhuma linha selecionada para edição.", "Aviso!", JOptionPane.WARNING_MESSAGE);
		}
	}
       
	private void deleteRow(String url, String user, String password) {
    	int selectedRow = table.getSelectedRow();
	    if (selectedRow >= 0) {
            String id = model.getValueAt(selectedRow, 0).toString();
            
         // Exclua os dados do banco de dados
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String query = "DELETE FROM registrodeleitor WHERE id = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                    pstmt.setInt(1, Integer.parseInt(id));
                    pstmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Atualize a tabela
            model.removeRow(selectedRow);
        }else {
        	JOptionPane.showMessageDialog(contentPane, "Nenhuma linha selecionada para edição.", "Aviso!", JOptionPane.WARNING_MESSAGE);
        }
	    
	 }           
	
	public void tabelaLeitor() {
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 216, 216));
		panel_1.setBounds(185, 133, 859, 417);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("CPF");
		model.addColumn("Telefone");
		model.addColumn("Email");
		model.addColumn("Endereço");
		
		table = new JTable(model);
//		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 45, 859, 372);
		panel_1.add(scrollPane);
		
		registerTable(url, user, password);
		
		JButton btnNewButtonNovoLeitor = new JButton("Novo leitor");
		btnNewButtonNovoLeitor.setBounds(0, 11, 93, 23);
		panel_1.add(btnNewButtonNovoLeitor);
		btnNewButtonNovoLeitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonNovoLeitor.setBackground(new Color(43, 167, 208));
		
		JButton btnNewButtonExcluir = new JButton("Excluir\r\n");
		btnNewButtonExcluir.setBackground(new Color(255, 0, 0));
		btnNewButtonExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonExcluir.setBounds(770, 11, 89, 23);
		panel_1.add(btnNewButtonExcluir);
		
		JButton btnNewButtonEdit = new JButton("Editar\r\n");
		btnNewButtonEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonEdit.setBounds(671, 11, 89, 23);
		panel_1.add(btnNewButtonEdit);
		
		contentPane.repaint();
		contentPane.revalidate();
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
				tabelaLeitor();
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
