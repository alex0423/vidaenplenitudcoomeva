package co.com.vep.persistencia;

import co.com.vep.modelo.VepEncuesta;

public interface IQueryVepEncuestaDAO {

	public Long searchSequence()throws Exception;
	public Long insert(VepEncuesta entity)throws Exception;

}
