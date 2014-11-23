package br.com.svg.testes;

import java.util.List;

import br.com.svg.dao.UsuarioDAO;
import br.com.svg.dao.VacinaDAO;
import br.com.svg.vo.UsuarioVO;
import br.com.svg.vo.VacinaVO;

public class VacinaDAOTeste {

	public static void main(String[] args) {
		
//    cadastrar();
//	listarVacina();
//		excluir();
//		buscarVacinaPorId();
		
	}
	
	public static void cadastrar() {
		
		VacinaVO vacinaVO = new VacinaVO();
		VacinaDAO vacinaDAO = new VacinaDAO();
		
//		vacinaVO.setSequencial(7);
		vacinaVO.setNome("Bobonica");
		vacinaVO.setLote("8");
		vacinaVO.setCodUsuario(3);
		
		vacinaDAO.salvar(vacinaVO);
	}
	
	public static void listarVacina(){
		
		UsuarioVO usu = new UsuarioVO();
		UsuarioDAO usuDAO = new UsuarioDAO();
		
	   usu.setEmail("angelorobson3@hotmail.com");
	   usu.setSenha("123");
	   
	   UsuarioVO UsuRetorno = usuDAO.autenticar(usu);
	   
       Integer codUsuario = UsuRetorno.getSequencial();
    
        System.out.println(UsuRetorno.getNome());  
		
		
		VacinaDAO vacinaDAO = new VacinaDAO();
		
		List<VacinaVO> vacinaRetorno = vacinaDAO.buscarTodos(codUsuario);
		
		for (VacinaVO vacinaVO : vacinaRetorno) {
			
			System.out.println( vacinaVO.getSequencial() + " \n" + vacinaVO.getNome() + " \n" + vacinaVO.getCodUsuario()  + " \n" + vacinaVO.getData() + "\n" +  vacinaVO.getLote() + "\n");
		
			
		}
		
		
	}
	
	public static void excluir(){
		
		Integer sequencial = 8;
		
		VacinaDAO vacinaDAO = new VacinaDAO();
		vacinaDAO.excluir(sequencial);
	}
	
//  public static void buscarVacinaPorId() {
//		
//		Integer sequencial = 8;
//		
//		VacinaDAO vacinaDAO = new VacinaDAO();
//		
//	 VacinaVO vacina = vacinaDAO.buscarVacinaPorId(sequencial);
//	 
//	 System.out.println(vacina.getSequencial() + "\n" + vacina.getCodUsuario() + "\n" + vacina.getNome() + "\n" + vacina.getData() + "\n" + vacina.getLote() );
//		
//	}
	
	

}
