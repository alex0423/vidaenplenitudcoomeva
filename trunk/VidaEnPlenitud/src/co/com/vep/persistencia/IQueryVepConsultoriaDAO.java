package co.com.vep.persistencia;

import co.com.vep.modelo.VepConsultoria;

public interface IQueryVepConsultoriaDAO {

	public Integer searchSequence()throws Exception;
	public Integer insert(VepConsultoria entity)throws Exception;

}
