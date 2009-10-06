/**
 * 
 */
package co.com.vep.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepDetalleConsultoria;

/**
 * @author Juank
 * 
 */
public class QueryVepDetalleConsultoriaDAO implements
		IQueryVepDetalleConsultoriaDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepDetalleConsultoria#insert(co.com.vep.modelo.VepDetalleConsultoria)
	 */
	public Integer insert(VepDetalleConsultoria entity) throws Exception {
		EntityManagerHelper.log("Registrando un Servicio de Consultoria",
				Level.INFO, null);
		Integer nextId = searchSequence() + 1;
		entity.setIdDetallecons(nextId.intValue());
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
			return nextId;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepDetalleConsultoria#searchSequence()
	 */
	public Integer searchSequence() throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding Secuence", Level.INFO, null);
		try {
			final String queryString = "select max(model.idDetallecons) from VepDetalleConsultoria model";
			Query query = getEntityManager().createQuery(queryString);
			Object rs = query.getSingleResult();
			if (rs != null)
				return (Integer) rs;
			return new Integer(1);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepDetalleConsultoria> findByFilter(String idServicio,
			String asesor, String ciudad, String estado, Date fechaInicio,
			Date fechaFin, Long idRegional) throws Exception {
		try {
			Query nquery;
			nquery = EntityManagerHelper
					.getEntityManager()
					.createNativeQuery(
							"select detalle.ID_DETALLECONS, detalle.FECHA_INI, detalle.FECHASEG, detalle.FECHATERM, detalle.OBSERVACIONES, detalle.ESTADO, detalle.OBJETIVO, detalle.NUM_BENEFICIADOS, detalle.ID_REGIONAL, detalle.ID_SERVICIO_CON  "
									+ "from vep.vep_detalle_consultoria detalle "
									+ "JOIN vep.VEP_CONSULTORIA consultoria ON consultoria.id_serviciocon=detalle.id_servicio_con  "
									+ "JOIN vep.VEP_CONSULTOR consultor ON detalle.id_detallecons=consultor.id_detalle_cons "
									+ "where (VARCHAR(IFNULL(:idServicio, 0)) = '0' or consultoria.id_serviciocon = :idServicio) "
									+ "and (VARCHAR(IFNULL(:idAsesor, 0)) = '0' or consultor.id_consultor = :idAsesor) "
									+ "and (VARCHAR(IFNULL(:estado, 0)) = '0' or consultoria.estado = :estado) "
									+ "and (IFNULL(:fechaInicio, '1') = '1' or detalle.fecha_ini = :fechaInicio) "
									+ "and (IFNULL(:fechaFin, '1') = '1' or detalle.fechaterm = :fechaFin) "
									+ "and (VARCHAR(IFNULL(:idRegional, 0)) = '0' or detalle.id_regional = :idRegional) ",
							co.com.vep.modelo.VepDetalleConsultoria.class);

			nquery.setParameter("idServicio", idServicio);
			nquery.setParameter("idAsesor", asesor);
			nquery.setParameter("estado", estado);
			nquery.setParameter("fechaInicio", fechaInicio);
			nquery.setParameter("fechaFin", fechaFin);
			nquery.setParameter("idRegional", idRegional);

			return nquery.getResultList();
		} catch (Exception e) {
			throw e;
		}
	}
}
