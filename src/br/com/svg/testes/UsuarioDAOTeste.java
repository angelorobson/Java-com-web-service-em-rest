package br.com.svg.testes;

import java.util.List;

import br.com.svg.dao.UsuarioDAO;
import br.com.svg.vo.UsuarioVO;

public class UsuarioDAOTeste {

	public static void main(String[] args) {
		
		
		cadastrar();
//		autenticar();

	}
	
 public	static void cadastrar() {
	 
	 
	 UsuarioVO usuVO = new UsuarioVO();
	 UsuarioDAO usuDAO = new UsuarioDAO();
	 
	 usuVO.setSequencial(2);
	 usuVO.setNome("José da Silva");
	 usuVO.setEmail("josedasilva@hotmail.com");
	 usuVO.setSenha("123456");
	 
	 usuDAO.salvar(usuVO);
	 
	 
 }
 
 public static void autenticar(){
	 
	 UsuarioVO usu = new UsuarioVO();
	 usu.setEmail("manoel@hotmail.com");
	 usu.setSenha("1234");
	 
	 UsuarioDAO usuDAO = new UsuarioDAO();
	 
	UsuarioVO retorno = usuDAO.autenticar(usu);
	
	
	System.out.println(retorno.getSequencial() + "\n" + retorno.getNome() + "\n" + retorno.getEmail() + "\n" + retorno.getSenha() + "\n" + retorno.getIndStatus() );

	 
 }

}
