package projetoFinal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TelaCadastroLivro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroLivro dialog = new TelaCadastroLivro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastroLivro() {
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField.setBounds(163, 8, 230, 19);
		contentPanel.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_1.setBounds(163, 37, 230, 19);
		contentPanel.add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_2.setBounds(163, 62, 230, 19);
		contentPanel.add(formattedTextField_2);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_3.setBounds(163, 89, 230, 19);
		contentPanel.add(formattedTextField_3);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_4.setBounds(163, 116, 230, 19);
		contentPanel.add(formattedTextField_4);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_5.setBounds(163, 143, 230, 19);
		contentPanel.add(formattedTextField_5);
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_6.setBounds(163, 170, 230, 19);
		contentPanel.add(formattedTextField_6);
		
		JFormattedTextField formattedTextField_7 = new JFormattedTextField();
		formattedTextField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_7.setBounds(163, 197, 230, 19);
		contentPanel.add(formattedTextField_7);
		
		JFormattedTextField formattedTextField_8 = new JFormattedTextField();
		formattedTextField_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_8.setBounds(163, 224, 230, 19);
		contentPanel.add(formattedTextField_8);
		
		JFormattedTextField formattedTextField_9 = new JFormattedTextField();
		formattedTextField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_9.setBounds(163, 254, 230, 19);
		contentPanel.add(formattedTextField_9);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 309, 436, 44);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Salvar");
				okButton.setBounds(154, 5, 60, 29);
				okButton.setBorder(new LineBorder(new Color(0, 255, 0)));
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(219, 5, 60, 29);
				cancelButton.setBorder(new LineBorder(new Color(255, 0, 0)));
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
