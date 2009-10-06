package co.com.vep.persistencia;

import co.com.vep.modelo.VepBitacoraConsultoria;

public interface IQueryVepBitacoraConsultoriaDAO {

	public Long searchSequence() throws Exception;

	public Long insert(VepBitacoraConsultoria entity) throws Exception;

}
