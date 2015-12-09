package pt.gnr.gestaoescalas.service;

import java.util.List;


//import java.sql.SQLException;
import pt.gnr.gestaoescalas.dao.CategoriaDAOImpl;
import pt.gnr.gestaoescalas.model.Categoria;


public class CategoriaService {

	private CategoriaDAOImpl categoriaDAOImpl = new CategoriaDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<Categoria> getCategorias()
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
	public Categoria getCategoria(int id) throws Exception {

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
	public int addCategoria(Categoria categoria) throws Exception {

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
	public int updateCategoria(Categoria categoria) throws Exception {

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
	public int deleteCategoria(int id) throws Exception {

		try {

			return categoriaDAOImpl.deleteCategoria(id);
		} catch (Exception e) {
			throw e;
		}
	}
}