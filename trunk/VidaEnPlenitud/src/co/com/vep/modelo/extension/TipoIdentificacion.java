package co.com.vep.modelo.extension;

public class TipoIdentificacion extends AbstractSelectItem implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public TipoIdentificacion() {
	}

	public TipoIdentificacion(Long codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

}
