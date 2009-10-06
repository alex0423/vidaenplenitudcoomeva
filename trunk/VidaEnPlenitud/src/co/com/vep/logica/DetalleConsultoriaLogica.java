/**
 * 
 */
package co.com.vep.logica;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepConsultoria;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.VepRegional;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.VepDetalleConsultoriaDAO;

/**
 * @author Juank
 * 
 */
public class DetalleConsultoriaLogica implements IDetalleConsultoria {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IDetalleConsultoria#registrarDetalleConsultoria()
	 */
	public Integer registrarDetalleConsultoria() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<VepDetalleConsultoria> obtenerByConsultoria(VepConsultoria id)
			throws Exception {
		try {
			List<VepDetalleConsultoria> dt = EntityManagerHelper
					.getEntityManager().createNamedQuery(
							"vepdetalleconsultoria.findByConsultoria")
					.setParameter("id", id.getIdServiciocon()).getResultList();
			return dt;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepDetalleConsultoria> obtenerByConsultor(Long id)
			throws Exception {
		try {
			List<VepDetalleConsultoria> dt = EntityManagerHelper
					.getEntityManager().createNamedQuery(
							"vepdetalleconsultoria.findByConsultor")
					.setParameter("id", id).getResultList();
			return dt;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepDetalleConsultoria> obtenerByConsultoria(Integer id)
			throws Exception {
		try {
			List<VepDetalleConsultoria> dt = EntityManagerHelper
					.getEntityManager().createNamedQuery(
							"vepdetalleconsultoria.findByConsultoria")
					.setParameter("id", id).getResultList();
			return dt;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepDetalleConsultoria> obtenerByRegional(VepRegional id)
			throws Exception {
		try {
			List<VepDetalleConsultoria> rs = EntityManagerHelper
					.getEntityManager().createNamedQuery(
							"vepdetalleconsultoria.findByRegional")
					.setParameter("idRegional", id).getResultList();
			return rs;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepDetalleConsultoria> obtenerByRegional(Integer id)
			throws Exception {
		try {
			List<VepDetalleConsultoria> rs = EntityManagerHelper
					.getEntityManager().createNamedQuery(
							"vepdetalleconsultoria.findByRegional")
					.setParameter("idRegional", id).getResultList();
			return rs;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepDetalleConsultoria> obtenerTodosAsVep() throws Exception {
		try {
			List<VepDetalleConsultoria> rs = EntityManagerHelper
					.getEntityManager().createNamedQuery(
							"vepdetalleconsultoria.findAll").getResultList();
			return rs;
		} catch (Exception e) {
			throw e;
		}
	}

	public void actualizarFechaInicioByConsultoria(Integer id, Date date)
			throws Exception {
		try {
			List<VepDetalleConsultoria> lstvdc = obtenerByConsultoria(id);
			VepDetalleConsultoria vdc = lstvdc.get(0);
			vdc.setFechaIni(date);

			VepDetalleConsultoriaDAO vdcDao = new VepDetalleConsultoriaDAO();
			vdcDao.update(vdc);
		} catch (Exception e) {
			EntityManagerHelper.getEntityManager().getTransaction().rollback();
			throw e;
		}
	}

	public void actualizarFechaTerminacionByConsultoria(Integer id, Date date)
			throws Exception {
		try {
			List<VepDetalleConsultoria> lstvdc = obtenerByConsultoria(id);
			VepDetalleConsultoria vdc = lstvdc.get(0);
			vdc.setFechaterm(date);

			VepDetalleConsultoriaDAO vdcDao = new VepDetalleConsultoriaDAO();
			vdcDao.update(vdc);			
		} catch (Exception e) {
			EntityManagerHelper.getEntityManager().getTransaction().rollback();
			throw e;
		}
	}

}
