package co.com.vep.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import co.com.parametros.modelo.Parametros;
import co.com.vep.logica.BeneficiarioLogica;
import co.com.vep.logica.ConsultorLogica;
import co.com.vep.logica.ConsultoriaLogica;
import co.com.vep.logica.DetalleConsultoriaLogica;
import co.com.vep.logica.IBeneficiario;
import co.com.vep.logica.IConsultor;
import co.com.vep.logica.IConsultoria;
import co.com.vep.logica.RegionalLogica;
import co.com.vep.modelo.VepBeneficiario;
import co.com.vep.modelo.VepBitacoraConsultoria;
import co.com.vep.modelo.VepConsultoria;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.modelo.extension.Beneficiario;
import co.com.vep.modelo.extension.Consultor;
import co.com.vep.modelo.extension.DataRecordBeneficiario;
import co.com.vep.modelo.extension.Informe;
import co.com.vep.persistencia.VepConsultoriaDAO;
import co.com.vep.seguridad.Session;
import co.com.vep.util.FacesUtils;

public class VistaItemConsultoria {

	private Integer id = null;
	private String estado = null;
	private String estadoId;
	private String nombreConsultoria = null;
	private String descripcionConsultoria = null;
	private Date fechaInicioConsultoria = null;
	private Long beneficiadosConsultoria = null;
	private Date fechaTerminacionConsultoria = null;
	private String regional = null;
	private List<Consultor> lstConsultores;
	private List<DataRecordBeneficiario> lstBeneficiarios;
	private List<Informe> lstInformes;

	public VistaItemConsultoria() {
		try {
			if (Session.isSessionAlive()) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarConsultoria(Integer idConsultoria) {
		try {
			DetalleConsultoriaLogica detalle = new DetalleConsultoriaLogica();
			List<VepDetalleConsultoria> vdc = detalle
					.obtenerByConsultoria(idConsultoria);
			if (vdc.isEmpty())
				throw new Exception("Consultoria no existe");

			VepDetalleConsultoria item = vdc.get(0);
			VepConsultoria vc = new VepConsultoria();
			this.id = item.getIdDetallecons();

			List<SelectItem> lstEstado = ((LOVsVista) FacesUtils
					.getManagedBean("LOVs")).getEstadoConsultoria();
			this.estadoId = item.getEstado();
			for (SelectItem Ge : lstEstado) {
				if (Ge.getValue().toString().equals(item.getEstado())) {
					this.estado = Ge.getLabel();
					break;
				}
			}

			vc = new VepConsultoriaDAO().findById(item.getIdServicioCon());

			this.nombreConsultoria = vc.getNombre();
			this.descripcionConsultoria = vc.getDescripcion();
			this.fechaInicioConsultoria = item.getFechaIni();
			if (item.getNumBeneficiados() == null)
				this.beneficiadosConsultoria = new Long(0);
			else
				this.beneficiadosConsultoria = item.getNumBeneficiados();

			RegionalLogica regional = new RegionalLogica();
			Parametros pRegional = regional.obtenerRegionalAsParametro(item
					.getIdRegional());
			this.regional = pRegional.getDescripcionParam();

			lstConsultores = new ArrayList<Consultor>();

			IConsultor consultor = new ConsultorLogica();
			List<VepPlusBuc> consultores = consultor
					.obtenerAsBucByDetalle(item);
			if (consultores != null) {
				for (VepPlusBuc vepConsultor : consultores) {
					System.out.println(vepConsultor.getNumintAsociado());
					Consultor cons = new Consultor(vepConsultor);
					if (cons != null)
						lstConsultores.add(cons);
				}
			}

			lstBeneficiarios = new ArrayList<DataRecordBeneficiario>();

			IBeneficiario beneficiado = new BeneficiarioLogica();
			List<VepBeneficiario> beneficiados = beneficiado
					.obtenerAsBucByConsultoria(item.getIdDetallecons());
			DataRecordBeneficiario drb = new DataRecordBeneficiario();
			if (beneficiados != null) {
				for (VepBeneficiario vepBeneficiado : beneficiados) {
					// Beneficiario benef = new Beneficiario(vepBeneficiado);
					if (vepBeneficiado != null) {
						List<SelectItem> lstTituloProfesional = ((LOVsVista) FacesUtils
								.getManagedBean("LOVs")).getTiposIdentificacion();
						for (SelectItem TP : lstTituloProfesional) {
							if (vepBeneficiado.getId().getTipoDocumento().equals(new Long(TP.getValue().toString()))) {
								drb.setTipoDocumento(TP.getLabel());
								break;
							}
						}

						drb.setBeneficiado(vepBeneficiado);
						lstBeneficiarios.add(drb);
					}
				}
			}

			lstInformes = new ArrayList<Informe>();

			IConsultoria consultoria = new ConsultoriaLogica();
			List<VepBitacoraConsultoria> bitacora = consultoria
					.obtenerBitacora(idConsultoria);
			if (bitacora != null) {
				for (VepBitacoraConsultoria informe : bitacora) {
					lstInformes.add(new Informe(informe));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the nombreConsultoria
	 */
	public String getNombreConsultoria() {
		return nombreConsultoria;
	}

	/**
	 * @param nombreConsultoria
	 *            the nombreConsultoria to set
	 */
	public void setNombreConsultoria(String nombreConsultoria) {
		this.nombreConsultoria = nombreConsultoria;
	}

	/**
	 * @return the descripcionConsultoria
	 */
	public String getDescripcionConsultoria() {
		return descripcionConsultoria;
	}

	/**
	 * @param descripcionConsultoria
	 *            the descripcionConsultoria to set
	 */
	public void setDescripcionConsultoria(String descripcionConsultoria) {
		this.descripcionConsultoria = descripcionConsultoria;
	}

	/**
	 * @return the regional
	 */
	public String getRegional() {
		return regional;
	}

	/**
	 * @param regional
	 *            the regional to set
	 */
	public void setRegional(String regional) {
		this.regional = regional;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the lstConsultores
	 */
	public List<Consultor> getLstConsultores() {
		return lstConsultores;
	}

	/**
	 * @param lstConsultores
	 *            the lstConsultores to set
	 */
	public void setLstConsultores(List<Consultor> lstConsultores) {
		this.lstConsultores = lstConsultores;
	}

	/**
	 * @return the lstBeneficiarios
	 */
	public List<DataRecordBeneficiario> getLstBeneficiarios() {
		return lstBeneficiarios;
	}

	/**
	 * @param lstBeneficiarios
	 *            the lstBeneficiarios to set
	 */
	public void setLstBeneficiarios(List<DataRecordBeneficiario> lstBeneficiarios) {
		this.lstBeneficiarios = lstBeneficiarios;
	}

	/**
	 * @return the lstInformes
	 */
	public List<Informe> getLstInformes() {
		return lstInformes;
	}

	/**
	 * @param lstInformes
	 *            the lstInformes to set
	 */
	public void setLstInformes(List<Informe> lstInformes) {
		this.lstInformes = lstInformes;
	}

	/**
	 * @return the fechaInicioConsultoria
	 */
	public Date getFechaInicioConsultoria() {
		return fechaInicioConsultoria;
	}

	/**
	 * @param fechaInicioConsultoria
	 *            the fechaInicioConsultoria to set
	 */
	public void setFechaInicioConsultoria(Date fechaInicioConsultoria) {
		this.fechaInicioConsultoria = fechaInicioConsultoria;
	}

	/**
	 * @return the fechaTerminacionConsultoria
	 */
	public Date getFechaTerminacionConsultoria() {
		return fechaTerminacionConsultoria;
	}

	/**
	 * @param fechaTerminacionConsultoria
	 *            the fechaTerminacionConsultoria to set
	 */
	public void setFechaTerminacionConsultoria(Date fechaTerminacionConsultoria) {
		this.fechaTerminacionConsultoria = fechaTerminacionConsultoria;
	}

	/**
	 * @return the beneficiadosConsultoria
	 */
	public Long getBeneficiadosConsultoria() {
		return beneficiadosConsultoria;
	}

	/**
	 * @param beneficiadosConsultoria
	 *            the beneficiadosConsultoria to set
	 */
	public void setBeneficiadosConsultoria(Long beneficiadosConsultoria) {
		this.beneficiadosConsultoria = beneficiadosConsultoria;
	}

	public String getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

}
