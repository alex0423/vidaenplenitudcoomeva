package co.com.vep.persistencia;

import co.com.vep.modelo.VepProfesor;

public class QueryVepProfesorPlusBucDAO implements IQueryVepProfesorPlusBucDAO {

	public VepProfesor obtenerByAsociado(Long tipoId, Long numero)
			throws Exception {
		try {
			return (VepProfesor) EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepprofesor.findbyid").setParameter(
							"id", tipoId).setParameter("numero", numero)
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		}
	}

}
