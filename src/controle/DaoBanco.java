package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import banco.ConFactory;
import entidades.Pessoa;

public class DaoBanco implements Dao {
	private ArrayList<Pessoa> list() throws ClassNotFoundException, SQLException{
		ArrayList<Pessoa> lista = new ArrayList<>();
		Connection connection = (Connection) new ConFactory().getConnection();
		String sql = "select * from usuario";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String email = rs.getString("email");
			String nome = rs.getString("nome");
			String cidade = rs.getString("cidade");
			String profissao = rs.getString("profissao");
			Date nascimento = rs.getDate("nascimento");
			Instant instant = Instant.ofEpochMilli(nascimento.getTime());
	        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
			String sexo = rs.getString("sexo");
			String foto = rs.getString("foto");
			String senha = rs.getString("senha");
			Pessoa pessoa = new Pessoa(email, nome, cidade, sexo, senha, foto, profissao, localDate);
			lista.add(pessoa);
		}
		stmt.close();
		connection.close();
		return lista;
	}
	@Override
	public boolean create(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		ArrayList<Pessoa> lista = list();
		for(Pessoa p : lista) {
			if(p.getEmail().equals(pessoa.getEmail())) {
				return false;
			}
		}
		Connection connection = (Connection) (new ConFactory()).getConnection();
		String sql = "insert into usuario (email, nome, cidade, profissao, nascimento, sexo, foto, senha) values (?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, pessoa.getEmail());
		stmt.setString(2, pessoa.getNome());
		stmt.setString(3, pessoa.getCidade());
		stmt.setString(4, pessoa.getProfissao());
		stmt.setDate(5, java.sql.Date.valueOf(pessoa.getNascimento()));
		stmt.setString(6, pessoa.getSexo());
		stmt.setString(7, pessoa.getFoto());
		stmt.setString(8, pessoa.getSenha());
		boolean resultado = !stmt.execute();
		stmt.close();
		connection.close();
		return resultado;
	}

	@Override
	public Pessoa read(String email) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = (Connection) (new ConFactory()).getConnection();
		String sql = "select * from usuario u where u.email = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, email);
		return null;
	}
	
}
