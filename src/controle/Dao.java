package controle;

import java.sql.SQLException;

import entidades.Pessoa;

public interface Dao {
	public boolean create(Pessoa pessoa) throws SQLException, ClassNotFoundException;
	public Pessoa read(String email) throws SQLException, ClassNotFoundException;
}
