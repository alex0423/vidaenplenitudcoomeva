package co.com.vep.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepBeneficiado;
import co.com.vep.modelo.VepBeneficiadoConsultoria;
import co.com.vep.modelo.VepBeneficiario;
import co.com.vep.modelo.VepBeneficiarioId;
import co.com.vep.modelo.VepBitacoraConsultoria;
import co.com.vep.modelo.VepConsultor;
import co.com.vep.modelo.VepConsultoria;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.VepRegional;
import co.com.vep.modelo.extension.ItemConsultoria;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepBeneficiarioDAO;
import co.com.vep.persistencia.IQueryVepBitacoraConsultoriaDAO;
import co.com.vep.persistencia.IQueryVepConsultorDAO;
import co.com.vep.persistencia.IQueryVepConsultoriaDAO;
import co.com.vep.persistencia.IQueryVepDetalleConsultoriaDAO;
import co.com.vep.persistencia.QueryVepBeneficiarioDAO;
import co.com.vep.persistencia.QueryVepBitacoraConsultoriaDAO;
import co.com.vep.persistencia.QueryVepConsultorDAO;
import co.com.vep.persistencia.QueryVepConsultoriaDAO;
import co.com.vep.persistencia.QueryVepDetalleConsultoriaDAO;
import co.com.vep.persistencia.VepBeneficiadoConsultoriaDAO;
import co.com.vep.persistencia.VepBeneficiarioDAO;
import co.com.vep.persistencia.VepBitacoraConsultoriaDAO;
import co.com.vep.persistencia.VepConsultoriaDAO;
import co.com.vep.persistencia.VepDetalleConsultoriaDAO;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.util.MessageBundleLoader;

public class ConsultoriaLogica implements IConsultoria {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#registrar(java.lang.String,
	 *      java.lang.String, java.lang.Long, java.lang.String,
	 *      java.lang.String, java.lang.Long, java.lang.Integer, java.lang.Long)
	 */
	public void registrar(String nombre, String descripcion,
			Long numBeneficiados, String objetivo, String observaciones,
			Long idConsultor, Integer tipoIdentificacion, Long idRegional)
			throws Exception {
		VepConsultoria vc = new VepConsultoria();
		vc.setDescripcion(descripcion);
		vc.setNombre(nombre);
		vc.setEstado(LocalApplicationConfiguration.Util.getInstance()
				.getProperty("tipo_estadoconsultoria_planeacion"));

		VepDetalleConsultoria vdc = new VepDetalleConsultoria();
		vdc.setEstado(LocalApplicationConfiguration.Util.getInstance()
				.getProperty("tipo_estadoconsultoria_planeacion"));
		vdc.setNumBeneficiados(numBeneficiados);
		vdc.setObjetivo(objetivo);
		vdc.setObservaciones(observaciones);

		VepRegional regional = new VepRegional();
		VepConsultor consultor = new VepConsultor();

		IQueryVepConsultorDAO iqvco = new QueryVepConsultorDAO();
		IQueryVepConsultoriaDAO iqvc = new QueryVepConsultoriaDAO();
		IQueryVepDetalleConsultoriaDAO iqvdc = new QueryVepDetalleConsultoriaDAO();

		RegionalLogica rl = new RegionalLogica();
		ConsultorLogica cl = new ConsultorLogica();

		try {
			EntityManagerHelper.getEntityManager().getTransaction().begin();
			Integer idInsert = iqvc.insert(vc);

			regional = rl.obtenerRegional(idRegional.intValue());

			VepConsultoria it = EntityManagerHelper.getEntityManager().find(
					VepConsultoria.class, idInsert);
			vdc.setIdServicioCon(it.getIdServiciocon());
			vdc.setIdRegional(regional.getIdRegional());
			Integer idDetalleInsert = iqvdc.insert(vdc);

			VepDetalleConsultoria itDetalle = EntityManagerHelper
					.getEntityManager().find(VepDetalleConsultoria.class,
							idDetalleInsert);

			VepAsociado asociado = cl.obtenerAsVep(idConsultor,
					tipoIdentificacion);

			consultor.setVepAsociado(asociado);
			consultor.setVepDetalleConsultoria(itDetalle);
			iqvco.insert(consultor);

			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			EntityManagerHelper.getEntityManager().getTransaction().rollback();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#obtenerConsultoria(java.lang.Integer)
	 */
	public VepConsultoria obtenerConsultoria(Integer id) throws Exception {
		try {
			VepConsultoria it = EntityManagerHelper.getEntityManager().find(
					VepConsultoria.class, id);
			return it;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#obtenerTodasAsItem()
	 */
	public List<ItemConsultoria> obtenerTodasAsItem() throws Exception {
		List<ItemConsultoria> items = new ArrayList<ItemConsultoria>();
		try {
			List<VepConsultoria> rs = EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepconsultoria.findAll").getResultList();
			for (VepConsultoria consultoria : rs) {
				items.add(new ItemConsultoria(new Long(consultoria
						.getIdServiciocon()), consultoria.getNombre()));
			}
			return items;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#obtenerTodasAsVep()
	 */
	public List<VepConsultoria> obtenerTodasAsVep() throws Exception {
		try {
			List<VepConsultoria> rs = EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepconsultoria.findAll").getResultList();
			return rs;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#obtenerDetalle(co.com.vep.modelo.VepConsultoria)
	 */
	public List<VepDetalleConsultoria> obtenerDetalle(VepConsultoria id)
			throws Exception {
		try {
			DetalleConsultoriaLogica detalle = new DetalleConsultoriaLogica();
			return detalle.obtenerByConsultoria(id);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#obtenerDetalle(java.lang.Integer)
	 */
	public List<VepDetalleConsultoria> obtenerDetalle(Integer id)
			throws Exception {
		try {
			DetalleConsultoriaLogica detalle = new DetalleConsultoriaLogica();
			return detalle.obtenerByConsultoria(id);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#obtenerByRegionalAsItem(java.lang.Integer)
	 */
	public List<ItemConsultoria> obtenerByRegionalAsItem(Integer idRegional)
			throws Exception {
		List<ItemConsultoria> items = new ArrayList<ItemConsultoria>();
		try {
			List<VepConsultoria> rs = EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepconsultoria.findByRegional")
					.setParameter("idRegional", idRegional).getResultList();
			for (VepConsultoria consultoria : rs) {
				items.add(new ItemConsultoria(new Long(consultoria
						.getIdServiciocon()), consultoria.getNombre()));
			}
			return items;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#obtenerByRegionalAsVep(java.lang.Integer)
	 */
	public List<VepConsultoria> obtenerByRegionalAsVep(Integer idRegional)
			throws Exception {
		try {
			List<VepConsultoria> rs = EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepconsultoria.findByRegional")
					.setParameter("idRegional", idRegional).getResultList();

			return rs;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#cambiarEstadoConsultoria(java.lang.Integer,
	 *      java.lang.String)
	 */
	public void cambiarEstadoConsultoria(Integer id, String Estado)
			throws Exception {
		try {
			VepConsultoria vc = obtenerConsultoria(id);
			if (!vc.getEstado().equals(Estado)) {

				List<VepDetalleConsultoria> vdc = obtenerDetalle(id);
				if (vdc.isEmpty())
					throw new Exception("Consultoria no Existe");

				vc.setEstado(Estado);
				VepConsultoriaDAO vcDao = new VepConsultoriaDAO();
				vcDao.update(vc);

				(vdc.get(0)).setEstado(Estado);
				VepDetalleConsultoriaDAO vdcDao = new VepDetalleConsultoriaDAO();
				vdcDao.update(vdc.get(0));
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#validarEstadoAsActivo(java.lang.Integer)
	 */
	public boolean validarEstadoAsActivo(Integer id) {
		try {
			VepConsultoria vc = obtenerConsultoria(id);
			if (vc != null) {
				if (validarEstadoAsEjecucion(vc.getEstado())
						|| validarEstadoAsPlaneacion(vc.getEstado()))
					return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean validarEstadoAsPlaneacion(String estado) {
		try {
			System.out.println("Estados: "
					+ estado
					+ " "
					+ LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tipo_estadoconsultoria_planeacion"));
			if (estado.equals(LocalApplicationConfiguration.Util.getInstance()
					.getProperty("tipo_estadoconsultoria_planeacion")))
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean validarEstadoAsEjecucion(String estado) {
		try {
			System.out.println("Estados: "
					+ estado
					+ " "
					+ LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tipo_estadoconsultoria_ejecucion"));
			if (estado.equals(LocalApplicationConfiguration.Util.getInstance()
					.getProperty("tipo_estadoconsultoria_ejecucion")))
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#registrarBitacora(java.lang.Integer,
	 *      java.lang.String, java.lang.String)
	 */
	public Long registrarBitacora(Integer idConsultoria, String observacion,
			String urlArchivo) throws Exception {
		try {
			IConsultoria consultoria = new ConsultoriaLogica();
			List<VepDetalleConsultoria> detalle = consultoria
					.obtenerDetalle(idConsultoria);
			if (detalle.isEmpty())
				throw new Exception("Consultoria no existe");

			VepBitacoraConsultoria entity = new VepBitacoraConsultoria();
			entity.setFecha(new Date());
			entity.setObservacion(observacion);
			entity.setIdDetalleCons(detalle.get(0).getIdDetallecons());

			IQueryVepBitacoraConsultoriaDAO iqvbc = new QueryVepBitacoraConsultoriaDAO();
			Long id = iqvbc.insert(entity);

			if (urlArchivo != null && urlArchivo.trim().length() > 0)
				incluirArchivo(id, urlArchivo);

			return id;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#guardarSeguimiento(java.lang.Integer,
	 *      java.lang.String, java.lang.String)
	 */
	public void guardarSeguimiento(Integer id, String observacion,
			String urlArchivo) throws Exception {
		try {
			if (observacion != null && observacion.trim().length() > 0) {
				EntityManagerHelper.getEntityManager().getTransaction().begin();
				registrarBitacora(id, observacion, urlArchivo);
				EntityManagerHelper.getEntityManager().flush();
				EntityManagerHelper.getEntityManager().getTransaction()
						.commit();
			} else
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion9"));

		} catch (Exception e) {
			if (EntityManagerHelper.getEntityManager().getTransaction()
					.isActive())
				EntityManagerHelper.getEntityManager().getTransaction()
						.rollback();
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#iniciarConsultoria(java.lang.Integer,
	 *      java.util.Date, java.lang.String, java.lang.String)
	 */
	public void iniciarConsultoria(Integer id, Date fechaInicio,
			String observacion, String urlArchivo) throws Exception {
		try {
			if (fechaInicio.after(new Date()))
				throw new Exception(
						"La fecha de inicio de la consultoria no debe ser mayor a la fecha actual");
			EntityManagerHelper.getEntityManager().getTransaction().begin();
			cambiarEstadoConsultoria(id, LocalApplicationConfiguration.Util
					.getInstance().getProperty(
							"tipo_estadoconsultoria_ejecucion"));
			DetalleConsultoriaLogica detalle = new DetalleConsultoriaLogica();
			detalle.actualizarFechaInicioByConsultoria(id, fechaInicio);

			if (observacion != null && observacion.trim().length() > 0)
				registrarBitacora(id, observacion, urlArchivo);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#anularConsultoria(java.lang.Integer,
	 *      java.lang.String, java.lang.String)
	 */
	public void anularConsultoria(Integer id, String observacion,
			String urlArchivo) throws Exception {
		try {
			EntityManagerHelper.getEntityManager().getTransaction().begin();

			cambiarEstadoConsultoria(id, LocalApplicationConfiguration.Util
					.getInstance()
					.getProperty("tipo_estadoconsultoria_anulado"));

			if (observacion != null && observacion.trim().length() > 0)
				registrarBitacora(id, observacion, urlArchivo);

			DetalleConsultoriaLogica detalle = new DetalleConsultoriaLogica();
			detalle.actualizarFechaTerminacionByConsultoria(id, new Date());

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#finalizarConsultoria(java.lang.Integer,
	 *      java.lang.String, java.lang.String)
	 */
	public void finalizarConsultoria(Integer id) throws Exception {
		try {
			EntityManagerHelper.getEntityManager().getTransaction().begin();

			cambiarEstadoConsultoria(id, LocalApplicationConfiguration.Util
					.getInstance().getProperty(
							"tipo_estadoconsultoria_terminado"));

			DetalleConsultoriaLogica detalle = new DetalleConsultoriaLogica();
			detalle.actualizarFechaTerminacionByConsultoria(id, new Date());

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#registrar(java.lang.String,
	 *      java.lang.String, java.lang.Long, java.lang.Long, java.lang.Integer,
	 *      java.lang.Long, java.lang.Long)
	 */
	public void registrar(String nombre, String descripcion,
			Long numBeneficiados, Long idConsultor, Integer tipoIdentificacion,
			Long idBeneficiado, Long idRegional) throws Exception {

		VepConsultoria vc = new VepConsultoria();
		vc.setDescripcion(descripcion);
		vc.setNombre(nombre);
		vc.setEstado(LocalApplicationConfiguration.Util.getInstance()
				.getProperty("tipo_estadoconsultoria_planeacion"));

		VepDetalleConsultoria vdc = new VepDetalleConsultoria();
		vdc.setEstado(LocalApplicationConfiguration.Util.getInstance()
				.getProperty("tipo_estadoconsultoria_planeacion"));
		vdc.setNumBeneficiados(numBeneficiados);
		vdc.setObjetivo("");
		vdc.setObservaciones("");

		VepRegional regional = new VepRegional();
		VepConsultor consultor = new VepConsultor();

		IQueryVepConsultorDAO iqvco = new QueryVepConsultorDAO();
		IQueryVepConsultoriaDAO iqvc = new QueryVepConsultoriaDAO();
		IQueryVepDetalleConsultoriaDAO iqvdc = new QueryVepDetalleConsultoriaDAO();

		RegionalLogica rl = new RegionalLogica();
		AsociadoLogica al = new AsociadoLogica();
		try {
			regional = rl.obtenerRegional(idRegional.intValue());
			if (regional == null)
				throw new Exception("Regional no encontrada");

			EntityManagerHelper.getEntityManager().getTransaction().begin();
			Integer idInsert = iqvc.insert(vc);

			VepConsultoria it = EntityManagerHelper.getEntityManager().find(
					VepConsultoria.class, idInsert);
			vdc.setIdServicioCon(it.getIdServiciocon());
			vdc.setIdRegional(regional.getIdRegional());
			Integer idDetalleInsert = iqvdc.insert(vdc);

			VepDetalleConsultoria itDetalle = EntityManagerHelper
					.getEntityManager().find(VepDetalleConsultoria.class,
							idDetalleInsert);
			if (itDetalle == null)
				throw new Exception("Detalle de consultoria no encontrado!!");

			VepAsociado asociado = al.obtenerOnlyDocumento(idConsultor);
			if (asociado == null)
				throw new Exception("Asociado asesor no encontrado!");

			consultor.setVepAsociado(asociado);
			consultor.setVepDetalleConsultoria(itDetalle);
			iqvco.insert(consultor);

			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			EntityManagerHelper.getEntityManager().getTransaction().rollback();
			throw ex;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#registrar(java.lang.String,
	 *      java.lang.String, java.lang.Long, java.util.List, java.lang.Integer,
	 *      java.lang.Long, java.lang.Long)
	 */
	public void registrar(String nombre, String descripcion,
			Long numBeneficiados, List<Long> idConsultor,
			Integer tipoIdentificacion, Long idBeneficiado, Long idRegional,
			String objetivo, String observaciones) throws Exception {
		VepConsultoria vc = new VepConsultoria();
		vc.setDescripcion(descripcion);
		vc.setNombre(nombre);
		vc.setEstado(LocalApplicationConfiguration.Util.getInstance()
				.getProperty("tipo_estadoconsultoria_planeacion"));

		VepDetalleConsultoria vdc = new VepDetalleConsultoria();
		vdc.setEstado(LocalApplicationConfiguration.Util.getInstance()
				.getProperty("tipo_estadoconsultoria_planeacion"));
		vdc.setNumBeneficiados(numBeneficiados);
		vdc.setObjetivo(objetivo);
		vdc.setObservaciones(observaciones);

		VepRegional regional = new VepRegional();
		VepConsultor consultor = null;

		IQueryVepConsultorDAO iqvco = new QueryVepConsultorDAO();
		IQueryVepConsultoriaDAO iqvc = new QueryVepConsultoriaDAO();
		IQueryVepDetalleConsultoriaDAO iqvdc = new QueryVepDetalleConsultoriaDAO();
		IQueryVepBeneficiarioDAO iqvb = new QueryVepBeneficiarioDAO();

		RegionalLogica rl = new RegionalLogica();
		AsociadoLogica al = new AsociadoLogica();
		try {
			regional = rl.obtenerRegional(idRegional.intValue());
			if (regional == null)
				throw new Exception("Regional no encontrada");

			EntityManagerHelper.getEntityManager().getTransaction().begin();
			Integer idInsert = iqvc.insert(vc);

			VepConsultoria it = EntityManagerHelper.getEntityManager().find(
					VepConsultoria.class, idInsert);
			vdc.setIdServicioCon(it.getIdServiciocon());
			vdc.setIdRegional(regional.getIdRegional());
			Integer idDetalleInsert = iqvdc.insert(vdc);

			VepDetalleConsultoria itDetalle = EntityManagerHelper
					.getEntityManager().find(VepDetalleConsultoria.class,
							idDetalleInsert);
			if (itDetalle == null)
				throw new Exception("Detalle de consultoria no encontrado!!");

			for (Long asesor : idConsultor) {
				VepAsociado asociado = al.obtenerOnlyDocumento(asesor);
				if (asociado == null)
					throw new Exception("Asociado asesor no encontrado!");

				consultor = new VepConsultor();
				consultor.setVepAsociado(asociado);
				consultor.setVepDetalleConsultoria(itDetalle);
				iqvco.insert(consultor);
			}

			VepBeneficiadoConsultoria beneficiado = new VepBeneficiadoConsultoria();
			beneficiado.setTipoDocumento(Long.valueOf(tipoIdentificacion.toString()));
			beneficiado.setIdBeneficiario(idBeneficiado);
			beneficiado.setIdDetalleCons(itDetalle.getIdDetallecons());
			new VepBeneficiadoConsultoriaDAO().save(beneficiado);

			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			if (EntityManagerHelper.getEntityManager().getTransaction()
					.isActive())
				EntityManagerHelper.getEntityManager().getTransaction()
						.rollback();
			throw ex;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#obtenerBitacora(java.lang.Integer)
	 */
	public List<VepBitacoraConsultoria> obtenerBitacora(Integer idConsultoria)
			throws Exception {
		try {
			return EntityManagerHelper.getEntityManager().createNamedQuery(
					"vepbitacoraconsultoria.findbyconsultoria").setParameter(
					"idConsultoria", idConsultoria).getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#incluirArchivo(java.lang.Long,
	 *      java.lang.String)
	 */
	public void incluirArchivo(Long idBitacora, String fileAnexo)
			throws Exception {
		try {
			VepBitacoraConsultoria vbc = new VepBitacoraConsultoriaDAO()
					.findById(Integer.valueOf(idBitacora.toString()));
			vbc.setArchivoUrl(fileAnexo);

			VepBitacoraConsultoriaDAO vbcDao = new VepBitacoraConsultoriaDAO();
			vbcDao.update(vbc);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IConsultoria#filterAsVep(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.util.Date, java.util.Date, java.lang.Long)
	 */
	public List<VepDetalleConsultoria> filterAsVep(String axIdServicio,
			String axAsesor, String axCiudad, String axEstado,
			Date sFechaInicio, Date sFechaFin, Long idRegional)
			throws Exception {
		try {
			IQueryVepDetalleConsultoriaDAO iqvdcDao = new QueryVepDetalleConsultoriaDAO();
			return iqvdcDao.findByFilter(axIdServicio, axAsesor, axCiudad,
					axEstado, sFechaInicio, sFechaFin, idRegional);
		} catch (Exception e) {
			throw e;
		}
	}

	public void registrar(String nombre, String descripcion,
			Long numBeneficiados, List<Long> idConsultor,
			Integer tipoIdentificacion, Long idBeneficiado,
			String nombreBeneficiario, String apellido1, String apellido2,
			Long idRegional, String objetivo, String observaciones)
			throws Exception {
		// TODO Auto-generated method stub
		VepConsultoria vc = new VepConsultoria();
		vc.setDescripcion(descripcion);
		vc.setNombre(nombre);
		vc.setEstado(LocalApplicationConfiguration.Util.getInstance()
				.getProperty("tipo_estadoconsultoria_planeacion"));

		VepDetalleConsultoria vdc = new VepDetalleConsultoria();
		vdc.setEstado(LocalApplicationConfiguration.Util.getInstance()
				.getProperty("tipo_estadoconsultoria_planeacion"));
		vdc.setNumBeneficiados(numBeneficiados);
		vdc.setObjetivo(objetivo);
		vdc.setObservaciones(observaciones);

		VepRegional regional = new VepRegional();
		VepConsultor consultor = null;

		IQueryVepConsultorDAO iqvco = new QueryVepConsultorDAO();
		IQueryVepConsultoriaDAO iqvc = new QueryVepConsultoriaDAO();
		IQueryVepDetalleConsultoriaDAO iqvdc = new QueryVepDetalleConsultoriaDAO();
		VepBeneficiarioDAO vbd = new VepBeneficiarioDAO();
		VepBeneficiadoConsultoriaDAO vbcd = new VepBeneficiadoConsultoriaDAO();

		RegionalLogica rl = new RegionalLogica();
		AsociadoLogica al = new AsociadoLogica();
		try {
			regional = rl.obtenerRegional(idRegional.intValue());
			if (regional == null)
				throw new Exception("Regional no encontrada");

			EntityManagerHelper.getEntityManager().getTransaction().begin();
			Integer idInsert = iqvc.insert(vc);

			VepConsultoria it = EntityManagerHelper.getEntityManager().find(
					VepConsultoria.class, idInsert);
			vdc.setIdServicioCon(it.getIdServiciocon());
			vdc.setIdRegional(regional.getIdRegional());
			Integer idDetalleInsert = iqvdc.insert(vdc);

			VepDetalleConsultoria itDetalle = EntityManagerHelper
					.getEntityManager().find(VepDetalleConsultoria.class,
							idDetalleInsert);
			if (itDetalle == null)
				throw new Exception("Detalle de consultoria no encontrado!!");

			for (Long asesor : idConsultor) {
				VepAsociado asociado = al.obtenerOnlyDocumento(asesor);
				if (asociado == null)
					throw new Exception("Asociado asesor no encontrado!");

				consultor = new VepConsultor();
				consultor.setVepAsociado(asociado);
				consultor.setVepDetalleConsultoria(itDetalle);
				iqvco.insert(consultor);
			}
			
			VepBeneficiario vepBeneficiario = new VepBeneficiario();
			VepBeneficiarioId idBeneficiario = new VepBeneficiarioId();
			idBeneficiario.setTipoDocumento(Long.valueOf(tipoIdentificacion.toString()));
			idBeneficiario.setNumeroDocumento(idBeneficiado);
			vepBeneficiario.setId(idBeneficiario);
			vepBeneficiario.setNombre(nombreBeneficiario);
			vepBeneficiario.setApellido1(apellido1);
			vepBeneficiario.setApellido2(apellido2);
			vbd.save(vepBeneficiario);

			VepBeneficiadoConsultoria beneficiado = new VepBeneficiadoConsultoria();
			beneficiado.setTipoDocumento(Long.valueOf(tipoIdentificacion.toString()));
			beneficiado.setIdBeneficiario(idBeneficiado);
			beneficiado.setIdDetalleCons(itDetalle.getIdDetallecons());
			vbcd.save(beneficiado);

			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			if (EntityManagerHelper.getEntityManager().getTransaction()
					.isActive())
				EntityManagerHelper.getEntityManager().getTransaction()
						.rollback();
			throw ex;
		}
	}
}
