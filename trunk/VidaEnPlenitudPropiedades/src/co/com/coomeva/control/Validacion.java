package co.com.coomeva.control;

/**
 * @author Oscar Javier Salazar
 * Clase encargada de validar la nulidad de las variables
 * y atrubutos de seleccion.
 */
public class Validacion {

	protected LoadBundle mensajes;
	
	public Validacion(){
		mensajes = Properties.getInstance().getLoadBundleMensajes();
	}
	
	/**
	 * Valida la nulidad de un dato
	 * @param variable
	 * @param mensaje
	 * @throws Exception
	 */
	public void validar( Object variable, String mensaje ) throws Exception{
		if( variable == null || variable.toString().length() == 0 )
			throw new Exception( mensaje );
	}
	
	public void validarSeleccion( Object variable, String mensaje ) throws Exception{
		if( variable == null || variable.toString().length() == 0 || variable.toString().equals("-1"))
			throw new Exception( mensaje );
	}
	public void validarSeleccionTU( Object variable, String mensaje ) throws Exception{
		if( variable == null || variable.toString().length() == 0 || variable.toString().equals("0"))
			throw new Exception( mensaje );
	}	
	public void validarValorPositivo( Long variable, String mensaje ) throws Exception{
		if( variable != null && variable.longValue() <= 0 )
			throw new Exception( mensaje );
	}

	public LoadBundle getMensajes() {
		return mensajes;
	}

	public void setMensajes(LoadBundle mensajes) {
		this.mensajes = mensajes;
	}
}
