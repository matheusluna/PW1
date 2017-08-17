package entidades;

import java.time.LocalDate;

import excecoes.EmailException;
import excecoes.NomeException;
import excecoes.SenhaException;

public class Pessoa {
	private String email;
	private String nome;
	private String cidade;
	private String sexo;
	private String senha;
	private String foto;
	private String profissao;
	private LocalDate nascimento;
	
	public Pessoa(String email, String nome, String cidade, String sexo, String senha, String foto, String profissao,
			LocalDate nascimento) throws EmailException, SenhaException, NomeException {
		if(email.equals("")) throw new EmailException("Campo Email não preenchido!");
		this.email = email;
		if(nome.equals("")) throw new NomeException("Campo Nome não preenchido!");
		this.nome = nome;
		this.cidade = cidade;
		this.sexo = sexo;
		if(senha.equals("")) throw new SenhaException("Campo Senha não preenchido!");
		this.senha = senha;
		this.foto = foto;
		this.profissao = profissao;
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	public boolean validaLogin(String senha) {
		if(this.senha.equals(senha)) {
			return true;
		}else {
			return false;
		}
	}
	
}
