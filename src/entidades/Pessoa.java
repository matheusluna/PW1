package entidades;

import java.time.LocalDate;

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
			LocalDate nascimento) {
		this.email = email;
		this.nome = nome;
		this.cidade = cidade;
		this.sexo = sexo;
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
	
	
	
}
