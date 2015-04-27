package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.HabilitaServico;

public interface HabilitaServicoDAO {
	public List<HabilitaServico> getHabilitaServicos () throws Exception;
	public HabilitaServico getHabilitaServico (int id) throws Exception;
	public void addHabilitaServico (HabilitaServico habilitaServico) throws Exception;
	public void deleteHabilitaServico (int id) throws Exception;
	public void updateHabilitaServico (HabilitaServico habilitaServico) throws Exception;
}
