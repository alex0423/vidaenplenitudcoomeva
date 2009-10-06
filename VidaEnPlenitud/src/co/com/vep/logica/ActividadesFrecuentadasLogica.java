package co.com.vep.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.persistencia.IQueryVepAsistenteProgDAO;
import co.com.vep.persistencia.QueryVepAsistenteProgDAO;

public class ActividadesFrecuentadasLogica implements IActividadesFrecuentadas {

	public List<VepAsistenteProg> findActividadesFrecuentadas(
			Date date1, Date date2) throws Exception {
		// TODO Auto-generated method stub
		List<VepAsistenteProg> lista = new ArrayList<VepAsistenteProg>();
		IQueryVepAsistenteProgDAO iqvapd = new QueryVepAsistenteProgDAO();

		lista = iqvapd.findByDateRange(date1, date2);

		return lista;
	}
}
