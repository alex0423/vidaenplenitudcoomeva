/**
 * 
 */
package co.com.vep.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWSServiceLocator;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepBeneficiario;
import co.com.vep.modelo.VepConsultor;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepConsultorDAO;
import co.com.vep.persistencia.QueryVepConsultorDAO;

/**
 * @author Juank
 * 
 */
public class ConsultorLogica implements IConsultor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultor#registrar()
	 */
	public void registrar(Long identificacion, Integer tipoIdentificacion,
			Integer idDetalle) throws Exception {

		VepConsultor vc = new VepConsultor();
		VepAsociado va = new VepAsociado();
		VepDetalleConsultoria vdc = new VepDetalleConsultoria();

		IQueryVepConsultorDAO iqvc = new QueryVepConsultorDAO();
		try {
			va = obtenerAsVep(identificacion, tipoIdentificacion);
			vdc = EntityManagerHelper.getEntityManager().find(
					VepDetalleConsultoria.class, idDetalle);

			vc.setVepAsociado(va);
			vc.setVepDetalleConsultoria(vdc);

			EntityManagerHelper.getEntityManager().getTransaction().begin();
			iqvc.insert(vc);
			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			EntityManagerHelper.getEntityManager().getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public VepConsultor obtener(Integer identificacion) throws Exception {
		VepConsultor vc = new VepConsultor();
		try {
			vc = EntityManagerHelper.getEntityManager().find(
					VepConsultor.class, identificacion);
			return vc;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IAsociado#obtenerAsAsociado(java.lang.Long)
	 */
	public AsociadoVida obtenerAsAsociado(Long identificacion,
			Integer tipoIdentificacion) throws Exception {
		AsociadoVida asociado = new AsociadoVida();
		try {
			DelegadoAsociadoVidaWSServiceLocator locator = new DelegadoAsociadoVidaWSServiceLocator();
			DelegadoAsociadoVidaWS service = locator.getdatosAsociadoVida();
			asociado = service.consultarAsociadoVida(identificacion,
					tipoIdentificacion);
			return asociado;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IAsociado#obtenerAsVep(java.lang.Long)
	 */
	public VepAsociado obtenerAsVep(Long identificacion,
			Integer tipoIdentificacion) throws Exception {
		try {
			DelegadoAsociadoVidaWSServiceLocator locator = new DelegadoAsociadoVidaWSServiceLocator();
			DelegadoAsociadoVidaWS service = locator.getdatosAsociadoVida();
			AsociadoVida asoc = service.consultarAsociadoVida(identificacion,
					tipoIdentificacion);

			AsociadoLogica asociado = new AsociadoLogica();
			return asociado.obtener(new Long(asoc.getCodTipDocumento()),
					new Long(asoc.getNumDocumento()));

		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IAsociado#validar(java.lang.Long)
	 */
	public boolean validar(Integer identificacion) {
		try {
			VepConsultor asociado = obtener(identificacion);
			if (asociado != null)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public VepConsultor obtenerByDocumento(Long identificacion)
			throws Exception {

		try {
			return obtener(new Integer(identificacion.intValue()));
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepConsultor> obtenerByDetalle(VepDetalleConsultoria item)
			throws Exception {
		try {
			return EntityManagerHelper.getEntityManager().createNamedQuery(
					"vepconsultor.findbydetalle").setParameter("idDetalle",
					item.getIdDetallecons()).getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepPlusBuc> obtenerAsBucByDetalle(VepDetalleConsultoria item)
			throws Exception {
		try {
			if (item == null || item.getIdDetallecons() == null)
				return new ArrayList<VepPlusBuc>();

			Query nquery = EntityManagerHelper
					.getEntityManager()
					.createNativeQuery(
							"SELECT "
									+ "buc.id, buc.numint_asociado, "
									+ "buc.documento, buc.nombre1_asociado, "
									+ "buc.nombre2_asociado, buc.apellido1_asociado, "
									+ "buc.apellido2_asociado, buc.id_asociado, "
									+ "buc.estado_asociado, buc.FECHA_INGRESOVP, "
									+ "buc.COMPARTIR_CONOCIMIENTOS, buc.DOCUMENTO_ACUDIENTE, "
									+ "buc.nombre1_acudiente, buc.nombre2_acudiente, "
									+ "buc.apellido1_acudiente, buc.apellido2_acudiente, "
									+ "buc.id_acudiente, buc.ESTCIVIL, "
									+ "buc.FECHA_NACE, buc.GENERO, "
									+ "buc.MEDICAMENTOS, buc.NUMERO_HORAS_DISP_SV, "
									+ "buc.OCUPACION, buc.TIPODOCUMENTO_ASOCIADO, "
									+ "buc.TIPODOCUMENTO_ACUDIENTE, buc.TIPO_SANGRE "
									+ "from VEP.VEP_PLUS_BUC buc "
									+ "JOIN ( "
									+ "	select detalle.ID_DETALLECONS, consultor.ID_ASOCIADO "
									+ "	from vep.vep_detalle_consultoria detalle "
									+ "	JOIN vep.VEP_CONSULTOR consultor ON detalle.id_detallecons=consultor.id_detalle_cons "
									+ ") consultor ON consultor.ID_ASOCIADO = buc.numint_asociado "
									+ " where consultor.ID_DETALLECONS = :idDetalle",
							VepPlusBuc.class);
			nquery.setParameter("idDetalle", item.getIdDetallecons());
			return nquery.getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	public VepBeneficiario obtenerBeneficiario(Long tipoId, Long numDocumento)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
