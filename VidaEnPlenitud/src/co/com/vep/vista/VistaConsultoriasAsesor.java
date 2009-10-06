package co.com.vep.vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import co.com.vep.logica.AsociadoLogica;
import co.com.vep.logica.DetalleConsultoriaLogica;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.extension.DataRecordConsultoria;
import co.com.vep.util.MessageBundleLoader;

import com.icesoft.faces.component.ext.HtmlDataTable;

public class VistaConsultoriasAsesor extends VistaItemConsultoria {

	private Long idAsesor = null;

	private List<DataRecordConsultoria> lstConsultorias;
	private Integer selectedConsultoria = null;
	private HtmlDataTable dataTable;
	private boolean renderInfo = false;

	public VistaConsultoriasAsesor() {
	}

	public void mostrarConsultoriasAsesor() throws Exception {
		try {
			if (idAsesor != null)
				mostrarConsultoriasAsesor(idAsesor);
			else
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion1"));
		} catch (Exception e) {
			throw e;
		}
	}

	public void mostrarTodasConsultorias() throws Exception {
		try {
			lstConsultorias = new ArrayList<DataRecordConsultoria>();

			DetalleConsultoriaLogica detalle = new DetalleConsultoriaLogica();
			List<VepDetalleConsultoria> rs = detalle.obtenerTodosAsVep();
			if (!rs.isEmpty()) {
				for (VepDetalleConsultoria vepDetalleConsultoria : rs) {
					lstConsultorias.add(new DataRecordConsultoria(
							vepDetalleConsultoria));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(MessageBundleLoader
					.getMessage("labels.seguimientoBE.excepcion1"));
		}
	}

	public void mostrarConsultoriasAsesor(Long idUsuario) throws Exception {
		// TODO: Reemplazar por session
		try {
			AsociadoLogica asociado = new AsociadoLogica();
			VepAsociado va = asociado.obtenerOnlyDocumento(idUsuario);
			if (va == null)
				throw new Exception("Asociado no encontrado!!");

			lstConsultorias = new ArrayList<DataRecordConsultoria>();

			DetalleConsultoriaLogica detalle = new DetalleConsultoriaLogica();
			List<VepDetalleConsultoria> rs = detalle.obtenerByConsultor(va
					.getIdAsociado());
			if (!rs.isEmpty()) {
				for (VepDetalleConsultoria vepDetalleConsultoria : rs) {
					lstConsultorias.add(new DataRecordConsultoria(
							vepDetalleConsultoria));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(MessageBundleLoader
					.getMessage("labels.seguimientoBE.excepcion1"));
		}
	}

	/**
	 * @return the lstConsultorias
	 */
	public List<DataRecordConsultoria> getLstConsultorias() {
		return lstConsultorias;
	}

	/**
	 * @param lstConsultorias
	 *            the lstConsultorias to set
	 */
	public void setLstConsultorias(List<DataRecordConsultoria> lstConsultorias) {
		this.lstConsultorias = lstConsultorias;
	}

	/**
	 * @return the selectedConsultoria
	 */
	public Integer getSelectedConsultoria() {
		return selectedConsultoria;
	}

	/**
	 * @param selectedConsultoria
	 *            the selectedConsultoria to set
	 */
	public void setSelectedConsultoria(Integer selectedConsultoria) {
		this.selectedConsultoria = selectedConsultoria;
	}

	/**
	 * @return the dataTable
	 */
	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable
	 *            the dataTable to set
	 */
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the renderInfo
	 */
	public boolean isRenderInfo() {
		return renderInfo;
	}

	/**
	 * @param renderInfo
	 *            the renderInfo to set
	 */
	public void setRenderInfo(boolean renderInfo) {
		this.renderInfo = renderInfo;
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

	public Long getIdAsesor() {
		return idAsesor;
	}

	public void setIdAsesor(Long idAsesor) {
		this.idAsesor = idAsesor;
	}

}
