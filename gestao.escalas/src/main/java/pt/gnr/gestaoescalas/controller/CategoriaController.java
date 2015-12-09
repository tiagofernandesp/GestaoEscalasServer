package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.model.Categoria;
import pt.gnr.gestaoescalas.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	private CategoriaService categoriaService = new CategoriaService();
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
			List<Categoria> categorias = categoriaService.getCategorias();
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
			Categoria categoria = categoriaService.getCategoria(id);
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

			return categoriaService.addCategoria(categoria);
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

			return categoriaService.updateCategoria(categoria);
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

			return categoriaService.deleteCategoria(id);
		} catch (Exception e) {
			throw e;
		}
	}
}