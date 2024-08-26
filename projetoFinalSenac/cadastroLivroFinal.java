package projetoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class cadastroLivroFinal extends JFrame {
    private JTextField[] textFields;
    private JComboBox<String> comboBoxEstado;

    public cadastroLivroFinal() {
        setTitle("Cadastro de Livros");
        setSize(662, 559);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        String[] labels = {
            "Título:", "Autor(es):", "Editora:", "Ano de Publicação:", "ISBN:", "Edição:", 
            "Número de Páginas:", "Gênero:", "Idioma:", "Data de Aquisição:", "Estado de Conservação:"
        };
        textFields = new JTextField[10]; // Não incluir o campo do JComboBox

        for (int i = 0; i < labels.length - 1; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setBounds(20, 20 + i * 40, 200, 25);
            getContentPane().add(label);

            textFields[i] = new JTextField();
            textFields[i].setBounds(220, 20 + i * 40, 300, 25);
            getContentPane().add(textFields[i]);
        }

        JLabel labelEstado = new JLabel("Estado de Conservação:");
        labelEstado.setBounds(20, 420, 200, 25);
        getContentPane().add(labelEstado);

        comboBoxEstado = new JComboBox<>(new String[] {"Estado","Novo", "Bom", "Usado", "Danificado"});
        comboBoxEstado.setBounds(220, 420, 150, 25);
        getContentPane().add(comboBoxEstado);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(220, 472, 120, 25);
        getContentPane().add(btnCadastrar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(351, 472, 120, 25);
        getContentPane().add(btnVoltar);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarLivro();
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void cadastrarLivro() {
        String[] livro = new String[11];
        for (int i = 0; i < textFields.length; i++) {
            livro[i] = textFields[i].getText();
        }
        livro[10] = comboBoxEstado.getSelectedItem().toString();

        if (salvarLivro(livro)) {
            JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o livro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean salvarLivro(String[] livro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("livros.txt", true))) {
            writer.write(String.join(",", livro));
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new cadastroLivroFinal().setVisible(true));
    }
}
