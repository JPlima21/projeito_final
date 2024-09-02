package projetoFinal;

import java.awt.Color;
import java.awt.Font;

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

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaCadastroLivro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

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
		contentPanel.setBounds(0, 0, 436, 287);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Titulo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 10, 42, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblAutores = new JLabel("Autor(es)");
			lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAutores.setBounds(10, 37, 61, 17);
			contentPanel.add(lblAutores);
		}
		{
			JLabel lblAnoDePublicao = new JLabel("Ano de publicação");
			lblAnoDePublicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAnoDePublicao.setBounds(10, 64, 115, 17);
			contentPanel.add(lblAnoDePublicao);
		}
		{
			JLabel lblIsbn = new JLabel("ISBN");
			lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIsbn.setBounds(10, 91, 61, 17);
			contentPanel.add(lblIsbn);
		}
		{
			JLabel lblEdio = new JLabel("Edição");
			lblEdio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEdio.setBounds(10, 118, 61, 17);
			contentPanel.add(lblEdio);
		}
		{
			JLabel lblNmeroDePaginas = new JLabel("Número de paginas");
			lblNmeroDePaginas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNmeroDePaginas.setBounds(10, 145, 129, 17);
			contentPanel.add(lblNmeroDePaginas);
		}
		{
			JLabel lblGnero = new JLabel("Gênero");
			lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGnero.setBounds(10, 172, 61, 17);
			contentPanel.add(lblGnero);
		}
		{
			JLabel lblIdioma = new JLabel("Idioma");
			lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIdioma.setBounds(10, 199, 61, 17);
			contentPanel.add(lblIdioma);
		}
		{
			JLabel lblDataDeAquisio = new JLabel("Data de aquisição");
			lblDataDeAquisio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDataDeAquisio.setBounds(10, 226, 115, 17);
			contentPanel.add(lblDataDeAquisio);
		}
		{
			JLabel lblEstadoDeConservao = new JLabel("Estado de conservação");
			lblEstadoDeConservao.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEstadoDeConservao.setBounds(10, 253, 144, 17);
			contentPanel.add(lblEstadoDeConservao);
		}
		
		
		try {
			MaskFormatter maskAnoPublic, maskIsbn, maskAquisicao;
			maskAnoPublic = new MaskFormatter("##/##/####");
			maskAnoPublic.setPlaceholderCharacter('_');
			maskIsbn = new MaskFormatter("###-#-###-####-#");
			maskIsbn.setPlaceholderCharacter('_');
			maskAquisicao = new MaskFormatter("##/##/####");
			maskAquisicao.setPlaceholderCharacter('_');
		
		
		
		JFormattedTextField formattedTextFieldTitulo = new JFormattedTextField();
		formattedTextFieldTitulo.setName("Titulo");
		formattedTextFieldTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldTitulo.setBounds(163, 8, 230, 19);
		contentPanel.add(formattedTextFieldTitulo);
		
		JFormattedTextField formattedTextFieldAutor = new JFormattedTextField();
		formattedTextFieldAutor.setName("Autor");
		formattedTextFieldAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldAutor.setBounds(163, 37, 230, 19);
		contentPanel.add(formattedTextFieldAutor);
		
		JFormattedTextField formattedTextFieldAnoPublicacao = new JFormattedTextField(maskAnoPublic);
		formattedTextFieldAnoPublicacao.setName("Ano de publição");
		formattedTextFieldAnoPublicacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldAnoPublicacao.setBounds(163, 62, 230, 19);
		contentPanel.add(formattedTextFieldAnoPublicacao);
		
		JFormattedTextField formattedTextFieldIsbn = new JFormattedTextField(maskIsbn);
		formattedTextFieldIsbn.setName("Isbn");
		formattedTextFieldIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldIsbn.setBounds(163, 89, 230, 19);
		contentPanel.add(formattedTextFieldIsbn);
		
		JFormattedTextField formattedTextFieldEdicao = new JFormattedTextField();
		formattedTextFieldEdicao.setName("Edição");
		formattedTextFieldEdicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldEdicao.setBounds(163, 116, 230, 19);
		contentPanel.add(formattedTextFieldEdicao);
		
		JFormattedTextField formattedTextFieldNumPaginas = new JFormattedTextField();
		formattedTextFieldNumPaginas.setName("Nùmero de paginas");
		formattedTextFieldNumPaginas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldNumPaginas.setBounds(163, 143, 230, 19);
		contentPanel.add(formattedTextFieldNumPaginas);
		
		JFormattedTextField formattedTextFieldGenero = new JFormattedTextField();
		formattedTextFieldGenero.setName("Gênero");
		formattedTextFieldGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldGenero.setBounds(163, 170, 230, 19);
		contentPanel.add(formattedTextFieldGenero);
		
		JFormattedTextField formattedTextFieldIdioma = new JFormattedTextField();
		formattedTextFieldIdioma.setName("Idioma");
		formattedTextFieldIdioma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldIdioma.setBounds(163, 197, 230, 19);
		contentPanel.add(formattedTextFieldIdioma);
		
		JFormattedTextField formattedTextFieldDataAquisicao = new JFormattedTextField(maskAquisicao);
		formattedTextFieldDataAquisicao.setName("Data de aquisicao");
		formattedTextFieldDataAquisicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldDataAquisicao.setBounds(163, 224, 230, 19);
		contentPanel.add(formattedTextFieldDataAquisicao);
		
		JFormattedTextField formattedTextFieldEstadoConservacao = new JFormattedTextField();
		formattedTextFieldEstadoConservacao.setName("Estado de Conservacao");
		formattedTextFieldEstadoConservacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldEstadoConservacao.setBounds(163, 254, 230, 19);
		contentPanel.add(formattedTextFieldEstadoConservacao);
		
		
		
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
							JOptionPane.showMessageDialog(contentPanel, "Informações validas!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
							
						}else {
							JOptionPane.showMessageDialog(contentPanel, "Por favor verifique o campo(s):" + camposVazios, "Aviso!", JOptionPane.INFORMATION_MESSAGE);
							
						}
					}
				});
				okButton.setBounds(154, 5, 60, 29);
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
				cancelButton.setBounds(219, 5, 60, 29);
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
}
