package projetoFinal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
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

import javax.swing.ImageIcon;
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
	public JPanel painel_1;

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
	
	//metodos para para 		
	private void registerTableLeitor(String url, String user, String password) {
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
	
	private void registerTableLivro(String url, String user, String password) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
            connection = DriverManager.getConnection(url, user, password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM cadastrolivro");
            
            while(rs.next()) {
            	String id = rs.getString("id");
            	String titulo = rs.getString("titulo_livro");
            	String autor = rs.getString("autor");
            	String editora = rs.getString("editora");
            	String anoPublicacao = rs.getString("ano_de_publicação");
            	String isbn = rs.getString("isbn");
            	String edicao = rs.getString("edicao");
            	String paginas = rs.getString("paginas");
            	String idioma = rs.getString("idioma");
            	String dataAquisicao = rs.getString("data_de_aquisicao");
            	String estadoConservacao = rs.getString("estado_de_conservacao");
            	model.addRow(new Object[] {id, titulo, autor, editora, anoPublicacao, isbn, edicao, paginas, idioma, dataAquisicao, estadoConservacao});
            }
            
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(connection != null) connection.close(); 
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(contentPane, "Não foi posivel se conectar ao banco de dados", "Aviso!", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}
	}
	
	private void registerTableUsuario(String url, String user, String password) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
            connection = DriverManager.getConnection(url, user, password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM cadastrousuario");
            
            while(rs.next()) {
            	String id = rs.getString("id");
            	String nomeuser = rs.getString("nome");
            	String usuario = rs.getString("usuario");
            	String senha = rs.getString("senha");
            	String nivelAcesso = rs.getString("nivel_de_acesso");
   
            	model.addRow(new Object[] {id, nomeuser, usuario, senha, nivelAcesso});
            }
            
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(contentPane, "Não foi posivel se conectar ao banco de dados", "Aviso!", JOptionPane.WARNING_MESSAGE);
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
	
	private void registerTableEmprestimo(String url, String user, String password) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
            connection = DriverManager.getConnection(url, user, password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM registrodeleitor");
            
            while(rs.next()) {
            	String id = rs.getString("id");
            	String nomeuser = rs.getString("nome");
            	String usuario = rs.getString("cpf");
            	String senha = rs.getString("telefone");
            	String nivelAcesso = rs.getString("email");
   
            	model.addRow(new Object[] {id, nomeuser, usuario, senha, nivelAcesso});
            }
            
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(contentPane, "Não foi posivel se conectar ao banco de dados", "Aviso!", JOptionPane.WARNING_MESSAGE);
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
	
	//metodos para editar as linhas da tabela
	private void editRowLeitor(String url, String user, String password) {
		int selectedRow = table.getSelectedRow();
		if(selectedRow >= 0) {
            String id = model.getValueAt(selectedRow, 0).toString();
            String nome = model.getValueAt(selectedRow, 1).toString();
            String cpf = model.getValueAt(selectedRow, 2).toString();
            String telefone = model.getValueAt(selectedRow, 3).toString();
            String email = model.getValueAt(selectedRow, 4).toString();
            String endereco = model.getValueAt(selectedRow, 5).toString();
            
            EditDialog dialog = new EditDialog(this);
            dialog.leitorEditDialog(id, nome, cpf, telefone, email, endereco);
            dialog.setVisible(true);
            
            if (dialog.isConfirmed()) {
                // Atualize os dados no banco de dados
                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String query = "UPDATE registrodeleitor SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?";
                    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                        pstmt.setString(1, dialog.getNome());
                        pstmt.setString(2, dialog.getCpf());
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
    
	private void editRowLivro(String url, String user, String password) {
		int selectedRow = table.getSelectedRow();
		if(selectedRow >= 0) {
            String id = model.getValueAt(selectedRow, 0).toString();
            String titulo = model.getValueAt(selectedRow, 1).toString();
            String autor = model.getValueAt(selectedRow, 2).toString();
            String anopublicacao = model.getValueAt(selectedRow, 3).toString();
            String isbn = model.getValueAt(selectedRow, 4).toString();
            String edicao = model.getValueAt(selectedRow, 5).toString();
            String numpaginas = model.getValueAt(selectedRow, 6).toString();
            String genero = model.getValueAt(selectedRow, 7).toString();
            String idioma = model.getValueAt(selectedRow, 8).toString();
            String dataaquisicao = model.getValueAt(selectedRow, 9).toString();
            String estadoConservacao = model.getValueAt(selectedRow, 10).toString();
            
            EditDialog dialog = new EditDialog(this);
            dialog.livroEditDialog(id, titulo, autor, anopublicacao, isbn, edicao, numpaginas, genero, idioma, dataaquisicao, estadoConservacao);
            dialog.setVisible(true);
            
            if (dialog.isConfirmed()) {
                // Atualize os dados no banco de dados
                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String query = "UPDATE cadastrolivro SET titulo_livro = ?, autor = ?,"
                    		+ " editora = ?, ano_de_publicação = ?, isbn = ?, edicao = ?,"
                    		+ " paginas = ?, genero = ?, idioma = ?, data_de_aquisicao = ?,"
                    		+ " estado_de_conservacao WHERE id = ?";
                    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                        pstmt.setString(1, dialog.getTitulo());
                        pstmt.setString(2, dialog.getAutor());
                        pstmt.setString(3, dialog.getAnoPublicacao());
                        pstmt.setString(4, dialog.getIsbn());
                        pstmt.setString(5, dialog.getEdicao());
                        pstmt.setString(6, dialog.getNumPaginas());
                        pstmt.setString(7, dialog.getGenero());
                        pstmt.setString(8, dialog.getIdioma());
                        pstmt.setString(9, dialog.getDataAquisicao());
                        pstmt.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // Atualize a tabela
                model.setValueAt(dialog.getTitulo(), selectedRow, 1);
                model.setValueAt(dialog.getAutor(), selectedRow, 2);
                model.setValueAt(dialog.getAnoPublicacao(), selectedRow, 3);
                model.setValueAt(dialog.getIsbn(), selectedRow, 4);
                model.setValueAt(dialog.getEdicao(), selectedRow, 5);
                model.setValueAt(dialog.getNumPaginas(), selectedRow, 6);
                model.setValueAt(dialog.getGenero(), selectedRow, 7);
                model.setValueAt(dialog.getIdioma(), selectedRow, 8);
                model.setValueAt(dialog.getDataAquisicao(), selectedRow, 9);
            }
		}else {
			JOptionPane.showMessageDialog(contentPane, "Nenhuma linha selecionada para edição.", "Aviso!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void editRowUsuario(String url, String user, String password) {
		int selectedRow = table.getSelectedRow();
		if(selectedRow >= 0) {
            String id = model.getValueAt(selectedRow, 0).toString();
            String nome = model.getValueAt(selectedRow, 1).toString();
            String usuario = model.getValueAt(selectedRow, 2).toString();
            String senha = model.getValueAt(selectedRow, 3).toString();
            String nivelAcesso = model.getValueAt(selectedRow, 4).toString();
            
            EditDialog dialog = new EditDialog(this);
            dialog.usuarioEditDialog(id,nome, usuario, senha, nivelAcesso);
            dialog.setVisible(true);
            
            if (dialog.isConfirmed()) {
                // Atualize os dados no banco de dados
                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String query = "UPDATE registrodeleitor SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?";
                    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                        pstmt.setString(1, dialog.getNome());
                        pstmt.setString(2, dialog.getCpf());
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
	
	private void editRowEmprestimo(String url, String user, String password) {

		int selectedRow = table.getSelectedRow();
		if(selectedRow >= 0) {
            String id = model.getValueAt(selectedRow, 0).toString();
            String nome = model.getValueAt(selectedRow, 1).toString();
            String cpf = model.getValueAt(selectedRow, 2).toString();
            String telefone = model.getValueAt(selectedRow, 3).toString();
            String email = model.getValueAt(selectedRow, 4).toString();
            String endereco = model.getValueAt(selectedRow, 5).toString();
            
            EditDialog dialog = new EditDialog(this);
            //dialog.
            //dialog.setVisible(true);
            
            if (dialog.isConfirmed()) {
                // Atualize os dados no banco de dados
                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String query = "UPDATE registrodeleitor SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?";
                    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                        pstmt.setString(1, dialog.getNome());
                        pstmt.setString(2, dialog.getCpf());
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
	
	//metodo para deletar linhas da tabela
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
	
	//metodos para criar as tabelas
	public void tabelaLeitor(JPanel panel_1) {
		
		panel_1.removeAll();
		
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("CPF");
		model.addColumn("Telefone");
		model.addColumn("Email");
		model.addColumn("Endereço");
		
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 45, 859, 372);
		panel_1.add(scrollPane);
		
		registerTableLeitor(url, user, password);
		
		JButton btnNewButtonNovoLeitor = new JButton("Novo leitor");
		btnNewButtonNovoLeitor.setBounds(0, 11, 96, 23);
		panel_1.add(btnNewButtonNovoLeitor);
		btnNewButtonNovoLeitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonNovoLeitor.setBackground(new Color(43, 167, 208));
		btnNewButtonNovoLeitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroLeitor cadastroleitor = new TelaCadastroLeitor(TelaPrincipal.this);
				cadastroleitor.setVisible(true);
				
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		
		JButton btnNewButtonExcluir = new JButton("Excluir\r\n");
		btnNewButtonExcluir.setBackground(new Color(255, 0, 0));
		btnNewButtonExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonExcluir.setBounds(770, 11, 89, 23);
		panel_1.add(btnNewButtonExcluir);
		
		JButton btnNewButtonEdit = new JButton("Editar\r\n");
		btnNewButtonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editRowLeitor(url, user, password);
			}
		});
		btnNewButtonEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonEdit.setBounds(671, 11, 89, 23);
		panel_1.add(btnNewButtonEdit);
		
		contentPane.repaint();
		contentPane.revalidate();
	}
	
	public void tabelaLivro(JPanel panel_1) {

		panel_1.removeAll();
		
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Titulo");
		model.addColumn("Autor(es)");
		model.addColumn("Ano de publicação");
		model.addColumn("ISBN");
		model.addColumn("Edição");
		model.addColumn("Num_Páginas");
		model.addColumn("Gênero");
		model.addColumn("Idioma");;
		model.addColumn("Data_de_aquisição");
		model.addColumn("Estado_de_conservação");
		
		table = new JTable(model);
//		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 45, 859, 372);
		panel_1.add(scrollPane);
		
		registerTableLivro(url, user, password);
		
		JButton btnNewButtonNovoLeitor = new JButton("Novo livro");
		btnNewButtonNovoLeitor.setBounds(0, 11, 96, 23);
		panel_1.add(btnNewButtonNovoLeitor);
		btnNewButtonNovoLeitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonNovoLeitor.setBackground(new Color(43, 167, 208));
		btnNewButtonNovoLeitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroLivro cadastrolivro = new TelaCadastroLivro(TelaPrincipal.this);
				cadastrolivro.setVisible(true);
				
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		
		JButton btnNewButtonExcluir = new JButton("Excluir\r\n");
		btnNewButtonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow(url, user, password);
				
			}
		});
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
	
	public void tabelaUsuario(JPanel panel_1) {

		panel_1.removeAll();
		
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Usúario");
		model.addColumn("Senha");
		model.addColumn("Nivel de acesso");
		
		
		table = new JTable(model);
//		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 45, 859, 372);
		panel_1.add(scrollPane);
		
		registerTableUsuario(url, user, password);
		
		JButton btnNewButtonNovoLeitor = new JButton("Novo Usuario");
		btnNewButtonNovoLeitor.setBounds(0, 11, 96, 23);
		panel_1.add(btnNewButtonNovoLeitor);
		btnNewButtonNovoLeitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonNovoLeitor.setBackground(new Color(43, 167, 208));
		btnNewButtonNovoLeitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroLivro cadastrolivro = new TelaCadastroLivro(TelaPrincipal.this);
				cadastrolivro.setVisible(true);
				
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		
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
	
	public void tabelaEmprestimo(JPanel panel_1) {

		panel_1.removeAll();
		
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Livro");
		model.addColumn("Autor");
		model.addColumn("Estoque");
		model.addColumn("Leitor");
		
		
		table = new JTable(model);
//		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 45, 859, 372);
		panel_1.add(scrollPane);
		
		registerTableUsuario(url, user, password);
		
		JButton btnNewButtonNovoLeitor = new JButton("Novo Usuario");
		btnNewButtonNovoLeitor.setBounds(0, 11, 96, 23);
		panel_1.add(btnNewButtonNovoLeitor);
		btnNewButtonNovoLeitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonNovoLeitor.setBackground(new Color(43, 167, 208));
		btnNewButtonNovoLeitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroLivro cadastrolivro = new TelaCadastroLivro(TelaPrincipal.this);
				cadastrolivro.setVisible(true);
				
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/icones/logobiblioteca500x500.png")));
		setTitle("Sistema biblioteca - tela principal\r\n");
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 216, 216));
		panel_1.setBounds(185, 133, 859, 417);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(8, 128, 153, 14);
		panel.add(separator);
		
		JButton btnNewButton = new JButton("Cadastro de usúario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaUsuario(panel_1);
				
			}
		});
		btnNewButton.setBounds(new Rectangle(8, 153, 153, 19));
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 145, 145)));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastro de livro\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaLivro(panel_1);
			}
		});
		btnNewButton_1.setBounds(new Rectangle(8, 190, 153, 19));
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 145, 145)));
		btnNewButton_1.setAlignmentX(0.5f);
		panel.add(btnNewButton_1);
		JButton btnNewButton_1_1 = new JButton("Cadastro de leitor\r\n\r\n");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaLeitor(panel_1);
			}
		});
		btnNewButton_1_1.setBounds(new Rectangle(8, 227, 153, 19));
		btnNewButton_1_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 145, 145)));
		btnNewButton_1_1.setAlignmentX(0.5f);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Cadastro de emprestimo");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaEmprestimo(panel_1);
			}
		});
		btnNewButton_1_2.setBounds(new Rectangle(8, 264, 153, 19));
		btnNewButton_1_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(0, 145, 145)));
		btnNewButton_1_2.setAlignmentX(0.5f);
		panel.setLayout(null);
		panel.add(btnNewButton_1_2);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Painel Principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(34, 98, 112, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/logobiblioteca82x82.png")));
		lblNewLabel_1.setBounds(43, 8, 82, 82);
		panel.add(lblNewLabel_1);
	
		
		
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
	//public void atualizarTabela() {
	//	TelaPrincipal tel = new TelaPrincipal();
	//	panel_1.setText(tel.registerTableUsuario(url,user,password));
//	}
}
