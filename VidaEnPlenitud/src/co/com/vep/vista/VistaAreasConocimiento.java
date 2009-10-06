package co.com.vep.vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import co.com.vep.logica.AsesorLogica;
import co.com.vep.logica.IAsesor;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.modelo.extension.DataRecordAsesor;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.vista.excepciones.VepException;

public class VistaAreasConocimiento {

	private Integer selectedArea = null;
	private List<DataRecordAsesor> lstAsesores;
	private HtmlDataTable dataTable;

	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;

	private String seleccionadoColumnName = "Seleccionado";

	public VistaAreasConocimiento() {
		if (Session.isSessionAlive()) {
			lstAsesores = new ArrayList<DataRecordAsesor>();
		}
	}

	/**
	 * @return the selectedArea
	 */
	public Integer getSelectedArea() {
		return selectedArea;
	}

	/**
	 * @param selectedArea
	 *            the selectedArea to set
	 */
	public void setSelectedArea(Integer selectedArea) {
		this.selectedArea = selectedArea;
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

	/**
	 * @return the autoCentre
	 */
	public boolean isAutoCentre() {
		return autoCentre;
	}

	/**
	 * @param autoCentre
	 *            the autoCentre to set
	 */
	public void setAutoCentre(boolean autoCentre) {
		this.autoCentre = autoCentre;
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

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	public void toggleModal() {
		modalRendered = !modalRendered;
	}

	public void onSelectConocimiento(ValueChangeEvent event) {
		try {
			Integer selectedReg = new Integer(event.getNewValue().toString());
			if (selectedReg == -1) {
			} else {
				lstAsesores = new ArrayList<DataRecordAsesor>();
				selectedArea = selectedReg;

				List<VepPlusBuc> temp = new ArrayList<VepPlusBuc>();
				IAsesor asesor = new AsesorLogica();
				temp = asesor.obtenerAsBucByConocimiento(new Integer(
						selectedReg.intValue()));
				if (temp.size() == 0)
					throw new Exception(
							"No hay asesorias registradas para esta area de conocimiento");

				for (VepPlusBuc item : temp) {
					lstAsesores.add(new DataRecordAsesor(item));
				}
			}
		} catch (Exception ex) {
			setMessageTittle(MessageBundleLoader.getMessage("labels.titulo"));
			setMessage(ex.getMessage());
			toggleModal();
			VepException.displayError(ex);
		}
	}

	/**
	 * @return the lstAsesores
	 */
	public List<DataRecordAsesor> getLstAsesores() {
		if (lstAsesores == null)
			lstAsesores = new ArrayList<DataRecordAsesor>();
		return lstAsesores;
	}

	/**
	 * @param lstAsesores
	 *            the lstAsesores to set
	 */
	public void setLstAsesores(List<DataRecordAsesor> lstAsesores) {
		this.lstAsesores = lstAsesores;
	}

	/**
	 * @return the seleccionadoColumnName
	 */
	public String getSeleccionadoColumnName() {
		return seleccionadoColumnName;
	}

	/**
	 * @param seleccionadoColumnName
	 *            the seleccionadoColumnName to set
	 */
	public void setSeleccionadoColumnName(String seleccionadoColumnName) {
		this.seleccionadoColumnName = seleccionadoColumnName;
	}

	public void setDataTable(HtmlDataTable value) {
		this.dataTable = value;
	}

	public HtmlDataTable getDataTable() {
		return this.dataTable;
	}

	public List<Long> getSelectedAsesores() throws Exception {
		try {
			List<Long> rs = new ArrayList<Long>();
			for (DataRecordAsesor record : lstAsesores) {
				if (record.isSelected()) {
					rs.add(record.getDocumento());
				}
			}
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
