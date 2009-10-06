package co.com.vep.logica;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepAsistenteProg;

public interface IActividadesFrecuentadas {

	public List<VepAsistenteProg> findActividadesFrecuentadas(Date date1,
			Date date2) throws Exception;
}
