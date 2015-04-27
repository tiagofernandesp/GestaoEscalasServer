package pt.gnr.gestaoescalas.dao;

import java.util.List;
import pt.gnr.gestaoescalas.model.GratificadoPessoa;

public interface GratificadoPessoaDAO {
	public List<GratificadoPessoa> getGratificadoPessoas () throws Exception;
	public GratificadoPessoa getGratificadoPessoa (int id) throws Exception;
	public void addGratificadoPessoa (GratificadoPessoa gratificadoPessoa) throws Exception;
	public void deleteGratificadoPessoa (int id) throws Exception;
	public void updateGratificadoPessoa (GratificadoPessoa gratificadoPessoa) throws Exception;
}
