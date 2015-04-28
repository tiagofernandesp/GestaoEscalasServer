package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Configuracao;

public interface ConfiguracaoDAO {
	public List<Configuracao> getConfiguracaos () throws Exception;
	public Configuracao getConfiguracao (int id) throws Exception;
	public int addConfiguracao (Configuracao configuracao) throws Exception;
	public int deleteConfiguracao (int id)throws Exception;
	public int updateConfiguracao (Configuracao configuracao) throws Exception;
}
