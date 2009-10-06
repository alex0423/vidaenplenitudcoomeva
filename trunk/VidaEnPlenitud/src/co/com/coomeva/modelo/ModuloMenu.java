package co.com.coomeva.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ModuloMenu {

	private String descripcion;

	private boolean rendered;

	private boolean optionsVisible;

	private OpcionModulo[] opciones = null;

	private HashMap opcionesModulo = null;

	private ArrayList listaOpcionesModulo = null;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public OpcionModulo[] getOpciones() {
		return opciones;
	}

	public void setOpciones(OpcionModulo[] opciones) {
		this.opciones = opciones;
	}

	public HashMap getOpcionesModulo() {
		if (opcionesModulo == null)
			opcionesModulo = new HashMap();
		return opcionesModulo;
	}

	public void setOpcionesModulo(HashMap opcionesModulo) {
		this.opcionesModulo = opcionesModulo;
	}

	public ArrayList getListaOpcionesModulo() {
		if (listaOpcionesModulo == null)
			listaOpcionesModulo = new ArrayList();
		return listaOpcionesModulo;
	}

	public void setListaOpcionesModulo(ArrayList listaOpcionesModulo) {
		this.listaOpcionesModulo = listaOpcionesModulo;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public boolean isOptionsVisible() {
		return optionsVisible;
	}

	public void setOptionsVisible(boolean optionsVisible) {
		this.optionsVisible = optionsVisible;
	}

	public OpcionModulo getOpcionModulo(String opcion) {
		opcion = opcion.replaceAll(" ", "");
		return (OpcionModulo) getOpcionesModulo().get(opcion);
	}

	public void adicionarOpcion(OpcionModulo opcion) {
		if (getOpcionesModulo()
				.get(opcion.getDescripcion().replaceAll(" ", "")) == null) {
			getOpcionesModulo().put(
					opcion.getDescripcion().replaceAll(" ", ""), opcion);
			getListaOpcionesModulo().add(opcion);
			setearOpciones();
		}
	}

	private void setearOpciones() {
		// TODO Auto-generated method stub
		OpcionModulo[] opciones = new OpcionModulo[getOpcionesModulo().size()];
		Iterator iterator = getOpcionesModulo().values().iterator();
		int i = 0;

		while (iterator.hasNext()) {
			OpcionModulo opcionTmp = (OpcionModulo) iterator.next();
			opciones[i] = opcionTmp;
			i++;
		}

		this.setOpciones(opciones);
	}
}