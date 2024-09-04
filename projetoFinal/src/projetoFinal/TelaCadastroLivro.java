package projetoFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class TelaCadastroLivro extends JDialog {
	JFormattedTextField formattedTextFieldTitulo;
	JFormattedTextField formattedTextFieldAutor;
	JFormattedTextField formattedTextFieldAnoPublicacao;
	JFormattedTextField formattedTextFieldIsbn;
	JFormattedTextField formattedTextFieldEdicao;
	JFormattedTextField formattedTextFieldNumPaginas;
	JFormattedTextField formattedTextFieldGenero;
	JFormattedTextField formattedTextFieldIdioma;
	JFormattedTextField formattedTextFieldDataAquisicao;
	JFormattedTextField formattedTextFieldEstadoConservacao;
	JFormattedTextField formattedTextFieldEditora;
	public JPanel teste;
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	public JPanel panel_1;
	 private JTable table3;
	    private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroLivro dialog = new TelaCadastroLivro(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public TelaCadastroLivro() {
	        // Inicialize panel_1
	        panel_1 = new JPanel();
	        panel_1.setLayout(null); // Defina o layout como null ou outro layout manager adequado
	        
	        // Inicialize outros componentes ou configurações se necessário
	    }
	String url2 = "jdbc:postgresql://localhost:5432/Projeto_Biblioteca";
	String user = "postgres";
	String password = "postgres";
	
	 private Connection conectar() throws SQLException {
	        // Substitua os valores abaixo pelos detalhes do seu banco de dados
		 String url = "jdbc:postgresql://localhost:5432/Projeto_Biblioteca";
			String usuario = "postgres";
			String senha = "postgres";
	        return DriverManager.getConnection(url, usuario, senha);
	    }
	
	static StringBuilder camposVazios = new StringBuilder();

	private static boolean verificarCamposVazios(JFormattedTextField... campos) {
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
	
	public TelaCadastroLivro(JFrame parent) {
		super(parent, "Tela cadastro leitor", true);
		setLocationRelativeTo(parent);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 311);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Titulo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 9, 42, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblAutores = new JLabel("Autor(es)");
			lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAutores.setBounds(10, 36, 61, 17);
			contentPanel.add(lblAutores);
		}
		{
			JLabel lblAnoDePublicao = new JLabel("Ano de publicação");
			lblAnoDePublicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAnoDePublicao.setBounds(10, 90, 115, 17);
			contentPanel.add(lblAnoDePublicao);
		}
		{
			JLabel lblIsbn = new JLabel("ISBN");
			lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIsbn.setBounds(10, 117, 61, 17);
			contentPanel.add(lblIsbn);
		}
		{
			JLabel lblEdio = new JLabel("Edição");
			lblEdio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEdio.setBounds(10, 144, 61, 17);
			contentPanel.add(lblEdio);
		}
		{
			JLabel lblNmeroDePaginas = new JLabel("Número de paginas");
			lblNmeroDePaginas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNmeroDePaginas.setBounds(10, 171, 129, 17);
			contentPanel.add(lblNmeroDePaginas);
		}
		{
			JLabel lblGnero = new JLabel("Gênero");
			lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGnero.setBounds(10, 198, 61, 17);
			contentPanel.add(lblGnero);
		}
		{
			JLabel lblIdioma = new JLabel("Idioma");
			lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIdioma.setBounds(10, 225, 61, 17);
			contentPanel.add(lblIdioma);
		}
		{
			JLabel lblDataDeAquisio = new JLabel("Data de aquisição");
			lblDataDeAquisio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDataDeAquisio.setBounds(10, 251, 115, 17);
			contentPanel.add(lblDataDeAquisio);
		}
		{
			JLabel lblEstadoDeConservao = new JLabel("Estado de conservação");
			lblEstadoDeConservao.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEstadoDeConservao.setBounds(10, 279, 144, 17);
			contentPanel.add(lblEstadoDeConservao);
		}
		{
			JLabel lblEditora = new JLabel("Editora");
			lblEditora.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEditora.setBounds(10, 63, 61, 17);
			contentPanel.add(lblEditora);
		}
		
		
		try {
			MaskFormatter maskAnoPublic, maskIsbn, maskAquisicao;
			maskAnoPublic = new MaskFormatter("####-##-##");
			maskAnoPublic.setPlaceholderCharacter('_');
			maskIsbn = new MaskFormatter("###-#-###-####-#");
			maskIsbn.setPlaceholderCharacter('_');
			maskAquisicao = new MaskFormatter("####-##-##");
			maskAquisicao.setPlaceholderCharacter('_');
		
		
		
		formattedTextFieldTitulo = new JFormattedTextField();
		formattedTextFieldTitulo.setName("Titulo");
		formattedTextFieldTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldTitulo.setBounds(163, 8, 230, 19);
		contentPanel.add(formattedTextFieldTitulo);
		
		formattedTextFieldAutor = new JFormattedTextField();
		formattedTextFieldAutor.setName("Autor");
		formattedTextFieldAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldAutor.setBounds(163, 35, 230, 19);
		contentPanel.add(formattedTextFieldAutor);
		
		formattedTextFieldAnoPublicacao = new JFormattedTextField(maskAnoPublic);
		formattedTextFieldAnoPublicacao.setName("Ano de publição");
		formattedTextFieldAnoPublicacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldAnoPublicacao.setBounds(163, 89, 230, 19);
		contentPanel.add(formattedTextFieldAnoPublicacao);
		
		formattedTextFieldIsbn = new JFormattedTextField(maskIsbn);
		formattedTextFieldIsbn.setName("Isbn");
		formattedTextFieldIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldIsbn.setBounds(163, 116, 230, 19);
		contentPanel.add(formattedTextFieldIsbn);
		
		formattedTextFieldEdicao = new JFormattedTextField();
		formattedTextFieldEdicao.setName("Edição");
		formattedTextFieldEdicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldEdicao.setBounds(163, 143, 230, 19);
		contentPanel.add(formattedTextFieldEdicao);
		
		formattedTextFieldNumPaginas = new JFormattedTextField();
		formattedTextFieldNumPaginas.setName("Nùmero de paginas");
		formattedTextFieldNumPaginas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldNumPaginas.setBounds(163, 170, 230, 19);
		contentPanel.add(formattedTextFieldNumPaginas);
		
		 formattedTextFieldGenero = new JFormattedTextField();
		formattedTextFieldGenero.setName("Gênero");
		formattedTextFieldGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldGenero.setBounds(163, 197, 230, 19);
		contentPanel.add(formattedTextFieldGenero);
		
		 formattedTextFieldIdioma = new JFormattedTextField();
		formattedTextFieldIdioma.setName("Idioma");
		formattedTextFieldIdioma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldIdioma.setBounds(163, 224, 230, 19);
		contentPanel.add(formattedTextFieldIdioma);
		
		 formattedTextFieldDataAquisicao = new JFormattedTextField(maskAquisicao);
		formattedTextFieldDataAquisicao.setName("Data de aquisicao");
		formattedTextFieldDataAquisicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldDataAquisicao.setBounds(163, 251, 230, 19);
		contentPanel.add(formattedTextFieldDataAquisicao);
		
		 formattedTextFieldEstadoConservacao = new JFormattedTextField();
		formattedTextFieldEstadoConservacao.setName("Estado de Conservacao");
		formattedTextFieldEstadoConservacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldEstadoConservacao.setBounds(163, 278, 230, 19);
		contentPanel.add(formattedTextFieldEstadoConservacao);
		
		formattedTextFieldEditora = new JFormattedTextField();
		formattedTextFieldEditora.setName("Editora");
		formattedTextFieldEditora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldEditora.setBounds(163, 62, 230, 19);
		contentPanel.add(formattedTextFieldEditora);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 309, 436, 44);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						camposVazios.setLength(0);
						
						boolean verificacao = verificarCamposVazios(formattedTextFieldAnoPublicacao, formattedTextFieldAutor, formattedTextFieldDataAquisicao,
																	formattedTextFieldEdicao, formattedTextFieldEstadoConservacao, formattedTextFieldGenero,
																	formattedTextFieldIdioma, formattedTextFieldIsbn, formattedTextFieldNumPaginas, formattedTextFieldTitulo);
						if(verificacao == true) {
							salvarDados();
//							JOptionPane.showMessageDialog(contentPanel, "Informações validas!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
						//	TelaPrincipal tel=new TelaPrincipal();
							//tel.tabelaLivro(panel_1);
							TelaPrincipal tela = new TelaPrincipal();
							tela.tabelaLivro(tela.panel_table);
							
						}else {
							JOptionPane.showMessageDialog(contentPanel, "Por favor verifique o campo(s):" + camposVazios, "Aviso!", JOptionPane.INFORMATION_MESSAGE);
							
						}
					}
				});
				okButton.setBounds(105, 5, 60, 29);
				okButton.setBorder(new LineBorder(new Color(0, 255, 0)));
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBounds(270, 5, 60, 29);
				cancelButton.setBorder(new LineBorder(new Color(255, 0, 0)));
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		  }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	 public void TabelaPanel() {
	        setLayout(new BorderLayout());

	        // Cria o modelo da tabela
	        tableModel = new DefaultTableModel(new Object[]{"Dados"}, 0);
	        table3 = new JTable(tableModel);

	        // Adiciona a tabela a um JScrollPane
	        JScrollPane scrollPane = new JScrollPane(table);
	        add(scrollPane, BorderLayout.CENTER);
	    }

	    public void adicionarDado(String dado) {
	        tableModel.addRow(new Object[]{dado});
	    }
	private void salvarDados() {
        try (Connection conn = conectar()) {
            String sql = "INSERT INTO cadastrolivro (titulo_livro, autor,editora, ano_de_publicacao, isbn, edicao, paginas, genero, idioma, data_de_aquisicao, estado_de_consevacao) VALUES (?, ?,?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Preencher o PreparedStatement com os valores dos campos
                pstmt.setString(1, formattedTextFieldTitulo.getText().trim());
                pstmt.setString(2, formattedTextFieldAutor.getText().trim());
                pstmt.setString(3, formattedTextFieldEditora.getText().trim());
                //pstmt.setDate(3, new java.sql.Date(((java.util.Date) formattedTextFieldAnoPublicacao.getValue()).getTime()));
                pstmt.setString(4, formattedTextFieldAnoPublicacao.getText().trim());
                pstmt.setString(5, formattedTextFieldIsbn.getText().trim());
                pstmt.setString(6, formattedTextFieldEdicao.getText().trim());
                pstmt.setInt(7, Integer.parseInt(formattedTextFieldNumPaginas.getText().trim()));
                pstmt.setString(8, formattedTextFieldGenero.getText().trim());
                pstmt.setString(9, formattedTextFieldIdioma.getText().trim());
                //pstmt.setDate(9, new java.sql.Date(((java.util.Date) formattedTextFieldDataAquisicao.getValue()).getTime()));
                pstmt.setString(10,formattedTextFieldDataAquisicao.getText().trim());
                pstmt.setString(11, formattedTextFieldEstadoConservacao.getText().trim());

                // Executar o comando de inserção
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(contentPanel, "Informações salvas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(contentPanel, "Erro ao salvar informações: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
