/**
 * 
 */
package co.com.vep.vista;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import co.com.vep.logica.AsociadoLogica;
import co.com.vep.logica.IRealizarValoracion;
import co.com.vep.logica.RealizarValoracion;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.validadorNumerico;
import co.com.vep.util.validadorReales;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;

public class VistaValoracion extends VistaAgregarAsociado {

	private String mensajesup;
	private String mensajeinf;

	private Integer aavd;
	private Integer aivd;
	private Integer abvd;
	private Integer nivelDependenciaVD;
	private Integer marcha;
	private Integer equilibrio;
	private Integer flexibilidad;
	private Integer proyectoVida;

	// Atributos propios de la tabla Valoracion
	private Date fecha_actual;
	private String estatura;
	private Double peso;
	private Long presionDiastole;
	private Long presionSistole;
	private String toma_med;
	private String med;
	private Long fcm;
	private String reforzar_en;
	private String plan_seg;
	private String imc;
	private String per_cintura;
	private String cv_event_sig;
	private String cv_camb_signif;
	private String cv_marc_des;

	// Antecedentes Clinicos
	private String aclin_otros;
	private HtmlInputTextarea txt_aclin_otros;

	// Proyecto de Vida, como ve su vida en estos momentos
	private String pv_obs;
	private HtmlInputTextarea txt_pv_obs;

	// Auto Percepcion de Salud 10
	private Integer autopercepcion;

	// Actividades de la Vida Diaria AAVD 11 AIVD 13
	private String obs_vd;

	// Acondicionamiento Fisico 14 15 16
	private Integer aconfis_1;

	// Fuerza muscular miembros superiores 21
	private Integer fmms;

	// Fuerza muscular miembros inferiores 22
	private Integer fmmi;

	// Abdominales 23
	private Integer abdom;

	// Movilidad Artcular MAMS 24 MAMI 25 CUELLO 26 POSTURA 27
	private Integer mams;
	private Integer mami;
	private Integer cuello;
	private Integer postura;
	private String ma_obs;

	// Acompañamiento DUELO 29 TRISTEZA 30 APOYO FAMILIAR 31 GRUPO AMIGOS 32
	private Integer duelo;
	private Integer tristeza;
	private Integer apoyofam;
	private Integer amigos;

	// En Relacion con su memoria HECHOS RECIENTES 33 HECHOS PASADOS 34 APOYO 35
	private Integer recuerdapre;
	private Integer recuerdapas;
	private Integer apoyomem;

	private Integer[] selectedAntecedenteClinico;

	private HtmlInputText txtEstatura;
	private HtmlInputText txtPer_cintura;

	private boolean renderInfo = false;

	public VistaValoracion() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("IngresarValoracion")) {
				initializeComponent();
			}
		}
	}

	private void initializeComponent() {
		fecha_actual = new GregorianCalendar().getTime();
		renderInfo = false;
		txtEstatura = new HtmlInputText();
		txtEstatura.addValidator(new validadorReales(MessageBundleLoader
				.getMessage("labels.sg.estatura"), true));
		txtEstatura.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtEstatura.validate(FacesContext.getCurrentInstance());
			}
		});

		txtPer_cintura = new HtmlInputText();
		txtPer_cintura.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.seg.percin"), true));
		txtPer_cintura.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtPer_cintura.validate(FacesContext.getCurrentInstance());
			}
		});
		// txt_aclin_otros.setRendered(false);
		// txt_aclin_otros.setVisible(false);
	}

	public HtmlInputTextarea getTxt_aclin_otros() {
		return txt_aclin_otros;
	}

	public void setTxt_aclin_otros(HtmlInputTextarea txt_aclin_otros) {
		this.txt_aclin_otros = txt_aclin_otros;
	}

	public String getpv_obs() {
		return pv_obs;
	}

	public void setpv_obs(String pv_obs) {
		this.pv_obs = pv_obs;
	}

	public HtmlInputTextarea getTxt_pv_obs() {
		return txt_pv_obs;
	}

	public void setTxt_pv_obs(HtmlInputTextarea txt_pv_obs) {
		this.txt_pv_obs = txt_pv_obs;
	}

	public void action_generarConsultaAsociadoVEP(ActionEvent event) {
		try {
			renderInfo = false;
			if (tipoid.equals(new Long("-1")))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err16"));

			if (cedula == null || cedula.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err17"));

			AsociadoLogica logica = new AsociadoLogica();
			VepAsociado rs = logica.obtener(tipoid, new Long(cedula));
			if (rs == null || rs.getIdAsociado() == null)
				throw new Exception("Registro inconsistente");

			llenarCamposAsociado(rs);

		} catch (Exception e) {
			showException(e);
		}
	}

	public void llenarCamposAsociado(VepAsociado asociado) throws Exception {
		renderInfo = true;
		try {
			mostrarRegistro(asociado);
			habilitarInput(true);
		} catch (Exception err) {
			showException(err);
		}
	}

	private void vaciarCamposYSelecciones() {
		estatura = null;
		peso = null;
		presionDiastole = null;
		presionSistole = null;
		toma_med = "N";
		med = null;
		fcm = null;
		reforzar_en = null;
		plan_seg = null;
		imc = null;
		per_cintura = null;
		cv_event_sig = null;
		cv_camb_signif = null;
		cv_marc_des = null;

		visibleMedicamentos = false;
		renderedMedicamentos = false;
		// Antecedentes Clinicos
		aclin_otros = null;

		// Proyecto de Vida, como ve su vida en estos momentos
		pv_obs = null;

		// Auto Percepcion de Salud 10
		autopercepcion = -1;

		// Actividades de la Vida Diaria AAVD 11 AIVD 13
		obs_vd = null;

		// Acondicionamiento Fisico 14 15 16
		aconfis_1 = -1;

		// Fuerza muscular miembros superiores 21
		fmms = -1;

		// Fuerza muscular miembros inferiores 22
		fmmi = -1;

		// Abdominales 23
		abdom = -1;

		// toma algun medicamento
		toma_med = "-1";

		// Movilidad Artcular MAMS 24 MAMI 25 CUELLO 26 POSTURA 27
		mams = -1;
		mami = -1;
		cuello = -1;
		postura = -1;
		ma_obs = null;

		// Acompañamiento DUELO 29 TRISTEZA 30 APOYO FAMILIAR 31 GRUPO AMIGOS 32
		duelo = -1;
		tristeza = -1;
		apoyofam = -1;
		amigos = -1;

		// En Relacion con su memoria HECHOS RECIENTES 33 HECHOS PASADOS 34
		// APOYO 35
		recuerdapre = -1;
		recuerdapas = -1;
		apoyomem = -1;

		selectedAntecedenteClinico = new Integer[] {};

		//Actividades
		aavd = -1;
		aivd = -1;
		marcha = -1;
		flexibilidad = -1;
		equilibrio = -1;
		nivelDependenciaVD = -1;
		abvd = -1;
		
		proyectoVida = -1;

	}

	public void action_generarValoracion(ActionEvent ae) {
		IRealizarValoracion rval = new RealizarValoracion();
		try {
			if (estatura == null || estatura.equals(""))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.valoracion.excepcion19"));

			if (peso == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.valoracion.excepcion20"));

			if (presionDiastole == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.valoracion.excepcion21"));

			if (presionSistole == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.valoracion.excepcion21"));

			System.out.println("Toma med: " + toma_med + " - " + med);
			if (toma_med != null && !toma_med.equals("-1")) {
				if (toma_med.equals("S")
						&& (med == null || med.trim().length() == 0))
					throw new Exception(MessageBundleLoader
							.getMessage("labels.valoracion.excepcion28"));
			} else if (toma_med != null && toma_med.equals("-1"))
				toma_med = null;

			if (autopercepcion != null && autopercepcion.equals(-1))
				autopercepcion = null;

			// if (autopercepcion == null || autopercepcion.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion1"));

			if (aavd != null && aavd.equals(-1))
				aavd = null;

			// if (aavd == null || aavd.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion2")
			// + " AAVD");

			if (abvd != null && abvd.equals(-1))
				abvd = null;

			// if (abvd == null || abvd.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion2")
			// + " ABVD");

			if (aivd != null && aivd.equals(-1))
				aivd = null;

			// if (aivd == null || aivd.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion2")
			// + " AIVD");

			if (nivelDependenciaVD != null && nivelDependenciaVD.equals(-1))
				nivelDependenciaVD = null;

			// if (nivelDependenciaVD == null || nivelDependenciaVD.equals(-1))
			// throw new Exception(
			// "Debe especificar el Nivel de dependencia actividades diarias");

			if (marcha != null && marcha.equals(-1))
				marcha = null;

			// if (marcha == null || marcha.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion3" + " MARCHA"));

			if (equilibrio != null && equilibrio.equals(-1))
				equilibrio = null;

			// if (equilibrio == null || equilibrio.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion3"
			// + " EQUILIBRIO"));

			if (flexibilidad != null && flexibilidad.equals(-1))
				flexibilidad = null;

			// if (flexibilidad == null || flexibilidad.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion3"
			// + " FLEXIBILIDAD"));

			if (aconfis_1 != null && aconfis_1.equals(-1))
				aconfis_1 = null;

			// if (aconfis_1 == null || aconfis_1.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion3"));

			// if (fcm == null)
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion22"));

			if (fmms != null && fmms.equals(-1))
				fmms = null;

			// if (fmms == null || fmms.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion5"));

			if (fmmi != null && fmmi.equals(-1))
				fmmi = null;

			// if (fmmi == null || fmmi.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion6"));

			if (abdom != null && abdom.equals(-1))
				abdom = null;

			// if (abdom == null || abdom.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion7"));

			if (mams != null && mams.equals(-1))
				mams = null;

			// if (mams == null || mams.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion8"));

			if (mami != null && mami.equals(-1))
				mami = null;

			// if (mami == null || mami.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion9"));

			if (cuello != null && cuello.equals(-1))
				cuello = null;

			// if (cuello == null || cuello.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion10"));

			if (postura != null && postura.equals(-1))
				postura = null;

			// if (postura == null || postura.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion11"));

			if (reforzar_en == null || reforzar_en.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.valoracion.excepcion25"));

			if (plan_seg == null || plan_seg.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.valoracion.excepcion26"));

			if (imc == null || imc.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.valoracion.excepcion24"));

			if (per_cintura == null || per_cintura.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.valoracion.excepcion23"));

			if (pv_obs == null || pv_obs.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.valoracion.excepcion27"));

			if (duelo != null && duelo.equals(-1))
				duelo = null;

			// if (duelo == null || duelo.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion12"));

			if (tristeza != null && tristeza.equals(-1))
				tristeza = null;

			// if (tristeza == null || tristeza.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion13"));

			if (apoyofam != null && apoyofam.equals(-1))
				apoyofam = null;

			// if (apoyofam == null || apoyofam.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion14"));

			if (amigos != null && amigos.equals(-1))
				amigos = null;

			// if (amigos == null || amigos.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion15"));

			if (recuerdapre != null && recuerdapre.equals(-1))
				recuerdapre = null;

			// if (recuerdapre == null || recuerdapre.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion16"));

			if (recuerdapas != null && recuerdapas.equals(-1))
				recuerdapas = null;

			// if (recuerdapas == null || recuerdapas.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion17"));

			if (apoyomem != null && apoyomem.equals(-1))
				apoyomem = null;

			// if (apoyomem == null || apoyomem.equals(-1))
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.valoracion.excepcion18"));
			if (per_cintura == null || per_cintura.equals(""))
				per_cintura = "0";

			rval.guardarValoracion(tipoid, cedula, fecha_actual, Double
					.valueOf(estatura), peso, presionDiastole, presionSistole,
					selectedAntecedenteClinico, toma_med, med, autopercepcion,
					aavd, abvd, aivd, nivelDependenciaVD, marcha, flexibilidad,
					equilibrio, aconfis_1, fcm, fmms, fmmi, abdom, mams, mami,
					cuello, postura, reforzar_en, plan_seg, imc, Long
							.valueOf(per_cintura), cv_event_sig,
					cv_camb_signif, cv_marc_des, proyectoVida, obs_vd, duelo,
					tristeza, apoyofam, amigos, recuerdapre, recuerdapas,
					apoyomem, pv_obs);

			mensajeinf = MessageBundleLoader
					.getMessage("labels.valoracion.mensajeok");
			mensajesup = "";
			this.vaciarCamposAsociado();
			this.vaciarCamposYSelecciones();

		} catch (Exception err) {
			showException(err);
		}

	}

	public void vaciarCamposAsociado() {
		renderInfo = false;
		limpiar();
	}

	public String getMensajesup() {
		return mensajesup;
	}

	public void setMensajesup(String mensajesup) {
		this.mensajesup = mensajesup;
	}

	public Date getFecha_actual() {
		return fecha_actual;
	}

	public void setFecha_actual(Date fecha_actual) {
		this.fecha_actual = fecha_actual;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getToma_med() {
		return toma_med;
	}

	public void setToma_med(String toma_med) {
		this.toma_med = toma_med;
	}

	public String getMed() {
		return med;
	}

	public void setMed(String med) {
		this.med = med;
	}

	public Long getFcm() {
		return fcm;
	}

	public void setFcm(Long fcm) {
		this.fcm = fcm;
	}

	public String getReforzar_en() {
		return reforzar_en;
	}

	public void setReforzar_en(String reforzar_en) {
		this.reforzar_en = reforzar_en;
	}

	public String getPlan_seg() {
		return plan_seg;
	}

	public void setPlan_seg(String plan_seg) {
		this.plan_seg = plan_seg;
	}

	public String getImc() {
		return imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}

	public String getPer_cintura() {
		return per_cintura;
	}

	public void setPer_cintura(String per_cintura) {
		this.per_cintura = per_cintura;
	}

	public String getCv_event_sig() {
		return cv_event_sig;
	}

	public void setCv_event_sig(String cv_event_sig) {
		this.cv_event_sig = cv_event_sig;
	}

	public String getCv_camb_signif() {
		return cv_camb_signif;
	}

	public void setCv_camb_signif(String cv_camb_signif) {
		this.cv_camb_signif = cv_camb_signif;
	}

	public String getCv_marc_des() {
		return cv_marc_des;
	}

	public void setCv_marc_des(String cv_marc_des) {
		this.cv_marc_des = cv_marc_des;
	}

	public String getMensajeinf() {
		return mensajeinf;
	}

	public void setMensajeinf(String mensajeinf) {
		this.mensajeinf = mensajeinf;
	}

	public String getAclin_otros() {
		return aclin_otros;
	}

	public void setAclin_otros(String aclin_otros) {
		this.aclin_otros = aclin_otros;
	}

	public Integer getAutopercepcion() {
		return autopercepcion;
	}

	public void setAutopercepcion(Integer autopercepcion) {
		this.autopercepcion = autopercepcion;
	}

	public String getObs_vd() {
		return obs_vd;
	}

	public void setObs_vd(String obs_vd) {
		this.obs_vd = obs_vd;
	}

	public Integer getAconfis_1() {
		return aconfis_1;
	}

	public void setAconfis_1(Integer aconfis_1) {
		this.aconfis_1 = aconfis_1;
	}

	public Integer getFmms() {
		return fmms;
	}

	public void setFmms(Integer fmms) {
		this.fmms = fmms;
	}

	public Integer getFmmi() {
		return fmmi;
	}

	public void setFmmi(Integer fmmi) {
		this.fmmi = fmmi;
	}

	public Integer getAbdom() {
		return abdom;
	}

	public void setAbdom(Integer abdom) {
		this.abdom = abdom;
	}

	public String getPv_obs() {
		return pv_obs;
	}

	public void setPv_obs(String pv_obs) {
		this.pv_obs = pv_obs;
	}

	public Integer getMams() {
		return mams;
	}

	public void setMams(Integer mams) {
		this.mams = mams;
	}

	public Integer getMami() {
		return mami;
	}

	public void setMami(Integer mami) {
		this.mami = mami;
	}

	public Integer getCuello() {
		return cuello;
	}

	public void setCuello(Integer cuello) {
		this.cuello = cuello;
	}

	public Integer getPostura() {
		return postura;
	}

	public void setPostura(Integer postura) {
		this.postura = postura;
	}

	public String getMa_obs() {
		return ma_obs;
	}

	public void setMa_obs(String ma_obs) {
		this.ma_obs = ma_obs;
	}

	public Integer getDuelo() {
		return duelo;
	}

	public void setDuelo(Integer duelo) {
		this.duelo = duelo;
	}

	public Integer getTristeza() {
		return tristeza;
	}

	public void setTristeza(Integer tristeza) {
		this.tristeza = tristeza;
	}

	public Integer getApoyofam() {
		return apoyofam;
	}

	public void setApoyofam(Integer apoyofam) {
		this.apoyofam = apoyofam;
	}

	public Integer getAmigos() {
		return amigos;
	}

	public void setAmigos(Integer amigos) {
		this.amigos = amigos;
	}

	public Integer getRecuerdapre() {
		return recuerdapre;
	}

	public void setRecuerdapre(Integer recuerdapre) {
		this.recuerdapre = recuerdapre;
	}

	public Integer getRecuerdapas() {
		return recuerdapas;
	}

	public void setRecuerdapas(Integer recuerdapas) {
		this.recuerdapas = recuerdapas;
	}

	public Integer getApoyomem() {
		return apoyomem;
	}

	public void setApoyomem(Integer apoyomem) {
		this.apoyomem = apoyomem;
	}

	public void showException(Exception ex) {
		showException(ex.getMessage());
		ex.printStackTrace();
	}

	public void showException(String ex) {
		FacesMessage msg = new FacesMessage(ex);
		FacesContext.getCurrentInstance().addMessage("msg", msg);
	}

	public Integer[] getSelectedAntecedenteClinico() {
		return selectedAntecedenteClinico;
	}

	public void setSelectedAntecedenteClinico(
			Integer[] selectedAntecedenteClinico) {
		this.selectedAntecedenteClinico = selectedAntecedenteClinico;
	}

	private boolean visibleMedicamentos = false;
	private boolean renderedMedicamentos = false;
	private boolean visibleLabel = true;
	private boolean renderedLabel = true;
	private boolean visibleOtraPatologia = false;

	public void onSelectTomaMedicamentos(ValueChangeEvent event) {
		toma_med = event.getNewValue().toString();
		visibleMedicamentos = false;
		if (toma_med != null && toma_med.equals("S")) {
			visibleMedicamentos = true;
			renderedMedicamentos = true;
			visibleLabel = false;
			renderedLabel = false;
		} else {
			visibleMedicamentos = false;
			renderedMedicamentos = false;
			visibleLabel = true;
			renderedLabel = true;
		}
	}

	public void onSelectAntecedenteClinico(ValueChangeEvent event) {
		selectedAntecedenteClinico = (Integer[]) event.getNewValue();
		visibleOtraPatologia = false;
		for (Integer item : selectedAntecedenteClinico) {
			if (item.toString().equals(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("otro_antecedenteclinico"))) {
				txt_aclin_otros.setVisible(true);
				txt_aclin_otros.setRendered(true);
			} else {
				txt_aclin_otros.setVisible(false);
				txt_aclin_otros.setRendered(false);
			}
		}
	}

	public boolean isVisibleMedicamentos() {
		return visibleMedicamentos;
	}

	public void setVisibleMedicamentos(boolean visibleMedicamentos) {
		this.visibleMedicamentos = visibleMedicamentos;
	}

	public boolean isVisibleOtraPatologia() {
		return visibleOtraPatologia;
	}

	public void setVisibleOtraPatologia(boolean visibleOtraPatologia) {
		this.visibleOtraPatologia = visibleOtraPatologia;
	}

	public boolean isRenderInfo() {
		return renderInfo;
	}

	public void setRenderInfo(boolean renderInfo) {
		this.renderInfo = renderInfo;
	}

	public Long getPresionDiastole() {
		return presionDiastole;
	}

	public void setPresionDiastole(Long presionDiastole) {
		this.presionDiastole = presionDiastole;
	}

	public Long getPresionSistole() {
		return presionSistole;
	}

	public void setPresionSistole(Long presionSistole) {
		this.presionSistole = presionSistole;
	}

	public Integer getAavd() {
		return aavd;
	}

	public void setAavd(Integer aavd) {
		this.aavd = aavd;
	}

	public Integer getAivd() {
		return aivd;
	}

	public void setAivd(Integer aivd) {
		this.aivd = aivd;
	}

	public Integer getAbvd() {
		return abvd;
	}

	public void setAbvd(Integer abvd) {
		this.abvd = abvd;
	}

	public Integer getNivelDependenciaVD() {
		return nivelDependenciaVD;
	}

	public void setNivelDependenciaVD(Integer nivelDependenciaVD) {
		this.nivelDependenciaVD = nivelDependenciaVD;
	}

	public Integer getMarcha() {
		return marcha;
	}

	public void setMarcha(Integer marcha) {
		this.marcha = marcha;
	}

	public Integer getEquilibrio() {
		return equilibrio;
	}

	public void setEquilibrio(Integer equilibrio) {
		this.equilibrio = equilibrio;
	}

	public Integer getFlexibilidad() {
		return flexibilidad;
	}

	public void setFlexibilidad(Integer flexibilidad) {
		this.flexibilidad = flexibilidad;
	}

	public Integer getProyectoVida() {
		return proyectoVida;
	}

	public void setProyectoVida(Integer proyectoVida) {
		this.proyectoVida = proyectoVida;
	}

	public boolean isRenderedMedicamentos() {
		return renderedMedicamentos;
	}

	public void setRenderedMedicamentos(boolean renderedMedicamentos) {
		this.renderedMedicamentos = renderedMedicamentos;
	}

	public boolean isVisibleLabel() {
		return visibleLabel;
	}

	public void setVisibleLabel(boolean visibleLabel) {
		this.visibleLabel = visibleLabel;
	}

	public boolean isRenderedLabel() {
		return renderedLabel;
	}

	public void setRenderedLabel(boolean renderedLabel) {
		this.renderedLabel = renderedLabel;
	}

	public HtmlInputText getTxtEstatura() {
		return txtEstatura;
	}

	public void setTxtEstatura(HtmlInputText txtEstatura) {
		this.txtEstatura = txtEstatura;
	}

	public HtmlInputText getTxtPer_cintura() {
		return txtPer_cintura;
	}

	public void setTxtPer_cintura(HtmlInputText txtPer_cintura) {
		this.txtPer_cintura = txtPer_cintura;
	}

}
