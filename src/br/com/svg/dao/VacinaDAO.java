package br.com.svg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.svg.bd.Conexao;
import br.com.svg.vo.VacinaVO;

public class VacinaDAO {

	private Connection con = Conexao.getConnection();


	public void cadastrar(VacinaVO vacina) {

		// Monta sql 
		String sql = "INSERT INTO vacina (cod_usuario, nom_vacina, lote, data) VALUES ( ?, ?, ?, ?)";

		// Constroe o PrepareStatement com sql

		try {

			System.out.println(vacina.getData());
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, vacina.getCodUsuario());
			preparador.setString(2, vacina.getNome());
			preparador.setString(3, vacina.getLote());
			preparador.setString(4, vacina.getData());
			preparador.execute();
			preparador.close();

			System.out.println("Vacina Cadastrada com Sucesso!");

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro: " + e.getMessage());
		}
	}

	public List<VacinaVO> buscarTodos(Integer codUsuario) {

		// Monta sql 
		String sql = "  SELECT * FROM vacina WHERE cod_usuario = ?;";

		// Constroe o PrepareStatement com sql

		VacinaVO vacina = null;
		ArrayList<VacinaVO> lista = new ArrayList<VacinaVO>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codUsuario);


			// na variável resultado está todos os dados do banco
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				vacina = new VacinaVO();


				vacina.setSequencial(resultado.getInt("sequencial"));
				vacina.setCodUsuario(resultado.getInt("cod_usuario"));
				vacina.setNome(resultado.getString("nom_vacina"));
				vacina.setData(resultado.getString("data"));
				vacina.setLote(resultado.getString("lote"));

				lista.add(vacina);

			}


			preparador.close();
			resultado.close();

			System.out.println("Vacinas listadas com Sucesso");
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro: " + e.getMessage());
		}
		
		return lista;
	}

	public VacinaVO buscarVacinaPorId(Integer sequencial, Integer codUsuario){

		String sql = "SELECT * FROM vacina WHERE sequencial =? and cod_usuario = ?";

		VacinaVO vacina = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, sequencial);
			preparador.setInt(2, codUsuario);

			ResultSet resultado = preparador.executeQuery();



			while (resultado.next()) {

				vacina = new VacinaVO();

				vacina.setSequencial(resultado.getInt("sequencial"));
				vacina.setCodUsuario(resultado.getInt("cod_usuario"));
				vacina.setNome(resultado.getString("nom_vacina"));
				vacina.setData(resultado.getString("data"));
				vacina.setLote(resultado.getString("lote"));

			}
			
			resultado.close();
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vacina;


	}

	public void excluir(Integer sequencial) {

		String sql = "DELETE FROM vacina WHERE sequencial = ?";


		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, sequencial);
			preparador.execute();
			preparador.close();

			System.out.println("Vacina excluída com sucesso!");

		} catch (SQLException e) {

			e.printStackTrace();
		}


	}

	public void atualizar(VacinaVO vacina){

		String sql = "UPDATE vacina SET nom_vacina = ?, lote =?, data=? WHERE sequencial = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, vacina.getNome());
			preparador.setString(2, vacina.getLote());
			preparador.setString(3, vacina.getData());
			preparador.setInt(4, vacina.getSequencial());
			preparador.execute();
			preparador.close();

			System.out.println("Vacina Atualizada com Sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvar(VacinaVO vacina) {


		if (vacina.getSequencial() !=null && vacina.getSequencial() !=0) {

			atualizar(vacina);

		} else {

			cadastrar(vacina);
		}
	}

}
