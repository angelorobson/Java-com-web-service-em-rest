package br.com.svg.vo;



public class UsuarioVO {
	
	private Integer sequencial;
	private String nome;
	private String email;
	private String senha;
	private String indStatus;
	

	public Integer getSequencial() {
		return sequencial;
	}
	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getIndStatus() {
		return indStatus;
	}
	public void setIndStatus(String indStatus) {
		this.indStatus = indStatus;
	}


}
