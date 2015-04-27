package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Configuracao;

public interface ConfiguracaoDAO {
	public List<Configuracao> getConfiguracaos () throws Exception;
	public Configuracao getConfiguracao (int id) throws Exception;
	public void addConfiguracao (Configuracao configuracao) throws Exception;
	public void deleteConfiguracao (int id)throws Exception;
	public void updateConfiguracao (Configuracao configuracao) throws Exception;
}
