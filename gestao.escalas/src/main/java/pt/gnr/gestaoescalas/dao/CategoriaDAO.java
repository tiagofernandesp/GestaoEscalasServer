package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Categoria;

public interface CategoriaDAO {
	public List<Categoria> getCategorias ()throws Exception;
	public Categoria getCategoria (int id)throws Exception;
	public void addCategoria (Categoria categoria)throws Exception;
	public void deleteCategoria (int id)throws Exception;
	public void updateCategoria (Categoria categoria)throws Exception;
}
