/**
 * 
 */
package co.com.vep.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWSServiceLocator;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepBeneficiario;
import co.com.vep.modelo.VepBeneficiarioId;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.modelo.extension.DataRecordVepPlusAsociado;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepAsociadoDAO;
import co.com.vep.persistencia.IQueryVepAtributoAsociadoDAO;
import co.com.vep.persistencia.IQueryVepPlusBucDAO;
import co.com.vep.persistencia.QueryVepAsociadoDAO;
import co.com.vep.persistencia.QueryVepAtributoAsociadoDAO;
import co.com.vep.persistencia.QueryVepPlusBucDAO;
import co.com.vep.persistencia.VepBeneficiarioDAO;

/**
 * @author Juank
 * 
 */
public class AsociadoLogica implements IAsociado {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IAsociado#obtenerAsVep(java.lang.Long)
	 */
	public VepAsociado obtenerAsVep(Long identificacion,
			Integer tipoIdentificacion) throws Exception {
		VepAsociado asociado = new VepAsociado();
		try {
			DelegadoAsociadoVidaWSServiceLocator locator = new DelegadoAsociadoVidaWSServiceLocator();
			DelegadoAsociadoVidaWS service = locator.getdatosAsociadoVida();
			AsociadoVida asoc = service.consultarAsociadoVida(identificacion,
					tipoIdentificacion);
			asociado = obtener(new Long(asoc.getCodTipDocumento()), new Long(
					asoc.getNumDocumento()));
			return asociado;
		} catch (Exception e) {
			throw e;
		}
	}

	public VepPlusBuc obtenerDetalleBUC(Long identificacion, Long tipoId)
			throws Exception {
		VepPlusBuc vpb = new VepPlusBuc();
		try {
			IQueryVepPlusBucDAO qvppbDao = new QueryVepPlusBucDAO();
			vpb = qvppbDao.findbyid(identificacion, tipoId);
			return vpb;
		} catch (Exception e) {
			e.printStackTrace();
			return vpb;
		}
	}

	public List<VepAtributoAsociado> obtenerDetalleAtributos(Long idAsociado)
			throws Exception {
		try {
			IQueryVepAtributoAsociadoDAO iqvaaDao = new QueryVepAtributoAsociadoDAO();
			return iqvaaDao.obtenerByAsociado(idAsociado);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IAsociado#validar(java.lang.Long)
	 */
	public boolean validar(Long tipoId, Long identificacion) {
		try {
			if (obtener(tipoId, identificacion) != null)
				return true;
			return false;
		} catch (Exception e) {
			return false;
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
			e.printStackTrace();
			throw new Exception("Registro no encontrado");
		}
	}

	public VepAsociado obtener(Long tipoId, Long id) throws Exception {
		try {
			return (VepAsociado) EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepasociado.findbyasociado")
					.setParameter("tipoId", tipoId.toString()).setParameter(
							"documento", id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			//throw new Exception("Registro no encontrado");
		}
	}

	public VepAsociado obtenerOnlyDocumento(Long id) throws Exception {
		try {
			return (VepAsociado) EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepasociado.findbydocumento")
					.setParameter("documento", id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Registro no encontrado");
		}
	}

	public void registrar(Long idAsociado, String tipoSangre,
			String compartirConocimientos, Date fechaIngresovp,
			String validacionAspirante, String tipoAsociado,
			Long numeroHorasDispSv, String estodoAsociado, Long idAcudiente,
			String medicamentos, String tipoDocumento, Long documento,
			String tipoDocumentoAcu, Long documentoAcudiente, Date fechaNace)
			throws Exception {

		try {
			VepAsociado asociado = new VepAsociado();
			asociado.setIdAsociado(idAsociado);
			asociado.setTipoSangre(tipoSangre);
			asociado.setCompartirConocimientos(compartirConocimientos);
			asociado.setFechaIngresovp(fechaIngresovp);
			asociado.setValidacionAspirante(validacionAspirante);
			asociado.setNumeroHorasDispSv(numeroHorasDispSv);
			asociado.setTipoAsociado(tipoAsociado);
			asociado.setEstodoAsociado(estodoAsociado);
			asociado.setIdAcudiente(idAcudiente);
			asociado.setMedicamentos(medicamentos);
			asociado.setTipoDocumento(tipoDocumento);
			asociado.setDocumento(documento);
			asociado.setTipoDocumentoAcu(tipoDocumentoAcu);
			asociado.setDocumentoAcudiente(documentoAcudiente);
			asociado.setFechaNace(fechaNace);
			registrar(asociado);
		} catch (Exception e) {
			throw e;
		}
	}

	public void registrar(Long idAsociado, String tipoSangre,
			String compartirConocimientos, String tipoAsociado,
			String estodoAsociado, String tipoDocumento, Long documento)
			throws Exception {

		try {
			VepAsociado asociado = new VepAsociado();
			asociado.setIdAsociado(idAsociado);
			asociado.setTipoSangre(tipoSangre);
			asociado.setCompartirConocimientos(compartirConocimientos);
			asociado.setTipoAsociado(tipoAsociado);
			asociado.setEstodoAsociado(estodoAsociado);
			asociado.setTipoDocumento(tipoDocumento);
			asociado.setDocumento(documento);
			registrar(asociado);
		} catch (Exception e) {
			throw e;
		}
	}

	private void registrar(VepAsociado entity) throws Exception {

		IQueryVepAsociadoDAO iqva = new QueryVepAsociadoDAO();
		try {
			iqva.insert(entity);
		} catch (Exception e) {
			throw e;
		}

	}

	public List<VepPlusBuc> filterAsVep(String tipoAsociado,
			String tipoDocumento, String documento, String tipoSangre,
			String genero, String estadoCivil, Date fechaNace,
			Date fechaIngreso, String ocupacion, Vector<Integer> atributos)
			throws Exception {
		try {
			IQueryVepPlusBucDAO iqvpbDao = new QueryVepPlusBucDAO();
			return iqvpbDao.findByFilter(tipoAsociado, tipoDocumento,
					documento, tipoSangre, genero, estadoCivil, fechaNace,
					fechaIngreso, ocupacion, atributos);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepPlusBuc> obtenerCumpleanos(Date fechaIni, Date fechaFin)
			throws Exception {
		try {
			IQueryVepPlusBucDAO iqvpbDao = new QueryVepPlusBucDAO();
			return iqvpbDao.findByBirthday(fechaIni, fechaFin);
		} catch (Exception e) {
			throw e;
		}
	}

	public VepBeneficiario obtenerBeneficiario(Long tipoId, Long numDocumento)
			throws Exception {
		// TODO Auto-generated method stub
		VepBeneficiarioId idbeneficiario = new VepBeneficiarioId(tipoId,
				numDocumento);
		VepBeneficiario vb = new VepBeneficiario();

		try {
			vb = new VepBeneficiarioDAO().findById(idbeneficiario);
			return vb;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return vb;
		}
	}

	// public List<DataRecordVepPlusAsociado> obtenerCumpleanosHQL(Date
	// fechaIni, Date fechaFin)
	// throws Exception {
	// try {
	// List<VepAsociado> listaAsociado = new ArrayList<VepAsociado>();
	// List<DataRecordVepPlusAsociado> listaAsociadoBUC = new
	// ArrayList<DataRecordVepPlusAsociado>();
	// DataRecordVepPlusAsociado drvpa;
	// IQueryVepPlusBucDAO iqvpbDao = new QueryVepPlusBucDAO();
	// listaAsociado = iqvpbDao.findByBirthdayHQL(fechaIni, fechaFin);
	// for (VepAsociado vepAsociado : listaAsociado) {
	// drvpa = new DataRecordVepPlusAsociado();
	// drvpa.setVepAsociado(vepAsociado);
	// drvpa.setAsociadoVida(this.obtenerAsAsociado(vepAsociado
	// .getDocumento(), Integer.valueOf(vepAsociado
	// .getTipoDocumento())));
	// listaAsociadoBUC.add(drvpa);
	// }
	// return listaAsociadoBUC;
	// } catch (Exception e) {
	// throw e;
	// }
	// }

	public List<DataRecordVepPlusAsociado> obtenerCumpleanosHQL(Date fechaIni,
			Date fechaFin) throws Exception {
		try {
			List<VepPlusBuc> listaAsociado = new ArrayList<VepPlusBuc>();
			List<DataRecordVepPlusAsociado> listaAsociadoBUC = new ArrayList<DataRecordVepPlusAsociado>();
			DataRecordVepPlusAsociado drvpa;
		
			listaAsociado = new QueryVepPlusBucDAO().findByBirthdayHQL1(fechaIni, fechaFin);
			for (VepPlusBuc vepAsociado : listaAsociado) {
				drvpa = new DataRecordVepPlusAsociado();
				//drvpa.setVepAsociado(vepAsociado);
				drvpa.setVepPlusBuc(vepAsociado);
				listaAsociadoBUC.add(drvpa);
			}
			return listaAsociadoBUC;
		} catch (Exception e) {
			throw e;
		}
	}
}
