package co.com.vep.vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.joda.time.DateTime;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.logica.AsociadoLogica;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.modelo.extension.DataRecordVepPlusAsociado;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.reportes.ExportarFactory;

import com.icesoft.faces.component.ext.HtmlDataTable;

public class VistaConsultarCumple extends VistaRegistroAsociado {

	private Date fechaIni;
	private Date fechaFin;
	private List<VepPlusBuc> lista_aso;

	private boolean visible = false;
	private HtmlDataTable dataTable;

	private String exportName;
	private boolean visibleExport = false;

	private String exportNameHtml;
	private boolean visibleExportHtml = false;
	private List<DataRecordVepPlusAsociado> lista_asociado = new ArrayList<DataRecordVepPlusAsociado>();

	public VistaConsultarCumple() {
		initializeComponent();
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("ConsultarCumpleanos")) {

			}
		}
	}

	private void initializeComponent() {
		visibleExport = false;
		visibleExportHtml = false;
	}

	public void action_generarConsultaCumple(ActionEvent ae) {
		visibleExport = false;
		visibleExportHtml = false;

		try {

			if (fechaIni != null) {
				if (fechaFin == null) {
					Calendar hoy = Calendar.getInstance();
					fechaFin = hoy.getTime();
				} else {
					DateTime inicio = new DateTime(fechaIni.getTime());
					if (inicio.isAfter(fechaFin.getTime())
							|| inicio.isEqual(fechaFin.getTime()))
						throw new Exception(
								"La fecha inicial no podra ser mayor o igual que la fecha final");
				}
			} else if (fechaFin == null) {
				throw new Exception(
						"Debe especificar la fecha de inicio o eliminar la fecha final para ejecutar la consulta para todas las fechas posibles");
			} else {
				fechaIni = null;
				fechaFin = null;
			}

			Date fechaIni1 = new Date(fechaIni.getTime() + 86400000);
			Date fechaFin1 = new Date(fechaFin.getTime() + 86400000);
			AsociadoLogica asociado = new AsociadoLogica();
			// lista_aso = asociado.obtenerCumpleanos(fechaIni, fechaFin);
			lista_asociado = asociado.obtenerCumpleanosHQL(fechaIni1, fechaFin1);
			if (lista_asociado == null || lista_asociado.size() == 0)
				throw new Exception("No se obtuvieron datos para la consulta");
		} catch (Exception e) {
			showException(e);
		}
	}

	public void action_generarExcel(ActionEvent ae) {
		exportName = ExportarFactory.exportar(ExportarFactory.types.CUMPLEANOS,
				ExportarFactory.formats.EXCEL, lista_aso);
		visibleExport = true;
	}

	public void action_generarHtml(ActionEvent ae) {
		exportNameHtml = ExportarFactory.exportar(
				ExportarFactory.types.CUMPLEANOS, ExportarFactory.formats.HTML,
				lista_aso);
		visibleExportHtml = true;
	}

	private void showException(String e) {
		FacesMessage msg = new FacesMessage(e);
		FacesContext.getCurrentInstance().addMessage("msg", msg);
	}

	private void showException(Exception e) {
		showException(e.getMessage());
		e.printStackTrace();
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<VepPlusBuc> getLista_aso() {
		return lista_aso;
	}

	public void setLista_aso(List<VepPlusBuc> lista_aso) {
		this.lista_aso = lista_aso;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	private void limpiar() {
		fechaIni = null;
		fechaFin = null;
		nombre1 = null;
		nombre2 = null;
		apellido1 = null;
		apellido2 = null;
		fechaNace = null;
		edad = null;
		genero = null;
		codigoAsociado = null;
		estadoAsociado = null;
		fechaIngresoAsociado = null;
		corte = null;
		fechaIngVEP = null;
		direccionResidencia = null;
		ciuRes = null;
		dirComercial = null;
		ciuCom = null;
		telefonoResidencia = null;
		telefonoComercial = null;
		telefonoCelular = null;
		correoElectrinico = null;
		tituloProfesionalLabel = null;
		ocupacionLabel = null;
		estadoCivilLabel = null;
		tipoSangre = null;
	}

	public void rowSelection(ActionEvent e) {
		limpiar();
		visible = true;
		try {
			DataRecordVepPlusAsociado drc = (DataRecordVepPlusAsociado) dataTable.getRowData();
			mostrarRegistro(drc.getVepPlusBuc());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	public List<DataRecordVepPlusAsociado> getLista_asociado() {
		return lista_asociado;
	}

	public void setLista_asociado(List<DataRecordVepPlusAsociado> lista_asociado) {
		this.lista_asociado = lista_asociado;
	}

}
