package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.HabilitaServico;

public interface HabilitaServicoDAO {
	public List<HabilitaServico> getHabilitaServicos () throws Exception;
	public List<HabilitaServico> getHabilitaServicosByPerson (int id) throws Exception;
	public HabilitaServico getByTServicoAndPessoa (int tServico_Id,int pessoa_Id) throws Exception;
	/*public List<Integer> getHabilitaServicosByTServico (int tipoService_Id) throws Exception;*/
	public HabilitaServico getHabilitaServico (int id) throws Exception;
	public int addHabilitaServico (HabilitaServico habilitaServico) throws Exception;
	public int deleteHabilitaServico (int id) throws Exception;
	public int updateHabilitaServico (HabilitaServico habilitaServico) throws Exception;
}
