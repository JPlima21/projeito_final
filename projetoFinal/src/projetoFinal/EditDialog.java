package projetoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystemAlreadyExistsException;

public class EditDialog extends JDialog {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField telefoneField;
    private JTextField emailField;
    private JTextField enderecoField;
    
    private boolean confirmed;

    public EditDialog(JFrame parent, String id, String nome, String cpf, String telefone, String email, String endereco) {
        super(parent, "Editar Dados", true);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nome:"));
        nomeField = new JTextField(nome);
        add(nomeField);

        add(new JLabel("CPF:"));
        cpfField = new JTextField(cpf);
        add(cpfField);

        add(new JLabel("Endereço:"));
        enderecoField = new JTextField(endereco);
        add(enderecoField);

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
        return nomeField.getText();
    }

    public String getCpf() {
        return cpfField.getText();
    }
    
    public String getTelefone() {
    	return telefoneField.getText();
    }
    
    public String getEmail() {
    	return emailField.getText();
    }

    public String getEndereco() {
        return enderecoField.getText();
    }
}