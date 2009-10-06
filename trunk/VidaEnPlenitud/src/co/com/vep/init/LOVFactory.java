package co.com.vep.init;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import co.com.parametros.modelo.DelegadoWsParametros;
import co.com.parametros.modelo.DelegadoWsParametrosServiceLocator;
import co.com.parametros.modelo.Pais;
import co.com.parametros.modelo.Parametros;
import co.com.parametros.modelo.ParametrosWS;
import co.com.vep.logica.RealizarConsultas;
import co.com.vep.logica.RegionalLogica;
import co.com.vep.logica.SIPParametrosLogica;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.persistencia.VepParametroActividadDAO;
import co.com.vep.properties.LocalApplicationConfiguration;

public class LOVFactory {

	public static List<SelectItem> getItems(String kindof) {
		if (kindof.equals("tiposIdentificacion"))
			return loadTiposIdentificacion();
		else if (kindof.equals("regionales"))
			return loadRegionales();
		else if (kindof.equals("regionalesUsuario"))
			return loadRegionalesUsuario();
		else if (kindof.equals("paises"))
			return loadPaises();
		else if (kindof.equals("ocupacion"))
			return loadOcupacion();
		else if (kindof.equals("tiposAsociado"))
			return loadTipoAsociado();
		else if (kindof.equals("corte"))
			return loadCorte();
		else if (kindof.equals("estadoCivil"))
			return loadEstadoCivil();
		else if (kindof.equals("tituloProfesional"))
			return loadTituloProfesional();
		else if (kindof.equals("PAM"))
			return loadPAM();
		else if (kindof.equals("patologias"))
			return loadPatologias();
		else if (kindof.equals("hobbies"))
			return loadHobbies();
		else if (kindof.equals("servicioMedico"))
			return loadServicioMedico();
		else if (kindof.equals("serviciosOfrecer"))
			return loadServiciosOfrecer();
		else if (kindof.equals("conocimientos"))
			return loadConocimientos();
		else if (kindof.equals("areasConocimiento"))
			return loadAreasConocimientos();
		else if (kindof.equals("genero"))
			return loadGenero();
		else if (kindof.equals("estado"))
			return loadEstados();
		else if (kindof.equals("mediosConocimiento"))
			return loadMediosConocimiento();
		else if (kindof.equals("atencion"))
			return loadAtencion();
		else if (kindof.equals("sino"))
			return loadSiNo();
		else if (kindof.equals("MAMS"))
			return loadMAMS();
		else if (kindof.equals("MAMI"))
			return loadMAMI();
		else if (kindof.equals("AAVD"))
			return loadAAVD();
		else if (kindof.equals("AIVD"))
			return loadAIVD();
		else if (kindof.equals("FMMI"))
			return loadFMMI();
		else if (kindof.equals("FMMS"))
			return loadFMMS();
		else if (kindof.equals("valoracionCuello"))
			return loadValoracionCuello();
		else if (kindof.equals("valoracionPostura"))
			return loadValoracionPostura();
		else if (kindof.equals("autoPercepcionSalud"))
			return loadAutoPercepcion();
		else if (kindof.equals("acondicionamiento"))
			return loadAcondicionamiento();
		else if (kindof.equals("situacionDuelo"))
			return loadSituacionDuelo();
		else if (kindof.equals("situacionTristeza"))
			return loadSituacionTristeza();
		else if (kindof.equals("apoyoFamiliar"))
			return loadApoyoFamiliar();
		else if (kindof.equals("grupoAmigos"))
			return loadGrupoAmigos();
		else if (kindof.equals("recuerdosRecientes"))
			return loadRecuerdosRecientes();
		else if (kindof.equals("recuerdosPasados"))
			return loadRecuerdosPasados();
		else if (kindof.equals("requiereApoyo"))
			return loadRequiereApoyo();
		else if (kindof.equals("abdominales"))
			return loadAbdominales();
		else if (kindof.equals("antecedentesClinicos"))
			return loadAntecedentesClinicos();
		else if (kindof.equals("autoPercepcionVida"))
			return loadAutopercepcionVida();
		else if (kindof.equals("estadoConsultoria"))
			return loadEstadoConsultoria();
		else if (kindof.equals("actividades"))
			return loadActividades();
		else if (kindof.equals("tipoSangre"))
			return loadTipoSangre();
		else if (kindof.equals("marcha"))
			return loadMarcha();
		else if (kindof.equals("flexibilidad"))
			return loadFlexibilidad();
		else if (kindof.equals("equilibrio"))
			return loadEquilibrio();
		else if (kindof.equals("nivelDependenciaVD"))
			return loadNivelDependenciaVD();
		else if (kindof.equals("ABVD"))
			return loadABVD();
		else if (kindof.equals("nivelAcondicionamiento"))
			return loadNivelAcondicionamiento();
		else if (kindof.equals("tipoEstadoAsociado"))
			return loadTiposEstadoAsociado();
		else
			return new java.util.ArrayList<SelectItem>();
	}

	private static List<SelectItem> loadNivelAcondicionamiento() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty(
									"tipo_nivelacondicionamiento"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadABVD() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_abvd"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadNivelDependenciaVD() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty(
									"tipo_niveldependencia_vd"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadEquilibrio() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_equilibrio"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadFlexibilidad() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_flexibilidad"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadMarcha() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_marcha"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadActividades() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			List<VepParametroActividad> rs = new VepParametroActividadDAO()
					.findByEstadopar("ACTIVO");
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepParametroActividad vepParametroActividad : rs) {
				items
						.add(new SelectItem(vepParametroActividad
								.getIdActividadpar(), vepParametroActividad
								.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadEstadoConsultoria() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance()
							.getProperty("tipo_estadoconsultoria"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadAutopercepcionVida() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty(
									"tipo_autopercepcionvida"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadAntecedentesClinicos() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty(
									"tipo_antecedentesclinicos"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadAbdominales() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_abdominales"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadRequiereApoyo() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_apoyorecuerdos"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadRecuerdosPasados() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_hechospasados"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadRecuerdosRecientes() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_hechosrecientes"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadGrupoAmigos() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_amigos"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadApoyoFamiliar() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_apoyofamiliar"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadSituacionTristeza() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_tristeza"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadSituacionDuelo() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_duelo"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadAcondicionamiento() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty(
									"tipo_acondicionamiento1"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadAutoPercepcion() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_autopercepcion"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadValoracionPostura() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_postura"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadValoracionCuello() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_cuello"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadFMMS() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_fmms"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadFMMI() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_fmmi"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadAIVD() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_aivd"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadAAVD() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_aavd"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadMAMI() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_mami"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadMAMS() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_mams"));
			items.add(new SelectItem(new Integer(-1), "-- Seleccione -- "));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadPatologias() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_patologias"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadMediosConocimiento() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			items.add(new SelectItem(new Integer("-1"), "-- Seleccione --"));
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty(
									"tipo_mediosconocimiento"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadAtencion() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			items.add(new SelectItem(new Integer("-1"), "-- Seleccione --"));
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_atencion"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadSiNo() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("-1", "-- Seleccione --"));
		items.add(new SelectItem("S", "SI"));
		items.add(new SelectItem("N", "NO"));
		return items;
	}

	private static List<SelectItem> loadEstados() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_estado"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadHobbies() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_hobbies"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadServicioMedico() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_serviciosmedicos"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadServiciosOfrecer() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_serviciosofrecer"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadConocimientos() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_conocimiento"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadAreasConocimientos() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		SIPParametrosLogica parametros = new SIPParametrosLogica();
		try {
			items.add(new SelectItem(new Integer("-1"), "-- Seleccione --"));
			List<VepSipParametro> lista = parametros
					.loadParameters(LocalApplicationConfiguration.Util
							.getInstance().getProperty("tipo_conocimiento"));
			for (VepSipParametro vepSipParametro : lista) {
				items.add(new SelectItem(vepSipParametro.getIdTipoClasif(),
						vepSipParametro.getNombre()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadPAM() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			RealizarConsultas rcons = new RealizarConsultas();
			List<VepSipParametro> lista = rcons
					.consultarParametrosVEP(new Integer(
							LocalApplicationConfiguration.Util.getInstance()
									.getProperty("tipo_pam")));
			if (!lista.isEmpty()) {
				for (int i = 0; i < lista.size(); i++) {
					items.add(new SelectItem(((VepSipParametro) lista.get(i))
							.getIdTipoClasif(),
							((VepSipParametro) lista.get(i)).getIdTipoClasif()
									+ "-"
									+ ((VepSipParametro) lista.get(i))
											.getNombre()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadTiposIdentificacion() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			DelegadoWsParametrosServiceLocator locator = new DelegadoWsParametrosServiceLocator();
			DelegadoWsParametros service = locator.getconsultarParametros();
			ParametrosWS rs = service.consultarParametrosXTipo(new Long(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tipo_tipoidentificacion")));
			Parametros[] rsarray = rs.getArrayParametros();
			items.add(new SelectItem(new Long(-1), "-- Seleccione --"));
			for (Parametros parametros : rsarray) {
				items.add(new SelectItem(new Long(parametros.getCodigoParam()),
						parametros.getDescripcionParam()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadGenero() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			DelegadoWsParametrosServiceLocator locator = new DelegadoWsParametrosServiceLocator();
			DelegadoWsParametros service = locator.getconsultarParametros();
			ParametrosWS rs = service.consultarParametrosXTipo(new Long(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tipo_genero")));
			Parametros[] rsarray = rs.getArrayParametros();
			items.add(new SelectItem(new Long(-1), "-- Seleccione --"));
			for (Parametros parametros : rsarray) {
				items.add(new SelectItem(new Long(parametros.getCodigoParam()),
						parametros.getDescripcionParam()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadTipoSangre() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("-1", "-- Seleccione --"));
		items.add(new SelectItem("A+", "A+"));
		items.add(new SelectItem("A-", "A-"));
		items.add(new SelectItem("AB+", "AB+"));
		items.add(new SelectItem("AB-", "AB-"));
		items.add(new SelectItem("B-", "B-"));
		items.add(new SelectItem("B+", "B+"));
		items.add(new SelectItem("O+", "O+"));
		items.add(new SelectItem("O-", "O-"));
		return items;
	}

	private static List<SelectItem> loadRegionales() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		RegionalLogica regional = new RegionalLogica();
		try {
			List<Parametros> rs = regional.obtenerTodasAsParametro();
			items.add(new SelectItem(new Long(-1), "Todas"));
			for (Parametros param : rs) {
				items.add(new SelectItem(param.getCodigoParam(), param
						.getDescripcionParam()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadRegionalesUsuario() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		RegionalLogica regional = new RegionalLogica();
		try {
			List<Parametros> rs = regional.obtenerTodasAsParametro();
			items.add(new SelectItem(new Long(-1), "-- Seleccione --"));
			for (Parametros param : rs) {
				items.add(new SelectItem(param.getCodigoParam(), param
						.getDescripcionParam()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadPaises() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		RealizarConsultas rcons = new RealizarConsultas();
		try {
			Pais[] mispar = rcons.mostrarPaises();
			if (mispar != null) {
				items.add(new SelectItem("-1", "-- Seleccione --"));
				for (int i = 0; i < mispar.length; i++) {
					items.add(new SelectItem(mispar[i].getCodigoPais(),
							mispar[i].getCodigoPais().trim() + "-"
									+ mispar[i].getNombrePais()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadOcupacion() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		RealizarConsultas rcons = new RealizarConsultas();
		try {
			Parametros[] mispar = rcons.mostrarParametrosBUCXTipo(new Long(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tipo_ocupacion")));
			if (mispar != null) {
				items.add(new SelectItem(new Long(-1), "-- Seleccione --"));
				for (int i = 0; i < mispar.length; i++) {
					items.add(new SelectItem(mispar[i].getCodigoParam(),
						/*	mispar[i].getCodigoParam() + "-"
									+ */mispar[i].getDescripcionParam()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadCorte() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			RealizarConsultas rcons = new RealizarConsultas();
			Parametros[] mispar = rcons.mostrarParametrosBUCXTipo(new Long(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tipo_corte")));
			if (mispar != null) {
				items.add(new SelectItem(new Long(-1), "-- Seleccione --"));
				for (int i = 0; i < mispar.length; i++) {
					items.add(new SelectItem(mispar[i].getCodigoParam(),
							mispar[i].getCodigoParam() + "-"
									+ mispar[i].getDescripcionParam()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadEstadoCivil() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			RealizarConsultas rcons = new RealizarConsultas();
			Parametros[] mispar = rcons.mostrarParametrosBUCXTipo(new Long(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tipo_estadocivil")));
			if (mispar != null) {
				items.add(new SelectItem(new Long(-1), "-- Seleccione --"));
				for (int i = 0; i < mispar.length; i++) {
					items.add(new SelectItem(mispar[i].getCodigoParam(),
							mispar[i].getCodigoParam() + "-"
									+ mispar[i].getDescripcionParam()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadTituloProfesional() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			RealizarConsultas rcons = new RealizarConsultas();
			Parametros[] mispar = rcons.mostrarParametrosBUCXTipo(new Long(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tipo_tituloprofesional")));
			if (mispar != null) {
				items.add(new SelectItem(new Long(-1), "-- Seleccione --"));
				for (int i = 0; i < mispar.length; i++) {
					items.add(new SelectItem(mispar[i].getCodigoParam(),
						/*	mispar[i].getCodigoParam() + "-"
									+ */mispar[i].getDescripcionParam()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private static List<SelectItem> loadTipoAsociado() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			RealizarConsultas rcons = new RealizarConsultas();
			List<VepSipParametro> lista = rcons
					.consultarParametrosVEP(new Integer(
							LocalApplicationConfiguration.Util.getInstance()
									.getProperty("tipo_tipoasociado")));
			if (!lista.isEmpty()) {
				items.add(new SelectItem(new Long(-1), "-- Seleccione --"));
				for (int i = 0; i < lista.size(); i++) {
					items.add(new SelectItem(new Long(((VepSipParametro) lista
							.get(i)).getIdTipoClasif()),
							((VepSipParametro) lista.get(i)).getIdTipoClasif()
									+ "-"
									+ ((VepSipParametro) lista.get(i))
											.getNombre()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
	
	private static List<SelectItem> loadTiposEstadoAsociado() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			DelegadoWsParametrosServiceLocator locator = new DelegadoWsParametrosServiceLocator();
			DelegadoWsParametros service = locator.getconsultarParametros();
			ParametrosWS rs = service.consultarParametrosXTipo(new Long(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tipo_estado_asociado")));
			Parametros[] rsarray = rs.getArrayParametros();
			items.add(new SelectItem(new Long(-1), "-- Seleccione --"));
			for (Parametros parametros : rsarray) {
				items.add(new SelectItem(new Long(parametros.getCodigoParam()),
						parametros.getDescripcionParam()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
}
