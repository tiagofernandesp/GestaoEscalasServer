package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.HabilitaServico;

public interface HabilitaServicoDAO {
	public List<HabilitaServico> getHabilitaServicos () throws Exception;
	public HabilitaServico getHabilitaServico (int id) throws Exception;
	public int addHabilitaServico (HabilitaServico habilitaServico) throws Exception;
	public int deleteHabilitaServico (int id) throws Exception;
	public int updateHabilitaServico (HabilitaServico habilitaServico) throws Exception;
}
