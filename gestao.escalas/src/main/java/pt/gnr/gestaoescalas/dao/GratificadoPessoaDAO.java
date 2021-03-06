package pt.gnr.gestaoescalas.dao;

import java.sql.Date;
import java.util.List;

import pt.gnr.gestaoescalas.model.GratificadoPessoa;

public interface GratificadoPessoaDAO {
	public List<GratificadoPessoa> getGratificadoPessoas () throws Exception;
	public GratificadoPessoa getGratificadoPessoa (int id) throws Exception;
	public List<GratificadoPessoa> getGratificadoPessoasbetweenDates(Date dataI, Date dataF) throws Exception;
	public int addGratificadoPessoa (GratificadoPessoa gratificadoPessoa) throws Exception;
	public int deleteGratificadoPessoa (int id) throws Exception;
	public int updateGratificadoPessoa (GratificadoPessoa gratificadoPessoa) throws Exception;
}
