package co.com.vep.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import org.joda.time.DateTime;

import co.com.coomeva.profile.ws.client.CaasStub.Role;
import co.com.vep.logica.ConsultoriaLogica;
import co.com.vep.logica.IConsultoria;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.extension.DataRecordConsultoria;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.validadorNumerico;
import co.com.vep.util.reportes.ExportarFactory;

import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;

public class VistaListadoConsultorias extends VistaItemConsultoria {

	private Date sFechaInicio;
	private Date sFechaFin;

	private String sAsesor;
	private String sIdServicio;
	private Integer sEstado;

	private List<DataRecordConsultoria> lstConsultorias;
	private Integer selectedConsultoria = null;
	private HtmlDataTable dataTable;
	private boolean renderInfo = false;
	private Long idRegional;
	private boolean disabledRegional = false;

	private HtmlInputText filteredIdServicio;
	private HtmlInputText filteredAsesor;

	private String exportName;
	private boolean visibleExport = false;

	private String exportNameHtml;
	private boolean visibleExportHtml = false;
	private String selectorDestination;
	private boolean visible = false;

	public VistaListadoConsultorias() {

		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("Consultarexpertos")) {
				initializeComponent();
				lstConsultorias = new ArrayList<DataRecordConsultoria>();
				try {
					String roleUsuario = ((Role) Session
							.getSessionAttribute("Role")).getName();
					idRegional = null;
					if (roleUsuario.toLowerCase().equalsIgnoreCase("coordinador")
							|| roleUsuario.toLowerCase().equalsIgnoreCase("analista")) {

						idRegional = (Long) Session
								.getSessionAttribute("userRegional");
						if (idRegional == null)
							throw new Exception(MessageBundleLoader
									.getMessage("labels.consexp.exception3"));
						else
							disabledRegional = true;
					}
				} catch (Exception e) {
					showException(e);
				}
			}
		}
	}

	private void initializeComponent() {
		disabledRegional = false;
		visibleExport = false;
		visibleExportHtml = false;

		filteredIdServicio = new HtmlInputText();
		filteredIdServicio.addValidator(new validadorNumerico(
				MessageBundleLoader.getMessage("labels.consexp.idservicio"),
				true));
		filteredIdServicio.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				filteredIdServicio.validate(FacesContext.getCurrentInstance());
			}
		});

		filteredAsesor = new HtmlInputText();
		filteredAsesor.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.consexp.idasesor"), true));
		filteredAsesor.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				filteredAsesor.validate(FacesContext.getCurrentInstance());
			}
		});
	}

	public void action_consultar(ActionEvent event) {
		visibleExport = false;
		lstConsultorias = new ArrayList<DataRecordConsultoria>();
		try {

			if (sFechaInicio != null) {
				if (sFechaFin != null) {
					DateTime inicio = new DateTime(sFechaInicio.getTime());
					if (inicio.isAfter(sFechaFin.getTime()))
						throw new Exception(MessageBundleLoader
								.getMessage("labels.consexp.exception1"));
				} else {
					sFechaFin = new Date();
				}
			}

			String axEstado = (sEstado == null) ? null : sEstado.toString();
			if (axEstado != null && axEstado.equals("-1"))
				axEstado = null;

			String axAsesor = (sAsesor != null && sAsesor.trim().length() == 0) ? null
					: sAsesor;
			String axIdServicio = (sIdServicio != null && sIdServicio.trim()
					.length() == 0) ? null : sIdServicio;

			Long axRegional = (idRegional == null) ? null : idRegional;
			if (axRegional != null && axRegional.equals(new Long(-1)))
				axRegional = null;

			IConsultoria logica = new ConsultoriaLogica();
			List<VepDetalleConsultoria> lst = logica.filterAsVep(axIdServicio,
					axAsesor, null, axEstado, sFechaInicio, sFechaFin,
					axRegional);
			if (lst == null || lst.size() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.consexp.exception2"));

			if (!lst.isEmpty()) {
				for (VepDetalleConsultoria vepDetalleConsultoria : lst) {
					lstConsultorias.add(new DataRecordConsultoria(
							vepDetalleConsultoria));
				}
			}

		} catch (Exception e) {
			showException(e);
		}
	}

	public void action_generarExcel(ActionEvent ae) {
		exportName = ExportarFactory.exportar(
				ExportarFactory.types.CONSULTORIAS,
				ExportarFactory.formats.EXCEL, lstConsultorias);
		visibleExport = true;
	}

	public void action_generarHtml(ActionEvent ae) {
		exportNameHtml = ExportarFactory.exportar(
				ExportarFactory.types.CONSULTORIAS,
				ExportarFactory.formats.HTML, lstConsultorias);
		visibleExportHtml = true;
	}

	public void action_limpiar(ActionEvent event) {
		limpiarConsulta();
	}

	private void limpiarConsulta() {
		sEstado = new Integer(-1);
		sAsesor = null;
		sFechaFin = null;
		sFechaInicio = null;
		idRegional = new Long(-1);
	}

	private void showException(Exception e) {
		showException(e.getMessage());
		e.printStackTrace();
	}

	private void showException(String e) {
		FacesMessage msg = new FacesMessage(e);
		FacesContext.getCurrentInstance().addMessage("msg", msg);
	}

	public HtmlInputText getFilteredIdServicio() {
		return filteredIdServicio;
	}

	public void setFilteredIdServicio(HtmlInputText filteredIdServicio) {
		this.filteredIdServicio = filteredIdServicio;
	}

	public HtmlInputText getFilteredAsesor() {
		return filteredAsesor;
	}

	public void setFilteredAsesor(HtmlInputText filteredAsesor) {
		this.filteredAsesor = filteredAsesor;
	}

	public String getSAsesor() {
		return sAsesor;
	}

	public void setSAsesor(String asesor) {
		sAsesor = asesor;
	}

	public String getSIdServicio() {
		return sIdServicio;
	}

	public void setSIdServicio(String idServicio) {
		sIdServicio = idServicio;
	}

	public Date getSFechaInicio() {
		return sFechaInicio;
	}

	public void setSFechaInicio(Date fechaInicio) {
		sFechaInicio = fechaInicio;
	}

	public Date getSFechaFin() {
		return sFechaFin;
	}

	public void setSFechaFin(Date fechaFin) {
		sFechaFin = fechaFin;
	}

	public Integer getSEstado() {
		return sEstado;
	}

	public void setSEstado(Integer estado) {
		sEstado = estado;
	}

	public List<DataRecordConsultoria> getLstConsultorias() {
		return lstConsultorias;
	}

	public void setLstConsultorias(List<DataRecordConsultoria> lstConsultorias) {
		this.lstConsultorias = lstConsultorias;
	}

	public Integer getSelectedConsultoria() {
		return selectedConsultoria;
	}

	public void setSelectedConsultoria(Integer selectedConsultoria) {
		this.selectedConsultoria = selectedConsultoria;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public boolean isRenderInfo() {
		return renderInfo;
	}

	public void setRenderInfo(boolean renderInfo) {
		this.renderInfo = renderInfo;
	}

	public Long getIdRegional() {
		return idRegional;
	}

	public void setIdRegional(Long idRegional) {
		this.idRegional = idRegional;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getSelectorDestination() {
		return selectorDestination;
	}

	public void setSelectorDestination(String selectorDestination) {
		this.selectorDestination = selectorDestination;
	}

	public void rowSelection(ActionEvent e) {
		try {
			DataRecordConsultoria drc = (DataRecordConsultoria) dataTable
					.getRowData();
			selectedConsultoria = drc.getId();
			renderInfo = true;
			mostrarConsultoria(selectedConsultoria);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	public boolean isDisabledRegional() {
		return disabledRegional;
	}

	public void setDisabledRegional(boolean disabledRegional) {
		this.disabledRegional = disabledRegional;
	}

}
