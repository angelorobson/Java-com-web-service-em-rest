package br.com.svg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.svg.bd.Conexao;
import br.com.svg.vo.UsuarioVO;
import br.com.svg.vo.VacinaVO;

public class UsuarioDAO {


	private Connection con= Conexao.getConnection();

	// Monta sql 
	public void cadastrar(UsuarioVO usuario) {
		// Monta sql 
		String sql = "INSERT INTO usuario (nome, email, senha, ind_status) VALUES ( ?, ?, ?, ?)";

		// Constroe o PrepareStatement com sql

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
			preparador.setString(4, "U");
			preparador.execute();
			preparador.close();

			System.out.println("Usuário Cadastrado com Sucesso!");

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro: " + e.getMessage());
		}
	}


	public List<UsuarioVO> buscarTodos() {

		// Monta sql 
		String sql = "SELECT * FROM usuario";

		// Constroe o PrepareStatement com sql


		ArrayList<UsuarioVO> lista = new ArrayList<UsuarioVO>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
            

			// na variável resultado está todos os dados do banco
			ResultSet resultado = preparador.executeQuery();




			while (resultado.next()) {

				UsuarioVO usu = new UsuarioVO();

				usu.setSequencial(resultado.getInt("sequencial")); // valor da coluna id
				usu.setNome(resultado.getString("nome")); // valor da coluna nome
				usu.setEmail(resultado.getString("email")); // valor da coluna login
				usu.setSenha(resultado.getString("senha"));
				usu.setIndStatus(resultado.getString("ind_status"));// valor da coluna senha

				lista.add(usu);

			}


			preparador.close();
			resultado.close();



		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro: " + e.getMessage());
		}
		return lista;
	}


	public UsuarioVO autenticar(UsuarioVO usuario) {


		String sql = "SELECT *  FROM  usuario U "
				+ "WHERE U.email = ? "
				+ "AND U.senha = ?;";

		UsuarioVO usuarioRetorno = null;

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, usuario.getEmail());
			preparador.setString(2, usuario.getSenha());

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()) { //se foi para o próximo

				usuarioRetorno = new UsuarioVO();
				usuarioRetorno.setSequencial(resultado.getInt("sequencial"));
				usuarioRetorno.setNome(resultado.getString("nome"));
				usuarioRetorno.setEmail(resultado.getString("email"));
				usuarioRetorno.setSenha(resultado.getString("senha"));
				usuarioRetorno.setIndStatus(resultado.getString("ind_status"));

			}

			preparador.close();
			resultado.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro" + e.getMessage());
		}
		return usuarioRetorno;




	}

	public void alterar(UsuarioVO usuario) {

		String sql = "UPDATE usuario SET nome=?, email=?, senha=? WHERE sequencial =?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getSequencial());
			preparador.execute();
			preparador.close();

			System.out.println("Usuário Alterado com Sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void salvar(UsuarioVO usuario){

		if (usuario.getSequencial() != null && usuario.getSequencial() !=0) {

			alterar(usuario);

		}
		else 
			cadastrar(usuario);
	}


}




