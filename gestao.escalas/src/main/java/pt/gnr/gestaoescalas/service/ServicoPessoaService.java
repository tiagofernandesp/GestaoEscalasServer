package pt.gnr.gestaoescalas.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pt.gnr.gestaoescalas.dao.ServicoDAOImpl;
import pt.gnr.gestaoescalas.dao.ServicoPessoaDAOImpl;
import pt.gnr.gestaoescalas.model.ServicoPessoa;

public class ServicoPessoaService {

	private ServicoPessoaDAOImpl servicoPessoaDAOImpl = new ServicoPessoaDAOImpl();
	private ServicoDAOImpl servicoDAOImpl = new ServicoDAOImpl();

	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<ServicoPessoa> getServicoPessoas()
			throws Exception {
		try {
			List<ServicoPessoa> servicoPessoas = servicoPessoaDAOImpl.getServicoPessoas();
			return servicoPessoas;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<ServicoPessoa> getServicoPessoasByDate( Date dat)
			throws Exception {
		try {
			List<ServicoPessoa> servicoPessoas = servicoPessoaDAOImpl.getServicoPessoasByDate(dat);
			return servicoPessoas;
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
	 * @return servicoPessoa retorna um objecto
	 *
	 * */
	public ServicoPessoa getServicoPessoa(int id) throws Exception {
		try {
			ServicoPessoa servicoPessoa = servicoPessoaDAOImpl.getServicoPessoa(id);
			return servicoPessoa;
		} catch (Exception e) {
			throw e;
		}


	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param servicoPessoa
	 *            objecto para adicionar à BD
	 *
	 * */
	public int addServicoPessoa(ServicoPessoa servicoPessoa) throws Exception {

		try {
			verifyErrors(servicoPessoa);
			return servicoPessoaDAOImpl.addServicoPessoa(servicoPessoa);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param servicoPessoa
	 *            objecto para modificar na BD
	 *
	 * */
	public int updateServicoPessoa(ServicoPessoa servicoPessoa) throws Exception {

		try {
			verifyErrors(servicoPessoa);
			return servicoPessoaDAOImpl.updateServicoPessoa(servicoPessoa);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param servicoPessoa
	 *            objecto para apagar na BD
	 *
	 *
	 * */
	public int deleteServicoPessoa(int id) throws Exception {

		try {
			return servicoPessoaDAOImpl.deleteServicoPessoa(id);
		} catch (Exception e) {
			throw e;
		}

	}
	/**
	 *
	 * @param pessoaId
	 * @param data
	 * @param nDiasIncrementa
	 * @return obj
	 * @throws Exception
	 */
	private ServicoPessoa getServicoPessoaByDatePessoaId (int pessoaId, Date data, int nDiasIncrementa) throws Exception {
		try {
			List<ServicoPessoa> servicoPessoas = new ArrayList<ServicoPessoa>();
			ServicoPessoa sp = new ServicoPessoa();
			if (nDiasIncrementa!=0) {
				String dt = data.toString();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(dt));
				c.add(Calendar.DATE, nDiasIncrementa);
				Date dataFinal =  new Date(c.getTimeInMillis());
				servicoPessoas = servicoPessoaDAOImpl.getServicoPessoasByDataPessoa(dataFinal,pessoaId);
			}
			else {
				servicoPessoas = servicoPessoaDAOImpl.getServicoPessoasByDataPessoa(data, pessoaId);
			}
			if (!servicoPessoas.isEmpty()) {
				sp = servicoPessoas.get(0);
			}
			return sp;
		} catch (Exception e) {
			throw e;
		}


	}

	private void verifyErrors (ServicoPessoa servicoPessoa) throws Exception {
		try {

			int prevDay = -1;
			int prevprevDay = -2;
			int nextDay = 1;
			int nextnextDay = 2;
			servicoPessoa.setServico(servicoDAOImpl.getServico(servicoPessoa.getServico().getId()));
			ServicoPessoa prevServicoPessoa = getServicoPessoaByDatePessoaId(servicoPessoa.getPessoa().getId(),servicoPessoa.getData(),prevDay);
			ServicoPessoa nextServicoPessoa = getServicoPessoaByDatePessoaId(servicoPessoa.getPessoa().getId(),servicoPessoa.getData(),nextDay);

			//Reset errors
			servicoPessoa.setErro(null);
			servicoPessoa.setStatus(1);
			prevServicoPessoa.setErro(null);
			prevServicoPessoa.setStatus(1);
			nextServicoPessoa.setErro(null);
			nextServicoPessoa.setStatus(1);

			//verifica dia anterior existe
			if (prevServicoPessoa.getId()!=-1) {
				//verifica erros servico com dia anterior
				verifyDay(servicoPessoa, prevServicoPessoa);
				//verifica erros do dia anterior para atualizar
				verifyDay(prevServicoPessoa, getServicoPessoaByDatePessoaId(servicoPessoa.getPessoa().getId(),servicoPessoa.getData(),prevprevDay));
				verifyDay(prevServicoPessoa, servicoPessoa);
				servicoPessoaDAOImpl.updateServicoPessoa(prevServicoPessoa);
			}
			//verifica proximo dia existe
			if (nextServicoPessoa.getId()!=-1) {
				//verifica erros servico com proximo dia
				verifyDay(servicoPessoa, nextServicoPessoa);
				//verifica erros do proximo dia para atualizar
				verifyDay(nextServicoPessoa, servicoPessoa);
				verifyDay(nextServicoPessoa, getServicoPessoaByDatePessoaId(servicoPessoa.getPessoa().getId(),servicoPessoa.getData(),nextnextDay));
				servicoPessoaDAOImpl.updateServicoPessoa(nextServicoPessoa);
			}

		} catch (Exception e) {
			throw e;
		}


	}
	private void verifyDay (ServicoPessoa servicoPessoa, ServicoPessoa compareServicoPessoa) throws Exception {
		try {
			String erroServicoRepetido = servicoPessoa.getData()+ " \\ "+ compareServicoPessoa.getData()+" | Serviço repetido.";
			String erroServicoHora = servicoPessoa.getData()+ " \\ "+ compareServicoPessoa.getData()+" | Conflito no horário.";
			//verifica dia
			if (compareServicoPessoa.getId()!=-1) {
				//verifica se serviço é repetido
				if (compareServicoPessoa.getServico().getTipoServico().getId()==servicoPessoa.getServico().getTipoServico().getId()
						&& servicoPessoa.getServico().getTipoServico().getServicoRepetitivo()!=true) {
					servicoPessoa.setStatus(0);
					if(servicoPessoa.getErro()!=null)
					{
						servicoPessoa.setErro(servicoPessoa.getErro() + "\n" + erroServicoRepetido);
					}
					else {
						servicoPessoa.setErro(erroServicoRepetido);
					}
				}
				//se compareServicoPessoa for dia anterior
				if (servicoPessoa.getServico().getData().compareTo(compareServicoPessoa.getServico().getData())>=0) {
					//se data sp inicio for mais recente que comparesp data fim
					int condicao1 = servicoPessoa.getServico().getDataInicio().compareTo(compareServicoPessoa.getServico().getDataFim());
					int condicao2 = servicoPessoa.getServico().getHoraInicio().compareTo(compareServicoPessoa.getServico().getHoraFim());
					if (condicao1 < 0) {
						servicoPessoa.setStatus(0);
						if(servicoPessoa.getErro()!=null)
						{
							servicoPessoa.setErro(servicoPessoa.getErro() + "\n" + erroServicoHora);
						}
						else {
							servicoPessoa.setErro(erroServicoHora);
						}
					}
					else {
						if (condicao1 == 0  && condicao2 < 0) {
							servicoPessoa.setStatus(0);
							if(servicoPessoa.getErro()!=null)
							{
								servicoPessoa.setErro(servicoPessoa.getErro() + "\n" + erroServicoHora);
							}
							else {
								servicoPessoa.setErro(erroServicoHora);
							}
						}
					}
				}
				//se compareServicoPessoa for dia seguinte
				else {
					//se data sp inicio for mais recente que comparesp data fim
					int condicao1 = servicoPessoa.getServico().getDataFim().compareTo(compareServicoPessoa.getServico().getDataInicio());
					int condicao2 = servicoPessoa.getServico().getHoraFim().compareTo(compareServicoPessoa.getServico().getHoraInicio());
					if (condicao1 > 0) {
						servicoPessoa.setStatus(0);
						if(servicoPessoa.getErro()!=null)
						{
							servicoPessoa.setErro(servicoPessoa.getErro() + "\n" + erroServicoHora);
						}
						else {
							servicoPessoa.setErro(erroServicoHora);
						}
					}
					else {
						if (condicao1 == 0  && condicao2 > 0) {
							servicoPessoa.setStatus(0);
							if(servicoPessoa.getErro()!=null)
							{
								servicoPessoa.setErro(servicoPessoa.getErro() + "\n" + erroServicoHora);
							}
							else {
								servicoPessoa.setErro(erroServicoHora);
							}
						}
					}
				}

			}
		} catch (Exception e) {
			throw e;
		}


	}
}