package Area51;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class testeBancoDeDados extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Tabela Postgresql");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600,500);
		
		//Cria modelo de tabela
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Idade");
		model.addColumn("Endereço");
		System.out.println("Criação da tabela concluida");
		
		//Cria a tabela
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		frame.add(scrollpane);
		
		//Configurando a conexão com o Postgresql
		String url = "jdbc:postgresql://localhost:5432/Registro_de_leitor";
		String user = "postgres";
		String password = "postgres";
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("conexão com o database concluida");
		
		try {
//			Class.forName("org.postgresql.Driver");
			
			connection = DriverManager.getConnection(url, user, password);
			
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM registrodeleitor");
			
			while(rs.next()) {
				String id = rs.getString("id");
				String nome = rs.getString("nome");
				String idade = rs.getString("idade");
				String endereço = rs.getString("endereco");
				model.addRow(new Object[] {id, nome, idade, endereço});
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(connection != null) stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			frame.setVisible(true);
		}
		
	}
}
