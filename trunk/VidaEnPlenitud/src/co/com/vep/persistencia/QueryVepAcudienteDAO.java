package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAcudiente;
import co.com.vep.modelo.VepUbicacionAcudiente;

public class QueryVepAcudienteDAO implements IQueryVepAcudienteDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public VepAcudiente findByTipoDocDocumento(Long tipoDocumento,
			Long documento) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log(
				"finding VepAcudiente instance with tipoDocumento: "
						+ tipoDocumento + " and Documento: " + documento,
				Level.INFO, null);
		try {
			final String queryString = "select model from VepAcudiente model where model.tipoDocumento="
					+ tipoDocumento
					+ " and model.numeroDocumento = "
					+ documento;
			Query query = getEntityManager().createQuery(queryString);
			return (VepAcudiente) query.getSingleResult();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VepUbicacionAcudiente> findUbicacionAcudiente(Integer idAcudiente)
			throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log(
				"finding VepAcudiente instance with idAcudiente: "
						+idAcudiente,
				Level.INFO, null);
		try {
			final String queryString = "select model from VepUbicacionAcudiente model where model.id.idAcudiente="
					+ idAcudiente;
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}
	
	

}
