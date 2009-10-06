package co.com.vep.modelo.extension;

import java.io.Serializable;

public class ItemConsultoria extends AbstractSelectItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public ItemConsultoria() {
		// TODO Auto-generated constructor stub
	}

	public ItemConsultoria(Long codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

}
