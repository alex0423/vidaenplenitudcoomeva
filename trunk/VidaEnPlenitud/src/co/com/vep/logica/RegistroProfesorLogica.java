package co.com.vep.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWSServiceLocator;
import co.com.parametros.ws.cliente.ciudad.DelegadoWsParametros;
import co.com.parametros.ws.cliente.ciudad.DelegadoWsParametrosService;
import co.com.parametros.ws.cliente.ciudad.DelegadoWsParametrosServiceLocator;
import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepProfesorId;
import co.com.vep.modelo.VepUbicacionProfesor;
import co.com.vep.modelo.VepUbicacionProfesorId;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepProfesorDAO;
import co.com.vep.persistencia.IQueryVepUbicacionProfesorDAO;
import co.com.vep.persistencia.QueryVepProfesorDAO;
import co.com.vep.persistencia.QueryVepUbicacionProfesorDAO;
import co.com.vep.persistencia.VepProfesorDAO;
import co.com.vep.persistencia.VepUbicacionProfesorDAO;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.util.MessageBundleLoader;

public class RegistroProfesorLogica implements IRegistrarProfesorLogica {

	public AsociadoVida consultarAsociado(Long tipoDocumento,
			Long identificacion) throws Exception {

		try {
			DelegadoAsociadoVidaWSServiceLocator delASoc = new DelegadoAsociadoVidaWSServiceLocator();
			DelegadoAsociadoVidaWS delegado = delASoc.getdatosAsociadoVida();

			return delegado.consultarAsociadoVida(identificacion.longValue(),
					tipoDocumento.longValue());
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean validarProfesor(Long tipoId, Long idProfesor) {
		try {
			IQueryVepProfesorDAO iqvp = new QueryVepProfesorDAO();
			VepProfesor vp = iqvp.obtener(tipoId,idProfesor);
			if (vp != null && vp.getId() != null)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public VepProfesor obtener(Long tipoId, Long idProfesor) throws Exception {
		try {
			IQueryVepProfesorDAO iqvp = new QueryVepProfesorDAO();
			VepProfesor vp = iqvp.obtener(tipoId,idProfesor);
			if (vp != null && vp.getId() != null)
				return vp;
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	public void registrarProfesor(Long tipoid, String identificacion,
			String nombre1, String nombre2, String apellido1, String apellido2,
			Date fechaNace, Long genero, String direccionResidencia,
			Long ciuRes, String telefonoResidencia, Long tituloProfesional,
			Long ocupacion, Long estadoCivil, String url, Integer estado,
			String usuario, String direccionComercial, Long ciudadCom,
			String telefonoComercial, String celular, String mail)
			throws Exception {

		try {

			if (validarProfesor(tipoid, new Long(identificacion)))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.cuerpoRegProfesor.excepcion8"));

			VepProfesor profesor = new VepProfesor();
			VepProfesorId idProfesor = new VepProfesorId();
			VepUbicacionProfesor vup = null;
			VepUbicacionProfesorId vupi = null;
			List<VepUbicacionProfesor> lstVUP = new ArrayList<VepUbicacionProfesor>();

			if (direccionResidencia.trim().length() > 0) {
				vup = new VepUbicacionProfesor();
				vupi = new VepUbicacionProfesorId();
				vupi.setTipoId(tipoid);
				vupi.setIdProfesor(Long.valueOf(identificacion));
				vupi.setTipoUbicacion(LocalApplicationConfiguration.Util
						.getInstance().getProperty("direccion_residencia"));
				vup.setId(vupi);
				vup.setDescripcionUbicacion(direccionResidencia);
				vup.setCiudad(ciuRes);
				lstVUP.add(vup);
			}
			if (telefonoResidencia.trim().length() > 0) {
				vup = new VepUbicacionProfesor();
				vupi = new VepUbicacionProfesorId();
				vupi.setTipoId(tipoid);
				vupi.setIdProfesor(Long.valueOf(identificacion));
				vupi.setTipoUbicacion(LocalApplicationConfiguration.Util
						.getInstance().getProperty("telefono_residencia"));
				vup.setId(vupi);
				vup.setDescripcionUbicacion(telefonoResidencia);
				vup.setCiudad(ciuRes);
				lstVUP.add(vup);
			}
			if (direccionComercial.trim().length() > 0) {
				vup = new VepUbicacionProfesor();
				vupi = new VepUbicacionProfesorId();
				vupi.setTipoId(tipoid);
				vupi.setIdProfesor(Long.valueOf(identificacion));
				vupi.setTipoUbicacion(LocalApplicationConfiguration.Util
						.getInstance().getProperty("direccion_comercial"));
				vup.setId(vupi);
				vup.setDescripcionUbicacion(direccionComercial);
				vup.setCiudad(ciudadCom);
				lstVUP.add(vup);
			}
			if (telefonoComercial.trim().length() > 0) {
				vup = new VepUbicacionProfesor();
				vupi = new VepUbicacionProfesorId();
				vupi.setTipoId(tipoid);
				vupi.setIdProfesor(Long.valueOf(identificacion));
				vupi.setTipoUbicacion(LocalApplicationConfiguration.Util
						.getInstance().getProperty("telefono_comercial"));
				vup.setId(vupi);
				vup.setDescripcionUbicacion(telefonoComercial);
				vup.setCiudad(ciudadCom);
				lstVUP.add(vup);
			}
			if (celular.trim().length() > 0) {
				vup = new VepUbicacionProfesor();
				vupi = new VepUbicacionProfesorId();
				vupi.setTipoId(tipoid);
				vupi.setIdProfesor(Long.valueOf(identificacion));
				vupi.setTipoUbicacion(LocalApplicationConfiguration.Util
						.getInstance().getProperty("telefono_celular"));
				vup.setId(vupi);
				vup.setDescripcionUbicacion(celular);
				vup.setCiudad(ciuRes);
				lstVUP.add(vup);
			}
			if (mail.trim().length() > 0) {
				vup = new VepUbicacionProfesor();
				vupi = new VepUbicacionProfesorId();
				vupi.setTipoId(tipoid);
				vupi.setIdProfesor(Long.valueOf(identificacion));
				vupi.setTipoUbicacion(LocalApplicationConfiguration.Util
						.getInstance().getProperty("correo_electronico"));
				vup.setId(vupi);
				vup.setDescripcionUbicacion(mail);
				vup.setCiudad(ciuRes);
				lstVUP.add(vup);
			}

			idProfesor.setTipoId(tipoid);
			idProfesor.setIdProfesor(Long.valueOf(identificacion));

			profesor.setId(idProfesor);
			profesor.setNombre1(nombre1);
			profesor.setNombre2(nombre2);
			profesor.setApellido1(apellido1);
			profesor.setApellido2(apellido2);
			profesor.setFechaNace(fechaNace);
			profesor.setGenero(genero.toString());
			profesor.setEstcivil(estadoCivil.toString());
			profesor.setTitulo(tituloProfesional.toString());
			profesor.setEspecialidad(ocupacion.toString());
			profesor.setUrlHoja(url);
			profesor.setEstadoProfesor(estado.toString());

			EntityManagerHelper.getEntityManager().getTransaction().begin();
			new VepProfesorDAO().save(profesor);
			for (VepUbicacionProfesor vepUbicacionProfesor : lstVUP) {
				new VepUbicacionProfesorDAO().save(vepUbicacionProfesor);
			}
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

	public String buscarCiudadxCodigo(String codigo) throws Exception {
		// TODO Auto-generated method stub
		long codigoCiudad = Long.parseLong(codigo);

		DelegadoWsParametrosService delLoc = new DelegadoWsParametrosServiceLocator();

		DelegadoWsParametros delegado = delLoc.getconsultarParametros();

		String ciudad = delegado.consultarCiudadxCodigo(codigoCiudad);

		return ciudad;
	}

	public List<VepUbicacionProfesor> obtenerUbicacioProfesor(Long tipoId,
			Long idProfesor) throws Exception {
		// TODO Auto-generated method stub
		try {
			IQueryVepUbicacionProfesorDAO iqvupd = new QueryVepUbicacionProfesorDAO();
			List<VepUbicacionProfesor> vp = iqvupd.findByProperty(tipoId, idProfesor);
			if (vp != null && vp.size() != 0)
				return vp;
			return null;
		} catch (Exception e) {
			throw e;
		}
	}
}
