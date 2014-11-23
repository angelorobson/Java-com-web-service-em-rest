package br.com.svg.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import br.com.svg.dao.VacinaDAO;
import br.com.svg.vo.VacinaVO;

@Path("vacina")
public class VacinaResources {

	VacinaVO vacina = new VacinaVO();
	VacinaDAO vacinaDAO = new VacinaDAO();


	@GET
	@Path("/listarVacinas/{codUsuario}")
	@Consumes("application/json")
	@Produces("application/json")
	public List<VacinaVO> listarVacinas(@PathParam("codUsuario") int sequencial) {


		return vacinaDAO.buscarTodos(sequencial);

	}


	@GET
	@Path("/listarVacina/{sequencial}/{codUsuario}")
	@Consumes("application/json")
	@Produces("application/json")
	public VacinaVO listarVacina(@PathParam("sequencial") int sequencial, @PathParam("codUsuario") int codUsuario) {

		return vacinaDAO.buscarVacinaPorId(sequencial, codUsuario);

	}

	@DELETE
	@Path("/excluir/{sequencial}")
	@Consumes("application/json")
	@Produces("application/json")
	public void excluirVacina(@PathParam("sequencial") int sequencial){

		vacinaDAO.excluir(sequencial);

	}

	@POST
	@Path("/salvar")
	@Consumes("application/json")
	@Produces("application/json")
	public void cadastrar(VacinaVO vacina){

		vacina.setCodUsuario(vacina.getCodUsuario());
		vacina.setNome(vacina.getNome());
		vacina.setLote(vacina.getLote());
		vacina.setData(vacina.getData());

		vacinaDAO.salvar(vacina);

	}

	@PUT
	@Path("/atualizar")
	@Consumes("application/json")
	@Produces("application/json")
	public void atualizar(VacinaVO vacina){

		vacina.setSequencial(vacina.getSequencial());
		vacina.setNome(vacina.getNome());
		vacina.setLote(vacina.getLote());
		vacina.setData(vacina.getData());
		vacinaDAO.salvar(vacina);

	}

}
