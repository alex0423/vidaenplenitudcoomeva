package co.com.vep.logica;

import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.VepEncuesta;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepEncuestaDAO;
import co.com.vep.persistencia.QueryVepEncuestaDAO;

public class EncuestaLogica implements IEncuesta {

	public void registrarEncuesta(Integer medioConocimiento,
			String espMedioConocimiento, String cumpEspectativas,
			String aclaraCumplimientoEsp, String cumplimientoProgEst,
			String aclaracionCumpProgEst, Integer atencion, String nombreRef,
			String apellidoRef, String direccionRef, Long telefonoRef,
			String emailRef, String actividadesInteres, String sugerencias,
			Integer idConsultoria) throws Exception {

		try {

			VepEncuesta ve = new VepEncuesta();
			ve.setAclaracionCumpProgEst(aclaracionCumpProgEst);
			ve.setAclaraCumplimientoEsp(aclaraCumplimientoEsp);
			ve.setActividadesInteres(actividadesInteres);
			ve.setApellidoRef(apellidoRef);
			ve.setAtencion(atencion.toString());
			ve.setCumpEspectativas(cumpEspectativas);
			ve.setCumplimientoProgEst(cumplimientoProgEst);
			ve.setDireccionRef(direccionRef);
			ve.setEmailRef(emailRef);
			ve.setEspMedioConocimiento(espMedioConocimiento);
			ve.setMedioConocimiento(medioConocimiento.toString());
			ve.setNombreRef(nombreRef);
			ve.setSugerencias(sugerencias);
			ve.setTelefonoRef(telefonoRef);

			VepDetalleConsultoria vdc = EntityManagerHelper.getEntityManager()
					.find(VepDetalleConsultoria.class, idConsultoria);

			ve.setVepDetalleConsultoria(vdc);

			IQueryVepEncuestaDAO iqve = new QueryVepEncuestaDAO();

			EntityManagerHelper.getEntityManager().getTransaction().begin();
			iqve.insert(ve);
			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();

		} catch (Exception e) {
			if (EntityManagerHelper.getEntityManager().getTransaction()
					.isActive())
				EntityManagerHelper.getEntityManager().getTransaction()
						.rollback();
			throw e;
		}
	}
}
