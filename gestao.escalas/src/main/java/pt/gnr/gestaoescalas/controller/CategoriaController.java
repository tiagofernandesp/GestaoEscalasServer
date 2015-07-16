package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import java.sql.SQLException;
import pt.gnr.gestaoescalas.dao.CategoriaDAOImpl;
import pt.gnr.gestaoescalas.model.Categoria;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	private CategoriaDAOImpl categoriaDAOImpl = new CategoriaDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Categoria> getCategorias()
			throws Exception {
		try{
			List<Categoria> categorias = categoriaDAOImpl.getCategorias();
			return categorias;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Metodo devolte objecto pelo "/{id}"
	 *
	 * @param id
	 *            do objecto
	 * @return categoria retorna um objecto
	 *
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Categoria getCategoria(
			@PathVariable("id") int id) throws Exception {

		try {
			Categoria categoria = categoriaDAOImpl.getCategoria(id);
			return categoria;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param categoria
	 *            objecto para adicionar à BD
	 *
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addCategoria(
			@RequestBody Categoria categoria) throws Exception {

		try {

			return categoriaDAOImpl.addCategoria(categoria);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param categoria
	 *            objecto para modificar na BD
	 *
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateCategoria(
			@RequestBody Categoria categoria) throws Exception {

		try {

			return categoriaDAOImpl.updateCategoria(categoria);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param categoria
	 *            objecto para apagar na BD
	 *
	 *
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteCategoria(
			@RequestBody int id) throws Exception {

		try {

			return categoriaDAOImpl.deleteCategoria(id);
		} catch (Exception e) {
			throw e;
		}
	}
}