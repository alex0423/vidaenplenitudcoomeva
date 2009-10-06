package co.com.vep.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.event.ActionEvent;

import co.com.vep.logica.AsociadoLogica;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.reportes.ExportarFactory;
import co.com.vep.vista.excepciones.VepException;

import com.icesoft.faces.component.ext.HtmlDataTable;

public class VistaConsultarInscripcion extends VistaAgregarAsociado {

	private Long sTituloProfesional;
	private Long sEstadoCivil;

	private Date sFechaIngresoAsociado;
	private Date sFechaNace;
	private Long sGenero;
	private String sTipoSangre;
	private Vector<Integer> atributos;
	private Long sTipoid;
	private Long sTipoAsociado;
	private String sCedula;
	private boolean visible = false;

	private HtmlDataTable dataTable;

	private Integer[] filteredServMedico;
	private Integer[] filteredPAMS;
	private Integer[] filteredHobbies;
	private Integer[] filteredPatologias;

	private String mensajeError;
	private List<VepPlusBuc> lista_aso;

	private boolean modalRendered = false;

	private String message;
	private String messageTittle;

	private String exportName;
	private boolean visibleExport = false;

	private String exportNameHtml;
	private boolean visibleExportHtml = false;

	public VistaConsultarInscripcion() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("ConsultarInscripcion")) {
				initializeComponent();
			}
		}
	}

	private void initializeComponent() {
		visibleExport = false;
		visibleExportHtml = false;
		resetMessages();
		lista_aso = new ArrayList<VepPlusBuc>();
	}

	public void action_realizarConsulta(ActionEvent ae) {
		visibleExport = false;
		visibleExportHtml = false;
		resetMessages();
		lista_aso = new ArrayList<VepPlusBuc>();
		try {
			String axTipoAsociado = (sTipoAsociado == null) ? null
					: sTipoAsociado.toString();
			if (axTipoAsociado != null && axTipoAsociado.equals("-1"))
				axTipoAsociado = null;

			String axTipoId = (sTipoid == null) ? null : sTipoid.toString();
			if (axTipoId != null && axTipoId.equals("-1"))
				axTipoId = null;

			String axEstadoCivil = (sEstadoCivil == null) ? null : sEstadoCivil
					.toString();
			if (axEstadoCivil != null && axEstadoCivil.equals("-1"))
				axEstadoCivil = null;

			String axTituloProfesional = (sTituloProfesional == null) ? null
					: sTituloProfesional.toString();
			if (axTituloProfesional != null && axTituloProfesional.equals("-1"))
				axTituloProfesional = null;

			if (sCedula != null && sCedula.trim().length() == 0)
				sCedula = null;

			atributos = new Vector<Integer>();
			for (Integer item : filteredPAMS) {
				atributos.add(item);
			}

			for (Integer item : filteredServMedico) {
				atributos.add(item);
			}
			
			for (Integer item : filteredHobbies) {
				atributos.add(item);
			}
			
			for (Integer item : filteredPatologias) {
				atributos.add(item);
			}

			if (atributos != null && atributos.size() == 0)
				atributos = null;

			String axTipoSangre = (sTipoSangre == null) ? null : sTipoSangre
					.toString();
			if (sTipoSangre != null && sTipoSangre.equals("-1"))
				axTipoSangre = null;

			String axGenero = null;
			if (sGenero == 1)
				axGenero = "M";
			else if (sGenero == 2)
				axGenero = "F";

			AsociadoLogica asociado = new AsociadoLogica();
			lista_aso = asociado.filterAsVep(axTipoAsociado, axTipoId, sCedula,
					axTipoSangre, axGenero, axEstadoCivil, sFechaNace,
					sFechaIngresoAsociado, axTituloProfesional, atributos);
			if (lista_aso.size() == 0)
				throw new Exception(
						"No se encontraron resultados para la consulta");

		} catch (Exception e) {
			setMessageTittle(MessageBundleLoader.getMessage("labels.titulo"));
			setMessage(e.getMessage());
			toggleModal();
			VepException.displayError(e);
		}
	}

	public void action_generarExcel(ActionEvent ae) {
		exportName = ExportarFactory.exportar(
				ExportarFactory.types.INSCRIPCIONES,
				ExportarFactory.formats.EXCEL, lista_aso);
		visibleExport = true;
	}

	public void action_generarHtml(ActionEvent ae) {
		exportNameHtml = ExportarFactory.exportar(
				ExportarFactory.types.INSCRIPCIONES,
				ExportarFactory.formats.HTML, lista_aso);
		visibleExportHtml = true;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the messageTittle
	 */
	public String getMessageTittle() {
		return messageTittle;
	}

	/**
	 * @param messageTittle
	 *            the messageTittle to set
	 */
	public void setMessageTittle(String messageTittle) {
		this.messageTittle = messageTittle;
	}

	public void toggleModal() {
		modalRendered = !modalRendered;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	/**
	 * @return the modalRendered
	 */
	public boolean isModalRendered() {
		return modalRendered;
	}

	/**
	 * @param modalRendered
	 *            the modalRendered to set
	 */
	public void setModalRendered(boolean modalRendered) {
		this.modalRendered = modalRendered;
	}

	private void resetMessages() {
		setMessage("");
		setMessageTittle("");
	}

	public void vaciarCampos() {
	}

	public List<VepPlusBuc> getLista_aso() {
		return lista_aso;
	}

	public void setLista_aso(List<VepPlusBuc> lista_aso) {
		this.lista_aso = lista_aso;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public Vector<Integer> getAtributos() {
		return atributos;
	}

	public void setAtributos(Vector<Integer> atributos) {
		this.atributos = atributos;
	}

	public Integer[] getFilteredServMedico() {
		return filteredServMedico;
	}

	public void setFilteredServMedico(Integer[] selectedServMedico) {
		this.filteredServMedico = selectedServMedico;
	}

	public Integer[] getFilteredPAMS() {
		return filteredPAMS;
	}

	public void setFilteredPAMS(Integer[] selectedPAMS) {
		this.filteredPAMS = selectedPAMS;
	}

	private void limpiarFiltros() {
		estadoCivil = null;
		fechaNace = null;
		fechaIngVEP = null;
		genero = null;
		ocupacion = null;
		tipoSangre = null;
	}

	public void rowSelection(ActionEvent e) {
		limpiarFiltros();
		visible = true;
		try {
			VepPlusBuc drc = (VepPlusBuc) dataTable.getRowData();
			mostrarRegistro(drc);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public Long getSTituloProfesional() {
		return sTituloProfesional;
	}

	public void setSTituloProfesional(Long tituloProfesional) {
		sTituloProfesional = tituloProfesional;
	}

	public Long getSEstadoCivil() {
		return sEstadoCivil;
	}

	public void setSEstadoCivil(Long estadoCivil) {
		sEstadoCivil = estadoCivil;
	}

	public Date getSFechaIngresoAsociado() {
		return sFechaIngresoAsociado;
	}

	public void setSFechaIngresoAsociado(Date fechaIngresoAsociado) {
		sFechaIngresoAsociado = fechaIngresoAsociado;
	}

	public Date getSFechaNace() {
		return sFechaNace;
	}

	public void setSFechaNace(Date fechaNace) {
		sFechaNace = fechaNace;
	}

	public Long getSGenero() {
		return sGenero;
	}

	public void setSGenero(Long genero) {
		sGenero = genero;
	}

	public String getSTipoSangre() {
		return sTipoSangre;
	}

	public void setSTipoSangre(String tipoSangre) {
		sTipoSangre = tipoSangre;
	}

	public Long getSTipoid() {
		return sTipoid;
	}

	public void setSTipoid(Long tipoid) {
		sTipoid = tipoid;
	}

	public Long getSTipoAsociado() {
		return sTipoAsociado;
	}

	public void setSTipoAsociado(Long tipoAsociado) {
		sTipoAsociado = tipoAsociado;
	}

	public String getSCedula() {
		return sCedula;
	}

	public void setSCedula(String cedula) {
		sCedula = cedula;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getExportName() {
		return exportName;
	}

	public void setExportName(String exportName) {
		this.exportName = exportName;
	}

	public boolean isVisibleExport() {
		return visibleExport;
	}

	public void setVisibleExport(boolean visibleExport) {
		this.visibleExport = visibleExport;
	}

	public String getExportNameHtml() {
		return exportNameHtml;
	}

	public void setExportNameHtml(String exportNameHtml) {
		this.exportNameHtml = exportNameHtml;
	}

	public boolean isVisibleExportHtml() {
		return visibleExportHtml;
	}

	public void setVisibleExportHtml(boolean visibleExportHtml) {
		this.visibleExportHtml = visibleExportHtml;
	}

	public Integer[] getFilteredHobbies() {
		return filteredHobbies;
	}

	public void setFilteredHobbies(Integer[] filteredHobbies) {
		this.filteredHobbies = filteredHobbies;
	}

	public Integer[] getFilteredPatologias() {
		return filteredPatologias;
	}

	public void setFilteredPatologias(Integer[] filteredPatologias) {
		this.filteredPatologias = filteredPatologias;
	}

}
