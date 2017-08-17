package controle;

import java.sql.SQLException;

import entidades.Pessoa;
import excecoes.EmailException;
import excecoes.NomeException;
import excecoes.SenhaException;

public interface Dao {
	public boolean create(Pessoa pessoa) throws SQLException, ClassNotFoundException, EmailException, SenhaException, NomeException;
	public Pessoa read(String email) throws SQLException, ClassNotFoundException, EmailException, SenhaException, NomeException;
}
