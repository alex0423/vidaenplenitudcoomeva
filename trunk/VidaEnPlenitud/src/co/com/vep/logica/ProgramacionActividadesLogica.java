package co.com.vep.logica;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWSServiceLocator;
import co.com.parametros.ws.cliente.ciudad.DelegadoWsParametros;
import co.com.parametros.ws.cliente.ciudad.DelegadoWsParametrosService;
import co.com.parametros.ws.cliente.ciudad.DelegadoWsParametrosServiceLocator;
import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepLugar;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.extension.VepAsistenteProgAsociado;
import co.com.vep.persistencia.IQueryVepProfesorDAO;
import co.com.vep.persistencia.IQueryVepProgramacionDAO;
import co.com.vep.persistencia.QueryVepProfesorDAO;
import co.com.vep.persistencia.QueryVepProgramacionDAO;
import co.com.vep.persistencia.VepLugarDAO;
import co.com.vep.persistencia.VepParametroActividadDAO;
import co.com.vep.persistencia.VepProgramacionDAO;
import co.com.vep.persistencia.VepSipParametroDAO;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.util.StringUtils;

public class ProgramacionActividadesLogica implements IProgramacionActividad {

	static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("ProyectoVEP1PU");
	static EntityManager em = emf.createEntityManager();

	private long validarTipoParametroBUC(String tipoID) {
		int posslash = tipoID.indexOf("-");
		String tipo = tipoID.substring(0, posslash);
		return Long.parseLong(tipo);
	}

	public List<VepParametroActividad> findParametroActividad()
			throws Exception {
		// TODO Auto-generated method stub
		return new VepParametroActividadDAO()
				.findByEstadopar(LocalApplicationConfiguration.Util
						.getInstance().getProperty("findByEstadoparActivo"));
	}

	public List<VepProgramacion> findProgramacionGrupo(Object grupo)
			throws Exception {
		// TODO Auto-generated method stub
		return new VepProgramacionDAO().findByGrupo(grupo);
	}

	public VepProgramacion obtener(Integer idProgramacion) throws Exception {
		try {
			return new VepProgramacionDAO().findById(idProgramacion);
		} catch (Exception e) {
			throw e;
		}
	}

	public VepProgramacion obtenerByActividadGrupo(Integer idActividad,
			String grupo) throws Exception {
		try {
			IQueryVepProgramacionDAO iqvpDao = new QueryVepProgramacionDAO();
			return (VepProgramacion) iqvpDao.findByActividadGrupo(idActividad,
					grupo);
		} catch (Exception e) {
			throw e;
		}
	}

	public VepProfesor findProfesor(Long tipoId, Long identificacion)
			throws Exception {
		// TODO Auto-generated method stub
		IQueryVepProfesorDAO iqvpd = new QueryVepProfesorDAO();
		VepProfesor profesor = new VepProfesor();

		try {
			// Consulta los datos
			profesor = iqvpd.obtener(tipoId, identificacion);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return profesor;
	}

	public List<VepLugar> findLugar() throws Exception {
		// TODO Auto-generated method stub
		return new VepLugarDAO().findAll();
	}

	public List<VepSipParametro> findListEstados(String propiedad, Object value)
			throws Exception {
		// TODO Auto-generated method stub
		return new VepSipParametroDAO().findByProperty(propiedad, value);
	}

	public void registrarProgramacion(Integer codigoActividad,
			String codigoGrupo, Date fechaInicio, Date fechaFinal,
			Timestamp horaInicio, Timestamp horaTermina, String nivel,
			String estado, Long tipoId, Long identificacionProfesor,
			Integer codigoLugar, Long cupoMinimo, Long cupoMaximo, Long regional)
			throws Exception {
		VepProgramacion programacion = new VepProgramacion();
		programacion.setIdLugar(codigoLugar);
		programacion.setIdActividadPar(codigoActividad);
		programacion.setIdProfesor(identificacionProfesor);
		programacion.setIdRegional(Integer.valueOf(regional.toString()));
		programacion.setFechaInicio(fechaInicio);
		programacion.setFechaFin(fechaFinal);
		// programacion.setHoraIni(horaInicio);
		// programacion.setHoraFin(horaTermina);
		programacion.setCupoMinimo(cupoMinimo);
		programacion.setCupoMaximo(cupoMaximo);
		programacion.setNivel(nivel);
		programacion.setEstado(estado);
		programacion.setGrupo(codigoGrupo);
		programacion.setCupoAsistentes(0);

		try {
			em.getTransaction().begin();
			int a = em.createNamedQuery("callProceso1").setParameter(1,
					fechaInicio).setParameter(2, fechaFinal).setParameter(3,
					horaInicio).setParameter(4, horaTermina).setParameter(5,
					cupoMaximo).setParameter(6, cupoMinimo).setParameter(7,
					nivel).setParameter(8, estado).setParameter(9, codigoLugar)
					.setParameter(10, regional).setParameter(11,
							codigoActividad).setParameter(12, tipoId)
					.setParameter(13, identificacionProfesor).setParameter(14,
							codigoGrupo).setParameter(15, 0).executeUpdate();
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public List<VepAsistenteProgAsociado> listaProgActividades(String property,
			Object date1, Object date2) throws Exception {
		// TODO Auto-generated method stub
		DelegadoAsociadoVidaWSServiceLocator delASoc = new DelegadoAsociadoVidaWSServiceLocator();
		DelegadoAsociadoVidaWS delegado = delASoc.getdatosAsociadoVida();
		AsociadoVida asociado = null;
		VepAsistenteProgAsociado vapa = null;
		List<VepAsistenteProgAsociado> listVAPA = new ArrayList<VepAsistenteProgAsociado>();
		List<VepAsistenteProg> listaAsisProg;

		if (date1 == null && date2 != null) {
			listaAsisProg = new ArrayList<VepAsistenteProg>();
			listaAsisProg = new QueryVepProgramacionDAO().findByFecha2(
					property, date2);
		} else if (date1 != null && date2 == null) {
			listaAsisProg = new ArrayList<VepAsistenteProg>();
			listaAsisProg = new QueryVepProgramacionDAO().findByFecha1(
					property, date1);
		} else if (date1 == null && date2 == null) {
			listaAsisProg = new ArrayList<VepAsistenteProg>();
			listaAsisProg = new QueryVepProgramacionDAO().findWithoutFecha();
		} else {
			listaAsisProg = new ArrayList<VepAsistenteProg>();
			listaAsisProg = new QueryVepProgramacionDAO().findByFecha(property,
					date1, date2);
		}
		for (VepAsistenteProg vepAsistenteProg : listaAsisProg) {
			VepAsociado asoc = vepAsistenteProg.getVepAsociado();
			vapa = new VepAsistenteProgAsociado();

			long tipDocumento = Long.parseLong(asoc.getTipoDocumento());
			long identificacion = asoc.getDocumento();
			asociado = delegado.consultarAsociadoVida(identificacion,
					tipDocumento);
			vapa.setAsociado(asociado);
			vapa.setAsistenteProg(vepAsistenteProg);
			vapa.setParametroActividad(new VepParametroActividadDAO()
					.findById(vepAsistenteProg.getVepProgramacion()
							.getIdActividadPar()));			
			if (asociado.getFecNacimiento() == 0) {
				vapa.setFormatoFecha("-");
			} else {
				vapa.setFormatoFecha(StringUtils.generarFechaCorrecta1(String
						.valueOf(asociado.getFecNacimiento())));
			}
			listVAPA.add(vapa);
		}
		return listVAPA;
	}

	public VepLugar findLugarSitio(Integer codigoLugar) throws Exception {
		// TODO Auto-generated method stub
		return new VepLugarDAO().findById(codigoLugar);
	}

	public String buscarCiudadxCodigo(String codigo) throws Exception {
		// TODO Auto-generated method stub
		long codigoCiudad = Long.parseLong(codigo);

		DelegadoWsParametrosService delLoc = new DelegadoWsParametrosServiceLocator();

		DelegadoWsParametros delegado = delLoc.getconsultarParametros();

		String ciudad = delegado.consultarCiudadxCodigo(codigoCiudad);

		return ciudad;
	}

	public List<VepProgramacion> programadasProfesor(Long tipoId,
			Long identificacion) throws Exception {
		// TODO Auto-generated method stub
		return new QueryVepProgramacionDAO().findProfesorProgramado(tipoId,
				identificacion);
	}
}
