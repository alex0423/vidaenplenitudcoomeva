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
import co.com.vep.modelo.VepBeneficiado;
import co.com.vep.modelo.VepBeneficiadoConsultoria;
import co.com.vep.modelo.VepBeneficiario;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepBeneficiarioDAO;
import co.com.vep.persistencia.QueryVepBeneficiarioDAO;
import co.com.vep.persistencia.VepBeneficiadoConsultoriaDAO;
import co.com.vep.persistencia.VepBeneficiadoDAO;

/**
 * @author Juank
 * 
 */
public class BeneficiarioLogica implements IBeneficiario {

	public VepBeneficiado obtener(Integer identificacion) throws Exception {
		VepBeneficiadoDAO beneficiario = new VepBeneficiadoDAO();
		try {
			return beneficiario.findById(identificacion);
		} catch (Exception e) {
			throw e;
		}
	}

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

	public VepAsociado obtenerAsVep(Long identificacion,
			Integer tipoIdentificacion) throws Exception {
		VepAsociado asociado = new VepAsociado();
		try {
			DelegadoAsociadoVidaWSServiceLocator locator = new DelegadoAsociadoVidaWSServiceLocator();
			DelegadoAsociadoVidaWS service = locator.getdatosAsociadoVida();
			AsociadoVida asoc = service.consultarAsociadoVida(identificacion,
					tipoIdentificacion);
			asociado.setDocumento(new Long(asoc.getNumDocumento()));
			asociado.setIdAsociado(asoc.getNumInt());
			return asociado;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean validar(Integer identificacion, Integer idConsultoria,
			Integer tipoIdentificacion) {
		try {
			VepBeneficiado vb = (VepBeneficiado) EntityManagerHelper
					.getEntityManager().createNamedQuery(
							"vepbeneficiado.findByConsultoria").setParameter(
							"tipoDocumento", tipoIdentificacion).setParameter(
							"idBeneficiario", identificacion).setParameter(
							"idConsultoria", idConsultoria).getSingleResult();
			if (vb != null)
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validar(Integer identificacion) {
		try {
			VepBeneficiado findit = obtener(identificacion);
			if (findit != null)
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public void registrar(Integer idConsultoria, Integer idAsociado,
//			Integer idTipoIdentificacion) throws Exception {
//
//		VepDetalleConsultoria vdc = new VepDetalleConsultoria();
//		VepBeneficiadoConsultoria vb = new VepBeneficiadoConsultoria();
//
//		VepBeneficiadoConsultoriaDAO iqvb = new VepBeneficiadoConsultoriaDAO();
//		try {
//
//			AsociadoLogica asociado = new AsociadoLogica();
//			if (!asociado.validar(new Long(idAsociado)))
//				throw new Exception(
//						"Debe estar registrado primero en el programa de VEP");
//
//			VepAsociado va = asociado.obtener(new Long(idAsociado));
//			if (!validar(new Integer(va.getDocumento().intValue()),
//					idConsultoria, new Integer(va.getTipoDocumento()))) {
//
//				EntityManagerHelper.getEntityManager().getTransaction().begin();
//
//				vb.setIdBeneficiario(va.getDocumento());
//				vb.setTipoDocumento(Long.valueOf(va.getTipoDocumento()));
//				IConsultoria consultoria = new ConsultoriaLogica();
//				List<VepDetalleConsultoria> lstvdc = consultoria
//						.obtenerDetalle(idConsultoria);
//				vdc = lstvdc.get(0);
//				vb.setIdDetalleCons(vdc.getIdDetallecons());
//
//				iqvb.save(vb);
//
//				EntityManagerHelper.getEntityManager().flush();
//				EntityManagerHelper.getEntityManager().getTransaction()
//						.commit();
//			} else
//				throw new Exception(
//						"Ya existe un registro como beneficiado para esta consultoria");
//		} catch (Exception ex) {
//			if (EntityManagerHelper.getEntityManager().getTransaction()
//					.isActive())
//				EntityManagerHelper.getEntityManager().getTransaction()
//						.rollback();
//			throw ex;
//		}
//	}

	public List<VepBeneficiado> obtenerByConsultoria(Integer idConsultoria)
			throws Exception {
		try {
			return EntityManagerHelper.getEntityManager().createNamedQuery(
					"vepbeneficiado.findAllByConsultoria").setParameter(
					"idConsultoria", idConsultoria).getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepBeneficiario> obtenerAsBucByConsultoria(Integer idConsultoria)
			throws Exception {
		try {
			if (idConsultoria == null)
				return new ArrayList<VepBeneficiario>();

			Query nquery = EntityManagerHelper
					.getEntityManager()
					.createNativeQuery(
							"select bene.numero_documento numero_documento, "
									+ "bene.tipo_documento tipo_documento, bene.nombre nombre, bene.apellido1 apellido1,"
									+ "bene.apellido2 apellido2 from vep.vep_detalle_consultoria detalle, "
									+ "vep.vep_beneficiado_consultoria beneficiado, vep.vep_beneficiario  bene where "
									+ "detalle.ID_DETALLECONS = :idConsultoria and detalle.id_detallecons = beneficiado.id_detalle_cons "
									+ "and beneficiado.tipo_documento = bene.tipo_documento and "
									+ "beneficiado.id_beneficiario = bene.numero_documento",
							VepBeneficiario.class);
			nquery.setParameter("idConsultoria", idConsultoria);
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
