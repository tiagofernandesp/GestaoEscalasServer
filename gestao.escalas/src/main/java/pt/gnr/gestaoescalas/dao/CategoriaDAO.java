package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Categoria;

public interface CategoriaDAO {
	public List<Categoria> getCategorias ()throws Exception;
	public Categoria getCategoria (int id)throws Exception;
	public int addCategoria (Categoria categoria)throws Exception;
	public int deleteCategoria (int id)throws Exception;
	public int updateCategoria (Categoria categoria)throws Exception;
}
