package co.com.vep.persistencia;

import co.com.vep.modelo.VepConsultor;

public interface IQueryVepConsultorDAO {

	public Integer searchSequence()throws Exception;
	public Integer insert(VepConsultor entity)throws Exception;

}
