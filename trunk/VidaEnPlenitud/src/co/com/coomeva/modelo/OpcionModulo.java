package co.com.coomeva.modelo;

public class OpcionModulo {
	private String modulo;
	private String descripcion;

	private String pagina;

	private boolean rendered;

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
}