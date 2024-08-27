package projetoFinal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditDialog extends JDialog {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField telefoneField;
    private JTextField emailField;
    private JTextField enderecoField;
    
    private JTextField tituloField;
    private JTextField autorField;
    private JTextField anoPublicacaoField;
    private JTextField isbnField;
    private JTextField edicaoField;
    private JTextField numPaginasField;
    private JTextField generoField;
    private JTextField idiomaField;
    private JTextField dataAquisicaoField;
    private JTextField estadoDeConservaçãoField;
    
    private boolean confirmed;

    public EditDialog(JFrame parent, String id, String nome, String cpf, String telefone, String email, String endereco) {
        super(parent, "Editar Dados", true);
        setLayout(new GridLayout(0, 2));
        
        
        if (nome != null) {
            add(new JLabel("Nome:"));
            nomeField = new JTextField(nome);
            add(nomeField);
        }

        if (cpf != null) {
            add(new JLabel("CPF:"));
            cpfField = new JTextField(cpf);
            add(cpfField);
        }
        
        if (telefone != null) {
            add(new JLabel("Telefone:"));
            telefoneField = new JTextField(telefone);
            add(telefoneField);
        }

        if (email != null) {
            add(new JLabel("Email:"));
            emailField = new JTextField(email);
            add(emailField);
        }

        if (endereco != null) {
            add(new JLabel("Endereço:"));
            enderecoField = new JTextField(endereco);
            add(enderecoField);
        }

        JButton confirmButton = new JButton("Confirmar");
        JButton cancelButton = new JButton("Cancelar");
        add(confirmButton);
        add(cancelButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = true;
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = false;
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(parent);
    }
        
        public EditDialog(JFrame parent, String id, String titulo, String autor, String anoPublicacao, String isbn, String edicao, String numPaginas, String genero, String idioma, String dataAquisicao, String estadoDeConservacao) {
            super(parent, "Editar Dados do Livro", true);
            setLayout(new GridLayout(10, 2));
            
            if (titulo != null) {
                add(new JLabel("Título:"));
                tituloField = new JTextField(titulo);
                add(tituloField);
            }

            if (autor != null) {
                add(new JLabel("Autor(es):"));
                autorField = new JTextField(autor);
                add(autorField);
            }

            if (anoPublicacao != null) {
                add(new JLabel("Ano de Publicação:"));
                anoPublicacaoField = new JTextField(anoPublicacao);
                add(anoPublicacaoField);
            }

            if (isbn != null) {
                add(new JLabel("ISBN:"));
                isbnField = new JTextField(isbn);
                add(isbnField);
            }

            if (edicao != null) {
                add(new JLabel("Edição:"));
                edicaoField = new JTextField(edicao);
                add(edicaoField);
            }

            if (numPaginas != null) {
                add(new JLabel("Número de Páginas:"));
                numPaginasField = new JTextField(numPaginas);
                add(numPaginasField);
            }

            if (genero != null) {
                add(new JLabel("Gênero:"));
                generoField = new JTextField(genero);
                add(generoField);
            }

            if (idioma != null) {
                add(new JLabel("Idioma:"));
                idiomaField = new JTextField(idioma);
                add(idiomaField);
            }

            if (dataAquisicao != null) {
                add(new JLabel("Data de Aquisição:"));
                dataAquisicaoField = new JTextField(dataAquisicao);
                add(dataAquisicaoField);
            }

            JButton confirmButton = new JButton("Confirmar");
            JButton cancelButton = new JButton("Cancelar");
            add(confirmButton);
            add(cancelButton);

            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    confirmed = true;
                    dispose();
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    confirmed = false;
                    dispose();
                }
            });

            pack();
            setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getNome() {
        return nomeField != null ? nomeField.getText() : null;
    }

    public String getCpf() {
        return cpfField != null ? cpfField.getText() : null;
    }
    
    public String getTelefone() {
        return telefoneField != null ? telefoneField.getText() : null;
    }
    
    public String getEmail() {
        return emailField != null ? emailField.getText() : null;
    }

    public String getEndereco() {
        return enderecoField != null ? enderecoField.getText() : null;
    }
    
    public String getTitulo() {
        return tituloField != null ? tituloField.getText() : null;
    }

    public String getAutor() {
        return autorField != null ? autorField.getText() : null;
    }

    public String getAnoPublicacao() {
        return anoPublicacaoField != null ? anoPublicacaoField.getText() : null;
    }

    public String getIsbn() {
        return isbnField != null ? isbnField.getText() : null;
    }

    public String getEdicao() {
        return edicaoField != null ? edicaoField.getText() : null;
    }

    public String getNumPaginas() {
        return numPaginasField != null ? numPaginasField.getText() : null;
    }

    public String getGenero() {
        return generoField != null ? generoField.getText() : null;
    }

    public String getIdioma() {
        return idiomaField != null ? idiomaField.getText() : null;
    }

    public String getDataAquisicao() {
        return dataAquisicaoField != null ? dataAquisicaoField.getText() : null;
    }
    
    public String getEstadoConservação() {
    	return estadoDeConservaçãoField != null ? estadoDeConservaçãoField.getText() : null;
    }
}