package co.com.vep.logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;

import co.com.coomeva.utilidaldes.profile.Properties;
import co.com.coomeva.wsasociado.modelo.Asociado;
import co.com.coomeva.wsasociado.modelo.DelegadoWS;
import co.com.coomeva.wsasociado.modelo.DelegadoWSServiceLocator;
import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.modelo.VepAcudiente;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepUbicacionAcudiente;
import co.com.vep.modelo.VepUbicacionAcudienteId;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.VepAcudienteDAO;
import co.com.vep.persistencia.VepAsociadoDAO;
import co.com.vep.persistencia.VepAtributoAsociadoDAO;
import co.com.vep.persistencia.VepUbicacionAcudienteDAO;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.util.MessageBundleLoader;
import co.com.vida.modelo.DatosVinculacion;
import co.com.vida.modelo.DelegadoWSVinculacion;
import co.com.vida.modelo.DelegadoWSVinculacionServiceLocator;
import co.com.vida.properties.MessagesConfiguration;

public class RealizarInscripcion implements IRealizarInscripcion {

	/*
	 * Los métodos obtenerDatosBuc se encargan de buscar a la persona ya sea
	 * Asociado, Acudiente o Beneficiario cumpliendo asi con lo estipulado en el
	 * siguiente Caso de Uso CUVEP20080925_002 Consultar datos básicos.
	 * 
	 */

	public void guardarAsociado(Long tipoid, Long cedula, String nombre1,
			String nombre2, String apellido1, String apellido2, Date fechaNace,
			String genero, Long codigoAsociado, String estadoAsociado,
			Date fechaEstado, Date fechaIngresoAsociado, Long corte,
			String direccionResidencia, String ciudad, String dirComercial,
			String ciudadComercial, String telefonoResidencia,
			String telefonoComercial, String telefonoCelular,
			String correoElectrinico, Long tituloProfesional, Long ocupacion,
			Long estadoCivil, Integer num_cuotas_vencidas, Long tipoidacu,
			Long cedulaAcudiente, String nombre1Acudiente,
			String nombre2Acudiente, String apellido1Acudiente,
			String apellido2Acudiente, String telefonoResidenciaAcudiente,
			String telefonoComercialAcudiente, String telefonoCelularAcudiente,
			String tipoSangre, Date fechaIngresovp, Long tipoAsociado,
			Integer[] seleccionPatologias, Integer[] seleccionServMedico,
			Integer[] seleccionServOfrecer, Integer[] seleccionConocimiento,
			Integer[] seleccionHobbies, Integer[] seleccionPAM,
			String otraPatologia, String otroServOfrecer,
			String otroConocimiento, String otroHobbie, String medicamentos,
			Long numHoras, String usuario) throws Exception {
		try {
			RealizarConsultas rcons = new RealizarConsultas();
			co.com.coomeva.wsasociado.vida.AsociadoVida aso = rcons
					.consultarDatosAsociadoBUC(cedula, tipoid.longValue());
			long idAsociado = aso.getNumInt();
			if (String.valueOf(aso.getNumInt()).trim().equals("0")) {
				try {
					guardarBUC(tipoid, cedula, nombre1, nombre2, apellido1,
							apellido2, fechaNace, genero, direccionResidencia,
							telefonoResidencia, tituloProfesional, ocupacion,
							estadoCivil, usuario);

					aso = rcons.consultarDatosAsociadoBUC(cedula, tipoid
							.longValue());
					idAsociado = aso.getNumInt();
					if (String.valueOf(aso.getNumInt()).trim().equals("0"))
						throw new Exception(MessageBundleLoader
								.getMessage("labels.inscripcionaso.err35"));
					else {
						actualizaTipoAsociado(Long.parseLong(aso
								.getNumDocumento()), aso.getCodTipDocumento(),
								2l, usuario);
					}

				} catch (Exception e) {
					throw e;
				}
			} else {
				aso.setCodCiuResidencia(ciudad);
				aso.setCodCiuComercial(ciudadComercial);
				aso.setDirResidencia(direccionResidencia);
				aso.setDirComercial(dirComercial);
				aso.setTelResidencia(telefonoResidencia);
				aso.setTelComercial(telefonoComercial);
				aso.setUsuario(usuario);
				actualizaDatosUbicacion(aso);
			}

			VepAsociado vaso = new VepAsociado();
			VepAsociadoDAO vasoDAO = new VepAsociadoDAO();

			vaso.setIdAsociado(idAsociado);
			vaso.setTipoSangre(tipoSangre);
			if (estadoAsociado == null || estadoAsociado.trim().length() == 0)
				vaso.setEstodoAsociado("36");
			else
				vaso.setEstodoAsociado(estadoAsociado.trim());
			if (seleccionConocimiento != null
					&& seleccionConocimiento.length > 0)
				vaso.setCompartirConocimientos("S");
			else
				vaso.setCompartirConocimientos("N");

			VepAcudiente acu = new VepAcudiente();
			if (!tipoidacu.equals(new Long("-1"))
					&& !cedulaAcudiente.equals(new Long("0"))
					|| (cedulaAcudiente != null && tipoidacu != null)) {
				acu = rcons.consultarDatosAcudiente(tipoidacu, cedula);
			}

			Integer idAcudiente = acu.getIdAcudiente();

			vaso.setGenero(genero);
			if (ocupacion != null) {
				vaso.setOcupacion(ocupacion.toString());	
			}
			
			AsociadoLogica logica = new AsociadoLogica();
			if (logica.validar(tipoid, cedula))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.mens5"));
			
			vaso.setEstcivil(estadoCivil.toString());
			vaso.setFechaIngresovp(fechaIngresovp);
			vaso.setValidacionAspirante(null);
			vaso.setTipoAsociado(tipoAsociado.toString());
			vaso.setNumeroHorasDispSv(numHoras);
			vaso.setMedicamentos(medicamentos);
			// vaso.setIdAcudiente(new Long(idAcudiente.longValue()));
			vaso.setTipoDocumento(tipoid.toString());
			vaso.setDocumento(cedula);
			vaso.setDocumentoAcudiente(cedulaAcudiente);
			vaso.setTipoDocumentoAcu(tipoidacu.toString());
			vaso.setFechaNace(fechaNace);
			vaso.setNumeroHorasDispSv(numHoras);

			EntityManagerHelper.getEntityManager().getTransaction().begin();
			vasoDAO.save(vaso);

			VepAtributoAsociadoDAO vatribasoDAO = new VepAtributoAsociadoDAO();
			VepAsociado vepAsociado = new VepAsociado();
			vepAsociado.setIdAsociado(idAsociado);
			if (seleccionPAM != null) {
				for (Integer item : seleccionPAM) {
					VepAtributoAsociado vatribaso = new VepAtributoAsociado();
					VepSipParametro vepSipParametro = new VepSipParametro();
					vepSipParametro.setIdTipoClasif(item);
					vatribaso.setVepSipParametro(vepSipParametro);
					vatribaso.setValor(null);
					vatribaso.setVepAsociado(vepAsociado);
					vatribasoDAO.save(vatribaso);
				}
			}

			if (seleccionConocimiento != null) {
				for (Integer item : seleccionConocimiento) {
					VepAtributoAsociado vatribaso = new VepAtributoAsociado();
					VepSipParametro vepSipParametro = new VepSipParametro();
					vepSipParametro.setIdTipoClasif(item);
					vatribaso.setVepSipParametro(vepSipParametro);
					if (item.equals(new Integer(63)))
						vatribaso.setValor(otroConocimiento);
					else
						vatribaso.setValor(null);

					vatribaso.setVepAsociado(vepAsociado);
					vatribasoDAO.save(vatribaso);
				}
			}

			if (seleccionHobbies != null) {
				for (Integer item : seleccionHobbies) {
					VepAtributoAsociado vatribaso = new VepAtributoAsociado();
					VepSipParametro vepSipParametro = new VepSipParametro();
					vepSipParametro.setIdTipoClasif(item);
					vatribaso.setVepSipParametro(vepSipParametro);
					if (item.equals(new Integer(35)))
						vatribaso.setValor(otroHobbie);
					else
						vatribaso.setValor(null);

					vatribaso.setVepAsociado(vepAsociado);
					vatribasoDAO.save(vatribaso);
				}
			}

			if (seleccionPatologias != null) {
				for (Integer item : seleccionPatologias) {
					VepAtributoAsociado vatribaso = new VepAtributoAsociado();
					VepSipParametro vepSipParametro = new VepSipParametro();
					vepSipParametro.setIdTipoClasif(item);
					vatribaso.setVepSipParametro(vepSipParametro);
					if (item.equals(new Integer(23)))
						vatribaso.setValor(otraPatologia);
					else
						vatribaso.setValor(null);

					vatribaso.setVepAsociado(vepAsociado);
					vatribasoDAO.save(vatribaso);
				}
			}

			if (seleccionServMedico != null) {
				for (Integer item : seleccionServMedico) {
					VepAtributoAsociado vatribaso = new VepAtributoAsociado();
					VepSipParametro vepSipParametro = new VepSipParametro();
					vepSipParametro.setIdTipoClasif(item);
					vatribaso.setVepSipParametro(vepSipParametro);
					vatribaso.setValor(null);
					vatribaso.setVepAsociado(vepAsociado);
					vatribasoDAO.save(vatribaso);
				}
			}

			if (seleccionServOfrecer != null) {
				for (Integer item : seleccionServOfrecer) {
					VepAtributoAsociado vatribaso = new VepAtributoAsociado();
					VepSipParametro vepSipParametro = new VepSipParametro();
					vepSipParametro.setIdTipoClasif(item);
					vatribaso.setVepSipParametro(vepSipParametro);
					if (item.equals(new Integer(49)))
						vatribaso.setValor(otroServOfrecer);
					else
						vatribaso.setValor(null);

					vatribaso.setVepAsociado(vepAsociado);
					vatribasoDAO.save(vatribaso);
				}
			}

			if (idAcudiente == null) {
				try {
					saveAcudiente(tipoidacu, cedulaAcudiente, nombre1Acudiente,
							nombre2Acudiente, apellido1Acudiente,
							apellido2Acudiente, new Long(idAsociado),
							telefonoResidenciaAcudiente,
							telefonoComercialAcudiente,
							telefonoCelularAcudiente, vaso);

//					acu = rcons.consultarDatosAcudiente(tipoidacu,
//							cedulaAcudiente);
//					idAcudiente = acu.getIdAcudiente();
//					if (idAcudiente == null)
//						throw new Exception(MessageBundleLoader
//								.getMessage("labels.inscripcionaso.err36"));
					// else {
					// actualizaTipoAsociado(Long.parseLong(acu
					// .getNumDocumento()), acu.getCodTipDocumento(),
					// 2l, usuario);
					// }
				} catch (Exception e) {
					throw e;
				}
			} else {
				vaso.setIdAcudiente(new Long(acu.getIdAcudiente().longValue()));
				new VepAsociadoDAO().update(vaso);
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

	public String guardarBUC(Long tipoid, Long cedula, String nombre1,
			String nombre2, String apellido1, String apellido2,
			String telefonoResidencia, String telefonoComercial,
			String telefonoCelular) throws Exception {
		try {
			return guardarBUC(tipoid, cedula, nombre1, nombre2, apellido1,
					apellido2, new Date(1930, 11, 10), "M", "dirACU",
					telefonoResidencia, new Long("4"), new Long("2"), new Long(
							"1"), "");
		} catch (Exception e) {
			throw e;
		}
	}

	public String guardarBUC(Long tipoid, Long cedula, String nombre1,
			String nombre2, String apellido1, String apellido2, Date fechaNace,
			String genero, String direccionResidencia,
			String telefonoResidencia, Long tituloProfesional, Long ocupacion,
			Long estadoCivil, String usuario) throws Exception {

		try {
			DatosVinculacion datos = new DatosVinculacion();
			DelegadoWSVinculacionServiceLocator delVin = new DelegadoWSVinculacionServiceLocator();
			co.com.coomeva.ws.tipovinculacion.client.DelegadoWSVinculacionServiceLocator delVinTitulo = new co.com.coomeva.ws.tipovinculacion.client.DelegadoWSVinculacionServiceLocator();
			DelegadoWSVinculacion delegado = delVin.getvincularCliente();
			co.com.coomeva.ws.tipovinculacion.client.DelegadoWSVinculacion delegadoTitulo = delVinTitulo
					.getvincularCliente();

			datos.setTipoDoc(tipoid.toString());
			datos.setNumIdentificacion(cedula.toString());

			datos.setPrimerNombre(nombre1);
			datos.setSegundoNombre(nombre2);
			datos.setPrimerApellido(apellido1);
			datos.setSegundoApellido(apellido2);

			DateTime nacimientoFecha = new DateTime(fechaNace);
			String mes = String.valueOf(nacimientoFecha.getMonthOfYear());
			String annio = String.valueOf(nacimientoFecha.getYear());
			String dia = String.valueOf(nacimientoFecha.getDayOfMonth());

			if (mes.length() == 1)
				mes = "0" + mes;
			if (dia.length() == 1)
				dia = "0" + dia;

			datos.setFechaNac(annio + mes + dia);

			if (genero.trim().equals("M"))
				datos.setSexo(LocalApplicationConfiguration.Util.getInstance()
						.getProperty("setSexoM"));
			else
				datos.setSexo(LocalApplicationConfiguration.Util.getInstance()
						.getProperty("setSexoF"));

			datos.setDirReside(direccionResidencia);
			datos.setCodCiiu(LocalApplicationConfiguration.Util.getInstance()
					.getProperty("setCodCiiu"));

			datos.setNumTelReside(telefonoResidencia);

			datos.setIndEstudio(LocalApplicationConfiguration.Util
					.getInstance().getProperty("setIndEstudio"));
			datos.setOcupacion(ocupacion.toString());
			datos.setEstadoCivil(estadoCivil.toString());

			datos.setNombreCajero(LocalApplicationConfiguration.Util
					.getInstance().getProperty("setNombreCajero"));// oblig
			datos.setTipoCliente(LocalApplicationConfiguration.Util
					.getInstance().getProperty("setTipoCliente"));// oblig
			datos.setFechaExpDoc(LocalApplicationConfiguration.Util
					.getInstance().getProperty("setFechaExpDoc"));// oblig
			datos.setBarrioReside(LocalApplicationConfiguration.Util
					.getInstance().getProperty("setBarrioReside"));// oblig
			datos.setVlrIngresos(LocalApplicationConfiguration.Util
					.getInstance().getProperty("setVlrIngresos"));// oblig
			datos.setTipoVivienda(LocalApplicationConfiguration.Util
					.getInstance().getProperty("setTipoVivienda"));// oblig
			datos.setEstrato(LocalApplicationConfiguration.Util.getInstance()
					.getProperty("setEstrato"));// oblig

			datos.setVlrComercialPatrim1(LocalApplicationConfiguration.Util
					.getInstance().getProperty("setVlrComercialPatrim1"));// oblig
			datos.setLugarNac(LocalApplicationConfiguration.Util.getInstance()
					.getProperty("setLugarNac"));
			datos.setLugarExpDoc(LocalApplicationConfiguration.Util
					.getInstance().getProperty("setLugarExpDoc"));

			DatosVinculacion retorno = delegado.vincularCliente(datos);
			if (String.valueOf(retorno.getCodError()).equals("991")) {
				String detalleError = MessagesConfiguration.Util.getInstance()
						.getProperty(retorno.getCodError());
				String retornoNew = delegadoTitulo.registrarTitulo(cedula
						.longValue(), tipoid.longValue(), "AS", "", 0l,
						tituloProfesional.longValue(), 0l, " ", usuario);
				// throw new Exception("Error: " + retorno.getCodError() + ". "
				// + detalleError + ". " + retorno.getMensajeError());
			} else {
				String detalleError = MessagesConfiguration.Util.getInstance()
						.getProperty(retorno.getCodError());
				throw new Exception(retorno.getCodError() + ": " + detalleError);
			}
			return retorno.getCodError();

		} catch (Exception err) {
			throw err;
		}
	}

	public void actualizaTipoAsociado(long nitcli, long tipdoc, long asocia,
			String usruac) throws Exception {
		// TODO Auto-generated method stub
		try {
			co.com.coomeva.ws.tipoasociado.client.DelegadoWSVinculacionServiceLocator delWSV = new co.com.coomeva.ws.tipoasociado.client.DelegadoWSVinculacionServiceLocator();
			co.com.coomeva.ws.tipoasociado.client.DelegadoWSVinculacion delegado = delWSV
					.getvincularCliente();
			String retorno = delegado.actualizarAsocia(nitcli, tipdoc, asocia,
					usruac);
			if (!retorno.equalsIgnoreCase("1-Exito")) {
				String detalleError = MessageBundleLoader
						.getMessage("labels.inscripcionaso.err44");
				throw new Exception("Error: " + detalleError);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public void actualizaDatosUbicacion(AsociadoVida asociado) throws Exception {
		// TODO Auto-generated method stub
		Asociado asocia = new Asociado();
		asocia.setBarComercial(asociado.getBarComercial());
		asocia.setBarFamiliar(asociado.getBarFamiliar());
		asocia.setBarResidencia(asociado.getBarResidencia());
		asocia.setCelular(asociado.getCelular());
		asocia.setCiuComercial(asociado.getCiuComercial());
		asocia.setCiuFamiliar(asociado.getCiuFamiliar());
		asocia.setCiuResidencia(asociado.getCiuResidencia());
		asocia.setCodCiuComercial(asociado.getCodCiuComercial());
		asocia.setCodCiuFamiliar(asociado.getCodCiuFamiliar());
		asocia.setCodCiuResidencia(asociado.getCodCiuResidencia());
		asocia.setCodDepExpDocumento(asociado.getCodDepExpDocumento());
		asocia.setCodEstadoCivil(asociado.getCodEstadoCivil());
		asocia.setCodLugExpDocumento(asociado.getCodLugExpDocumento());
		asocia.setCodRetornoWS(asociado.getCodRetornoWS());
		asocia.setCodSexo(asociado.getCodSexo());
		asocia.setCodTipDocumento(asociado.getCodTipDocumento());
		asocia.setCodTipoCasa(asociado.getCodTipoCasa());
		asocia.setDepExpDocumento(asociado.getDepExpDocumento());
		asocia.setDescRetornoWS(asociado.getDescRetornoWS());
		asocia.setDirComercial(asociado.getDirComercial());
		asocia.setDirCorrespondencia(asociado.getDirCorrespondencia());
		asocia.setDirFamiliar(asociado.getDirFamiliar());
		asocia.setDirResidencia(asociado.getDirResidencia());
		asocia.setEmail(asociado.getEmail());
		asocia.setEstadoCivil(asociado.getEstadoCivil());
		asocia.setEstrato(asociado.getEstrato());
		asocia.setExtComercial(asociado.getExtComercial());
		asocia.setFaxComercial(asociado.getFaxComercial());
		asocia.setFecExpDocumento(asociado.getFecExpDocumento());
		asocia.setLugExpDocumento(asociado.getLugExpDocumento());
		asocia.setNombre1(asociado.getNombre1());
		asocia.setNombre2(asociado.getNombre2());
		asocia.setNumDocumento(asociado.getNumDocumento());
		asocia.setNumInt(asociado.getNumInt());
		asocia.setPerMayCargo(asociado.getPerMayCargo());
		asocia.setPerMenCargo(asociado.getPerMenCargo());
		asocia.setPrimerApellido(asociado.getPrimerApellido());
		asocia.setSegundoApellido(asociado.getSegundoApellido());
		asocia.setSexo(asociado.getSexo());
		asocia.setSistema(Properties.getInstance()
				.getLoadBundleServicioAutenticacion().getProperty("nombreApp"));
		asocia.setTelComercial(asociado.getTelComercial());
		asocia.setTelFamiliar(asociado.getTelFamiliar());
		asocia.setTelResidencia(asociado.getTelResidencia());
		asocia.setTipDocumento(asociado.getTipDocumento());
		asocia.setTipoCasa(asociado.getTipoCasa());
		asocia.setTipUbiDirCor(asociado.getTipUbiDirCor());
		asocia.setUsuario(asociado.getUsuario());

		DelegadoWSServiceLocator DWSS = new DelegadoWSServiceLocator();
		DelegadoWS delegado = DWSS.getadmonAsociado();
		String retorno = delegado.actualizarAsociado(asocia);
		System.out.println("retorno actualizacion -> " + retorno);
	}

	public void saveAcudiente(Long tipoDoc, Long cedula, String nombre,
			String nombre2, String apellido1, String apellido2,
			Long idAsociado, String telefonoResidencia,
			String telefonoComercial, String telefonoCelular, VepAsociado vae)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			VepAcudiente va = new VepAcudiente();
			VepUbicacionAcudiente vua = null;
			VepUbicacionAcudienteId vuaId = null;
			List<VepUbicacionAcudiente> listaVua = new ArrayList<VepUbicacionAcudiente>();

			va.setTipoDocumento(tipoDoc);
			va.setNumeroDocumento(cedula);
			va.setNombre1(nombre);
			va.setNombre2(nombre2);
			va.setApellido1(apellido1);
			va.setApellido2(apellido2);
			va.setIdAsociado(vae.getIdAsociado());

			// EntityManagerHelper.getEntityManager().getTransaction().begin();
			// EntityManagerHelper.getEntityManager().flush();
			new VepAcudienteDAO().save(va);

			vae.setIdAcudiente(new Long(va.getIdAcudiente().longValue()));

			new VepAsociadoDAO().update(vae);

			if (telefonoResidencia.trim().length() > 0) {
				vua = new VepUbicacionAcudiente();
				vuaId = new VepUbicacionAcudienteId();
				vuaId.setIdAcudiente(va.getIdAcudiente());
				vuaId.setTipoUbicacion(LocalApplicationConfiguration.Util
						.getInstance().getProperty("telefono_residencia"));
				vua.setId(vuaId);
				vua.setDescripcionUbicacion(telefonoResidencia);
				listaVua.add(vua);
			}

			if (telefonoComercial.trim().length() > 0) {
				vua = new VepUbicacionAcudiente();
				vuaId = new VepUbicacionAcudienteId();
				vuaId.setIdAcudiente(va.getIdAcudiente());
				vuaId.setTipoUbicacion(LocalApplicationConfiguration.Util
						.getInstance().getProperty("telefono_comercial"));
				vua.setId(vuaId);
				vua.setDescripcionUbicacion(telefonoComercial);
				listaVua.add(vua);
			}

			if (telefonoCelular.trim().length() > 0) {
				vua = new VepUbicacionAcudiente();
				vuaId = new VepUbicacionAcudienteId();
				vuaId.setIdAcudiente(va.getIdAcudiente());
				vuaId.setTipoUbicacion(LocalApplicationConfiguration.Util
						.getInstance().getProperty("telefono_celular"));
				vua.setId(vuaId);
				vua.setDescripcionUbicacion(telefonoCelular);
				listaVua.add(vua);
			}

			for (VepUbicacionAcudiente vepUbicacionAcudiente : listaVua) {
				new VepUbicacionAcudienteDAO().save(vepUbicacionAcudiente);
			}
			// EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (EntityManagerHelper.getEntityManager().getTransaction()
					.isActive())
				EntityManagerHelper.getEntityManager().getTransaction()
						.rollback();
			throw e;
		}

	}
}
