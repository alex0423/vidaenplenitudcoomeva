package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepValoracion;

public class QueryVepValoracionDAO implements IQueryVepValoracionDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepValoracionDAO#obtener(java.lang.Integer)
	 */
	public VepValoracion obtener(Integer id) throws Exception {
		try {
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	public Long searchSequence() throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding Secuence", Level.INFO, null);
		try {
			final String queryString = "select max(c.idValoracion) from VepValoracion c";
			Query query = getEntityManager().createQuery(queryString);
			Object rs = query.getSingleResult();
			if (rs != null)
				return (Long) rs;
			return new Long(1);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	public void registrar(VepAsociado vepAsociado, Date fecha_actual,
			Double estatura, Double peso, Long presionDiastole,
			Long presionSistole, String toma_med, String med, Long fcm,
			String reforzar_en, String plan_seg, String imc, Long per_cintura,
			String cv_event_sig, String cv_camb_signif, String cv_marc_des,
			String obs_vd, List<Integer> atts, String pv_obs) throws Exception {
		try {
			EntityManagerHelper.getEntityManager().getTransaction().begin();

			for (Integer vepAtributoAsociado : atts) {				
				if (vepAtributoAsociado != -1)
					EntityManagerHelper
							.getEntityManager()
							.createNativeQuery(
									"INSERT INTO VEP_ATRIBUTO_ASOCIADO (ID_ASOCIADO, ID_TIPO_CLASIF, VALOR) VALUES (:idAsociado, :idParametro, NULL)")
							.setParameter("idAsociado",
									vepAsociado.getIdAsociado()).setParameter(
									"idParametro", vepAtributoAsociado)
							.executeUpdate();
			}

			VepValoracion entity = new VepValoracion();
			entity.setIdValoracion(searchSequence() + 1);
			entity.setConsumoFarmacos(toma_med);
			entity.setCvCambiosSig(cv_camb_signif);
			entity.setCvEventosSig(cv_event_sig);
			entity.setCvMarcadoresDes(cv_marc_des);
			entity.setDescripcionFarmacos(med);
			entity.setEstatura(estatura);
			entity.setFechaActual(fecha_actual);
			entity.setFrecCardiacaMax(fcm);
			entity.setImc(imc);
			entity.setObsProyectoVida(pv_obs);
			if (presionDiastole != null)
				entity.setPresionDiastolica(presionDiastole.intValue());
			else
				entity.setPresionDiastolica(null);
			if (presionSistole != null)
				entity.setPresionSistolica(presionSistole.intValue());
			else
				entity.setPresionSistolica(null);
			entity.setPerimetroCintura(per_cintura);
			entity.setPeso(peso);
			entity.setPlanSeguimiento(plan_seg);
			entity.setReforzarEn(reforzar_en);
			entity.setVepAsociado(vepAsociado);

			VepValoracionDAO vvDao = new VepValoracionDAO();
			vvDao.save(entity);

			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			if (EntityManagerHelper.getEntityManager().getTransaction()
					.isActive())
				EntityManagerHelper.getEntityManager().getTransaction()
						.rollback();
			throw e;
		}
	}
}
