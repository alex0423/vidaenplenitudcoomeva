package co.com.vep.logica;


public interface IEncuesta {

	public void registrarEncuesta(Integer medioConocimiento,
			String espMedioConocimiento, String cumpEspectativas,
			String aclaraCumplimientoEsp, String cumplimientoProgEst,
			String aclaracionCumpProgEst, Integer atencion, String nombreRef,
			String apellidoRef, String direccionRef, Long telefonoRef,
			String emailRef, String actividadesInteres, String sugerencias,
			Integer idConsultoria) throws Exception;

}
