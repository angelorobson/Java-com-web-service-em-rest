package br.com.svg.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.svg.dao.UsuarioDAO;
import br.com.svg.vo.UsuarioVO;

@Path("usuario")
public class UsuarioResource {
	



	
	@GET
	@Path("/listarUsuarios")
	@Consumes("application/json")
	@Produces("application/json")
	public List<UsuarioVO> buscarTodos() {
		
		System.out.println("Listou todos");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscarTodos();
	}
	
	@POST
	@Path("/autenticar")
	@Consumes("application/json")
	@Produces("application/json")
	public UsuarioVO autenticar(UsuarioVO usuario) {
		
		usuario.setEmail(usuario.getEmail());
		usuario.setSenha(usuario.getSenha());
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		System.out.println(usuario.getEmail());
		
		return usuarioDAO.autenticar(usuario);
	}
	
	@POST
	@Path("/salvar")
	@Consumes("application/json")
	@Produces("application/json")
	public void inserirUsuario(UsuarioVO usuario){
		
		usuario.setNome(usuario.getNome());
		usuario.setEmail(usuario.getEmail());
		usuario.setSenha(usuario.getSenha());
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.salvar(usuario);
		
		
	}
	
}
