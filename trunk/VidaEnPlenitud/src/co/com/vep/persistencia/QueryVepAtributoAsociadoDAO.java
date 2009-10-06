package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepAtributoAsociado;

public class QueryVepAtributoAsociadoDAO implements IQueryVepAtributoAsociadoDAO {

	/* (non-Javadoc)
	 * @see co.com.vep.persistencia.IQueryVepAtributoAsociadoDAO#obtenerByAsociado(java.lang.Long)
	 */
	public List<VepAtributoAsociado> obtenerByAsociado(Long idAsociado)
			throws Exception {
		try {
			return EntityManagerHelper.getEntityManager().createNamedQuery(
					"vepatributoasociado.findbyasociado").setParameter(
					"idAsociado", idAsociado).getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

}
