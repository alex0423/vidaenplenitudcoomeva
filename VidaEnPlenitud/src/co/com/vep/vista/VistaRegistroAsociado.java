package co.com.vep.vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.faces.model.SelectItem;

import org.joda.time.DateTime;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.logica.AsociadoLogica;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.StringUtils;

public class VistaRegistroAsociado {

	public Long tipoid;
	public Long tipoAsociado;
	public Long corte;
	public String corteLabel;
	public Long tituloProfesional;
	public String tituloProfesionalLabel;
	public Long ocupacion;
	public String ocupacionLabel;
	public Long estadoCivil;
	public String estadoCivilLabel;
	public Long tipoidacu;
	public Integer num_cuotas_vencidas;
	public String cedula;
	public String nombre1;
	public String nombre2;
	public String apellido1;
	public String apellido2;
	public Date fechaNace;
	public Integer edad;
	public String tipoSangre;
	public String genero;
	public Long generoId;
	public Long codigoAsociado;
	public String estadoAsociado;
	public Date fechaEstado;
	public Date fechaIngresoAsociado;

	public Date fechaCorte;
	public Date fechaIngVEP;

	public String direccionResidencia;
	public String dirComercial;
	public String telefonoResidencia;
	public String telefonoComercial;
	public String telefonoCelular;
	public String correoElectrinico;

	public Long numCuotasVen;
	public String ciudadComercial;
	public String medicamentos;

	public String compartir;

	public String numHorasDisp;

	public Long cedulaAcudiente;
	public String nombre1Acudiente;
	public String nombre2Acudiente;
	public String apellido1Acudiente;
	public String apellido2Acudiente;
	public String telefonoResidenciaAcudiente;
	public String telefonoComercialAcudiente;
	public String telefonoCelularAcudiente;
	public Long codigoAcudiente;

	public String otraPat;
	public String otroHob;

	public String otroServicio;
	public String otroCon;

	public String ciuCom;
	public String ciuRes;

	public List<SelectItem> registeredPatologias;
	public List<SelectItem> registeredConocimientos;
	public List<SelectItem> registeredHobbies;
	public List<SelectItem> registeredServMedico;
	public List<SelectItem> registeredServOfrecer;
	public List<SelectItem> registeredPAMS;

	public VistaRegistroAsociado() {

	}

	public Long getTipoid() {
		return tipoid;
	}

	public void setTipoid(Long tipoid) {
		this.tipoid = tipoid;
	}

	public Long getTipoAsociado() {
		return tipoAsociado;
	}

	public void setTipoAsociado(Long tipoAsociado) {
		this.tipoAsociado = tipoAsociado;
	}

	public Long getCorte() {
		return corte;
	}

	public void setCorte(Long corte) {
		this.corte = corte;
	}

	public Long getTituloProfesional() {
		return tituloProfesional;
	}

	public void setTituloProfesional(Long tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public Long getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Long ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Long getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Long estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Long getTipoidacu() {
		return tipoidacu;
	}

	public void setTipoidacu(Long tipoidacu) {
		this.tipoidacu = tipoidacu;
	}

	public Integer getNum_cuotas_vencidas() {
		return num_cuotas_vencidas;
	}

	public void setNum_cuotas_vencidas(Integer num_cuotas_vencidas) {
		this.num_cuotas_vencidas = num_cuotas_vencidas;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFechaNace() {
		return fechaNace;
	}

	public void setFechaNace(Date fechaNace) {
		this.fechaNace = fechaNace;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getCodigoAsociado() {
		return codigoAsociado;
	}

	public void setCodigoAsociado(Long codigoAsociado) {
		this.codigoAsociado = codigoAsociado;
	}

	public String getEstadoAsociado() {
		return estadoAsociado;
	}

	public void setEstadoAsociado(String estadoAsociado) {
		this.estadoAsociado = estadoAsociado;
	}

	public Date getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Date getFechaIngresoAsociado() {
		return fechaIngresoAsociado;
	}

	public void setFechaIngresoAsociado(Date fechaIngresoAsociado) {
		this.fechaIngresoAsociado = fechaIngresoAsociado;
	}

	public Date getFechaCorte() {
		return fechaCorte;
	}

	public void setFechaCorte(Date fechaCorte) {
		this.fechaCorte = fechaCorte;
	}

	public Date getFechaIngVEP() {
		return fechaIngVEP;
	}

	public void setFechaIngVEP(Date fechaIngVEP) {
		this.fechaIngVEP = fechaIngVEP;
	}

	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}

	public String getDirComercial() {
		return dirComercial;
	}

	public void setDirComercial(String dirComercial) {
		this.dirComercial = dirComercial;
	}

	public String getTelefonoResidencia() {
		return telefonoResidencia;
	}

	public void setTelefonoResidencia(String telefonoResidencia) {
		this.telefonoResidencia = telefonoResidencia;
	}

	public String getTelefonoComercial() {
		return telefonoComercial;
	}

	public void setTelefonoComercial(String telefonoComercial) {
		this.telefonoComercial = telefonoComercial;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getCorreoElectrinico() {
		return correoElectrinico;
	}

	public void setCorreoElectrinico(String correoElectrinico) {
		this.correoElectrinico = correoElectrinico;
	}

	public Long getNumCuotasVen() {
		return numCuotasVen;
	}

	public void setNumCuotasVen(Long numCuotasVen) {
		this.numCuotasVen = numCuotasVen;
	}

	public String getCiudadComercial() {
		return ciudadComercial;
	}

	public void setCiudadComercial(String ciudadComercial) {
		this.ciudadComercial = ciudadComercial;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getCompartir() {
		return compartir;
	}

	public void setCompartir(String compartir) {
		this.compartir = compartir;
	}

	public String getNumHorasDisp() {
		return numHorasDisp;
	}

	public void setNumHorasDisp(String numHorasDisp) {
		this.numHorasDisp = numHorasDisp;
	}

	public Long getCedulaAcudiente() {
		return cedulaAcudiente;
	}

	public void setCedulaAcudiente(Long cedulaAcudiente) {
		this.cedulaAcudiente = cedulaAcudiente;
	}

	public String getNombre1Acudiente() {
		return nombre1Acudiente;
	}

	public void setNombre1Acudiente(String nombre1Acudiente) {
		this.nombre1Acudiente = nombre1Acudiente;
	}

	public String getNombre2Acudiente() {
		return nombre2Acudiente;
	}

	public void setNombre2Acudiente(String nombre2Acudiente) {
		this.nombre2Acudiente = nombre2Acudiente;
	}

	public String getApellido1Acudiente() {
		return apellido1Acudiente;
	}

	public void setApellido1Acudiente(String apellido1Acudiente) {
		this.apellido1Acudiente = apellido1Acudiente;
	}

	public String getApellido2Acudiente() {
		return apellido2Acudiente;
	}

	public void setApellido2Acudiente(String apellido2Acudiente) {
		this.apellido2Acudiente = apellido2Acudiente;
	}

	public String getTelefonoResidenciaAcudiente() {
		return telefonoResidenciaAcudiente;
	}

	public void setTelefonoResidenciaAcudiente(
			String telefonoResidenciaAcudiente) {
		this.telefonoResidenciaAcudiente = telefonoResidenciaAcudiente;
	}

	public String getTelefonoComercialAcudiente() {
		return telefonoComercialAcudiente;
	}

	public void setTelefonoComercialAcudiente(String telefonoComercialAcudiente) {
		this.telefonoComercialAcudiente = telefonoComercialAcudiente;
	}

	public String getTelefonoCelularAcudiente() {
		return telefonoCelularAcudiente;
	}

	public void setTelefonoCelularAcudiente(String telefonoCelularAcudiente) {
		this.telefonoCelularAcudiente = telefonoCelularAcudiente;
	}

	public Long getCodigoAcudiente() {
		return codigoAcudiente;
	}

	public void setCodigoAcudiente(Long codigoAcudiente) {
		this.codigoAcudiente = codigoAcudiente;
	}

	public String getOtraPat() {
		return otraPat;
	}

	public void setOtraPat(String otraPat) {
		this.otraPat = otraPat;
	}

	public String getOtroHob() {
		return otroHob;
	}

	public void setOtroHob(String otroHob) {
		this.otroHob = otroHob;
	}

	public String getOtroServicio() {
		return otroServicio;
	}

	public void setOtroServicio(String otroServicio) {
		this.otroServicio = otroServicio;
	}

	public String getOtroCon() {
		return otroCon;
	}

	public void setOtroCon(String otroCon) {
		this.otroCon = otroCon;
	}

	public String getCiuCom() {
		return ciuCom;
	}

	public void setCiuCom(String ciuCom) {
		this.ciuCom = ciuCom;
	}

	public String getCiuRes() {
		return ciuRes;
	}

	public void setCiuRes(String ciuRes) {
		this.ciuRes = ciuRes;
	}

	public String getEstadoCivilLabel() {
		return estadoCivilLabel;
	}

	public void setEstadoCivilLabel(String estadoCivilLabel) {
		this.estadoCivilLabel = estadoCivilLabel;
	}

	public String getOcupacionLabel() {
		return ocupacionLabel;
	}

	public void setOcupacionLabel(String ocupacionLabel) {
		this.ocupacionLabel = ocupacionLabel;
	}

	public String getTituloProfesionalLabel() {
		return tituloProfesionalLabel;
	}

	public void setTituloProfesionalLabel(String tituloProfesionalLabel) {
		this.tituloProfesionalLabel = tituloProfesionalLabel;
	}

	public void mostrarRegistro(Long documento, Integer tipoDocumento)
			throws Exception {
		try {
			AsociadoLogica logica = new AsociadoLogica();
			VepPlusBuc drc = logica.obtenerDetalleBUC(documento, Long
					.valueOf(tipoDocumento.toString()));
			VepAsociado asociado = logica
					.obtenerAsVep(documento, tipoDocumento);
			AsociadoVida aVida = logica.obtenerAsAsociado(documento,
					tipoDocumento);
			if (drc == null || asociado == null || aVida == null)
				throw new Exception("Registro inconsistente");

			mostrarRegistro(drc, asociado, aVida);
		} catch (Exception e) {
			throw e;
		}
	}

	public void mostrarRegistroFromBuc(AsociadoVida aVida) throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		try {
			cedula = aVida.getNumDocumento();
			codigoAsociado = aVida.getCodAsociado();
			telefonoCelular = aVida.getCelular();
			direccionResidencia = aVida.getDirResidencia();
			fechaNace = StringUtils.cambiarFechaTexto_Date(StringUtils
					.generarFechaCorrecta(String.valueOf(aVida
							.getFecNacimiento())));

			estadoCivilLabel = aVida.getEstadoCivil();
			if (estadoCivilLabel != null) {
				List<SelectItem> lstEstadoCivil = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getEstadoCivil();
				for (SelectItem item : lstEstadoCivil) {
					if (item.getLabel().toString().contains(estadoCivilLabel)) {
						estadoCivil = new Long(item.getValue().toString());
						break;
					}
				}
			}
			ocupacionLabel = aVida.getOcupacion().trim();
			if (ocupacionLabel != null) {
				List<SelectItem> lstOcupacion = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getOcupacion();
				for (SelectItem item : lstOcupacion) {
					if (item.getLabel().toString().trim().equalsIgnoreCase(
							ocupacionLabel)) {
						ocupacion = new Long(item.getValue().toString());
						break;
					}
				}
			}
			tituloProfesionalLabel = aVida.getProfesion().trim();
			if (tituloProfesionalLabel != null) {
				List<SelectItem> lstProfesion = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getTituloProfesional();
				for (SelectItem item : lstProfesion) {
					if (item.getLabel().toString().trim().equalsIgnoreCase(
							tituloProfesionalLabel)) {
						tituloProfesional = new Long(item.getValue().toString());
						break;
					}
				}
			}
			generoId = new Long(aVida.getCodSexo());
			corteLabel = aVida.getCorte();
			telefonoComercial = aVida.getTelComercial();
			edad = miEdad(fechaNace);
			fechaIngresoAsociado = StringUtils
					.cambiarFechaTexto_Date(StringUtils
							.generarFechaCorrecta(String.valueOf(aVida
									.getFecIngreso())));
			tipoid = aVida.getCodTipDocumento();
			nombre1 = aVida.getNombre1();
			nombre2 = aVida.getNombre2();
			apellido1 = aVida.getPrimerApellido();
			apellido2 = aVida.getSegundoApellido();

			direccionResidencia = aVida.getDirResidencia();
			telefonoResidencia = aVida.getTelResidencia();
			telefonoCelular = aVida.getCelular();
			ciuRes = aVida.getCiuResidencia();
			ciuCom = aVida.getCiuComercial();
			correoElectrinico = aVida.getEmail();

			System.out.println("CODIGO CORTE -> " + aVida.getCorte());
			if (aVida.getCorte() != null
					|| aVida.getCorte().trim().length() != 0) {
				List<SelectItem> lstCortes = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getCorte();
				for (SelectItem item : lstCortes) {
					if (item.getLabel() == aVida.getCorte()) {
						corte = new Long(item.getValue().toString());
						break;
					}
				}
			}

			if (aVida.getEstado() != 0l) {
				List<SelectItem> lstProfesion = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getTipoEstadoAsociado();
				for (SelectItem item : lstProfesion) {
					if (new Long(item.getValue().toString()).longValue() == aVida
							.getEstado()) {
						estadoAsociado = item.getLabel();
						break;
					}
				}
			}

			fechaEstado = formato.parse(StringUtils.generarFechaCorrecta(
					String.valueOf(aVida.getFecEstado())).replace("-", "/"));

			fechaIngVEP = new GregorianCalendar().getTime();
		} catch (Exception e) {
			throw e;
		}
	}

	public void mostrarRegistro(AsociadoVida aVida) throws Exception {
		try {
			AsociadoLogica logica = new AsociadoLogica();
			VepAsociado asociado = logica.obtener(new Long(aVida
					.getCodTipDocumento()), new Long(aVida.getNumDocumento()));
			VepPlusBuc drc = logica.obtenerDetalleBUC(asociado.getDocumento(),
					Long.valueOf(asociado.getTipoDocumento()));

			mostrarRegistro(drc, asociado, aVida);
		} catch (Exception e) {
			throw e;
		}
	}

	public void mostrarRegistro(VepAsociado asociado) throws Exception {
		try {
			AsociadoLogica logica = new AsociadoLogica();
			Long tipo = Long.valueOf(asociado.getTipoDocumento());
			VepPlusBuc drc = logica.obtenerDetalleBUC(asociado.getDocumento(),
					tipo);
			AsociadoVida aVida = logica.obtenerAsAsociado(asociado
					.getDocumento(), new Integer(asociado.getTipoDocumento()));
			if (drc == null || asociado == null || aVida == null)
				throw new Exception("Registro inconsistente");

			mostrarRegistro(drc, asociado, aVida);
		} catch (Exception e) {
			throw e;
		}
	}

	public void mostrarRegistro(VepPlusBuc drc) throws Exception {
		try {
			AsociadoLogica logica = new AsociadoLogica();
			VepAsociado asociado = logica.obtenerAsVep(drc.getDocumento(),
					new Integer(drc.getTipodocumentoAsociado()));
			AsociadoVida aVida = logica.obtenerAsAsociado(drc.getDocumento(),
					new Integer(drc.getTipodocumentoAsociado()));
			if (drc == null || asociado == null || aVida == null)
				throw new Exception("Registro inconsistente");

			mostrarRegistro(drc, asociado, aVida);
		} catch (Exception e) {
			throw e;
		}
	}

	private void mostrarRegistro(VepPlusBuc drc, VepAsociado asociado,
			AsociadoVida aVida) throws Exception {
		AsociadoLogica logica = new AsociadoLogica();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			System.out.println("Estado Civil: " + drc.getEstcivil());
			if (drc.getEstcivil() != null) {
				List<SelectItem> lstEstadoCivil = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getEstadoCivil();
				for (SelectItem item : lstEstadoCivil) {
					System.out.println("ID:" + item.getValue());
					if (item.getValue().toString().equals(drc.getEstcivil())) {
						estadoCivilLabel = item.getLabel();
						break;
					}
				}
			}

			System.out.println("Ocupacion: " + drc.getOcupacion());
			if (drc.getOcupacion() != null) {
				List<SelectItem> lstOcupacion = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getOcupacion();
				for (SelectItem item : lstOcupacion) {
					System.out.println("ID:" + item.getValue());
					if (item.getValue().toString().equals(drc.getOcupacion())) {
						ocupacionLabel = item.getLabel();
						break;
					}
				}
			}

			tituloProfesionalLabel = aVida.getProfesion();
			if (tituloProfesionalLabel != null) {
				List<SelectItem> lstProfesion = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getTituloProfesional();
				for (SelectItem item : lstProfesion) {
					if (item.getLabel().toString().contains(
							tituloProfesionalLabel)) {
						tituloProfesional = new Long(item.getValue().toString());
						break;
					}
				}
			}

			if (asociado.getTipoAsociado().equals("1")) {
				if (aVida.getEstado() != 0l) {
					List<SelectItem> estadosAsociado = ((LOVsVista) FacesUtils
							.getManagedBean("LOVs")).getTipoEstadoAsociado();
					for (SelectItem item : estadosAsociado) {
						if (aVida.getEstado() == new Long(item.getValue()
								.toString()).longValue()) {
							estadoAsociado = item.getLabel();
							break;
						}
					}
				}
			}

			if (aVida.getCorte().equalsIgnoreCase("Tipos de Corte")) {
				corteLabel = "";
			} else {
				corteLabel = aVida.getCorte();
			}

			fechaNace = drc.getFechaNace();

			if (fechaNace != null)
				edad = miEdad(fechaNace);
			if (asociado.getDocumento() != null) {
				if (new Integer(asociado.getTipoAsociado()).intValue() == 1) {
					fechaIngresoAsociado = formato.parse(StringUtils
							.generarFechaCorrecta(String.valueOf(aVida
									.getFecIngreso())));
					fechaEstado = formato.parse(StringUtils
							.generarFechaCorrecta(String.valueOf(aVida
									.getFecEstado())));
				}
			}

			nombre1 = drc.getNombre1Asociado();
			nombre2 = drc.getNombre2Asociado();
			apellido1 = drc.getApellido1Asociado();
			apellido2 = drc.getApellido2Asociado();
			estadoCivil = new Long(drc.getEstcivil());

			fechaIngVEP = drc.getFechaIngresovp();
			genero = aVida.getSexo();
			ocupacion = new Long(drc.getOcupacion());
			tipoSangre = drc.getTipoSangre();
			codigoAsociado = drc.getIdAsociado();
			cedula = drc.getDocumento().toString();
			medicamentos = drc.getMedicamentos();
			tipoid = new Long(drc.getTipodocumentoAsociado());
			numHorasDisp = drc.getNumeroHorasDispSv().toString();

			direccionResidencia = aVida.getDirResidencia();
			telefonoResidencia = aVida.getTelResidencia();
			telefonoCelular = aVida.getCelular();
			ciuRes = aVida.getCiuResidencia();
			ciuCom = aVida.getCiuComercial();
			correoElectrinico = aVida.getEmail();
			tipoAsociado = null;

			List<VepAtributoAsociado> atts = logica
					.obtenerDetalleAtributos(asociado.getIdAsociado());
			System.out.println("Size: " + atts.size());
			if (atts.size() > 0) {
				List<SelectItem> lstPatologias = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getPatologias();
				List<SelectItem> lstServMedicos = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getServicioMedico();
				List<SelectItem> lstServOfrecer = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getServiciosOfrecer();
				List<SelectItem> lstHobbies = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getHobbies();
				List<SelectItem> lstConocimientos = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getConocimientos();
				List<SelectItem> lstPAMs = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getPAM();

				registeredConocimientos = new ArrayList<SelectItem>();
				registeredHobbies = new ArrayList<SelectItem>();
				registeredPAMS = new ArrayList<SelectItem>();
				registeredPatologias = new ArrayList<SelectItem>();
				registeredServMedico = new ArrayList<SelectItem>();
				registeredServOfrecer = new ArrayList<SelectItem>();

				boolean found = false;
				for (VepAtributoAsociado att : atts) {
					found = false;
					for (SelectItem selectItem : lstPatologias) {
						if (selectItem.getValue().equals(
								att.getVepSipParametro().getIdTipoClasif())) {
							registeredPatologias.add(selectItem);
							found = true;
							break;
						}
					}

					if (!found)
						for (SelectItem selectItem : lstServMedicos) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredServMedico.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						for (SelectItem selectItem : lstServOfrecer) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredServOfrecer.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						for (SelectItem selectItem : lstHobbies) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredHobbies.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						for (SelectItem selectItem : lstConocimientos) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredConocimientos.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						for (SelectItem selectItem : lstPAMs) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredPAMS.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						System.out.println("Sin grupo: "
								+ att.getVepSipParametro().getIdTipoClasif());
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void mostrarRegistro(VepAsociado asociado, VepPlusBuc aVida)
			throws Exception {
		AsociadoLogica logica = new AsociadoLogica();
		try {

			estadoCivilLabel = aVida.getEstcivil();
			ocupacionLabel = aVida.getOcupacion();
			// tituloProfesional = aVida.get; tituloProfesional

			if (aVida.getOcupacion() != null) {
				List<SelectItem> lstOcupacion = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getOcupacion();
				for (SelectItem item : lstOcupacion) {
					if (item.getValue().toString().equals(
							asociado.getOcupacion())) {
						ocupacionLabel = item.getLabel();
						break;
					}
				}
			}

			// System.out.println("tituloProfesional: " + aVida.getProfesion());
			// tituloProfesionalLabel = aVida.getProfesion();
			// if (tituloProfesionalLabel != null) {
			// List<SelectItem> lstProfesion = ((LOVsVista) FacesUtils
			// .getManagedBean("LOVs")).getTituloProfesional();
			// for (SelectItem item : lstProfesion) {
			// if (item.getLabel().toString().contains(
			// tituloProfesionalLabel)) {
			// tituloProfesionalLabel = item.getLabel();
			// break;
			// }
			// }
			// }

			if (aVida.getEstadoAsociado() != 0l) {
				List<SelectItem> estadosAsociado = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getTipoEstadoAsociado();
				for (SelectItem item : estadosAsociado) {
					if (aVida.getEstadoAsociado() == new Long(item.getValue()
							.toString()).longValue()) {
						estadoAsociado = item.getLabel();
						break;
					}
				}
			}

			// if (aVida.getCorte().equalsIgnoreCase("Tipos de Corte")) {
			// corteLabel = "";
			// } else {
			// corteLabel = aVida.getCorte();
			// }

			if (fechaNace != null)
				edad = miEdad(fechaNace);
			// if (asociado.getTipoAsociado() != null) {
			// if (new Integer(asociado.getTipoAsociado()).intValue() == 1) {
			// fechaIngresoAsociado = formato.parse(StringUtils
			// .generarFechaCorrecta(String.valueOf(aVida
			// .getFecIngreso())));
			// fechaEstado = formato.parse(StringUtils
			// .generarFechaCorrecta(String.valueOf(aVida
			// .getFecEstado())));
			// }
			// }

			nombre1 = aVida.getNombre1Asociado();
			nombre2 = aVida.getNombre2Asociado();
			apellido1 = aVida.getApellido1Asociado();
			apellido2 = aVida.getApellido2Asociado();
			estadoCivil = new Long(asociado.getEstcivil());
			fechaNace = aVida.getFechaNace();

			fechaIngVEP = aVida.getFechaIngresovp();
			genero = aVida.getGenero();
			// ocupacion = new Long(asociado.getOcupacion());
			tipoSangre = asociado.getTipoSangre();
			codigoAsociado = asociado.getIdAsociado();
			cedula = asociado.getDocumento().toString();
			// medicamentos = drc.getMedicamentos();
			// tipoid = new Long(drc.getTipodocumentoAsociado());
			// numHorasDisp = drc.getNumeroHorasDispSv().toString();

			// direccionResidencia = aVida.getDirResidencia();
			// telefonoResidencia = aVida.getTelResidencia();
			// telefonoCelular = aVida.getCelular();
			// ciuRes = aVida.getCiuResidencia();
			// ciuCom = aVida.getCiuComercial();
			// correoElectrinico = aVida.getEmail();
			tipoAsociado = null;

			List<VepAtributoAsociado> atts = logica
					.obtenerDetalleAtributos(asociado.getIdAsociado());
			System.out.println("Size: " + atts.size());
			if (atts.size() > 0) {
				List<SelectItem> lstPatologias = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getPatologias();
				List<SelectItem> lstServMedicos = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getServicioMedico();
				List<SelectItem> lstServOfrecer = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getServiciosOfrecer();
				List<SelectItem> lstHobbies = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getHobbies();
				List<SelectItem> lstConocimientos = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getConocimientos();
				List<SelectItem> lstPAMs = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getPAM();

				registeredConocimientos = new ArrayList<SelectItem>();
				registeredHobbies = new ArrayList<SelectItem>();
				registeredPAMS = new ArrayList<SelectItem>();
				registeredPatologias = new ArrayList<SelectItem>();
				registeredServMedico = new ArrayList<SelectItem>();
				registeredServOfrecer = new ArrayList<SelectItem>();

				boolean found = false;
				for (VepAtributoAsociado att : atts) {
					found = false;
					for (SelectItem selectItem : lstPatologias) {
						if (selectItem.getValue().equals(
								att.getVepSipParametro().getIdTipoClasif())) {
							registeredPatologias.add(selectItem);
							found = true;
							break;
						}
					}

					if (!found)
						for (SelectItem selectItem : lstServMedicos) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredServMedico.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						for (SelectItem selectItem : lstServOfrecer) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredServOfrecer.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						for (SelectItem selectItem : lstHobbies) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredHobbies.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						for (SelectItem selectItem : lstConocimientos) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredConocimientos.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						for (SelectItem selectItem : lstPAMs) {
							if (selectItem.getValue().equals(
									att.getVepSipParametro().getIdTipoClasif())) {
								registeredPAMS.add(selectItem);
								found = true;
								break;
							}
						}

					if (!found)
						System.out.println("Sin grupo: "
								+ att.getVepSipParametro().getIdTipoClasif());
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private Integer miEdad(Date fechaNace) {

		DateTime nacimiento = new DateTime(fechaNace.getTime());
		DateTime hoy = new DateTime();

		int diff_year = hoy.minusYears(nacimiento.getYear()).getYear();
		System.out.println(diff_year);
		int diff_mes = hoy.minusMonths(nacimiento.getMonthOfYear())
				.getMonthOfYear();
		System.out.println(diff_mes);
		if (diff_mes < 0)
			diff_year--;
		System.out.println(diff_year);
		return diff_year;
	}

	public List<SelectItem> getRegisteredPatologias() {
		return registeredPatologias;
	}

	public void setRegisteredPatologias(List<SelectItem> registeredPatologias) {
		this.registeredPatologias = registeredPatologias;
	}

	public List<SelectItem> getRegisteredConocimientos() {
		return registeredConocimientos;
	}

	public void setRegisteredConocimientos(
			List<SelectItem> registeredConocimientos) {
		this.registeredConocimientos = registeredConocimientos;
	}

	public List<SelectItem> getRegisteredHobbies() {
		return registeredHobbies;
	}

	public void setRegisteredHobbies(List<SelectItem> registeredHobbies) {
		this.registeredHobbies = registeredHobbies;
	}

	public List<SelectItem> getRegisteredServMedico() {
		return registeredServMedico;
	}

	public void setRegisteredServMedico(List<SelectItem> registeredServMedico) {
		this.registeredServMedico = registeredServMedico;
	}

	public List<SelectItem> getRegisteredServOfrecer() {
		return registeredServOfrecer;
	}

	public void setRegisteredServOfrecer(List<SelectItem> registeredServOfrecer) {
		this.registeredServOfrecer = registeredServOfrecer;
	}

	public List<SelectItem> getRegisteredPAMS() {
		return registeredPAMS;
	}

	public void setRegisteredPAMS(List<SelectItem> registeredPAMS) {
		this.registeredPAMS = registeredPAMS;
	}

	public String getCorteLabel() {
		return corteLabel;
	}

	public void setCorteLabel(String corteLabel) {
		this.corteLabel = corteLabel;
	}

	public Long getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Long generoId) {
		this.generoId = generoId;
	}

}
