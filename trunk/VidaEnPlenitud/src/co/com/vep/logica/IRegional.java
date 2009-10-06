package co.com.vep.logica;

import java.util.List;

import co.com.parametros.modelo.Parametros;
import co.com.vep.modelo.VepRegional;

public interface IRegional {

	public boolean validarRegional(Integer identificacion);

	public Parametros obtenerRegionalAsParametro(Integer identificacion)
			throws Exception;

	public VepRegional obtenerRegional(Integer identificacion) throws Exception;

	public List<Parametros> obtenerTodasAsParametro() throws Exception;

	public List<VepRegional> obtenerTodasAsVep() throws Exception;

}
